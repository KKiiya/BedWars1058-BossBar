package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import me.notlewx.bossbar.Bossbar;
import me.notlewx.bossbar.config.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.event.EventHandler;

public class ArenaJoin implements Listener {
    static BarColor color = BarColor.PURPLE;
    static BarStyle style = BarStyle.SOLID;
    static String message = ChatColor.translateAlternateColorCodes('&', Bossbar.getPlugins().getConfig().getString("bossbar"));
    static BossBar bar = Bukkit.createBossBar(message, color, style );
    @EventHandler
    public static void onArenaJoinEvent(PlayerJoinArenaEvent e) {
        Player p = e.getPlayer();
            bar.addPlayer(p);
            bar.setVisible(true);
    }
}

