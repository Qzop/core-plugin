package me.fairuhc.CorePlugin;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class Ping implements Listener
{
	@SuppressWarnings("unused")
	public void ping(Player p, String[] args)
	{
		int playerping = ((CraftPlayer) p).getHandle().ping;
		
		if(args.length == 0)
		{
			if(playerping > 100)
			{
				p.sendMessage(ChatColor.YELLOW + "Your ping is: " + ChatColor.RED + playerping);
			}
			else
			{
				p.sendMessage(ChatColor.YELLOW + "Your ping is: " + ChatColor.GREEN + playerping);
			}
		}
		else if(args.length == 1)
		{
			Player target = Bukkit.getPlayer(args[0]);
			
			if(target == null)
			{
				p.sendMessage(ChatColor.RED + "That player is not online!"); 
			}
			else
			{
				int targetping = ((CraftPlayer) target).getHandle().ping;
				
				if(targetping > 100)
				{
					p.sendMessage(ChatColor.YELLOW + target.getDisplayName() + "'s ping is: " + ChatColor.RED + targetping);
				}
				else
				{
					p.sendMessage(ChatColor.YELLOW + target.getDisplayName() + "'s ping is: " + ChatColor.GREEN + targetping);
				}
			}
		}
		else
		{
			p.sendMessage(ChatColor.RED + "Usage: /ping (player)");
		}
		
	}
}
