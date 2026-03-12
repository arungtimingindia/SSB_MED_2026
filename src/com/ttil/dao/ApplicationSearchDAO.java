package com.ttil.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.ApplicationSearchBean;
import com.ttil.util.DbConnection;
import com.ttil.util.StringUtils;

public class ApplicationSearchDAO {

	/**
	 * This will fetch basic details for Forgot Password Users with Registration Id
	 * & DOB
	 * 
	 * @param applicationSearchBean
	 * @return
	 */
	public ApplicationFormBean getPasswordDeatils(ApplicationSearchBean applicationSearchBean) {
		Connection con = null;
		String query = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ApplicationFormBean applicationFormBean = null;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				query = "select u.username,u.password,a.transactionid,a.post_applied,a.post_selected_name,a.mobilenumber,a.emailaddress,a.first_name, a.middle_name, a.last_name,a.application_status,a.dob,a.community,a.sex from userinfo u,applicants a WHERE u.transactionid=a.transactionid and a.application_status is not null and  a.dob='"
						+ StringUtils.changeDateFormatYMD(ESAPI.encoder().canonicalize(applicationSearchBean.getDob()))
						+ "' and a.transactionid='" + applicationSearchBean.getTransactionid() + "'";

				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					applicationFormBean = new ApplicationFormBean();
					applicationFormBean.setApplication_status(rs.getString("application_status"));
					applicationFormBean.setTransactionid(rs.getInt("transactionid"));
					applicationFormBean.setPost_applied(rs.getString("post_applied"));
					applicationFormBean.setPost_selected_name(rs.getString("post_selected_name"));
					applicationFormBean.setFirst_name(rs.getString("first_name"));
					applicationFormBean.setMiddle_name(rs.getString("middle_name"));
					applicationFormBean.setLast_name(rs.getString("last_name"));
					applicationFormBean.setPassword(rs.getString("password"));
					applicationFormBean.setMobileNumber(rs.getString("mobileNumber"));
					applicationFormBean.setEmailaddress(rs.getString("emailaddress"));
					applicationFormBean.setCommunity(rs.getString("community"));
					applicationFormBean.setDob(StringUtils.changeDateFormatDMY(rs.getString("dob")));
					applicationFormBean.setSex(rs.getString("sex"));
					if (applicationFormBean.getSex().equalsIgnoreCase("F"))
						applicationFormBean.setSex("Female");
					else
						applicationFormBean.setSex("Male");
					return applicationFormBean;
				} else {
					return null;
				}
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO", "Connection
				// is null", null, null, null);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in Catch",
			// exceptionAsString, null, null, null);
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in
				// finally",exceptionAsString, null, null, null);
			}
		}
	}

	/**
	 * This will fetch basic details for Forgot Registratin ID Fetching with post
	 * Applied, Mobile number & DOB
	 * 
	 * @param applicationSearchBean
	 * @return
	 */
	public ApplicationFormBean getRegistrationIdDeatils(ApplicationSearchBean applicationSearchBean) {
		Connection con = null;
		String query = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ApplicationFormBean applicationFormBean = null;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				query = "select u.username,u.password,a.transactionid,a.post_applied,a.post_selected_name,a.mobilenumber,a.emailaddress,a.first_name, a.middle_name, a.last_name,a.application_status,a.dob,a.community,a.sex from userinfo u,applicants a WHERE u.transactionid=a.transactionid and a.application_status is not null and a.post_applied='"
						+ ESAPI.encoder().canonicalize(applicationSearchBean.getPost_applied()) + "' and  a.dob='"
						+ StringUtils.changeDateFormatYMD(ESAPI.encoder().canonicalize(applicationSearchBean.getDob()))
						+ "' and a.mobileNumber='" + applicationSearchBean.getMobilenumber() + "'";
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					applicationFormBean = new ApplicationFormBean();
					applicationFormBean.setApplication_status(rs.getString("application_status"));
					applicationFormBean.setPassword(rs.getString("password"));
					applicationFormBean.setTransactionid(rs.getInt("transactionid"));
					applicationFormBean.setPost_applied(rs.getString("post_applied"));
					applicationFormBean.setPost_selected_name(rs.getString("post_selected_name"));
					applicationFormBean.setFirst_name(rs.getString("first_name"));
					applicationFormBean.setMiddle_name(rs.getString("middle_name"));
					applicationFormBean.setLast_name(rs.getString("last_name"));
					applicationFormBean.setMobileNumber(rs.getString("mobileNumber"));
					applicationFormBean.setEmailaddress(rs.getString("emailaddress"));
					applicationFormBean.setCommunity(rs.getString("community"));
					applicationFormBean.setDob(StringUtils.changeDateFormatDMY(rs.getString("dob")));
					applicationFormBean.setSex(rs.getString("sex"));
					if (applicationFormBean.getSex().equalsIgnoreCase("F"))
						applicationFormBean.setSex("Female");
					else if (applicationFormBean.getSex().equalsIgnoreCase("M"))
						applicationFormBean.setSex("Male");
					return applicationFormBean;
				} else {
					return null;
				}
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO", "Connection
				// is null", null, null, null);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in Catch",
			// exceptionAsString, null, null, null);
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in
				// finally",exceptionAsString, null, null, null);
			}
		}
	}

	/**
	 * This will authenticate user
	 * 
	 * @param applicationSearchBean
	 * @return
	 */
	public int userAuthenticate(ApplicationSearchBean applicationSearchBean) {
		Connection con = null;
		String query = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int transactionid = 0;
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				query = "select * from userinfo WHERE username=? and password=? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, applicationSearchBean.getTransactionid());
				pstmt.setString(2, applicationSearchBean.getPassword());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					transactionid = rs.getInt("transactionid");
					return transactionid;
				} else {
					return 0;
				}
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO", "Connection
				// is null", null, null, null);
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in Catch",
			// exceptionAsString, null, null, null);
			return 0;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in
				// finally",exceptionAsString, null, null, null);
			}
		}
	}

	/**
	 * This will fetch whole details of candidate with Registration Id
	 * 
	 * @param transactionid
	 * @param post
	 * @return
	 */
	public ApplicationFormBean getData(int transactionid, String post) {
		Connection con = null;
		String query = null, query_check = null;
		PreparedStatement pstmt = null, pstmt1 = null, pstmt3 = null, pstmt5 = null, pstmt_pwd = null;
		ResultSet rs = null, rs1 = null, rs3 = null, rs5 = null, rs_pwd = null;
		;
		ApplicationFormBean applicationFormBean = null;
		String password = "";
		try {
			con = DbConnection.setupDataSource();
			if (con != null) {
				query = "select *,DATE_FORMAT(`date_created`,'%d-%m-%Y %H:%i:%s') as date_created_format from applicants WHERE transactionid=? and  application_status is not null";
				// System.out.println("query="+query);
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, transactionid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					applicationFormBean = new ApplicationFormBean();
					applicationFormBean.setApplication_status(rs.getString("application_status"));
					applicationFormBean.setApplication_final_status(rs.getString("application_final_status"));
					if ("Eligible".equalsIgnoreCase(applicationFormBean.getApplication_final_status())) {
						applicationFormBean.setApplication_final_status("Approved");
					} else if ("PHOTO NOT UPLOADED"
							.equalsIgnoreCase(applicationFormBean.getApplication_final_status())) {
						applicationFormBean.setApplication_final_status("Rejected due to Photo Not Uploaded");
					} else {
						applicationFormBean.setApplication_final_status("Rejected due to Non Payment of Fees");
					}
					applicationFormBean.setPayment_status(rs.getString("payment_status"));
					applicationFormBean.setPost_applied(rs.getString("post_applied"));

					applicationFormBean.setDate_created(rs.getString("date_created_format"));
					applicationFormBean.setPayExempted(rs.getBoolean("payment_exempted"));
					applicationFormBean.setFee_amount(rs.getInt("fee_amount"));
					// boolean is_rejected=rs.getBoolean("is_rejected");
					// applicationFormBean.setIs_rejected(is_rejected);

					if ("Finished".equalsIgnoreCase(applicationFormBean.getApplication_status())) {
						if ("Success".equalsIgnoreCase(applicationFormBean.getPayment_status())
								|| applicationFormBean.isPayExempted()) {
							if (applicationFormBean.getPost_applied() != null
									&& applicationFormBean.getPost_applied().equalsIgnoreCase("9")) {
								applicationFormBean.setPost_change_eligible(false);
							} else {
								applicationFormBean.setPost_change_eligible(true);
							}
						} else
							applicationFormBean.setPost_change_eligible(false);
					} else
						applicationFormBean.setPost_change_eligible(false);

					applicationFormBean.setPost_selected_name(rs.getString("post_selected_name"));
					applicationFormBean.setDomicile_state(rs.getString("domicile_state"));
					applicationFormBean.setTransactionid(rs.getInt("transactionid"));
					applicationFormBean.setFirst_name(rs.getString("first_name"));
					applicationFormBean.setMiddle_name(rs.getString("middle_name"));
					applicationFormBean.setLast_name(rs.getString("last_name"));
					applicationFormBean.setFather_name(rs.getString("father_name"));
					applicationFormBean.setMother_name(rs.getString("mother_name"));
					applicationFormBean.setDob(StringUtils.changeDateFormatDMY(rs.getString("dob")));
					applicationFormBean.setReligion(rs.getString("religion"));
					applicationFormBean.setOther_religion(rs.getString("other_religion"));
					applicationFormBean.setMarrital_status(rs.getString("marrital_status"));
					applicationFormBean.setNationality(rs.getString("nationality"));
					applicationFormBean.setAadharNo(rs.getString("aadhar_no"));
					applicationFormBean.setIdentity_type(rs.getString("identity_type"));
					applicationFormBean.setIdentification_mark(rs.getString("identification_mark"));
					applicationFormBean.setMobileNumber(rs.getString("mobileNumber"));
					applicationFormBean.setEmailaddress(rs.getString("emailaddress"));
					applicationFormBean.setCommunity(rs.getString("community"));
					applicationFormBean.setCategory(rs.getString("category"));
					applicationFormBean.setSex(rs.getString("sex"));
					if (applicationFormBean.getSex().equalsIgnoreCase("F"))
						applicationFormBean.setSex("Female");
					else if (applicationFormBean.getSex().equalsIgnoreCase("M"))
						applicationFormBean.setSex("Male");
					applicationFormBean.setVillage(rs.getString("village"));
					applicationFormBean.setPostoffice(rs.getString("postoffice"));
					applicationFormBean.setPolicestation(rs.getString("policestation"));
					applicationFormBean.setTehsil(rs.getString("tehsil"));
					applicationFormBean.setDistrict(rs.getString("district"));
					applicationFormBean.setState(rs.getString("state"));
					applicationFormBean.setPincode(rs.getString("pincode"));
					applicationFormBean.setVillage1(rs.getString("village1"));
					applicationFormBean.setPostoffice1(rs.getString("postoffice1"));
					applicationFormBean.setPolicestation1(rs.getString("policestation1"));
					applicationFormBean.setTehsil1(rs.getString("tehsil1"));
					applicationFormBean.setState1(rs.getString("state1"));
					applicationFormBean.setDistrict1(rs.getString("district1"));
					applicationFormBean.setPincode1(rs.getString("pincode1"));
					applicationFormBean.setPost_id(rs.getInt("post_id"));
					applicationFormBean.setOrg_id(rs.getInt("org_id"));
					applicationFormBean.setEdu_qual(rs.getString("edu_qual"));

					applicationFormBean.setPhotoFileName(rs.getString("photo_file_name"));
					applicationFormBean.setSigFileName(rs.getString("signature_file_name"));

					applicationFormBean.setOther_nationality(rs.getString("other_nationality"));
					/*
					 * applicationFormBean.setAffected_categories(rs.getString("affected_categories"
					 * ));
					 * String affected_category_names="";
					 * if(applicationFormBean.getAffected_categories()!=null)
					 * {
					 * StringBuffer affected_category_names_sb=new StringBuffer();
					 * StringTokenizer st=new
					 * StringTokenizer(applicationFormBean.getAffected_categories(),",");
					 * while (st.hasMoreElements()) {
					 * affected_category_names_sb.append(StringUtils.getAffectedCategoryName(st.
					 * nextElement().toString()));
					 * affected_category_names_sb.append(",");
					 * }
					 * affected_category_names=affected_category_names_sb.toString();
					 * if(affected_category_names!=null)
					 * {
					 * affected_category_names=affected_category_names.substring(0,
					 * affected_category_names.lastIndexOf(","));
					 * }
					 * }
					 * applicationFormBean.setAffected_category_names(affected_category_names);
					 */
					applicationFormBean.setEx_serviceman(rs.getBoolean("ex_serviceman"));
					applicationFormBean.setEmployee_ssb(rs.getBoolean("ssb_emp_service"));
					applicationFormBean.setGovt_service(rs.getBoolean("govt_emp_service"));

					applicationFormBean.setDebarment(rs.getBoolean("debarment"));
					applicationFormBean.setFir_cases(rs.getBoolean("fir_case"));
					applicationFormBean.setFir_cases_pending(rs.getBoolean("fir_case_pending"));
					applicationFormBean.setArrested(rs.getBoolean("arrested"));
					applicationFormBean.setCriminal_case_acquitted(rs.getBoolean("criminal_case_acquitted"));
					applicationFormBean.setGood_behavior_bond(rs.getBoolean("good_behavior_bond"));

					applicationFormBean.setCategoty_belongs(rs.getBoolean("category_belongs"));
					applicationFormBean.setJk_domiciled(rs.getBoolean("jk_domiciled"));
					applicationFormBean.setRiots_affected(rs.getBoolean("riots_affected"));
					applicationFormBean.setRiots_gujarat(rs.getBoolean("riots_gujarat"));

					/*
					 * boolean payExempted=false;
					 * if("Female".equalsIgnoreCase(applicationFormBean.getSex()))
					 * payExempted=true;
					 * if("SC".equalsIgnoreCase(applicationFormBean.getCommunity()))
					 * payExempted=true;
					 * if("ST".equalsIgnoreCase(applicationFormBean.getCommunity()))
					 * payExempted=true;
					 * if(applicationFormBean.isEx_serviceman())
					 * payExempted=true;
					 * 
					 * applicationFormBean.setPayExempted(payExempted);
					 */

					String query_password = "select * from userinfo WHERE transactionid=? ";
					pstmt_pwd = con.prepareStatement(query_password);
					pstmt_pwd.setInt(1, applicationFormBean.getTransactionid());
					rs_pwd = pstmt_pwd.executeQuery();
					if (rs_pwd.next()) {
						password = rs_pwd.getString("password");
						applicationFormBean.setPassword(password);
					}

					query_check = "select * from debarment_details where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					pstmt5 = con.prepareStatement(query_check);
					rs5 = pstmt5.executeQuery();
					while (rs5.next()) {
						applicationFormBean.setExamorganizer(rs5.getString("exam_organizer"));
						applicationFormBean.setExamname(rs5.getString("exam_name"));
						applicationFormBean.setExamdate(rs5.getString("exam_date"));
						applicationFormBean.setDebarenddate(rs5.getString("debarment_date"));
						applicationFormBean.setDebar_reason(rs5.getString("reason"));
						applicationFormBean.setOther_reason(applicationFormBean.getDebar_reason());
					}

					query_check = "select * from fir_details where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					pstmt1 = con.prepareStatement(query_check);
					rs1 = pstmt1.executeQuery();
					while (rs1.next()) {
						applicationFormBean.setFirdate(rs1.getString("fir_date"));
						applicationFormBean.setFirdistrict(rs1.getString("fir_district"));
						applicationFormBean.setFirstatus(rs1.getString("fir_status"));
						applicationFormBean.setFirsection(rs1.getString("fir_section"));
						applicationFormBean.setFirno(rs1.getString("fir_no"));
					}

					query_check = "select * from service_details where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					pstmt3 = con.prepareStatement(query_check);
					rs3 = pstmt3.executeQuery();
					while (rs3.next()) {
						applicationFormBean.setEmp_date_since(rs3.getString("emp_date"));
						applicationFormBean.setPost_held(rs3.getString("post_held"));
						applicationFormBean.setNocdesignation(rs3.getString("noc_designation"));
						applicationFormBean.setPresent_employer(rs3.getString("emp_name"));
					}
					if (rs3 != null)
						rs3.close();
					if (pstmt3 != null)
						pstmt3.close();

					query_check = "select * from exman_details where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					PreparedStatement pstmt2 = con.prepareStatement(query_check);
					ResultSet rs2 = pstmt2.executeQuery();
					while (rs2.next()) {
						applicationFormBean.setExman_med_cat(rs2.getString("medical_category"));
						applicationFormBean.setExman_awd_dec(rs2.getString("award_decoration"));
						applicationFormBean.setExman_discharge_reason(rs2.getString("discharge_reason"));
						applicationFormBean.setExman_edu_qual(rs2.getString("edu_qual"));
						applicationFormBean.setExman_enrollment_date(rs2.getString("date_enrollment"));
						applicationFormBean.setExman_retirement_date(rs2.getString("date_retirement"));
					}
					if (rs2 != null)
						rs2.close();
					if (pstmt2 != null)
						pstmt2.close();

					query_check = "select * from personal_qualification where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					PreparedStatement pstmtPersonal = con.prepareStatement(query_check);
					ResultSet personal = pstmtPersonal.executeQuery();
					while (personal.next()) {
						Object hc_lab_assistant_cert = personal.getObject("hc_lab_assistant_cert");
						Object hc_lab_assistant_experience = personal.getObject("hc_lab_assistant_experience");
						Object hc_physio_cert = personal.getObject("hc_physio_cert");
						Object hc_phsio_assistant_experience = personal.getObject("hc_phsio_assistant_experience");
						Object ct_nursing_first_aid_cert = personal.getObject("ct_nursing_first_aid_cert");
						Object ct_nursing_assistant_experience = personal.getObject("ct_nursing_assistant_experience");

						if (hc_lab_assistant_cert == null) {
							applicationFormBean.setHcLabAsstCertValue("");
						} else {
							boolean hc_lab_assistant_cert_val = (Boolean) hc_lab_assistant_cert;
							applicationFormBean.setHcLabAsstCertValue(null);
							applicationFormBean.setHcLabAsstCert(hc_lab_assistant_cert_val);
						}
						if (hc_lab_assistant_experience == null) {
							applicationFormBean.setHcLabAsstExpValue("");
						} else {
							boolean hc_lab_assistant_experience_val = (Boolean) hc_lab_assistant_experience;
							applicationFormBean.setHcLabAsstExpValue(null);
							applicationFormBean.setHcLabAsstExp(hc_lab_assistant_experience_val);
						}

						if (hc_physio_cert == null) {
							applicationFormBean.setHcPhysioAsstCertValue("");
						} else {
							boolean hc_physio_cert_val = (Boolean) hc_physio_cert;
							applicationFormBean.setHcPhysioAsstCertValue(null);
							applicationFormBean.setHcPhysioAsstCert(hc_physio_cert_val);
						}

						if (hc_phsio_assistant_experience == null) {
							applicationFormBean.setHcPhysioAsstExpValue("");
						} else {
							boolean hc_phsio_assistant_experience_val = (Boolean) hc_phsio_assistant_experience;
							applicationFormBean.setHcPhysioAsstExpValue(null);
							applicationFormBean.setHcPhysioAsstExp(hc_phsio_assistant_experience_val);
						}

						if (ct_nursing_first_aid_cert == null) {
							applicationFormBean.setCtNursingCertValue("");
						} else {
							boolean ct_nursing_first_aid_cert_val = (Boolean) ct_nursing_first_aid_cert;
							applicationFormBean.setCtNursingCertValue(null);
							applicationFormBean.setCtNursingCert(ct_nursing_first_aid_cert_val);
						}

						if (ct_nursing_assistant_experience == null) {
							applicationFormBean.setCtNursingExpValue("");
						} else {
							boolean ct_nursing_assistant_experience_val = (Boolean) ct_nursing_assistant_experience;
							applicationFormBean.setCtNursingExpValue(null);
							applicationFormBean.setCtNursingExp(ct_nursing_assistant_experience_val);
						}

						// if (registered_nursing_council == null) {
						// applicationFormBean.setNurse("");
						// } else {
						// boolean registeredNursing = (Boolean) registered_nursing_council;
						// applicationFormBean.setNurse(null);
						// applicationFormBean.setNursing_council(registeredNursing);
						// }

						// Object registered_nursing_council =
						// personal.getObject("registered_nursing_council");
						// Object hospital_experience = personal.getObject("hospital_experience");
						// Object tradesmen_certificate = personal.getObject("tradesmen_certificate");
						// Object autocad_experience = personal.getObject("autocad_experience");
						// Object draughtsmanship_experience =
						// personal.getObject("draughtsmanship_experience");
						// if (registered_nursing_council == null) {
						// applicationFormBean.setNurse("");
						// } else {
						// boolean registeredNursing = (Boolean) registered_nursing_council;
						// applicationFormBean.setNurse(null);
						// applicationFormBean.setNursing_council(registeredNursing);
						// }

						// if (hospital_experience == null) {
						// applicationFormBean.setHospital("");
						// } else {
						// boolean hospital = (Boolean) hospital_experience;
						// applicationFormBean.setHospital(null);
						// applicationFormBean.setHospital_experience(hospital);
						// }

						// if (tradesmen_certificate == null) {
						// applicationFormBean.setTrade("");
						// } else {
						// boolean trade = (Boolean) tradesmen_certificate;
						// applicationFormBean.setTrade(null);
						// applicationFormBean.setTradesmen_certificate(trade);
						// }
						// if (autocad_experience == null) {
						// applicationFormBean.setAutocad("");
						// } else {
						// boolean auto = (Boolean) autocad_experience;
						// applicationFormBean.setAutocad(null);
						// applicationFormBean.setAutocad_certificate(auto);
						// }
						// if (draughtsmanship_experience == null) {
						// applicationFormBean.setDraft("");
						// } else {
						// boolean draft = (Boolean) draughtsmanship_experience;
						// applicationFormBean.setDraft(null);
						// applicationFormBean.setDraughtsmanship_exp(draft);
						// }

					}
					if (personal != null)
						personal.close();
					if (pstmtPersonal != null)
						pstmtPersonal.close();

					if (applicationFormBean.isCategoty_belongs()) {
						String certificate_query = "select * from certificate_details where transactionid='"
								+ applicationFormBean.getTransactionid() + "' and certificate='Community'";
						pstmt2 = con.prepareStatement(certificate_query);
						rs2 = pstmt2.executeQuery();
						while (rs2.next()) {
							applicationFormBean.setCat_cert_no(rs2.getString("cert_no"));
							applicationFormBean.setCat_date_Issue(rs2.getString("date_issue"));
							applicationFormBean.setCat_issue_authority(rs2.getString("issueing_authority"));
						}
						if (rs2 != null)
							rs2.close();
						if (pstmt2 != null)
							pstmt2.close();
					}

					if (applicationFormBean.isJk_domiciled()) {
						String certificate_query = "select * from certificate_details where transactionid='"
								+ applicationFormBean.getTransactionid() + "' and certificate='JK Domicile'";
						pstmt2 = con.prepareStatement(certificate_query);
						rs2 = pstmt2.executeQuery();
						while (rs2.next()) {
							applicationFormBean.setJk_cert_no(rs2.getString("cert_no"));
							applicationFormBean.setJk_date_Issue(rs2.getString("date_issue"));
							applicationFormBean.setJk_issue_authority(rs2.getString("issueing_authority"));
						}
						if (rs2 != null)
							rs2.close();
						if (pstmt2 != null)
							pstmt2.close();
					}

					if (applicationFormBean.isRiots_affected()) {
						String certificate_query = "select * from certificate_details where transactionid='"
								+ applicationFormBean.getTransactionid() + "' and certificate='Riots 1984'";
						pstmt2 = con.prepareStatement(certificate_query);
						rs2 = pstmt2.executeQuery();
						while (rs2.next()) {
							applicationFormBean.setRiots_cert_no(rs2.getString("cert_no"));
							applicationFormBean.setRiots_date_Issue(rs2.getString("date_issue"));
							applicationFormBean.setRiots_issue_authority(rs2.getString("issueing_authority"));
						}
						if (rs2 != null)
							rs2.close();
						if (pstmt2 != null)
							pstmt2.close();
					}

					if (applicationFormBean.isRiots_gujarat()) {
						String certificate_query = "select * from certificate_details where transactionid='"
								+ applicationFormBean.getTransactionid() + "' and certificate='Riots 2002 Gujarat'";
						pstmt2 = con.prepareStatement(certificate_query);
						rs2 = pstmt2.executeQuery();
						while (rs2.next()) {
							applicationFormBean.setRiots_guj_cert_no(rs2.getString("cert_no"));
							applicationFormBean.setRiots_guj_date_Issue(rs2.getString("date_issue"));
							applicationFormBean.setRiots_guj_issue_authority(rs2.getString("issueing_authority"));
						}
						if (rs2 != null)
							rs2.close();
						if (pstmt2 != null)
							pstmt2.close();
					}

					query_check = "select * from education_details where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					pstmt2 = con.prepareStatement(query_check);
					rs2 = pstmt2.executeQuery();
					String ed_qual = "";
					while (rs2.next()) {
						ed_qual = rs2.getString("ed_qual");
						if (ed_qual != null && ed_qual.equalsIgnoreCase("1")) {
							applicationFormBean.setExam_passed_1(rs2.getString("exam_passed"));
							applicationFormBean.setUniversity_1(rs2.getString("university"));
							applicationFormBean.setEdu_certno_1(rs2.getString("cert_no"));
							applicationFormBean.setEdu_date_issue_1(rs2.getString("date_issue"));
							applicationFormBean.setEdu_rollno_1(rs2.getString("rollno"));
							applicationFormBean.setStream_1(rs2.getString("subject"));
							applicationFormBean.setEdu_marks_1(rs2.getString("percentage"));
							applicationFormBean.setEdu_year_1(rs2.getString("year"));
						} else if (ed_qual != null && ed_qual.equalsIgnoreCase("2")) {
							applicationFormBean.setExam_passed_2(rs2.getString("exam_passed"));
							applicationFormBean.setUniversity_2(rs2.getString("university"));
							applicationFormBean.setEdu_certno_2(rs2.getString("cert_no"));
							applicationFormBean.setEdu_date_issue_2(rs2.getString("date_issue"));
							applicationFormBean.setEdu_rollno_2(rs2.getString("rollno"));
							applicationFormBean.setStream_2(rs2.getString("subject"));
							applicationFormBean.setEdu_marks_2(rs2.getString("percentage"));
							applicationFormBean.setEdu_year_2(rs2.getString("year"));
						} else if (ed_qual != null && ed_qual.equalsIgnoreCase("3")) {
							applicationFormBean.setExam_passed_plus2(rs2.getString("exam_passed"));
							applicationFormBean.setUniversity_plus2(rs2.getString("university"));
							applicationFormBean.setEdu_certno_plus2(rs2.getString("cert_no"));
							applicationFormBean.setEdu_date_issue_plus2(rs2.getString("date_issue"));
							applicationFormBean.setEdu_rollno_plus2(rs2.getString("rollno"));
							applicationFormBean.setStream_plus2(rs2.getString("subject"));
							applicationFormBean.setEdu_marks_plus2(rs2.getString("percentage"));
							applicationFormBean.setEdu_year_plus2(rs2.getString("year"));
						} else if (ed_qual != null && ed_qual.equalsIgnoreCase("4")) {
							applicationFormBean.setExam_passed_3(rs2.getString("exam_passed"));
							applicationFormBean.setUniversity_3(rs2.getString("university"));
							applicationFormBean.setEdu_certno_3(rs2.getString("cert_no"));
							applicationFormBean.setEdu_date_issue_3(rs2.getString("date_issue"));
							applicationFormBean.setEdu_rollno_3(rs2.getString("rollno"));
							applicationFormBean.setStream_3(rs2.getString("subject"));
							applicationFormBean.setEdu_marks_3(rs2.getString("percentage"));
							applicationFormBean.setEdu_year_3(rs2.getString("year"));
						} else if (ed_qual != null && ed_qual.equalsIgnoreCase("5")) {
							applicationFormBean.setExam_passed_4(rs2.getString("exam_passed"));
							applicationFormBean.setUniversity_4(rs2.getString("university"));
							applicationFormBean.setEdu_certno_4(rs2.getString("cert_no"));
							applicationFormBean.setEdu_date_issue_4(rs2.getString("date_issue"));
							applicationFormBean.setEdu_rollno_4(rs2.getString("rollno"));
							applicationFormBean.setStream_4(rs2.getString("subject"));
							applicationFormBean.setEdu_marks_4(rs2.getString("percentage"));
							applicationFormBean.setEdu_year_4(rs2.getString("year"));
						} else if (ed_qual != null && ed_qual.equalsIgnoreCase("6")) {
							applicationFormBean.setExam_passed_5(rs2.getString("exam_passed"));
							applicationFormBean.setUniversity_5(rs2.getString("university"));
							applicationFormBean.setEdu_certno_5(rs2.getString("cert_no"));
							applicationFormBean.setEdu_date_issue_5(rs2.getString("date_issue"));
							applicationFormBean.setEdu_rollno_5(rs2.getString("rollno"));
							applicationFormBean.setStream_5(rs2.getString("subject"));
							applicationFormBean.setEdu_marks_5(rs2.getString("percentage"));
							applicationFormBean.setEdu_year_5(rs2.getString("year"));
						}
					}
					if (rs2 != null)
						rs2.close();
					if (pstmt2 != null)
						pstmt2.close();

					query_check = "select * from other_skills where transactionid='"
							+ applicationFormBean.getTransactionid() + "'";
					pstmt2 = con.prepareStatement(query_check);
					rs2 = pstmt2.executeQuery();
					int skill_no = 0, no_of_skills = 0;
					while (rs2.next()) {
						no_of_skills++;
						skill_no = rs2.getInt("skill_no");
						if (skill_no == 1) {
							applicationFormBean.setSkill_1(rs2.getString("skill"));
						}
						if (skill_no == 2) {
							applicationFormBean.setSkill_2(rs2.getString("skill"));
						}
						if (skill_no == 3) {
							applicationFormBean.setSkill_3(rs2.getString("skill"));
						}
						if (skill_no == 4) {
							applicationFormBean.setSkill_4(rs2.getString("skill"));
						}
						if (skill_no == 5) {
							applicationFormBean.setSkill_5(rs2.getString("skill"));
						}
						if (skill_no == 6) {
							applicationFormBean.setSkill_6(rs2.getString("skill"));
						}
						if (skill_no == 7) {
							applicationFormBean.setSkill_7(rs2.getString("skill"));
						}
						if (skill_no == 8) {
							applicationFormBean.setSkill_8(rs2.getString("skill"));
						}
						if (skill_no == 9) {
							applicationFormBean.setSkill_9(rs2.getString("skill"));
						}
					}
					if (no_of_skills > 0)
						applicationFormBean.setSkills_flag(true);
					else
						applicationFormBean.setSkills_flag(false);

					if (rs2 != null)
						rs2.close();
					if (pstmt2 != null)
						pstmt2.close();
				} else {
					return null;
				}
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO", "Connection
				// is null", null, null, null);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in Catch",
			// exceptionAsString, null, null, null);
			return null;
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (rs != null)
					rs.close();
				if (rs5 != null)
					rs5.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt5 != null)
					pstmt5.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null && !con.isClosed())
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				// LogsGeneration.generateErrorLogsWithMobileNumber("SearchDataDAO in
				// finally",exceptionAsString, null, null, null);
			}
		}
		return applicationFormBean;
	}

	/***
	 * For Fecthing Payment Status of Registration Id in Applicants table
	 * 
	 * @param transactionid
	 * @return
	 */
	public String getPaymentStatus(int transactionid) {
		Connection con = null;
		String query_check = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String application_status = "", payment_status = null;
		try {
			con = DbConnection.setupRepoDataSource();
			if (con != null) {
				query_check = "select transactionid,application_status,payment_status from applicants WHERE transactionid=? ";
				pstmt1 = con.prepareStatement(query_check);
				pstmt1.setInt(1, transactionid);
				rs = pstmt1.executeQuery();
				if (rs.next()) {
					payment_status = rs.getString("payment_status");
					return payment_status;
				} else {
					return null;
				}
			} else {
				// LogsGeneration.generateErrorLogsWithMobileNumber("MobileVerifyDAO",
				// "Connection is null in DAO", null, null, null);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogs("PaymentStatus Catch",exceptionAsString,
			// null,transactionid, null, null);
			return null;
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

}
