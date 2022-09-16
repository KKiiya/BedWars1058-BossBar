package me.notlewx.bossbar.listeners;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.event.EventHandler;
import static com.andrei1058.bedwars.api.arena.GameState.*;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import com.andrei1058.bedwars.api.arena.GameState;

public class BossBarOn implements Listener {

    @EventHandler
    public static void onArenaJoinEvent(PlayerJoinArenaEvent e) {
        IArena arena = e.getArena();
        Player p = e.getPlayer();
        GameState ArenaStatus = arena.getStatus();

        String message = (ChatColor.translateAlternateColorCodes('&', ChatColor.YELLOW + "&lPlaying " + ChatColor.WHITE + ChatColor.BOLD + "BED WARS" + ChatColor.YELLOW + ChatColor.BOLD + " on " + ChatColor.AQUA + ChatColor.BOLD + "MC.EXAMPLE.NET"));
        BarColor color = BarColor.PURPLE;
        BarStyle style = BarStyle.SOLID;
        BossBar bar = Bukkit.createBossBar(message, color, style);

        if (ArenaStatus == waiting || ArenaStatus == starting) {
            bar.addPlayer(p);
            bar.setVisible(true);
        }
        else if (ArenaStatus == playing) {
            bar.removePlayer(p);
        }
    }
}

