package de.lp4.roleplay;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RolePlayPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("RolePlayPlus has been enabled!");
        getServer().getPluginManager().registerEvents(new EventLisener(this), this);
        //Disable console command output
        
        
        
    }

    @Override
    public void onDisable() {
        
        getLogger().info("RolePlayPlus has been disabled!");
        // Plugin shutdown logic
    }
}
