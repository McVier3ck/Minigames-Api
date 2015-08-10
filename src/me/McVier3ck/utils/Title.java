package me.McVier3ck.utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class Title {
	
	public static void newTitle(Player player, String Title, Integer In, Integer Stay, Integer Out) {
		PlayerConnection playerconnection = ((CraftPlayer)player).getHandle().playerConnection;
		
		PacketPlayOutTitle TitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, In, Stay.intValue(), Out.intValue());
		playerconnection.sendPacket(TitlePacket);
	    
	      IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Title + "\"}");
	      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
	      playerconnection.sendPacket(packetPlayOutTitle);
	    
		
	}
	
	public static void newTitle(Player player, String Title, String subTitle, Integer In, Integer Stay, Integer Out) {
		PlayerConnection playerconnection = ((CraftPlayer)player).getHandle().playerConnection;
		
		PacketPlayOutTitle TitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, In, Stay.intValue(), Out.intValue());
		playerconnection.sendPacket(TitlePacket);
	    
	      IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subTitle + "\"}");
	      PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
	      playerconnection.sendPacket(packetPlayOutSubTitle);
	    
	      IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Title + "\"}");
	      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
	      playerconnection.sendPacket(packetPlayOutTitle);
	    
		
	}
	
}
