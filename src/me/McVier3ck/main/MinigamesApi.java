package me.McVier3ck.main;

import java.util.ArrayList;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.McVier3ck.arena.Arena;
import me.McVier3ck.arena.ArenaListener;
import me.McVier3ck.team.Team;
import me.McVier3ck.team.TeamListener;

	public class MinigamesApi extends JavaPlugin{
		
	public static MinigamesApi api;
	
	public static ArrayList<Team> Teams = new ArrayList<Team>();
	public static ArrayList<Arena> Arenas = new ArrayList<Arena>();
	
	public static MinigamesApi getInstance() {
		return api;
	}
	
	@Override
	public void onDisable() {
	}
	
	
	
	@Override
	public void onEnable() {
		api = this;
		
		
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new TeamListener(), this);
		pm.registerEvents(new ArenaListener(), this);
	}	
	
	
	
	
	
	
}
