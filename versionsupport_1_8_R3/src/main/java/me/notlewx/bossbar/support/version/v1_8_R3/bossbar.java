package me.notlewx.bossbar.support.version.v1_8_R3;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class bossbar extends BukkitRunnable implements Listener {
      private String message;
      private static HashMap<Player, EntityWither> wither =new HashMap<>();
      public bossbar(Plugin plugin, String message) {
          this.message = message;
          runTaskTimer(plugin, 0L, 20L);
    }

    public bossbar() {

    }

    public void addPlayer(Player player) {

    }

    public void removePlayer(Player player) {

    }

    public void setTitle(String title) {

    }

    public void setHealth(double health) {

    }

    public void run() {

    }
}