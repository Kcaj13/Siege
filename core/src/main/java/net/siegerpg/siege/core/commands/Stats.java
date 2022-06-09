package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.listeners.CustomItemKotlinListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.math.*;

public class Stats implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}
		OfflinePlayer player = (Player) sender;
		if (args.length > 0) {
			OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);
			if (!argPlayer.isOnline()) {
				((Player) player).sendMessage(Utils.lore("<red>That player can not be found."));
				return false;
			}
			player = argPlayer;
		}
		((Player)sender).playSound(((Player)sender).getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.5f);

		BigDecimal health = BigDecimal.valueOf(CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.HEALTH));
		BigDecimal strength = BigDecimal.valueOf(CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.STRENGTH));
		BigDecimal toughness =
				BigDecimal.valueOf(
						(CustomItemKotlinListener.Companion.calcReducedToughness(
								CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.DEFENSE)) / 1000)*100);
		BigDecimal luck = BigDecimal.valueOf(CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.LUCK));
		BigDecimal regeneration = BigDecimal.valueOf(CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.REGENERATION));

		sender.sendMessage("");
		sender.sendMessage("");
		sender.sendMessage(Utils.lore("<color:#EECB66><bold>Specifics"));
		sender.sendMessage(Utils.lore(" "));
		sender.sendMessage(Utils.lore("  <dark_red>Strength <reset><gray>You deal <yellow>"+strength+"<r><gray> damage to your target's health points."));
		sender.sendMessage(Utils.lore("  <blue>Defense <reset><gray>You prevent <yellow>" + toughness + "<r><gray>% incoming damage."));
		sender.sendMessage(Utils.lore("  <red>Health <reset><gray>You have <yellow>"+health+" <r><gray>extra health."));
		sender.sendMessage(Utils.lore("  <gold>Regeneration <reset><gray>You heal <yellow>" + BigDecimal.valueOf(regeneration.doubleValue()/5) + "<r><gray> health every <bold>" +
		                              BigDecimal.valueOf((PlayerData.getRegenRate((int) regeneration.doubleValue()))/20.0) + " <r><gray>second(s) on full hunger"));
		sender.sendMessage(Utils.lore("  <green>Luck <reset><gray>You have a <yellow>"+luck+"<r><gray>% chance to get double the drops, EXP, and gold. For every 100 luck, you get a higher drops multiplier."));
		sender.sendMessage("");
		sender.sendMessage("");


		return true;
	}

}

