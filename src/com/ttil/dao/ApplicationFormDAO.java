package com.ttil.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.AppDataBean;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.HDFCPaymentBean;
import com.ttil.bean.PaymentBean;
import com.ttil.bean.PostsBean;
import com.ttil.util.DbConnection;
import com.ttil.util.StringUtils;

public class ApplicationFormDAO {

	/**
	 * This will check any duplicate records exist with Mobile number or Email or
	 * Personal details like Name, fathername, mothername , DOB
	 * 
	 * @param appFormBean
	 * @param postsBean
	 * @return
	 */
	public int checkMobileAndEmail(ApplicationFormBean appFormBean, PostsBean postsBean) {
		Connection con = null;
		String query_check = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int transaction_id = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				// query_check="select transactionid,mobileNumber,emailaddress from applicants
				// WHERE post_id=? and org_id=? and (mobileNumber=? or emailaddress=?)";
				// query_check="select transactionid,mobileNumber,emailaddress,fullname from
				// applicants WHERE post_applied=? and application_status='FINISHED' and
				// ((mobileNumber=? or emailaddress=?) or (fullname=? and father_name=? and
				// mother_name=? and dob=? and community=?))";
				// query_check="select transactionid,mobileNumber,emailaddress,fullname from
				// applicants WHERE post_applied=? and ((mobileNumber=? or emailaddress=?) or
				// (fullname=? and father_name=? and mother_name=? and dob=? and community=?))";
				query_check = "select transactionid,mobileNumber,emailaddress,fullname from applicants WHERE application_status is not null  and  ((mobileNumber=? or emailaddress=? or aadhar_no=?) or (fullname=? and father_name=? and mother_name=? and dob=? and community=?))";
				
				if (appFormBean.getTransactionidEdit() != 0) {
					query_check+=" and transactionid!=?";
				}
				
				pstmt1 = con.prepareStatement(query_check);
				String enteredMobileNumber = ESAPI.encoder().canonicalize(appFormBean.getMobileNumber());
				String enteredEmailAddress = ESAPI.encoder().canonicalize(appFormBean.getEmailaddress());
				String enteredFullname = ESAPI.encoder().canonicalize(appFormBean.getFullname());
				/*
				 * pstmt1.setInt(1, postsBean.getPost_id());
				 * pstmt1.setInt(2, postsBean.getOrg_id());
				 */
				// pstmt1.setString(1,
				// ESAPI.encoder().canonicalize(appFormBean.getPost_applied()));
				pstmt1.setString(1, enteredMobileNumber);
				pstmt1.setString(2, enteredEmailAddress);
				pstmt1.setString(3, ESAPI.encoder().canonicalize(appFormBean.getAadharNo()));
				pstmt1.setString(4, enteredFullname);
				pstmt1.setString(5, ESAPI.encoder().canonicalize(appFormBean.getFather_name()));
				pstmt1.setString(6, ESAPI.encoder().canonicalize(appFormBean.getMother_name()));
				pstmt1.setString(7,
						StringUtils.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getDob())));
				pstmt1.setString(8, ESAPI.encoder().canonicalize(appFormBean.getCommunity()));
				// System.out.println(pstmt1.toString());
				
				if (appFormBean.getTransactionidEdit() != 0) {
					pstmt1.setInt(9, appFormBean.getTransactionidEdit());
				}
				
				rs = pstmt1.executeQuery();
				int mobileReturnNo = 0, emailReturnNo = 0;

				if (rs.next()) {
					String mobileNo = rs.getString("mobileNumber");
					String emailAddress = rs.getString("emailaddress");
					String fullname = rs.getString("fullname");
					/*
					 * boolean is_rejected=rs.getBoolean("is_rejected"); if(is_rejected==true){
					 * return 0; }else{
					 */
					if (enteredMobileNumber.equalsIgnoreCase(mobileNo))
						mobileReturnNo = -1;
					if (enteredEmailAddress.equalsIgnoreCase(emailAddress))
						emailReturnNo = -2;

					if (mobileReturnNo == -1 && emailReturnNo == -2)
						return -3;
					else if (mobileReturnNo == -1)
						return -1;
					else if (emailReturnNo == -2)
						return -2;
					else
						return -5;

				} else {
					return 0;
				}

			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO",
				// "Connection is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO Catch",
			 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO Catch",
			 * exceptionAsString, null, null, null);
			 */return -4;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO in
				// Finally", exceptionAsString, null, null, null);
			}
		}
	}

	public int checkDuplicateRecord(ApplicationFormBean appFormBean) {
		Connection con = null;
		String query_check = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int transaction_id = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				query_check = "select transactionid,mobileNumber,emailaddress,fullname  from applicants WHERE application_status is not null  and ((mobileNumber=? or emailaddress=? or aadhar_no=?) or (fullname=? and father_name=? and mother_name=? and dob=? and community=?)) and transactionid!=? ";
				pstmt1 = con.prepareStatement(query_check);
				String enteredMobileNumber = ESAPI.encoder().canonicalize(appFormBean.getMobileNumber());
				String enteredEmailAddress = ESAPI.encoder().canonicalize(appFormBean.getEmailaddress());
				String enteredFullname = ESAPI.encoder().canonicalize(appFormBean.getFullname());
				pstmt1.setString(1, enteredMobileNumber);
				pstmt1.setString(2, enteredEmailAddress);
				pstmt1.setString(3, ESAPI.encoder().canonicalize(appFormBean.getAadharNo()));
				pstmt1.setString(4, enteredFullname);
				pstmt1.setString(5, ESAPI.encoder().canonicalize(appFormBean.getFather_name()));
				pstmt1.setString(6, ESAPI.encoder().canonicalize(appFormBean.getMother_name()));
				pstmt1.setString(7,
						StringUtils.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getDob())));
				pstmt1.setString(8, ESAPI.encoder().canonicalize(appFormBean.getCommunity()));
				pstmt1.setInt(9, appFormBean.getTransactionid());
				rs = pstmt1.executeQuery();
				int mobileReturnNo = 0, emailReturnNo = 0;
				if (rs.next()) {
					String mobileNo = rs.getString("mobileNumber");
					String emailAddress = rs.getString("emailaddress");
					String fullname = rs.getString("fullname");
//					boolean is_rejected = rs.getBoolean("is_rejected");
//					if (is_rejected == true) {
//						return 0;
//					} else {
						if (enteredMobileNumber.equalsIgnoreCase(mobileNo))
							mobileReturnNo = -1;
						if (enteredEmailAddress.equalsIgnoreCase(emailAddress))
							emailReturnNo = -2;

						if (mobileReturnNo == -1 && emailReturnNo == -2)
							return -3;
						else if (mobileReturnNo == -1)
							return -1;
						else if (emailReturnNo == -2)
							return -2;
						else
							return -5;
//					}

				} else {
					return 0;
				}

			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO",
				// "Connection is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO Catch",
			 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO Catch",
			 * exceptionAsString, null, null, null);
			 */return -4;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO in
				// Finally", exceptionAsString, null, null, null);
			}
		}
	}

	/**
	 * This will save whole applicant data into different tables
	 * 
	 * @param appFormBean
	 * @param ipaddress
	 * @param post_id
	 * @param org_id
	 * @param browser
	 * @return
	 */
	public int saveData(ApplicationFormBean appFormBean, String ipaddress, int post_id, int org_id, String browser) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null, pstmt_date = null, pstmt_user = null, pstmt_update = null;
		ResultSet rs = null, rs_date = null;
		int transaction_id = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				String currentDate = getCurrentDate();
				appFormBean.setDate_created(currentDate);
				con.setAutoCommit(false);
				String query = "INSERT INTO applicants (first_name, middle_name, last_name, father_name, mobileNumber, sex, dob, religion, other_religion, identification_mark, community, category, affected_categories, ex_serviceman, ssb_emp_service, govt_emp_service, village, tehsil, postoffice, policestation, district, state, pincode, correspondance_address, village1, tehsil1, postoffice1, policestation1, district1, state1, pincode1, debarment, fir_case, fir_case_pending, arrested, criminal_case_acquitted, good_behavior_bond, date_created, ipAddress, post_id, org_id, payment_exempted,photo_file_name,signature_file_name,emailaddress,edu_qual,post_applied,marrital_status,nationality,other_nationality,aadhar_no,category_belongs,jk_domiciled,riots_affected,riots_gujarat,fee_amount,mother_name,application_status,fullname,identity_type,browser,post_selected_name) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				pstmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, ESAPI.encoder().canonicalize(appFormBean.getFirst_name()));
				pstmt.setString(2, ESAPI.encoder().canonicalize(appFormBean.getMiddle_name()));
				pstmt.setString(3, ESAPI.encoder().canonicalize(appFormBean.getLast_name()));
				pstmt.setString(4, ESAPI.encoder().canonicalize(appFormBean.getFather_name()));
				pstmt.setString(5, ESAPI.encoder().canonicalize(appFormBean.getMobileNumber()));
				pstmt.setString(6, ESAPI.encoder().canonicalize(appFormBean.getSex().substring(0, 1)));
				pstmt.setString(7, StringUtils.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getDob()))); // date
				pstmt.setString(8, ESAPI.encoder().canonicalize(appFormBean.getReligion()));
				pstmt.setString(9, ESAPI.encoder().canonicalize(appFormBean.getOther_religion()));
				pstmt.setString(10, ESAPI.encoder().canonicalize(appFormBean.getIdentification_mark()));
				pstmt.setString(11, ESAPI.encoder().canonicalize(appFormBean.getCommunity()));
				pstmt.setString(12, ESAPI.encoder().canonicalize(appFormBean.getCategory()));
				pstmt.setString(13, null); //
				pstmt.setBoolean(14, appFormBean.isEx_serviceman());
				pstmt.setBoolean(15, appFormBean.isEmployee_ssb());
				pstmt.setBoolean(16, appFormBean.isGovt_service());
				pstmt.setString(17, ESAPI.encoder().canonicalize(appFormBean.getVillage()));
				pstmt.setString(18, ESAPI.encoder().canonicalize(appFormBean.getTehsil()));
				pstmt.setString(19, ESAPI.encoder().canonicalize(appFormBean.getPostoffice()));
				pstmt.setString(20, ESAPI.encoder().canonicalize(appFormBean.getPolicestation()));
				pstmt.setString(21, ESAPI.encoder().canonicalize(appFormBean.getDistrict())); // district
				pstmt.setString(22, ESAPI.encoder().canonicalize(appFormBean.getState()));
				pstmt.setString(23, ESAPI.encoder().canonicalize(appFormBean.getPincode()));
				pstmt.setBoolean(24, appFormBean.isCorrespondence_address());
				pstmt.setString(25, ESAPI.encoder().canonicalize(appFormBean.getVillage1()));
				pstmt.setString(26, ESAPI.encoder().canonicalize(appFormBean.getTehsil1()));
				pstmt.setString(27, ESAPI.encoder().canonicalize(appFormBean.getPostoffice1()));
				pstmt.setString(28, ESAPI.encoder().canonicalize(appFormBean.getPolicestation1()));
				pstmt.setString(29, ESAPI.encoder().canonicalize(appFormBean.getDistrict1())); // district
				pstmt.setString(30, ESAPI.encoder().canonicalize(appFormBean.getState1()));
				pstmt.setString(31, ESAPI.encoder().canonicalize(appFormBean.getPincode1()));
				pstmt.setBoolean(32, appFormBean.isDebarment());
				pstmt.setBoolean(33, appFormBean.isFir_cases());
				pstmt.setBoolean(34, appFormBean.isFir_cases_pending());
				pstmt.setBoolean(35, appFormBean.isArrested());
				pstmt.setBoolean(36, appFormBean.isCriminal_case_acquitted());
				pstmt.setBoolean(37, appFormBean.isGood_behavior_bond());
				pstmt.setString(38, appFormBean.getDate_created()); // date_created
				pstmt.setString(39, ipaddress); // ipAddress
				pstmt.setInt(40, post_id); // post id
				pstmt.setInt(41, org_id); // org_id
				pstmt.setBoolean(42, appFormBean.isPayExempted());
				pstmt.setString(43, appFormBean.getPhotoFileName());
				pstmt.setString(44, appFormBean.getSigFileName());
				pstmt.setString(45, ESAPI.encoder().canonicalize(appFormBean.getEmailaddress()));
				pstmt.setString(46, ESAPI.encoder().canonicalize(appFormBean.getEdu_qual()));
				pstmt.setString(47, ESAPI.encoder().canonicalize(appFormBean.getPost_applied()));
				pstmt.setString(48, ESAPI.encoder().canonicalize(appFormBean.getMarrital_status()));
				pstmt.setString(49, ESAPI.encoder().canonicalize(appFormBean.getNationality()));
				pstmt.setString(50, ESAPI.encoder().canonicalize(appFormBean.getOther_nationality()));
				pstmt.setString(51, ESAPI.encoder().canonicalize(appFormBean.getAadharNo()));
				pstmt.setBoolean(52, appFormBean.isCategoty_belongs());
				pstmt.setBoolean(53, appFormBean.isJk_domiciled());
				pstmt.setBoolean(54, appFormBean.isRiots_affected());
				pstmt.setBoolean(55, appFormBean.isRiots_gujarat());
				pstmt.setInt(56, appFormBean.getFee_amount());
				pstmt.setString(57, ESAPI.encoder().canonicalize(appFormBean.getMother_name()));
				pstmt.setString(58, null);
				pstmt.setString(59, ESAPI.encoder().canonicalize(appFormBean.getFullname()));
				pstmt.setString(60, ESAPI.encoder().canonicalize(appFormBean.getIdentity_type()));
				pstmt.setString(61, browser);
				pstmt.setString(62, ESAPI.encoder().canonicalize(appFormBean.getPost_selected_name()));

				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				if (rs != null && rs.next()) {
					transaction_id = rs.getInt(1);
				}
				// System.out.println("transaction_id="+transaction_id);
				if (transaction_id > 0) {

					String query_date = "select DATE_FORMAT(`date_created`,'%d-%m-%Y %H:%i:%s') as date_created_format from applicants WHERE transactionid=?";
					pstmt_date = con.prepareStatement(query_date);
					pstmt_date.setInt(1, transaction_id);
					rs_date = pstmt_date.executeQuery();
					if (rs_date.next()) {
						appFormBean.setDate_created(rs_date.getString("date_created_format"));
					}

					String exam_passed_1 = appFormBean.getExam_passed_1();
					String stream_1 = appFormBean.getStream_1();
					String university_1 = appFormBean.getUniversity_1();
					String edu_rollno_1 = appFormBean.getEdu_rollno_1();
					String edu_certno_1 = appFormBean.getEdu_certno_1();
					String edu_date_issue_1 = appFormBean.getEdu_date_issue_1();
					String edu_year_1 = appFormBean.getEdu_year_1();

					String exam_passed_2 = appFormBean.getExam_passed_2();
					String stream_2 = appFormBean.getStream_2();
					String university_2 = appFormBean.getUniversity_2();
					String edu_rollno_2 = appFormBean.getEdu_rollno_2();
					String edu_certno_2 = appFormBean.getEdu_certno_2();
					String edu_date_issue_2 = appFormBean.getEdu_date_issue_2();
					String edu_year_2 = appFormBean.getEdu_year_2();

					String edu_marks_1 = appFormBean.getEdu_marks_1();
					String edu_marks_2 = appFormBean.getEdu_marks_2();

					/*
					 * String edu_marks_6=appFormBean.getEdu_marks_6();
					 * String edu_marks_7=appFormBean.getEdu_marks_7();
					 */

					String exam_passed_3 = appFormBean.getExam_passed_3();
					String stream_3 = appFormBean.getStream_3();
					String university_3 = appFormBean.getUniversity_3();
					String edu_rollno_3 = appFormBean.getEdu_rollno_3();
					String edu_certno_3 = appFormBean.getEdu_certno_3();
					String edu_date_issue_3 = appFormBean.getEdu_date_issue_3();
					String edu_year_3 = appFormBean.getEdu_year_3();
					String edu_marks_3 = appFormBean.getEdu_marks_3();

					String exam_passed_4 = appFormBean.getExam_passed_4();
					String stream_4 = appFormBean.getStream_4();
					String university_4 = appFormBean.getUniversity_4();
					String edu_rollno_4 = appFormBean.getEdu_rollno_4();
					String edu_certno_4 = appFormBean.getEdu_certno_4();
					String edu_date_issue_4 = appFormBean.getEdu_date_issue_4();
					String edu_year_4 = appFormBean.getEdu_year_4();
					String edu_marks_4 = appFormBean.getEdu_marks_4();

					String exam_passed_5 = appFormBean.getExam_passed_5();
					String stream_5 = appFormBean.getStream_5();
					String university_5 = appFormBean.getUniversity_5();
					String edu_rollno_5 = appFormBean.getEdu_rollno_5();
					String edu_certno_5 = appFormBean.getEdu_certno_5();
					String edu_date_issue_5 = appFormBean.getEdu_date_issue_5();
					String edu_year_5 = appFormBean.getEdu_year_5();
					String edu_marks_5 = appFormBean.getEdu_marks_5();

					String exam_passed_plus2 = appFormBean.getExam_passed_plus2();
					String stream_plus2 = appFormBean.getStream_plus2();
					String university_plus2 = appFormBean.getUniversity_plus2();
					String edu_rollno_plus2 = appFormBean.getEdu_rollno_plus2();
					String edu_certno_plus2 = appFormBean.getEdu_certno_plus2();
					String edu_date_issue_plus2 = appFormBean.getEdu_date_issue_plus2();
					String edu_year_plus2 = appFormBean.getEdu_year_plus2();
					String edu_marks_plus2 = appFormBean.getEdu_marks_plus2();

					boolean edu_qual_1 = true, edu_qual_2 = true, edu_qual_3 = true, edu_qual_4 = true,
							edu_qual_plus2 = true, edu_qual_5 = true, edu_qual_7 = true, edu_qual_8 = true;
					if ("".equalsIgnoreCase(exam_passed_1) || "".equalsIgnoreCase(stream_1)
							|| "".equalsIgnoreCase(university_1) || "".equalsIgnoreCase(edu_rollno_1)
							|| "".equalsIgnoreCase(edu_certno_1) || "".equalsIgnoreCase(edu_date_issue_1)
							|| "".equalsIgnoreCase(edu_marks_1) || "".equalsIgnoreCase(edu_year_1)) {
						edu_qual_1 = false;
					}
					if ("".equalsIgnoreCase(exam_passed_2) || "".equalsIgnoreCase(stream_2)
							|| "".equalsIgnoreCase(university_2) || "".equalsIgnoreCase(edu_rollno_2)
							|| "".equalsIgnoreCase(edu_certno_2) || "".equalsIgnoreCase(edu_date_issue_2)
							|| "".equalsIgnoreCase(edu_marks_2) || "".equalsIgnoreCase(edu_year_2)) {
						edu_qual_2 = false;
					}
					if (exam_passed_3 == null || stream_3 == null || university_3 == null || edu_rollno_3 == null
							|| edu_certno_3 == null || edu_date_issue_3 == null || edu_marks_3 == null
							|| edu_year_3 == null ||
							"".equalsIgnoreCase(exam_passed_3) || "".equalsIgnoreCase(stream_3)
							|| "".equalsIgnoreCase(university_3) || "".equalsIgnoreCase(edu_rollno_3)
							|| "".equalsIgnoreCase(edu_certno_3) || "".equalsIgnoreCase(edu_date_issue_3)
							|| "".equalsIgnoreCase(edu_marks_3) || "".equalsIgnoreCase(edu_year_3)
							|| "null".equalsIgnoreCase(exam_passed_3) || "null".equalsIgnoreCase(stream_3)
							|| "null".equalsIgnoreCase(university_3) || "null".equalsIgnoreCase(edu_rollno_3)
							|| "null".equalsIgnoreCase(edu_certno_3) || "null".equalsIgnoreCase(edu_date_issue_3)
							|| "null".equalsIgnoreCase(edu_marks_3) || "null".equalsIgnoreCase(edu_year_3)) {
						edu_qual_3 = false;
					}

					if (exam_passed_4 == null || stream_4 == null || university_4 == null || edu_rollno_4 == null
							|| edu_certno_4 == null || edu_date_issue_4 == null || edu_marks_4 == null
							|| edu_year_4 == null ||
							"".equalsIgnoreCase(exam_passed_4) || "".equalsIgnoreCase(stream_4)
							|| "".equalsIgnoreCase(university_4) || "".equalsIgnoreCase(edu_rollno_4)
							|| "".equalsIgnoreCase(edu_certno_4) || "".equalsIgnoreCase(edu_date_issue_4)
							|| "".equalsIgnoreCase(edu_marks_4) || "".equalsIgnoreCase(edu_year_4)
							|| "null".equalsIgnoreCase(exam_passed_4) || "null".equalsIgnoreCase(stream_4)
							|| "null".equalsIgnoreCase(university_4) || "null".equalsIgnoreCase(edu_rollno_4)
							|| "null".equalsIgnoreCase(edu_certno_4) || "null".equalsIgnoreCase(edu_date_issue_4)
							|| "null".equalsIgnoreCase(edu_marks_4) || "null".equalsIgnoreCase(edu_year_4)) {
						edu_qual_4 = false;
					}

					if (exam_passed_plus2 == null || stream_plus2 == null || university_plus2 == null
							|| edu_rollno_plus2 == null || edu_certno_plus2 == null || edu_date_issue_plus2 == null
							|| edu_marks_plus2 == null || edu_year_plus2 == null ||
							"".equalsIgnoreCase(exam_passed_plus2) || "".equalsIgnoreCase(stream_plus2)
							|| "".equalsIgnoreCase(university_plus2) || "".equalsIgnoreCase(edu_rollno_plus2)
							|| "".equalsIgnoreCase(edu_certno_plus2) || "".equalsIgnoreCase(edu_date_issue_plus2)
							|| "".equalsIgnoreCase(edu_marks_plus2) || "".equalsIgnoreCase(edu_year_plus2)
							|| "null".equalsIgnoreCase(exam_passed_plus2) || "null".equalsIgnoreCase(stream_plus2)
							|| "null".equalsIgnoreCase(university_plus2) || "null".equalsIgnoreCase(edu_rollno_plus2)
							|| "null".equalsIgnoreCase(edu_certno_plus2)
							|| "null".equalsIgnoreCase(edu_date_issue_plus2) || "null".equalsIgnoreCase(edu_marks_plus2)
							|| "null".equalsIgnoreCase(edu_year_plus2)) {
						edu_qual_plus2 = false;
					}

					if (exam_passed_5 == null || stream_5 == null || university_5 == null || edu_rollno_5 == null
							|| edu_certno_5 == null || edu_date_issue_5 == null || edu_marks_5 == null
							|| edu_year_5 == null ||
							"".equalsIgnoreCase(exam_passed_5) || "".equalsIgnoreCase(stream_5)
							|| "".equalsIgnoreCase(university_5) || "".equalsIgnoreCase(edu_rollno_5)
							|| "".equalsIgnoreCase(edu_certno_5) || "".equalsIgnoreCase(edu_date_issue_5)
							|| "".equalsIgnoreCase(edu_marks_5) || "".equalsIgnoreCase(edu_year_5)
							|| "null".equalsIgnoreCase(exam_passed_5) || "null".equalsIgnoreCase(stream_5)
							|| "null".equalsIgnoreCase(university_5) || "null".equalsIgnoreCase(edu_rollno_5)
							|| "null".equalsIgnoreCase(edu_certno_5) || "null".equalsIgnoreCase(edu_date_issue_5)
							|| "null".equalsIgnoreCase(edu_marks_5) || "null".equalsIgnoreCase(edu_year_5)) {
						edu_qual_5 = false;
					}

					String query_edu_qualifications = "INSERT INTO education_details (transactionid,  exam_passed, university, cert_no, date_issue, rollno, subject,percentage,ed_qual,year)  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
					PreparedStatement pstmt4 = con.prepareStatement(query_edu_qualifications);
					if (edu_qual_1) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_1()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_1()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_1()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_1()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_1()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_1()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_1()));
						pstmt4.setInt(9, 1);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_1()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_2) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_2()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_2()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_2()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_2()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_2()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_2()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_2()));
						pstmt4.setInt(9, 2);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_2()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_plus2) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_plus2()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_plus2()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_plus2()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_plus2()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_plus2()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_plus2()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_plus2()));
						pstmt4.setInt(9, 3);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_plus2()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_3) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_3()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_3()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_3()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_3()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_3()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_3()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_3()));
						pstmt4.setInt(9, 4);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_3()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_4) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_4()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_4()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_4()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_4()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_4()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_4()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_4()));
						pstmt4.setInt(9, 5);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_4()));
						pstmt4.executeUpdate();
					}

					if (edu_qual_5) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_5()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_5()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_5()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_5()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_5()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_5()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_5()));
						pstmt4.setInt(9, 6);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_5()));
						pstmt4.executeUpdate();
					}

					if (pstmt4 != null)
						pstmt4.close();

					String query_essential = "INSERT INTO essential_qualification (transactionid,  qualification,answer,sno)  VALUES ( ?, ?,?,?);";
					PreparedStatement pstmt8 = con.prepareStatement(query_essential);
					if (appFormBean.getQualification1_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification1_text()));
						pstmt8.setString(3, appFormBean.getQualification1());
						pstmt8.setInt(4, 1);
						pstmt8.execute();
					}
					if (appFormBean.getQualification2_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification2_text()));
						pstmt8.setString(3, appFormBean.getQualification2());
						pstmt8.setInt(4, 2);
						pstmt8.execute();
					}
					if (appFormBean.getQualification3_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification3_text()));
						pstmt8.setString(3, appFormBean.getQualification3());
						pstmt8.setInt(4, 3);
						pstmt8.execute();
					}
					if (appFormBean.getQualification4_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification4_text()));
						pstmt8.setString(3, appFormBean.getQualification4());
						pstmt8.setInt(4, 4);
						pstmt8.execute();
					}
					if (pstmt8 != null)
						pstmt8.close(); 

					String query_personal = "INSERT INTO personal_qualification (transactionid,hc_lab_assistant_cert,hc_lab_assistant_experience,hc_physio_cert,hc_phsio_assistant_experience,ct_nursing_first_aid_cert,ct_nursing_assistant_experience ) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pstmtPersonal = con.prepareStatement(query_personal);
					pstmtPersonal.setInt(1, transaction_id);
					// hc-lab
					if (appFormBean.getHcLabAsstCertValue() == "") {
						pstmtPersonal.setNull(2, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(2, appFormBean.isHcLabAsstCert());
					}

					if (appFormBean.getHcLabAsstExpValue() == "") {
						pstmtPersonal.setNull(3, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(3, appFormBean.isHcLabAsstExp());
					}

					// hc-physio
					if (appFormBean.getHcPhysioAsstCertValue() == "") {
						pstmtPersonal.setNull(4, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(4, appFormBean.isHcPhysioAsstCert());
					}

					if (appFormBean.getHcPhysioAsstExpValue() == "") {
						pstmtPersonal.setNull(5, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(5, appFormBean.isHcPhysioAsstExp());
					}

					// ct-nursing
					if (appFormBean.getCtNursingCertValue() == "") {
						pstmtPersonal.setNull(6, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(6, appFormBean.isCtNursingCert());
					}

					if (appFormBean.getCtNursingExpValue() == "") {
						pstmtPersonal.setNull(7, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(7, appFormBean.isCtNursingExp());
					}

					// if(appFormBean.getHospital()==""){
					// pstmtPersonal.setNull(3, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(3, appFormBean.isHospital_experience());
					// }

					// if(appFormBean.getTrade()==""){
					// pstmtPersonal.setNull(4, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(4, appFormBean.isTradesmen_certificate());
					// }

					// if(appFormBean.getAutocad()==""){
					// pstmtPersonal.setNull(5, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(5, appFormBean.isAutocad_certificate());
					// }

					// if(appFormBean.getDraft()==""){
					// pstmtPersonal.setNull(6, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(6, appFormBean.isDraughtsmanship_exp());
					// }

					pstmtPersonal.execute();
					if (pstmtPersonal != null)
						pstmtPersonal.close();

					if (appFormBean.isSkills_flag()) {
						String query_skills = "INSERT INTO other_skills (transactionid,  skill,skill_no)  VALUES ( ?, ?,?);";
						PreparedStatement pstmt7 = con.prepareStatement(query_skills);
						if (appFormBean.getSkill_1() != null && !"".equalsIgnoreCase(appFormBean.getSkill_1())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_1()));
							pstmt7.setInt(3, 1);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_2() != null && !"".equalsIgnoreCase(appFormBean.getSkill_2())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_2()));
							pstmt7.setInt(3, 2);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_3() != null && !"".equalsIgnoreCase(appFormBean.getSkill_3())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_3()));
							pstmt7.setInt(3, 3);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_4() != null && !"".equalsIgnoreCase(appFormBean.getSkill_4())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_4()));
							pstmt7.setInt(3, 4);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_5() != null && !"".equalsIgnoreCase(appFormBean.getSkill_5())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_5()));
							pstmt7.setInt(3, 5);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_6() != null && !"".equalsIgnoreCase(appFormBean.getSkill_6())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_6()));
							pstmt7.setInt(3, 6);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_7() != null && !"".equalsIgnoreCase(appFormBean.getSkill_7())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_7()));
							pstmt7.setInt(3, 7);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_8() != null && !"".equalsIgnoreCase(appFormBean.getSkill_8())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_8()));
							pstmt7.setInt(3, 8);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_9() != null && !"".equalsIgnoreCase(appFormBean.getSkill_9())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_9()));
							pstmt7.setInt(3, 9);
							pstmt7.executeUpdate();
						}

						if (pstmt7 != null)
							pstmt7.close();
					}
					if (appFormBean.isCategoty_belongs()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "Community");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getCat_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getCat_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getCat_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isJk_domiciled()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "JK Domicile");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getJk_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getJk_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getJk_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isRiots_affected()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "Riots 1984");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getRiots_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getRiots_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getRiots_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isRiots_gujarat()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "Riots 2002 Gujarat");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getRiots_guj_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getRiots_guj_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getRiots_guj_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isEx_serviceman()) {
						String query_exman = "INSERT INTO exman_details (transactionid, medical_category, date_enrollment, date_retirement, award_decoration, discharge_reason, edu_qual) VALUES (?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt3 = con.prepareStatement(query_exman);
						pstmt3.setInt(1, transaction_id);
						pstmt3.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExman_med_cat()));
						pstmt3.setString(3, StringUtils.changeDateFormatYMD(
								ESAPI.encoder().canonicalize(appFormBean.getExman_enrollment_date())));
						pstmt3.setString(4, StringUtils.changeDateFormatYMD(
								ESAPI.encoder().canonicalize(appFormBean.getExman_retirement_date())));
						pstmt3.setString(5, ESAPI.encoder().canonicalize(appFormBean.getExman_awd_dec()));
						pstmt3.setString(6, ESAPI.encoder().canonicalize(appFormBean.getExman_discharge_reason()));
						pstmt3.setString(7, ESAPI.encoder().canonicalize(appFormBean.getExman_edu_qual()));
						pstmt3.executeUpdate();
						if (pstmt3 != null)
							pstmt3.close();
					}

					if (appFormBean.isGovt_service() || appFormBean.isEmployee_ssb()) {
						String query_service_insert = "INSERT INTO service_details (transactionid, emp_name, emp_date, post_held, noc_designation,emp_name2, emp_date2, post_held2, noc_designation2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt5 = con.prepareStatement(query_service_insert);
						pstmt5.setInt(1, transaction_id);
						pstmt5.setString(2, ESAPI.encoder().canonicalize(appFormBean.getPresent_employer()));
						pstmt5.setString(3, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getEmp_date_since())));
						pstmt5.setString(4, ESAPI.encoder().canonicalize(appFormBean.getPost_held()));
						pstmt5.setString(5, ESAPI.encoder().canonicalize(appFormBean.getNocdesignation()));

						pstmt5.setString(6, ESAPI.encoder().canonicalize(appFormBean.getPresent_employer2()));
						pstmt5.setString(7, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getEmp_date_since2())));
						pstmt5.setString(8, ESAPI.encoder().canonicalize(appFormBean.getPost_held2()));
						pstmt5.setString(9, ESAPI.encoder().canonicalize(appFormBean.getNocdesignation2()));
						pstmt5.executeUpdate();
						if (pstmt5 != null)
							pstmt5.close();
					}

					if (appFormBean.isDebarment()) {
						String query_cat_insert = "INSERT INTO debarment_details (transactionid, exam_organizer, exam_name, exam_date, debarment_date,reason) VALUES (?, ?, ?, ?, ?,?);";
						PreparedStatement pstmt2 = con.prepareStatement(query_cat_insert);
						pstmt2.setInt(1, transaction_id);
						pstmt2.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExamorganizer()));
						pstmt2.setString(3, ESAPI.encoder().canonicalize(appFormBean.getExamname()));
						pstmt2.setString(4, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getExamdate())));
						pstmt2.setString(5, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getDebarenddate())));
						if ("Others".equalsIgnoreCase(appFormBean.getDebar_reason()))
							pstmt2.setString(6, ESAPI.encoder().canonicalize(appFormBean.getOther_reason()));
						else
							pstmt2.setString(6, ESAPI.encoder().canonicalize(appFormBean.getDebar_reason()));
						pstmt2.executeUpdate();
						if (pstmt2 != null)
							pstmt2.close();
					}

					boolean fir_cases = false;
					if (appFormBean.isFir_cases())
						fir_cases = true;
					if (appFormBean.isFir_cases_pending())
						fir_cases = true;
					if (appFormBean.isArrested())
						fir_cases = true;
					if (appFormBean.isCriminal_case_acquitted())
						fir_cases = true;
					if (appFormBean.isGood_behavior_bond())
						fir_cases = true;
					if (fir_cases) {
						String query_cat_insert = "INSERT INTO fir_details (transactionid, fir_no, fir_date, fir_section, fir_status,fir_district) VALUES (?, ?, ?, ?, ?,?);";
						PreparedStatement pstmt2 = con.prepareStatement(query_cat_insert);
						pstmt2.setInt(1, transaction_id);
						pstmt2.setString(2, ESAPI.encoder().canonicalize(appFormBean.getFirno()));
						pstmt2.setString(3, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getFirdate())));
						pstmt2.setString(4, ESAPI.encoder().canonicalize(appFormBean.getFirsection()));
						pstmt2.setString(5, ESAPI.encoder().canonicalize(appFormBean.getFirstatus()));
						pstmt2.setString(6, ESAPI.encoder().canonicalize(appFormBean.getFirdistrict()));
						pstmt2.executeUpdate();
						if (pstmt2 != null)
							pstmt2.close();
					}

					String query_user = "INSERT INTO userinfo ( username, password, transactionid) VALUES ( ?, ?, ?);";
					pstmt_user = con.prepareStatement(query_user);
					pstmt_user.setString(1, transaction_id + "");
					pstmt_user.setString(2, ESAPI.encoder().canonicalize(appFormBean.getPassword()));
					pstmt_user.setInt(3, transaction_id);
					pstmt_user.executeUpdate();
					if (pstmt_user != null)
						pstmt_user.close();

					String query_update = "update applicants set application_status=? where transactionid=?";
					pstmt_update = con.prepareStatement(query_update);
					pstmt_update.setString(1, "NEW");
					pstmt_update.setInt(2, transaction_id);
					pstmt_update.executeUpdate();
					if (pstmt_update != null)
						pstmt_update.close();
				} else {
					return -4;
				}
				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch"
			 * ,exceptionAsString, appFormBean.getMobileNumber(), ipaddress, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch",
			 * exceptionAsString, null, ipaddress, null);
			 */try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return -4;
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
				 * else
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, null, null, null);
				 */}
		}
		return transaction_id;
	}
	
	
	public int updateData(ApplicationFormBean appFormBean, String ipaddress, int post_id, int org_id, String browser) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null, pstmt_date = null, pstmt_user = null, pstmt_update = null;
		ResultSet rs = null, rs_date = null;
		int transaction_id = appFormBean.getTransactionidEdit();
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				String currentDate = getCurrentDate();
				appFormBean.setDate_created(currentDate);
				con.setAutoCommit(false);
				String query = "UPDATE  applicants set first_name = ?, middle_name = ?,  "
						+ "last_name = ?, father_name = ?, mobileNumber = ?, sex = ?, dob = ?, "
						+ "religion = ?, other_religion = ? , identification_mark = ? , community = ?, "
						+ "category = ? , affected_categories = ? , ex_serviceman = ? , ssb_emp_service = ? , "
						+ "govt_emp_service = ? , village = ? , tehsil = ? , postoffice = ? , "
						+ "policestation = ? , district = ? , state = ? , pincode = ? , correspondance_address = ? , "
						+ "village1 = ? , tehsil1 = ? , postoffice1 = ? , policestation1 = ? , "
						+ "district1 = ? , state1 = ? , pincode1 = ? , debarment = ? , fir_case = ? , "
						+ "fir_case_pending = ? , arrested = ? , criminal_case_acquitted = ? , good_behavior_bond = ? , "
						+ "date_created = ? , ipAddress = ? , post_id = ? , org_id = ? , "
						+ "payment_exempted = ? ,photo_file_name = ? ,signature_file_name = ? , "
						+ "emailaddress = ? , edu_qual = ? , post_applied = ? ,marrital_status = ? , "
						+ "nationality = ? , other_nationality = ? , aadhar_no = ? , category_belongs  = ? , "
						+ "jk_domiciled = ? , riots_affected = ? , riots_gujarat = ? , fee_amount = ? , mother_name = ? , "
						+ "application_status = ? , fullname = ? , identity_type = ? ,browser = ? , post_selected_name = ? , payment_required = ? ,edit_completed = ? ,mobile_number_backup = ? ,fee_amount_edit=?, "
						+ "total_fee_amount=?, email_address_backup=? , photo_file_name=?,signature_file_name=?, date_created=?  "
						+ " WHERE transactionid=? ";
				pstmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, ESAPI.encoder().canonicalize(appFormBean.getFirst_name()));
				pstmt.setString(2, ESAPI.encoder().canonicalize(appFormBean.getMiddle_name()));
				pstmt.setString(3, ESAPI.encoder().canonicalize(appFormBean.getLast_name()));
				pstmt.setString(4, ESAPI.encoder().canonicalize(appFormBean.getFather_name()));
				pstmt.setString(5, ESAPI.encoder().canonicalize(appFormBean.getMobileNumber()));
				pstmt.setString(6, ESAPI.encoder().canonicalize(appFormBean.getSex().substring(0, 1)));
				pstmt.setString(7, StringUtils.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getDob()))); // date
				pstmt.setString(8, ESAPI.encoder().canonicalize(appFormBean.getReligion()));
				pstmt.setString(9, ESAPI.encoder().canonicalize(appFormBean.getOther_religion()));
				pstmt.setString(10, ESAPI.encoder().canonicalize(appFormBean.getIdentification_mark()));
				pstmt.setString(11, ESAPI.encoder().canonicalize(appFormBean.getCommunity()));
				pstmt.setString(12, ESAPI.encoder().canonicalize(appFormBean.getCategory()));
				pstmt.setString(13, null); //
				pstmt.setBoolean(14, appFormBean.isEx_serviceman());
				pstmt.setBoolean(15, appFormBean.isEmployee_ssb());
				pstmt.setBoolean(16, appFormBean.isGovt_service());
				pstmt.setString(17, ESAPI.encoder().canonicalize(appFormBean.getVillage()));
				pstmt.setString(18, ESAPI.encoder().canonicalize(appFormBean.getTehsil()));
				pstmt.setString(19, ESAPI.encoder().canonicalize(appFormBean.getPostoffice()));
				pstmt.setString(20, ESAPI.encoder().canonicalize(appFormBean.getPolicestation()));
				pstmt.setString(21, ESAPI.encoder().canonicalize(appFormBean.getDistrict())); // district
				pstmt.setString(22, ESAPI.encoder().canonicalize(appFormBean.getState()));
				pstmt.setString(23, ESAPI.encoder().canonicalize(appFormBean.getPincode()));
				pstmt.setBoolean(24, appFormBean.isCorrespondence_address());
				pstmt.setString(25, ESAPI.encoder().canonicalize(appFormBean.getVillage1()));
				pstmt.setString(26, ESAPI.encoder().canonicalize(appFormBean.getTehsil1()));
				pstmt.setString(27, ESAPI.encoder().canonicalize(appFormBean.getPostoffice1()));
				pstmt.setString(28, ESAPI.encoder().canonicalize(appFormBean.getPolicestation1()));
				pstmt.setString(29, ESAPI.encoder().canonicalize(appFormBean.getDistrict1())); // district
				pstmt.setString(30, ESAPI.encoder().canonicalize(appFormBean.getState1()));
				pstmt.setString(31, ESAPI.encoder().canonicalize(appFormBean.getPincode1()));
				pstmt.setBoolean(32, appFormBean.isDebarment());
				pstmt.setBoolean(33, appFormBean.isFir_cases());
				pstmt.setBoolean(34, appFormBean.isFir_cases_pending());
				pstmt.setBoolean(35, appFormBean.isArrested());
				pstmt.setBoolean(36, appFormBean.isCriminal_case_acquitted());
				pstmt.setBoolean(37, appFormBean.isGood_behavior_bond());
				pstmt.setString(38, appFormBean.getDate_created()); // date_created
				pstmt.setString(39, ipaddress); // ipAddress
				pstmt.setInt(40, post_id); // post id
				pstmt.setInt(41, org_id); // org_id
				pstmt.setBoolean(42, appFormBean.isPayExempted());
				pstmt.setString(43, appFormBean.getPhotoFileName());
				pstmt.setString(44, appFormBean.getSigFileName());
				pstmt.setString(45, ESAPI.encoder().canonicalize(appFormBean.getEmailaddress()));
				pstmt.setString(46, ESAPI.encoder().canonicalize(appFormBean.getEdu_qual()));
				pstmt.setString(47, ESAPI.encoder().canonicalize(appFormBean.getPost_applied()));
				pstmt.setString(48, ESAPI.encoder().canonicalize(appFormBean.getMarrital_status()));
				pstmt.setString(49, ESAPI.encoder().canonicalize(appFormBean.getNationality()));
				pstmt.setString(50, ESAPI.encoder().canonicalize(appFormBean.getOther_nationality()));
				pstmt.setString(51, ESAPI.encoder().canonicalize(appFormBean.getAadharNo()));
				pstmt.setBoolean(52, appFormBean.isCategoty_belongs());
				pstmt.setBoolean(53, appFormBean.isJk_domiciled());
				pstmt.setBoolean(54, appFormBean.isRiots_affected());
				pstmt.setBoolean(55, appFormBean.isRiots_gujarat());
				pstmt.setInt(56, appFormBean.getFee_amount());
				pstmt.setString(57, ESAPI.encoder().canonicalize(appFormBean.getMother_name()));
				pstmt.setString(58, null);
				pstmt.setString(59, ESAPI.encoder().canonicalize(appFormBean.getFullname()));
				pstmt.setString(60, ESAPI.encoder().canonicalize(appFormBean.getIdentity_type()));
				pstmt.setString(61, browser);
				pstmt.setString(62, ESAPI.encoder().canonicalize(appFormBean.getPost_selected_name()));
				pstmt.setBoolean(63,true);
				pstmt.setBoolean(64, true);
				pstmt.setString(65, ESAPI.encoder().canonicalize(appFormBean.getMobileNumberBackup()));
				pstmt.setInt(66, appFormBean.getFee_amount_edit());
				pstmt.setInt(67, appFormBean.getTotalFeeAmount());
				pstmt.setString(68, ESAPI.encoder().canonicalize(appFormBean.getEmailaddressBackup()));
				pstmt.setString(69, ESAPI.encoder().canonicalize(appFormBean.getPhotoFileName()));
				pstmt.setString(70, ESAPI.encoder().canonicalize(appFormBean.getSigFileName()));
				pstmt.setString(71,appFormBean.getDate_created());
				pstmt.setInt(72, appFormBean.getTransactionidEdit());

				pstmt.executeUpdate();
//				rs = pstmt.getGeneratedKeys();
//				if (rs != null && rs.next()) {
//					transaction_id = rs.getInt(1);
//				}
				// System.out.println("transaction_id="+transaction_id);
				if (transaction_id > 0) {

					String query_date = "select DATE_FORMAT(`date_created`,'%d-%m-%Y %H:%i:%s') as date_created_format from applicants WHERE transactionid=?";
					pstmt_date = con.prepareStatement(query_date);
					pstmt_date.setInt(1, transaction_id);
					rs_date = pstmt_date.executeQuery();
					if (rs_date.next()) {
						appFormBean.setDate_created(rs_date.getString("date_created_format"));
					}

					String exam_passed_1 = appFormBean.getExam_passed_1();
					String stream_1 = appFormBean.getStream_1();
					String university_1 = appFormBean.getUniversity_1();
					String edu_rollno_1 = appFormBean.getEdu_rollno_1();
					String edu_certno_1 = appFormBean.getEdu_certno_1();
					String edu_date_issue_1 = appFormBean.getEdu_date_issue_1();
					String edu_year_1 = appFormBean.getEdu_year_1();

					String exam_passed_2 = appFormBean.getExam_passed_2();
					String stream_2 = appFormBean.getStream_2();
					String university_2 = appFormBean.getUniversity_2();
					String edu_rollno_2 = appFormBean.getEdu_rollno_2();
					String edu_certno_2 = appFormBean.getEdu_certno_2();
					String edu_date_issue_2 = appFormBean.getEdu_date_issue_2();
					String edu_year_2 = appFormBean.getEdu_year_2();

					String edu_marks_1 = appFormBean.getEdu_marks_1();
					String edu_marks_2 = appFormBean.getEdu_marks_2();

					/*
					 * String edu_marks_6=appFormBean.getEdu_marks_6();
					 * String edu_marks_7=appFormBean.getEdu_marks_7();
					 */

					String exam_passed_3 = appFormBean.getExam_passed_3();
					String stream_3 = appFormBean.getStream_3();
					String university_3 = appFormBean.getUniversity_3();
					String edu_rollno_3 = appFormBean.getEdu_rollno_3();
					String edu_certno_3 = appFormBean.getEdu_certno_3();
					String edu_date_issue_3 = appFormBean.getEdu_date_issue_3();
					String edu_year_3 = appFormBean.getEdu_year_3();
					String edu_marks_3 = appFormBean.getEdu_marks_3();

					String exam_passed_4 = appFormBean.getExam_passed_4();
					String stream_4 = appFormBean.getStream_4();
					String university_4 = appFormBean.getUniversity_4();
					String edu_rollno_4 = appFormBean.getEdu_rollno_4();
					String edu_certno_4 = appFormBean.getEdu_certno_4();
					String edu_date_issue_4 = appFormBean.getEdu_date_issue_4();
					String edu_year_4 = appFormBean.getEdu_year_4();
					String edu_marks_4 = appFormBean.getEdu_marks_4();

					String exam_passed_5 = appFormBean.getExam_passed_5();
					String stream_5 = appFormBean.getStream_5();
					String university_5 = appFormBean.getUniversity_5();
					String edu_rollno_5 = appFormBean.getEdu_rollno_5();
					String edu_certno_5 = appFormBean.getEdu_certno_5();
					String edu_date_issue_5 = appFormBean.getEdu_date_issue_5();
					String edu_year_5 = appFormBean.getEdu_year_5();
					String edu_marks_5 = appFormBean.getEdu_marks_5();

					String exam_passed_plus2 = appFormBean.getExam_passed_plus2();
					String stream_plus2 = appFormBean.getStream_plus2();
					String university_plus2 = appFormBean.getUniversity_plus2();
					String edu_rollno_plus2 = appFormBean.getEdu_rollno_plus2();
					String edu_certno_plus2 = appFormBean.getEdu_certno_plus2();
					String edu_date_issue_plus2 = appFormBean.getEdu_date_issue_plus2();
					String edu_year_plus2 = appFormBean.getEdu_year_plus2();
					String edu_marks_plus2 = appFormBean.getEdu_marks_plus2();

					boolean edu_qual_1 = true, edu_qual_2 = true, edu_qual_3 = true, edu_qual_4 = true,
							edu_qual_plus2 = true, edu_qual_5 = true, edu_qual_7 = true, edu_qual_8 = true;
					if ("".equalsIgnoreCase(exam_passed_1) || "".equalsIgnoreCase(stream_1)
							|| "".equalsIgnoreCase(university_1) || "".equalsIgnoreCase(edu_rollno_1)
							|| "".equalsIgnoreCase(edu_certno_1) || "".equalsIgnoreCase(edu_date_issue_1)
							|| "".equalsIgnoreCase(edu_marks_1) || "".equalsIgnoreCase(edu_year_1)) {
						edu_qual_1 = false;
					}
					if ("".equalsIgnoreCase(exam_passed_2) || "".equalsIgnoreCase(stream_2)
							|| "".equalsIgnoreCase(university_2) || "".equalsIgnoreCase(edu_rollno_2)
							|| "".equalsIgnoreCase(edu_certno_2) || "".equalsIgnoreCase(edu_date_issue_2)
							|| "".equalsIgnoreCase(edu_marks_2) || "".equalsIgnoreCase(edu_year_2)) {
						edu_qual_2 = false;
					}
					if (exam_passed_3 == null || stream_3 == null || university_3 == null || edu_rollno_3 == null
							|| edu_certno_3 == null || edu_date_issue_3 == null || edu_marks_3 == null
							|| edu_year_3 == null ||
							"".equalsIgnoreCase(exam_passed_3) || "".equalsIgnoreCase(stream_3)
							|| "".equalsIgnoreCase(university_3) || "".equalsIgnoreCase(edu_rollno_3)
							|| "".equalsIgnoreCase(edu_certno_3) || "".equalsIgnoreCase(edu_date_issue_3)
							|| "".equalsIgnoreCase(edu_marks_3) || "".equalsIgnoreCase(edu_year_3)
							|| "null".equalsIgnoreCase(exam_passed_3) || "null".equalsIgnoreCase(stream_3)
							|| "null".equalsIgnoreCase(university_3) || "null".equalsIgnoreCase(edu_rollno_3)
							|| "null".equalsIgnoreCase(edu_certno_3) || "null".equalsIgnoreCase(edu_date_issue_3)
							|| "null".equalsIgnoreCase(edu_marks_3) || "null".equalsIgnoreCase(edu_year_3)) {
						edu_qual_3 = false;
					}

					if (exam_passed_4 == null || stream_4 == null || university_4 == null || edu_rollno_4 == null
							|| edu_certno_4 == null || edu_date_issue_4 == null || edu_marks_4 == null
							|| edu_year_4 == null ||
							"".equalsIgnoreCase(exam_passed_4) || "".equalsIgnoreCase(stream_4)
							|| "".equalsIgnoreCase(university_4) || "".equalsIgnoreCase(edu_rollno_4)
							|| "".equalsIgnoreCase(edu_certno_4) || "".equalsIgnoreCase(edu_date_issue_4)
							|| "".equalsIgnoreCase(edu_marks_4) || "".equalsIgnoreCase(edu_year_4)
							|| "null".equalsIgnoreCase(exam_passed_4) || "null".equalsIgnoreCase(stream_4)
							|| "null".equalsIgnoreCase(university_4) || "null".equalsIgnoreCase(edu_rollno_4)
							|| "null".equalsIgnoreCase(edu_certno_4) || "null".equalsIgnoreCase(edu_date_issue_4)
							|| "null".equalsIgnoreCase(edu_marks_4) || "null".equalsIgnoreCase(edu_year_4)) {
						edu_qual_4 = false;
					}

					if (exam_passed_plus2 == null || stream_plus2 == null || university_plus2 == null
							|| edu_rollno_plus2 == null || edu_certno_plus2 == null || edu_date_issue_plus2 == null
							|| edu_marks_plus2 == null || edu_year_plus2 == null ||
							"".equalsIgnoreCase(exam_passed_plus2) || "".equalsIgnoreCase(stream_plus2)
							|| "".equalsIgnoreCase(university_plus2) || "".equalsIgnoreCase(edu_rollno_plus2)
							|| "".equalsIgnoreCase(edu_certno_plus2) || "".equalsIgnoreCase(edu_date_issue_plus2)
							|| "".equalsIgnoreCase(edu_marks_plus2) || "".equalsIgnoreCase(edu_year_plus2)
							|| "null".equalsIgnoreCase(exam_passed_plus2) || "null".equalsIgnoreCase(stream_plus2)
							|| "null".equalsIgnoreCase(university_plus2) || "null".equalsIgnoreCase(edu_rollno_plus2)
							|| "null".equalsIgnoreCase(edu_certno_plus2)
							|| "null".equalsIgnoreCase(edu_date_issue_plus2) || "null".equalsIgnoreCase(edu_marks_plus2)
							|| "null".equalsIgnoreCase(edu_year_plus2)) {
						edu_qual_plus2 = false;
					}

					if (exam_passed_5 == null || stream_5 == null || university_5 == null || edu_rollno_5 == null
							|| edu_certno_5 == null || edu_date_issue_5 == null || edu_marks_5 == null
							|| edu_year_5 == null ||
							"".equalsIgnoreCase(exam_passed_5) || "".equalsIgnoreCase(stream_5)
							|| "".equalsIgnoreCase(university_5) || "".equalsIgnoreCase(edu_rollno_5)
							|| "".equalsIgnoreCase(edu_certno_5) || "".equalsIgnoreCase(edu_date_issue_5)
							|| "".equalsIgnoreCase(edu_marks_5) || "".equalsIgnoreCase(edu_year_5)
							|| "null".equalsIgnoreCase(exam_passed_5) || "null".equalsIgnoreCase(stream_5)
							|| "null".equalsIgnoreCase(university_5) || "null".equalsIgnoreCase(edu_rollno_5)
							|| "null".equalsIgnoreCase(edu_certno_5) || "null".equalsIgnoreCase(edu_date_issue_5)
							|| "null".equalsIgnoreCase(edu_marks_5) || "null".equalsIgnoreCase(edu_year_5)) {
						edu_qual_5 = false;
					}
					
					String query_delete = "delete from education_details where transactionid=?";
					PreparedStatement pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					String query_edu_qualifications = "INSERT INTO education_details (transactionid,  exam_passed, university, cert_no, date_issue, rollno, subject,percentage,ed_qual,year)  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
					PreparedStatement pstmt4 = con.prepareStatement(query_edu_qualifications);
					if (edu_qual_1) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_1()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_1()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_1()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_1()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_1()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_1()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_1()));
						pstmt4.setInt(9, 1);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_1()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_2) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_2()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_2()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_2()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_2()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_2()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_2()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_2()));
						pstmt4.setInt(9, 2);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_2()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_plus2) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_plus2()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_plus2()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_plus2()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_plus2()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_plus2()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_plus2()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_plus2()));
						pstmt4.setInt(9, 3);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_plus2()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_3) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_3()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_3()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_3()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_3()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_3()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_3()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_3()));
						pstmt4.setInt(9, 4);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_3()));
						pstmt4.executeUpdate();
					}
					if (edu_qual_4) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_4()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_4()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_4()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_4()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_4()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_4()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_4()));
						pstmt4.setInt(9, 5);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_4()));
						pstmt4.executeUpdate();
					}

					if (edu_qual_5) {
						pstmt4.setInt(1, transaction_id);
						pstmt4.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExam_passed_5()));
						pstmt4.setString(3, ESAPI.encoder().canonicalize(appFormBean.getUniversity_5()));
						pstmt4.setString(4, ESAPI.encoder().canonicalize(appFormBean.getEdu_certno_5()));
						pstmt4.setString(5, ESAPI.encoder().canonicalize(appFormBean.getEdu_date_issue_5()));
						pstmt4.setString(6, ESAPI.encoder().canonicalize(appFormBean.getEdu_rollno_5()));
						pstmt4.setString(7, ESAPI.encoder().canonicalize(appFormBean.getStream_5()));
						pstmt4.setString(8, ESAPI.encoder().canonicalize(appFormBean.getEdu_marks_5()));
						pstmt4.setInt(9, 6);
						pstmt4.setString(10, ESAPI.encoder().canonicalize(appFormBean.getEdu_year_5()));
						pstmt4.executeUpdate();
					}

					if (pstmt4 != null)
						pstmt4.close();

					query_delete = "delete from essential_qualification where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					String query_essential = "INSERT INTO essential_qualification (transactionid,  qualification,answer,sno)  VALUES ( ?, ?,?,?);";
					PreparedStatement pstmt8 = con.prepareStatement(query_essential);
					if (appFormBean.getQualification1_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification1_text()));
						pstmt8.setString(3, appFormBean.getQualification1());
						pstmt8.setInt(4, 1);
						pstmt8.execute();
					}
					if (appFormBean.getQualification2_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification2_text()));
						pstmt8.setString(3, appFormBean.getQualification2());
						pstmt8.setInt(4, 2);
						pstmt8.execute();
					}
					if (appFormBean.getQualification3_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification3_text()));
						pstmt8.setString(3, appFormBean.getQualification3());
						pstmt8.setInt(4, 3);
						pstmt8.execute();
					}
					if (appFormBean.getQualification4_text() != null) {
						pstmt8.setInt(1, transaction_id);
						pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification4_text()));
						pstmt8.setString(3, appFormBean.getQualification4());
						pstmt8.setInt(4, 4);
						pstmt8.execute();
					}
					if (pstmt8 != null)
						pstmt8.close(); 

					
					query_delete = "delete from personal_qualification where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					String query_personal = "INSERT INTO personal_qualification (transactionid,hc_lab_assistant_cert,hc_lab_assistant_experience,hc_physio_cert,hc_phsio_assistant_experience,ct_nursing_first_aid_cert,ct_nursing_assistant_experience ) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pstmtPersonal = con.prepareStatement(query_personal);
					pstmtPersonal.setInt(1, transaction_id);
					// hc-lab
					if (appFormBean.getHcLabAsstCertValue() == "") {
						pstmtPersonal.setNull(2, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(2, appFormBean.isHcLabAsstCert());
					}

					if (appFormBean.getHcLabAsstExpValue() == "") {
						pstmtPersonal.setNull(3, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(3, appFormBean.isHcLabAsstExp());
					}

					// hc-physio
					if (appFormBean.getHcPhysioAsstCertValue() == "") {
						pstmtPersonal.setNull(4, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(4, appFormBean.isHcPhysioAsstCert());
					}

					if (appFormBean.getHcPhysioAsstExpValue() == "") {
						pstmtPersonal.setNull(5, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(5, appFormBean.isHcPhysioAsstExp());
					}

					// ct-nursing
					if (appFormBean.getCtNursingCertValue() == "") {
						pstmtPersonal.setNull(6, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(6, appFormBean.isCtNursingCert());
					}

					if (appFormBean.getCtNursingExpValue() == "") {
						pstmtPersonal.setNull(7, java.sql.Types.TINYINT);
					} else {
						pstmtPersonal.setBoolean(7, appFormBean.isCtNursingExp());
					}

					// if(appFormBean.getHospital()==""){
					// pstmtPersonal.setNull(3, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(3, appFormBean.isHospital_experience());
					// }

					// if(appFormBean.getTrade()==""){
					// pstmtPersonal.setNull(4, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(4, appFormBean.isTradesmen_certificate());
					// }

					// if(appFormBean.getAutocad()==""){
					// pstmtPersonal.setNull(5, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(5, appFormBean.isAutocad_certificate());
					// }

					// if(appFormBean.getDraft()==""){
					// pstmtPersonal.setNull(6, java.sql.Types.TINYINT);
					// }else {
					// pstmtPersonal.setBoolean(6, appFormBean.isDraughtsmanship_exp());
					// }

					pstmtPersonal.execute();
					if (pstmtPersonal != null)
						pstmtPersonal.close();

					if (appFormBean.isSkills_flag()) {
						String query_skills = "INSERT INTO other_skills (transactionid,  skill,skill_no)  VALUES ( ?, ?,?);";
						PreparedStatement pstmt7 = con.prepareStatement(query_skills);
						if (appFormBean.getSkill_1() != null && !"".equalsIgnoreCase(appFormBean.getSkill_1())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_1()));
							pstmt7.setInt(3, 1);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_2() != null && !"".equalsIgnoreCase(appFormBean.getSkill_2())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_2()));
							pstmt7.setInt(3, 2);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_3() != null && !"".equalsIgnoreCase(appFormBean.getSkill_3())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_3()));
							pstmt7.setInt(3, 3);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_4() != null && !"".equalsIgnoreCase(appFormBean.getSkill_4())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_4()));
							pstmt7.setInt(3, 4);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_5() != null && !"".equalsIgnoreCase(appFormBean.getSkill_5())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_5()));
							pstmt7.setInt(3, 5);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_6() != null && !"".equalsIgnoreCase(appFormBean.getSkill_6())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_6()));
							pstmt7.setInt(3, 6);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_7() != null && !"".equalsIgnoreCase(appFormBean.getSkill_7())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_7()));
							pstmt7.setInt(3, 7);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_8() != null && !"".equalsIgnoreCase(appFormBean.getSkill_8())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_8()));
							pstmt7.setInt(3, 8);
							pstmt7.executeUpdate();
						}
						if (appFormBean.getSkill_9() != null && !"".equalsIgnoreCase(appFormBean.getSkill_9())) {
							pstmt7.setInt(1, transaction_id);
							pstmt7.setString(2, ESAPI.encoder().canonicalize(appFormBean.getSkill_9()));
							pstmt7.setInt(3, 9);
							pstmt7.executeUpdate();
						}

						if (pstmt7 != null)
							pstmt7.close();
					}
					
					query_delete = "delete from certificate_details where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					
					if (appFormBean.isCategoty_belongs()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "Community");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getCat_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getCat_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getCat_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isJk_domiciled()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "JK Domicile");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getJk_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getJk_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getJk_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isRiots_affected()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "Riots 1984");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getRiots_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getRiots_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getRiots_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					if (appFormBean.isRiots_gujarat()) {
						String certificate_query = "INSERT INTO certificate_details (transactionid, certificate, cert_no, date_issue, issueing_authority) VALUES ( ?, ?, ?, ?, ?);";
						PreparedStatement pstmt6 = con.prepareStatement(certificate_query);
						pstmt6.setInt(1, transaction_id);
						pstmt6.setString(2, "Riots 2002 Gujarat");
						pstmt6.setString(3, ESAPI.encoder().canonicalize(appFormBean.getRiots_guj_cert_no()));
						pstmt6.setString(4, ESAPI.encoder().canonicalize(appFormBean.getRiots_guj_date_Issue()));
						pstmt6.setString(5, ESAPI.encoder().canonicalize(appFormBean.getRiots_guj_issue_authority()));
						pstmt6.executeUpdate();
						if (pstmt6 != null)
							pstmt6.close();
					}

					
					query_delete = "delete from exman_details where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					
					if (appFormBean.isEx_serviceman()) {
						String query_exman = "INSERT INTO exman_details (transactionid, medical_category, date_enrollment, date_retirement, award_decoration, discharge_reason, edu_qual) VALUES (?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt3 = con.prepareStatement(query_exman);
						pstmt3.setInt(1, transaction_id);
						pstmt3.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExman_med_cat()));
						pstmt3.setString(3, StringUtils.changeDateFormatYMD(
								ESAPI.encoder().canonicalize(appFormBean.getExman_enrollment_date())));
						pstmt3.setString(4, StringUtils.changeDateFormatYMD(
								ESAPI.encoder().canonicalize(appFormBean.getExman_retirement_date())));
						pstmt3.setString(5, ESAPI.encoder().canonicalize(appFormBean.getExman_awd_dec()));
						pstmt3.setString(6, ESAPI.encoder().canonicalize(appFormBean.getExman_discharge_reason()));
						pstmt3.setString(7, ESAPI.encoder().canonicalize(appFormBean.getExman_edu_qual()));
						pstmt3.executeUpdate();
						if (pstmt3 != null)
							pstmt3.close();
					}

					
					
					query_delete = "delete from service_details where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					if (appFormBean.isGovt_service() || appFormBean.isEmployee_ssb()) {
						String query_service_insert = "INSERT INTO service_details (transactionid, emp_name, emp_date, post_held, noc_designation,emp_name2, emp_date2, post_held2, noc_designation2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt5 = con.prepareStatement(query_service_insert);
						pstmt5.setInt(1, transaction_id);
						pstmt5.setString(2, ESAPI.encoder().canonicalize(appFormBean.getPresent_employer()));
						pstmt5.setString(3, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getEmp_date_since())));
						pstmt5.setString(4, ESAPI.encoder().canonicalize(appFormBean.getPost_held()));
						pstmt5.setString(5, ESAPI.encoder().canonicalize(appFormBean.getNocdesignation()));

						pstmt5.setString(6, ESAPI.encoder().canonicalize(appFormBean.getPresent_employer2()));
						pstmt5.setString(7, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getEmp_date_since2())));
						pstmt5.setString(8, ESAPI.encoder().canonicalize(appFormBean.getPost_held2()));
						pstmt5.setString(9, ESAPI.encoder().canonicalize(appFormBean.getNocdesignation2()));
						pstmt5.executeUpdate();
						if (pstmt5 != null)
							pstmt5.close();
					}

					query_delete = "delete from debarment_details where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					if (appFormBean.isDebarment()) {
						String query_cat_insert = "INSERT INTO debarment_details (transactionid, exam_organizer, exam_name, exam_date, debarment_date,reason) VALUES (?, ?, ?, ?, ?,?);";
						PreparedStatement pstmt2 = con.prepareStatement(query_cat_insert);
						pstmt2.setInt(1, transaction_id);
						pstmt2.setString(2, ESAPI.encoder().canonicalize(appFormBean.getExamorganizer()));
						pstmt2.setString(3, ESAPI.encoder().canonicalize(appFormBean.getExamname()));
						pstmt2.setString(4, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getExamdate())));
						pstmt2.setString(5, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getDebarenddate())));
						if ("Others".equalsIgnoreCase(appFormBean.getDebar_reason()))
							pstmt2.setString(6, ESAPI.encoder().canonicalize(appFormBean.getOther_reason()));
						else
							pstmt2.setString(6, ESAPI.encoder().canonicalize(appFormBean.getDebar_reason()));
						pstmt2.executeUpdate();
						if (pstmt2 != null)
							pstmt2.close();
					}

					query_delete = "delete from fir_details where transactionid=?";
					pstmt_delete = con.prepareStatement(query_delete);
					pstmt_delete.setInt(1, transaction_id);
					pstmt_delete.execute();
					
					
					boolean fir_cases = false;
					if (appFormBean.isFir_cases())
						fir_cases = true;
					if (appFormBean.isFir_cases_pending())
						fir_cases = true;
					if (appFormBean.isArrested())
						fir_cases = true;
					if (appFormBean.isCriminal_case_acquitted())
						fir_cases = true;
					if (appFormBean.isGood_behavior_bond())
						fir_cases = true;
					if (fir_cases) {
						String query_cat_insert = "INSERT INTO fir_details (transactionid, fir_no, fir_date, fir_section, fir_status,fir_district) VALUES (?, ?, ?, ?, ?,?);";
						PreparedStatement pstmt2 = con.prepareStatement(query_cat_insert);
						pstmt2.setInt(1, transaction_id);
						pstmt2.setString(2, ESAPI.encoder().canonicalize(appFormBean.getFirno()));
						pstmt2.setString(3, StringUtils
								.changeDateFormatYMD(ESAPI.encoder().canonicalize(appFormBean.getFirdate())));
						pstmt2.setString(4, ESAPI.encoder().canonicalize(appFormBean.getFirsection()));
						pstmt2.setString(5, ESAPI.encoder().canonicalize(appFormBean.getFirstatus()));
						pstmt2.setString(6, ESAPI.encoder().canonicalize(appFormBean.getFirdistrict()));
						pstmt2.executeUpdate();
						if (pstmt2 != null)
							pstmt2.close();
					}

//					String query_user = "INSERT INTO userinfo ( username, password, transactionid) VALUES ( ?, ?, ?);";
//					pstmt_user = con.prepareStatement(query_user);
//					pstmt_user.setString(1, transaction_id + "");
//					pstmt_user.setString(2, ESAPI.encoder().canonicalize(appFormBean.getPassword()));
//					pstmt_user.setInt(3, transaction_id);
//					pstmt_user.executeUpdate();
//					if (pstmt_user != null)
//						pstmt_user.close();

					String query_update = "update applicants set application_status=? where transactionid=?";
					pstmt_update = con.prepareStatement(query_update);
					pstmt_update.setString(1, "FINISHED");
					pstmt_update.setInt(2, transaction_id);
					pstmt_update.executeUpdate();
					if (pstmt_update != null)
						pstmt_update.close();
				} else {
					return -4;
				}
				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch"
			 * ,exceptionAsString, appFormBean.getMobileNumber(), ipaddress, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch",
			 * exceptionAsString, null, ipaddress, null);
			 */try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return -4;
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
				 * else
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, null, null, null);
				 */}
		}
		return transaction_id;
	}
	
	

	/**
	 * This will update Photo & signature path into database and update the status
	 * as Finished
	 * 
	 * @param appFormBean
	 * @param ipaddress
	 * @return
	 */
	public String updatePhotoPath(ApplicationFormBean appFormBean, String ipaddress) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		ResultSet rs = null;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				con.setAutoCommit(false);
				String query = "update applicants  set photo_file_name=?,signature_file_name=?,matric_file_name=?,prof_qual_file_name=?,identity_file_name=?,cat_file_name=?,com_file_name=?,application_status='FINISHED' , edit_enabled=?  where transactionid=?  ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, appFormBean.getPhotoFileName());
				pstmt.setString(2, appFormBean.getSigFileName());
				pstmt.setString(3, appFormBean.getMatricFileName());
				pstmt.setString(4, appFormBean.getProfQualFileName());
				pstmt.setString(5, appFormBean.getIdentityFileName());
				pstmt.setString(6, appFormBean.getCatFileName());
				pstmt.setString(7, appFormBean.getComFileName());
				pstmt.setBoolean(8, appFormBean.isEditEnabled());
				pstmt.setInt(9, appFormBean.getTransactionid());
				pstmt.executeUpdate();

				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return "It seems Database Server is busy , please try again.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch"
			 * ,exceptionAsString, appFormBean.getMobileNumber(), ipaddress, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch",
			 * exceptionAsString, null, ipaddress, null);
			 */try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return exceptionAsString;
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
				 * else
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, null, null, null);
				 */}
		}
		return "Success";
	}

	/**
	 * This will create Order Id for Payments. New Record will insert into payment
	 * orders
	 * 
	 * @param appDataBean
	 * @param pgtype
	 * @param ipaddress
	 * @return
	 */
	public int createPaymentOrder(AppDataBean appDataBean, String pgtype, String ipaddress) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int order_id = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				String currentDate = getCurrentDate();
				// appFormBean.setDate_created(currentDate);
				con.setAutoCommit(false);
				String query = "INSERT INTO payment_orders(transactionid,pgtype,date_created,ipaddress,order_status) values(?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, appDataBean.getTransactionid());
				pstmt.setString(2, pgtype);
				pstmt.setString(3, getCurrentDate());
				pstmt.setString(4, ipaddress);
				pstmt.setString(5, "NEW");
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				if (rs != null && rs.next()) {
					order_id = rs.getInt(1);
				}
				// System.out.println("query="+pstmt.toString());

				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch",exceptionAsString,
			 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
			 * null);
			 * else
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch", exceptionAsString,
			 * null,0, ipaddress, null);
			 */
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return -5;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally",exceptionAsString,
				 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
				 * null);
				 * else
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally", exceptionAsString,
				 * null,0, ipaddress, null);
				 */
			}
		}
		return order_id;

	}

	/**
	 * This method will save the HDFC payment response into payments table and
	 * update the status into applicants table
	 * 
	 * @param paymentBean
	 * @param appFormBean
	 * @param ipaddress
	 * @return
	 */
	public int savePaymentsData(HDFCPaymentBean paymentBean, ApplicationFormBean appFormBean, String ipaddress) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		int transaction_id = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				String currentDate = getCurrentDate();
				// appFormBean.setDate_created(currentDate);
				con.setAutoCommit(false);
				String query = "INSERT INTO hdfc_payments(transactionid,order_id,tracking_id,bank_ref_no,order_status,failure_message,payment_mode,card_name,status_code,status_message,currency,amount,merchant_param1,vault,trans_date,bin_country,mer_amount,bank_response,paid_on,ipaddress,responseType) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				String query1 = "update applicants  set payment_status=? where transactionid=?  ";
				pstmt = con.prepareStatement(query);
				pstmt1 = con.prepareStatement(query1);
				pstmt.setString(1, paymentBean.getMerchant_param1());
				pstmt.setString(2, paymentBean.getOrder_id());
				pstmt.setString(3, paymentBean.getTracking_id());
				pstmt.setString(4, paymentBean.getBank_ref_no());
				pstmt.setString(5, paymentBean.getOrder_status());
				pstmt.setString(6, paymentBean.getFailure_message());
				pstmt.setString(7, paymentBean.getPayment_mode());
				pstmt.setString(8, paymentBean.getCard_name());
				pstmt.setString(9, paymentBean.getStatus_code());
				pstmt.setString(10, paymentBean.getStatus_message());
				pstmt.setString(11, paymentBean.getCurrency());
				pstmt.setString(12, paymentBean.getAmount());
				pstmt.setString(13, paymentBean.getMerchant_param1());
				pstmt.setString(14, paymentBean.getVault());
				pstmt.setString(15, paymentBean.getTrans_date());
				pstmt.setString(16, paymentBean.getBin_country());
				pstmt.setString(17, paymentBean.getMer_amount());
				pstmt.setString(18, paymentBean.getBank_response());
				pstmt.setString(19, getCurrentDate());
				pstmt.setString(20, ipaddress);
				pstmt.setString(21, paymentBean.getResponseType());
				pstmt.executeUpdate();

				pstmt1.setString(1, paymentBean.getOrder_status());
				pstmt1.setString(2, paymentBean.getMerchant_param1());
				pstmt1.executeUpdate();
				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch",exceptionAsString,
			 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
			 * null);
			 * else
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch", exceptionAsString,
			 * null,0, ipaddress, null);
			 */
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return -5;
		} finally {
			try {
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally",exceptionAsString,
				 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
				 * null);
				 * else
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally", exceptionAsString,
				 * null,0, ipaddress, null);
				 */
			}
		}
		return transaction_id;

	}

	/**
	 * This method will save the SBI payment response into payments table and update
	 * the status into applicants table
	 * 
	 * @param paymentBean
	 * @param appFormBean
	 * @param ipaddress
	 * @return
	 */
	public int saveSBIPaymentsData(PaymentBean paymentBean, ApplicationFormBean appFormBean, String ipaddress) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		int transaction_id = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null && appFormBean != null) {
				String currentDate = getCurrentDate();
				appFormBean.setDate_created(currentDate);
				con.setAutoCommit(false);
				String query = "INSERT INTO payments (transactionid, SBIePay_Reference_ID, status, amount, currency, paymode, reason, bankCode, bankReferenceNumber, TransactionDate, bank_cin, bank_response, paid_on, payment_amount, order_id,ipaddress,responseType,country,merchant_id,transaction_gst_fee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
				String query1 = "update applicants  set payment_status=? ,payment_status_edit=? , edit_enabled=? where transactionid=?  ";
				pstmt = con.prepareStatement(query);
				pstmt1 = con.prepareStatement(query1);
				pstmt.setInt(1, paymentBean.getRes_transactionid());
				pstmt.setString(2, paymentBean.getRes_bank_ref_id());
				pstmt.setString(3, paymentBean.getRes_status());
				pstmt.setString(4, paymentBean.getRes_amount());
				pstmt.setString(5, paymentBean.getCurrency());
				pstmt.setString(6, paymentBean.getRes_paymode());
				pstmt.setString(7, paymentBean.getRes_reason());
				pstmt.setString(8, paymentBean.getRes_bankCode());
				pstmt.setString(9, paymentBean.getRes_bank_ref_no());
				pstmt.setString(10, paymentBean.getRes_trans_date_time());
				pstmt.setString(11, paymentBean.getRes_cin());
				pstmt.setString(12, paymentBean.getBank_response());
				pstmt.setString(13, getCurrentDate());
				pstmt.setInt(14, appFormBean.getFee_amount());
				pstmt.setInt(15, paymentBean.getRes_orderid());
				pstmt.setString(16, ipaddress);
				pstmt.setString(17, paymentBean.getResponseType());
				pstmt.setString(18, paymentBean.getCountry());
				pstmt.setString(19, paymentBean.getMerchantId());
				pstmt.setString(20, paymentBean.getTrans_fee());
				pstmt.executeUpdate();

				pstmt1.setString(1, appFormBean.getPayment_status());
				pstmt1.setString(2, appFormBean.getPaymentStatusEdit());
				pstmt1.setBoolean(3, appFormBean.isEditEnabled());
				pstmt1.setInt(4, paymentBean.getRes_transactionid());
				pstmt1.executeUpdate();
				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch",exceptionAsString,
			 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
			 * null);
			 * else
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch", exceptionAsString,
			 * null,0, ipaddress, null);
			 */
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return -5;
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally",exceptionAsString,
				 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
				 * null);
				 * else
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally", exceptionAsString,
				 * null,0, ipaddress, null);
				 */
			}
		}
		return transaction_id;

	}

	public int saveSBIPaymentsData1(PaymentBean paymentBean, ApplicationFormBean appFormBean1, String ipaddress) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		int transaction_id = 0;
		try {
			con = DbConnection.setupCommRectDataSource();
			if (con != null) {
				con.setAutoCommit(false);
				String query = "INSERT INTO payments (transactionid, SBIePay_Reference_ID, status, amount, currency, paymode, reason, bankCode, bankReferenceNumber, TransactionDate, bank_cin, bank_response, paid_on, payment_amount, order_id,ipaddress,responseType,country,merchant_id,transaction_gst_fee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
				String query1 = "update applicants  set payment_status=? where transactionid=?  ";
				pstmt = con.prepareStatement(query);
				pstmt1 = con.prepareStatement(query1);
				pstmt.setInt(1, paymentBean.getRes_transactionid());
				pstmt.setString(2, paymentBean.getRes_bank_ref_id());
				pstmt.setString(3, paymentBean.getRes_status());
				pstmt.setString(4, paymentBean.getRes_amount());
				pstmt.setString(5, paymentBean.getCurrency());
				pstmt.setString(6, paymentBean.getRes_paymode());
				pstmt.setString(7, paymentBean.getRes_reason());
				pstmt.setString(8, paymentBean.getRes_bankCode());
				pstmt.setString(9, paymentBean.getRes_bank_ref_no());
				pstmt.setString(10, paymentBean.getRes_trans_date_time());
				pstmt.setString(11, paymentBean.getRes_cin());
				pstmt.setString(12, paymentBean.getBank_response());
				pstmt.setString(13, getCurrentDate());
				pstmt.setInt(14, 400);
				pstmt.setInt(15, paymentBean.getRes_orderid());
				pstmt.setString(16, ipaddress);
				pstmt.setString(17, paymentBean.getResponseType());
				pstmt.setString(18, paymentBean.getCountry());
				pstmt.setString(19, paymentBean.getMerchantId());
				pstmt.setString(20, paymentBean.getTrans_fee());
				pstmt.executeUpdate();

				pstmt1.setString(1, paymentBean.getRes_status());
				pstmt1.setInt(2, paymentBean.getRes_transactionid());
				pstmt1.executeUpdate();
				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return -4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch",exceptionAsString,
			 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
			 * null);
			 * else
			 * LogsGeneration.generateErrorLogs("PaymentSave Catch", exceptionAsString,
			 * null,0, ipaddress, null);
			 */
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return -5;
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally",exceptionAsString,
				 * appFormBean.getMobileNumber(),appFormBean.getTransactionid(), ipaddress,
				 * null);
				 * else
				 * LogsGeneration.generateErrorLogs("PaymentSave Finally", exceptionAsString,
				 * null,0, ipaddress, null);
				 */
			}
		}
		return transaction_id;

	}

	public String changePost(ApplicationFormBean appFormBean, String ipaddress) {
		Connection con = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		ResultSet rs = null;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				String currentDate = getCurrentDate();
				con.setAutoCommit(false);

				String query1 = "insert into post_changes(post_applied,post_selected_name,old_post_applied,old_post_selected_name,postchangedTime,ipaddress,transactionid) values(?,?,?,?,?,?,?) ";
				pstmt = con.prepareStatement(query1);
				pstmt.setInt(1, 9);
				pstmt.setString(2, "Constable (Veterinary)");
				pstmt.setString(3, appFormBean.getPost_applied());
				pstmt.setString(4, appFormBean.getPost_selected_name());
				pstmt.setString(5, currentDate);
				pstmt.setString(6, ipaddress);
				pstmt.setInt(7, appFormBean.getTransactionid());
				pstmt.execute();

				String query_essential = "INSERT INTO essential_qualification (transactionid,  qualification,answer,sno)  VALUES ( ?, ?,?,?);";
				PreparedStatement pstmt8 = con.prepareStatement(query_essential);
				if (appFormBean.getQualification1_text() != null) {
					pstmt8.setInt(1, appFormBean.getTransactionid());
					pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification1_text()));
					pstmt8.setString(3, appFormBean.getQualification1());
					pstmt8.setInt(4, 1);
					pstmt8.execute();
				}
				if (appFormBean.getQualification2_text() != null) {
					pstmt8.setInt(1, appFormBean.getTransactionid());
					pstmt8.setString(2, ESAPI.encoder().canonicalize(appFormBean.getQualification2_text()));
					pstmt8.setString(3, appFormBean.getQualification2());
					pstmt8.setInt(4, 2);
					pstmt8.execute();
				}
				if (pstmt8 != null)
					pstmt8.close();

				String query = "update applicants  set  post_applied=?,post_selected_name=?  where transactionid=?  ";
				pstmt1 = con.prepareStatement(query);
				pstmt1.setInt(1, 9);
				pstmt1.setString(2, "Constable (Veterinary)");
				pstmt1.setInt(3, appFormBean.getTransactionid());
				pstmt1.executeUpdate();

				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return "It seems Database Server is busy , please try again.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch"
			 * ,exceptionAsString, appFormBean.getMobileNumber(), ipaddress, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch",
			 * exceptionAsString, null, ipaddress, null);
			 */try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return exceptionAsString;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
				 * else
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, null, null, null);
				 */}
		}
		return "Success";
	}

	public String otplogs(ApplicationFormBean appFormBean, String ipaddress, String smsText, int otp) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				String currentDate = getCurrentDate();
				con.setAutoCommit(false);

				String query1 = "insert into otplogs(transactionid,mobilenumber,message,otp,sent_time,type) values(?,?,?,?,?,?) ";
				pstmt = con.prepareStatement(query1);
				pstmt.setInt(1, appFormBean.getTransactionid());
				pstmt.setString(2, appFormBean.getMobileNumber());
				pstmt.setString(3, smsText);
				pstmt.setInt(4, otp);
				pstmt.setString(5, currentDate);
				pstmt.setString(6, "SMS OTP");
				pstmt.execute();

				con.commit();
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO", "Connection
				// is null in DAO", null, null, null);
				return "It seems Database Server is busy , please try again.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(appFormBean!=null)
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch"
			 * ,exceptionAsString, appFormBean.getMobileNumber(), ipaddress, null);
			 * else
			 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO Catch",
			 * exceptionAsString, null, ipaddress, null);
			 */try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
				// Rollback",exceptionAsString, null, ipaddress, null);
			}
			return exceptionAsString;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				/*
				 * if(appFormBean!=null)
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, appFormBean.getMobileNumber(), null, null);
				 * else
				 * //LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO in Finally",
				 * exceptionAsString, null, null, null);
				 */}
		}
		return "Success";
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat curFormater;
		String currDate = "";
		try {
			curFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			currDate = curFormater.format(date);
		} catch (Exception e) {
			// LogsGeneration.generateErrorLogsWithMobileNumber("DataSaveDAO
			// getCurrentDate", e.getMessage(), null, null, null);
		}
		return currDate;
	}
	
	public String verifyMobile(ApplicationFormBean applicationFormBean, String remoteAddr, int otp, String string) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				con.setAutoCommit(false);
				String query = "update applicants  set  otp_verified=?  where transactionid=?  ";
				pstmt1 = con.prepareStatement(query);
				pstmt1.setBoolean(1, true);
				pstmt1.setInt(2, applicationFormBean.getTransactionid());
				pstmt1.executeUpdate();

				con.commit();
			} else {
				return "It seems Database Server is busy , please try again 123.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace(new PrintWriter(sw));
				exceptionAsString = sw.toString();
			}
			return exceptionAsString;
		} finally {
			try {
				if (pstmt1 != null)
					pstmt1.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
			}
		}
		return "Success";
	}
}
