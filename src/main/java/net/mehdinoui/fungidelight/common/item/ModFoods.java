package net.mehdinoui.fungidelight.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.BRIEF_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.MEDIUM_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.LONG_DURATION;

public class ModFoods {
    // BASIC INGREDIENTS & COMPONENTS
    public static final FoodProperties CLEANED_CAPS = new FoodProperties.Builder().
            nutrition(4).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(net.mehdinoui.fungidelight.common.registry.ModEffects.WEAK_STOMACH.get(),BRIEF_DURATION , 0), 1.0F)
            .build();
    public static final FoodProperties TRUFFLE = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(net.mehdinoui.fungidelight.common.registry.ModEffects.WEAK_STOMACH.get(),BRIEF_DURATION , 0), 1.0F)
            .build();
    public static final FoodProperties TRUFFLE_SLICE = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.2f).build();

    // SALADS
    public static final FoodProperties INKY_CAPS_SALAD = new FoodProperties.Builder().
            nutrition(8).saturationMod(076f)
            .effect(() -> new MobEffectInstance(net.mehdinoui.fungidelight.common.registry.ModEffects.WEAK_STOMACH.get(),BRIEF_DURATION , 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK,BRIEF_DURATION , 0), 1.0F).build();

    // SNACKS & BAKED GOODS
    public static final FoodProperties COOKED_CLEANED_CAPS = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6f).build();

    // SOUPS & BOWLED MEALS
    public static final FoodProperties CREAMY_MOREL_SOUP = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties TRUFFLE_ICE_CREAM = new FoodProperties.Builder().
            nutrition(7).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED,200 , 0), 1.0F).build();


    // PLATED MEALS
    public static final FoodProperties INKY_CAP_SCRAMBLED_EGGS = new FoodProperties.Builder(). // Note: DANDELION_AND_EGGS in output.accept.
            nutrition(10).saturationMod(0.9f)
            .effect(() -> new MobEffectInstance(net.mehdinoui.fungidelight.common.registry.ModEffects.WEAK_STOMACH.get(),MEDIUM_DURATION , 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties TRUFFLE_PASTA = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties STUFFED_MORELS = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties STEAK_WITH_MUSHROOMS = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties MUTTON_CHOPS_WITH_TRUFFLE = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75f)
            .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION,0),1.0f)
            .build();
    public static final FoodProperties RABBIT_WITH_MORELS = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75f)
            .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION,0),1.0f)
            .build();
    public static final FoodProperties PORK_MARSALA_WITH_MUSHROOMS = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75f)
            .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION,0),1.0f)
            .build();

}