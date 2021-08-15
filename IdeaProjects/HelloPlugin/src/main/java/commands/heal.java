package commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class heal implements CommandExecutor {

    private HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
    private int cooldowntime = 10;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        if (!(player.isOp())) {

            if (cooldown.containsKey(player.getUniqueId())) {
                long secondsLeft = ((cooldown.get(player.getUniqueId()) / 1000) + cooldowntime) - (System.currentTimeMillis() / 1000);
                if (secondsLeft > 0) {
                    player.sendMessage("§6[§eHelloPlugin§6] §cYou are currently on cooldown. Try again in " + secondsLeft + " seconds.");
                } else {
                    double maxHealth = player.getMaxHealth();
                    player.setFoodLevel(20);
                    player.setHealth(maxHealth);
                    player.sendMessage("§6[§eHelloPlugin§6] §5You have been healed.");
                    cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                }
            } else {
                double maxHealth = player.getMaxHealth();
                player.setFoodLevel(20);
                player.setHealth(maxHealth);
                player.sendMessage("§6[§eHelloPlugin§6] §5You have been healed.");
                cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            }

        } else {
            double maxHealth = player.getMaxHealth();
            player.setFoodLevel(20);
            player.setHealth(maxHealth);
            player.sendMessage("§6[§eHelloPlugin§6] §5You have been healed.");
        }


        return true;
    }
}
