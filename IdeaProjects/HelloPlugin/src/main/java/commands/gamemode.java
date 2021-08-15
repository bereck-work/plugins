package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class gamemode implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        if ((strings.length > 2) || (strings.length == 0)){
            Bukkit.broadcastMessage("§6[§eHelloPlugin§6] §cIncorrect usage of the command. Use: /gamemode <gamemode>");
        } else {
            if (strings.length == 1) {
                GameMode gamemode = GameMode.SURVIVAL;
                boolean canGo = true;
                if ((strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("survival")) || (strings[0].equalsIgnoreCase("0")) || (strings[0].equalsIgnoreCase("s"))) {
                    gamemode = GameMode.SURVIVAL;
                } else if ((strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("creative")) || (strings[0].equalsIgnoreCase("1")) || (strings[0].equalsIgnoreCase("c"))) {
                    gamemode = GameMode.CREATIVE;
                } else if ((strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("adventure")) || (strings[0].equalsIgnoreCase("2")) || (strings[0].equalsIgnoreCase("a"))) {
                    gamemode = GameMode.ADVENTURE;
                } else if ((strings[0].toLowerCase(Locale.ROOT).equalsIgnoreCase("spectator")) || (strings[0].equalsIgnoreCase("3")) || (strings[0].equalsIgnoreCase("sp"))) {
                    gamemode = GameMode.SPECTATOR;
                } else {
                    Bukkit.broadcastMessage("§6[§eHelloPlugin§6] §cThat gamemode doesn't exist.");
                    canGo = false;
                }

                if (canGo) {
                    GameMode currentGamemode = player.getGameMode();
                    if (currentGamemode == gamemode) {
                        player.sendMessage(ChatColor.GOLD + "§lUmmm. " + ChatColor.YELLOW + "Your gamemode is already set to " + gamemode.name().substring(0, 1).toUpperCase(Locale.ROOT) + gamemode.name().toLowerCase(Locale.ROOT).substring(1) + "!");
                    } else {
                        player.sendMessage(ChatColor.GOLD + "§lWoohoo! "  + ChatColor.YELLOW + "Your gamemode has been changed to " + gamemode.name().substring(0, 1).toUpperCase(Locale.ROOT) + gamemode.name().toLowerCase(Locale.ROOT).substring(1) + "!");
                    }

                    player.setGameMode(gamemode);
                }
            }


        }

        return true;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] strings) {
            List<String> n = new ArrayList<String>();
            if (strings.length == 1) {
                n.add("survival");
                n.add("creative");
                n.add("adventure");
                n.add("spectator");
            }
            return n;
    }

}
