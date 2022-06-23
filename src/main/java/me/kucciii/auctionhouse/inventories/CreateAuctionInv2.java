package me.kucciii.auctionhouse.inventories;

import me.kucciii.auctionhouse.utilities.InventoryUtil;
import me.kucciii.auctionhouse.utilities.ItemBuilderUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateAuctionInv2 {
    private Inventory inventory;
    private final InventoryUtil inventoryUtil = new InventoryUtil();

    public CreateAuctionInv2() {
        inventory = Bukkit.createInventory(null, 54, "Create Auction");
        ItemStack empty = new ItemBuilderUtil(Material.STAINED_GLASS_PANE, 1, (short) 15)
                .setDisplayName(" ")
                .toItemStack();
        ItemStack chooseItem = new ItemBuilderUtil(Material.STONE_BUTTON)
                .setDisplayName("&eClick an item in your inventory!")
                .setLore("&7Selects it for auction.")
                .toItemStack();
        ItemStack createAuctionItem = new ItemBuilderUtil(Material.STAINED_CLAY, 1, (short) 14)
                .setDisplayName("&cCreate Auction")
                .setLore(
                        "&7No Item Selected!",
                        "",
                        "&7Click an item in your inventory",
                        "&7to select it for this auction."
                )
                .toItemStack();
        ItemStack auctionBidItem = new ItemBuilderUtil(Material.POWERED_RAIL)
                .setDisplayName("&fStarting bid: &6500 coins")
                .setLore(
                        "&7The minimum price a player can",
                        "&7offer to obtain your item.",
                        "",
                        "&7Once a player bids for your",
                        "&7item, other players will have",
                        "&7until the auction ends to make a",
                        "&7higher bid.",
                        "",
                        "&7Extra Fee: &6+25 Coins &e(5%)",
                        "",
                        "&eClick to edit!"
                )
                .toItemStack();
        ItemStack auctionDurationItem = new ItemBuilderUtil(Material.WATCH)
                .setDisplayName("&fDuration: &e6 Hours")
                .setLore(
                        "&7How long players will be able to",
                        "&7place bids for.",
                        "",
                        "&7Note: Bids Automatically",
                        "&7increase the duration of",
                        "&7auctions.",
                        "",
                        "&7Extra Fee: &6+45 Coins"
                )
                .toItemStack();
        ItemStack switchAuctionTypeItem = new ItemBuilderUtil(Material.GOLD_INGOT)
                .setDisplayName("&aSwitch to BIN")
                        .setLore(
                                "&7BIN Auctions are simple.",
                                "",
                                "&7Set a price, then one player may",
                                "&7buy the item at that price.",
                                "",
                                "&8(BIN means Buy It Now)",
                                "",
                                "&eClick to switch!"
                        )
                .toItemStack();
        ItemStack goBackItem = new ItemBuilderUtil(Material.ARROW)
                .setDisplayName("&aGo Back")
                .setLore("&7To Auction House")
                .toItemStack();

        inventory.setItem(13, chooseItem);
        inventory.setItem(29, createAuctionItem);
        inventory.setItem(31, auctionBidItem);
        inventory.setItem(33, auctionDurationItem);
        inventory.setItem(48, switchAuctionTypeItem);
        inventory.setItem(49, goBackItem);

        inventoryUtil.fillEmptySpaces(inventory, empty);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
