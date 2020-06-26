package com.coot;

import java.util.logging.Logger;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigCoot extends JavaPlugin {
	
	Logger log = this.getLogger();
	World skyblock;
	SkyblockGenerator skyGen = new SkyblockGenerator();
	
	@Override
	public void onEnable() {
		
		skyblock = skyGen.createWorld();
	
	}
	
	@Override
	public void onDisable() {
		
		
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player)sender;
		
		switch(label) {
		case "sky":
			player.teleport(skyblock.getSpawnLocation(), TeleportCause.COMMAND);
			break;
		}
		
		return true;
		
	}
	
}
