package me.fairuhc.CorePlugin;

import org.bukkit.Material;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class tags implements Listener 
{
	public Plugin plugin = main.getPlugin(main.class);

	public void newInventory(Player player)
	{
		if(player.hasPermission("tags.winner"))
		{
			Inventory i = plugin.getServer().createInventory(null, 9, ChatColor.AQUA + "Tags");
		
			ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte) 15);
			ItemMeta emptyMeta = empty.getItemMeta();
			emptyMeta.setDisplayName("");
			empty.setItemMeta(emptyMeta);
		
			ItemStack sword = new ItemStack(Material.NAME_TAG, 1, (byte) 1);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.AQUA + "Winner tag: " + ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]");
			sword.setItemMeta(swordMeta);
		
			i.setItem(0, empty);
			i.setItem(1, empty);
			i.setItem(2, empty);
			i.setItem(3, empty);
			i.setItem(4, sword);
			i.setItem(5, empty);
			i.setItem(6, empty);
			i.setItem(7, empty);
			i.setItem(8, empty);
	
			player.openInventory(i);
		}
		else
		{
			player.sendMessage(ChatColor.RED + "You do not have permission.");
		}
	}
}