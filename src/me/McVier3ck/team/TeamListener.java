package me.McVier3ck.team;

import me.McVier3ck.main.MinigamesApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class TeamListener implements Listener{

	@EventHandler
	private void friendlyFire(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player geter = (Player) e.getEntity();
			Player seter = (Player) e.getDamager();
			for (Team team : MinigamesApi.Teams) {
				if(team.containsPlayer(geter) && team.containsPlayer(seter)) {
					if(!team.getFriendlyFire()) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	
}
