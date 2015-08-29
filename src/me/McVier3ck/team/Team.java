package me.McVier3ck.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McVier3ck.log.Log;
import me.McVier3ck.main.MinigamesApi;
import net.md_5.bungee.api.ChatColor;

public class Team {

	private ArrayList<UUID> players = new ArrayList<UUID>();
	private ChatColor color = ChatColor.WHITE;
	private Boolean friendlyfire = false;
	private Boolean canBreak = true;
	private Boolean canPlace = true;
	private Boolean canInteract = true;
	private String teamname = "";
	private HashMap<String, Integer> score = new HashMap<>();
	private int maxSize = 1000;
	private int minSize = 0;
	private int currentSize = 0;
	private Location spawn;

	public Team(String teamname) {
		this.teamname = teamname;
		MinigamesApi.Teams.add(this);
	}

	public boolean containsPlayer(Player player) {
		if (players.contains(player.getUniqueId())) {
			return true;
		}
		return false;
	}

	public static String joinRandomTeam(Player player) {
		Team teamLowest = null;
		for (Team team : MinigamesApi.Teams) {
			if (teamLowest == null || team.getCurrentSize() < teamLowest.getCurrentSize()) {
				teamLowest = team;
			}
		}
		if (teamLowest.getCurrentSize() <= teamLowest.getMaxSize()) {
			teamLowest.joinTeam(player);
			return teamLowest.getTeamname();
		}
		return null;
	}

	public void joinTeam(Player player) {
		if (maxSize >= currentSize) {
			currentSize++;
			if (containsPlayer(player)) {
				Log.Error("Player already in Team");
				return;
			}
			players.add(player.getUniqueId());
			player.setDisplayName(color + player.getName() + ChatColor.WHITE);
			player.setPlayerListName(color + player.getName());
		} else {
			Log.Error("Team are Full");
			return;
		}

	}

	public void leaveTeam(Player player) {
		if (!containsPlayer(player)) {
			Log.Error("Player not in Team");
			return;
		}
		currentSize--;
		players.remove(player.getUniqueId());
	}

	public void setColor(ChatColor color) {
		this.color = color;

		for (UUID uuid : players) {
			Player player = Bukkit.getPlayer(uuid);
			player.setDisplayName(color + player.getName() + ChatColor.WHITE);
			player.setPlayerListName(color + player.getName());
			player.setCustomName(color + player.getName());
		}
	}

	public ArrayList<Player> getPlayers() {
		ArrayList<Player> playerlist = new ArrayList<Player>();
		for (UUID uuid : players) {
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

	public void setCanInteract(boolean canInteract) {
		this.canInteract = canInteract;
	}

	public boolean getCanInteract() {
		return canInteract;
	}

	public void setCanBreak(boolean canBreak) {
		this.canBreak = canBreak;
	}

	public Boolean getCanBreak() {
		return canBreak;
	}

	public void setCanPlace(boolean canPlace) {
		this.canPlace = canPlace;
	}

	public Boolean getCanPlace() {
		return canPlace;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public int getScore(String name) {
		return score.get(name);
	}

	public void setScore(String name, int value) {
		score.put(name, value);
	}

	public void addScore(String name, int value) {
		score.put(name, score.get(name) + value);
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getMinSize() {
		return minSize;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public Location getSpawn() {
		return spawn;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}

}
