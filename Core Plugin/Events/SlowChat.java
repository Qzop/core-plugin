package Events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.fairuhc.CorePlugin.main;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("deprecation")
public class SlowChat implements Listener
{
	@SuppressWarnings("unused")
	private main plugin;
	
	public SlowChat(main plugin)
	{
		this.plugin = plugin;
	}
	
	private final Map<String, Long> cooldownTime = new HashMap();
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerChat(PlayerChatEvent e)
	{
		Player p = e.getPlayer();
		
		if(p.hasPermission("slowchat.bypass"))
		{
			return;
		}
		else
		{
			long now = System.currentTimeMillis();
			String name = p.getName();
			Long lastChat = (Long) cooldownTime.get(name);
			
			if(lastChat != null)
			{
				long earliestnextChat = lastChat.longValue() + (3 * 1000);
				
				if(now < earliestnextChat)
				{
					int timeRemaining = (int)((earliestnextChat - now) / 1000L) + 1;
					
					p.sendMessage(ChatColor.RED + "Wait " + timeRemaining + " more second" + (timeRemaining > 1 ? "s" : "") + " before chatting again!");
					e.setCancelled(true);
					return;
				}
			}
			cooldownTime.put(name,  Long.valueOf(now));
		}
	}
	
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		cooldownTime.remove(p.getName());
	}
}
