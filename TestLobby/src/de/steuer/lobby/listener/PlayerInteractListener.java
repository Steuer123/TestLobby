package de.steuer.lobby.listener;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import de.steuer.lobby.utils.InventoryManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getItem() == null || event.getItem().getType() != Material.COMPASS && !event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigator")) return;
        new InventoryManager().openNavigatorInventory(player);
    }

}
