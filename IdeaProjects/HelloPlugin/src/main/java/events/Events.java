package events;

import com.EpicPlayer.HelloPlugin.HelloPlugin;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import com.EpicPlayer.HelloPlugin.HelloPlugin.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import events.Events;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.*;


public class Events implements Listener {

    FileConfiguration config = HelloPlugin.getInstance().getConfig();
    static int block_counter = 0;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();
        Location location = new Location(world, 5.500, 68, 337.500);
        player.teleport(location);

        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server " + player.getDisplayName() + "! \n" + ChatColor.YELLOW + "Have a good time here!");
    }

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block = player.getWorld().getBlockAt(x, y - 1, z).getType();

        if (block == Material.DIAMOND_BLOCK) {
            block_counter++;
            player.sendMessage(ChatColor.GREEN + "You are standing on Diamond Block! " + ChatColor.AQUA + "#" + block_counter);
            if (block_counter % 100 == 0) {
                ItemStack gold_ingot = new ItemStack(Material.GOLD_INGOT, 1);
                Inventory inv = player.getInventory();
                inv.addItem(gold_ingot);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou received x1 Gold Ingot!"));
            }
        } else if (block == Material.GOLD_BLOCK) {
            block_counter++;
            player.sendMessage(ChatColor.GREEN + "You are standing on Gold Block! " + ChatColor.AQUA + "#" + block_counter);
            if (block_counter % 100 == 0) {
                ItemStack gold_ingot = new ItemStack(Material.GOLD_INGOT, 1);
                Inventory inv = player.getInventory();
                inv.addItem(gold_ingot);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou received x1 Gold Ingot!"));
            }
        }

    }

    public static ItemStack createItem(final Material material, final String name, final String[] fakeItemLore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> itemLore = new ArrayList<>();
        for (String row: fakeItemLore) {
           itemLore.add(row);
        }
        meta.setLore(Arrays.asList(fakeItemLore));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemByte(final Material material, final byte byt, final String name, final String[] fakeItemLore) {
        final ItemStack item = new ItemStack(material, 1, byt);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> itemLore = new ArrayList<>();
        for (String row: fakeItemLore) {
            itemLore.add(row);
        }
        meta.setLore(Arrays.asList(fakeItemLore));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createPotion(final PotionType potionType, final int level, final boolean isSplash, final String name, final String[] fakeItemLore) {
        ItemStack potion = new ItemStack(Material.POTION, 1);
        Potion pot = new Potion(1);
        pot.setSplash(isSplash);
        pot.setType(potionType);
        pot.setLevel(level);
        pot.apply(potion);

        ItemMeta itemMeta = potion.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        ArrayList<String> itemLore = new ArrayList<>();
        for (String row: fakeItemLore) {
            itemLore.add(row);
        }
        itemMeta.setLore(Arrays.asList(fakeItemLore));
        potion.setItemMeta(itemMeta);

        return potion;
    }


    @EventHandler
    public static void swearFilter(AsyncPlayerChatEvent event) {
        String[] swear_words = {"shit", "fuck", "bitch"};
        String message = event.getMessage();
        Player player = event.getPlayer();

        boolean found = false;

        for (String word : swear_words) {

            if (message.toLowerCase().contains(word.toLowerCase())) {
                found = true;
            }
        }


        if (found == true) {
            if (!(player.hasPermission("HelloPlugin.bypass"))) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("HelloPlugin.bypass")) {
                        p.sendMessage("§6[§eHelloPlugin§6] §c" + player.getDisplayName() + " said §4\"" + message + "\", §cluckily his message got filtered.");
                    }
                }
                player.sendMessage("§6[§eHelloPlugin§6] §cDon't swear.");
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8<&7&lDefault&8> &f" + player.getDisplayName() + "&8> &f" + message));
            }

        } else if (message.toLowerCase(Locale.ROOT).equalsIgnoreCase("ranked")) {

            Inventory inventory = Bukkit.createInventory(player, 54, "Ranked Queue");
            inventory.setItem(10, createItem(Material.DIAMOND_SWORD, "§c§lInformation", new String[]{"Get information I guess."}));
            inventory.setItem(12, createPotion(PotionType.STRENGTH, 1, true, "§c§lNodebuff", new String[]{"Play nodebuff.", "lol"}));
            inventory.setItem(13, createPotion(PotionType.POISON, 1, true, "§c§lDebuff", new String[]{"Play nodebuff."}));
            inventory.setItem(14, createItem(Material.GOLDEN_APPLE, "§c§lGapple", new String[]{"Play gapple."}));
            inventory.setItem(15, createItem(Material.LAVA_BUCKET, "§c§lBuildUHC", new String[]{"Play builduhc."}));
            inventory.setItem(16, createItemByte(Material.RAW_FISH, (byte)3, "§c§lCombo", new String[]{"Play combo.", "Click to start the match!", "Good luck."}));
            inventory.setItem(19, createItem(Material.EMERALD, "§c§lEloranks", new String[]{"Get eloranks information."}));
            inventory.setItem(21, createItem(Material.DIAMOND_AXE, "§c§lAxePvP", new String[]{"Play axepvp."}));
            inventory.setItem(22, createItem(Material.LEASH, "§c§lSumo", new String[]{"Break your keyboard against 400ms asian guy."}));
            inventory.setItem(23, createItem(Material.ENCHANTMENT_TABLE, "§c§lEnchant", new String[]{"Play enchant."}));
            inventory.setItem(24, createItem(Material.BOW, "§c§lArcher", new String[]{"Play archer."}));
            inventory.setItem(25, createItem(Material.FLINT_AND_STEEL, "§c§lSG", new String[]{"Play sg."}));
            inventory.setItem(28, createItem(Material.BOOKSHELF, "§c§lYour ranked stats", new String[]{"View your ranked stats."}));
            inventory.setItem(30, createItem(Material.FENCE, "§c§lHCF", new String[]{"Play hcf."}));
            inventory.setItem(31, createItem(Material.BROWN_MUSHROOM, "§c§lSoup", new String[]{"Play soup."}));
            inventory.setItem(32, createItem(Material.BED, "§c§lBedwars", new String[]{"Play bedwars against 500ms", "asian and break your table."}));
            inventory.setItem(37, createItem(Material.ENCHANTMENT_TABLE, "§c§lRanked leaderboards", new String[]{"Get ranked leaderboards."}));
            player.openInventory(inventory);

        } else {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8<&7&lDefault&8> &f" + player.getDisplayName() + "&8> &f" + message));
        }
        event.setCancelled(true);
    }

    @EventHandler
    public static void onWeatherChange(ThunderChangeEvent event) {
        event.setCancelled(true);
        Bukkit.broadcastMessage("§6[§eHelloPlugin§6] §bWeather changed!");

    }

    @EventHandler
    public static void entityKill(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        Entity entity = event.getEntity();
        if (entity instanceof Monster) {
            killer.sendMessage(ChatColor.GREEN + "You killed " + entity.getName() + "! You got 0.5 hp and 1 hunger bar.");
            double killersHealth = killer.getHealth();
            killer.setHealth(killersHealth + 0.5);
            int killersHunger = killer.getFoodLevel();
            killer.setFoodLevel(killersHunger + 2);
        }
    }

    @EventHandler
    public static void playerKill(PlayerDeathEvent event) {
        String deathMessage = event.getDeathMessage();
        event.setDeathMessage(ChatColor.GOLD + "§lOh no! " + ChatColor.YELLOW + deathMessage + ".");
    }

    @EventHandler
    public static void achievementEvent(PlayerAchievementAwardedEvent event) {
        Player player = event.getPlayer();
        Achievement achi = event.getAchievement();
        player.sendMessage(ChatColor.GOLD + "§lWoohoo! " + ChatColor.YELLOW + "You have completed an achievement and received x1 Diamond sword!");
        PlayerInventory inventory = event.getPlayer().getInventory();
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        inventory.addItem(sword);
    }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        Player player = event.getPlayer();
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "See ya " + player.getDisplayName() + "! \n" + ChatColor.YELLOW + "We hope you had good time!");
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equalsIgnoreCase("Menu")) {
            if (!(event.getClickedInventory().equals(InventoryType.PLAYER))) {
                switch (event.getCurrentItem().getType()) {
                    case TNT:
                        player.closeInventory();
                        player.setHealth(0.0);
                        break;
                    case BREAD:
                        player.closeInventory();
                        player.setFoodLevel(20);
                        player.sendMessage("§6[§eHelloPlugin§6] §bYou have been feeded.");
                        break;
                    case DIAMOND_SWORD:
                        player.closeInventory();
                        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
                        player.getInventory().addItem(diamondSword);
                        player.sendMessage("§6[§eHelloPlugin§6] §bYou received a Diamond Sword.");
                        break;
                }
            }
            event.setCancelled(true);
        } else if (event.getInventory().getTitle().equalsIgnoreCase("Ranked Queue")) {
            event.setCancelled(true);
        }


    }

}
