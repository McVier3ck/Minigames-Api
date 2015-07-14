package me.McVier3ck.config;

import java.io.File;
import java.io.IOException;

import me.McVier3ck.main.MinigamesApi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class Config {
	
	
	
	File FileDir; 
	File pFile;

	public Config(String filename, String pluginname) {
		FileDir = new File(Bukkit.getPluginManager().getPlugin(pluginname).getDataFolder(), "");
		pFile = new File(Bukkit.getPluginManager().getPlugin(pluginname).getDataFolder(),filename + ".yml");
	}
	
	
	
	public void create()
	{
		
		if(!FileDir.exists())
		{
			FileDir.mkdir();
		}
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
	
	
	
	public void delete(String Filename)
	{
		pFile.delete();
	}
	

	
	
	
	public boolean existFile()
	{
		if(pFile.exists())
		{
			return true;
		}
		return false;
	}


	public void addLocation(String LocationName, Location location) {
		if(!existFile()) {
			create();
		}
		
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
	
	public Location getLocation(String LocationName, boolean yawandpitch) {
		if(!existFile()) {
			System.out.println("File not Found");
			return null;
		}
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
	
	public void removeLocation(String Filename, String LocationName) {
		if(!existFile()) {
			create();
		}
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

		



}
