package me.ItsDanniey1.FallingEdge.Powerups;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class Powerups {

	public static ItemStack getFreeze() {
		ItemStack is = new ItemStack(Material.SLIME_BALL, 1);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Sticky trouble!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Freeze all players");
		lore.add("except yourself!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}

	public static ItemStack getBook() {
		ItemStack is = new ItemStack(Material.WRITTEN_BOOK, 1);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		BookMeta bm = (BookMeta) is.getItemMeta();
		bm.setAuthor("the Creators");
		bm.setTitle(ChatColor.RED + "Falling Edge");
		ArrayList<String> pages = new ArrayList<String>();
		pages.add(ChatColor.DARK_PURPLE + "Falling Edge" + ChatColor.DARK_RED
				+ " is a custom server gametype created by DCDJ and Danniey1!"
				+ ChatColor.DARK_PURPLE + "\n\n\n\nFalling Edge"
				+ ChatColor.DARK_RED + " is best described as PVP Spleef!");
		pages.add(ChatColor.DARK_RED
				+ "The way to win "
				+ ChatColor.DARK_PURPLE
				+ "Falling Edge "
				+ ChatColor.DARK_RED
				+ "is by being the last player alive. \n\nYou will have to be careful though, as not only do you have enemy players to worry about, but after 20 seconds the floor begins to disappear as well!");
		pages.add(ChatColor.GOLD.toString()
				+ ChatColor.BOLD.toString()
				+ "POWERUPS"
				+ ChatColor.BLUE
				+ "\n\nEnergised!"
				+ ChatColor.DARK_RED
				+ "\nEnergised will give the user 10 seconds of a Speed 2 boost!"
				+ ChatColor.BLUE
				+ "\n\nSticky Trouble!"
				+ ChatColor.DARK_RED
				+ "\n Sticky Trouble will freeze all other players for 3 seconds!");
		pages.add(ChatColor.BOLD.toString() + ChatColor.GOLD.toString()
				+ "POWERUPS (cont)" + ChatColor.BLUE + "\n\nFling Up!"
				+ ChatColor.DARK_RED + "\nFling all enemies up into the air!"
				+ ChatColor.BLUE + "\n\nCursed Coal!" + ChatColor.DARK_RED
				+ "\nBlind all you enemies for 20 seconds!");
		pages.add(ChatColor.BOLD.toString()
				+ ChatColor.GOLD.toString()
				+ "POWERUPS (cont)"
				+ ChatColor.BLUE
				+ "\n\nBlazed Over!"
				+ ChatColor.DARK_RED
				+ "\nBecome invisible for 10 seconds - Don't forget to take off armour though!");
		bm.setPages(pages);
		is.setItemMeta(bm);
		return is;
	}

	public static ItemStack getSpeed() {
		ItemStack is = new ItemStack(Material.FERMENTED_SPIDER_EYE);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Energised!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_PURPLE + "Get a speed");
		lore.add(ChatColor.DARK_PURPLE + "boost for 10s!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;

	}

	public static ItemStack flingUp() {
		ItemStack is = new ItemStack(Material.FEATHER);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Fling Up!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_PURPLE + "Fling all players");
		lore.add(ChatColor.DARK_PURPLE + "into the air!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;

	}

	public static ItemStack getCarrot() {
		ItemStack is = new ItemStack(Material.COAL);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Cursed coal!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_PURPLE + "Make everyone in the");
		lore.add(ChatColor.DARK_PURPLE + "arena blind except yourself!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;

	}

	public static ItemStack getInvis() {
		ItemStack is = new ItemStack(Material.BLAZE_POWDER);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Blazed over!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_PURPLE + "Right click and");
		lore.add(ChatColor.DARK_PURPLE + "become invisible for 10s!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;

	}

	public static ItemStack getStaff() {
		ItemStack is = new ItemStack(Material.BLAZE_ROD, 64);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Arrow Staff!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_PURPLE + "Kill your enemies with");
		lore.add(ChatColor.DARK_PURPLE + "the essence of fire!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;

	}
	
	public static ItemStack pickupStaff() {
		ItemStack is = new ItemStack(Material.BLAZE_ROD, 1);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Arrow Staff!");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_PURPLE + "Kill your enemies with");
		lore.add(ChatColor.DARK_PURPLE + "the essence of fire!");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;

	}

}
