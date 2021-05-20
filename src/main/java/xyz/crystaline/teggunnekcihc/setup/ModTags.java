package xyz.crystaline.teggunnekcihc.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import xyz.crystaline.teggunnekcihc.Teggunekcihc;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");

        public static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        public static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(Teggunekcihc.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        // Items
        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/sliver");
        // BlockItems
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");

        public static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        public static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(Teggunekcihc.MOD_ID, path).toString());
        }
    }
}
