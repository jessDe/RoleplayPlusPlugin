package de.lp4.roleplay;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import org.bukkit.plugin.Plugin;

import java.util.*;


public class EventLisener implements Listener {
    
    Plugin plugin;
    private final List<WardenTypeEvent> wardenTypeEvents = new ArrayList<>();
    
    
    public EventLisener(Plugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void EntitySpawn(EntitySpawnEvent e){
        // Check if the entity is a warden and has ai
        if(e.getEntityType() == EntityType.WARDEN){
            Warden warden = (Warden) e.getEntity();
            if (!warden.hasAI()){
                return;
            }
            
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

