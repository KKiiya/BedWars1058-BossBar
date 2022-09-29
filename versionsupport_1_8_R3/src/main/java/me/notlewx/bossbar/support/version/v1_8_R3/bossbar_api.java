package me.notlewx.bossbar.support.version.v1_8_R3;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class bossbar_api extends BukkitRunnable implements bossbar, Listener {
      private String message;
      private static HashMap<Player, EntityWither> wither =new HashMap<>();
      public bossbar_api(Plugin plugin, String message) {
          this.message = message;
          runTaskTimer(plugin, 0L, 20L);
    }

    public bossbar_api() {

    }

    private void b(double v) {
    }

    public net.minecraft.server.v1_8_R3.World a() {
        return null;
    }

    public boolean a(EntityComplexPart entityComplexPart, DamageSource damageSource, float v) {
        return false;
    }

    @Override
    public void run() {

    }
}