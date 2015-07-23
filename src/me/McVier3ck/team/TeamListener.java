package me.McVier3ck.team;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.McVier3ck.main.MinigamesApi;

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
	
	
	@EventHandler
	private void allowInteractBlock(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		for (Team team : MinigamesApi.Teams) {
			if(team.containsPlayer(player)) {
				if(!team.getAllowInteract()) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	private void allowInteractEntity(PlayerInteractAtEntityEvent e) {
		Player player = e.getPlayer();
		for (Team team : MinigamesApi.Teams) {
			if(team.containsPlayer(player)) {
				if(!team.getAllowInteract()) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	private void allowDamage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			for (Team team : MinigamesApi.Teams) {
				if(team.containsPlayer(player)) {
					if(!team.getAllowInteract()) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	
}
