package me.McVier3ck.utils;

public enum GameStats {

	WAITING("Waiting"), STARTING("Starting"), INGAME("Ingame"), ENDING("Ending");

	private String GameStatName;

	private GameStats(String GameStatName) {
		this.GameStatName = GameStatName;
	}

	public String getGameStatName() {
		return GameStatName;
	}

}
