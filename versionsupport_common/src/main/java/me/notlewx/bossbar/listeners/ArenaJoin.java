package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import static me.notlewx.bossbar.bossbar.bossbar_api1.*;

public class ArenaJoin implements Listener {
    @EventHandler
    public static void onArenaJoinEvent(PlayerJoinArenaEvent e) {
        Player p = e.getPlayer();
            bossbar_api1.bar.setVisible(true);
            bossbar_api1.bar.addPlayer(p);
    }
}

