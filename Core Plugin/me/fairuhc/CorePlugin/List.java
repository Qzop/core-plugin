package me.fairuhc.CorePlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class List implements Listener
{
	public void list(Player p, String[] args)
	{
		String players = "";
		String Owners = "";
		String Admins = "";
		String SrMods = "";
		String Mods = "";
		String Trials = "";
		int count = 0;
		
		if(args.length == 0)
		{
			for(Player list : Bukkit.getServer().getOnlinePlayers())
			{
				if(list.hasPermission("list.owner"))
				{
					Owners += ChatColor.DARK_RED + list.getDisplayName() + " ";
					count++;
				}
				else if(list.hasPermission("list.admin"))
				{
					Admins += ChatColor.RED + list.getDisplayName() + " ";
					count++;
				}
				else if(list.hasPermission("list.srmod"))
				{
					SrMods += ChatColor.LIGHT_PURPLE + list.getDisplayName() + " ";
					count++;
				}
				else if(list.hasPermission("list.mod"))
				{
					Mods += ChatColor.AQUA + list.getDisplayName() + " ";
					count++;
				}
				else if(list.hasPermission("list.trial"))
				{
					Trials += ChatColor.YELLOW + list.getDisplayName() + " ";
					count++;
				}
				else if(list.hasPermission("list.default"))
				{
					players += ChatColor.WHITE + list.getDisplayName() + " ";
					count++;
				}
			}
			
			p.sendMessage(ChatColor.GOLD + "Players online: " + ChatColor.GREEN + count + "\n\n"
					+ Owners + Admins + SrMods + Mods + Trials + players);
		}
		else if(args.length > 0)
		{
			p.sendMessage(ChatColor.RED + "Usage: /list");
		}
	}
}
