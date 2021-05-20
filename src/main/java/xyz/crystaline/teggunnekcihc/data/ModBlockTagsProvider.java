package xyz.crystaline.teggunnekcihc.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.crystaline.teggunnekcihc.Teggunekcihc;
import xyz.crystaline.teggunnekcihc.setup.ModBlocks;
import xyz.crystaline.teggunnekcihc.setup.ModTags;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Teggunekcihc.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get());
        tag(Tags.Blocks.ORES).add(ModBlocks.SILVER_ORE.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModBlocks.SILVER_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).add(ModBlocks.SILVER_BLOCK.get());
    }
}
