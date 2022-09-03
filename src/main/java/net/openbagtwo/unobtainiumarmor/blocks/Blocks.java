package net.openbagtwo.unobtainiumarmor.blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;

public class Blocks {

  public static final Map<String, Block> BLOCK_LIST /*haha*/ = Map.ofEntries(
      Map.entry("alexandrite_block", new Block(FabricBlockSettings.of(Material.METAL))),
      Map.entry("alexandrite_ore", new Block(FabricBlockSettings.of(Material.STONE))),
      Map.entry("cats_eye_gemm_block", new Block(FabricBlockSettings.of(Material.METAL))),
      Map.entry("cats_eye_gemm_ore", new Block(FabricBlockSettings.of(Material.STONE))),
      Map.entry("sapphire_block", new Block(FabricBlockSettings.of(Material.METAL))),
      Map.entry("sapphire_ore", new Block(FabricBlockSettings.of(Material.STONE)))
      );

  private static Map<String, BlockItem> generateBlockItems(){
    HashMap<String, BlockItem> blockItems = new HashMap<>();
    for (Entry<String, Block> block : BLOCK_LIST.entrySet()) {
      blockItems.put(
          block.getKey(),
          new BlockItem(block.getValue(), new FabricItemSettings().group(ItemGroup.MATERIALS))
      );
    }
    return blockItems;
  }

  public static final Map<String, BlockItem> BLOCK_ITEMS = generateBlockItems();

  public static void register() {
    for (Entry<String, Block> block : BLOCK_LIST.entrySet()) {
      Registry.register(
          Registry.BLOCK,
          new Identifier(UnobtainiumArmorMod.MOD_ID, block.getKey()),
          block.getValue()
      );
      Registry.register(
          Registry.ITEM,
          new Identifier(UnobtainiumArmorMod.MOD_ID, block.getKey()),
          BLOCK_ITEMS.get(block.getKey())
      );
    }

  }

}
