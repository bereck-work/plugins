package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        ItemStack kill = new ItemStack(Material.TNT, 1);
        ItemStack feed = new ItemStack(Material.BREAD, 1);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);

        ItemMeta killMeta = kill.getItemMeta();
        killMeta.setDisplayName(ChatColor.GOLD + "Kill");
        ArrayList<String> killLore = new ArrayList<>();
        killLore.add("Kill yourself.");
        killMeta.setLore(killLore);
        kill.setItemMeta(killMeta);

        ItemMeta feedMeta = feed.getItemMeta();
        feedMeta.setDisplayName(ChatColor.GOLD + "Feed");
        ArrayList<String> feedLore = new ArrayList<>();
        feedLore.add("Feed yourself.");
        feedMeta.setLore(feedLore);
        feed.setItemMeta(feedMeta);

        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.GOLD + "Sword");
        ArrayList<String> swordLore = new ArrayList<>();
        swordLore.add("Receive a Diamond Sword.");
        swordMeta.setLore(swordLore);
        sword.setItemMeta(swordMeta);

        ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 8);
        ItemMeta paneMeta = glassPane.getItemMeta();
        paneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a"));
        glassPane.setItemMeta(paneMeta);

        ItemStack[] menuItems = {kill, feed, sword};
        Inventory gui = Bukkit.createInventory(player, 9, "Menu");
        gui.setContents(menuItems);
        player.openInventory(gui);


        return true;
    }
}
