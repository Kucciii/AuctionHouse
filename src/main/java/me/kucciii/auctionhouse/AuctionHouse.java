package me.kucciii.auctionhouse;

import me.kucciii.auctionhouse.commands.AuctionHouseCmd;
import me.kucciii.auctionhouse.inventories.InventoryGUIListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuctionHouse extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getCommand("ah").setExecutor(new AuctionHouseCmd());
        getServer().getPluginManager().registerEvents(new InventoryGUIListener(), this);
    }
}
