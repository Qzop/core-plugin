package Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.fairuhc.CorePlugin.main;
import net.md_5.bungee.api.ChatColor;

public class chatcolorevent implements Listener
{
	EventClass color = new EventClass();
	
	private main plugin;
	
	public chatcolorevent(main plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void chatcolor(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		String msg = e.getMessage();

		if(color.red.contains(p))
		{
			e.setMessage(ChatColor.RED + msg);
		}	
		else if(color.darkred.contains(p))
		{
			e.setMessage(ChatColor.DARK_RED + msg);
		}
		else if(color.black.contains(p))
		{
			e.setMessage(ChatColor.BLACK+ msg);
		}
		else if(color.gold.contains(p))
		{
			e.setMessage(ChatColor.GOLD + msg);
		}
		else if(color.blue.contains(p))
		{
			e.setMessage(ChatColor.BLUE + msg);
		}
		else if(color.darkblue.contains(p))
		{
			e.setMessage(ChatColor.DARK_BLUE + msg);
		}
		else if(color.green.contains(p))
		{
			e.setMessage(ChatColor.GREEN + msg);
		}
		else if(color.darkgreen.contains(p))
		{
			e.setMessage(ChatColor.DARK_GREEN + msg);
		}
		else if(color.lightpurple.contains(p))
		{
			e.setMessage(ChatColor.LIGHT_PURPLE + msg);
		}
		else if(color.darkpurple.contains(p))
		{
			e.setMessage(ChatColor.DARK_PURPLE + msg);
		}
		else if(color.aqua.contains(p))
		{
			e.setMessage(ChatColor.AQUA + msg);
		}
		else if(color.darkaqua.contains(p))
		{
			e.setMessage(ChatColor.DARK_AQUA + msg);
		}
		else if(color.gray.contains(p))
		{
			e.setMessage(ChatColor.GRAY + msg);
		}
		else if(color.yellow.contains(p))
		{
			e.setMessage(ChatColor.YELLOW + msg);
		}
		else if(color.darkgray.contains(p))
		{
			e.setMessage(ChatColor.DARK_GRAY + msg);
		}
		else if(color.white.contains(p))
		{
			e.setMessage(ChatColor.WHITE + msg);
		}
	}
}