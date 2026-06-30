package com.Octopussaass.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	public int getRandomNumber()
	{
		Random random= new Random();
		  int randomNumber = random.nextInt(110000);
		 return randomNumber;
		 
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date dateobj= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;
		 
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{	Date dateobj= new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM/DD/YYYY");
		String date = sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
		
	}

			
}
