package fr.fuzeblocks.customsmines.listeners;

import fr.fuzeblocks.customsmines.CustomsMines;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Material.STONE_PRESSURE_PLATE;


public class MineListener implements Listener {
    private final CustomsMines mines;


    public MineListener(CustomsMines inputCustomsMines) {
        this.mines = inputCustomsMines;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) throws IOException {
        FileConfiguration configuration = mines.getConfig();
        Player player = event.getPlayer();
        String world = player.getWorld().getName();
        if (event.getItemDrop().getItemStack().getType() == STONE_PRESSURE_PLATE) {
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE LVL 1")) {
                Location location = player.getLocation();
                int x = location.getBlockX();
                int y = location.getBlockY();
                int z = location.getBlockZ();
                z += 1;

                try {
                    File file = new File(mines.getDataFolder(), "data/getdata.yml");
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                    String type = "LVL1";
                    String key = "Mines." + x;
                    config.set(key + ".World", world);
                    config.set(key + ".X", x);
                    config.set(key + ".Y", y);
                    config.set(key + ".Z", z);
                    config.set(key + ".Type", type);
                    config.save(file);
                    if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE LVL 1") && event.getItemDrop().getItemStack().getType() == STONE_PRESSURE_PLATE) {
                        Item droppedItem = event.getItemDrop();
                        droppedItem.remove();
                        String messages = configuration.getString("Messages.CreateMines");
                        player.sendMessage(messages + " " + x + " " + y + " " + z);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE")) {
                Location location = player.getLocation();
                int x = location.getBlockX();
                int y = location.getBlockY();
                int z = location.getBlockZ();
                z += 1;
                try {
                    File file = new File(mines.getDataFolder(), "data/getdata.yml");
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                    String type = "Normal";
                    String key = "Mines." + x;
                    config.set(key + ".World", world);
                    config.set(key + ".X", x);
                    config.set(key + ".Y", y);
                    config.set(key + ".Z", z);
                    config.set(key + ".Type", type);
                    config.save(file);
                    if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE") && event.getItemDrop().getItemStack().getType() == STONE_PRESSURE_PLATE) {
                        Item droppedItem = event.getItemDrop();
                        droppedItem.remove();
                        String messages = configuration.getString("Messages.CreateMines");
                        player.sendMessage(messages + " " + x + " " + y + " " + z);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE LVL 2")) {
                Location location = player.getLocation();
                int x = location.getBlockX();
                int y = location.getBlockY();
                int z = location.getBlockZ();
                z += 1;

                try {
                    File file = new File(mines.getDataFolder(), "data/getdata.yml");
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                    String type = "LVL2";
                    String key = "Mines." + x;
                    config.set(key + ".World", world);
                    config.set(key + ".X", x);
                    config.set(key + ".Y", y);
                    config.set(key + ".Z", z);
                    config.set(key + ".Type", type);
                    config.save(file);
                    if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE LVL 2") && event.getItemDrop().getItemStack().getType() == STONE_PRESSURE_PLATE) {
                        Item droppedItem = event.getItemDrop();
                        droppedItem.remove();
                        String messages = configuration.getString("Messages.CreateMines");
                        player.sendMessage(messages + " " + x + " " + y + " " + z);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE LVL 3")) {
                Location location = player.getLocation();
                int x = location.getBlockX();
                int y = location.getBlockY();
                int z = location.getBlockZ();
                z += 1;

                try {
                    File file = new File(mines.getDataFolder(), "data/getdata.yml");
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                    String type = "LVL3";
                    String key = "Mines." + x;
                    config.set(key + ".World", world);
                    config.set(key + ".X", x);
                    config.set(key + ".Y", y);
                    config.set(key + ".Z", z);
                    config.set(key + ".Type", type);
                    config.save(file);
                    if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMINE LVL 3") && event.getItemDrop().getItemStack().getType() == STONE_PRESSURE_PLATE) {
                        Item droppedItem = event.getItemDrop();
                        droppedItem.remove();
                        String messages = configuration.getString("Messages.CreateMines");
                        player.sendMessage(messages + " " + x + " " + y + " " + z);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


