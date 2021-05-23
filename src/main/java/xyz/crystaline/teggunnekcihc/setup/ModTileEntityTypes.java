package xyz.crystaline.teggunnekcihc.setup;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import xyz.crystaline.teggunnekcihc.block.trashcompactor.TrashCompactorTileEntity;

import java.util.function.Supplier;

public class ModTileEntityTypes {
    public static final RegistryObject<TileEntityType<TrashCompactorTileEntity>> TRASH_COMPACTOR = register(
            "trash_compactor",
            TrashCompactorTileEntity::new,
            ModBlocks.TRASH_COMPACTOR
    );

    static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name,
                                                                                     Supplier<T> factory,
                                                                                     RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> {
            //noinspection ConstantConditions - null in build
            return TileEntityType.Builder.of(factory, block.get()).build(null);
        });
    }
}
