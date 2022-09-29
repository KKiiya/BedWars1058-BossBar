package me.notlewx.bossbar.common;

import com.andrei1058.bedwars.api.server.VersionSupport;
import me.notlewx.bossbar.Bossbar;
import me.notlewx.bossbar.bossbar.bossbar;
import me.notlewx.bossbar.listeners.ArenaJoin;
import me.notlewx.bossbar.listeners.ArenaLeave;
import me.notlewx.bossbar.listeners.GameEnd;
import me.notlewx.bossbar.listeners.GameStart;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class VersionCommon {
    public static Bossbar api;

    public VersionCommon(VersionSupport versionSupport) {
        api = Bukkit.getServicesManager().getRegistration(Bossbar.class).getProvider();

        registerListeners(versionSupport.getPlugin(), new ArenaJoin());
        registerListeners(versionSupport.getPlugin(), new ArenaLeave());
        registerListeners(versionSupport.getPlugin(), new GameStart());
        registerListeners(versionSupport.getPlugin(), new GameEnd());

        if (versionSupport.getVersion() > 1) {
            registerListeners(versionSupport.getPlugin(), new bossbar(), new me.notlewx.bossbar.support.version.v1_8_R3.bossbar());
        }
    }

    private void registerListeners(Plugin plugin, Listener... listener) {
        for (Listener l : listener) {
            plugin.getServer().getPluginManager().registerEvents(l, plugin);
        }
    }
}
