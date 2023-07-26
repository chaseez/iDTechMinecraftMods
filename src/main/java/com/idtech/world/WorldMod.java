package com.idtech.world;

import com.idtech.BaseMod;
import com.idtech.block.BlockMod;
import com.idtech.entity.ZomboEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BaseMod.MODID)
public class WorldMod {

  public static void registerBiomes(final RegistryEvent.Register<Biome> event){
  }

  @SubscribeEvent
  public static void addFeatures(BiomeLoadingEvent event) {
    MobSpawnSettingsBuilder builder = event.getSpawns();
    if(event.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
      builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ZomboEntity.TYPE, 100, 2, 4));
    }
  }
}
