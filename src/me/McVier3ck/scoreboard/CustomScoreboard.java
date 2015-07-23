package me.McVier3ck.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.McVier3ck.team.Team;

public class CustomScoreboard {

	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard scoreboard = manager.getNewScoreboard();
	Objective objective = null;
	
	
	public CustomScoreboard(String Name, DisplaySlot displaySlot) {
		objective = scoreboard.registerNewObjective(Name, "dummy");
		objective.setDisplayName(Name);
		objective.setDisplaySlot(displaySlot);
	}
	
	public void setScore(String name, Integer Score) {
		Score score = objective.getScore(name);
		score.setScore(Score);
	}
	
	public int getScore(String name) {
		Score score = objective.getScore(name);
		
		return score.getScore();
	}
	
	public void setScoreboard(Player player) {
		player.setScoreboard(scoreboard);
	}
	
	public void setScoreboard(Team team) {
		for (Player player : team.getPlayers()) {
			player.setScoreboard(scoreboard);
		}
	}
} 
