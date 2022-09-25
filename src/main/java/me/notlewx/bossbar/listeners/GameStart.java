package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.andrei1058.bedwars.api.events.gameplay.TeamAssignEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static me.notlewx.bossbar.bossbar.bossbar.bar;


public class GameStart implements Listener {
    @EventHandler
    public void onGameStateChangeEvent(GameStateChangeEvent e) {
        IArena arena = e.getArena();
        for (Player player : arena.getPlayers()) {
            bar.setVisible(false);
            bar.removePlayer(player);
        }
    }
}
