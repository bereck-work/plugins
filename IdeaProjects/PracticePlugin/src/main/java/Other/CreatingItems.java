package Other;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Arrays;

public class CreatingItems {

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
        meta.spigot().setUnbreakable(true);
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


}
