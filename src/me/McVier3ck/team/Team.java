package me.McVier3ck.team;

import java.util.ArrayList;
import java.util.UUID;

import me.McVier3ck.log.Log;
import me.McVier3ck.main.MinigamesApi;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Team {
	
	
	private ArrayList<UUID> players = new ArrayList<UUID>();
	private ChatColor color = ChatColor.WHITE;
	private Boolean friendlyfire = false;
	private Boolean allowInteract = true; 
	@SuppressWarnings("unused")
	private String teamname = "";
	
	
	public Team(String teamname) {
		this.teamname = teamname;
		MinigamesApi.Teams.add(this);
	}
	
	
	public boolean containsPlayer(Player player) {
		if(players.contains(player.getUniqueId())) {
			return true;
		}
		return false;
	}
	
	public void joinTeam(Player player) {
		if(containsPlayer(player)) {
			Log.Error("Player already in Team");
			return;
		}
		players.add(player.getUniqueId());
		player.setDisplayName(color + player.getName() + ChatColor.WHITE);
		player.setPlayerListName(color + player.getName());
		
	}
	
	public void leaveTeam(Player player) {
		if(!containsPlayer(player)) {
			Log.Error("Player not in Team");
			return;
		}
		players.remove(player.getUniqueId());
	}
	
	public void setColor(ChatColor color) {
		this.color = color;
		
		for(UUID uuid : players) {
			Player player = Bukkit.getPlayer(uuid);
			player.setDisplayName(color + player.getName() + ChatColor.WHITE);
			player.setPlayerListName(color + player.getName());
			player.setCustomName(color + player.getName());
		}
	}
	
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> playerlist = new ArrayList<Player>();
		for(UUID uuid : players) {
			Player player = Bukkit.getPlayer(uuid);
			playerlist.add(player);
		}
		return playerlist;
	}
	
	public ChatColor getColor() {
		return color;
	}
	
	public void setFriendlyFire(boolean friendlyFire) {
		this.friendlyfire = friendlyFire;
	}
	
	public boolean getFriendlyFire() {
		return friendlyfire;
	}
	
	public void setAllowInteract(boolean allowInteract) {
		this.allowInteract = allowInteract;
	}
	
	public boolean getAllowInteract() {
		return allowInteract;
	}
	
	

}
