package com.ttil.servlet;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.util.Age;
import com.ttil.util.AgeCalculator;
import com.ttil.util.Validation;

import nl.captcha.util.Age1;

public class ServerSideSanitizationValidation___ {
	public void checkValidation(ApplicationFormBean applicationFormBean, List<String> messageOb) {
		try {
			String charactersOnlyRule = "^[a-zA-Z\\s]*$";
			String emailRule = "^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$";
			String CharsNumbers = "^[a-zA-Z0-9 \\-]*$";
			String CharsNumbersAndSpecialChars = "^[a-zA-Z0-9 \\-.,()&@_/:;'#]*$";
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date notificationDate = sdf.parse("18-06-2023");

			boolean firstname_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getFirst_name().trim(), charactersOnlyRule, 30, false);
			if (!firstname_status) {
				messageOb.add("Please Provide Valid input in Full Name (First Name).");
			} else if ((ESAPI.encoder().canonicalize(applicationFormBean.getFirst_name())).length() < 1) {
				messageOb.add("Applicant Full Name (First Name) should contain at least 1 characters.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getFirst_name()))
					messageOb.add("Please Provide Valid input in Full Name (First Name).");
			}

			boolean middlename_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getMiddle_name().trim(), charactersOnlyRule, 30, true);
			if (!middlename_status) {
				messageOb.add("Please Provide Valid input in Full Name (Middle Name).");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getMiddle_name()))
					messageOb.add("Please Provide Valid input in Full Name (Middle Name).");
			}

			boolean lastname_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getLast_name().trim(), charactersOnlyRule, 30, true);
			if (!lastname_status) {
				messageOb.add("Please Provide Valid input in Full Name (Last Name).");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getLast_name()))
					messageOb.add("Please Provide Valid input in Full Name (Last Name).");
			}

			boolean fathername_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getFather_name(), charactersOnlyRule, 50, false);
			if (!fathername_status) {
				messageOb.add("Please Provide Valid input in Father Name.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getFather_name()))
					messageOb.add("Please Provide Valid input in Father Name.");
			}

			boolean mothername_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getMother_name(), charactersOnlyRule, 50, false);
			if (!mothername_status) {
				messageOb.add("Please Provide Valid input in Mother Name.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getFather_name()))
					messageOb.add("Please Provide Valid input in Mother Name.");
			}

			boolean nationality_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getNationality(), charactersOnlyRule, 40, false);
			if (!nationality_status) {
				messageOb.add("Please Provide Valid input in Nationality.");
			} else {
				if (!Validation.sanitizeNationalityText(applicationFormBean.getNationality()))
					messageOb.add("Please Provide Valid input in Nationality.");
			}

			boolean sex_status = ESAPI.validator().isValidInput("ServerSideTest", applicationFormBean.getSex(),
					charactersOnlyRule, 7, false);
			if (!sex_status) {
				messageOb.add("Please Provide Valid input in Gender.");
			} else {
				if (!Validation.sanitizeGenderText(applicationFormBean.getSex()))
					messageOb.add("Please Provide Valid input in Gender.");
			}

			boolean marrital_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getMarrital_status(), charactersOnlyRule, 15, false);
			if (!marrital_status) {
				messageOb.add("Please Provide Valid input in Marital Status.");
			} else {
				if (!Validation.sanitizeMaritalText(applicationFormBean.getMarrital_status()))
					messageOb.add("Please Provide Valid input in Marital Status.");
			}

			boolean cat_status = ESAPI.validator().isValidInput("ServerSideTest", applicationFormBean.getCommunity(),
					charactersOnlyRule, 10, false);
			if (!cat_status) {
				messageOb.add("Please Provide Valid input in Category.");
			} else {
				if (!Validation.sanitizeCategoryText(applicationFormBean.getCommunity()))
					messageOb.add("Please Provide Valid input in Category.");
			}

			Long min = 0000000000L;
			Long max = 9999999999L;
			boolean mobileNumberStatus = ESAPI.validator().isValidNumber("ServerSideTest",
					applicationFormBean.getMobileNumber().trim(), min, max, false);
			if (!mobileNumberStatus) {
				messageOb.add("Please Provide Valid input in Mobile Number.");
			}
			boolean email_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getEmailaddress().trim(), emailRule, 45, false);
			if (!email_status) {
				messageOb.add("Please Provide Valid input in Email address.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getEmailaddress()))
					messageOb.add("Please Provide Valid input in Email address.");
			}

			boolean identity_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getIdentity_type(), CharsNumbersAndSpecialChars, 30, false);
			if (!identity_status) {
				messageOb.add("Please Provide Valid input in Identity Card Type.");
			} else {
				if (!Validation
						.sanitizeIdenityTypeText(ESAPI.encoder().canonicalize(applicationFormBean.getIdentity_type())))
					messageOb.add("Please Provide Valid input in Identity Card Type.");
			}

			boolean identityNo_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getAadharNo(), CharsNumbersAndSpecialChars, 20, false);
			if (!identityNo_status) {
				messageOb.add("Please Provide Valid input in Identity Card No.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getIdentification_mark()))
					messageOb.add("Please Provide Valid input in Identity Card No.");
			}

			boolean identification_mark1_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getIdentification_mark(), charactersOnlyRule, 80, false);
			if (!identification_mark1_status) {
				messageOb.add("Please Provide Valid input in Identification Marks.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getIdentification_mark()))
					messageOb.add("Please Provide Valid input in Identification Marks.");
			}

			boolean village_status = ESAPI.validator().isValidInput("ServerSideTest", applicationFormBean.getVillage(),
					CharsNumbersAndSpecialChars, 40, false);
			if (!village_status) {
				messageOb.add("Please Provide Valid input in Village/ Town.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getVillage()))
					messageOb.add("Please Provide Valid input in Village/ Town.");
			}

			boolean postoffice_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getPostoffice(), CharsNumbersAndSpecialChars, 40, false);
			if (!postoffice_status) {
				messageOb.add("Please Provide Valid input in Post Office.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getPostoffice()))
					messageOb.add("Please Provide Valid input in Post Office.");
			}

			boolean district_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getDistrict(), CharsNumbersAndSpecialChars, 40, false);
			if (!district_status) {
				messageOb.add("Please Provide Valid input in District.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getDistrict()))
					messageOb.add("Please Provide Valid input in District.");
			}

			boolean state_status = ESAPI.validator().isValidInput("ServerSideTest", applicationFormBean.getState(),
					charactersOnlyRule, 35, false);
			if (!state_status) {
				messageOb.add("Please Provide Valid input in State.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getState()))
					messageOb.add("Please Provide Valid input in State.");
			}

			Long postcode_min = 000000L;
			Long postcode_max = 999999L;
			boolean postcode_status = ESAPI.validator().isValidNumber("ServerSideTest",
					applicationFormBean.getPincode(), postcode_min, postcode_max, false);
			if (!postcode_status) {
				messageOb.add("Please Provide Valid input in Pincode.");
			}

			boolean village_status1 = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getVillage1(), CharsNumbersAndSpecialChars, 40, false);
			if (!village_status1) {
				messageOb.add("Please Provide Valid input in Village/ Town.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getVillage1()))
					messageOb.add("Please Provide Valid input in Village/ Town.");
			}

			boolean postoffice_status1 = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getPostoffice1(), CharsNumbersAndSpecialChars, 40, false);
			if (!postoffice_status1) {
				messageOb.add("Please Provide Valid input in Post Office.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getPostoffice1()))
					messageOb.add("Please Provide Valid input in Post Office.");
			}

			boolean district_status1 = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getDistrict1(), CharsNumbersAndSpecialChars, 40, false);
			if (!district_status1) {
				messageOb.add("Please Provide Valid input in District.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getDistrict1()))
					messageOb.add("Please Provide Valid input in District.");
			}

			boolean state_status1 = ESAPI.validator().isValidInput("ServerSideTest", applicationFormBean.getState1(),
					charactersOnlyRule, 35, false);
			if (!state_status1) {
				messageOb.add("Please Provide Valid input in State.");
			} else {
				if (Validation.sanitizeText(applicationFormBean.getState1()))
					messageOb.add("Please Provide Valid input in State.");
			}

			boolean postcode_status1 = ESAPI.validator().isValidNumber("ServerSideTest",
					applicationFormBean.getPincode1(), postcode_min, postcode_max, false);
			if (!postcode_status1) {
				messageOb.add("Please Provide Valid input in Pincode.");
			}

			boolean pwd_status = ESAPI.validator().isValidInput("ServerSideTest",
					applicationFormBean.getPassword(), CharsNumbersAndSpecialChars, 6, false);
			if (!pwd_status) {
				messageOb.add("Please Provide Valid input in Password (6 Characters only).");
			}  
			/*
			 * if(!(("true".equalsIgnoreCase(applicationFormBean.getJk_domiciledS())) ||
			 * ("false".equalsIgnoreCase(applicationFormBean.getJk_domiciledS())))) {
			 * messageOb.add("Please Select Are You a Domicile of Bihar State."); }
			 */

			/*
			 * if(!(("true".equalsIgnoreCase(applicationFormBean.getHomeguardS())) ||
			 * ("false".equalsIgnoreCase(applicationFormBean.getHomeguardS())))) {
			 * messageOb.add("Please Select Are you an Employee of Bihar Government."); }
			 * boolean govt_date_status=false;
			 * if("true".equalsIgnoreCase(applicationFormBean.getHomeguardS()) ){
			 * govt_date_status=Validation.isThisDateValid(applicationFormBean.
			 * getYear_hg_training()); if(!govt_date_status) { messageOb.
			 * add("Please Provide Valid input in Date of Joining of Employee of Bihar Government."
			 * ); } }
			 */

			boolean dob_status = Validation.isThisDateValid(applicationFormBean.getDob());
			if (!dob_status) {
				messageOb.add("Please Provide Valid Date Of Birth.");
			}

			if (dob_status) {
				String post = applicationFormBean.getPost_applied();
				int post_applied = Integer.parseInt(applicationFormBean.getPost_applied());
				boolean agevalidated = false, govtFlag = false, govtService = false, govtServ = false,
						riots_flag = false, exman = false;
				int hg_years = 0;
				String community = applicationFormBean.getCommunity();
				Date birthDate = sdf.parse(applicationFormBean.getDob());
				String dob = applicationFormBean.getDob();
				String[] dobArray = dob.split("-");
				int bmo1 = Integer.parseInt(dobArray[1]);
				int bday1 = Integer.parseInt(dobArray[0]);
				int byr = Integer.parseInt(dobArray[2]);
				int yearSSC = byr + 12;
				String date_ssc = bday1 + "-" + bmo1 + "-" + yearSSC;
				int min_age = 0, max_age = 0;
				boolean edu1 = false;
				String date_ug = "";
				String ep1 = applicationFormBean.getExam_passed_1();
				String stream1 = applicationFormBean.getStream_1();
				String uni1 = applicationFormBean.getUniversity_1();
				String es1 = applicationFormBean.getEdu_rollno_1();
				String ey1 = applicationFormBean.getEdu_certno_1();
				String em1 = applicationFormBean.getEdu_date_issue_1();
				String edm1 = applicationFormBean.getEdu_marks_1();
				String eyear1 = applicationFormBean.getEdu_year_1();
				if (!ep1.equalsIgnoreCase("") && !ey1.equalsIgnoreCase("") && !es1.equalsIgnoreCase("")
						&& !em1.equalsIgnoreCase("") && !uni1.equalsIgnoreCase("") && !stream1.equalsIgnoreCase("")
						&& !edm1.equalsIgnoreCase("") && !eyear1.equalsIgnoreCase("")) {

					edu1 = true;
					if (!dateDiff(dob, em1)) {
						messageOb.add(
								"Date Of Issued should be Greater than Date of birth for Matriculation Certificate");
					}
					String[] arr = em1.split("-", 3);
					if (Integer.parseInt(eyear1) > Integer.parseInt(arr[2])) {
						messageOb.add(
								"Date Of Issued should be Greater than or equal to year of exam for Matriculation Certificate");
					}
					if (!dateDiff(em1, "19-06-2023")) {
						messageOb.add(
								"Matriculation Certificate Issued Date / Passing Year & Date should be less than or equal to 18-06-2023");
					}
					if (Integer.parseInt(eyear1) < yearSSC) {
						messageOb.add("Matriculation Year of Exam should be atleast 12 years after Date of birth");
					}
					if (!dateDiff(date_ssc, em1)) {
						messageOb.add(
								"Matriculation Certificate Issued Date / Passing Year & Date should be atleast 12 years after Date of birth");
					}
					if (Integer.parseInt(edm1) > 100 || Integer.parseInt(edm1) <=0) {
						messageOb.add(
								"Please select valid aggregate percentage of marks for Matriculation Certificate");
					}

					String[] em1Arr = em1.split("-");
					int em1yr = Integer.parseInt(em1Arr[2]);
					int em1mo = Integer.parseInt(em1Arr[1]);
					int em1day = Integer.parseInt(em1Arr[0]);
					int years_ug = em1yr + 1;
					date_ug = em1day + "-" + em1mo + "-" + years_ug;
				}
				if (edu1 == false) {
					messageOb.add("Please enter Matriculation Education details  ");
				}

				String ep2 = applicationFormBean.getExam_passed_plus2();
				String stream2 = applicationFormBean.getStream_plus2();
				String uni2 = applicationFormBean.getUniversity_plus2();
				String es2 = applicationFormBean.getEdu_rollno_plus2();
				String ey2 = applicationFormBean.getEdu_certno_plus2();
				String em2 = applicationFormBean.getEdu_date_issue_plus2();
				String edm2 = applicationFormBean.getEdu_marks_plus2();
				String eyear2 = applicationFormBean.getEdu_year_plus2();
				boolean edu3 = false;
				if (!ep2.equalsIgnoreCase("") && !ey2.equalsIgnoreCase("") && !es2.equalsIgnoreCase("")
						&& !em2.equalsIgnoreCase("") && !uni2.equalsIgnoreCase("") && !stream2.equalsIgnoreCase("")
						&& !edm2.equalsIgnoreCase("") && !eyear2.equalsIgnoreCase("")) {
					edu3 = true;

					if (!dateDiff(dob, em2)) {
						messageOb.add("Date Of Issuedd should be Greater than Date of birth for 10+2 Certificate");
					}
					String[] arr = em2.split("-", 3);
					if (Integer.parseInt(eyear2) > Integer.parseInt(arr[2])) {
						messageOb.add(
								"Date Of Issued should be Greater than or equal to year of exam for 10+2 Certificate");
					}
					if (!dateDiff(em2, "19-06-2023")) {
						messageOb.add(
								"10+2 Certificate Issued Date / Passing Year & Date should be less than or equal to 18-06-2023");
					}
					if (edu1 == true) {
						if (!dateDiff(date_ug, em2)) {
							messageOb.add(
									"10+2 Certificate Issued Date should be atleast 2 year after Matriculation Passing Date");

						}

					}
					if (Integer.parseInt(edm2) > 100 || Integer.parseInt(edm2) <= 0) {
						messageOb.add(
								"Please select valid aggregate percentage of marks for 10+2 Certificate");
					}
				}

				if (edu3 == false && post_applied != 2) {
					messageOb.add("Please enter 10+2 details  ");
				}

				String ep3 = applicationFormBean.getExam_passed_3();
				String stream3 = applicationFormBean.getStream_3();
				String uni3 = applicationFormBean.getUniversity_3();
				String es3 = applicationFormBean.getEdu_rollno_3();
				String ey3 = applicationFormBean.getEdu_certno_3();
				String em3 = applicationFormBean.getEdu_date_issue_3();
				String edm3 = applicationFormBean.getEdu_marks_3();
				String eyear3 = applicationFormBean.getEdu_year_3();

				boolean edug3 = false;

				if (!ep3.equalsIgnoreCase("") && !ey3.equalsIgnoreCase("") && !es3.equalsIgnoreCase("")
						&& !em3.equalsIgnoreCase("") && !uni3.equalsIgnoreCase("") && !stream3.equalsIgnoreCase("")
						&& !edm3.equalsIgnoreCase("") && !eyear3.equalsIgnoreCase("")) {

					if (!dateDiff(dob, em3)) {
						messageOb
								.add("Date Of Issuedd should be Greater than Date of birth for Graduation Certificate");
					}

					String[] arr = em3.split("-", 3);
					if (Integer.parseInt(eyear3) > Integer.parseInt(arr[2])) {
						messageOb.add(
								"Date Of Issued should be Greater than or equal to year of exam for Graduation Certificate");
					}

					if (!dateDiff(em3, "19-06-2023")) {
						messageOb.add(
								"Graduation Certificate Issued Date / Passing Year & Date should be less than or equal to 18-06-2023");
					}

					if (Integer.parseInt(edm3) > 100 || Integer.parseInt(edm3) <=0) {
						messageOb.add(
								"Please select valid aggregate percentage of marks for Graduation Certificate");
					}
				} else {
					if (post_applied == 3) {
						messageOb.add("Graduation details should not be empty for selected post");
					}
					if (post_applied == 1) {
						edug3 = true;
					}
				}

				String ep4 = applicationFormBean.getExam_passed_4();
				String stream4 = applicationFormBean.getStream_4();
				String uni4 = applicationFormBean.getUniversity_4();
				String es4 = applicationFormBean.getEdu_rollno_4();
				String ey4 = applicationFormBean.getEdu_certno_4();
				String em4 = applicationFormBean.getEdu_date_issue_4();
				String edm4 = applicationFormBean.getEdu_marks_4();
				String eyear4 = applicationFormBean.getEdu_year_4();
				// String edu4=false;

				if (!ep4.equalsIgnoreCase("") && !ey4.equalsIgnoreCase("") && !es4.equalsIgnoreCase("")
						&& !em4.equalsIgnoreCase("") && !uni4.equalsIgnoreCase("") && !stream4.equalsIgnoreCase("")
						&& !edm4.equalsIgnoreCase("") && !eyear4.equalsIgnoreCase("")) {

					if (!dateDiff(dob, em4)) {
						messageOb.add(
								"Date Of Issuedd should be Greater than Date of birth for Post Graduation Certificate");
					}

					String[] arr = em4.split("-", 3);
					if (Integer.parseInt(eyear4) > Integer.parseInt(arr[2])) {
						messageOb.add(
								"Date Of Issued should be Greater than or equal to year of exam for Post Graduation Certificate");
					}

					if (!dateDiff(em4, "19-06-2023")) {
						messageOb.add(
								"Post Graduation Certificate Issued Date / Passing Year & Date should be less than or equal to 18-06-2023");
					}

					if (Integer.parseInt(edm4) > 100 || Integer.parseInt(edm4) <= 0) {
						messageOb.add(
								"Please select valid aggregate percentage of marks for Post Graduation Certificate");
					}
				}

				String epd4 = applicationFormBean.getExam_passed_5();
				String streamd4 = applicationFormBean.getStream_5();
				String unid4 = applicationFormBean.getUniversity_5();
				String esd4 = applicationFormBean.getEdu_rollno_5();
				String eyd4 = applicationFormBean.getEdu_certno_5();
				String emd4 = applicationFormBean.getEdu_date_issue_5();
				String edmd4 = applicationFormBean.getEdu_marks_5();
				String eyeard4 = applicationFormBean.getEdu_year_5();
				if (!epd4.equalsIgnoreCase("") && !eyd4.equalsIgnoreCase("") && !esd4.equalsIgnoreCase("")
						&& !emd4.equalsIgnoreCase("") && !unid4.equalsIgnoreCase("") && !streamd4.equalsIgnoreCase("")
						&& !edmd4.equalsIgnoreCase("") && !eyeard4.equalsIgnoreCase("")) {
					if (!dateDiff(dob, emd4)) {
						messageOb.add("Date Of Issuedd should be Greater than Date of birth for Diploma Certificate");
					}

					String[] arr = emd4.split("-", 3);
					if (Integer.parseInt(eyeard4) > Integer.parseInt(arr[2])) {
						messageOb.add(
								"Date Of Issued should be Greater than or equal to year of exam for Diploma Certificate");
					}

					if (!dateDiff(emd4, "19-06-2023")) {
						messageOb.add(
								"Diploma Certificate Issued Date / Passing Year & Date should be less than or equal to 18-06-2023");
					}

					if (Integer.parseInt(edmd4) > 100 || Integer.parseInt(edmd4) <= 0) {
						messageOb.add(
								"Please select valid aggregate percentage of marks for Diploma Certificate");
					}
				} else {
					if (post_applied == 4) {
						messageOb.add("Diploma details should not be empty for selected post");
					}
					if (post_applied == 1 && edug3 == true) {
						messageOb.add("Either Degree or Diploma details are mandatory for selected post");
					}
				}

				if (post_applied == 4) { // only female
					if (applicationFormBean.getSex().equalsIgnoreCase("F")
							|| applicationFormBean.getSex().equalsIgnoreCase("Female")) {

					} else {
						messageOb.add("You must be female for this post, male gender not allowed");
					}
				}

				if ((post_applied == 1 || post_applied == 4)
						&& applicationFormBean.getNationality().equalsIgnoreCase("Others")) {
					messageOb.add("Nationality should be Indian for the selected Post");
				}

				if (post_applied == 4) {

					String inter = applicationFormBean.getStream_plus2();  
					String diploma = applicationFormBean.getStream_5();
		    		
					if (applicationFormBean.isNursing_council() == false
							|| applicationFormBean.getNurse().equalsIgnoreCase("")) {
						messageOb.add("Must be registered with Central or State Nursing Council for selected post.");
					}
					if (applicationFormBean.isHospital_experience() == false
							|| applicationFormBean.getHospital().equalsIgnoreCase("")) {
						messageOb.add(
								"You should have Two years Experience in a recognised Hospital to apply for selected post.");
					}
					
					if(inter.equalsIgnoreCase("Science") && diploma.equalsIgnoreCase("general_nursing")){}
					else if(!(inter.equalsIgnoreCase("Science"))){
						messageOb.add("You should have Science as your subject in 10+2");
					}
					else if(!(diploma.equalsIgnoreCase("general_nursing"))){
						messageOb.add("You should have General nursing as your subject in Diploma");
					}

				}

				if (post_applied == 2) {

					if (applicationFormBean.isTradesmen_certificate() == false
							|| applicationFormBean.getTrade().equalsIgnoreCase("")) {
						messageOb.add("Should have Two years National Tradesmen certificate for selected post.");
					}
					if (applicationFormBean.isAutocad_certificate() == false
							|| applicationFormBean.getAutocad().equalsIgnoreCase("")) {
						messageOb.add(
								"Should have one year certificate course or one year experience in AUTOCAD for selected post.");
					}
					/*
					 * if(applicationFormBean.isDraughtsmanship_exp()==false ||
					 * applicationFormBean.getDraft().equalsIgnoreCase("")){ messageOb.
					 * add("Should have one year experience in Draughtsmanship from a recognised Architect Consultancy Firm of Category ‘B’ and ‘C."
					 * ); }
					 */

				}
				
				  if(post_applied==1){
				    	String degree = applicationFormBean.getStream_3();
				    	String diploma = applicationFormBean.getStream_5();
				    	if(degree.equalsIgnoreCase("civil_Engineering") || diploma.equalsIgnoreCase("civil_Engineering")){}
				    	else{
				    		messageOb.add("You should have Civil Engineering as your subject either in Graduation or in Diploma");
				    	}
				    }
				    
				    if(post_applied==3){
				    	String degree = applicationFormBean.getStream_3(); 
				    	
				    	if(degree.equalsIgnoreCase("Electronics_and_Communication") || degree.equalsIgnoreCase("Computer_Science") ||  degree.equalsIgnoreCase("Information_Technology_Engineering") 
				    			|| degree.equalsIgnoreCase("Science(Physics,Chemistry and Mathematics)")){}
				    	else{
				    		messageOb.add("You should have Electronics and Communication or Computer Science or Information Technology Engineering or Science with Physics, Chemistry and Mathematics as your subject in Graduation. ");
				    	}
				    }

				min_age = 18;
				max_age = 30;
				if (post_applied == 0 || post.equalsIgnoreCase("") || post == null) {
					messageOb.add("Please select the post");
				} else {

					if (post_applied == 1) {
						min_age = 18;
						max_age = 30;
					} else if (post_applied == 2) {
						max_age = 30;
						min_age = 18;
					} else if (post_applied == 3) {
						max_age = 30;
						min_age = 18;
					} else if (post_applied == 4) {
						max_age = 30;
						min_age = 21;
					}

				}

				if ("true".equalsIgnoreCase(applicationFormBean.getEx_servicemanS())) {
					exman = true;
				}
				if ("true".equalsIgnoreCase(applicationFormBean.getEmployee_ssbS())) {
					Date govtDate = sdf.parse(applicationFormBean.getEmp_date_since());
					Age age = AgeCalculator.calculateAge(govtDate, notificationDate);
					if (age.getYears() >= 3) {
						govtFlag = true;
					} else {
						govtFlag = false;
					}

					if (applicationFormBean.getPresent_employer() == null
							|| applicationFormBean.getPresent_employer() == "") {
						messageOb.add("Please Enter Name of Present Organization for Employment Certificate.");
					} else if (applicationFormBean.getEmp_date_since() == null
							|| applicationFormBean.getEmp_date_since() == "") {
						messageOb.add("Please Enter Date Since When for Employment Certificate.");
					} else if (applicationFormBean.getPost_held() == null || applicationFormBean.getPost_held() == "") {
						messageOb.add("Please Enter Post held for Employment Certificate");
					} else if (applicationFormBean.getNocdesignation() == null
							|| applicationFormBean.getNocdesignation() == "") {
						messageOb.add("Please Enter Issuing Authority (NOC) for Employment Certificate");
					} else if (govtFlag == false) {
						messageOb.add(
								"You are not eligible for Departmental Candidates, due to service is less than 3 years");
					} else if (!dateDiff(date_ssc, applicationFormBean.getEmp_date_since())) {
						messageOb.add("Date Since should be atleast 12 years after Date of birth for Employment");
					} else if (!dateDiff(dob, applicationFormBean.getEmp_date_since())) {
						messageOb.add("Date Since should be Greater than Date of birth for Employment");
					}

				}


				if ("true".equalsIgnoreCase(applicationFormBean.getJk_domiciledS())
						|| "true".equalsIgnoreCase(applicationFormBean.getRiots_gujaratS())
						|| "true".equalsIgnoreCase(applicationFormBean.getRiots_affectedS())) {
					riots_flag = true;
					if(applicationFormBean.getJk_cert_no()==null || applicationFormBean.getJk_cert_no().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Certificate No for J&K Domicile Certificate");
					}
					else if(applicationFormBean.getJk_date_Issue()==null || applicationFormBean.getJk_date_Issue().equalsIgnoreCase("")) {
						messageOb.add("Please Select Date Of Issued for J&K Domicile Certificate");
					}else if(applicationFormBean.getJk_issue_authority()==null || applicationFormBean.getJk_issue_authority().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Issuing Authority for J&K Domicile Certificate");
					}
					else if(!dateDiff(dob,applicationFormBean.getJk_date_Issue())){
						messageOb.add("Date Of Issued should be Greater than Date of birth for J&K Domicile Certificate");
					}
					
					else if(applicationFormBean.getRiots_cert_no()==null || applicationFormBean.getRiots_cert_no().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Certificate No for riots Certificate");
					}
					else if(applicationFormBean.getRiots_date_Issue()==null || applicationFormBean.getRiots_date_Issue().equalsIgnoreCase("")) {
						messageOb.add("Please Select Date Of Issued for riots Certificate");
					}else if(applicationFormBean.getRiots_issue_authority()==null || applicationFormBean.getRiots_issue_authority().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Issuing Authority for riots Certificate");
					}
					else if(!dateDiff(dob,applicationFormBean.getRiots_date_Issue())){
						messageOb.add("Date Of Issued should be Greater than Date of birth for riots Certificate");
					}
					
				}
				/*
				 * System.out.println("exman="+exman); System.out.println("govtFlag="+govtFlag);
				 * System.out.println("riots_flag="+riots_flag);
				 */

				if (exman == true) {
					int bmo = Integer.parseInt(dobArray[1]);
					int bday = Integer.parseInt(dobArray[0]);
					int years_exman = byr + 16;
					String date_exman = bday + "-" + bmo + "-" + years_exman;
					boolean sixMonths = false;

					if (applicationFormBean.getExman_enrollment_date() == null
							|| applicationFormBean.getExman_enrollment_date().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Date of Enrollment for Ex-Serviceman Certificate.");
					} else if (applicationFormBean.getExman_retirement_date() == null
							|| applicationFormBean.getExman_retirement_date().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Date of Retirement / Discharge for Ex-Serviceman Certificate.");
					} else if (applicationFormBean.getExman_med_cat() == null
							|| applicationFormBean.getExman_med_cat().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Medical Category for Ex-Serviceman Certificate.");
					} else if (applicationFormBean.getExman_discharge_reason() == null
							|| applicationFormBean.getExman_discharge_reason().equalsIgnoreCase("")) {
						messageOb.add("Please Enter Reasons for release/Discharge for Ex-Serviceman Certificate.");
					}

					if (!dateDiff(dob, applicationFormBean.getExman_enrollment_date())) {
						messageOb.add("Date of Enrollment should be Greater than Date of birth for Ex-Serviceman");
					}

					if (!dateDiff(date_exman, applicationFormBean.getExman_enrollment_date())) {
						sixMonths = true;
						messageOb.add(
								"Date of Enrollment should be Greater than 16 years after Date of birth for Ex-Serviceman");
					}

					if (!dateDiff(dob, applicationFormBean.getExman_retirement_date())) {
						sixMonths = true;
						messageOb.add(
								"Date of Retirement / Discharge should be Greater than Date of birth for Ex-Serviceman");
					}
					Age1 age1 = getAgeOfTwoDates(applicationFormBean.getExman_enrollment_date(),
							applicationFormBean.getExman_retirement_date());
					if (age1.getYears() == 0 && age1.getMonths() < 6) {
						sixMonths = true;
						messageOb.add(
								"Date of Retirement / Discharge should be at least 6 Months after Date of Enrollment for Ex-Serviceman");
					}
					if (!dateDiff(applicationFormBean.getExman_enrollment_date(),
							applicationFormBean.getExman_retirement_date())) {
						messageOb.add(
								"Date of Retirement / Discharge should be Greater than Date of Enrollment for Ex-Serviceman");
					}
					String enrollMentDate = applicationFormBean.getExman_enrollment_date();
					String retirementDate = applicationFormBean.getExman_retirement_date();
					int exService = AgeCaluclateFor2Dates(enrollMentDate, retirementDate);
					int age = applicationFormBean.getAge();
					int exman_ser_age_diff = (age - exService);

					if (sixMonths == false) {
						if (community.equalsIgnoreCase("General") || community.equalsIgnoreCase("EWS")) {
							if (exman_ser_age_diff <= (max_age + 3)) {

							} else {
								max_age = max_age + exService + 3;
								messageOb.add("Your age must be in between " + min_age + " TO " + max_age + ".");
							}
						}
						if (community.equalsIgnoreCase("OBC")) {
							if (exman_ser_age_diff <= (max_age + 6)) {

							} else {
								max_age = max_age + exService + 6;
								messageOb.add("Your age must be in between " + min_age + " TO " + max_age + ".");
							}
						}
						if (community.equalsIgnoreCase("SC") || community.equalsIgnoreCase("ST")) {
							if (exman_ser_age_diff <= (max_age + 8)) {

							} else {
								max_age = max_age + exService + 8;
								messageOb.add("Your age must be in between " + min_age + " TO " + max_age + ".");
							}
						}
					}

				} else {

					if (govtFlag == true) {

						if ("SC".equalsIgnoreCase(community) || "ST".equalsIgnoreCase(community)) {
							max_age = 40;
						} else if ("OBC".equalsIgnoreCase(community)) {
							max_age = 38;
						} else if ("General".equalsIgnoreCase(community) || "EWS".equalsIgnoreCase(community)) {
							max_age = 35;
						}

					}

				  else if (riots_flag == true) {
						if ("SC".equalsIgnoreCase(community) || "ST".equalsIgnoreCase(community)) {
							max_age = max_age + 10;
						} else if ("OBC".equalsIgnoreCase(community)) {
							max_age = max_age + 8;
						} else if ("General".equalsIgnoreCase(community) || "EWS".equalsIgnoreCase(community)) {
							max_age = max_age + 5;
						}
					} else {
						if ("SC".equalsIgnoreCase(community) || "ST".equalsIgnoreCase(community)) {
							max_age = max_age + 5;
						} else if ("OBC".equalsIgnoreCase(community)) {
							max_age = max_age + 3;
						} else if ("General".equalsIgnoreCase(community) || "EWS".equalsIgnoreCase(community)) {
							max_age = max_age + 0;
						}
					}

					Age age = AgeCalculator.calculateAge(birthDate, notificationDate);
					if (age.getYears() < min_age) {
						messageOb.add("Your age must be more than or equal to " + min_age + " years.");
					} else {
						int age_years = age.getYears();
						if (age.getMonths() == 0 && age.getDays() == 0) {

						} else {
							age_years = age_years + 1;
						}

						if (age_years <= max_age) {
						} else {
							messageOb.add("Your age must be in between " + min_age + " TO " + max_age + ".");
						}
					}
				}
			}

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("ServerSideSanitaion",
			// exceptionAsString, null,null, null);
		}
	}

	private int AgeCaluclateFor2Dates(String enrollMentDate, String retirementDate) {
		String[] date1Arr = enrollMentDate.split("-");
		int byr = Integer.parseInt(date1Arr[2]);
		int bmo = Integer.parseInt(date1Arr[1]);
		int bday = Integer.parseInt(date1Arr[0]);

		String[] date2Arr = retirementDate.split("-");
		int tyr = Integer.parseInt(date2Arr[2]);
		int tmo = Integer.parseInt(date2Arr[1]);
		int tday = Integer.parseInt(date2Arr[0]);
		int tmpage = 0, age = 0;

		if ((tmo > bmo) || (tmo == bmo & tday >= bday)) {
			tmpage = byr;
		} else {
			tmpage = byr + 1;
		}
		age = (tyr - tmpage);
		return age;

	}

	public static boolean dateDiff(String startD, String endD) {
		String[] dobArr = startD.split("-");
		String byr = dobArr[2];
		String bmo = dobArr[1];
		String bday = dobArr[0];
		startD = byr + "-" + bmo + "-" + bday;

		String[] dobArr1 = endD.split("-");
		String byr1 = dobArr1[2];
		String bmo1 = dobArr1[1];
		String bday1 = dobArr1[0];
		endD = byr1 + "-" + bmo1 + "-" + bday1;

		Date start = null, end = null;
		try {
			start = new SimpleDateFormat("yyyy-MM-dd").parse(startD);
			end = new SimpleDateFormat("yyyy-MM-dd").parse(endD);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long diffInMillies = end.getTime() - start.getTime();
		long days = Math.round(diffInMillies / (1000.0 * 60 * 60 * 24));

		if (days > 0) {
			return true;
		}
		return false;
	}

	public Age1 getAgeOfTwoDates(String enrollMentDate, String retirementDate) {
		String[] dobArr = enrollMentDate.split("-");
		int byr = Integer.parseInt(dobArr[2]);
		int bmo = Integer.parseInt(dobArr[1]) - 1;
		int bday = Integer.parseInt(dobArr[0]);

		String[] date1Arr = retirementDate.split("-");
		int byr1 = Integer.parseInt(date1Arr[2]);
		int bmo1 = Integer.parseInt(date1Arr[1]) - 1;
		int bday1 = Integer.parseInt(date1Arr[0]);

		Calendar cal = Calendar.getInstance();
		cal.set(byr, bmo, bday);
		Date date_s = cal.getTime();
		cal.set(byr1, bmo1, bday1);
		Date date_e = cal.getTime();

		Calendar dob = Calendar.getInstance();
		dob.setTime(date_s);
		Calendar today = Calendar.getInstance();
		today.setTime(date_e);
		Age1 age = new Age1();

		int years = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		int months = today.get(Calendar.MONTH) - dob.get(Calendar.MONTH);
		int days = today.get(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH);

		if (months < 0) {
			years--;
			months += 12;
		}
		if (days < 0) {
			months--;
			days += dob.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		age.setYears(years);
		age.setMonths(months);
		age.setDays(days);

		if (age.getYears() <= 0) {
			age.setYears(0);
		}
		if (age.getMonths() <= 0) {
			age.setMonths(0);
		}
		if (age.getDays() <= 0) {
			age.setDays(0);
		}

		return age;
	}

}
