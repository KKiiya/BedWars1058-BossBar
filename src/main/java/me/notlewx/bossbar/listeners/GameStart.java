package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static me.notlewx.bossbar.listeners.ArenaJoin.bar;

public class GameStart implements Listener {
    @EventHandler
    public static void onGameStartEvent(GameStateChangeEvent e) {
        IArena arena = e.getArena();

            bar.addPlayer();
            bar.setVisible(false);
    }
}
