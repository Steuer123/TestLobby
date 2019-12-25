package de.steuer.lobby.utils;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import de.steuer.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationManager {

    private static FileConfiguration cfg = new Lobby().getInstance().getConfig();

    public static void setLocation(String name, Location loc) {
        String path = "Location." + name.toUpperCase() + ".";
        cfg.set(path + "World", loc.getWorld().getName());
        cfg.set(path + "X", loc.getX());
        cfg.set(path + "Y", loc.getY());
        cfg.set(path + "Z", loc.getZ());
        cfg.set(path + "Yaw", loc.getYaw());
        cfg.set(path + "Pitch", loc.getPitch());
        new Lobby().getInstance().saveConfig();
    }

    public static Location getLocation(String name) {
        String path = "Location." + name.toUpperCase() + ".";
        World world = Bukkit.getWorld(cfg.getString(path + "World"));
        double x = cfg.getDouble(path + "X");
        double y = cfg.getDouble(path + "Y");
        double z = cfg.getDouble(path + "Z");
        float yaw = (float) cfg.getDouble(path + "Yaw");
        float pitch = (float) cfg.getDouble(path + "Pitch");

        Location loc = new Location(world, x, y, z, yaw, pitch);
        return loc;
    }
}
