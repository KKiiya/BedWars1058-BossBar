package me.notlewx.bossbar.versionsupport_common.src.main.java.me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.events.gameplay.TeamAssignEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static me.notlewx.bossbar.bossbar.bossbar.bar;


public class GameStart implements Listener {
    @EventHandler
    public void onTeamAssignEvent(TeamAssignEvent e) {
        Player p = e.getPlayer();
            bar.setVisible(false);
            bar.removePlayer(p);
    }
}
