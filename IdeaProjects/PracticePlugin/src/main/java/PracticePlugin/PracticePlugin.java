package PracticePlugin;

import Commands.opPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events.Events(), this);
        getCommand("opplayer").setExecutor(new opPlayer());
        getServer().getConsoleSender().sendMessage("PracticePlugin has been successfully started.");
    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("PracticePlugin has been stopped.");
    }

}
