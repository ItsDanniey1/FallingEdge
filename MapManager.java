package me.ItsDanniey1.FallingEdge;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class MapManager {

	public static int map = 0;
	public static String worldList[] = { "Void Map2", "Wooden Retreat" };

	public static World getWorld() {
		switch (map) {
		case 0:
			return Bukkit.getServer().getWorld(worldList[0]);
		case 1:
			return Bukkit.getServer().getWorld(worldList[1]);
		}
		return null;
	}

	public static double[][] getSpawns() {
		double spawns1[][] = {
		{-23.5,90.5,-99.5,-180},
		{-34.5,90.5,-99.5,-150},
		{-43.5,90.5,-103.5,-120},
		{-47.5,90.5,-112.5,-95},
		{-47.5,90.5,-123.5,-90},
		{-47.5,-0.5,-134.5,-60},
		{-43.5,90.5,-143.5,-30},
		{-34.5,90.5,-147.5,-25},
		{-23.5,90.5,147.5,0},
		{-12.5,90.5,-147.5,25},
		{-3.5,90.5,-143.5,30},
		{0.5,90.5,-134.5,60},
		{0.5,90.5,-123.5,90},
		{0.5,90.5,-112.5,120},
		{-3.5,90.5,-103.5,135},
		{-12.5,90.5,-99.5,160},
		};
		
		double spawns2[][] = {
		{-37, 95, 105, 0, 0},
		{-31, 95, 105, 0, 28},
		{-24, 95, 105, 1, 45},
		{-24, 95, 112, 1, 65},
		{-24, 95, 118, 1, 90},
		{-24, 95, 124, 1, 115},
		{-24, 95, 131, 2, 135},
		{-31, 95, 131, 2, 155},
		{-37, 95, 131, 2, -180},
		{-43, 95, 131, 2, -153},
		{-50, 95, 131, 2, -135},
		{-50, 95, 124, 3, -114},
		{-50, 95, 118, 3, -90},
		{-50, 95, 112, 3, -64},
		{-50, 95, 105, 3, -45},
		{-43, 95, 105, 0, -25},
 };

		switch (map) {
		case 0:
			return spawns1;
		case 1:
			return spawns2;
		}
		return null;
	}

	public static Location[] getLowerChests() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(-18, 92, -118).getLocation()),
				(MapManager.getWorld().getBlockAt(-30, 92, -130).getLocation()),
				(MapManager.getWorld().getBlockAt(-30, 92, -118).getLocation()),
				(MapManager.getWorld().getBlockAt(-18, 92, -130).getLocation()), };

		Location[] chests2 = {
				(MapManager.getWorld().getBlockAt(-38, 95, 117).getLocation()),
				(MapManager.getWorld().getBlockAt(-39, 95, 118).getLocation()),
				(MapManager.getWorld().getBlockAt(-38, 95, 119).getLocation()),
				(MapManager.getWorld().getBlockAt(-37, 95, 118).getLocation()), };

		switch (map) {
		case 0:
			return chests1;
		case 1:
			return chests2;
		}
		return null;
		
		
	}
	
	public static Location[] getBestChest() {
		Location[] bchest1 = {
				(MapManager.getWorld().getBlockAt(-24, 91, -124).getLocation())
		};
		Location[] bchest2 = {
				(MapManager.getWorld().getBlockAt(-38, 104, 118).getLocation())
				
		};
		
		switch (map) {
		case 0:
			return bchest1;
		case 1:
			return bchest2;
		}
		return null;
	}
	
	public static int[] getFloorCoords() {
		int coords1[] = {
				-51,3,-151,-97,89
		};
		
		int coords2[] = {
				-58,-18,98,138,93
		};
		
		int def[] = {
				0,0,0,0,0
		};
		
		switch (map) {
		case 0:
			return coords1;
		case 1:
			return coords2;
		}
		return def;
	}
}
