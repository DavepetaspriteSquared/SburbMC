package com.sburbmc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	Player p;
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
	  String message = e.getMessage(); //get the message

	  e.setCancelled(true); //cancel the event, so no message is sent (yet)

	  for(Player on : Bukkit.getOnlinePlayers()){ //loop thru all online players
	    if(message.contains(on.getName())){ //check if the message contains the player's name
	      String newMessage = message.replaceAll(on.getName(), ChatColor.BLUE + "" + ChatColor.UNDERLINE + on.getName() + ChatColor.WHITE); //format the message
	      //change ChatColor.BLUE + ChatColor.UNDERLINE to the formatting you want
	      on.sendMessage(newMessage); //send the player the message
	      on.playNote(on.getLocation(), Instrument.PIANO, Note.natural(1, Tone.A)); //send the player the music
	    }else{
	      on.sendMessage(message); //else send the player the regular message
	    }
	  }
	}
	
	
}
