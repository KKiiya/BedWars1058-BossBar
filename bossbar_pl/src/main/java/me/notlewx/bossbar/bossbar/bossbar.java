package me.notlewx.bossbar.bossbar;

import me.notlewx.bossbar.Bossbar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.boss.*;

public class bossbar implements Listener {
    static BarColor color = BarColor.PURPLE;
    static BarStyle style = BarStyle.SOLID;
    public static String message = ChatColor.translateAlternateColorCodes('&', Bossbar.getPlugins().getConfig().getString("bossbar"));
    public static BossBar bar = Bukkit.createBossBar(message, color, style);
}

