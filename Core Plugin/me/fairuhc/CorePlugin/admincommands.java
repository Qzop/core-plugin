package me.fairuhc.CorePlugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class admincommands implements Listener
{
	public void fly(CommandSender sender, Player player, String label, String[] args)
	{
		Player p = (Player) sender;
		
		if(p.hasPermission("admin.fly"))
		{
			if(args.length == 0)
			{
				if(p.isFlying())
				{
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(ChatColor.RED + "You are no longer flying.");
				}
				else
				{
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(ChatColor.GREEN + "You are now flying.");
				}
			}
			else if(args.length == 1)
			{
				Player target = (Player) Bukkit.getPlayer(args[0]);
				
				if(target == null)
				{
					p.sendMessage(ChatColor.RED + "That player is not online!");
				}
				else
				{
					if(target.isFlying())
					{
						target.setAllowFlight(false);
						target.setFlying(false);
						target.sendMessage(ChatColor.RED + "You are no longer flying.");
					}
					else
					{
						target.setAllowFlight(true);
						target.setFlying(true);
						target.sendMessage(ChatColor.GREEN + "You are now flying.");
					}
				}
			}
			else if(args.length > 1)
			{
				p.sendMessage(ChatColor.RED + "Usage: /fly (name)");
			}
		}
		else
		{
			p.sendMessage(ChatColor.RED + "You do not have permission.");
		}
	}
	
	public void gamemode(CommandSender sender, Player player, String label, String[] args)
	{
		Player p = (Player) sender;
		ArrayList<String> gamemode = new ArrayList<>();
		gamemode.add("0");
		gamemode.add("1");
		
		if(p.hasPermission("admin.gamemode"))
		{
			if(args.length == 0 || args.length > 2 || !gamemode.contains(args[0]))
			{
				p.sendMessage(ChatColor.RED + "Usage: /gm (number) (name)");
			}
			else if(args.length == 1)
			{
				if(p.getGameMode().equals(GameMode.CREATIVE) && args[0].equals("1"))
				{
					p.sendMessage(ChatColor.RED + "You are already in creative mode.");
				}
				else if(!p.getGameMode().equals(GameMode.CREATIVE) && args[0].equals("1"))
				{
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(ChatColor.GREEN + "You are now in creative mode.");
				}
				else if(p.getGameMode().equals(GameMode.SURVIVAL) && args[0].equals("0"))
				{
					p.sendMessage(ChatColor.RED + "You are already in survival mode.");
				}
				else if(!p.getGameMode().equals(GameMode.SURVIVAL) && args[0].equals("0"))
				{
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(ChatColor.GREEN + "You are now in survival mode.");
				}
			}
			else if(args.length == 2)
			{
				Player target = (Player) Bukkit.getPlayer(args[1]);
				
				if(target == null)
				{
					p.sendMessage(ChatColor.RED + "That player is not online!");
				}
				else
				{
					if(target.getGameMode().equals(GameMode.CREATIVE) && args[0].equals("1"))
					{
						p.sendMessage(ChatColor.RED + "That player is already in creative mode!");
					}
					else if(!target.getGameMode().equals(GameMode.CREATIVE) && args[0].equals("1"))
					{
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(ChatColor.GREEN + "You are now in creative mode.");
						p.sendMessage(ChatColor.GREEN + target.getDisplayName() + " is now in creative mode." );
					}
					else if(target.getGameMode().equals(GameMode.SURVIVAL) && args[0].equals("0"))
					{
						p.sendMessage(ChatColor.RED + "That player is already in survival mode!");
					}
					else if(!p.getGameMode().equals(GameMode.SURVIVAL) && args[0].equals("0"))
					{
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage(ChatColor.GREEN + "You are now in survival mode.");
						p.sendMessage(ChatColor.GREEN + target.getDisplayName() +  " is now in survival mode.");
					}
				}
			}
		}
		else
		{
			p.sendMessage(ChatColor.RED + "You do not have permission.");
		}
	}
}