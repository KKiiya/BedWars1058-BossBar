package me.notlewx.bossbar.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;



public class CustomConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("bossbar").getDataFolder(), "config.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e) {
                //Config files
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
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
