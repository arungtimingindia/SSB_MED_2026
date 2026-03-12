package com.ttil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

	public static boolean dateComparison(String date1S, String date2S) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = sdf.parse(date1S);
			Date date2 = sdf.parse(date2S);

			if (date1.compareTo(date2) > 0) {
				return false;
			} else if (date1.compareTo(date2) <= 0) {
				return true;
			} else if (date1.compareTo(date2) == 0) {
				return false;
			} else {
				return false;
			}

		} catch (ParseException ex) {
			// LogsGeneration.generateErrorLogsWithMobileNumber("Validation dateComparison
			// Error", ex.getMessage(), null, null, null);
			return false;
		}
	}

	public static boolean dateComparison1(String date1S, String date2S) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = sdf.parse(date1S);
			Date date2 = sdf.parse(date2S);

			if (date1.compareTo(date2) >= 0) {
				return false;
			} else if (date1.compareTo(date2) < 0) {
				return true;
			} else if (date1.compareTo(date2) == 0) {
				return false;
			} else {
				return false;
			}

		} catch (ParseException ex) {
			// LogsGeneration.generateErrorLogsWithMobileNumber("Validation dateComparison
			// Error", ex.getMessage(), null, null, null);
			return false;
		}
	}

	public static boolean isThisDateValid(String dateToValidate) {

		if (dateToValidate == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		try {
			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	public static boolean sanitizeText(String input_text) {
		try {
			String text = input_text.toLowerCase();
			if (text.contains(">") || text.contains("&gt;")) {
				return true;
			} else if (text.contains("<") || text.contains("&lt;")) {
				return true;
			} else if (text.contains("create ")) {
				return true;
			} else if (text.contains("select ")) {
				return true;
			} else if (text.contains("drop ")) {
				return true;
			} else if (text.contains("delete ")) {
				return true;
			} else if (text.contains("insert ")) {
				return true;
			} else if (text.contains("update ")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean sanitizeCategoryText(String input_text) {
		try {
			if (input_text.equalsIgnoreCase("GEN") || input_text.equalsIgnoreCase("General")
					|| input_text.equalsIgnoreCase("EWS") || input_text.equalsIgnoreCase("OBC")
					|| input_text.equalsIgnoreCase("SC") || input_text.equalsIgnoreCase("ST")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean sanitizeMaritalText(String input_text) {
		try {
			if (input_text.equalsIgnoreCase("Unmarried") || input_text.equalsIgnoreCase("Married")
					|| input_text.equalsIgnoreCase("Divorce") || input_text.equalsIgnoreCase("Widowed")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean sanitizeIdenityTypeText(String input_text) {
		try {
			if (input_text.equalsIgnoreCase("Aadhaar Card") || input_text.equalsIgnoreCase("Voter Id")
					|| input_text.equalsIgnoreCase("PAN Card") || input_text.equalsIgnoreCase("Passport")
					|| input_text.equalsIgnoreCase("Driving License") || input_text.equalsIgnoreCase("Ration Card")
					|| input_text.equalsIgnoreCase("Birth Certificate")
					|| input_text.equalsIgnoreCase("University / College Id Card")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean sanitizeGenderText(String input_text) {
		try {
			if (input_text.equalsIgnoreCase("Female") || input_text.equalsIgnoreCase("Male")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean sanitizeNationalityText(String input_text) {
		try {
			if (input_text.equalsIgnoreCase("INDIAN") || input_text.equalsIgnoreCase("Others")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean sanitizeSubjectText(String input_text) {
		try {
			if (input_text.equalsIgnoreCase("Science")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean isValidEmailAddress(String email) {
		try {
			new javax.mail.internet.InternetAddress(email, true);
		} catch (javax.mail.internet.AddressException e) {
			return false;
		}
		return true;
	}

	public static boolean sanitizePostPrefText(String input_text) {
		try {
			if (input_text == null) {
				return false;
			}
			if (input_text.equalsIgnoreCase("District Police") || input_text.equalsIgnoreCase("BMP")
					|| input_text.equalsIgnoreCase("SIRB") || input_text.equalsIgnoreCase("BISF")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static void main(String[] args) {
		// System.out.println(Validation.dateComparison("01-01-1997","01-01-1997"));
		// System.out.println(Validation.dateComparison("01-01-1975","02-01-1975"));
		/*
		 * //System.out.println("connect 1");
		 * Validator instance = ESAPI.validator();
		 * //System.out.println("connect 2");
		 * //System.out.println(instance.isValidInput("test", "xxxxssax@ddssd.com",
		 * "Email", 100, false));
		 */
		/*
		 * //System.out.println("raju284@gmail.com="+Validation.isValidEmailAddress(
		 * "raju284@gmail.com"));
		 * //System.out.println("raju284@gmail.com="+Validation.isValidEmailAddress(
		 * "raju284aas@gmail.com"));
		 * //System.out.println("raju.k@thoughtgreen.com="+Validation.
		 * isValidEmailAddress("raju.k@thoughtgreen.com"));
		 * //System.out.println("raju@thoughtgreen.com="+Validation.isValidEmailAddress(
		 * "raju@thoughtgreen.com"));
		 * //System.out.println("raju.k@timingindia.com="+Validation.isValidEmailAddress
		 * ("raju.k@timingindia.com"));
		 * //System.out.println("raju@timingindia.com="+Validation.isValidEmailAddress(
		 * "raju@timingindia.com"));
		 */ }

}
