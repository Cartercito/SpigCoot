package com.coot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.coot.rpg.Bounty;
import com.coot.rpg.CoinBank;
import com.coot.rpg.Shop;

public class SpigCoot extends JavaPlugin implements Listener {
	
	//Global plugin reference
	public static SpigCoot plugin;
	public Logger log = this.getLogger();
	public List<Module> modules = new ArrayList<Module>();
	public HashMap<String, Module> commands = new HashMap<String, Module>();
	
	public CoinBank bank = new CoinBank(this);
	public Bounty bounty = new Bounty(this);
	public Shop shop = new Shop(this);
	
	
	@Override
	public void onEnable() {
		
		plugin = this;
		this.getServer().getPluginManager().registerEvents(this, this);
		
		for (Module mod : modules) {
			this.getServer().getPluginManager().registerEvents(mod, this);
			mod.onEnable();
			mod.addCommands();
		}
	
	}
	
	@Override
	public void onDisable() {
		
		for (Module mod : modules) {
			mod.onDisable();
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player)sender;
		label = label.toLowerCase();
		
		//Send command to correct module
		Module mod = commands.get(label);
		if (mod != null) {
			mod.onCommand(player, label, args);
		}
		
		return true;
		
	}
	
}
