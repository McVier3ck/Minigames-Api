package me.McVier3ck.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.McVier3ck.Log.Log;

import org.bukkit.entity.Player;

public class Team {
	
	@SuppressWarnings("rawtypes")
	private static HashMap<String, List> teams = new HashMap<String, List>();
	
	public static void addTeam(String teamname) {
		if(teams.containsKey(teamname)) {
			Log.Error("Team already exist");
			return;
		}
		List<UUID> empty = new ArrayList<UUID>();

		teams.put(teamname, empty);
		
	}
	
	public static void removeTeam(String teamname) {
		if(!teams.containsKey(teamname)) {
			Log.Error("Team not exist");
			return;
		}
		teams.remove(teamname);
		
	}
	
	@SuppressWarnings("unchecked")
	public static boolean containsTeam(String teamname, Player player) {
		if(!teams.containsKey(teamname)) {
			Log.Error("Team not exist");
			return false;
		}
		List<UUID> uuid = teams.get(teamname);
		if(uuid.contains(player.getUniqueId())) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static void joinTeam(String teamname, Player player) {
		if(!teams.containsKey(teamname)) {
			Log.Error("Team not exist");
			return;
		}
		if(containsTeam(teamname, player)) {
			Log.Error("Player already in Team");
			return;
		}
		List<UUID> uuid = teams.get(teamname);
		uuid.add(player.getUniqueId());
		
	}
	
	@SuppressWarnings("unchecked")
	public static void leaveTeam(String teamname, Player player) {
		if(!teams.containsKey(teamname)) {
			Log.Error("Team not exist");
			return;
		}
		if(!containsTeam(teamname, player)) {
			Log.Error("Player not in Team");
			return;
		}
		List<UUID> uuid = teams.get(teamname);
		uuid.remove(player.getUniqueId());
	}
	
	public static void switchTeam(String oldteamname, String newteam, Player player) {
		if(!teams.containsKey(oldteamname) || !teams.containsKey(newteam)) {
			Log.Error("Team not exist");
			return;
		}
		if(!containsTeam(oldteamname, player)) {
			Log.Error("Player not in Team");
			return;
		}
		if(containsTeam(newteam, player)) {
			Log.Error("Player already in Team");
			return;
		}
		
		leaveTeam(oldteamname, player);
		joinTeam(newteam, player);
		
	}
	
	public static String getTeam(Player player) {
		for (String teamname : teams.keySet()) {
			List<UUID> uuid = teams.get(teamname);
			
		}
		
		
		return null;
		
	}
	

}
