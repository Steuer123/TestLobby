package de.steuer.lobby.listener;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import de.steuer.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(!player.getInventory().contains(Material.COMPASS)) {
            player.getInventory().setItem(0, new ItemBuilder(Material.COMPASS, 1, 0).setName("§aNavigator").build());
        }

        event.setJoinMessage(null);
    }
}
