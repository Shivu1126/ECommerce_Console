package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static long changeToMillis(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		    Date date = sdf.parse(dateString);
		    long milliseconds = date.getTime();
		    return milliseconds;
		} catch (Exception e) {
			System.out.println("Invalid date string");
		    return 0;
		}
	}
	public static String changeFormat(long millisSecond) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(millisSecond);
	}
}
