package com.ArenaPlugin;

import commands.ArenaStart;
import org.bukkit.plugin.java.JavaPlugin;

public class ArenaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new commands.ArenaStart(), this);
        getCommand("arenastart").setExecutor(new ArenaStart());
        getServer().getConsoleSender().sendMessage("ArenaPlugin has been started.");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("ArenaPlugin has been stopped.");
    }


}
