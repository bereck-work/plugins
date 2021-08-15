package events;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import commands.ArenaStart;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Consumer;

public class ArenaEvents implements Listener {



    @EventHandler
    public void monsterDeath(EntityDeathEvent event) {

            Player player = event.getEntity().getKiller();
            Entity entity = event.getEntity();
            if (entity instanceof Monster) {

                int foodLevelToBeAdded = 0;
                double healthLevelToBeAdded = 0;

                if (entity.getName().equalsIgnoreCase("Zombie")) {
                    foodLevelToBeAdded = 1;
                    healthLevelToBeAdded = 0;
                    player.sendMessage(ChatColor.GREEN + "Zombie " + ChatColor.AQUA + "+0 hp +0,5 hunger");
                } else if (entity.getName().equalsIgnoreCase("Creeper")) {
                    foodLevelToBeAdded = 2;
                    healthLevelToBeAdded = 0.5;
                    player.sendMessage(ChatColor.GREEN + "Creeper " + ChatColor.AQUA + "+0,5 hp +1 hunger");
                } else if (entity.getName().equalsIgnoreCase("Skeleton")) {
                    foodLevelToBeAdded = 2;
                    healthLevelToBeAdded = 2;
                    player.sendMessage(ChatColor.GREEN + "Skeleton " + ChatColor.AQUA + "+1 hp +1 hunger");
                } else if (entity.getName().equalsIgnoreCase("Spider")) {
                    foodLevelToBeAdded = 1;
                    healthLevelToBeAdded = 0.5;
                    player.sendMessage(ChatColor.GREEN + "Spider " + ChatColor.AQUA + "+0,5 hp +0,5 hunger");
                }

                double playersHealth = player.getHealth();
                player.setHealth(playersHealth + healthLevelToBeAdded);
                int playersHunger = player.getFoodLevel();
                player.setFoodLevel(playersHunger + foodLevelToBeAdded);
            }

    }

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {


            Player player = event.getPlayer();
            GameMode gamemode = player.getGameMode();
            if (gamemode.name().equalsIgnoreCase("SURVIVAL")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &cYou can't break that block!"));
            }

    }

    @EventHandler
    public void playerKill(PlayerDeathEvent event) {

            String deathMessage = event.getDeathMessage();
            event.setDeathMessage(ChatColor.GOLD + "§6[§eArena§6] §7" + ChatColor.YELLOW + deathMessage + ".");

            Bukkit.getWorld("world").getEntities().forEach(entity -> {
                if (!(entity instanceof Player)) {
                    entity.remove();
                }
            });

    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {

            event.getDrops().clear();

    }

}
