package me.kucciii.auctionhouse.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class InventoryGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        UUID inventoryUUID = InventoryGUI.openInventories.get(playerUUID);

        if (inventoryUUID == null) return;
        InventoryGUI gui = InventoryGUI.getInventoriesByUUID().get(inventoryUUID);
        InventoryGUI.GUIAction action = gui.getActions().get(event.getSlot());

        if (action == null) return;
        action.click(player);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        InventoryGUI.openInventories.remove(playerUUID);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        InventoryGUI.openInventories.remove(playerUUID);
    }
}
