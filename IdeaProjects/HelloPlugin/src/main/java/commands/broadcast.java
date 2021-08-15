package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        // /heal
        if (command.getName().equalsIgnoreCase("broadcast")) {
            if (strings.length >= 1) {
                String message = "";
                for (String element: strings) {
                    message += element + " ";
                }
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eHelloPlugin&6] &4[&cBroadcast&4] " + message));

            } else {
                player.sendMessage("§6[§eHelloPlugin§6] §cIncorrect usage of the command. Use: /broadcast <sentence>");
            }
        }

        return true;
    }
}
