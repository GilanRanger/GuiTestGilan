package me.gilan.guitest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.gilan.guitest.GuiItems.*;

public class GuiMenuActions implements Listener {

    public Inventory inv = Bukkit.getServer().createInventory(null, 54, "Menu");

    ItemStack Empty = new ItemStack(Material.AIR, 1);

    public static ItemStack Menu() {
        ItemStack MenuOpener = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = MenuOpener.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "MENU");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_AQUA + "Right-Click while holding to Open Menu");

        meta.setLore(lore);
        MenuOpener.setItemMeta(meta);

        return MenuOpener;
    }

    @EventHandler
    public void GiveMenuOpener(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        //ADDS ITEM
        if (!(p.getInventory().contains(Menu()))){
            for(int i=0; i<9; i++){
                p.getInventory().setItem(i, Empty);
            }
            p.getInventory().setItem(0, Menu());
        }
    }
    //OPEN UP MENU
    @EventHandler
    public void RightClick(PlayerInteractEvent e){
        Player p = e.getPlayer();

        //Menu (Inventory Items)
        inv.setItem(0, GreenWool());
        inv.setItem(8, RedWool());
        inv.setItem(13, Question1());
        inv.setItem(53, ArrowRight1());

        //Inventory Open
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getInventory().getItemInMainHand().equals(Menu())){
                p.openInventory(inv);
            }
        }

    }

    //Prevents Menu from being dropped
    @EventHandler
    public void onDropMenu(PlayerDropItemEvent e){

        if(e.getItemDrop().getItemStack().equals(Menu())){
            e.setCancelled(true);
        }
    }

    //Resets Hotbar on when Inventory is closed
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        Inventory inventory = e.getInventory();

        if (inventory.getName().equals(inv.getName())) {
            for (int i = 1; i < 9; i++) {
                p.getInventory().setItem(i, Empty);
            }
            p.getInventory().setItem(0, Menu());

        }
    }
}
