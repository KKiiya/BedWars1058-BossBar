package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import me.clip.placeholderapi.libs.kyori.adventure.platform.facet.Facet;
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

public class ArenaListener implements Listener {

    @EventHandler
    public static void onArenaJoinEvent(PlayerJoinArenaEvent e) {
        IArena arena = e.getArena();
        Player p = e.getPlayer();
        GameState ArenaStatus = arena.getStatus();

        String message = (ChatColor.translateAlternateColorCodes('&', ChatColor.WHITE + "&lPlaying " + ChatColor.YELLOW + ChatColor.BOLD + "BED WARS" + ChatColor.WHITE + ChatColor.BOLD + " on " + ChatColor.AQUA + ChatColor.BOLD + "MC.EXAMPLE.NET"));
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
