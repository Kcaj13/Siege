package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Fireman extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 5000;
	final int duration = 30;

	public Fireman() {
		this.identifier = "2_B_3";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Fireman";
		this.description = List.of(
				"Effects yourself with speed III",
				"and burns all mobs in 6 blocks",
				"for 30 seconds"
		                          );
	}

	@Override
	public List< String > getDescription() {
		return this.description;
	}
	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of(
				"Effects yourself with speed III",
				"and burns all mobs in 6 blocks",
				"for " + getDuration(level) + " seconds"
		              );
	}

	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.05));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 5.0);
	}

	public double getDuration(int level) {

		return (this.duration) + ((level-1) * 2);
	}



	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;


		// Handling of the skill goes here
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (int) (20 * getDuration(level)), 3));

		Location location = player.getLocation();

		for (LivingEntity entity : location.getNearbyLivingEntities(6, 6, 6)) {
			if (!entity.equals(player)) {
				entity.setFireTicks((int) (20 * getDuration(level)));
			}
		}

		triggerEnd(player, level);

		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
