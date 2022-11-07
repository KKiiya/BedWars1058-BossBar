package me.notlewx.bossbar.support.version.v1_8_R3;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import static me.notlewx.bossbar.bossbar.bossbar.message;
import java.util.HashMap;
import java.util.Map;

public class bossbar extends BukkitRunnable implements Listener {
    private static final HashMap<Player, EntityWither> bar = new HashMap<>();
    private String m = message;

    public bossbar(Plugin plugin, String message) {
          this.m = message;
          runTaskTimer(plugin, 0L, 20L);
    }

    public bossbar() {

    }

    public Location setWitherLoc(Location loc) {
        return loc.add(loc.getDirection().multiply(20));
    }

    public void run() {
        for (Map.Entry<Player, EntityWither> q : bar.entrySet()) {
            EntityWither w = q.getValue();
            PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport(w);
            (((CraftPlayer)q.getKey()).getHandle()).playerConnection.sendPacket(packet);
            Location loc = setWitherLoc((q.getKey()).getLocation());
            w.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0.0F, 0.0F);
        }
    }


    public void addPlayer(Player player) {
        EntityWither w = new EntityWither(((CraftWorld)player.getWorld()).getHandle());
        Location l = setWitherLoc(player.getLocation());
        w.setCustomName(this.m);
        w.setInvisible(true);
        w.setLocation(l.getX(), l.getY(), l.getZ(), 0.0F, 0.0F);
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(w);
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket(packet);
    }

    public void removePlayer(Player player) {
        EntityWither w = bar.remove(player);
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(w.getId());
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket(packet);
    }

    public void setHealth(double health) {
        for (Map.Entry<Player, EntityWither> entry : bar.entrySet()) {
            EntityWither w = entry.getValue();
            w.setHealth((float)(health * w.getMaxHealth()));
            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(w.getId(), w.getDataWatcher(), true);
            (((CraftPlayer)entry.getKey()).getHandle()).playerConnection.sendPacket(packet);
        }
    }

    public void setTitle(String title) {
        this.m = title;
        for (Map.Entry<Player, EntityWither> entry : bar.entrySet()) {
            EntityWither w = entry.getValue();
            w.setCustomName(title);
            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(w.getId(), w.getDataWatcher(), true);
            (((CraftPlayer)entry.getKey()).getHandle()).playerConnection.sendPacket(packet);
        }
    }
}