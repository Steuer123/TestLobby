package de.steuer.lobby;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import de.steuer.lobby.commands.SetCommand;
import de.steuer.lobby.listener.InventoryClickListener;
import de.steuer.lobby.listener.PlayerInteractListener;
import de.steuer.lobby.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    private Lobby instance;
    private String prefix = "§aLobby §r§8| §r";
    private String noperms = prefix + "§7Dazu hast du keine Rechte!";

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new PlayerInteractListener(), this);

        this.getCommand("setcitybuild").setExecutor(new SetCommand(this));

        Bukkit.getConsoleSender().sendMessage("§aPlugin gestartet, BY §eSTEUER");
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public Lobby getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoperms() {
        return noperms;
    }
}
