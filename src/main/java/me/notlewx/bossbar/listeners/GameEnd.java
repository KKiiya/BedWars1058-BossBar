package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import static me.notlewx.bossbar.listeners.ArenaJoin.bar;

public class GameEnd implements Listener {
    @EventHandler
    public static void onGameWin(GameEndEvent e) {
        Player Win = (Player) e.getWinners();
        bar.addPlayer(Win);
        bar.setVisible(true);

        Player Lose = (Player) e.getLosers();
        bar.addPlayer(Lose);
        bar.setVisible(true);
    }
}
