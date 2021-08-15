package com.EpicPlayer.HelloPlugin;

import commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    static JavaPlugin instance;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new events.Events(), this);
        getCommand("heal").setExecutor(new heal());
        getCommand("broadcast").setExecutor(new broadcast());
        getCommand("warp").setExecutor(new warp());
        getCommand("spawn").setExecutor(new spawn());
        getCommand("addswear").setExecutor(new addswear());
        getCommand("calculate").setExecutor(new calculate());
        getCommand("gamemode").setExecutor(new gamemode());
        getCommand("kill").setExecutor(new kill());
        getCommand("warp").setTabCompleter(new warp());
        getCommand("gamemode").setTabCompleter(new gamemode());
        getCommand("menu").setExecutor(new gui());
        getCommand("ltmode").setExecutor(new LtMode());
        config.addDefault("youAreAwesome", true);
        config.options().copyDefaults(true);
        saveConfig();
        getServer().getConsoleSender().sendMessage("HelloPlugin has been successfully started.");
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("HelloPlugin has been stopped.");
    }

}

