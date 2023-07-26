package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.SoundHandler;
import com.idtech.Utils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;

public class ZomboEntity extends Zombie {
  public ZomboEntity(EntityType<? extends Zombie> type, Level level) {
    super(type, level);
  }
  public static EntityType<ZomboEntity> TYPE = (EntityType<ZomboEntity>)
          EntityType.Builder.of(ZomboEntity::new, MobCategory.MONSTER)
                  .build("zombo")
                  .setRegistryName(BaseMod.MODID, "zombo");

  public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

  public static AttributeSupplier.Builder createAttributes() {
    return Monster.createMonsterAttributes().add(Attributes.SPAWN_REINFORCEMENTS_CHANCE)
            .add(Attributes.MAX_HEALTH, 200)
            .add(Attributes.ARMOR,2.0D)
            .add(Attributes.ATTACK_DAMAGE, 50)
            .add(Attributes.ATTACK_SPEED, 1)
            .add(Attributes.FOLLOW_RANGE, 300.0D)
            .add(Attributes.MOVEMENT_SPEED, 1);
  }
  @Override
  public void registerGoals() {
    this.targetSelector.addGoal(0, new FloatGoal(this));
    this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
    this.targetSelector.addGoal(3, new MeleeAttackGoal(this, 0.8f, false));
    this.targetSelector.addGoal(4, (new HurtByTargetGoal(this)).setAlertOthers(ZomboEntity.class));
    this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
  }

  @Nullable
  @Override
  public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor,
                                      DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType,
                                      @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
    int random = this.level.random.nextInt(100);
    if(random < 10) {
      PolarBear polarBear = new PolarBear(EntityType.POLAR_BEAR, levelAccessor.getLevel());
      ZomboEntity zombo = new ZomboEntity(EntityType.ZOMBIE, levelAccessor.getLevel());
      Utils.spawnEntity(levelAccessor.getLevel(), zombo, this.blockPosition());
      this.startRiding(zombo);

      Utils.spawnEntity(levelAccessor.getLevel(), polarBear, this.blockPosition());
      this.startRiding(polarBear);
    }
    if(random > 10 && random < 25) {
      this.setItemSlotAndDropWhenKilled(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
      this.setItemSlotAndDropWhenKilled(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
      this.setItemSlotAndDropWhenKilled(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
      this.setItemSlotAndDropWhenKilled(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
      this.setItemSlotAndDropWhenKilled(EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));
    }

    return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
  }
  @Override
  protected SoundEvent getAmbientSound() {
    return SoundEvents.ZOMBIE_AMBIENT;
  }

  @Override
  protected SoundEvent getHurtSound(DamageSource ds) {
    return SoundHandler.mySound;
  }

  @Override
  protected SoundEvent getDeathSound() {
    return SoundHandler.zomboDeathSound;
  }

}
