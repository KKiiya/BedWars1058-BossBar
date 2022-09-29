package me.notlewx.bossbar;

import me.notlewx.bossbar.support.version.v1_8_R3.bossbar;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import me.notlewx.bossbar.listeners.*;
import me.notlewx.bossbar.config.CustomConfig;

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
            System.out.println("[BedWars1058-BossBar] BedWars1058 Found! Hooking...");
        }

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new bossbar(), this);
        Bukkit.getPluginManager().registerEvents(new me.notlewx.bossbar.bossbar.bossbar(), this);
        Bukkit.getPluginManager().registerEvents(new ArenaJoin(), this);
        Bukkit.getPluginManager().registerEvents(new ArenaLeave(), this);
        Bukkit.getPluginManager().registerEvents(new GameStart(), this);
        Bukkit.getPluginManager().registerEvents(new GameEnd(), this);
        Bukkit.getPluginManager().registerEvents(new CustomConfig(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Bossbar getPlugins() {
        return getPlugin(Bossbar.class);
    }
}
