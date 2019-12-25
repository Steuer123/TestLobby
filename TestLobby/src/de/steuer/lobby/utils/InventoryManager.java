package de.steuer.lobby.utils;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryManager {

    public void openNavigatorInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, "§eNavigator");

        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).setName(" ").build());
        }

        inventory.setItem(4, new ItemBuilder(Material.GRASS, 1, 0).setName("§bCitybuild").setLore(" ", "§7Klick §8-> §7Teleport").build());

        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
        player.openInventory(inventory);
    }
}
