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
            if (player.hasPermission("setmine.use") || player.isOp()) {
              Location location = player.getLocation();
              if (args.length == 2) {
                  String name = args[0];
                  String type = args[1];
                  UUID world = player.getWorld().getUID();
                  int x = location.getBlockX();
                  int y = location.getBlockY();
                  int z = location.getBlockZ();
                  File file = new File(this.customsMines.getDataFolder(),"/data.yml");
                  YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
                  FileConfiguration config = customsMines.getConfig();
                  String key = "Mines." + name;
                  config.set(key + ".Type",type);
                  config.set(key + ".World",world);
                  config.set(key + ".X",x);
                  config.set(key + ".Y",y);
                  config.set(key + ".Z",z);
                  try {
                     config.save(file);
                     player.sendMessage(config.getString("Messages.CreateMines"));
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }

              }


            }
        }
        return true;
    }
}
