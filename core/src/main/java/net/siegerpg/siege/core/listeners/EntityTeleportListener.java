package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EntityTeleportListener implements Listener {

	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {

		if (!Bukkit
				.getOnlinePlayers()
				.contains(e.getPlayer())) return;
		Bukkit
				.getServer()
				.getScheduler()
				.runTaskLater(Core.plugin(), () -> {
					Scoreboard.updateScoreboard(e.getPlayer());
				}, 2);
	}

}
