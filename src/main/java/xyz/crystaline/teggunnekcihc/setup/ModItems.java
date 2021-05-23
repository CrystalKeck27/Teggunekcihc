package xyz.crystaline.teggunnekcihc.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings("unused")
public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> TRASH = Registration.ITEMS.register("trash", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> BUTCHER_KNIFE = Registration.ITEMS.register("butcher_knife", () ->
            new SwordItem(ItemTier.IRON, 0, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject <Item> CHICKEN_NUGGET = Registration.ITEMS.register("chicken_nugget", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD)));

    static void register() {}
}
