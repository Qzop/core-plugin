package Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class EventClass implements Listener
{
	public static ArrayList<UUID> players = new ArrayList<>();
	public String prefix = (ChatColor.AQUA + "Tags");
	public String winner = ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]";
	public static ArrayList<Player> red = new ArrayList<>();
	public static ArrayList<Player> blue = new ArrayList<>();
	public static ArrayList<Player> darkred = new ArrayList<>();
	public static ArrayList<Player> yellow = new ArrayList<>();
	public static ArrayList<Player> darkblue = new ArrayList<>();
	public static ArrayList<Player> gold = new ArrayList<>();
	public static ArrayList<Player> green = new ArrayList<>();
	public static ArrayList<Player> darkgreen = new ArrayList<>();
	public static ArrayList<Player> aqua = new ArrayList<>();
	public static ArrayList<Player> darkaqua = new ArrayList<>();
	public static ArrayList<Player> lightpurple = new ArrayList<>();
	public static ArrayList<Player> darkpurple = new ArrayList<>();
	public static ArrayList<Player> gray = new ArrayList<>();
	public static ArrayList<Player> darkgray = new ArrayList<>();
	public static ArrayList<Player> black = new ArrayList<>();
	public static ArrayList<Player> white = new ArrayList<>();
	
	public String owner = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Owner"+ ChatColor.GRAY + "]" + ChatColor.DARK_RED;
	public String admin = ChatColor.GRAY + "[" + ChatColor.RED + "Admin"+ ChatColor.GRAY + "]" + ChatColor.RED;
	public String srmod = ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "Sr.Mod"+ ChatColor.GRAY + "]" + ChatColor.LIGHT_PURPLE;
	public String mod = ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Mod"+ ChatColor.GRAY + "]" + ChatColor.AQUA;
	public String trial = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Trial"+ ChatColor.GRAY + "]" + ChatColor.YELLOW;
	
	@SuppressWarnings("null")
	@EventHandler
	public void inventoryClick (InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if(open == null)
		{
			return;
		}		
		else if(open.getName().equals(ChatColor.AQUA + "Tags")) // line 30 
		{
			event.setCancelled(true);
			
			if(item == null || !item.hasItemMeta())
			{
				return;
			}
			
			if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Winner tag: " + ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]") && !players.contains(player.getUniqueId()))
			{
				player.closeInventory();
				
				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]" + ChatColor.GREEN + " prefix set.");
				players.add(player.getUniqueId());
				
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Winner tag: " + ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]") && players.contains(player.getUniqueId()))
			{
				player.closeInventory();
				
				players.remove(player.getUniqueId());
				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Winner" + ChatColor.GRAY + "]" + ChatColor.RED + " prefix unset");
			}
		}	
		else if( open.getName().equals(ChatColor.YELLOW + "Chat Colors"))
		{	
			if(item == null || !item.hasItemMeta())
			{
				return;
			}
			
			if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Red"))
			{
				blue.remove(player);
				darkred.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				aqua.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				black.remove(player);
				white.remove(player);
				
				if(red.contains(player))
				{
					player.closeInventory();
					red.remove(player);
					player.sendMessage(ChatColor.RED + "Red " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					red.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.RED + "Red " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Dark Red"))
			{
				blue.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				aqua.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				black.remove(player);
				white.remove(player);
				
				if(darkred.contains(player))
				{
					player.closeInventory();
					darkred.remove(player);
					player.sendMessage(ChatColor.DARK_RED + "Dark Red " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					darkred.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.DARK_RED + "Dark Red " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Blue"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				aqua.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				black.remove(player);
				white.remove(player);
				
				if(blue.contains(player))
				{
					player.closeInventory();
					blue.remove(player);
					player.sendMessage(ChatColor.BLUE + "Blue " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					blue.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.BLUE + "Blue " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Aqua"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				black.remove(player);
				white.remove(player);
				
				if(aqua.contains(player))
				{
					player.closeInventory();
					aqua.remove(player);
					player.sendMessage(ChatColor.AQUA + "Aqua " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					aqua.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.AQUA + "Aqua " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Black"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
				
				if(black.contains(player))
				{
					player.closeInventory();
					black.remove(player);
					player.sendMessage(ChatColor.BLACK + "Black " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					black.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.BLACK + "Black " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Dark Blue"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				black.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
				
				if(darkblue.contains(player))
				{
					player.closeInventory();
					darkblue.remove(player);
					player.sendMessage(ChatColor.DARK_BLUE + "Dark Blue " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					darkblue.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.DARK_BLUE + "Dark Blue " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Dark Aqua"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				black.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
				
				if(darkaqua.contains(player))
				{
					player.closeInventory();
					darkaqua.remove(player);
					player.sendMessage(ChatColor.DARK_AQUA + "Dark Aqua " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					darkaqua.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.DARK_AQUA + "Dark Aqua " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Light Purple"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				black.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
				
				if(lightpurple.contains(player))
				{
					player.closeInventory();
					lightpurple.remove(player);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Light Purple " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					lightpurple.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.LIGHT_PURPLE + "Light Purple " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Dark Purple"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				black.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
				
				if(darkpurple.contains(player))
				{
					player.closeInventory();
					darkpurple.remove(player);
					player.sendMessage(ChatColor.DARK_PURPLE + "Dark Purple " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					darkpurple.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.DARK_PURPLE + "Dark Purple " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Dark Green"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				green.remove(player);
				black.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
			
				if(darkgreen.contains(player))
				{
					player.closeInventory();
					darkgreen.remove(player);
					player.sendMessage(ChatColor.DARK_GREEN + "Dark Green " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					darkgreen.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.DARK_GREEN + "Dark Green " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Light Green"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				gold.remove(player);
				black.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
			
				if(green.contains(player))
				{
					player.closeInventory();
					green.remove(player);
					player.sendMessage(ChatColor.GREEN + "Green " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					green.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.GREEN + "Green " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Gold"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				black.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
			
				if(gold.contains(player))
				{
					player.closeInventory();
					gold.remove(player);
					player.sendMessage(ChatColor.GOLD + "Gold " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					gold.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.GOLD + "Gold " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Yellow"))
			{
				darkred.remove(player);
				red.remove(player);
				gold.remove(player);
				darkblue.remove(player);
				black.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
			
				if(yellow.contains(player))
				{
					player.closeInventory();
					yellow.remove(player);
					player.sendMessage(ChatColor.YELLOW + "Yellow " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					yellow.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.YELLOW + "Yellow " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Light Gray"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				black.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gold.remove(player);
				darkgray.remove(player);
				aqua.remove(player);
				white.remove(player);
			
				if(gray.contains(player))
				{
					player.closeInventory();
					gray.remove(player);
					player.sendMessage(ChatColor.GRAY + "Gray " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					gray.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.GRAY + "Gray " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Dark Gray"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				black.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				gold.remove(player);
				aqua.remove(player);
				white.remove(player);
			
				if(darkgray.contains(player))
				{
					player.closeInventory();
					darkgray.remove(player);
					player.sendMessage(ChatColor.DARK_GRAY + "Dark Gray " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					darkgray.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.DARK_GRAY + "Dark Gray " + ChatColor.GREEN + "chat color.");
				}
			}
			else if(item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "White"))
			{
				darkred.remove(player);
				red.remove(player);
				yellow.remove(player);
				darkblue.remove(player);
				black.remove(player);
				green.remove(player);
				darkgreen.remove(player);
				blue.remove(player);
				darkaqua.remove(player);
				lightpurple.remove(player);
				darkpurple.remove(player);
				gray.remove(player);
				gold.remove(player);
				aqua.remove(player);
			
				if(white.contains(player))
				{
					player.closeInventory();
					white.remove(player);
					player.sendMessage(ChatColor.WHITE + "White " + ChatColor.YELLOW + "chat color is now turned off." );
				}
				else
				{
					player.closeInventory();
					white.add(player);
					player.sendMessage(ChatColor.GREEN + "You now have a " + ChatColor.WHITE + "White " + ChatColor.GREEN + "chat color.");
				}
			}
		}
	}
}