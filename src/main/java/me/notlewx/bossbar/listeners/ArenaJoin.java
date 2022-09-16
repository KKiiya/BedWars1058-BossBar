package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.event.EventHandler;
import com.andrei1058.bedwars.api.arena.IArena;

public class ArenaJoin implements Listener {
    static String message = (ChatColor.translateAlternateColorCodes('&', ChatColor.YELLOW + "&lPlaying " + ChatColor.WHITE + ChatColor.BOLD + "BED WARS" + ChatColor.YELLOW + ChatColor.BOLD + " on " + ChatColor.AQUA + ChatColor.BOLD + "MC.EXAMPLE.NET"));
    static BarColor color = BarColor.PURPLE;
    static BarStyle style = BarStyle.SOLID;
    static BossBar bar = Bukkit.createBossBar(message, color, style);
    @EventHandler
    public static void onArenaJoinEvent(PlayerJoinArenaEvent e) {
        IArena arena = e.getArena();
        Player p = e.getPlayer();
        String a = e.getArena().getArenaName();
            bar.addPlayer(p);
            bar.setVisible(true);
            System.out.println(p + "joined the arena" + a);
    }
}

