package me.McVier3ck.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class Vote {

	private ArrayList<Player> votetplayer = new ArrayList<>();
	private HashMap<String, Integer> votes = new HashMap<>();
	
	public Vote() {
		
	}
	
	public void addVote(Player player, String vote, Integer votevalue) {
		if(!hasVote(player)) {
			votetplayer.add(player);
			if(votes.containsKey(vote)) {
				votes.put(vote, votes.get(vote) +votevalue);
			} else {
				votes.put(vote, votevalue);
			}
		}
	}
	
	public void removeVote(Player player, String vote, Integer votevalue) {
		if(hasVote(player)) {
			if(votes.containsKey(vote) && votes.get(vote) >=votevalue) {
				votes.put(vote, votes.get(vote) -votevalue);
			}
		}
	}
	
	public int getVote(String vote) {
		if(votes.containsKey(vote)) {
			return votes.get(vote);
		}
		return 0;
	}
	
	public int getHighestVote() {
		int highest = 0;
		if(!votes.isEmpty()) {
			for(String key : votes.keySet()) {
				if(votes.get(key) > highest) {
					highest = votes.get(key);
				}
			}
		}
		return highest;
	}
	
	public boolean hasVote(Player player) {
		if(votetplayer.contains(player)) return true;
		return false;
	}
	
	

	
	
}
