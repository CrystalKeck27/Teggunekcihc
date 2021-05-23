package xyz.crystaline.teggunnekcihc.setup;

import net.minecraft.item.Food;

public class ModFoods {
    public static final Food CHICKEN_NUGGET = new Food.Builder().nutrition(1).saturationMod(0.3f).meat().fast().build();
    public static final Food CHEEZ_IT = new Food.Builder().nutrition(0).saturationMod(0.1f).fast().build();
}
