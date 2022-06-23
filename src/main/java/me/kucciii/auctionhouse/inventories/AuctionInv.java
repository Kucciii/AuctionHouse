package me.kucciii.auctionhouse.inventories;

import me.kucciii.auctionhouse.utilities.ItemBuilderUtil;
import org.bukkit.Material;

public class AuctionInv extends InventoryGUI{
    public AuctionInv() {
        super(36, "Auction House");

        setItem(13,
                new ItemBuilderUtil(Material.GOLD_BLOCK)
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
                        .toItemStack(),
                new CreateAuctionInv()::open
                );
    }
}
