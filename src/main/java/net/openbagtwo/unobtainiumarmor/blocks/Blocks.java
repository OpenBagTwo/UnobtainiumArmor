package net.openbagtwo.unobtainiumarmor.blocks;

import static net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod.MOD_ID;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;

public class Blocks {

  public static final Map<String, Block> blockList /*haha*/ = Map.ofEntries(
      Map.entry("alexandrite_block", new Block(FabricBlockSettings.of(Material.METAL))),
      Map.entry("alexandrite_ore", new Block(FabricBlockSettings.of(Material.STONE))),
      Map.entry("cats_eye_gemm_block", new Block(FabricBlockSettings.of(Material.METAL))),
      Map.entry("cats_eye_gemm_ore", new Block(FabricBlockSettings.of(Material.STONE))),
      Map.entry("sapphire_block", new Block(FabricBlockSettings.of(Material.METAL))),
      Map.entry("sapphire_ore", new Block(FabricBlockSettings.of(Material.STONE)))
      );

  public static void register() {
    for (Entry<String, Block> block : blockList.entrySet()) {
      Registry.register(
          Registry.BLOCK,
          new Identifier(UnobtainiumArmorMod.MOD_ID, block.getKey()),
          block.getValue()
      );
    }

  }

}
