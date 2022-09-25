package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import me.notlewx.bossbar.Bossbar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import static me.notlewx.bossbar.bossbar.bossbar.bar;

public class GameEnd implements Listener {


    @EventHandler
    public static void onGameEnd(GameEndEvent e) {
         IArena arena = e.getArena();
         for (Player player : arena.getPlayers()) {
             bar.addPlayer(player);
             bar.setVisible(true);
         }

        boolean end = Bossbar.getPlugins().getConfig().getBoolean("bossbar-at-game-end");

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
