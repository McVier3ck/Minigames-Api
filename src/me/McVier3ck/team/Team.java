package me.McVier3ck.team;

import java.util.ArrayList;
import java.util.UUID;

import me.McVier3ck.log.Log;

import org.bukkit.entity.Player;

public class Team {
	
	
	private ArrayList<UUID> players = new ArrayList<UUID>();
	@SuppressWarnings("unused")
	private String teamname = "";
	
	
	public Team(String teamname) {
		this.teamname = teamname;
		
	}
	
	
	public boolean containsPlayer(Player player) {
		if(players.contains(player.getUniqueId())) {
			return true;
		}
		return false;
	}
	
	public void joinTeamPlayer(Player player) {
		if(containsPlayer(player)) {
			Log.Error("Player already in Team");
			return;
		}
		players.add(player.getUniqueId());
		
	}
	
	public void leaveTeam(Player player) {
		if(!containsPlayer(player)) {
			Log.Error("Player not in Team");
			return;
		}
		players.remove(player.getUniqueId());
	}
	

	

}
