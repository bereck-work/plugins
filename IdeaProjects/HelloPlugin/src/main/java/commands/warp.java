package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class warp implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        // /warp
        if (command.getName().equalsIgnoreCase("warp")) {
            if (!(strings.length == 1)) {
                player.sendMessage("§6[§eHelloPlugin§6] §cIncorrect usage of the command. Use: /warp <warp>");
            } else {
                if (strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("house")) {
                    World world = Bukkit.getWorld("world");
                    Location location = new Location(world, -16.500, 63, 351.500, -90.5f, -0.4f);
                    player.teleport(location);
                    player.sendMessage("§6[§eHelloPlugin§6] §eYou have been warped to " + strings[0].toLowerCase(Locale.ROOT) + "!");
                } else if (strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("tower")) {
                    World world = Bukkit.getWorld("world");
                    Location location = new Location(world, 19.500, 75, 357.500, -178.8f, 1.7f);
                    player.teleport(location);
                    player.sendMessage("§6[§eHelloPlugin§6] §eYou have been warped to " + strings[0].toLowerCase(Locale.ROOT) + "!");
                } else if (strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("arena")) {
                    World world = Bukkit.getWorld("world");
                    Location location = new Location(world, -18.500, 100, 300.500);
                    player.teleport(location);
                    player.sendMessage("§6[§eHelloPlugin§6] §eYou have been warped to " + strings[0].toLowerCase(Locale.ROOT) + "!");
                } else {
                    player.sendMessage("§6[§eHelloPlugin§6] §cThat warp doesn't exist.");
                }
            }

        }



        return true;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] strings) {
        List<String> l = new ArrayList<String>();
        if (strings.length == 1) {
            l.add("house");
            l.add("tower");
            l.add("arena");
        }
        return l;
    }

}
