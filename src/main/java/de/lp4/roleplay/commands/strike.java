package de.lp4.roleplay.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class strike implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        
        if (sender.hasPermission("roleplay.strike")) {
            if (args.length == 1) {
                if(Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage("§cThe player §4" + args[0] + " §cis not online.");
                    return true;
                }
                sender.sendMessage("§aSuccessfully struck §2" + args[0] + "§a with lightning.");
                Bukkit.getPlayer(args[0]).getWorld().strikeLightning(Bukkit.getPlayer(args[0]).getLocation());
            } else {
                sender.sendMessage("§cUsage: /strike <player>");
            }
        } else {
            sender.sendMessage("§cYou do not have permission to use this command.");
        }
        
        return true;
    }
}
