package me.notlewx.bossbar.config;

import me.notlewx.bossbar.Bossbar;
import com.andrei1058.bedwars.api.configuration.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class config implements Listener {
        public static ConfigManager config;
        public static final String ANIM_1 = "anim-1";
        public static final String ANIM_2 = "anim-2";
        public static final String ANIM_3 = "anim-3";

    public static void addDefaultConfig() {
        config = new ConfigManager(Bossbar.getPlugins(), "config", "plugins/BedWars1058/Addons/BossBarAddon");
        YamlConfiguration yml = config.getYml();
        yml.addDefault("bossbar-1", ChatColor.translateAlternateColorCodes('&',"&e&lPlaying" + "&f&lBED WARS" + "&e&lon" + "&b&lMC.EXAMPLE.NET"));
        yml.addDefault("bossbar-2", ChatColor.translateAlternateColorCodes('&',"&e&lPlaying" + "&f&lBED WARS" + "&e&lon" + "&f&lMC.EXAMPLE.NET"));
        yml.addDefault("bossbar-3", ChatColor.translateAlternateColorCodes('&',"&e&lPlaying" + "&f&lBED WARS" + "&e&lon" + "&a&lMC.EXAMPLE.NET"));
        yml.options().copyDefaults(true);
        config.save();
    }
}
