package me.McVier3ck.log;



public class Log {

	
	public static void Error(String message) {
		
		System.out.println((char)27 + "[31m" + "[Error] " + message + (char)27 + "[0m");
	}
	
	public static void ColorText(String message, LogColors logcolor) {
		String color = "[" + GetColor.getColor(logcolor) + "m";
		System.out.println((char)27 + color + message + (char)27 + "[0m");
	}
	
	public static void ColorBackground(String message, LogColorsBackground backcolor) {
		String color = "[" + GetColor.getBackColor(backcolor) + "m";
		System.out.println((char)27 + color + message + (char)27 + "[0m");
		
	}
	
	public static void ColorTextWithBackround(String message, LogColorsBackground backcolor, LogColors logcolor) {
		String color = "[" + GetColor.getColor(logcolor) + ";" + GetColor.getBackColor(backcolor) + "m";
		System.out.println((char)27 + color + message + (char)27 + "[0m");
		
	}
	
	

	
}
