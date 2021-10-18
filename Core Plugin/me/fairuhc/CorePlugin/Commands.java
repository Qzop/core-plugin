package me.fairuhc.CorePlugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.CommandExecute;

public class Commands extends CommandExecute implements Listener, CommandExecutor 
{
	public String msg = "msg";
	public String msgoff = "msgoff";
	public String msgon = "msgon";
	public String reply = "r";
	public String tags = "tags";
	public String ranks = "rank";
	public String block = "block";
	public String unblock = "unblock";
	public String sc = "staffchat";
	public String fly = "fly";
	public String gm = "gm";
	public String color = "color";
	public String ping = "ping";
	public String list = "list";
	public String broadcast = "bc";
	
	private tags tag = new tags();
	private messaging message = new messaging();
	private admincommands admin = new admincommands();
	private color chat = new color();
	private Ping slashping = new Ping();
	private List slashlist = new List();
	
	public static ArrayList <Player> staff = new ArrayList<Player>();
	
	
	public main plugin;
	
	public Commands(main pl)
	{
		this.plugin = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		String prefix = ChatColor.DARK_AQUA + "[StaffChat]";
		
		if(label.equalsIgnoreCase(tags))
		{
			if(sender instanceof Player)
			{
				tag.newInventory(player);
			}
			
		}
		
		if(label.equalsIgnoreCase(msg))
		{
			if(sender instanceof Player)
			{
				message.newMessage(sender, player, label, args);
			}
		}
		
		if(label.equalsIgnoreCase(reply))
		{
			if(sender instanceof Player)
			{
				message.newReply(sender, player, label, args);
			}
		}
		
		if(label.equalsIgnoreCase(msgoff))
		{
			if(sender instanceof Player)
			{
				message.messageOff(sender, player, label, args);
			}
		}
		
		if(label.equalsIgnoreCase(msgon))
		{
			if(sender instanceof Player)
			{
				message.messageOn(sender, player, label, args);
			}
		}
		
		if(label.equalsIgnoreCase(sc))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You must be a player to use that command!");
				
				return true;
			}
			
			if(player.hasPermission("staffchat.use"))
			{
				if(args.length == 0)
				{
					if(staff.contains(player))
					{
						staff.remove(player);
						player.sendMessage(prefix + ChatColor.RED + " disabled.");
						
						return true;
					}
					else
					{
						staff.add(player);
						player.sendMessage(prefix + ChatColor.GREEN + " enabled.");
						
						return true;
					}
				}
				
				if(args.length > 0)
				{
					player.sendMessage(ChatColor.RED + "Usage: /sc");
					
					return true;
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "You do not have permission.");
			}
		}
		
		if(label.equalsIgnoreCase(fly))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			}
			else
			{
				admin.fly(sender, player, label, args);
			}
		}
		
		if(label.equalsIgnoreCase(gm))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			}
			else
			{
				admin.gamemode(sender, player, label, args);
			}
		}
		
		if(label.equalsIgnoreCase(color))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			}
			else
			{
				chat.newInventory(player);
			}
		}
		
		if(label.equalsIgnoreCase(ping))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			}
			else
			{
				slashping.ping(player, args);
			}
		}
		
		if(label.equalsIgnoreCase(list))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			}
			else
			{
				slashlist.list(player, args);
			}
		}
		
		if(label.equalsIgnoreCase(broadcast))
		{
			if(sender instanceof Player)
			{
				if(sender.hasPermission("server.broadcast"))
				{
					String pre = "&7&L[&4&lBroadcast&7&l]";
					
					if(args.length == 0)
					{
						sender.sendMessage(ChatColor.RED + "Usage: /bc (message)");
					}
					else
					{
						StringBuilder sb = new StringBuilder(); 
						for(int i = 0; i < args.length; i++)
						{
							sb.append("&6&l" + args[i] + " ");
						}
						
						for(Player p : Bukkit.getOnlinePlayers())
						{
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', pre + " " + sb));
						}
					}
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "You do not have permission.");
				}
			}
		}
		
		return false;
	}
}
