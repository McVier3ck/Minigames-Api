package me.McVier3ck.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Items {

	public static ItemStack ItemName(Material material, int count, short damage, String name) {
		ItemStack items = new ItemStack(material, count, damage);
		ItemMeta itemMeta = items.getItemMeta();
		
		itemMeta.setDisplayName(name);
		
		items.setItemMeta(itemMeta);
		
		return items;
	}
	
	public static ItemStack ItemName(Material material, int count, String name) {
		ItemStack items = new ItemStack(material, count);
		ItemMeta itemMeta = items.getItemMeta();
		
		itemMeta.setDisplayName(name);
		
		items.setItemMeta(itemMeta);
		
		return items;
	}
	
	public static ItemStack ItemEnchant(Material material, int count, short damage, Enchantment[] enchantment, int[] level) {
		ItemStack items = new ItemStack(material, count, damage);
		
		for(int i=1; i< enchantment.length; i++) {
			items.addEnchantment(enchantment[i], level[i]);
		}
		
		return items;
	}
	
	public static ItemStack ItemEnchant(Material material, int count, Enchantment[] enchantment, int[] level) {
		ItemStack items = new ItemStack(material, count);
		
		for(int i=1; i< enchantment.length; i++) {
			items.addEnchantment(enchantment[i], level[i]);
		}
		
		return items;
	}
	
	public static ItemStack ItemLore(Material material, int count, short damage, String[] lore) {
		ItemStack items = new ItemStack(material, count, damage);
		ItemMeta itemMeta = items.getItemMeta();
		
		ArrayList<String> Lore = new ArrayList<String>();
		
		for(String string : lore) {
			Lore.add(string);
		}
		
		itemMeta.setLore(Lore);
		
		items.setItemMeta(itemMeta);
		
		return items;
	}
	
	public static ItemStack ItemLore(Material material, int count, String[] lore) {
		ItemStack items = new ItemStack(material, count);
		ItemMeta itemMeta = items.getItemMeta();
		
		ArrayList<String> Lore = new ArrayList<String>();
		
		for(String string : lore) {
			Lore.add(string);
		}
		
		itemMeta.setLore(Lore);
		
		items.setItemMeta(itemMeta);
		
		return items;
	}
	
}
