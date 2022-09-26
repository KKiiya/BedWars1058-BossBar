package me.notlewx.bossbar.versionsupport_common.src.main.java.me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import static me.notlewx.bossbar.bossbar.bossbar.bar;
import static me.notlewx.bossbar.bossbar.bossbar.end;

public class GameEnd implements Listener {


    @EventHandler
    public static void onGameEnd(GameEndEvent e) {
         IArena arena = e.getArena();
         for (Player player : arena.getPlayers()) {
             bar.addPlayer(player);
             bar.setVisible(true);
         }

        if (end) {
            for (Player player : arena.getPlayers()) {
                bar.addPlayer(player);
                bar.setVisible(true);
            }
        }
        else if (!end) {
            for (Player player : arena.getPlayers()) {
                bar.setVisible(false);
                bar.removePlayer(player);
            }
        }
    }
}
