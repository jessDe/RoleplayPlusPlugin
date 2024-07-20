package de.lp4.roleplay;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

import java.util.*;


public class EventLisener implements Listener {
    
    private final Set<UUID> v1 = new HashSet<>();
    Plugin plugin;
    private final List<WardenTypeEvent> wardenTypeEvents = new ArrayList<>();
    
    
    public EventLisener(Plugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void EntitySpawn(EntitySpawnEvent e){
        if(e.getEntityType() == EntityType.WARDEN){
            Chunk chunk = e.getLocation().getChunk();
            int x = e.getLocation().getChunk().getX();
            int z = e.getLocation().getChunk().getZ();
            int radius = plugin.getConfig().getInt("warden-spawn-radius");
            for(WardenTypeEvent wardenTypeEvent : wardenTypeEvents){
                for(int i = -radius; i < radius; i++){
                    for (int j = -radius; j < radius; j++){
                        int cordX = x + i;
                        int cordZ = z + j;
                        
                        if(wardenTypeEvent.chunk.getX() == cordX && wardenTypeEvent.chunk.getZ() == cordZ){
                            if(wardenTypeEvent.CheckTime()){
                                e.setCancelled(true);
                                return;
                            } else {
                                wardenTypeEvents.remove(wardenTypeEvent);
                                wardenTypeEvents.add(new WardenTypeEvent(chunk, this.plugin));
                                return;
                            }
                        }
                        
                    }
                }
            }
            wardenTypeEvents.add(new WardenTypeEvent(chunk, this.plugin));
        }
    }
    
    
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        Player x1 = event.getPlayer();
        for (UUID h2234234 : v1) {
            x1.hidePlayer(this.plugin, Objects.requireNonNull(x1.getServer().getPlayer(h2234234)));
        }
    }


    static class WardenTypeEvent {
        public Chunk chunk;
        public long time;
        public WardenTypeEvent(Chunk chunk, Plugin plugin) {
            this.chunk = chunk;
            int repsawn = plugin.getConfig().getInt("warden-spawn-time");
            this.time = System.currentTimeMillis()+ 1000L *repsawn;
        }

        public boolean CheckTime(){
            return (time - System.currentTimeMillis() > 0);
        }
    }
    
    
}

