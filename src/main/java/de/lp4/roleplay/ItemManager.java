package de.lp4.roleplay;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public static ItemStack RedstonCrystal;
    public static ItemStack LapisCrystal;
    public static ItemStack EchoCrystal;
    
    public static void init(){
        createItems();
    }
    
    private static void createItems(){
        
        ItemStack item1 = new ItemStack(Material.REDSTONE, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.displayName(Component.text("§cRedstone Crystal"));
        ItemStack item2 = new ItemStack(Material.LAPIS_LAZULI, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.displayName(Component.text("§9Lapis Crystal"));
        ItemStack item3 = new ItemStack(Material.ECHO_SHARD, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.displayName(Component.text("§5Echo Crystal"));
        
    }
}
