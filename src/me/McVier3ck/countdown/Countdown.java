package me.McVier3ck.countdown;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.McVier3ck.main.MinigamesApi;
import me.McVier3ck.utils.Title;
import net.md_5.bungee.api.ChatColor;

public class Countdown {

	private int[] Countdowntimes = null;
	private int Startvalue = 0;
	private Boolean useXp = false;
	private Boolean useTitle = false;
	private int Scheduler;
	private ChatColor titleColor = ChatColor.WHITE;

	public Countdown(int[] Countdowntimes, int Startvalue) {
		this.Countdowntimes = Countdowntimes;
		this.Startvalue = Startvalue;
	}

	public void StartForAll(final String message) {

		Scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(MinigamesApi.getInstance(), new Runnable() {
			int curentCount = Startvalue;

			@Override
			public void run() {
				String finalmessage = message.replaceAll("%time%", String.valueOf(curentCount));
				for (int countTime : Countdowntimes) {
					if (countTime == curentCount) {

						Bukkit.broadcastMessage(finalmessage);
					}
				}
				if (useXp) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.setLevel(curentCount);
					}
				}

				if (useTitle && curentCount <= 5) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						Title.newTitle(player, titleColor + String.valueOf(curentCount), 5, 10, 1);
					}
				}

				if (curentCount == 0) {
					Bukkit.getScheduler().cancelTask(Scheduler);
					CountdownFinishEvent finishEvent = new CountdownFinishEvent(this);
					MinigamesApi.countDownEvent.CountDownFinish(finishEvent);
				}
				curentCount--;
			}
		}, 0L, 20L);
	}

	public void Stop() {
		Bukkit.getScheduler().cancelTask(Scheduler);
	}

	public int[] getCountdowntimes() {
		return Countdowntimes;
	}

	public void setCountdowntimes(int[] countdowntimes) {
		Countdowntimes = countdowntimes;
	}

	public int getStartValue() {
		return Startvalue;
	}

	public void setStartValue(int Startvalue) {
		this.Startvalue = Startvalue;
	}

	public Boolean getUseXp() {
		return useXp;
	}

	public void setUseXp(Boolean useXp) {
		this.useXp = useXp;
	}

	public Boolean getUseTitle() {
		return useTitle;
	}

	public void setUseTitle(Boolean useTitle) {
		this.useTitle = useTitle;
	}

	public ChatColor getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(ChatColor titleColor) {
		this.titleColor = titleColor;
	}

}
