package de.lp4.roleplay.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class setwardenspawntime implements CommandExecutor {
    
    Plugin plugin;
    
    public setwardenspawntime(Plugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("roleplay.setwardenspawntime")) {
            if (args.length == 1) {
                try {
                    int time = Integer.parseInt(args[0]);
                    plugin.getConfig().set("warden-spawn-time", time);
                    plugin.saveConfig();
                    sender.sendMessage("§aSuccessfully set the warden spawn time to " + time + " seconds.");
                } catch (NumberFormatException e) {
                    sender.sendMessage("§cPlease enter a valid number.");
                }
            } else {
                sender.sendMessage("§cUsage: /setwardenspawntime <time>");
            }
        } else {
            sender.sendMessage("§cYou do not have permission to use this command.");
        }
        return true;
    }
}
