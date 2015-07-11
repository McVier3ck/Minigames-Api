package me.McVier3ck.config;

import java.io.File;
import java.io.IOException;

import me.McVier3ck.main.MinigamesApi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class Config {
	
	public static void createConfig(String Filename)
	{
		File FileDir = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(), "");
		
		if(!FileDir.exists())
		{
			Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder().mkdir();
		}
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		if(!pFile.exists())
		{
			
			
					try {
						pFile.createNewFile();
						
					} catch (Exception e) 
					{
						
						MinigamesApi.getInstance().getLogger().severe("Kann nicht erstellt werden");
					}
				
		}
	}
	
	
	
	public static void deleteConfig(String Filename)
	{
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		pFile.delete();
	}
	

	
	
	
	public static boolean existFile(String Filename)
	{
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		if(pFile.exists())
		{
			return true;
		}
		return false;
	}


	public static void addLocation(String Filename, String LocationName, Location location) {
		if(!existFile(Filename)) {
			createConfig(Filename);
		}
		
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(pFile);
		config.set(LocationName + ".x", location.getX());
		config.set(LocationName + ".y", location.getY());
		config.set(LocationName + ".z", location.getZ());
		config.set(LocationName + ".world", location.getWorld().getName());
		config.set(LocationName + ".yaw", location.getYaw());
		config.set(LocationName + ".pitch", location.getPitch());
		try {
			config.save(pFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static Location getLocation(String Filename, String LocationName, boolean yawandpitch) {
		if(!existFile(Filename)) {
			System.out.println("File not Found");
			return null;
		}
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(pFile);
		double x = config.getDouble(LocationName + ".x");
		double y = config.getDouble(LocationName + ".y");
		double z = config.getDouble(LocationName + ".z");
		String world = config.getString(LocationName + ".world");
		double yaw = config.getDouble(LocationName + ".yaw");
		double pitch = config.getDouble(LocationName + ".pitch");
		
		if(yawandpitch) {
			return new Location(Bukkit.getWorld(world), x, y, z, (int)yaw, (int)pitch);
		}
		return new Location(Bukkit.getWorld(world), x, y, z);
		
	}
	
	public static void removeLocation(String Filename, String LocationName) {
		if(!existFile(Filename)) {
			createConfig(Filename);
		}
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(pFile);
		config.set(LocationName + ".x", null);
		config.set(LocationName + ".y", null);
		config.set(LocationName + ".z", null);
		config.set(LocationName + ".world", null);
		config.set(LocationName + ".yaw", null);
		config.set(LocationName + ".pitch", null);
		config.set(LocationName, null);
		try {
			config.save(pFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static FileConfiguration getConfig(String Filename) {
		File pFile = new File(Bukkit.getPluginManager().getPlugin("Minigames-Api").getDataFolder(),Filename + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(pFile);
		return config;
	}
	



}
