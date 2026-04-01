package com.ttil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class StringUtils {

	public static String getMonth(String id) {
		if (id.equalsIgnoreCase("01")) {
			return "Jan";
		} else if (id.equalsIgnoreCase("02")) {
			return "Feb";
		} else if (id.equalsIgnoreCase("03")) {
			return "Mar";
		} else if (id.equalsIgnoreCase("04")) {
			return "Apr";
		} else if (id.equalsIgnoreCase("05")) {
			return "May";
		} else if (id.equalsIgnoreCase("06")) {
			return "Jun";
		} else if (id.equalsIgnoreCase("07")) {
			return "Jul";
		} else if (id.equalsIgnoreCase("08")) {
			return "Aug";
		} else if (id.equalsIgnoreCase("09")) {
			return "Sep";
		} else if (id.equalsIgnoreCase("10")) {
			return "Oct";
		} else if (id.equalsIgnoreCase("11")) {
			return "Nov";
		} else if (id.equalsIgnoreCase("12")) {
			return "Dec";
		}
		return "";
	}

	public static String getEducationName(String id) {
		if (id.equalsIgnoreCase("1")) {
			return "SSLC/Matric";
		} else if (id.equalsIgnoreCase("2")) {
			return "HSC/SSC";
		} else if (id.equalsIgnoreCase("3")) {
			return "ITI";
		} else if (id.equalsIgnoreCase("4")) {
			return "Course Completed Act Apprentice";
		} else if (id.equalsIgnoreCase("5")) {
			return "Diploma";
		} else if (id.equalsIgnoreCase("6")) {
			return "Non-Technical : Graduate";
		} else if (id.equalsIgnoreCase("7")) {
			return "Non-Technical : PostGraduate";
		} else if (id.equalsIgnoreCase("8")) {
			return "Technical : Graduate";
		} else if (id.equalsIgnoreCase("9")) {
			return "Technical : PostGraduate";
		}
		return "";
	}

	public static String getAffectedCategoryName(String id) {
		if (id.equalsIgnoreCase("1")) {
			return "Domiciled ordinarily in J&K during 1980 to 1989";
		} else if (id.equalsIgnoreCase("2")) {
			return "Affected in 1984 riots";
		} else if (id.equalsIgnoreCase("3")) {
			return "Affected in 2002 communal riots of Gujarat";
		}
		return "";
	}

	public static String getCategoryName(String id) {
		if (id.equalsIgnoreCase("VH")) {
			return "VH";
		} else if (id.equalsIgnoreCase("HH")) {
			return "HH";
		} else if (id.equalsIgnoreCase("OH")) {
			return "OH";
		}
		return "";
	}

	public static String getPostName(int post_id) {
		if (post_id == 7) {
			return "Constable (Driver)";
		} else if (post_id == 8) {
			return "Constable (Laboratory Assistant)";
		} else if (post_id == 9) {
			return "Constable (Veterinary)";
		} else if (post_id == 11) {
			return "Constable (Ayah)";
		} else if (post_id == 26) {
			return "Constable (Carpenter)";
		} else if (post_id == 27) {
			return "Constable (Plumber)";
		} else if (post_id == 10) {
			return "Constable (Painter)";
		} else if (post_id == 23) {
			return "Constable (Tailor)";
		} else if (post_id == 24) {
			return "Constable (Cobbler)";
		} else if (post_id == 25) {
			return "Constable (Gardner)";
		} else if (post_id == 12) {
			return "Constable (Cook)";
		} else if (post_id == 17) {
			return "Constable (Washer Man)";
		} else if (post_id == 19) {
			return "Constable (Barber)";
		} else if (post_id == 21) {
			return "Constable (Safaiwala)";
		} else if (post_id == 14) {
			return "Constable (Water Carrier)";
		} else if (post_id == 16) {
			return "Constable (Waiter)";
		}
		return "";
	}

	public static String getPostShortName(String postName) {
		if (postName != null) {
			if (postName.equalsIgnoreCase("Assistant Commandant (Veterinary)")) {
				return "AC (Vetty)";
			} else if (postName.equalsIgnoreCase("Assistant Sub-Inspector (Stenographer)")) {
				return "ASI (Steno)";
			} else if (postName.equalsIgnoreCase("Head Constable (Electrician)")) {
				return "HC(Electrician)";
			} else if (postName.equalsIgnoreCase("Head Constable (Mechanic) Male")) {
				return "HC (Mechanic)";
			} else if (postName.equalsIgnoreCase("Head Constable (Steward)")) {
				return "HC (Steward)";
			} else if (postName.equalsIgnoreCase("Head Constable (Veterinary)")) {
				return "HC (Veterinary)";
			} else if (postName.equalsIgnoreCase("Head Constable (Communication)")) {
				return "HC (Commn)";
			} else if (postName.equalsIgnoreCase("Sub Inspector (Pioneer)")) {
				return "SI (Pioneer)";
			} else if (postName.equalsIgnoreCase("Sub Inspector (Draughtsman)")) {
				return "SI (Draughtsman)";
			} else if (postName.equalsIgnoreCase("Sub Inspector (Communication)")) {
				return "SI (Communication)";
			} else if (postName.equalsIgnoreCase("Sub Inspector (Staff Nurse Female)")) {
				return "SI (Staff Nurse)";
			} else if (postName.equalsIgnoreCase("ASI(Pharmacist)")) {
				return "ASI(Pharmacist)";
			} else if (postName.equalsIgnoreCase("ASI(Radiographer)")) {
				return "ASI(Radiographer)";
			} else if (postName.equalsIgnoreCase("ASI(Operation Theater Technician)")) {
				return "ASI(OT Technician)";
			} else if (postName.equalsIgnoreCase("ASI(Dental Technician)")) {
				return "ASI(Dental Tech)";
			} else if (postName.equalsIgnoreCase("Constable (Carpenter)")) {
				return "CT (Carpenter)";
			} else if (postName.equalsIgnoreCase("Constable (Blacksmith)")) {
				return "CT (Blacksmith)";
			} else if (postName.equalsIgnoreCase("Constable (Driver) Male")) {
				return "CT (Driver)";
			} else if (postName.equalsIgnoreCase("Constable (Tailor)")) {
				return "CT (Tailor)";
			} else if (postName.equalsIgnoreCase("Constable (Gardner)")) {
				return "CT (Gardner)";
			} else if (postName.equalsIgnoreCase("Constable (Cobbler)")) {
				return "CT (Cobbler)";
			} else if (postName.equalsIgnoreCase("Constable (Veterinary)")) {
				return "CT (Veterinary)";
			} else if (postName.equalsIgnoreCase("Constable (Painter)")) {
				return "CT (Painter)";
			} else if (postName.equalsIgnoreCase("Constable (Washerman) Male")) {
				return "CT (Washerman)";
			} else if (postName.equalsIgnoreCase("Constable (Barber) Male")) {
				return "CT (Barber)";
			} else if (postName.equalsIgnoreCase("Constable (Safaiwala) Male")) {
				return "CT (Safaiwala)";
			} else if (postName.equalsIgnoreCase("Constable (Cook)")) {
				return "CT (Cook)";
			} else if (postName.equalsIgnoreCase("Constable (Water Carrier) Male")) {
				return "CT (Water Carrier)";
			} else if (postName.equalsIgnoreCase("Head Constable (Laboratory Assistant)")) {
				return "HC (Lab Asst)";
			} else if (postName.equalsIgnoreCase("Head Constable (Physiotherapy Assistant)")) {
				return "HC (Physio Asst)";
			} else if (postName.equalsIgnoreCase("Constable (Nursing Assistant cum Medic)")) {
				return "CT (Nursing Asst cum Medic)";
			} else
				return "Head Constable";

		}
		return "";
	}

	public static String getPostNameById(String postName) {
		if (postName != null) {
			if (postName.equalsIgnoreCase("1")) {
				return "Head Constable (Laboratory Assistant)";
			}
			// else if (postName.equalsIgnoreCase("2")) {
			// return "Sub Inspector (Draughtsman)";
			// }
			else if (postName.equalsIgnoreCase("3")) {
				return "Head Constable (Physiotherapy Assistant)";
			} else if (postName.equalsIgnoreCase("4")) {
				return "Constable (Nursing Assistant cum Medic)";
			}
			// else
			// return "Sub Inspector";

		}
		return "";
	}

	public static String getCurrentDate() {
		String currDate = "";
		try {
			Date date = new Date();
			SimpleDateFormat curFormater = new SimpleDateFormat("dd-MMM-yyyy");
			currDate = curFormater.format(date);
		} catch (Exception e) {
			// LogsGeneration.generateErrorLogsWithMobileNumber("StringUtils getCurrentDate
			// Error", e.getMessage(), null, null, null);
		}
		return currDate;
	}

	public static String getTomorrowDate() {
		String currDate = "";
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			SimpleDateFormat curFormater = new SimpleDateFormat("dd-MMM-yyyy");
			calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
			Date tomorrow = calendar.getTime();
			currDate = curFormater.format(tomorrow);
		} catch (Exception e) {
			// LogsGeneration.generateErrorLogsWithMobileNumber("StringUtils getCurrentDate
			// Error", e.getMessage(), null, null, null);
		}
		return currDate;
	}

	public static String changeDateFormatDMY(String date) {
		Date dateFormat = null;
		String formatedRundate = null;
		SimpleDateFormat dfOutput = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dfInput = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			try {
				// String birthDate=dfInput.format(date);
				dateFormat = dfInput.parse(date);
				formatedRundate = dfOutput.format(dateFormat);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return formatedRundate;
	}

	public static String changeDateFormatYMD(String date) {
		Date dateFormat = null;
		String formatedRundate = null;

		SimpleDateFormat dfOutput = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			try {
				String parsedFormat = parse(date);
				SimpleDateFormat dfInput = new SimpleDateFormat(parsedFormat);
				// String birthDate=dfInput.format(date);
				dateFormat = dfInput.parse(date);
				formatedRundate = dfOutput.format(dateFormat);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return formatedRundate;
	}

	private static final String[] formats = {
			"dd-MM-yyyy", "dd-MMM-yyyy" };

	private static final String[] formats1 = {
			"yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ",
			"yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
			"yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss",
			"MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'",
			"MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS",
			"MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss",
			"yyyy:MM:dd HH:mm:ss", "yyyyMMdd", };

	public static String parse(String d) {
		if (d != null) {
			for (String parse : formats) {
				SimpleDateFormat sdf = new SimpleDateFormat(parse);
				try {
					sdf.parse(d);
					return parse;
				} catch (ParseException e) {

				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String yyyyMMdd = "02-MAY-1997";
		String yyyyMMdd1 = "21-12-2013";
		// System.out.println(parse(yyyyMMdd));
		// System.out.println(parse(yyyyMMdd1));
		// System.out.println(StringUtils.changeDateFormatDMY("2013-12-01"));
		// System.out.println(StringUtils.changeDateFormatYMD("21-12-2013"));
		// System.out.println(StringUtils.changeDateFormatYMD("2-Oct-1997"));
		// System.out.println(StringUtils.changeDateFormatYMD("23-june-1997"));
		// System.out.println(StringUtils.changeDateFormatYMD("15-Sep-1997"));
		// System.out.println(StringUtils.changeDateFormatYMD("14-Jun-1992"));
		// System.out.println(StringUtils.changeDateFormatYMD("23-Mar-1997"));
	}

}
