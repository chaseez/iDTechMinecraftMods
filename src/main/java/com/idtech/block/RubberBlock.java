package com.idtech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.material.Material;

public class RubberBlock extends Block
{
  private static Properties properties = Properties.of(Material.STONE);


  public RubberBlock(Properties properties){
    super(properties);
  }

}
