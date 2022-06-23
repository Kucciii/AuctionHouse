package me.kucciii.auctionhouse.inventories;

import me.kucciii.auctionhouse.utilities.InventoryUtil;
import me.kucciii.auctionhouse.utilities.ItemBuilderUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AuctionsInv {
    private final Inventory inventory;
    private final InventoryUtil inventoryUtil = new InventoryUtil();

    public AuctionsInv() {
        inventory = Bukkit.createInventory(null, 36, "Auction House");
        ItemStack empty = new ItemBuilderUtil(Material.STAINED_GLASS_PANE, 1, (short) 15)
                .setDisplayName(" ")
                .toItemStack();
        ItemStack auctionBrowserItem = new ItemBuilderUtil(Material.GOLD_BLOCK)
                .setDisplayName("&6Auctions Browser")
                .setLore(
                        "&7Find items for sale by players",
                        "&7across Hypixel Skyblock!",
                        "",
                        "&7Items offered here are for",
                        "&6auction &7meaning you have to",
                        "&7place the top bid to acquire",
                        "&7them!",
                        "",
                        "&eClick to browse!"
                )
                .toItemStack();
        ItemStack viewBidsItem = new ItemBuilderUtil(Material.GOLDEN_CARROT)
                .setDisplayName("&eView Bids")
                .setLore(
                        "&7You don't have any outstanding",
                        "&7bids.",
                        "",
                        "&7Use the &6Auction Browser &7to",
                        "&7find some cool items."
                )
                .toItemStack();
        ItemStack createAuctionItem = new ItemBuilderUtil(Material.GOLD_BARDING)
                .setDisplayName("&aCreate Auction")
                .setLore(
                                "&7Set your own items on auction",
                                "&7for other players to purchase.",
                                "",
                                "&eClick to become rich!"
                        )
                .toItemStack();
        ItemStack closeItem = new ItemBuilderUtil(Material.BARRIER)
                .setDisplayName("&cClose")
                .toItemStack();
        ItemStack auctionStatsItem = new ItemBuilderUtil(Material.EMPTY_MAP)
                .setDisplayName("&aAuction Stats")
                .setLore(
                                "&7View various statistics about",
                                "&7you and your Auction House.",
                                "",
                                "&eClick to view!"
                        )
                .toItemStack();

        inventory.setItem(11, auctionBrowserItem);
        inventory.setItem(13, viewBidsItem);
        inventory.setItem(15, createAuctionItem);
        inventory.setItem(31, closeItem);
        inventory.setItem(32, auctionStatsItem);

        inventoryUtil.fillEmptySpaces(inventory, empty);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
