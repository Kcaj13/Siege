package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class WoundingStrike extends Skill {

	final int initCooldown = 25 * 1000;
	final int initManaCost = 75;
	final int initGoldCost = 5000;
	final int duration = 3;

	private final String identifier = "3_B_1";
	private final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Wounding Strike";
	private final List< String > description =
			List.of("Deals +75% damage and",
			        "reduces enemy healing by 50%",
			        "for 3 seconds. If enemy is",
			        "weakened reduce for 6 seconds");

	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("Deals +75% damage and",
		               "reduces enemy healing by 50%",
		               "for "+((getDuration(level, false) - 1) * 100)+" seconds. If enemy is",
		               "weakened reduce for "+((getDuration(level, true) - 1) * 100)+" seconds");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.02));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 3.0);
	}

	public double getDuration(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.duration + 3) + ((level - 1) * 0.3)), 2);
		return Utils.round(((this.duration) + ((level - 1) * 0.3)), 2);
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