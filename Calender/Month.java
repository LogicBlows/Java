package cron.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Month {

	public static void main(String[] args) {
		
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, 10);
			    cal.set(Calendar.DAY_OF_MONTH, 1);
			    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			    SimpleDateFormat df = new SimpleDateFormat("EEEE, yyyy-MM-dd");
			    System.out.print(df.format(cal.getTime()));
			    for (int i = 1; i < maxDay; i++) {
			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
			        
			        if (df.format(cal.getTime()).contains("Saturday") || df.format(cal.getTime()).contains("Sunday")) {
						
					} else {

			        System.out.print(",\n" + df.format(cal.getTime()));
					}
			    }

	}

}
