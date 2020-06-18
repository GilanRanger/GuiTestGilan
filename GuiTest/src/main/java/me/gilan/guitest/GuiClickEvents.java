package me.gilan.guitest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.gilan.guitest.GuiItems.*;

public class GuiClickEvents implements Listener {

    public Inventory inv = Bukkit.getServer().createInventory(null, 54, "Menu");

    ItemStack Empty = new ItemStack(Material.AIR, 1);

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
                    p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + p.getName() + " says Yes!");
                }
                //Gets RedWool, (damage value of 14)
                if(clicked.getDurability() == 14) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + p.getName() + " says No...");
                }
            }
        }
            //Stops player from taking stuff
            if(inv.getName().equals(inv.getName())){
                //Panes
                if(clicked.getType().equals(Material.STAINED_GLASS_PANE)){
                    e.setCancelled(true);
                //Close
                if(clicked.getType().equals(Material.BARRIER)){
                    e.setCancelled(true);
                    p.closeInventory();
                }
                //Arrow
                if(clicked.getType().equals(Material.ARROW)){
                    if(clicked.getItemMeta().equals(GuiItems.ArrowRight1().getItemMeta())){
                        e.setCancelled(true);
                        for(int i=0; i<53; i++){
                            inv.setItem(i, Empty);
                        }
                        inv.setItem(0, GreenWool());
                        inv.setItem(8, RedWool());
                        inv.setItem(13, Question2());
                        inv.setItem(44, ArrowLeft2());
                    }
                    if(clicked.getItemMeta().equals(GuiItems.ArrowLeft2().getItemMeta())){
                        e.setCancelled(true);
                        for(int i=0; i<53; i++){
                            inv.setItem(i, Empty);
                        }
                        inv.setItem(0, GreenWool());
                        inv.setItem(8, RedWool());
                        inv.setItem(13, Question1());
                        inv.setItem(53, ArrowRight1());
                    }
                }
            }
        }

    }

}
