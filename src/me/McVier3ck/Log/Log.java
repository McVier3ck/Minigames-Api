package me.McVier3ck.Log;



public class Log {

	
	public static void Error(String message) {
		
		System.out.println((char)27 + "[31m" + "[Error] " + message + (char)27 + "[0m");
	}
	
	public static void ColorText(String message, LogColor logcolor) {
		String color = "[" + GetColor.getColor(logcolor) + "m";
		System.out.println((char)27 + color + message + (char)27 + "[0m");
	}
	
	public static void BackgroundColorText(String message, LogColorBackground backcolor) {
		String color = "[" + GetColor.getBackColor(backcolor) + "m";
		System.out.println((char)27 + color + message + (char)27 + "[0m");
		
	}
	
	public static void BackgroundColorTextAndColorText(String message, LogColorBackground backcolor, LogColor logcolor) {
		String color = "[" + GetColor.getColor(logcolor) + ";" + GetColor.getBackColor(backcolor) + "m";
		System.out.println((char)27 + color + message + (char)27 + "[0m");
		
	}
	
	

	
}
