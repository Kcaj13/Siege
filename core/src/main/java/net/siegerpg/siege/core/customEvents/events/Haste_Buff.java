package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.miscellaneous.GoldEXPSpawning;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Haste_Buff extends CustomEvent {

	BukkitTask currentTask;

	public Haste_Buff() {
		this.duration = 1800;
	}

	public Haste_Buff(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable() {
		return Utils.randTest(25.0);
	}

	@Override
	public void action() {

		this.currentTask = new BukkitRunnable() {
			@Override
			public void run() {
				PotionEffect potion = new PotionEffect(PotionEffectType.FAST_DIGGING, 100, 1);
				for (Player player : Bukkit.getOnlinePlayers()) { //trigger all events
					player.addPotionEffect(potion, true);
				}
			}
		}.runTaskTimer(Core.plugin(), 80, 80L); //checks for event every 10 seconds

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#F0E72E>You can mine faster!"));
		Bukkit.broadcast(Utils.parse("<color:#F2CC60>Haste will be in effect for 30 minutes."));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

	@Override
	public void clearAction() {

		this.currentTask.cancel();
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#F2CC60>The haste event has passed."));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

}
