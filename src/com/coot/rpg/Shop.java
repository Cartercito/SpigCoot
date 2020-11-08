package com.coot.rpg;

import org.bukkit.entity.Player;

import com.coot.Module;
import com.coot.SpigCoot;

public class Shop extends Module {
	
	CoinBank bank;
	int price = 4;

	public Shop(SpigCoot plugin) {
		super(plugin);
	}

	@Override
	public void onEnable() {
		commands.add("buy");
		price = 4;
		bank = SpigCoot.plugin.bank;
	}

	@Override
	public void onDisable() {
		
	}

	@Override
	public void onCommand(Player sender, String cmd, String[] args) {
		
		sender.sendMessage("Attempting to buy");
		if (bank.get(sender) >= price) {
			sender.sendMessage("Buying");
			bank.add(sender, -price);
			sender.giveExpLevels(1);
			
		}
		else {
			sender.sendMessage("Cant buy");
		}
		
	}

}
