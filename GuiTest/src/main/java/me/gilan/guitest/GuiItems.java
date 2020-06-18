package me.gilan.guitest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiItems implements Listener {

    public Inventory inv = Bukkit.getServer().createInventory(null, 54, "Menu");

    ItemStack Empty = new ItemStack(Material.AIR, 1);

    //YES BUTTON META
    public static ItemStack GreenWool(){
        ItemStack GreenWool = new ItemStack(Material.WOOL, 1, (byte) 13);
        ItemMeta GreenMeta = GreenWool.getItemMeta();
        GreenMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "YES!");
        GreenWool.setItemMeta(GreenMeta);

        return GreenWool;
    }

    //NO BUTTON META
    public static ItemStack RedWool(){
        ItemStack RedWool = new ItemStack(Material.WOOL, 1, (byte) 14);
        ItemMeta RedMeta = RedWool.getItemMeta();
        RedMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "No.");
        RedWool.setItemMeta(RedMeta);

        return RedWool;
    }
    //Question Piece Meta
    public static ItemStack Question1(){
        ItemStack Question1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
        ItemMeta Question1Meta = Question1.getItemMeta();
        Question1Meta.setDisplayName(ChatColor.YELLOW + "Do you like cheese?");
        Question1.setItemMeta(Question1Meta);

        return Question1;
    }
    public static ItemStack Question2(){
        ItemStack Question2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 8);
        ItemMeta Question2Meta = Question2.getItemMeta();
        Question2Meta.setDisplayName(ChatColor.DARK_AQUA + "Do you like 1.9+ PVP?");
        Question2.setItemMeta(Question2Meta);

        return Question2;
    }


    //Next page arrow
    public static ItemStack ArrowRight1(){
       ItemStack ArrowRight1 = new ItemStack(Material.ARROW,1);
       ItemMeta ArrowRight1Meta = ArrowRight1.getItemMeta();
       ArrowRight1Meta.setDisplayName(ChatColor.GREEN + "Next ->");
       ArrowRight1.setItemMeta(ArrowRight1Meta);

       return ArrowRight1;
    }
    //Other next page arrow
    public static ItemStack ArrowLeft2(){
        ItemStack ArrowLeft2 = new ItemStack(Material.ARROW,1);
        ItemMeta ArrowLeft2Meta = ArrowLeft2.getItemMeta();
        ArrowLeft2Meta.setDisplayName(ChatColor.GREEN + "Next ->");
        ArrowLeft2.setItemMeta(ArrowLeft2Meta);

        return ArrowLeft2;
    }


    //Stops Player from taking things from inventory
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        if (inventory.getName().equals(inv.getName())) {
            if(clicked.getType().equals(Material.WOOL)){
                //Gets GreenWool, (damage value of 13)
                if(clicked.getDurability() == 13) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + p.getName() + " likes cheese!");
                }
                //Gets RedWool, (damage value of 14)
                if(clicked.getDurability() == 14) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + p.getName() + " does not like cheese...");
                }
            }
        }
        //Stops player from taking question pane
        if(inv.getName().equals(inv.getName())){
            if(clicked.getType().equals(Material.STAINED_GLASS_PANE)){
                e.setCancelled(true);
            }
        }

    }

}



