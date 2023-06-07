package fr.fuzeblocks.customsmines;

import fr.fuzeblocks.customsmines.commands.GetMinesCommand;
import fr.fuzeblocks.customsmines.commands.SetMinesCommand;
import fr.fuzeblocks.customsmines.listeners.MineListener;
import fr.fuzeblocks.customsmines.listeners.MineWalkListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomsMines extends JavaPlugin {
    private String type;
    public String gettype() {
        return type;
    }
    private final String name1 = Bukkit.getName();

    @Override
    public void onEnable() {
        System.out.println("The plugin" + name1 + "has been started");
        saveDefaultConfig();
        getCommand("setmine").setExecutor(new SetMinesCommand(this));
        Bukkit.getServer().getPluginManager().registerEvents(new MineListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MineWalkListener(this), this);
        getCommand("getmine").setExecutor(new GetMinesCommand(this));
        ItemStack item = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aMINE");
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(this, "MINE");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("TTT","TPT","TTT");
        recipe.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe.setIngredient('T', Material.TNT,1);
        Bukkit.addRecipe(recipe);

        ItemStack item1 = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§aMINE LVL 1");
        item1.setItemMeta(meta1);
        NamespacedKey MIne = new NamespacedKey(this, "MINE-LVL-1");
        ShapedRecipe recipe1 = new ShapedRecipe(MIne, item1);
        recipe1.shape("TGT","TPT","TGT");
        recipe1.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe1.setIngredient('T', Material.TNT,1);
        recipe1.setIngredient('G',Material.GUNPOWDER,1);
        Bukkit.addRecipe(recipe1);

        ItemStack item2 = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§aMINE LVL 2");
        item2.setItemMeta(meta2);
        NamespacedKey MINE = new NamespacedKey(this, "MINE-LVL-2");
        ShapedRecipe recipe2 = new ShapedRecipe(MINE, item2);
        recipe2.shape("GTG","TPT","GTG");
        recipe2.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe2.setIngredient('T', Material.TNT,1);
        recipe2.setIngredient('G',Material.GUNPOWDER,1);
        Bukkit.addRecipe(recipe2);

        ItemStack item3 = new ItemStack(Material.STONE_PRESSURE_PLATE);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§aMINE LVL 3");
        item3.setItemMeta(meta3);
        NamespacedKey mine = new NamespacedKey(this, "MINE-LVL-3");
        ShapedRecipe recipe3 = new ShapedRecipe(mine, item3);
        recipe3.shape("GGG","TPT","GGG");
        recipe3.setIngredient('P', Material.STONE_PRESSURE_PLATE,1);
        recipe3.setIngredient('T', Material.TNT,1);
        recipe3.setIngredient('G',Material.GUNPOWDER,1);
        Bukkit.addRecipe(recipe3);


    }


    @Override
    public void onDisable() {
        System.out.println("The plugin" + name1 + "has been stopped");
    }
}

