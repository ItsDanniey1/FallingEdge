package me.ItsDanniey1.FallingEdge.GameLogic;

import org.bukkit.ChatColor;

import me.ItsDanniey1.FallingEdge.Utils;

public class StateManager {

	private static GameState STATE = GameState.WAITING;

	public static GameState getState() {
		return STATE;
	}

	public static void setState(GameState gs) {
		
		STATE = gs;

		switch (gs) {
		
		case WAITING:
			Utils.broadcast(ChatColor.GOLD + "Entering lobby mode");
			break;
		case WARMUP:
			Utils.broadcast(ChatColor.AQUA + "Warmup in progress");
			break;
		case IN_PROGRESS:
			Utils.broadcast(ChatColor.RED + "Game has started!");
			break;
		case ENDED:
			Utils.broadcast(ChatColor.RED + "Game ended");
			break;
		}
	}

}
