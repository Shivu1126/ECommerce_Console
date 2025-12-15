package util;

import java.text.SimpleDateFormat;

public class Utils {

	public static void changeToMillis(String date) {
		
	}
	public static String changeFormat(long millisSecond) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(millisSecond);
	}
}
