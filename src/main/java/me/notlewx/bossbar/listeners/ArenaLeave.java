package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import com.andrei1058.bedwars.api.arena.GameState;

import static com.andrei1058.bedwars.api.arena.GameState.*;
import static me.notlewx.bossbar.listeners.ArenaJoin.bar;

public class ArenaLeave implements Listener {
    @EventHandler
    public static void onArenaLeave(PlayerLeaveArenaEvent e) {
        Player p = e.getPlayer();
            bar.removePlayer(p);
    }
}
