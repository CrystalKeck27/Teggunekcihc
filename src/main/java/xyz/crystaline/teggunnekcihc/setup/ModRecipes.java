package xyz.crystaline.teggunnekcihc.setup;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import xyz.crystaline.teggunnekcihc.Teggunekcihc;
import xyz.crystaline.teggunnekcihc.crafting.recipe.CompactingRecipe;

import java.util.function.Supplier;

public class ModRecipes {
    public static class Types {
        public static final IRecipeType<CompactingRecipe> COMPACTING = IRecipeType.register(Teggunekcihc.MOD_ID + "compacting");
    }

    public static class Serializers {
        public static final RegistryObject<IRecipeSerializer<?>> COMPACTING = Registration.RECIPE_SERIALIZERS.register(
                "compacting", CompactingRecipe.Serializer::new);
    }
    
    static void register() {}
}
