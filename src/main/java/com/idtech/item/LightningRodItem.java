package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningRodItem extends Item {
  public LightningRodItem(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
    ItemStack itemstack = playerIn.getItemInHand(handIn);

    BlockPos pos = Utils.getBlockAtCursor(playerIn, 20.0d, true);

    if(pos != null){
      Utils.createExplosion(level, pos, 0.5f);
      Utils.strikeLightning(level, pos);
    }

    return InteractionResultHolder.pass(itemstack);
  }

  private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
  public static Item INSTANCE = new LightningRodItem(properties).setRegistryName("lightningrod");
}
