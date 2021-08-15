package Other;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import static Other.CreatingItems.*;

public class OnLobbyJoin {

    public static void executeOnLobbyJoin(Player player) {
        executeTeleporting(player);
        executeClearingAndSettingUpInventory(player);
    }

    public static void executeTeleporting(Player player) {

        World world = Bukkit.getWorld("world");
        Location location = new Location(world, 66.500, 117, 340.500);
        player.teleport(location);
    }

    public static void executeClearingAndSettingUpInventory(Player player) {
        player.setExp(0);
        GameMode gamemode = GameMode.SURVIVAL;
        player.setGameMode(gamemode);
        player.getInventory().setHeldItemSlot(0);
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        for (PotionEffect potion: player.getActivePotionEffects()) {
            player.removePotionEffect(potion.getType());
        }
        ItemStack[] emptyStack = {null, null, null, null};
        player.getInventory().setArmorContents(emptyStack);

        Inventory i = player.getInventory();
        i.clear();

        // Creating special items - Diamond sword, Iron sword, Gold Axe
        ItemStack diamondSword = createItem(Material.DIAMOND_SWORD, "§e§lPlay Ranked §7▶ §fRight Click", new String[]{});
        ItemStack ironSword = createItem(Material.IRON_SWORD, "§e§lPlay Unranked §7▶ §fRight Click", new String[]{});
        ItemStack goldAxe = createItem(Material.GOLD_AXE, "§e§lCreate a Party §7▶ §fRight Click", new String[]{});

        ItemStack[] specialItemsArray = {diamondSword, ironSword, goldAxe};

        for (ItemStack item: specialItemsArray) {
            ItemMeta specialItemMeta = item.getItemMeta();
            specialItemMeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            specialItemMeta.spigot().setUnbreakable(true);
            item.setItemMeta(specialItemMeta);
        }

        i.setItem(0, ironSword);
        i.setItem(1, diamondSword);
        i.setItem(2, goldAxe);
        i.setItem(4, createItem(Material.ENCHANTMENT_TABLE, "§e§lStatistics §7▶ §fRight Click", new String[]{}));
        i.setItem(6, createItem(Material.CHEST, "§e§lCosmetics §7▶ §fRight Click", new String[]{}));
        i.setItem(7, createItem(Material.SIGN, "§e§lHost Events §7▶ §fRight Click", new String[]{}));
        i.setItem(8, createItem(Material.REDSTONE_COMPARATOR, "§e§lSettings §7▶ §fRight Click", new String[]{}));

    }


}
