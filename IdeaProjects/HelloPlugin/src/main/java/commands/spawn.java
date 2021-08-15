package commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        // /spawn
        if (command.getName().equalsIgnoreCase("spawn")) {
            World world = player.getWorld();
            Location location = new Location(world, 5.500, 68, 337.500);
            player.teleport(location);
            player.sendMessage("§6[§eHelloPlugin§6] §eYou have been teleported to Spawn!");
        }
        return true;
    }
}
