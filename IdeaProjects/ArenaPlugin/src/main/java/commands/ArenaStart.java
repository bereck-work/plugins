package commands;

import com.ArenaPlugin.ArenaPlugin;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Random;

public class ArenaStart implements CommandExecutor, Listener {

    boolean isStarted = false;
    boolean isStartedTwo = true;
    int coins = 0;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            return true;
        }
        Player player = (Player) commandSender;

        isStarted = true;
        World world = Bukkit.getWorld("world");
        Location location = new Location(world, -18.500, 100, 300.500);
        player.teleport(location);
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&0&l=============================================\n&6&lWelcome to Arena!\n&eYour task is to defeat all monsters!\nYou will have to defeat all monsters. Good luck and have fun!\n&f&oPlugin made by EPIC_PLAYER.\n&0&l============================================="));
        GameMode gamemode = GameMode.SURVIVAL;
        player.setGameMode(gamemode);
        double maxHealth = player.getMaxHealth();
        player.setHealth(maxHealth);
        player.setFoodLevel(20);
        Inventory playersInv = player.getInventory();
        playersInv.clear();
        ItemStack ironSword = new ItemStack(Material.IRON_SWORD, 1);
        playersInv.addItem(ironSword);
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }


        System.out.println("Arena has been started: " + isStarted);

        new BukkitRunnable() {
            int countdownTime = 10;
            String word = "seconds";

            @Override
            public void run() {
                if (countdownTime == 0) {
                    this.cancel();

                    // All possible locations for mobs to spawn

                    Location locationNorth1 = new Location(world, -23.500, 103, 288.500);
                    Location locationNorth2 = new Location(world, -21.500, 103, 288.500);
                    Location locationNorth3 = new Location(world, -19.500, 103, 288.500);
                    Location locationNorth4 = new Location(world, -17.500, 103, 288.500);
                    Location locationNorth5 = new Location(world, -15.500, 103, 288.500);
                    Location locationNorth6 = new Location(world, -13.500, 103, 288.500);

                    Location locationEast1 = new Location(world, -6.500, 103, 295.500);
                    Location locationEast2 = new Location(world, -6.500, 103, 297.500);
                    Location locationEast3 = new Location(world, -6.500, 103, 299.500);
                    Location locationEast4 = new Location(world, -6.500, 103, 301.500);
                    Location locationEast5 = new Location(world, -6.500, 103, 303.500);
                    Location locationEast6 = new Location(world, -6.500, 103, 305.500);

                    Location locationSouth1 = new Location(world, -13.500, 103, 312.500);
                    Location locationSouth2 = new Location(world, -15.500, 103, 312.500);
                    Location locationSouth3 = new Location(world, -17.500, 103, 312.500);
                    Location locationSouth4 = new Location(world, -19.500, 103, 312.500);
                    Location locationSouth5 = new Location(world, -21.500, 103, 312.500);
                    Location locationSouth6 = new Location(world, -23.500, 103, 312.500);

                    Location locationWest1 = new Location(world, -30.500, 103, 305.500);
                    Location locationWest2 = new Location(world, -30.500, 103, 303.500);
                    Location locationWest3 = new Location(world, -30.500, 103, 301.500);
                    Location locationWest4 = new Location(world, -30.500, 103, 299.500);
                    Location locationWest5 = new Location(world, -30.500, 103, 297.500);
                    Location locationWest6 = new Location(world, -30.500, 103, 295.500);

                    Location[] locations = {locationNorth1, locationNorth2, locationNorth3, locationNorth4, locationNorth5, locationNorth6, locationEast1, locationEast2, locationEast3, locationEast4, locationEast5, locationEast6, locationSouth1, locationSouth2, locationSouth3, locationSouth4, locationSouth5, locationSouth6, locationWest1, locationWest2, locationWest3, locationWest4, locationWest5, locationWest6};
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &7Arena has begun!"));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &fZombies have been spawned!"));

                    for (int i = 1; i < 8; i++) {
                        int rnd = new Random().nextInt(locations.length);
                        Location location = locations[rnd];
                        Entity entity = location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
                    }
                    if (isStartedTwo) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &fSpiders have been spawned!"));

                                for (int i = 1; i < 10; i++) {
                                    int rnd = new Random().nextInt(locations.length);
                                    Location location = locations[rnd];
                                    Entity entity = location.getWorld().spawnEntity(location, EntityType.SPIDER);
                                }
                                if (isStartedTwo) {
                                    new BukkitRunnable() {
                                        Inventory currentInventory = player.getInventory();
                                        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);

                                        @Override
                                        public void run() {
                                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &fCreepers have been spawned!"));
                                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &bYou received a Diamond Sword!"));


                                            currentInventory.clear();
                                            currentInventory.addItem(diamondSword);
                                            for (int i = 1; i < 11; i++) {
                                                int rnd = new Random().nextInt(locations.length);
                                                Location location = locations[rnd];
                                                Entity entity = location.getWorld().spawnEntity(location, EntityType.CREEPER);
                                            }
                                            if (isStartedTwo) {
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &fSkeletons have been spawned!"));

                                                        for (int i = 1; i < 13; i++) {
                                                            int rnd = new Random().nextInt(locations.length);
                                                            Location location = locations[rnd];
                                                            Entity entity = location.getWorld().spawnEntity(location, EntityType.SKELETON);
                                                        }
                                                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&0&l=============================================\n&6&lGood job! \n&eAll you have to do is to kill the rest mobs and that's it, arena has been completed, gg!\nYou made " + coins + " coins!\n&0&l============================================="));
                                                    }
                                                }.runTaskLater(Bukkit.getPluginManager().getPlugin("ArenaPlugin"), 1000L);
                                            }
                                            }
                                    }.runTaskLater(Bukkit.getPluginManager().getPlugin("ArenaPlugin"), 700L);
                                }
                            }
                        }.runTaskLater(Bukkit.getPluginManager().getPlugin("ArenaPlugin"), 400L);
                    }

                } else {
                    if (countdownTime == 1) {
                        word = "second";
                    }
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &7Match starts in " + countdownTime + " " + word + "."));
                    countdownTime--;
                }
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("ArenaPlugin"), 100L, 20L);


        return true;

    }

    @EventHandler
    public void monsterDeath(EntityDeathEvent event) {
        isStarted = true;
        if (isStarted) {
            Player player = event.getEntity().getKiller();
            Entity entity = event.getEntity();
            if (entity instanceof Monster) {

                if (entity.getName().equalsIgnoreCase("Zombie")) {
                    coins += 5;
                    player.sendMessage(ChatColor.GREEN + "Zombie " + ChatColor.AQUA + "+5 coins");
                } else if (entity.getName().equalsIgnoreCase("Creeper")) {
                    coins += 10;
                    player.sendMessage(ChatColor.GREEN + "Creeper " + ChatColor.AQUA + "10 coins");
                } else if (entity.getName().equalsIgnoreCase("Skeleton")) {
                    coins += 15;
                    player.sendMessage(ChatColor.GREEN + "Skeleton " + ChatColor.AQUA + "+15 coins");
                } else if (entity.getName().equalsIgnoreCase("Spider")) {
                    coins += 7;
                    player.sendMessage(ChatColor.GREEN + "Spider " + ChatColor.AQUA + "+7 coins");
                }

            }
        }

    }

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {
        if (isStarted) {
            Player player = event.getPlayer();
            GameMode gamemode = player.getGameMode();
            if (gamemode.name().equalsIgnoreCase("SURVIVAL")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&eArena&6] &cYou can't break that block!"));
            }
        }
    }

    @EventHandler
    public void playerKill(PlayerDeathEvent event) {
        if (isStarted) {
            isStartedTwo = false;
            String deathMessage = event.getDeathMessage();
            event.setDeathMessage(ChatColor.GOLD + "§6[§eArena§6] §7" + ChatColor.YELLOW + deathMessage + ".");
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&0&l=============================================\n&6&lOh no! You died! \n&eSadly, arena has been stopped.\nYou made " + coins + " coins!\n&0&l============================================="));
            Bukkit.getWorld("world").getEntities().forEach(entity -> {
                if (!(entity instanceof Player)) {
                    entity.remove();
                }
            });
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (isStarted) {
            event.getDrops().clear();
        }
    }

}
