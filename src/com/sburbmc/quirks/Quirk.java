package com.sburbmc.quirks;

import java.util.ArrayList;

/*import org.bukkit.ChatColor;
import org.bukkit.entity.Player;*/

public class Quirk {
	
	String name;
	public ArrayList<String> players;
	
	public Quirk(String name) {
		players = new ArrayList<String>();
		this.name = name;
	}
	
	public void addPlayer(String uuid) {
		if (!containsPlayer(uuid)) {
			this.players.add(uuid);
		} else {
		//Player.sendMessage(ChatColor.RED + "???");
		}
		// else --> add error message
	}
	
	public void removePlayer(int uuid) {
		// not sure yet
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
	public boolean containsPlayer(String uuid) {
		
		for(String p : players) {
			if(p.equals(uuid))
				return true;
		} 
		
		return false;
		
	}
}