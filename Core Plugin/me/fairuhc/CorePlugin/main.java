package me.fairuhc.CorePlugin;

import org.bukkit.event.Listener;

import org.bukkit.plugin.java.JavaPlugin;


import Events.ChatEvent;
import Events.EventClass;
import Events.SlowChat;
import Events.chatcolorevent;
import net.md_5.bungee.api.ChatColor;


public class main extends JavaPlugin implements Listener
{
	public static main plugin;
	
	public void onEnable()
	{
		Commands command = new Commands(this);
		plugin = this;
		
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new EventClass(), this);
        this.getServer().getPluginManager().registerEvents(new SlowChat(this), (this));
        this.getServer().getPluginManager().registerEvents(new chatcolorevent(this), (this));
		getCommand(command.msg).setExecutor(command);
		getCommand(command.msgoff).setExecutor(command);
		getCommand(command.msgon).setExecutor(command);
		getCommand(command.reply).setExecutor(command);
		getCommand(command.tags).setExecutor(command);
		getCommand(command.block).setExecutor(command);
		getCommand(command.unblock).setExecutor(command);
		getCommand(command.sc).setExecutor(command);
		getCommand(command.fly).setExecutor(command);
		getCommand(command.gm).setExecutor(command);
		getCommand(command.color).setExecutor(command);
		getCommand(command.ping).setExecutor(command);
		getCommand(command.list).setExecutor(command);
		getCommand(command.broadcast).setExecutor(command);
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n\nCore Plugin Enabled\n\n");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n\nCore Plugin Disabled\n\n");
	}
}