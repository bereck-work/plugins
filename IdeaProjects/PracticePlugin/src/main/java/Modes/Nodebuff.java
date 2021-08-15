package Modes;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import Other.CreatingItems.*;

import static Other.CreatingItems.*;

public class Nodebuff {

    public static ArrayList<Player> nodebuffQueueList = new ArrayList<Player>();
    public static ArrayList<Player> nodebuffCurrentlyFightingList = new ArrayList<Player>();

    public static void nodebuffQueue(Player player) {

        player.closeInventory();
        player.getInventory().clear();
        Inventory i = player.getInventory();
        player.sendMessage("§e§lPractice §8▶ §6Waiting for an opponent in §a§lNodebuff queue");
        i.setItem(8, createItem(Material.BARRIER, "§c§lLeave Queue §7▶ §fRight Click", new String[]{}));
        nodebuffQueueList.add(player);
        int nodebuffQueueListSize = nodebuffQueueList.size();
        if (nodebuffQueueListSize % 2 == 0) {
            startNodebuff(nodebuffQueueList.get(0), nodebuffQueueList.get(1));
            nodebuffQueueList.remove(0);
            nodebuffQueueList.remove(1);
        }


    }


    public static void startNodebuff(Player player1, Player player2) {


        player1.closeInventory();
        player2.closeInventory();

        player1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &7▶ &91v1 against " + player2.getDisplayName()));
        player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &7▶ &91v1 against " + player1.getDisplayName()));

        World world = Bukkit.getWorld("world");
        Location NodebuffLocation_Player1 = new Location(world, 92.500, 117, 346.500, (float)157.0, (float)-0.1);
        Location NodebuffLocation_Player2 = new Location(world, 87.500, 117, 334.500, (float)-22.2, (float)-0.1);

        player1.teleport(NodebuffLocation_Player1);
        player2.teleport(NodebuffLocation_Player2);

        player1.getInventory().clear();
        player2.getInventory().clear();

        Inventory player1Inventory = player1.getInventory();
        Inventory player2Inventory = player2.getInventory();

        // Debuff kit
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
        ItemStack pearls = new ItemStack(Material.ENDER_PEARL, 16);
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);

        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        helmet.addEnchantment(Enchantment.DURABILITY, 3);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplate.addEnchantment(Enchantment.DURABILITY, 3);
        leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        leggings.addEnchantment(Enchantment.DURABILITY, 3);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addEnchantment(Enchantment.DURABILITY, 3);
        boots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
        diamondSword.addEnchantment(Enchantment.DURABILITY, 3);
        diamondSword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        diamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 2);

        ItemStack[] armor = {boots, leggings, chestplate, helmet};

        ItemStack splashHeal = new ItemStack(Material.POTION, 1);
        Potion splashHealPot = new Potion(1);
        splashHealPot.setSplash(true);
        splashHealPot.setType(PotionType.INSTANT_HEAL);
        splashHealPot.setLevel(2);
        splashHealPot.apply(splashHeal);

        ItemStack fireRes = new ItemStack(Material.POTION, 1);
        Potion fireResPot = new Potion(1);
        fireResPot.setSplash(false);
        fireResPot.setType(PotionType.FIRE_RESISTANCE);
        fireResPot.setLevel(1);
        fireResPot.apply(fireRes);

        ItemStack speed = new ItemStack(Material.POTION, 1);
        Potion speedPot = new Potion(1);
        speedPot.setSplash(false);
        speedPot.setType(PotionType.SPEED);
        speedPot.setLevel(2);
        speedPot.apply(speed);

        for (int i=0;i<36;i++) {
            player1Inventory.setItem(i, splashHeal);
        }

        player1Inventory.setItem(0, diamondSword);
        player1Inventory.setItem(1, pearls);
        player1Inventory.setItem(2, fireRes);
        player1Inventory.setItem(3, speed);
        player1Inventory.setItem(8, steak);
        player1Inventory.setItem(17, speed);
        player1Inventory.setItem(26, speed);
        player1Inventory.setItem(35, speed);
        player1.getInventory().setArmorContents(armor);

        for (int i=0;i<36;i++) {
            player2Inventory.setItem(i, splashHeal);
        }

        player2Inventory.setItem(0, diamondSword);
        player2Inventory.setItem(1, pearls);
        player2Inventory.setItem(2, fireRes);
        player2Inventory.setItem(3, speed);
        player2Inventory.setItem(8, steak);
        player2Inventory.setItem(17, speed);
        player2Inventory.setItem(26, speed);
        player2Inventory.setItem(35, speed);
        player2.getInventory().setArmorContents(armor);


        new BukkitRunnable() {
            int countdownTime = 4;
            @Override
            public void run() {
                if (countdownTime == 0) {
                    player1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &8▶ &cGO!"));
                    player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &8▶ &cGO!"));
                    this.cancel();
                } else {
                    player1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &8▶ &6Your match is starting in &e&l" + countdownTime + " &6seconds!"));
                    player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lPractice &8▶ &6Your match is starting in &e&l" + countdownTime + " &6seconds!"));
                    countdownTime -= 1;
                }
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("PracticePlugin"), 0L, 20L);

    }


}

//TODO: Add pearl cooldown, fix broken splash potion when slecting Debuff