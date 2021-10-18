package me.fairuhc.CorePlugin;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class color implements Listener 
{
	public Plugin plugin = main.getPlugin(main.class);

	public void newInventory(Player player)
	{
		if(player.hasPermission("chat.color"))
		{
			Inventory i = plugin.getServer().createInventory(null, 18, ChatColor.YELLOW + "Chat Colors");
			
			Wool redwool = new Wool(DyeColor.RED);
			Wool bluewool = new Wool(DyeColor.BLUE);
			Wool aquawool = new Wool(DyeColor.LIGHT_BLUE);
			Wool blackwool = new Wool(DyeColor.BLACK);
			Wool yellowwool = new Wool(DyeColor.YELLOW);
			Wool graywool = new Wool(DyeColor.GRAY);
			Wool darkaquawool = new Wool(DyeColor.CYAN);
			Wool lightpurplewool = new Wool(DyeColor.MAGENTA);
			Wool darkpurplewool = new Wool(DyeColor.PURPLE);
			Wool darkgreenwool = new Wool(DyeColor.GREEN);
			Wool lightgreenwool = new Wool(DyeColor.LIME);
			Wool goldwool = new Wool(DyeColor.ORANGE);
			Wool whitewool = new Wool(DyeColor.WHITE);
			
			ItemStack red = redwool.toItemStack();
			ItemMeta colorred = red.getItemMeta();
			colorred.setDisplayName(ChatColor.WHITE + "Red");
			red.setItemMeta(colorred);
			
			ItemStack darkred = new ItemStack(Material.REDSTONE_BLOCK, 1, (byte) 1);
			ItemMeta darkr = darkred.getItemMeta();
			darkr.setDisplayName(ChatColor.WHITE + "Dark Red");
			darkred.setItemMeta(darkr);
			
			ItemStack blue = bluewool.toItemStack();
			ItemMeta colorb = blue.getItemMeta();
			colorb.setDisplayName(ChatColor.WHITE + "Blue");
			blue.setItemMeta(colorb);
			
			ItemStack aqua = aquawool.toItemStack();
			ItemMeta colora = blue.getItemMeta();
			colora.setDisplayName(ChatColor.WHITE + "Aqua");
			aqua.setItemMeta(colora);
			
			ItemStack black = blackwool.toItemStack();
			ItemMeta colorbl = black.getItemMeta();
			colorbl.setDisplayName(ChatColor.WHITE + "Black");
			black.setItemMeta(colorbl);
			
			ItemStack darkblue = new ItemStack(Material.LAPIS_BLOCK, 1, (byte) 1);
			ItemMeta darkb = darkblue.getItemMeta();
			darkb.setDisplayName(ChatColor.WHITE + "Dark Blue");
			darkblue.setItemMeta(darkb);
			
			ItemStack yellow = yellowwool.toItemStack();
			ItemMeta coloryellow = yellow.getItemMeta();
			coloryellow.setDisplayName(ChatColor.WHITE + "Yellow");
			yellow.setItemMeta(coloryellow);
			
			ItemStack gray = graywool.toItemStack();
			ItemMeta colorgray = gray.getItemMeta();
			colorgray.setDisplayName(ChatColor.WHITE + "Dark Gray");
			gray.setItemMeta(colorgray);
			
			ItemStack darkaqua = darkaquawool.toItemStack();
			ItemMeta colordaqua = darkaqua.getItemMeta();
			colordaqua.setDisplayName(ChatColor.WHITE + "Dark Aqua");
			darkaqua.setItemMeta(colordaqua);
			
			ItemStack lightpurple = lightpurplewool.toItemStack();
			ItemMeta colorlpurple = lightpurple.getItemMeta();
			colorlpurple.setDisplayName(ChatColor.WHITE + "Light Purple");
			lightpurple.setItemMeta(colorlpurple);
			
			ItemStack darkpurple = darkpurplewool.toItemStack();
			ItemMeta colordpurple = darkpurple.getItemMeta();
			colordpurple.setDisplayName(ChatColor.WHITE + "Dark Purple");
			darkpurple.setItemMeta(colordpurple);
			
			ItemStack darkgreen = darkgreenwool.toItemStack();
			ItemMeta colordgreen = darkgreen.getItemMeta();
			colordgreen.setDisplayName(ChatColor.WHITE + "Dark Green");
			darkgreen.setItemMeta(colordgreen);
			
			ItemStack lightgreen = lightgreenwool.toItemStack();
			ItemMeta colorlgreen = lightgreen.getItemMeta();
			colorlgreen.setDisplayName(ChatColor.WHITE + "Light Green");
			lightgreen.setItemMeta(colorlgreen);
			
			ItemStack gold = goldwool.toItemStack();
			ItemMeta colorgold = gold.getItemMeta();
			colorgold.setDisplayName(ChatColor.WHITE + "Gold");
			gold.setItemMeta(colorgold);
			
			ItemStack lgray = new ItemStack(Material.STONE, 1, (byte) 1);
			ItemMeta colorlgray = lgray.getItemMeta();
			colorlgray.setDisplayName(ChatColor.WHITE + "Light Gray");
			lgray.setItemMeta(colorlgray);
			
			ItemStack white = whitewool.toItemStack();
			ItemMeta colorw = white.getItemMeta();
			colorw.setDisplayName(ChatColor.WHITE + "White");
			white.setItemMeta(colorw);
			
			i.setItem(0, red);
			i.setItem(1, darkred);
			i.setItem(2, blue);
			i.setItem(3, aqua);
			i.setItem(4, black);
			i.setItem(5, darkblue);
			i.setItem(6, yellow);
			i.setItem(7, gray);
			i.setItem(8, darkaqua);
			i.setItem(10, lightpurple);
			i.setItem(11, darkpurple);
			i.setItem(12, darkgreen);
			i.setItem(13, lightgreen);
			i.setItem(14, gold);
			i.setItem(15, lgray);
			i.setItem(16, white);
			
			
		
			player.openInventory(i);
		}
		else
		{
			player.sendMessage(ChatColor.RED + "You do not have permission.");
		}
	}
}