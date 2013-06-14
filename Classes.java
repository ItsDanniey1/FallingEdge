package me.ItsDanniey1.FallingEdge.GameLogic;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.*;

import me.ItsDanniey1.FallingEdge.Cache;
import me.ItsDanniey1.FallingEdge.FallingEdge;
import me.ItsDanniey1.FallingEdge.Utils;

public class Classes implements Listener {

	public static FallingEdge plugin;

	public final HashMap<Location, String> classSigns = new HashMap<Location, String>();

	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		//Swordsman
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(3).contains("SWORDSMAN")) {
					
					Cache.Classes.put(player, "swordsman");
					Utils.msg(player, ChatColor.RED + "You have chosen: " + ChatColor.AQUA + "SWORDSMAN!");
				}
			}
			
			

		}
		//Archer
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(3).contains("ARCHER")) {

					Cache.Classes.put(player, "archer");
					Utils.msg(player, ChatColor.RED + "You have chosen: " + ChatColor.AQUA + "ARCHER!");
					
				}
			}
		}
		//Mage
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(3).contains("MAGE")) {

					Cache.Classes.put(player, "mage");
					Utils.msg(player, ChatColor.RED + "You have chosen: " + ChatColor.AQUA + "MAGE!");
					
					if (player.getName().equals("pol161998")){
						e.setCancelled(true);
					}
				}
			}
		}

	}

}
