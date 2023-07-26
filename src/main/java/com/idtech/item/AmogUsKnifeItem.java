package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class AmogUsKnifeItem extends SwordItem {
  private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_COMBAT);
  public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 10,
          null, ()->{return Ingredient.of(ItemMod.AMOG_US);});

  public static Item INSTANCE = new AmogUsKnifeItem(tier, 100, 100, properties)
          .setRegistryName(BaseMod.MODID,"amogusknife");

  public AmogUsKnifeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
    super(tier, attackDamageIn, attackSpeedIn, properties);
  }


}
