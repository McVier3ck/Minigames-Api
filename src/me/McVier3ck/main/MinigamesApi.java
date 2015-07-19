package me.McVier3ck.main;

import java.util.ArrayList;

import me.McVier3ck.team.Team;
import me.McVier3ck.team.TeamListener;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

	public class MinigamesApi extends JavaPlugin{

	public static MinigamesApi api;
	
	public static ArrayList<Team> Teams = new ArrayList<Team>();
	
	public static MinigamesApi getInstance() {
		return api;
	}
	
	@Override
	public void onDisable() {
	}
	
	
	
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		

		pm.registerEvents(new TeamListener(), this);
		
		Team test = new Team("Test");
		for(Player player : Bukkit.getOnlinePlayers()) {
			test.joinTeam(player);
		}
		test.setColor(ChatColor.DARK_PURPLE);

	}	
	
	
}
