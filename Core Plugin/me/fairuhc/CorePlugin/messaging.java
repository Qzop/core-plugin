package me.fairuhc.CorePlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class messaging implements Listener
{
	private static HashMap <UUID, UUID> message = new HashMap <UUID, UUID>();
	public String msg = "msg";
	public String msgoff = "msgoff";
	public String msgon = "msgon";
	public String reply = "r";
	private ArrayList <UUID> msgtoggle = new ArrayList<>();
	
	public void newMessage(CommandSender sender, Player player, String label, String[] args)
	{
		if(args.length == 0)
		{
			player.sendMessage(ChatColor.RED + "Usage: /msg (Name) (message)");
		}
		else if(args.length == 1)
		{
			player.sendMessage(ChatColor.RED + "Usage: /msg (Name) (message)");
		}
		else if (args.length > 1)
		{
			StringBuilder sb = new StringBuilder(); 
			for(int i = 1; i < args.length; i++)
			{
				sb.append(args[i] + " ");
			}
		
			Player target = (Player) Bukkit.getPlayer(args[0]);
			
			if(target != null)
			{
				if(msgtoggle.contains(target.getUniqueId()))
				{
					sender.sendMessage(ChatColor.RED + target.getName() + " has messages off!");
				}
				else if(sender.hasPermission("msg.color"))
				{
					sender.sendMessage(ChatColor.GRAY + "(To " + ChatColor.WHITE + target.getName() + ChatColor.GRAY + ") " + ChatColor.translateAlternateColorCodes('&', sb.toString().trim()));
					target.sendMessage(ChatColor.GRAY + "(From " + ChatColor.WHITE + sender.getName() + ChatColor.GRAY + ") " + ChatColor.translateAlternateColorCodes('&', sb.toString().trim()));
					
					message.put(player.getUniqueId(), target.getUniqueId());
                    message.put(target.getUniqueId(), player.getUniqueId());
				}
				else
				{
					sender.sendMessage(ChatColor.GRAY + "(To " + ChatColor.WHITE + target.getName() + ChatColor.GRAY + ") " + sb.toString().trim());
					target.sendMessage(ChatColor.GRAY + "(From " + ChatColor.WHITE + sender.getName() + ChatColor.GRAY + ") " + sb.toString().trim());
										
					message.put(player.getUniqueId(), target.getUniqueId());
					message.put(target.getUniqueId(), player.getUniqueId());
						
				}
			}
			else if(target == null)
			{
				sender.sendMessage(ChatColor.RED + "That player is not online!");
			}
		}
	}

	public boolean newReply(CommandSender sender, Player player, String label, String[] args)
	{
		if(args.length == 0)
		{
			sender.sendMessage(ChatColor.RED + "Usage: /r (message)");
			return true;
		}
		else
		{
			UUID targetUUID = message.get(player.getUniqueId());
            
            if (targetUUID != null) 
            {
                if (Bukkit.getPlayer(targetUUID) == null) 
                {
                    message.remove(player.getUniqueId());
                    return true;
                } 
                else 
                {
                    Player target = Bukkit.getPlayer(targetUUID);
                    
                    if(msgtoggle.contains(target.getUniqueId()))
    				{
    					sender.sendMessage(ChatColor.RED + target.getName() + " has messages off!");
    				}
                    else
                    {
                    	StringBuilder sb = new StringBuilder(); 
                    	for(int i = 0; i < args.length; i++)
                    	{
                    		sb.append(args[i] + " ");
                    	}
                    
                    	sender.sendMessage(ChatColor.GRAY + "(To " + ChatColor.WHITE + target.getName() + ChatColor.GRAY + ") " + sb.toString().trim());
                    	Bukkit.getPlayer(targetUUID).sendMessage(ChatColor.GRAY + "(From " + ChatColor.WHITE + sender.getName() + ChatColor.GRAY + ") " + sb.toString().trim());
                    	return true;
                    }
                }
            }
            else
            {
            	sender.sendMessage(ChatColor.RED + "Error. Maybe the player has logged off?");
            	return true;
            }
		}
		
		return false;
	}
		
	public void messageOff(CommandSender sender, Player player, String label, String[] args)
	{
		if(!player.hasPermission("msg.off"))
		{
			player.sendMessage(ChatColor.RED + "You do not have permission.");
		}
		else
		{
			if(msgtoggle.contains(((Player) sender).getUniqueId()))
			{
				sender.sendMessage(ChatColor.RED + "You already have messages off!");
			}
			else
			{
				msgtoggle.add(((Player) sender).getUniqueId());
			
				player.sendMessage(ChatColor.RED + "Private messages are now off.");
			}
		}
	}
	
	public void messageOn(CommandSender sender, Player player, String label, String[] args)
	{
		if(!player.hasPermission("msg.on"))
		{
			player.sendMessage(ChatColor.RED + "You do not have permission.");
		}
		else
		{
			if(msgtoggle.contains(((Player) sender).getUniqueId()))
			{
				for(int i = 0; i < msgtoggle.size(); i++)
				{
					if(msgtoggle.get(i).equals(player.getUniqueId()))
					{
						msgtoggle.remove(i);
						player.sendMessage(ChatColor.GREEN + "Private messages are now on.");
					}
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "You already have messages on!");
			}
		}
	}
}