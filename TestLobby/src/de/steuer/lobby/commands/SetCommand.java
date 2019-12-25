package de.steuer.lobby.commands;
/*
    CREATED BY STEUER on 24.12.2019.
    THE COPYING OF THIS PLUGIN IS FORBIDDEN!
*/


import de.steuer.lobby.Lobby;
import de.steuer.lobby.utils.LocationManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    Lobby lobby;

    public SetCommand(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(lobby.getPrefix() + "§7Du musst ein Spieler sein!");
            return true;
        }
        Player player = (Player) commandSender;
        if(args.length == 0) {
            Location loc = player.getLocation();
            LocationManager.setLocation("cb", loc);

            player.sendMessage(lobby.getPrefix() + "§7Du hast den §bCITYBUILD §7Spawn gesetzt!");

        } else
            player.sendMessage(lobby.getPrefix() + "§7Benutze §8-> §e/setcitybuild");

        return false;
    }
}
