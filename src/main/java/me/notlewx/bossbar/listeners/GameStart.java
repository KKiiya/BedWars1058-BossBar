package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.gameplay.TeamAssignEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static me.notlewx.bossbar.listeners.ArenaJoin.bar;


public class GameStart implements Listener {
    @EventHandler
    public void onTeamAssignEvent(TeamAssignEvent e) {
        Player p = e.getPlayer();
            bar.removePlayer(p);
            bar.setVisible(false);
    }
}
