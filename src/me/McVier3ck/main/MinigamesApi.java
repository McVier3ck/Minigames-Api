package me.McVier3ck.main;

import me.McVier3ck.config.Config;

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
		test();
	
		
		Config.createConfig("Test");
	}	
	
	
	public void test() {
		
		
		
	}
	
}
