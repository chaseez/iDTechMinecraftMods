package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;
import java.util.Random;

public class CreeperSurpriseBlock extends Block {
  private static Properties properties = Properties.of(Material.STONE).randomTicks();

  public CreeperSurpriseBlock(Properties properties){
    super(properties);
  }

  public static Block INSTANCE = new CreeperSurpriseBlock(properties).setRegistryName(BaseMod.MODID, "creepersurpise");
  public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_MISC);

  @Override
  public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState,
                            @Nullable BlockEntity blockEntity, ItemStack stack) {
    super.playerDestroy(level, player, pos, blockState, blockEntity, stack);
    Creeper creeper = new Creeper(EntityType.CREEPER, level);
    Utils.spawnEntity(level, creeper, pos);
  }
}
