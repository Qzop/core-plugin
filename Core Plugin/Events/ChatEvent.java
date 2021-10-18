package Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.fairuhc.CorePlugin.Commands;
import me.fairuhc.CorePlugin.main;
import net.md_5.bungee.api.ChatColor;

public class ChatEvent implements Listener
{
	public HashMap<UUID, Long> cooldown = new HashMap<>();
	public EventClass event = new EventClass();
	
	public String owner = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Owner"+ ChatColor.GRAY + "]" + ChatColor.DARK_RED;
	public String admin = ChatColor.GRAY + "[" + ChatColor.RED + "Admin"+ ChatColor.GRAY + "]" + ChatColor.RED;
	public String srmod = ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "Sr.Mod"+ ChatColor.GRAY + "]" + ChatColor.LIGHT_PURPLE;
	public String mod = ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Mod"+ ChatColor.GRAY + "]" + ChatColor.AQUA;
	public String trial = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Trial"+ ChatColor.GRAY + "]" + ChatColor.YELLOW;
	public String winner = ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]";
	
	public main plugin;
	
	public ChatEvent(main pl)
	{
		this.plugin = pl;
	}
	
	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		 
		if(EventClass.players.contains(p.getUniqueId()))
		{
			if(p.hasPermission("chat.owner"))
			{
				e.setFormat(winner + " " + owner + " %s" + ChatColor.WHITE + ": " + ChatColor.GOLD + "%s");
			}
			else if(p.hasPermission("chat.admin"))
			{
				e.setFormat(winner + " " + admin + " %s" + ChatColor.WHITE + ": " + ChatColor.WHITE + "%s");
			}
			else if(p.hasPermission("chat.srmod"))
			{
				e.setFormat(winner + " " + srmod + " %s" + ChatColor.WHITE + ": " + ChatColor.WHITE + "%s");
			}
			else if(p.hasPermission("chat.mod"))
			{
				e.setFormat(winner + " " + mod + " %s" + ChatColor.WHITE + ": " + ChatColor.WHITE + "%s");
			}
			else if(p.hasPermission("chat.trial"))
			{
				e.setFormat(winner + " " + trial + " %s" + ChatColor.WHITE + ": " + ChatColor.WHITE + "%s");
			}
			else if(p.hasPermission("chat.default"))
			{
				e.setFormat(winner + " " + ChatColor.WHITE + "%s: %s");
			}
		}		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e)
	{
		String prefix = ChatColor.DARK_AQUA + "[StaffChat]";
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if(Commands.staff.contains(p))
		{
			e.setCancelled(true);
			
			for(Player s : Bukkit.getServer().getOnlinePlayers())
			{
				if(s.hasPermission("staffchat.see"))
				{
					if(p.hasPermission("staffchat.owner"))
					{
						s.sendMessage(prefix + " " + ChatColor.DARK_RED + p.getName() + ChatColor.WHITE + ": " + ChatColor.AQUA + msg);
					}
					else if(p.hasPermission("staffchat.admin"))
					{
						s.sendMessage(prefix + " " + ChatColor.RED + p.getName() + ChatColor.WHITE + ": " + ChatColor.AQUA + msg);
					}
					else if(p.hasPermission("staffchat.srmod"))
					{
						s.sendMessage(prefix + " " + ChatColor.DARK_PURPLE + p.getName() + ChatColor.WHITE + ": " + ChatColor.AQUA + msg);
					}
					else if(p.hasPermission("staffchat.mod"))
					{
						s.sendMessage(prefix + " " + ChatColor.AQUA + p.getName() + ChatColor.WHITE + ": " + ChatColor.AQUA + msg);
					}
					else if(p.hasPermission("staffchat.trial"))
					{
						s.sendMessage(prefix + " " + ChatColor.YELLOW + p.getName() + ChatColor.WHITE + ": " + ChatColor.AQUA + msg);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void chatFilter(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("nigger");
		filter.add("Nigger");
		filter.add("nigga");
		filter.add("Nigga");
		filter.add("fag");
		filter.add("Fag");
		filter.add("Beaner");
		filter.add("beaner");
		
		for(int i = 0; i < filter.size(); i++)
		{
			if(msg.contains(filter.get(i)))
			{
				e.setCancelled(true);
				p.sendMessage(ChatColor.RED + "Please refrain from using racial/homophobic slurs.");
			}
		}
	}
	
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) 
	{
		Player p = e.getPlayer();
		if(p.hasPermission("blockedcmds.bypass"))
		{
			return;
		}
		else
		{
			if (e.getMessage().startsWith("/?") || e.getMessage().startsWith("/pl") || e.getMessage().startsWith("/plugins") || e.getMessage().startsWith("/version")) 
			{
	            e.getPlayer().sendMessage(ChatColor.RED + "You do not have permission.");
	            e.setCancelled(true);
			}
			
			if(e.getMessage().startsWith("/me"))
			{
				e.getPlayer().sendMessage(ChatColor.RED + "You do not have permission.");
	            e.setCancelled(true);
			}
		}
	}
}