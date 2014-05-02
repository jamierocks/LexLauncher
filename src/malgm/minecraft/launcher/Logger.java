package malgm.minecraft.launcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	public static void log(Object ob) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		System.out.println("[" + dateFormat.format(date) + " INFO] " + ob);
	}

}
