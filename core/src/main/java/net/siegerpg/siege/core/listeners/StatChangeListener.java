package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class StatChangeListener implements Listener, Runnable {

	public static void statBarDisplayTask() {

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
				for (Player p : Bukkit.getOnlinePlayers()) {
					HashMap< Player, Double > playerHealth = PlayerData.playerHealth;
					HashMap< Player, Integer > playerMana = PlayerData.playerMana;
					if (playerHealth.get(p) == null) continue;
					if (PlayerData.hasActionBar.get(p)) continue;
					double health = Utils.round(playerHealth.get(p), 1);
					int mana = playerMana.get(p);

					double currentHealth = Utils.round(p.getHealth(), 1);
					int currentMana = PlayerData.playerCurrentMana.get(p);

					PlayerData.hasActionBar.put(p, true);
					p.sendActionBar(Utils.parse(
							"<red>" + currentHealth + "<dark_red>/" + health + " \u2764"+
							"    <aqua>" + currentMana + "<dark_aqua>/" + mana + " \u2740"));
				}
				for (Player p : Bukkit.getOnlinePlayers()) {
					PlayerData.hasActionBar.put(p, false);
				}
			}, 0, 20);
	}

	@Override
	public void run() {

	}

}
