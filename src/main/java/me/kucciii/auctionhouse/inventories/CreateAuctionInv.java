package me.kucciii.auctionhouse.inventories;

import me.kucciii.auctionhouse.utilities.ItemBuilderUtil;
import org.bukkit.Material;

public class CreateAuctionInv extends InventoryGUI{

    public CreateAuctionInv() {
        super(54, "Create Auction");

        setItem(9,
                new ItemBuilderUtil(Material.STONE_BUTTON)
                        .setDisplayName("&eClick an item in your inventory!")
                        .setLore("&7Selects it for auction.")
                        .toItemStack(),
                new AuctionInv()::open
                );
    }
}
