package xyz.crystaline.teggunnekcihc.data;

import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import xyz.crystaline.teggunnekcihc.Teggunekcihc;
import xyz.crystaline.teggunnekcihc.setup.ModBlocks;
import xyz.crystaline.teggunnekcihc.setup.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SILVER_BLOCK.get())
                .define('#', ModItems.SILVER_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get()))
                .save(consumer, name("silver_ingot_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get()))
                .save(consumer, name("silver_ingot_blasting"));
    }

    private static ResourceLocation name(String name) {
        return new ResourceLocation(Teggunekcihc.MOD_ID, name);
    }
}
