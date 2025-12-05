package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.entity.ai.pig.TruffleDiggingGoal;
import net.mehdinoui.fungidelight.common.entity.ai.wolf.DogTruffleHuntGoal;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.mehdinoui.fungidelight.common.registry.ModSoundEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModEntitiesEvents {
    public static final String HUNTING_TAG = "fungidelight.dog_hunting_timer";
    public static final int HUNT_DURATION = 20 * 60 * 2;
    @SubscribeEvent
    public static void onDogInteract(PlayerInteractEvent.EntityInteract event) {
        if (!Configuration.ENABLE_WOLF_HUNT_TRUFFLE.get()) return;
        if (event.getTarget() instanceof Wolf wolf && wolf.isTame()) {
            ItemStack itemStack = event.getItemStack();
            if (itemStack.is(ModItems.TRUFFLE.get())) {
                if (!event.getLevel().isClientSide) {
                    long endTime = event.getLevel().getGameTime() + HUNT_DURATION;
                    wolf.getPersistentData().putLong(HUNTING_TAG, endTime);
                    wolf.playSound(ModSoundEvents.DOG_SNIFF_TRUFFLE.get());
                }
                // Successful Interaction Particles
                if (event.getLevel().isClientSide) {
                    for(int i = 0; i < 7; ++i) {
                        double d0 = event.getLevel().random.nextGaussian() * 0.02D;
                        double d1 = event.getLevel().random.nextGaussian() * 0.02D;
                        double d2 = event.getLevel().random.nextGaussian() * 0.02D;
                        event.getLevel().addParticle(ParticleTypes.HAPPY_VILLAGER,
                                wolf.getRandomX(1.0D), wolf.getRandomY() + 0.5D, wolf.getRandomZ(1.0D), d0, d1, d2);
                    }
                }
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true); // Prevent default interaction (like opening GUI)
            }
        }
    }

    @SubscribeEvent
    public static void onPigInteract(PlayerInteractEvent.EntityInteract event) {
        if (!Configuration.ENABLE_PIG_FOODS.get()) return;
        if (!Configuration.ENABLE_PIG_EXTRA_BABY.get()) return;
        if (event.getTarget() instanceof Pig pig && pig.isFood(event.getItemStack())) {
            if (event.getItemStack().is(ModItems.TRUFFLE.get())) {
                if (pig.getAge() == 0 && !pig.isInLove()) {
                    pig.getPersistentData().putBoolean("FD_TruffleBred", true);
                    if (!event.getLevel().isClientSide) {
                        pig.setInLove(event.getEntity());
                        if (!event.getEntity().getAbilities().instabuild) {
                            event.getItemStack().shrink(1);
                        }
                    }
                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true); // Prevent default interaction (like opening GUI)
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBabySpawn(BabyEntitySpawnEvent event) {
        if (!Configuration.ENABLE_PIG_FOODS.get()) return;
        if (!Configuration.ENABLE_PIG_EXTRA_BABY.get()) return;
        Level level = event.getParentA().level();
        if (!(event.getParentA() instanceof Pig parentA)
                || !(event.getParentB() instanceof Pig parentB)) {
            return;
        }

        CompoundTag dataA = parentA.getPersistentData();
        CompoundTag dataB = parentB.getPersistentData();

        if (dataA.getBoolean("FD_TruffleBred") || dataB.getBoolean("FD_TruffleBred")) {
            if (level instanceof ServerLevel serverLevel) {
                float roll = parentA.getRandom().nextFloat();
                int extrasToSpawn = 0;

                if (roll < 0.1f) extrasToSpawn = 2;
                else if (roll < 0.5f) extrasToSpawn = 1;

                if (extrasToSpawn > 0) {
                    for (int i = 0; i < extrasToSpawn; i++) {
                        Pig extraBaby = (Pig) parentA.getBreedOffspring(serverLevel, parentB);
                        if (extraBaby != null) {
                            extraBaby.setBaby(true);
                            extraBaby.moveTo(parentA.getX(), parentA.getY(), parentA.getZ(), 0.0F, 0.0F);
                            serverLevel.addFreshEntity(extraBaby);
                        }
                    }
                }
            }
            dataA.remove("FD_TruffleBred");
            dataB.remove("FD_TruffleBred");
        }
    }

    @SubscribeEvent
    public static void addCustomGoals(EntityJoinLevelEvent event) {
        // --- PIG LOGIC ---
        if (Configuration.ENABLE_PIG_DIGGING.get()) {
            if (event.getEntity() instanceof Pig pig) {
                if (pig.goalSelector.getAvailableGoals().stream().anyMatch(
                        wrappedGoal -> wrappedGoal.getGoal() instanceof TruffleDiggingGoal)) {
                    return;
                }
                pig.goalSelector.addGoal(5, new TruffleDiggingGoal(pig));
            }
        }
        // --- WOLF LOGIC ---
        if (Configuration.ENABLE_WOLF_HUNT_TRUFFLE.get()) {
            if (event.getEntity() instanceof Wolf wolf) {
                if (wolf.goalSelector.getAvailableGoals().stream().anyMatch(
                        wrappedGoal -> wrappedGoal.getGoal() instanceof DogTruffleHuntGoal)) {
                    return;
                }
                wolf.goalSelector.addGoal(6, new DogTruffleHuntGoal(wolf));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (Configuration.ENABLE_WOLF_HUNT_TRUFFLE.get()) {
            if (!event.getEntity().level().isClientSide && event.getEntity() instanceof Wolf wolf) {
                // Check for Hunting Tag
                if (wolf.getPersistentData().contains(ModEntitiesEvents.HUNTING_TAG)) {
                    long endTime = wolf.getPersistentData().getLong(ModEntitiesEvents.HUNTING_TAG);
                    // Particles Indicator that the dog is in truffle hunting mode
                    if (wolf.level().getGameTime() < endTime) {
                        ServerLevel serverLevel = (ServerLevel) wolf.level();
                        if (wolf.tickCount % 4 == 0) {
                            serverLevel.sendParticles(ParticleTypes.MYCELIUM,
                                    wolf.getX(), wolf.getY() + 0.5, wolf.getZ(),
                                    3,
                                    0.3, 0.3, 0.3,
                                    0.05
                            );
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (!Configuration.ENABLE_SNIFFER_TRUFFLE.get()) return;
        if (event.getName().equals(BuiltInLootTables.SNIFFER_DIGGING)) {
            event.getTable().addPool(
                    LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(ModItems.TRUFFLE.get()))
                            .when(LootItemRandomChanceCondition.randomChance(0.05f))
                            .build()
            );
        }
    }
}