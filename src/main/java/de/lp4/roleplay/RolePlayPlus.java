package de.lp4.roleplay;

import de.lp4.roleplay.commands.setwardenspawntime;
import de.lp4.roleplay.commands.strike;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RolePlayPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        saveResource("config.yml", /* replace */ false);
        saveDefaultConfig();
        // Plugin startup logic
        getLogger().info("RolePlayPlus has been enabled!");
        getServer().getPluginManager().registerEvents(new EventLisener(this), this);
        Objects.requireNonNull(getCommand("setwardenspawntime")).setExecutor(new setwardenspawntime(this));
        Objects.requireNonNull(getCommand("strike")).setExecutor(new strike());
        
    }

    @Override
    public void onDisable() {
        getLogger().info("RolePlayPlus has been disabled!");
    }
}
