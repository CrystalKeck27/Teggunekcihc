package xyz.crystaline.teggunnekcihc.crafting.recipe;

import com.google.gson.JsonObject;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.lwjgl.system.CallbackI;
import xyz.crystaline.teggunnekcihc.setup.ModRecipes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class CompactingRecipe extends SingleItemRecipe {
    public CompactingRecipe(ResourceLocation recipeId,
                            Ingredient ingredient,
                            ItemStack result) {
        super(ModRecipes.Types.COMPACTING, ModRecipes.Serializers.COMPACTING.get(), recipeId, "", ingredient, result);
    }

    // Fail fast, this method should be quick.
    @Override
    public boolean matches(IInventory inv, World world) {
        return ingredient.test(inv.getItem(0));
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<CompactingRecipe> {

        @Nonnull
        @Override
        @ParametersAreNonnullByDefault
        public CompactingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            Ingredient ingredient = Ingredient.fromJson(json.get("ingredient"));
            ResourceLocation itemId = new ResourceLocation(JSONUtils.getAsString(json, "result"));
            int count = JSONUtils.getAsInt(json, "count");

            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId), count);
            return new CompactingRecipe(recipeId, ingredient, result);
        }

        @Nullable
        @Override
        @ParametersAreNonnullByDefault
        public CompactingRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack result = buffer.readItem();
            return new CompactingRecipe(recipeId, ingredient, result);
        }

        @Override
        @ParametersAreNonnullByDefault
        public void toNetwork(PacketBuffer buffer, CompactingRecipe recipe) {
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
        }
    }
}
