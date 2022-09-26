package me.notlewx.bossbar.bossbar;

import me.notlewx.bossbar.bossbar_plugin.src.main.java.me.notlewx.bossbar.Bossbar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Listener;

public class bossbar implements Listener {
    static BarColor color = BarColor.PURPLE;
    static BarStyle style = BarStyle.SOLID;
    static String message = ChatColor.translateAlternateColorCodes('&', Bossbar.getPlugins().getConfig().getString("bossbar"));
    public static BossBar bar = Bukkit.createBossBar(message, color, style );
}

