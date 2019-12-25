package de.steuer.lobby.listener;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import de.steuer.lobby.Lobby;
import de.steuer.lobby.utils.LocationManager;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    @Deprecated
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
        if(event.getClickedInventory().getTitle().equalsIgnoreCase("§eNavigator")) {
            if(event.getCurrentItem().getType() == Material.GRASS) {
                if(!event.getCurrentItem().hasItemMeta()) return;
                if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCitybuild")) {
                    player.closeInventory();
                    try {
                        player.teleport(LocationManager.getLocation("cb"));
                        player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        player.playEffect(player.getLocation().add(0.0D, 1.0D, 0.0D), Effect.ENDER_SIGNAL, 20);
                    } catch (Exception e) {
                        player.sendMessage(new Lobby().getPrefix() + "§7Der §bCITYBUILD §7Spawn wurde noch nicht gesetzt!");
                    }
                }
            }
        }
    }
}
