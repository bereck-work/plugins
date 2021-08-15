package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kill implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        if (strings.length > 0) {
            Player playerToBeKilled = Bukkit.getPlayer(strings[0]);
            playerToBeKilled.setHealth(0);
            player.sendMessage(ChatColor.GOLD + "§lDamn! " + ChatColor.YELLOW + "You killed " + playerToBeKilled.getDisplayName() + ".");
        } else if (strings.length == 0) {
            player.setHealth(0);
            player.sendMessage(ChatColor.GOLD + "§lDamn! " + ChatColor.YELLOW + "You killed " + player.getDisplayName() + ".");
        }

        return true;
    }
}
