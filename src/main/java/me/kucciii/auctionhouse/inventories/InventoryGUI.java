package me.kucciii.auctionhouse.inventories;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class InventoryGUI {
    @Getter private final Inventory inventory;
    @Getter private static final Map<UUID, InventoryGUI> inventoriesByUUID = new HashMap<>();
    @Getter public static final Map<UUID, UUID> openInventories = new HashMap<>();
    @Getter private final UUID inventoryUUID;
    @Getter private final Map<Integer, GUIAction> actions;

    public InventoryGUI(int size, String title) {
        inventoryUUID = UUID.randomUUID();
        inventory = Bukkit.createInventory(null, size, title);
        actions = new HashMap<>();
        inventoriesByUUID.put(getInventoryUUID(), this);
    }

    public void setItem(int slot, ItemStack stack, GUIAction action){
        inventory.setItem(slot, stack);
        if (action == null) return;
        actions.put(slot, action);
    }

    public void setItem(int slot, ItemStack stack){
        setItem(slot, stack, null);
    }

    public void open(Player p){
        p.openInventory(inventory);
        openInventories.put(p.getUniqueId(), getInventoryUUID());
    }

    public void delete(){
        Bukkit.getOnlinePlayers().forEach(player -> {
            UUID u = openInventories.get(player.getUniqueId());
            if (!u.equals(getInventoryUUID())) return;
            player.closeInventory();
        });
        inventoriesByUUID.remove(getInventoryUUID());
    }

    public interface GUIAction {
        void click(Player player);
    }
}
