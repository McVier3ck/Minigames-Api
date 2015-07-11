package me.McVier3ck.main;

import me.McVier3ck.config.Config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

	public class MinigamesApi extends JavaPlugin{

	public static MinigamesApi api;
	
	public static MinigamesApi getInstance() {
		return api;
	}
	
	@Override
	public void onDisable() {
	}
	
	
	
	@Override
	public void onEnable() {
		Config.addLocation("Test", "Test1", new Location(Bukkit.getWorld("world"), 3, 1, 9, 01, 2343));
		Config.addLocation("Test", "Test2", new Location(Bukkit.getWorld("world"), 3, 1, 9, 01, 2343));
		Config.addLocation("Test", "Test3", new Location(Bukkit.getWorld("world"), 3, 1, 9, 01, 2343));
		Config.removeLocation("Test", "Test3");;
	
		
		
	}	
	
	
	public void test() {
		
		
		
	}
	
}
