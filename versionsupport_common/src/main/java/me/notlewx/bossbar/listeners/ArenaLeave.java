package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import static me.notlewx.bossbar.bossbar.bossbar.bar;

public class ArenaLeave implements Listener {
    @EventHandler
    public static void onArenaLeave(PlayerLeaveArenaEvent e) {
        Player p = e.getPlayer();
            bar.removePlayer(p);
    }
}
