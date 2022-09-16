package me.notlewx.bossbar.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.GameState.*;
import me.notlewx.bossbar.listeners.BossBarOn;
import static com.andrei1058.bedwars.api.arena.GameState.playing;

public class BossBarOff implements Listener {
    @EventHandler
    public static void onGameStateChangeEvent(GameStateChangeEvent e) {
        IArena arena = e.getArena();
        Player p = (Player) arena.getPlayers();

        GameState ArenaStatus = arena.getStatus();
        if (ArenaStatus == playing) {
            BossBarOn bar = new BossBarOn();
        }
    }
}
