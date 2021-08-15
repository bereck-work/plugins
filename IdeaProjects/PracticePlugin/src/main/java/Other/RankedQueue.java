package Other;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Arrays;

import static Other.CreatingItems.*;

public class RankedQueue {



    public static Inventory openRankedQueueInventory(Player player) {
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
        return inventory;
    }


}
