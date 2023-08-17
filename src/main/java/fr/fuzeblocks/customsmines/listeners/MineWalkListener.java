package fr.fuzeblocks.customsmines.listeners;

import fr.fuzeblocks.customsmines.CustomsMines;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

public class MineWalkListener implements Listener {
    private final CustomsMines plugin;

    public MineWalkListener(CustomsMines customsMines) {
        this.plugin = customsMines;
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) throws IOException {
        FileConfiguration configuration = this.plugin.getConfig();
        Player player = event.getPlayer();
        String world = player.getWorld().getName();
        Location loc = player.getLocation();
        double X = loc.getBlockX();
        double Y = loc.getBlockY();
        double Z = loc.getBlockZ();
        File file = new File(plugin.getDataFolder(), "data/getdata.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection configurationSection = config.getConfigurationSection("Mines");
        if (configurationSection == null) return;

        Set<String> mine = configurationSection.getKeys(false);

        // Ici, on va parcourir tous les portails, car on peut récupérer les racines des clés.
        for (String name : mine) {
                String key = "Mines." + name;
                String world1 = config.getString(key + ".World");
                String type = config.getString(key + ".Type");
                double x = config.getDouble(key + ".X");
                double y = config.getDouble(key + ".Y");
                double z = config.getDouble(key + ".Z");
                if (X == x && Y == y && Z == z && world.equals(world1)) {
                    String gamemode = player.getGameMode().name().toString();
                  if (type.equalsIgnoreCase("Destructrice") && gamemode.equals("SURVIVAL")) {
                      if (configuration.getBoolean("Options.LandMinecreateExplosion")) {
                          player.getWorld().createExplosion(player.getLocation(), 20, true, true);
                      }
                      if (!configuration.getBoolean("Options.LandMinecreateExplosion")) {
                          player.setHealth(0);
                      }
                      config.set(key,null);
                      config.save(file);
                      if (player.isDead() && configuration.getBoolean("Options.broadcast-messages-onplayer-dead")) {
                          Bukkit.broadcastMessage(player.getDisplayName() + configuration.getString("Messages.DeadByMine") + " Mine destructrice");
                      }
                  }
                  if (type.equalsIgnoreCase("Faible") && gamemode.equals("SURVIVAL")) {
                      if (configuration.getBoolean("Options.LandMinecreateExplosion")) {
                          player.getWorld().createExplosion(player.getLocation(), 1, true, true);
                      }
                      if (!configuration.getBoolean("Options.LandMinecreateExplosion")) {
                      double health = player.getHealth();
                      double newHealth = health - 5;
                      if (newHealth < 0) {
                          newHealth = 0;

                          player.setHealth(newHealth);
                      }
                  }

                      config.set(key,null);
                      config.save(file);
                      if (player.isDead() && configuration.getBoolean("Options.broadcast-messages-onplayer-dead")) {
                          Bukkit.broadcastMessage(player.getDisplayName() + configuration.getString("Messages.DeadByMine") + " Mine faible");
                      }
                  }
                    if (type.equalsIgnoreCase("Moyenne") && gamemode.equals("SURVIVAL")) {
                        if (configuration.getBoolean("Options.LandMinecreateExplosion")) {
                            player.getWorld().createExplosion(player.getLocation(), 5, true, true);
                        }
                        if (!configuration.getBoolean("Options.LandMinecreateExplosion")) {
                            double health = player.getHealth();
                            double newHealth = health - 10;
                            if (newHealth < 0) {
                                newHealth = 0;
                                player.setHealth(newHealth);
                            }
                        }
                            config.set(key, null);
                            config.save(file);
                            if (player.isDead() && configuration.getBoolean("Options.broadcast-messages-onplayer-dead")) {
                                Bukkit.broadcastMessage(player.getDisplayName() + configuration.getString("Messages.DeadByMine") + " Mine moyenne");
                            }
                    }
                    if (type.equalsIgnoreCase("Forte") && gamemode.equals("SURVIVAL")) {
                        if (configuration.getBoolean("Options.LandMinecreateExplosion")) {
                            player.getWorld().createExplosion(player.getLocation(), 10, true, true);
                        }
                        if (!configuration.getBoolean("Options.LandMinecreateExplosion")) {
                            double health = player.getHealth();
                            double newHealth = health - 15;
                            if (newHealth < 0) {
                                newHealth = 0;
                                player.setHealth(newHealth);
                            }
                        }
                        config.set(key,null);
                        config.save(file);
                        if (player.isDead() && configuration.getBoolean("Options.broadcast-messages-onplayer-dead")) {
                            Bukkit.broadcastMessage(player.getDisplayName() + configuration.getString("Messages.DeadByMine") + " Mine forte");
                        }
                    }
                }
            }
        }
    }

