package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import me.notlewx.bossbar.Bossbar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import static me.notlewx.bossbar.bossbar.bossbar.bar;

public class ArenaJoin implements Listener {
    @EventHandler
    public static void onArenaJoinEvent(PlayerJoinArenaEvent e) {
        Player p = e.getPlayer();
            bar.setVisible(true);
            bar.addPlayer(p);

        boolean spec = Bossbar.getPlugins().getConfig().getBoolean("bossbar-when-joining-as-spec");

        if (e.isSpectator() && spec) {
            bar.addPlayer(p);
            bar.setVisible(true);
        }
        else if (!spec) {
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
}

