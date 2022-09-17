package me.notlewx.bossbar.config;

import me.notlewx.bossbar.Bossbar;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import java.io.File;
import java.io.IOException;



public class CustomConfig implements Listener {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(getInstance().getDataFolder(), "config.yml");

        if (!file.exists()) {
            CustomConfig.getInstance().saveResource("config.yml", false);
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    private static Plugin getInstance() {
        return Bossbar.getPlugins();
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save the file");
        }
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
