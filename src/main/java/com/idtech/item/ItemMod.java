package com.idtech.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", CreativeModeTab.TAB_MISC);
    public static final Item AMOG_US = ItemUtils.buildBasicItem("amogus", CreativeModeTab.TAB_MISC);

    //FOODS
    public static FoodProperties yummyFood = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f).effect(
            new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 1), 1.0f).alwaysEat().build());
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("yummyfood", yummyFood);

    public static FoodProperties yuckyFood = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f).effect(
            new MobEffectInstance(MobEffects.GLOWING, 500, 1), 1.0f).alwaysEat().build());
    public static Item yuckyFoodItem = ItemUtils.buildFoodItem("yuckyfood", yuckyFood);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(AMOG_US);
        // ITEMS
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(LightningRodItem.INSTANCE);
        event.getRegistry().register(FireballWandItem.INSTANCE);

        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(AmogUsKnifeItem.INSTANCE);
        event.getRegistry().register(SuperSwordItem.INSTANCE);

        // FOOD
        event.getRegistry().register(yummyFoodItem);
        event.getRegistry().register(yuckyFoodItem);

        // ARMOR

        //PROJECTILES

    }
}
