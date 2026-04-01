package com.ttil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {
	public static Age calculateAge(Date birthDate, Date notificationDate) {
		int years = 0;
		int months = 0;
		int days = 0;
		// create calendar object for birth day
		Calendar birthDay = Calendar.getInstance();
		birthDay.setTimeInMillis(birthDate.getTime());
		// create calendar object for current day
		// long currentTime = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(notificationDate.getTime());
		// Get difference between years
		years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
		int currMonth = now.get(Calendar.MONTH) + 1;
		int birthMonth = birthDay.get(Calendar.MONTH) + 1;
		// Get difference between months
		months = currMonth - birthMonth;
		// if month difference is in negative then reduce years by one and calculate the
		// number of months.
		if (months < 0) {
			years--;
			months = 12 - birthMonth + currMonth;
			if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
				months--;
			// System.out.println("in months <0 ");
		} else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			years--;
			months = 11;
			// System.out.println("in months else ");
		} else {
			// months=months-1;
			// System.out.println("in months -1 ");
		}
		// Calculate the days
		if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
			days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
		else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			int today = now.get(Calendar.DAY_OF_MONTH);
			now.add(Calendar.MONTH, -1);
			days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
		} else {
			days = 0;
			if (months == 12) {
				years++;
				months = 0;
			}
		}
		// Create new Age object
		return new Age(days, months, years);
		// return years;
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date birthDate = sdf.parse("30-12-1996"); // Yeh !! It's my date of birth <img
													// src="http://howtodoinjava.com/wp-includes/images/smilies/icon_smile.gif"
													// alt=":-)" class="wp-smiley">
		Date notificationDate = sdf.parse("01-01-2017");
		Age age = calculateAge(birthDate, notificationDate);
		// My age is
		// System.out.println(age.toString());
	}

}
