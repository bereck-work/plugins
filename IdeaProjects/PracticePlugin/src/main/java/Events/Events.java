package Events;

import Modes.Nodebuff;
import Other.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public class Events implements Listener {



    @EventHandler
    public static void rankedFilter(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        String message = event.getMessage();

        boolean isProtected = false;
        int X = player.getLocation().getBlockX();
        int Y = player.getLocation().getBlockY();
        int Z = player.getLocation().getBlockZ();

        if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
            isProtected = true;
            System.out.println("Player is on spawn.");
        }
        if (isProtected) {


            if (message.toLowerCase(Locale.ROOT).equalsIgnoreCase("ranked")) {

                player.openInventory(RankedQueue.openRankedQueueInventory(player));

            } else if (message.toLowerCase(Locale.ROOT).equalsIgnoreCase("unranked")) {

                player.openInventory(UnrankedQueue.openUnrankedQueueInventory(player));

            }

        }

        if ((isProtected) && ((message.toLowerCase(Locale.ROOT).equalsIgnoreCase("ranked")) || (message.toLowerCase(Locale.ROOT).equalsIgnoreCase("unranked")))) {
            event.setCancelled(true);
        } else {
            event.setFormat(ChatColor.translateAlternateColorCodes('&', "&8<&7&lDefault&8> &f" + player.getDisplayName() + "&8> &f" + message));
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        OnLobbyJoin.executeOnLobbyJoin(event.getPlayer());
        event.setJoinMessage(ChatColor.YELLOW + "Welcome to Practice " + event.getPlayer().getDisplayName() + "!");
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {

        int X = event.getWhoClicked().getLocation().getBlockX();
        int Y = event.getWhoClicked().getLocation().getBlockY();
        int Z = event.getWhoClicked().getLocation().getBlockZ();
        boolean isProtected = false;
        // The highest point - 57, 124, 349
        // The lowest point - 75, 115, 331
        //Debuff arena
        // The highest point - 97, 123, 351
        // The lowest point - 81, 116, 329

        if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
            isProtected = true;
        }

        if (isProtected) {

            Player player = (Player) event.getWhoClicked();

            if (event.getClickedInventory().getTitle().equalsIgnoreCase("Unranked queue")) {

                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lNodebuff")) {
                    Nodebuff.nodebuffQueue(player);
                } else {
                    // something
                }
            }

            if (!(player.isOp())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {

        int X = event.getPlayer().getLocation().getBlockX();
        int Y = event.getPlayer().getLocation().getBlockY();
        int Z = event.getPlayer().getLocation().getBlockZ();
        boolean isProtected = false;
        // The highest point - 57, 124, 349
        // The lowest point - 75, 115, 331
        //Debuff arena
        // The highest point - 97, 123, 351
        // The lowest point - 81, 116, 329

        if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
            isProtected = true;
        } else if ((((X > 81) && (X < 97)) && ((Y > 116) && (Y < 123)) && ((Z > 329) && (Z < 352))))  {
            isProtected = true;
        }

        if (isProtected) {
            if (!(event.getPlayer().isOp())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§c§lHey! §7Sorry, but you can't break that block here.");
            }
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent event) {

        int X = event.getPlayer().getLocation().getBlockX();
        int Y = event.getPlayer().getLocation().getBlockY();
        int Z = event.getPlayer().getLocation().getBlockZ();
        boolean isProtected = false;
        // The highest point - 57, 124, 349
        // The lowest point - 75, 115, 331
        //Debuff arena
        // The highest point - 97, 123, 351
        // The lowest point - 81, 116, 329

        if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
            isProtected = true;
        } else if ((((X > 81) && (X < 97)) && ((Y > 116) && (Y < 123)) && ((Z > 329) && (Z < 352))))  {
            isProtected = true;
        }

        if (isProtected) {
            if (!(event.getPlayer().isOp())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void itemDrop(PlayerDropItemEvent event) {
        int X = event.getPlayer().getLocation().getBlockX();
        int Y = event.getPlayer().getLocation().getBlockY();
        int Z = event.getPlayer().getLocation().getBlockZ();
        boolean isProtected = false;
        // The highest point - 57, 124, 349
        // The lowest point - 75, 115, 331
        //Debuff arena
        // The highest point - 97, 123, 351
        // The lowest point - 81, 116, 329

        if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
            isProtected = true;
        }

        if (isProtected) {
            if (!(event.getPlayer().isOp())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§c§lHey! §7Sorry, but you can't drop items here.");
            }
        }
    }

    @EventHandler
    public void hungerRestore(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            int X = player.getLocation().getBlockX();
            int Y = player.getLocation().getBlockY();
            int Z = player.getLocation().getBlockZ();
            boolean isProtected = false;
            // The highest point - 57, 124, 349
            // The lowest point - 75, 115, 331
            //Debuff arena
            // The highest point - 97, 123, 351
            // The lowest point - 81, 116, 329

            if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
                isProtected = true;
            }

            if (isProtected) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void clickEvent(PlayerInteractEvent event) {
        int X = event.getPlayer().getLocation().getBlockX();
        int Y = event.getPlayer().getLocation().getBlockY();
        int Z = event.getPlayer().getLocation().getBlockZ();
        boolean isProtected = false;
        // The highest point - 57, 124, 349
        // The lowest point - 75, 115, 331
        //Debuff arena
        // The highest point - 97, 123, 351
        // The lowest point - 81, 116, 329

        if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
            isProtected = true;
        }

        if (isProtected) {
            if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || ((event.getAction().equals(Action.RIGHT_CLICK_AIR)))) {
                if (event.getMaterial().equals(Material.DIAMOND_SWORD)) {
                    event.getPlayer().openInventory(RankedQueue.openRankedQueueInventory(event.getPlayer()));
                } else if (event.getMaterial().equals(Material.IRON_SWORD)) {
                    event.getPlayer().openInventory(UnrankedQueue.openUnrankedQueueInventory(event.getPlayer()));
                } else if (event.getMaterial().equals(Material.BARRIER)) {
                    if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
                        OnLobbyJoin.executeClearingAndSettingUpInventory(event.getPlayer());
                        event.getPlayer().sendMessage("§e§lPractice §8▶ §cYou have left your queue!");
                        if (Nodebuff.nodebuffQueueList.contains(event.getPlayer())) {
                            Nodebuff.nodebuffQueueList.remove(event.getPlayer());
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public static void playerLeave(PlayerQuitEvent event) {
        int X = event.getPlayer().getLocation().getBlockX();
        int Y = event.getPlayer().getLocation().getBlockY();
        int Z = event.getPlayer().getLocation().getBlockZ();
        boolean isProtected = false;
        if ((((X > 81) && (X < 97)) && ((Y > 116) && (Y < 123)) && ((Z > 329) && (Z < 352))))  {
            isProtected = true;
        }

        event.setQuitMessage(null);
        if (Nodebuff.nodebuffQueueList.contains(event.getPlayer())) {
            Nodebuff.nodebuffQueueList.remove(event.getPlayer());
        }
    }

    @EventHandler
    public static void antiPvP(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            int X = player.getLocation().getBlockX();
            int Y = player.getLocation().getBlockY();
            int Z = player.getLocation().getBlockZ();
            boolean isProtected = false;
            // The highest point - 57, 124, 349
            // The lowest point - 75, 115, 331
            //Debuff arena
            // The highest point - 97, 123, 351
            // The lowest point - 81, 116, 329

            if ((((X > 57) && (X < 75)) && ((Y > 115) && (Y < 124)) && ((Z > 331) && (Z < 349)))) {
                isProtected = true;
            }

            if (isProtected) {
                event.setCancelled(true);
            }
        }
    }

    private static HashMap<UUID, Long> pearlCooldown = new HashMap<UUID, Long>();
    private static int pearlCooldownTime = 10;

    @EventHandler
    public static void pearlThrow(ProjectileLaunchEvent event) {
        ItemStack enderPearl = new ItemStack(Material.ENDER_PEARL, 1);
        if (event.getEntity() instanceof EnderPearl) {
            if (event.getEntity().getShooter() instanceof Player) {
                Player player = (Player) event.getEntity().getShooter();
                if (!(player.isOp())) {
                    if (pearlCooldown.containsKey(player.getUniqueId())) {
                        long secondsLeft = ((pearlCooldown.get(player.getUniqueId()) / 1000) + pearlCooldownTime) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            player.getInventory().addItem(enderPearl);
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &8▶ &cYou can't use that again yet! You must wait " + secondsLeft + " seconds"));
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&7Cooldown: &e&l" + secondsLeft + " &eseconds"));
                            actionBar.sendToPlayer(player);
                        } else {
                            pearlCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        }
                    } else {
                        pearlCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    }
                }
            }
        }


    }

    @EventHandler
    public static void projectileFall(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof Player))  {
            Player player = (Player) event.getEntity().getShooter();
            Location playersLocation = player.getLocation();
            World world = Bukkit.getWorld("world");
            int playerY = playersLocation.getBlockY();
            int playerZ = playersLocation.getBlockZ();
            int playerX = playersLocation.getBlockX();
            float playerYaw = playersLocation.getYaw();
            float playerPitch = playersLocation.getPitch();
            Location newPlayerLocation = new Location(world, playerX, playerY-1.0, playerZ, playerYaw, playerPitch);
            int Y = event.getEntity().getLocation().getBlockY();
            int Z = event.getEntity().getLocation().getBlockZ();
            int X = event.getEntity().getLocation().getBlockX();
            int potentialBarrierBlock = Y + 1;
            Location location = new Location(world, X, potentialBarrierBlock, Z);
            if ((location.getBlock().getType().equals(Material.BARRIER)) || (event.getEntity().getLocation().getBlock().getType().equals(Material.BARRIER))) {
                player.teleport(newPlayerLocation);
            }
        }

    }

    @EventHandler
    public static void antiMobSpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof Player))  {
            event.setCancelled(true);
        }
    }


}
