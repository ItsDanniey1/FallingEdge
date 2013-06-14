package me.ItsDanniey1.FallingEdge;

import me.ItsDanniey1.FallingEdge.Powerups.Powerups;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerInteractEvents implements Listener {

	@EventHandler
	public void freezePlayers(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.getFreeze().getType()) {
				for (Player player : Cache.AlivePlayers.keySet()) {
					if (player.getName().equals(event.getPlayer().getName()))
						continue;
					PotionEffect pe = new PotionEffect(PotionEffectType.SLOW,
							60, 60);
					player.addPotionEffect(pe);
					Utils.msg(player, ChatColor.RED + "You were frozen by "
							+ ChatColor.BLUE + event.getPlayer().getName());
				}
				Utils.msg(event.getPlayer(), ChatColor.DARK_AQUA
						+ "All players Slowed!");
				event.getPlayer().setItemInHand(null);

			}
		}
	}

	@EventHandler
	public void speedBoost(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.getSpeed().getType()) {
				Player player = event.getPlayer();
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
						200, 2));
				Utils.msg(player, ChatColor.AQUA + "You now have "
						+ ChatColor.GOLD + "Speed 2 " + ChatColor.AQUA
						+ "boost!");
				event.getPlayer().setItemInHand(null);

			}
		}
	}

	@EventHandler
	public void poisonCarrot(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.getCarrot().getType()) {
				
				for (Player player : Cache.AlivePlayers.keySet()) {
					if (player.getName().equals(event.getPlayer().getName()))
						continue;
					PotionEffect pe = new PotionEffect(
							PotionEffectType.BLINDNESS, 200, 2);
					player.addPotionEffect(pe);
					Utils.msg(player, ChatColor.RED + "You were poisoned by "
							+ ChatColor.BLUE + event.getPlayer().getName());
				}
				
				Utils.msg(event.getPlayer(), ChatColor.DARK_AQUA
						+ "Everyone's poisoned!");
				event.getPlayer().setItemInHand(null);

			}
		}
	}

	@EventHandler
	public void blazeInvis(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.getInvis().getType()) {
				Player player = event.getPlayer();
				player.addPotionEffect(new PotionEffect(
						PotionEffectType.INVISIBILITY, 200, 2));
				Utils.msg(player, ChatColor.AQUA + "You are now "
						+ ChatColor.GOLD + "INVISIBLE!");
				event.getPlayer().setItemInHand(null);

			}
		}
	}

	@EventHandler
	public void fireStaff(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.getStaff().getType()) {
				Player player = event.getPlayer();
				Arrow arrow = (Arrow) player.launchProjectile(Arrow.class);
				ItemStack is = player.getItemInHand();
				is.setAmount(is.getAmount() - 1);
				player.setItemInHand(is);
			}
		}
	}

	
	@EventHandler
	public void firePickup(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.pickupStaff().getType()) {
				Player player = event.getPlayer();
				Arrow arrow = (Arrow) player.launchProjectile(Arrow.class);
				ItemStack is = player.getItemInHand();
				is.setAmount(is.getAmount() - 1);
				player.setItemInHand(is);
			}
		}
	}
	@EventHandler
	public void flingUp(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getItemInHand().getType() == Powerups
					.flingUp().getType()) {
				for (Player player : Cache.AlivePlayers.keySet()) {
					if (player.getName().equals(event.getPlayer().getName()))
						continue;

					player.setVelocity(new Vector(player.getVelocity().getX(),
							1.2, player.getVelocity().getZ()));

					Utils.msg(player, ChatColor.RED
							+ "You were thrown into the air by "
							+ ChatColor.BLUE + event.getPlayer().getName());

				}
				Utils.msg(event.getPlayer(), ChatColor.DARK_AQUA
						+ "Opponents thrown into the air!");
				event.getPlayer().setItemInHand(null);
			}

		}
	}
	
	
}
