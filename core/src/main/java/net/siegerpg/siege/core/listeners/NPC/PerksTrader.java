package net.siegerpg.siege.core.listeners.NPC;

import kotlin.Pair;
import kotlin.Triple;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.*;

public class PerksTrader implements Listener {


    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Perks") && e.getRightClicked().getName().contains("6")) {
            Inventory shop = getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("BenButcher").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("BenButcher").get(0).value(), e.getInventory())) {
            clickShop(e);
            e.setCancelled(true);
        }
    }

    private void clickShop(InventoryClickEvent e) {
        if (e.getSlot() != 14) return;

        Player player = (Player) e.getWhoClicked();
        int highestPV = Utils.getHighestPV(player);
        int cost = highestPV * 5000;

        if (VaultHook.econ.getBalance(player) < cost) {
            player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
            return;
        }
        VaultHook.perms.playerAdd(player, "cosmicvaults.amount."+(highestPV+1));
        VaultHook.econ.withdrawPlayer(player, cost);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        Scoreboard.updateScoreboard(player);
        player.sendMessage(Utils.tacc("&eYou have increased your player vault amount by 1."));
    }


    private Inventory getShopMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Perk Trading");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }
        int highestPV = Utils.getHighestPV(player);
        int cost = highestPV * 5000;
        ItemStack buyPerk = new ItemStack(Material.CHEST);
        ItemMeta buyPerkMeta = buyPerk.getItemMeta();
        buyPerkMeta.displayName(Utils.lore("<yellow>Buy +1 Vault"));
        buyPerkMeta.lore(new ArrayList<>() {
            {
                add(Utils.lore("<gray>" + highestPV + " -> " + highestPV+1));
                add(Utils.lore("<yellow>Cost " + String.format("%,d", cost)));
                add(Utils.lore("<yellow><bold>CLICK TO UPGRADE"));
            }
        });
        buyPerk.setItemMeta(buyPerkMeta);
        gui.setItem(14, buyPerk);

        player.setMetadata("PerkTrading", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}