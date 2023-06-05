package fr.fuzeblocks.customsmines.listeners;

import fr.fuzeblocks.customsmines.CustomsMines;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.File;
import java.util.UUID;

public class MineWalkListener implements Listener {
    private  CustomsMines plugin;
    public MineWalkListener(CustomsMines customsMines) {
        this.plugin = customsMines;
    }



    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID world = player.getWorld().getUID();
        Location loc = player.getLocation();
        double x = loc.getBlockX();
        double y = loc.getBlockY();
        double z = loc.getBlockZ();
        File file = new File(plugin.getDataFolder(), "data/getdata.yml");
        YamlConfiguration config1 = YamlConfiguration.loadConfiguration(file);
        String key = "Mines." + type + X;
    }
}
