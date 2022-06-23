package me.kucciii.auctionhouse.utilities;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilderUtil {
    private final ItemStack is;

    public ItemBuilderUtil(ItemStack itemStack) {
        is = itemStack;
    }

    public ItemBuilderUtil(Material material) {
        this(material, 1);
    }

    public ItemBuilderUtil(Material material, int amount) {
        is = new ItemStack(material, amount);
    }

    public ItemBuilderUtil(Material material, int amount, short ID) {
        is = new ItemStack(material, amount,ID);
    }

    public ItemBuilderUtil setDisplayName(String displayName) {
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        is.setItemMeta(meta);
        return this;
    }

    public ItemBuilderUtil hideAttributes() {
        ItemMeta meta = is.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName("");
        return this;
    }

    public ItemBuilderUtil setLore(String... lore) {
        ItemMeta meta = is.getItemMeta();
        List<String> colouredLore = new ArrayList<>();
        Arrays.asList(lore).forEach(line -> {
            colouredLore.add(ChatColor.translateAlternateColorCodes('&', line));
        });
        meta.setLore(colouredLore);
        is.setItemMeta(meta);
        return this;
    }

    public ItemBuilderUtil setArmorColor(Color color) {
        try {
            LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta();
            meta.setColor(color);
            is.setItemMeta(meta);
        } catch (ClassCastException e) {}
        return this;
    }


    public ItemStack toItemStack() {
        return is;
    }
}

