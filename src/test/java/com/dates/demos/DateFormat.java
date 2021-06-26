package com.dates.demos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat 
{
	public static void main(String args[]) throws ParseException
	{
		/*
		 * System.out.println("Date Format"); Calendar c=Calendar.getInstance(); Date
		 * today=c.getTime(); System.out.println("Todays Date is : " + today);
		 * 
		 * SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
		 * today=formatter.parse(today.toString());
		 * System.out.println("Todays Date is : " + today);
		 */
		
		/*
		 * Date date = new Date(); String modifiedDate= new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms").format(date);
		 * System.out.println(modifiedDate);
		 * 
		 * Calendar cal = Calendar.getInstance(); cal.add(Calendar.MONTH, -1);
		 * cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		 * 
		 * System.out.println(cal.get(Calendar.MONTH));
		 * System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		 */
	    
	    Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, max);

        System.out.println("++++++++++++++++++++++++++");
        System.out.println(calendar.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00.00");  
        String strDate = dateFormat.format(calendar.getTime()); 
        System.out.println(strDate);
        
	}
}
