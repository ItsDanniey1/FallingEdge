package me.ItsDanniey1.FallingEdge;

import java.util.Random;

import me.ItsDanniey1.FallingEdge.GameLogic.AutomationManager;
import me.ItsDanniey1.FallingEdge.GameLogic.Classes;
import me.ItsDanniey1.FallingEdge.GameLogic.Countdown;
import me.ItsDanniey1.FallingEdge.GameLogic.GameManager;
import me.ItsDanniey1.FallingEdge.GameLogic.StateManager;
import me.ItsDanniey1.FallingEdge.GameLogic.GameState;
import me.ItsDanniey1.FallingEdge.GameLogic.PlayerMovement;
import me.ItsDanniey1.FallingEdge.Powerups.Powerups;
import me.ItsDanniey1.FallingEdge.FEPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class FallingEdge extends JavaPlugin implements Listener {

	public static FallingEdge plugin;

	@Override
	public void onDisable() {
		Bukkit.broadcastMessage(ChatColor.GOLD + "FallingEdge by ItsDanniey1 -"
				+ ChatColor.BOLD + ChatColor.DARK_BLUE + "DISABLED!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "Version 0.1!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");
		for (Player players : Bukkit.getServer().getOnlinePlayers()) {
			Inventory inv = players.getInventory();
			inv.clear();

		}

	}

	@Override
	public void onEnable() {
		Bukkit.broadcastMessage(ChatColor.GOLD + "FallingEdge by ItsDanniey1 -"
				+ ChatColor.BOLD + ChatColor.AQUA + "ENABLED!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "Version 0.1!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");

		Bukkit.getServer().createWorld(
				new WorldCreator(MapManager.worldList[0]));
		Bukkit.getServer().createWorld(
				new WorldCreator(MapManager.worldList[1]));

		MapManager.map = 0;

		for (Player player : Bukkit.getOnlinePlayers()) {
			World world = MapManager.getWorld();
			world.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 1, 1);
			Location lobbyspawn = new Location(world, -21.5, 112, -123.5, 90, 0);
			world.setSpawnLocation(-21, 112, -123);

			player.teleport(lobbyspawn);
			Inventory inv = player.getInventory();
			inv.clear();
			inv.addItem(Powerups.getBook());
			player.setGameMode(GameMode.ADVENTURE);
			((PlayerInventory) inv).setArmorContents(null);
			player.setHealth(20);
			player.setFoodLevel(20);
			Cache.Classes.put(player, "swordsman");

		}

		System.out.println("Registering listeners...");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new PlayerMovement(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new PlayerInteractEvents(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Classes(), this);
		System.out.println("DONE!");

		GameManager gm = new GameManager();
		gm.setTaskID(Bukkit.getServer().getScheduler()
				.scheduleSyncRepeatingTask(this, gm, 0L, 20L));

		MapManager.getWorld().setAutoSave(false);

		plugin = this;

		MapManager.getWorld().setMonsterSpawnLimit(0);
			}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		World world = Bukkit.getServer().getWorld(MapManager.worldList[0]);
		Location lobbyspawn = new Location(world, -21, 112, -123.5, 90, 0);
		world.setSpawnLocation(-21, 112, -123);
		player.teleport(lobbyspawn);
		Inventory inv = player.getInventory();
		inv.addItem(Powerups.getBook());
		((PlayerInventory) inv).setArmorContents(null);
		Cache.Classes.put(player, "swordsman");
		player.setGameMode(GameMode.ADVENTURE);

		if (StateManager.getState() == GameState.IN_PROGRESS) {
			player.kickPlayer("GAME IN PROGRESS MOFO.");
		}

	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("mobs")) {

			for (Entity e : player.getWorld().getEntities()) {

				if (e instanceof Player) {
					continue;
				}
				e.remove();
			}

			Bukkit.broadcastMessage("Entities removed");
		}

		if (commandLabel.equalsIgnoreCase("day")) {

			World world = player.getWorld();
			world.setTime(1);
		}
		
		if (commandLabel.equalsIgnoreCase("clear")) {

			World world = player.getWorld();
			world.setTime(1);
		}

		if (commandLabel.equalsIgnoreCase("progress")) {

			StateManager.setState(GameState.IN_PROGRESS);
		}

		if (commandLabel.equalsIgnoreCase("spleef")) {

			AutomationManager am = new AutomationManager();
			am.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, am, 0L, 1L));

		}

		
		if (commandLabel.equalsIgnoreCase("heal")) {

			player.setHealth(20);
			player.setFoodLevel(20);
		}
		if (commandLabel.equalsIgnoreCase("map")) {
			int map = Integer.parseInt(args[0]);
			MapManager.map = map;
			Utils.msg(player, ChatColor.GOLD + "Map changed!");
		}

		if (commandLabel.equalsIgnoreCase("reset")) {

			AutomationManager.cancelTask();

			int START_X = MapManager.getFloorCoords()[0];
			int END_X = MapManager.getFloorCoords()[1];
			int START_Z = MapManager.getFloorCoords()[2];
			int END_Z = MapManager.getFloorCoords()[3];
			int MAIN_Y = MapManager.getFloorCoords()[4];

			for (int a = START_Z; a <= END_Z; a++) {

				for (int i = START_X; i <= END_X; i++) {
					Block b = MapManager.getWorld().getBlockAt

					(START_X, MAIN_Y, START_Z);

					if (MapManager.map == 0) {
						b.setType(Material.GRASS);
					}

					if (MapManager.map == 1) {
						b.setType(Material.GRASS);
					}

					START_X = START_X + 1;
				}

				START_X = MapManager.getFloorCoords()[0];
				;
				START_Z = START_Z + 1;
			}

		}

		if (commandLabel.equalsIgnoreCase("warmup")) {

			prepGame();

		}

		if (commandLabel.equalsIgnoreCase("halt")) {

			GameManager.cancelTask();

			Utils.broadcast(ChatColor.RED + "GameManager STOPPED!");

		}

		if (commandLabel.equalsIgnoreCase("startcountdown")) {

			GameManager gm = new GameManager();
			gm.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, gm, 0L, 20L));

			Utils.broadcast(ChatColor.GREEN + "GameManager STARTED!");

		}

		if (commandLabel.equalsIgnoreCase("start")) {
			Countdown cd = new Countdown();
			cd.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, cd, 0L, 20L));

			GameManager.cancelTask();
		}

		if (commandLabel.equalsIgnoreCase("finish")) {

			MapManager.map = 0;

			GameManager gm = new GameManager();
			gm.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, gm, 0L, 20L));

			Cache.clearAll();

			Countdown.cancelTask();

			StateManager.setState(GameState.ENDED);

			setupChests(true);

			StateManager.setState(GameState.WAITING);

			AutomationManager.cancelTask();

			int START_X = MapManager.getFloorCoords()[0];
			int END_X = MapManager.getFloorCoords()[1];
			int START_Z = MapManager.getFloorCoords()[2];
			int END_Z = MapManager.getFloorCoords()[3];
			int MAIN_Y = MapManager.getFloorCoords()[4];

			for (int a = START_Z; a <= END_Z; a++) {

				for (int i = START_X; i <= END_X; i++) {
					Block b = MapManager.getWorld().getBlockAt

					(START_X, MAIN_Y, START_Z);
					b.setType(Material.GRASS);
					START_X = START_X + 1;
				}

				START_X = -51;
				START_Z = START_Z + 1;
			}

			for (Player players : Bukkit.getServer().getOnlinePlayers()) {

				players.setGameMode(GameMode.ADVENTURE);
				Inventory inventory = players.getInventory();
				World world = MapManager.getWorld();
				Location lobbyspawn = new Location(world, -21.5, 112, -123.5,
						90, 0);
				inventory.clear();
				players.teleport(lobbyspawn);
				Cache.DeadPlayers.clear();
				((PlayerInventory) inventory).setArmorContents(null);
				String p = Cache.AlivePlayers.get(players);

				Cache.Classes.put(players, "swordsman");

				if (p != null && !p.isEmpty()) {
					Utils.broadcast(ChatColor.GOLD

					+ p + ChatColor.YELLOW + " has won the game!");

					for (FEPlayer feplayer : Cache.FEPlayers.values()) {
						Utils.broadcast(ChatColor.GOLD + feplayer.getName()
								+ ChatColor.LIGHT_PURPLE + " scored "
								+ ChatColor.RED + feplayer.getKills()
								+ ChatColor.LIGHT_PURPLE + " kills and "
								+ ChatColor.RED + feplayer.getDeaths()
								+ ChatColor.LIGHT_PURPLE + " deaths!");

					}
				}
			}

		}

		return false;
	}

	public static void teleportPlayers(boolean debug) {
		int i = 0;
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			if (player == null || player.isDead())
				continue;
			Location location = new Location(MapManager.getWorld(),
					MapManager.getSpawns()[i][0], MapManager.getSpawns()[i][1],
					MapManager.getSpawns()[i][2],
					(float) MapManager.getSpawns()[i][3], (float) 0);
			player.teleport(location);
			Cache.usedSpawns.put(player.getName(), i);
			if (debug)
				Utils.broadcast("Player " + player.getName()
						+ " teleported to spawn: " + i);
			i++;
		}
	}
	
	@EventHandler
	public void death2(PlayerDeathEvent e) {
		
			e.setDeathMessage(ChatColor.DARK_RED + e.getEntity().getName()
					+ ChatColor.GOLD + " has DIED!");
			Cache.DeadPlayers.put(e.getEntity(), e.getEntity().getName());
			Cache.AlivePlayers.remove(e.getEntity());
		e.getDrops().clear();
			Player player = (Player) e.getEntity();
			FEPlayer feplayer = Cache.FEPlayers.get(player.getName());
			feplayer.addDeath();
			if (player.getKiller() != null && player.getKiller() instanceof Player) {
				FEPlayer killer = Cache.FEPlayers.get(player.getKiller().getName());
				killer.addKill();
				Utils.msg(player.getKiller(), ChatColor.YELLOW + "You now have "
						+ killer.getKills() + " kills!");
				killer.save();

				feplayer.save();
				

			}
		MapManager.map = 0;

		GameManager gm = new GameManager();
		gm.setTaskID(Bukkit.getServer().getScheduler()
				.scheduleSyncRepeatingTask(this, gm, 0L, 20L));

		Cache.clearAll();

		Countdown.cancelTask();

		StateManager.setState(GameState.ENDED);

		setupChests(true);

		GameManager gm1 = new GameManager();
		gm1.setTaskID(Bukkit.getServer().getScheduler()
				.scheduleSyncRepeatingTask(this, gm1, 0L, 20L));
		
		AutomationManager.cancelTask();

		//Reset
		int START_X = MapManager.getFloorCoords()[0];
		int END_X = MapManager.getFloorCoords()[1];
		int START_Z = MapManager.getFloorCoords()[2];
		int END_Z = MapManager.getFloorCoords()[3];
		int MAIN_Y = MapManager.getFloorCoords()[4];

		for (int a = START_Z; a <= END_Z; a++) {

			for (int i = START_X; i <= END_X; i++) {
				Block b = MapManager.getWorld().getBlockAt

				(START_X, MAIN_Y, START_Z);
				b.setType(Material.GRASS);
				START_X = START_X + 1;
			}

			START_X = -51;
			START_Z = START_Z + 1;
		}

		for (Player players : Bukkit.getServer().getOnlinePlayers()) {

			players.setGameMode(GameMode.ADVENTURE);
			Inventory inventory = players.getInventory();
			World world = MapManager.getWorld();
			Location lobbyspawn = new Location(world, -21.5, 112, -123.5,
					90, 0);
			inventory.clear();
			players.teleport(lobbyspawn);
			Cache.DeadPlayers.clear();
			((PlayerInventory) inventory).setArmorContents(null);
			String p = Cache.AlivePlayers.get(players);

			Cache.Classes.put(players, "swordsman");

			if (p != null && !p.isEmpty()) {
				Utils.broadcast(ChatColor.GOLD

				+ p + ChatColor.YELLOW + " has won the game!");

				for (FEPlayer feplayer1 : Cache.FEPlayers.values()) {
					Utils.broadcast(ChatColor.GOLD + feplayer.getName()
							+ ChatColor.LIGHT_PURPLE + " scored "
							+ ChatColor.RED + feplayer.getKills()
							+ ChatColor.LIGHT_PURPLE + " kills and "
							+ ChatColor.RED + feplayer.getDeaths()
							+ ChatColor.LIGHT_PURPLE + " deaths!");

				}
			}
		}

	}

	//@EventHandler
	//public void onPlayerDeath(PlayerDeathEvent e) {


		//if (Cache.AlivePlayers.size() == 1) {

			//Countdown.cancelTask();

			//AutomationManager.cancelTask();

			//GameManager gm1 = new GameManager();
			//gm1.setTaskID(Bukkit.getServer().getScheduler()
			//		.scheduleSyncRepeatingTask(this, gm1, 0L, 20L));

			// RESET

			//int START_X = MapManager.getFloorCoords()[0];
			//int END_X = MapManager.getFloorCoords()[1];
			//int START_Z = MapManager.getFloorCoords()[2];
			//int END_Z = MapManager.getFloorCoords()[3];
			//int MAIN_Y = MapManager.getFloorCoords()[4];

			//for (int a = START_Z; a <= END_Z; a++) {

				//for (int i = START_X; i <= END_X; i++) {
				//	Block b = MapManager.getWorld().getBlockAt

				//	(START_X, MAIN_Y, START_Z);
				//	b.setType(Material.GRASS);
				//	START_X = START_X + 1;
				//}

				//START_X = -51;
				//START_Z = START_Z + 1;

				//Cache.clearAll();
			//}

			//StateManager.setState(GameState.ENDED);

			//for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				
			//	Utils.broadcast("GAME SHOULD'VE FUCKING ENDED.");

			//	players.setGameMode(GameMode.ADVENTURE);
			//	Inventory playerinv = players.getInventory();
				//World world = Bukkit.getServer().getWorld(
				//		MapManager.worldList[0]);
				//Location lobbyspawn = new Location(world, -21.5, 112, -123.5,
			//			90, 0);
				//playerinv.clear();
				//((PlayerInventory) playerinv).setArmorContents(null);
				//players.teleport(lobbyspawn);
				//String p = Cache.AlivePlayers.get(players);
				//if (p != null && !p.isEmpty()) {
			//		Utils.broadcast(ChatColor.GOLD + p + ChatColor.YELLOW
				//			+ " has won the game!");

				//}
				//players.setFoodLevel(20);
				//players.setHealth(20);

			//	Cache.Classes.put(players, "swordsman");
	//		}

	//		setupChests(true);
	//	}
		
	//	e.setDeathMessage(ChatColor.DARK_RED + e.getEntity().getName()
	//			+ ChatColor.GOLD + " has DIED!");
	//	Cache.DeadPlayers.put(e.getEntity(), e.getEntity().getName());
	//	Cache.AlivePlayers.remove(e.getEntity());
		//e.getDrops().clear();
	//	Player player = (Player) e.getEntity();
	//	FEPlayer feplayer = Cache.FEPlayers.get(player.getName());
	//	feplayer.addDeath();
	//	if (player.getKiller() != null && player.getKiller() instanceof Player) {
	//		FEPlayer killer = Cache.FEPlayers.get(player.getKiller().getName());
	//		killer.addKill();
	//		Utils.msg(player.getKiller(), ChatColor.YELLOW + "You now have "
	//				+ killer.getKills() + " kills!");
	//		killer.save();

	//		feplayer.save();
			

	//	}
//	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		int playerLoc = player.getLocation().getBlockY();
		// if (playerLoc == 85) {
		// player.setHealth(0);

		if (MapManager.map == 0) {
			if (playerLoc == 88) {
				player.setHealth(0);
			}
		}

		if (MapManager.map == 1) {
			if (playerLoc == 91) {
				player.setHealth(0);
			}
		}

	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player player = e.getPlayer();
		player.setGameMode(GameMode.ADVENTURE);
		Inventory inv = player.getInventory();
		inv.addItem(Powerups.getBook());

		MapManager.map = 0;

		World world = Bukkit.getServer().getWorld(MapManager.worldList[0]);
		world.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 1, 1);
		Location lobbyspawn = new Location(world, -21.5, 112, -123.5, 90, 0);

		player.teleport(lobbyspawn);
		player.setGameMode(GameMode.ADVENTURE);
		Cache.Classes.put(player, "swordsman");

	}

	@EventHandler
	public void playerHunger(PlayerMoveEvent e) {

		Player player = e.getPlayer();
		player.setFoodLevel(20);
	}

	public static void setupChests(boolean debug) {

		int i = 0;

		for (Location loc : MapManager.getLowerChests()) {
			Cache.filledChests.put(loc, i);
			i++;

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() != Material.CHEST) {
				chest.setType(Material.CHEST);
			}

			Chest chestinv = (Chest) chest.getState();

			Inventory inv = chestinv.getInventory();

			// NormalChest Items
			ItemStack usword = new ItemStack(Material.WOOD_SWORD, 1);
			usword.addEnchantment(Enchantment.KNOCKBACK, 1);
			usword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			ItemStack uchest = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemStack ulegs = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemStack uarrow = new ItemStack(Material.ARROW, 16);

			// BestChest Items
			// ItemStack bsword = new ItemStack(Material.STONE_SWORD, 1);
			// bsword.addEnchantment(Enchantment.KNOCKBACK, 1);
			// ItemStack bhelmet = new ItemStack(Material.IRON_HELMET, 1);
			// ItemStack bboots = new ItemStack(Material.IRON_BOOTS, 1);
			// ItemStack bbow = new ItemStack(Material.BOW, 1);
			// bbow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			// bbow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);

			inv.clear();

			if (StateManager.getState() == GameState.IN_PROGRESS) {

				inv.addItem(usword);
				inv.addItem(uchest);
				inv.addItem(ulegs);
				inv.addItem(uarrow);

				if (i == 0) {

					inv.addItem(Powerups.getSpeed());

				}

				if (i == 1) {

					inv.addItem(Powerups.getInvis());

				}

				if (i == 2) {

					inv.addItem(Powerups.flingUp());

				}

				if (i == 3) {

					inv.addItem(Powerups.getCarrot());

				}

				if (i == 4) {

					inv.addItem(Powerups.getFreeze());

				}

				if (debug)
					Utils.broadcast("Chests filled");
			}

			if (StateManager.getState() == GameState.ENDED) {
				inv.clear();

			}
			if (StateManager.getState() == GameState.WARMUP) {
				inv.clear();

			}

			if (StateManager.getState() == GameState.WAITING) {
				inv.clear();

			}

			chestinv.update();

		}

		for (Location loc : MapManager.getBestChest()) {
			Cache.filledChests.put(loc, i);
			i++;

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() != Material.CHEST) {
				chest.setType(Material.CHEST);
			}

			Chest chestinv = (Chest) chest.getState();

			Inventory inv = chestinv.getInventory();

			inv.clear();

			// BestChest Items
			ItemStack bsword = new ItemStack(Material.STONE_SWORD, 1);
			bsword.addEnchantment(Enchantment.KNOCKBACK, 1);
			ItemStack bhelmet = new ItemStack(Material.IRON_HELMET, 1);
			ItemStack bboots = new ItemStack(Material.IRON_BOOTS, 1);
			ItemStack bbow = new ItemStack(Material.BOW, 1);
			bbow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			bbow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);

			if (StateManager.getState() == GameState.IN_PROGRESS) {

				inv.addItem(bsword);
				inv.addItem(bhelmet);
				inv.addItem(bboots);
				inv.addItem(bbow);
				inv.addItem(Powerups.getFreeze());

			}

			if (StateManager.getState() == GameState.ENDED) {
				inv.clear();

			}
			if (StateManager.getState() == GameState.WARMUP) {
				inv.clear();

			}

			if (StateManager.getState() == GameState.WAITING) {
				inv.clear();

			}

		}

	}

	@EventHandler
	public void breakBlock(BlockBreakEvent event) {
		if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			return;
		} else if (!event.getPlayer().isOp()) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		Inventory inv = player.getInventory();
		inv.clear();
		Cache.FEPlayers.remove(event.getPlayer().getName());
	}

	public static void startGame() {
		setupChests(true);

		for (Player players : Bukkit.getServer().getOnlinePlayers()) {

			FEPlayer feplayer = new FEPlayer(players.getName());
			Cache.FEPlayers.put(feplayer.getName(), feplayer);

			Cache.AlivePlayers.put(players, players.getName());

			players.setHealth(20);
			players.setFoodLevel(20);

		}
		for (Player player : Cache.Classes.keySet()) {

			if (Cache.Classes.get(player).equals("swordsman")) {

				// Sword
				ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
				sword.addEnchantment(Enchantment.KNOCKBACK, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);

				// Potion of poison
				ItemStack poison = new ItemStack(373, 2, (short) 16396);

				ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);

				player.getInventory().addItem(sword);

				// Speed Boost
				player.getInventory().addItem(Powerups.getSpeed());
				player.getInventory().addItem(poison);

				((PlayerInventory) player.getInventory()).setChestplate(chest);
				((PlayerInventory) player.getInventory()).setLeggings(legs);
			}

			else if (Cache.Classes.get(player).equals("archer")) {

				// ARCHER

				// Bow
				ItemStack bow = new ItemStack(Material.BOW, 1);
				bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);

				// Arrows
				ItemStack arrow = new ItemStack(Material.ARROW, 64);

				// Dagger
				ItemStack dagger = new ItemStack(Material.WOOD_SWORD, 1);
				dagger.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				ItemMeta d = dagger.getItemMeta();
				d.setDisplayName("Dagger");
				dagger.setItemMeta(d);

				ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				player.getInventory().addItem(bow);
				player.getInventory().addItem(arrow);

				// Invis
				player.getInventory().addItem(Powerups.getInvis());
				player.getInventory().addItem(dagger);

				((PlayerInventory) player.getInventory()).setChestplate(chest);
				((PlayerInventory) player.getInventory()).setLeggings(legs);

			} else if (Cache.Classes.get(player).equals("mage")) {

				// Potion of harming >:D
				ItemStack item = new ItemStack(Material.POTION, 3);
				Potion pot = new Potion(1);
				pot.setType(PotionType.POISON);
				pot.setHasExtendedDuration(false);
				pot.setSplash(true);
				pot.apply(item);

				// CarrotPoison
				player.getInventory().addItem(Powerups.getCarrot());

				// Staff
				player.getInventory().addItem(Powerups.getStaff());

				ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				player.getInventory().addItem(item);

				((PlayerInventory) player.getInventory()).setChestplate(chest);
				((PlayerInventory) player.getInventory()).setLeggings(legs);
			}

		}
	}

	public static void prepGame() {

		for (Player player : Bukkit.getServer().getOnlinePlayers()) {

			// Inventory Management

			Inventory inventory = player.getInventory();
			inventory.clear();
			player.setGameMode(GameMode.ADVENTURE);

			player.setHealth(20);
			player.setFoodLevel(20);
			for (Entity e : player.getWorld().getEntities()) {

				if (e instanceof Player) {
					continue;
				}
				e.remove();
			}
		}

		teleportPlayers(true);
		StateManager.setState(GameState.WARMUP);

	}
}