package de.lp4.roleplay;

import de.lp4.roleplay.commands.setwardenspawnradius;
import de.lp4.roleplay.commands.setwardenspawntime;
import de.lp4.roleplay.commands.strike;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class RolePlayPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        Path path = Paths.get(getDataFolder().getParentFile().getAbsolutePath()).getParent().resolve("server.properties");

        boolean[] replaced = {false};

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path).stream()
                    .map(line -> {
                        if (line.equals("enforce-secure-profile=true")) {
                            replaced[0] = true;
                            return "enforce-secure-profile=false";
                        }
                        return line;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (replaced[0]) {
            try {
                Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            getLogger().warning("enforce-secure-profile in server.properties was set to true. The liberated chat plugin automatically changed it to false and now it restarts the server.");
            getServer().spigot().restart();
        }
        saveResource("config.yml", /* replace */ false);
        
        saveDefaultConfig();
        // Plugin startup logic
        getLogger().info("RolePlayPlus has been enabled!");
        
        if(getConfig().getInt("warden-spawn-time") == 0){
            getConfig().set("warden-spawn-time", 1200);
            saveConfig();
        }
        if(getConfig().getInt("warden-spawn-radius") == 0){
            getConfig().set("warden-spawn-radius", 3);
            saveConfig();
        }
        
        getServer().getPluginManager().registerEvents(new EventLisener(this), this);
        Objects.requireNonNull(getCommand("setwardenspawntime")).setExecutor(new setwardenspawntime(this));
        Objects.requireNonNull(getCommand("strike")).setExecutor(new strike());
        Objects.requireNonNull(getCommand("setwardenspawnradius")).setExecutor(new setwardenspawnradius(this));
        
    }

    @Override
    public void onDisable() {
        getLogger().info("RolePlayPlus has been disabled!");
    }
}
