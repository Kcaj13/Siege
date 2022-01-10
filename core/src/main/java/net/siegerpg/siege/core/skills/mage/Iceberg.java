package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Iceberg extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 80;
	final int initGoldCost = 5000;
	final double damageMulti = 2.0;

	private final String identifier = "2_A_2";
	private final SkillClass skillClass = SkillClass.MAGE;
	private final String name = "Iceberg";
	private final List< String > description =
			List.of("Throws a block of ice",
			        "at a target for +200%",
			        "of your strength. Deals",
			        "+250% if enemy is slowed.");

	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("Throws a block of ice",
		               "at a target for +"+((getDamageMulti(level, false)-1) * 100)+"%",
		               "of your strength. Deals",
		               "+"+((getDamageMulti(level, true)-1) * 100)+"% if enemy is slowed.");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.025));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getDamageMulti(int level, boolean slowed) {
		if (slowed) return (this.damageMulti + 0.5) + ((level-1) * 0.05);
		return this.damageMulti + ((level-1) * 0.05);
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