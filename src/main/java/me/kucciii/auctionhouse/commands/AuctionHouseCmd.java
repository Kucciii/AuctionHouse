package me.kucciii.auctionhouse.commands;

import me.kucciii.auctionhouse.inventories.AuctionInv;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionHouseCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        AuctionInv auctionInv = new AuctionInv();
        auctionInv.open(player);

        return true;
    }
}
