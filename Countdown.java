package me.ItsDanniey1.FallingEdge.GameLogic;

import me.ItsDanniey1.FallingEdge.FallingEdge;
import me.ItsDanniey1.FallingEdge.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


public class Countdown implements Runnable {
	
	private static int taskID;
	private int tick = 0;

	@Override
	public void run() {
		
		if(tick==0) FallingEdge.prepGame();
		
		if(tick==10) {
			StateManager.setState(GameState.IN_PROGRESS);
			FallingEdge.startGame();
		}
		
		if(tick == 30) {
			
			AutomationManager am = new AutomationManager();
			am.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(FallingEdge.plugin, am, 0L, 1L));
			
			Utils.broadcast(ChatColor.GOLD + "THE FLOOR HAS STARTED DISAPPEARING!");
		}
		
		if(tick == 100) {
			cancelTask();
			
			FallingEdge.setupChests(true);
			Utils.broadcast(ChatColor.GOLD + "CHESTS REFILLED!");
		}
		
		if(tick<=9) {
		Utils.broadcast(ChatColor.YELLOW+"Game starting in "+ChatColor.GREEN+(10-tick)+" seconds");
		}
		
		tick++;
	}
	
	public void setTaskID(int i) {
		this.taskID = i;
	}
	
	public static void cancelTask() {
		Bukkit.getServer().getScheduler().cancelTask(taskID);
	}
	
}
