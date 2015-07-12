package me.McVier3ck.team;

import java.util.HashMap;

public class Team {
	
	private static HashMap<String, String[]> teams = new HashMap<String, String[]>();
	
	public static void addTeam(String teamname) {
		if(teams.containsKey(teamname)) {
			System.out.println("Team already exist");
			return;
		}
		String[] empty = null;
		teams.put(teamname, empty);
		
	}
	
	public static void removeTeam(String teamname) {
		if(!teams.containsKey(teamname)) {
			System.out.println("Team not exist");
			return;
		}
		teams.remove(teamname);
		
	}
	

}
