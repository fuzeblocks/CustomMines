package fr.fuzeblocks.customsmines;

import fr.fuzeblocks.customsmines.Utils.RecipesUtils;
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
    private final String name1 = this.getDescription().getName();

    @Override
    public void onEnable() {
        System.out.println("The plugin " + name1 + " has been started");
        saveDefaultConfig();
        getCommand("setmine").setExecutor(new SetMinesCommand(this));
        Bukkit.getServer().getPluginManager().registerEvents(new MineListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MineWalkListener(this), this);
        getCommand("getmine").setExecutor(new GetMinesCommand(this));
        RecipesUtils.Recipes();
    }


    @Override
    public void onDisable() {
        System.out.println("The plugin " + name1 + " has been stopped");
    }
}

