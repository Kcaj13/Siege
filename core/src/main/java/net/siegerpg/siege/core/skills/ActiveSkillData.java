package net.siegerpg.siege.core.skills;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

/**
 * This class stores the skill data for each skill a player has currently activated
 */
public class ActiveSkillData {

	protected static HashMap< UUID, HashSet< Skill > > currentlyActiveSkills = new HashMap<>();

	/**
	 * Gets the list of currently active skills of the player
	 *
	 * @param player The player
	 *
	 * @return The instant when the skill will be usable again
	 */
	@Nullable
	public static HashSet< Skill > getActiveSkills(OfflinePlayer player) {

		return currentlyActiveSkills.get(player.getUniqueId());
	}

	/**
	 * Finds if a player has a skill currently active
	 *
	 * @param player The player that has that skill
	 * @param skill  The skill that should be checked
	 *
	 * @return Whether or not the player has the skill  active
	 */
	public static boolean isActive(OfflinePlayer player, Skill skill) {

		for (Skill currentSkill : currentlyActiveSkills.getOrDefault(player.getUniqueId(), new HashSet<>())) {
			if (currentSkill.getIdentifier().equals(skill.getIdentifier())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a skill to the list of currently active skills of the player
	 *
	 * @param player The player
	 * @param skill  The skill to add to the list
	 */
	@Nullable
	public static void addToActiveSkills(OfflinePlayer player, Skill skill) {

		currentlyActiveSkills
				.computeIfAbsent(player.getUniqueId(), k -> new HashSet<>());
		HashSet< Skill > activeSkills = currentlyActiveSkills.get(player.getUniqueId());
		activeSkills.add(skill);
		currentlyActiveSkills.put(player.getUniqueId(), activeSkills);
	}

	/**
	 * Remove a skill from the list of currently active skills of the player
	 *
	 * @param player The player
	 * @param skill  The skill to add to the list
	 */
	@Nullable
	public static void removeFromActiveSkills(OfflinePlayer player, Skill skill) {

		for (Skill currentSkill : currentlyActiveSkills.getOrDefault(player.getUniqueId(), new HashSet<>())) {
			if (currentSkill.getIdentifier().equals(skill.getIdentifier())) {
				currentlyActiveSkills
						.computeIfAbsent(player.getUniqueId(), k -> new HashSet<>());
				HashSet< Skill > activeSkills = currentlyActiveSkills.get(player.getUniqueId());
				activeSkills.remove(currentSkill);
				currentlyActiveSkills.put(player.getUniqueId(), activeSkills);
			}
		}
	}

}
