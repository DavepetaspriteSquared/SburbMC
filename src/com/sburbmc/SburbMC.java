package com.sburbmc;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.sburbmc.quirks.Quirk;

public class SburbMC extends JavaPlugin{

	ArrayList<Quirk> quirks;
	
	public void onEnable() {
		
		quirks = new ArrayList<Quirk>();
		
		quirks.add(new Quirk("Sollux"));
		quirks.add(new Quirk("Porrim"));
		quirks.add(new Quirk("Mituna"));
		quirks.add(new Quirk("Kurloz"));
		quirks.add(new Quirk("Vriska"));
		
		quirks.add(new Quirk("Jasprosesprite^2"));
		quirks.add(new Quirk("Davepetasprite^2"));
		quirks.add(new Quirk("Erisolsprite"));
		
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		
	}
	
	public void onDisable() {
		
		
		
	}
	
//	public String getChannel( ArrayList<Quirk> q, String uuid ) {
//		p.sendMessage("getPlayerQuirk");
//		for (Quirk a : q) { // Every quirk
//			if (a.containsPlayer(uuid)){
//				return a.getName();
//			}
//		}
//	
//		return " ";
//	}
	
	Player p;
	
//	public void mainChat(AsyncPlayerChatEvent e){	
//		p.setCancelled(true);
//		  p.setMessage("[" + p.getDisplayName() + "]" + e.getMessage());
//	}
	
	@EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK ||  event.getAction() == Action.RIGHT_CLICK_BLOCK) {
        //Teleport Player to Prospit/Derse
        	player.teleport(Bukkit.getWorld("Derspit").getSpawnLocation());
        }
}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("quirk") && sender instanceof Player) {

			Player p = (Player) sender;
			
			p.sendMessage("Arguments: " + args.length);
			p.sendMessage("Args[0]: " + args[0]);
			p.sendMessage("Args[1]: " + args[1]);
			
			if (args.length == 0){
				p.sendMessage(ChatColor.RED + "Please select a " + ChatColor.DARK_RED + "T" + ChatColor.GOLD + "h"
						+ ChatColor.GREEN + "i" + ChatColor.DARK_BLUE + "n" + ChatColor.BLUE + "g"
						+ ChatColor.LIGHT_PURPLE + "!");
			}
			
			if (args[0].equalsIgnoreCase("set") && !(args[1].length() > 0)){
				p.sendMessage(ChatColor.AQUA + "You must select a quirk first!");
				} else if (args[1].length() > 0) {
				for(Quirk q : quirks) {
					if(q.getName().equalsIgnoreCase(args[1])) {
						q.addPlayer(p.getUniqueId().toString());
						p.sendMessage("You have been added to: " + q.getName());
//						if(args[1].equalsIgnoreCase("Porrim")) {
//							p.setDisplayName(ChatColor.DARK_GREEN + "Porrim");
//						}if (args[1].equalsIgnoreCase("clear")) {
//							p.setDisplayName(p.getName() + "");
						}
					}
				}
		}
		return false;
			}
//		}
//		return false;
//	}

	public String getPlayerQuirk( ArrayList<Quirk> q, String uuid ) {
		p.sendMessage("getPlayerQuirk");
		for (Quirk a : q) { // Every quirk
			if (a.containsPlayer(uuid)){
				return a.getName();
			}
		}
	
		return " ";
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		
		System.out.println(p.getDisplayName());
		
		p.sendMessage("onChat");
		
		String pQuirk = getPlayerQuirk(quirks, p.getUniqueId().toString());
		
		p.sendMessage(pQuirk);
		
		p.sendMessage("p");
		p.sendMessage(pQuirk);
		
		if (pQuirk.equalsIgnoreCase("Porrim")){ //Porrim
			String message = e.getMessage().replaceAll("([oO0])", "$1+").replaceAll("[pP][lL][uU][sS]", "+");
			e.setMessage(ChatColor.GREEN + message);
		}
			
	
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Mituna
//			String message = e.getMessage().toUpperCase().replace("A", "4").replace("B", "8")
//					.replace("E", "3").replace("I", "1").replace("O", "0")
//					.replace("S", "5").replace("T", "7");
//			e.setMessage(p.getDisplayName() + ChatColor.YELLOW + message);
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Kurloz
//			e.setMessage(p.getDisplayName() + ChatColor.DARK_PURPLE + "...");
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Sollux
//			String message = e.getMessage().toLowerCase().replace("s", "2")
//					.replaceAll("i+", "ii").replaceAll("to+", "two");
//			e.setMessage(p.getDisplayName() + ChatColor.YELLOW + message);
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Vriska
//			String message = e.getMessage().replaceAll(":*([;:])+([dDbBpPL\\Q)(][\\E])", ":::$1$2")
//					.replaceAll("([\\.!?])+", "$1$1$1$1$1$1$1$1").replaceAll("[bB]", "8")
//					.replaceAll("[aA]([iI][tT]|[tT][eE])", "8")
//					.replaceAll("[aA][tT]([iI][nN][gG])\\b", "8$1");
//			e.setMessage(p.getDisplayName() + ChatColor.BLUE + message);
//			
//			
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Jasprosesprite^2
//			String message = e.getMessage();
//			e.setMessage(ChatColor.LIGHT_PURPLE + "Jasprosesprite^2: " + ChatColor.DARK_PURPLE + message);
//			
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Davepetasprite^2
//			String message = e.getMessage().toLowerCase().replaceAll("[e]{2},", "33")
//					.replace("ver", "fur").replace("pos", "paws").replaceAll("([^\\.])\\.{1,2}([^\\.])", "$1$2")
//					.replaceAll("\\.+", "...").replaceAll("[\\W&&[^\\s\\.!\\?]]", "");
//			e.setMessage(ChatColor.GREEN + "Davepetasprite^2: B33 < " + ChatColor.GOLD + message);
//			
//		} else if (players.contains(p) && players.contains(p.getUniqueId().toString())) { //Erisolsprite
//			String message = e.getMessage().toLowerCase().replace("s", "2")
//					.replaceAll("i+", "ii").replaceAll("to+", "two").replaceAll("([vwVW])", "$1$1").replaceAll("\\ban\\b", "a")
//					.replaceAll("\\band\\b", "an").replaceAll("\\b(.*in)g\\b", "$1");
//			e.setMessage(ChatColor.GREEN + "Erisolsprite: " + ChatColor.GREEN + message);
//		}
	}
}
