package fr.fuzeblocks.customsmines.commands;

import fr.fuzeblocks.customsmines.CustomsMines;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetMinesCommand implements CommandExecutor {
    private CustomsMines plugin;

    public GetMinesCommand(CustomsMines customsMines) {
        this.plugin = customsMines;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("getmine.use") || player.isOp()) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("FAI")) {
                        ItemStack itemStack = new ItemStack(Material.STONE_PRESSURE_PLATE, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setDisplayName("§aMine faible");
                        itemStack.setItemMeta(meta);
                        player.getInventory().addItem(itemStack);
                    }
                    if (args[0].equalsIgnoreCase("MOY")) {
                        ItemStack itemStack = new ItemStack(Material.STONE_PRESSURE_PLATE, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setDisplayName("§aMine moyenne");
                        itemStack.setItemMeta(meta);
                        player.getInventory().addItem(itemStack);
                    }
                    if (args[0].equalsIgnoreCase("FOR")) {
                        ItemStack itemStack = new ItemStack(Material.STONE_PRESSURE_PLATE, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setDisplayName("§aMine forte");
                        itemStack.setItemMeta(meta);
                        player.getInventory().addItem(itemStack);
                    }
                    if (args[0].equalsIgnoreCase("DES")) {
                        ItemStack itemStack = new ItemStack(Material.STONE_PRESSURE_PLATE, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setDisplayName("§aMine destructrice");
                        itemStack.setItemMeta(meta);
                        player.getInventory().addItem(itemStack);
                    }
                }
            }
            return true;
        } else {
            sender.sendMessage("Seul un joueur peut executer cette commande !");
        }
        return true;
    }
}
