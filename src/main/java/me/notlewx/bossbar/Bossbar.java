package me.notlewx.bossbar;

import com.andrei1058.bedwars.api.BedWars;
import me.notlewx.bossbar.config.CustomConfig;
import me.notlewx.bossbar.listeners.ArenaLeave;
import me.notlewx.bossbar.listeners.ArenaJoin;
import me.notlewx.bossbar.listeners.GameStart;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bossbar extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
            getLogger().severe("BedWars1058 was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        else {
            System.out.println("BedWars1058 Found! Hooking...");
        }
        BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars .class).getProvider();

        getServer().getPluginManager().registerEvents(new ArenaJoin(), this);
        getServer().getPluginManager().registerEvents(new ArenaLeave(), this);
        getServer().getPluginManager().registerEvents(new GameStart(), this);
        getServer().getPluginManager().registerEvents((Listener) new CustomConfig(), this);

        config.options().copyDefaults(true);
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().addDefault("bossbar", "&e&lPlaying &f&lBED WARS &f&lon &b&lMC.EXAMPLE.NET");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Bossbar getPlugins() {
        return getPlugin(Bossbar.class);
    }
}
