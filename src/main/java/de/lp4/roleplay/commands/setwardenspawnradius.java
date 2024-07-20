package de.lp4.roleplay.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class setwardenspawnradius implements CommandExecutor {
    Plugin plugin;
    
    public setwardenspawnradius(Plugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("roleplay.setwardenspawnradius")) {
            if(args.length == 1){
                try {
                    int radius = Integer.parseInt(args[0]);
                    plugin.getConfig().set("warden-spawn-radius", radius);
                    plugin.saveConfig();
                    sender.sendMessage("§aSuccessfully set the warden spawn radius to " + radius + " blocks.");
                } catch (NumberFormatException e) {
                    sender.sendMessage("§cPlease enter a valid number.");
                }
            } else {
                sender.sendMessage("§cUsage: /setwardenspawnradius <radius>");
            }
        }
        return true;
    }
}
