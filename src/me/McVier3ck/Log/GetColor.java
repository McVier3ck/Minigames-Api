package me.McVier3ck.log;

public class GetColor {
	
	public static int getColor(LogColors color) {
		int colorInt = 0;
		switch (color) {
		case Black: colorInt = 30;
			break;
		case Red: colorInt = 31;
			break;
		case Green: colorInt = 32;
			break;
		case Yellow: colorInt = 33;
			break;
		case Blue: colorInt = 34;
			break;
		case Magenta: colorInt = 35;
			break;
		case Cyan: colorInt = 38;
			break;
		case White: colorInt = 37;
			break;
		case Grey: colorInt = 38;
			break;
		case Clear: colorInt = 0;
			break;

		}
		return colorInt;
	}
	
	public static int getBackColor(LogColorsBackground color) {
		int colorInt = 0;
		switch (color) {
		case Black_background: colorInt = 40;
			break;
		case Red_background: colorInt = 41;
			break;
		case Green_background: colorInt = 42;
			break;
		case Yellow_background: colorInt = 43;
			break;
		case Blue_background: colorInt = 44;
			break;
		case Magenta_background: colorInt = 45;
			break;
		case Cyan_background: colorInt = 46;
			break;
		case White_background: colorInt = 47;
			break;
		case Grey_background: colorInt = 4;
			break;

		}
		return colorInt;
	}

}
