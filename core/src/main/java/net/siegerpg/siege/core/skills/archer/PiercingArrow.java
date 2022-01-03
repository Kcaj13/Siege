package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class PiercingArrow extends Skill {

	final int initCooldown = 25 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 2500;
	final double damageMulti = 0.1; //percentage to remove health by (1-0.1)*health = newHealth
	private final String identifier = "2_A_2";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Piercing Arrow";
	private final List< String > description =
			List.of(
					"The arrow will damage the enemy for",
					"10% of their health if you and the",
					"target are poisoned. If neither",
					"condition passes it becomes a poison arrow"
			       );

	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of(
				"The arrow will damage the enemy for",
				(getDamageMulti(level, true) * 100) + "% of their health if you and the",
				"target are poisoned. If neither",
				"condition passes it becomes a poison arrow"
		              );
	}


	@Override
	public Duration getCooldown(int level) {

		int time = (int) (this.initCooldown + Math.ceil(this.initCooldown * level * 0.04));
		return Duration.ofMillis(time);
	}

	@Override
	public double getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * level * 0.05));
	}


	public double getDamageMulti(int level, boolean poisoned) {

		if (poisoned) return (this.damageMulti) + (level * 0.01);
		return this.damageMulti;
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 2.5);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		return super.trigger(player, level);

		// Handling of the skill goes here
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}