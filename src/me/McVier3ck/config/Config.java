package me.McVier3ck.config;

import java.io.File;

import me.McVier3ck.main.MinigamesApi;

import org.bukkit.Bukkit;


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


	

	



}
