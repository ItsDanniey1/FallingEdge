package me.ItsDanniey1.FallingEdge.GameLogic;

import java.util.HashSet;
import java.util.Random;

import me.ItsDanniey1.FallingEdge.MapManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.*;

import daneffectapi.DanEffectAPI;
import daneffectapi.Particles;

public class AutomationManager implements Runnable {
	
	@SuppressWarnings("unused")
	private int tick = 0;
	private static int taskID;
	
	private int START_X = MapManager.getFloorCoords()[0];
	private int END_X = MapManager.getFloorCoords()[1];
	private int START_Z = MapManager.getFloorCoords()[2];
	private int END_Z = MapManager.getFloorCoords()[3];
	private int MAIN_Y = MapManager.getFloorCoords()[4];
	
	private Random random = new Random();
	public static HashSet<Block> blocks = new HashSet<Block>();
			
	
	@Override
	public void run() {
		tick++;
		
		int randX = random.nextInt(END_X - START_X + 1) + START_X;
		int randZ = random.nextInt(END_Z - START_Z + 1) + START_Z;
		Block block = MapManager.getWorld().getBlockAt(randX, MAIN_Y, randZ);
		if(!blocks.contains(block)) {
			blocks.add(block);
			DanEffectAPI.playEffect(block.getLocation(), Particles.EXPLOSION, 0.5F, 10);
			//block.breakNaturally();
			block.setType(Material.AIR);
			block.getDrops().clear();
		}
		
	}
	public void setTaskID(int i) {
		taskID = i;
	}
	
	public static void cancelTask() {
		Bukkit.getServer().getScheduler().cancelTask(taskID);
	}
	
	public static int generateNumber(int max , int min) {
	    @SuppressWarnings("unused")
		Random rand = new Random();
	    int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
	    return ii;
	}

}
