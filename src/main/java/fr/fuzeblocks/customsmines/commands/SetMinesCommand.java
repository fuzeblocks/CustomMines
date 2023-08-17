package fr.fuzeblocks.customsmines.commands;

import fr.fuzeblocks.customsmines.CustomsMines;
import fr.fuzeblocks.customsmines.listeners.MineListener;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("NullableProblems")
public class SetMinesCommand implements CommandExecutor {
    private final CustomsMines customsMines;
    public SetMinesCommand(CustomsMines inputcustomsMines) {
        this.customsMines = inputcustomsMines;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            FileConfiguration configuration = customsMines.getConfig();
            if (player.hasPermission("setmine.use") || player.isOp()) {
              Location location = player.getLocation();
              if (args.length == 2) {
                  String name = args[0];
                  String type = args[1];
                  String world = player.getWorld().getName();
                  int x = location.getBlockX();
                  int y = location.getBlockY();
                  int z = location.getBlockZ();
                  File file = new File(customsMines.getDataFolder(),"data/getdata.yml");
                  YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                  String key = "Mines." + name + x;
                  config.set(key + ".Type",type);
                  config.set(key + ".World",world);
                  config.set(key + ".X",x);
                  config.set(key + ".Y",y);
                  config.set(key + ".Z",z);
                  try {
                     config.save(file);
                      String messages = configuration.getString("Messages.CreateMines");
                      player.sendMessage(messages + " " + x + " " + y + " " + z);
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }

              }


            }
        } else {
            sender.sendMessage("Seul un joueur peut executer cette commande !");
        }
        return true;
    }
}
