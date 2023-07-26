package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ZooSwordItem extends SwordItem {
  private static Properties properties = new Properties().tab(CreativeModeTab.TAB_MISC);
  public static Item INSTANCE = new ZooSwordItem(Tiers.WOOD, 2, 1, properties).setRegistryName("zoosword");

  public ZooSwordItem(Tiers tier, int speed, float damage, Properties properties) {
    super(tier, speed, damage, properties);
  }

  @Override
  public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
    BlockPos location = Utils.getBlockAtCursor(playerIn, 200.0d, true);
    int size = 10;
    EntityType animals[] = new EntityType[size];
    animals[0] = EntityType.BAT;
    animals[1] = EntityType.BAT;
    animals[2] = EntityType.BAT;
    animals[3] = EntityType.BAT;
    animals[4] = EntityType.BAT;
    animals[5] = EntityType.BAT;
    animals[6] = EntityType.BAT;
    animals[7] = EntityType.BAT;
    animals[8] = EntityType.BAT;
    animals[9] = EntityType.BAT;

    int rand = levelIn.random.nextInt(10);

    if(location != null) {
      Entity newAnimal = animals[rand].create(levelIn);
      Utils.spawnEntity(levelIn, newAnimal, location);
      return InteractionResultHolder.success(playerIn.getItemInHand(handIn));
    }

    return InteractionResultHolder.fail(playerIn.getItemInHand(handIn));
  }





}
