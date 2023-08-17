package fr.fuzeblocks.customsmines.Utils;

import fr.fuzeblocks.customsmines.CustomsMines;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipesUtils {
    public static CustomsMines customsMines;
    public RecipesUtils(CustomsMines customsMines) {
        RecipesUtils.customsMines = customsMines;
    }

    public static void Recipes() {
        ItemStack item = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aMine destructrice");
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(customsMines, "Mine destructrice");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("TTT","TPT","TTT");
        recipe.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe.setIngredient('T', Material.TNT,1);
        Bukkit.addRecipe(recipe);

        ItemStack item1 = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§aMine forte");
        item1.setItemMeta(meta1);
        NamespacedKey MIne = new NamespacedKey(customsMines, "Mine-forte");
        ShapedRecipe recipe1 = new ShapedRecipe(MIne, item1);
        recipe1.shape("TGT","TPT","TGT");
        recipe1.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe1.setIngredient('T', Material.TNT,1);
        recipe1.setIngredient('G',Material.GUNPOWDER,1);
        Bukkit.addRecipe(recipe1);

        ItemStack item2 = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§aMine moyenne");
        item2.setItemMeta(meta2);
        NamespacedKey MINE = new NamespacedKey(customsMines, "Mine-moyenne");
        ShapedRecipe recipe2 = new ShapedRecipe(MINE, item2);
        recipe2.shape("GTG","TPT","GTG");
        recipe2.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe2.setIngredient('T', Material.TNT,1);
        recipe2.setIngredient('G',Material.GUNPOWDER,1);
        Bukkit.addRecipe(recipe2);

        ItemStack item3 = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§aMine faible");
        item3.setItemMeta(meta3);
        NamespacedKey mine = new NamespacedKey(customsMines, "Mine-faible");
        ShapedRecipe recipe3 = new ShapedRecipe(mine, item3);
        recipe3.shape("GGG","TPT","GGG");
        recipe3.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe3.setIngredient('T', Material.TNT,1);
        recipe3.setIngredient('G',Material.GUNPOWDER,1);
        Bukkit.addRecipe(recipe3);


        customsMines.getLogger().info("Les craft ont été chargés");
    }
}
