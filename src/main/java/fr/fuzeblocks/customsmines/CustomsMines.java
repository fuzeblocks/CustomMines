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
        recipe.shape( " P ", " T ");
        recipe.setIngredient('P', Material.STONE_PRESSURE_PLATE);
        recipe.setIngredient('T', Material.TNT);
        Bukkit.addRecipe(recipe);


    }


    @Override
    public void onDisable() {
        System.out.println("The plugin" + name1 + "has been stopped");
    }
}

