package me.ItsDanniey1.FallingEdge;

import java.util.HashMap;

import me.ItsDanniey1.FallingEdge.FEPlayer;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Cache {
	
	public static HashMap<String, Integer> usedSpawns = new HashMap<>();
	public static HashMap<Player, String> AlivePlayers = new HashMap<Player, String>();
	public static HashMap<Player, String> DeadPlayers = new HashMap<Player, String>();
	public static HashMap<String, FEPlayer> FEPlayers = new HashMap<String, FEPlayer>();
	public static HashMap<Player, String> Classes = new HashMap<Player, String>();
	public static HashMap<Location, Integer> filledChests = new HashMap<Location, Integer>();;

	
	public static void clearAll() {
		usedSpawns.clear();
		AlivePlayers.clear();
		DeadPlayers.clear();
		FEPlayers.clear();
		Classes.clear();
		
	}

}
