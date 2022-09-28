package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.gameplay.TeamAssignEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static me.notlewx.bossbar.bossbar.bossbar_api1.bar;


public class GameStart implements Listener {
    @EventHandler
    public void onTeamAssignEvent(TeamAssignEvent e) {
        Player p = e.getPlayer();
            bossbar_api1.bar.setVisible(false);
            bossbar_api1.bar.removePlayer(p);
    }
}
