package me.notlewx.bossbar.bossbar;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import me.notlewx.bossbar.Bossbar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class bossbar implements Listener {
    static BarColor color = BarColor.PURPLE;
    static BarStyle style = BarStyle.SOLID;
    static String message = ChatColor.translateAlternateColorCodes('&', Bossbar.getPlugins().getConfig().getString("bossbar"));
    public static BossBar bar = Bukkit.createBossBar(message, color, style );

    @EventHandler
    public static void SpecAndStart(PlayerJoinArenaEvent e) {
        boolean spec = Bossbar.getPlugins().getConfig().getBoolean("bossbar-when-joining-as-spec");

        Player p = e.getPlayer();

            if (e.isSpectator() && spec) {
                bar.addPlayer(p);
                bar.setVisible(true);
            }
            else {
                bar.removePlayer(p);
                bar.setVisible(false);
            }

        boolean join = Bossbar.getPlugins().getConfig().getBoolean("bossbar-at-waiting-state");
            if (join) {
                bar.addPlayer(p);
                bar.setVisible(true);
            }
            else {
                bar.removePlayer(p);
                bar.setVisible(false);
            }
    }
    @EventHandler
    public static void end(GameEndEvent e) {

        boolean end = Bossbar.getPlugins().getConfig().getBoolean("bossbar-at-game-end");

        IArena arena = e.getArena();

        if (end) {
        for (Player player : arena.getPlayers()) {
            bar.addPlayer(player);
            bar.setVisible(true);
          }
        }
        else {
            return;
        }
    }
}
