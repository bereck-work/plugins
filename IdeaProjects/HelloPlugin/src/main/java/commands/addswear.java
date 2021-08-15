package commands;

import com.EpicPlayer.HelloPlugin.HelloPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.configuration.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class addswear implements CommandExecutor {
    FileConfiguration config = HelloPlugin.getInstance().getConfig();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        // /addswear <swear word>
        if (strings.length != 1) {
            Bukkit.broadcastMessage("§6[§eHelloPlugin§6] §c Incorrect usage of the command. Use: /addswear <word you want to blacklist>");
        } else {
            Bukkit.broadcastMessage(ChatColor.GREEN + "test");
        }

        return true;
    }
}
