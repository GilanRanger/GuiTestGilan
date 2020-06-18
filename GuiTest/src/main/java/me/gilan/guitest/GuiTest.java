package me.gilan.guitest;

import org.bukkit.plugin.java.JavaPlugin;

public final class GuiTest extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GuiItems(), this);
        getServer().getPluginManager().registerEvents(new GuiMenuActions(), this);
    }
}
