package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.AcknoweledgementBean;

/**
 * @author Timing Technologies India Pvt Ltd
 *         This class is used for Generating Candidate Acknoweledgement through
 *         acknowledgement JSP page
 */
public class AcknoweledgementServlet extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;

	public void dopost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.service(req, res);
	}

	public void service(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			// LogsGeneration.generateAccessLog("Acknowledgement",
			// request.getRemoteAddr(),request.getHeader("User-Agent"));
			String requestFrom = (String) request.getParameter("requestFrom");
			if (requestFrom != null && "TransactionPage".equalsIgnoreCase(requestFrom)) {
				AcknoweledgementBean applicationFormBean = new AcknoweledgementBean();
				applicationFormBean.setTransactionid(Integer.parseInt(request.getParameter("transactionid")));
				// applicationFormBean.setOrg_name(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter(
				// "org_name" )));
				// applicationFormBean.setNotification_number(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter(
				// "notification_number" )));
				// applicationFormBean.setPost_name(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter(
				// "post_name" )));
				applicationFormBean.setMobileNumber(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("mobileNumber").trim()));
				applicationFormBean.setEmailaddress(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("emailaddress").trim()));

				String imagesPath = request.getServletContext().getRealPath("candidateImages");
				applicationFormBean.setPhotoFileName(request.getParameter("photoFileName").trim());
				applicationFormBean.setSigFileName(request.getParameter("sigFileName").trim());

				// applicationFormBean.setDomicile_state(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter(
				// "domicile_state" ).trim()));
				applicationFormBean.setPost_applied(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("post_applied").trim()));
				applicationFormBean.setPost_selected_name(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("post_selected_name").trim()));

				// applicationFormBean.setPost_applied("HC (MINISTERIAL)");
				applicationFormBean.setMarrital_status(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("marrital_status").trim()));
				applicationFormBean.setNationality(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("nationality").trim()));
				applicationFormBean.setOther_nationality(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("other_nationality").trim()));
				applicationFormBean
						.setAadharNo(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("aadharNo").trim()));
				applicationFormBean.setIdentity_type(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("identity_type").trim()));
				applicationFormBean.setFirst_name(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("first_name").trim()));
				applicationFormBean.setMiddle_name(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("middle_name").trim()));
				applicationFormBean
						.setLast_name(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("last_name").trim()));
				applicationFormBean.setFather_name(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("father_name").trim()));
				applicationFormBean.setMother_name(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("mother_name").trim()));
				applicationFormBean
						.setReligion(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("religion").trim()));
				applicationFormBean.setOther_religion(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("other_religion").trim()));
				applicationFormBean.setSex(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("sex").trim()));
				applicationFormBean
						.setCommunity(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("community").trim()));
				applicationFormBean
						.setCategory(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("category").trim()));
				applicationFormBean.setIdentification_mark(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("identification_mark").trim()));

				applicationFormBean
						.setVillage(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("village").trim()));
				applicationFormBean.setPostoffice(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("postoffice").trim()));
				applicationFormBean.setPolicestation(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("policestation").trim()));
				applicationFormBean
						.setTehsil(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("tehsil").trim()));
				applicationFormBean
						.setState(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("state").trim()));
				applicationFormBean
						.setDistrict(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("district").trim()));
				applicationFormBean
						.setPincode(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("pincode").trim()));
				applicationFormBean
						.setVillage1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("village1").trim()));
				applicationFormBean.setPostoffice1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("postoffice1").trim()));
				applicationFormBean.setPolicestation1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("policestation1").trim()));
				applicationFormBean
						.setTehsil1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("tehsil1").trim()));
				applicationFormBean
						.setState1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("state1").trim()));
				applicationFormBean
						.setDistrict1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("district1").trim()));
				applicationFormBean
						.setPincode1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("pincode1").trim()));

				/*
				 * applicationFormBean.setAffected_category_names(ESAPI.encoder().
				 * encodeForHTMLAttribute(request.getParameter( "affected_category_names"
				 * ).trim()));
				 */
				applicationFormBean.setCategoty_belongs(Boolean.parseBoolean(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("categoty_belongs"))));
				applicationFormBean.setJk_domiciled(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("jk_domiciled"))));
				applicationFormBean.setRiots_affected(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("riots_affected"))));
				applicationFormBean.setRiots_gujarat(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("riots_gujarat"))));

				if (applicationFormBean.isCategoty_belongs()) {
					applicationFormBean.setCat_cert_no(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("cat_cert_no").trim()));
					applicationFormBean.setCat_date_Issue(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("cat_date_Issue").trim()));
					applicationFormBean.setCat_issue_authority(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("cat_issue_authority").trim()));
				}
				if (applicationFormBean.isJk_domiciled()) {
					applicationFormBean.setJk_cert_no(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("jk_cert_no").trim()));
					applicationFormBean.setJk_date_Issue(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("jk_date_Issue").trim()));
					applicationFormBean.setJk_issue_authority(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("jk_issue_authority").trim()));
				}
				if (applicationFormBean.isRiots_affected()) {
					applicationFormBean.setRiots_cert_no(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("riots_cert_no").trim()));
					applicationFormBean.setRiots_date_Issue(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("riots_date_Issue").trim()));
					applicationFormBean.setRiots_issue_authority(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("riots_issue_authority").trim()));
				}
				if (applicationFormBean.isRiots_gujarat()) {
					applicationFormBean.setRiots_guj_cert_no(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("riots_guj_cert_no").trim()));
					applicationFormBean.setRiots_guj_date_Issue(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("riots_guj_date_Issue").trim()));
					applicationFormBean.setRiots_guj_issue_authority(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("riots_guj_issue_authority").trim()));
				}

				applicationFormBean.setEmployee_ssb(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("employee_ssb"))));
				applicationFormBean.setGovt_service(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("govt_service"))));
				applicationFormBean.setEx_serviceman(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("ex_serviceman"))));
				applicationFormBean.setGood_behavior_bond(Boolean.parseBoolean(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("good_behavior_bond"))));
				applicationFormBean.setFir_cases(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("fir_cases"))));
				applicationFormBean.setFir_cases_pending(Boolean.parseBoolean(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("fir_cases_pending"))));
				applicationFormBean.setCriminal_case_acquitted(Boolean.parseBoolean(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("criminal_case_acquitted"))));
				applicationFormBean.setArrested(
						Boolean.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("arrested"))));
				applicationFormBean.setDebarment(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("debarment"))));
				applicationFormBean.setCorrespondence_address(Boolean.parseBoolean(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("correspondence_address"))));
				applicationFormBean.setPayExempted(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("payExempted"))));

				if (!(request.getParameter("nurse").equalsIgnoreCase("null"))) {
					if (request.getParameter("nurse").equalsIgnoreCase("")) {
						applicationFormBean.setNurse("");
					}
				} else {

					applicationFormBean.setNursing_council(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("nursing_council"))));
					applicationFormBean.setNurse(null);
				}

				// .hc lab
				if (!(request.getParameter("hcLabAsstCertValue").equalsIgnoreCase("null"))) {
					if (request.getParameter("hcLabAsstCertValue").equalsIgnoreCase("")) {
						applicationFormBean.setHcLabAsstCertValue("");
					}
				} else {
					applicationFormBean.setHcLabAsstCert(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("hcLabAsstCert"))));
					applicationFormBean.setHcLabAsstCertValue(null);
				}

				if (!(request.getParameter("hcLabAsstExpValue").equalsIgnoreCase("null"))) {
					if (request.getParameter("hcLabAsstExpValue").equalsIgnoreCase("")) {
						applicationFormBean.setHcLabAsstExpValue("");
					}
				} else {
					applicationFormBean.setHcLabAsstExp(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("hcLabAsstExp"))));
					applicationFormBean.setHcLabAsstExpValue(null);
				}

				// .hc pysio
				if (!(request.getParameter("hcPhysioAsstCertValue").equalsIgnoreCase("null"))) {
					if (request.getParameter("hcPhysioAsstCertValue").equalsIgnoreCase("")) {
						applicationFormBean.setHcPhysioAsstCertValue("");
					}
				} else {
					applicationFormBean.setHcPhysioAsstCert(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("hcPhysioAsstCert"))));
					applicationFormBean.setHcPhysioAsstCertValue(null);
				}

				if (!(request.getParameter("hcPhysioAsstExpValue").equalsIgnoreCase("null"))) {
					if (request.getParameter("hcPhysioAsstExpValue").equalsIgnoreCase("")) {
						applicationFormBean.setHcPhysioAsstExpValue("");
					}
				} else {
					applicationFormBean.setHcPhysioAsstExp(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("hcPhysioAsstExp"))));
					applicationFormBean.setHcPhysioAsstExpValue(null);
				}

				// .ct nursing
				if (!(request.getParameter("ctNursingCertValue").equalsIgnoreCase("null"))) {
					if (request.getParameter("ctNursingCertValue").equalsIgnoreCase("")) {
						applicationFormBean.setCtNursingCertValue("");
					}
				} else {
					applicationFormBean.setCtNursingCert(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("ctNursingCert"))));
					applicationFormBean.setCtNursingCertValue(null);
				}

				if (!(request.getParameter("ctNursingExpValue").equalsIgnoreCase("null"))) {
					if (request.getParameter("ctNursingExpValue").equalsIgnoreCase("")) {
						applicationFormBean.setCtNursingExpValue("");
					}
				} else {
					applicationFormBean.setCtNursingExp(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("ctNursingExp"))));
					applicationFormBean.setCtNursingExpValue(null);
				}

				if (!(request.getParameter("draft").equalsIgnoreCase("null"))) {
					if (request.getParameter("draft").equalsIgnoreCase("")) {
						applicationFormBean.setDraft("");
					}
				} else {
					applicationFormBean.setDraughtsmanship_exp(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("draughtsmanship_exp"))));
					applicationFormBean.setDraft(null);
				}

				if (!(request.getParameter("hospital").equalsIgnoreCase("null"))) {
					if (request.getParameter("hospital").equalsIgnoreCase("")) {
						applicationFormBean.setHospital("");
					}
				} else {
					applicationFormBean.setHospital_experience(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("hospital_experience"))));
					applicationFormBean.setHospital(null);
				}

				if (!(request.getParameter("trade").equalsIgnoreCase("null"))) {
					if (request.getParameter("trade").equalsIgnoreCase("")) {
						applicationFormBean.setTrade("");
					}
				} else {
					applicationFormBean.setTradesmen_certificate(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("tradesmen_certificate"))));
					applicationFormBean.setTrade(null);
				}

				if (!(request.getParameter("autocad").equalsIgnoreCase("null"))) {
					if (request.getParameter("autocad").equalsIgnoreCase("")) {
						applicationFormBean.setAutocad("");
					}
				} else {
					applicationFormBean.setAutocad_certificate(Boolean.parseBoolean(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("autocad_certificate"))));
					applicationFormBean.setAutocad(null);
				}

				if (applicationFormBean.isEx_serviceman()) {
					// payExempted=true;
					applicationFormBean.setExman_enrollment_date(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("exman_enrollment_date").trim()));
					applicationFormBean.setExman_retirement_date(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("exman_retirement_date").trim()));
					applicationFormBean.setExman_med_cat(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exman_med_cat").trim()));
					applicationFormBean.setExman_awd_dec(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exman_awd_dec").trim()));
					applicationFormBean.setExman_discharge_reason(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("exman_discharge_reason").trim()));
					if (request.getParameter("exman_edu_qual") != null)
						applicationFormBean.setExman_edu_qual(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exman_edu_qual").trim()));
					else
						applicationFormBean.setExman_edu_qual("");
				}

				applicationFormBean.setEmp_date_since(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("emp_date_since").trim()));
				applicationFormBean.setPresent_employer(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("present_employer").trim()));
				applicationFormBean
						.setPost_held(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("post_held").trim()));
				applicationFormBean.setNocdesignation(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("nocdesignation").trim()));

				applicationFormBean.setDob(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("dob").trim()));
				applicationFormBean
						.setFirdate(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firdate").trim()));
				applicationFormBean.setFirdistrict(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firdistrict").trim()));
				applicationFormBean
						.setFirno(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firno").trim()));
				applicationFormBean.setFirsection(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firsection").trim()));
				applicationFormBean
						.setFirstatus(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firstatus").trim()));

				applicationFormBean.setDate_created(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("date_created").trim()));

				applicationFormBean.setExamorganizer(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("examorganizer").trim()));
				applicationFormBean
						.setExamname(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("examname").trim()));
				applicationFormBean
						.setExamdate(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("examdate").trim()));
				applicationFormBean.setDebarenddate(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("debarenddate").trim()));
				applicationFormBean.setDebar_reason(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("debar_reason").trim()));
				applicationFormBean.setOther_reason(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("other_reason").trim()));

				if (request.getParameter("edu_qual") != null)
					applicationFormBean.setEdu_qual(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_qual").trim()));
				else {
					applicationFormBean.setEdu_qual("");
				}

				applicationFormBean.setExam_passed_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exam_passed_1").trim()));
				applicationFormBean.setEdu_certno_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_certno_1").trim()));
				applicationFormBean.setEdu_rollno_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_rollno_1").trim()));
				applicationFormBean.setEdu_date_issue_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_date_issue_1").trim()));
				applicationFormBean
						.setStream_1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_1").trim()));
				applicationFormBean.setUniversity_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_1").trim()));
				applicationFormBean.setEdu_year_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_1").trim()));
				applicationFormBean.setEdu_marks_1(
						ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_1").trim()));

				if (request.getParameter("exam_passed_2") != null) {
					applicationFormBean.setExam_passed_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exam_passed_2").trim()));
					applicationFormBean.setEdu_certno_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_certno_2").trim()));
					applicationFormBean.setEdu_rollno_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_rollno_2").trim()));
					applicationFormBean.setEdu_date_issue_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_date_issue_2").trim()));
					applicationFormBean.setStream_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_2").trim()));
					applicationFormBean.setUniversity_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_2").trim()));
					applicationFormBean.setEdu_year_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_2").trim()));
					applicationFormBean.setEdu_marks_2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_2").trim()));
				}

				if (request.getParameter("exam_passed_3") != null) {
					applicationFormBean.setExam_passed_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exam_passed_3").trim()));
					applicationFormBean.setEdu_certno_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_certno_3").trim()));
					applicationFormBean.setEdu_rollno_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_rollno_3").trim()));
					applicationFormBean.setEdu_date_issue_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_date_issue_3").trim()));
					applicationFormBean.setStream_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_3").trim()));
					applicationFormBean.setUniversity_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_3").trim()));
					applicationFormBean.setEdu_year_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_3").trim()));
					applicationFormBean.setEdu_marks_3(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_3").trim()));
				}

				if (request.getParameter("exam_passed_4") != null) {
					applicationFormBean.setExam_passed_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exam_passed_4").trim()));
					applicationFormBean.setEdu_certno_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_certno_4").trim()));
					applicationFormBean.setEdu_rollno_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_rollno_4").trim()));
					applicationFormBean.setEdu_date_issue_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_date_issue_4").trim()));
					applicationFormBean.setStream_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_4").trim()));
					applicationFormBean.setUniversity_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_4").trim()));
					applicationFormBean.setEdu_year_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_4").trim()));
					applicationFormBean.setEdu_marks_4(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_4").trim()));
				}

				if (request.getParameter("exam_passed_5") != null) {
					applicationFormBean.setExam_passed_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exam_passed_5").trim()));
					applicationFormBean.setEdu_certno_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_certno_5").trim()));
					applicationFormBean.setEdu_rollno_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_rollno_5").trim()));
					applicationFormBean.setEdu_date_issue_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_date_issue_5").trim()));
					applicationFormBean.setStream_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_5").trim()));
					applicationFormBean.setUniversity_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_5").trim()));
					applicationFormBean.setEdu_year_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_5").trim()));
					applicationFormBean.setEdu_marks_5(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_5").trim()));
				}

				if (request.getParameter("exam_passed_plus2") != null) {
					applicationFormBean.setExam_passed_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("exam_passed_plus2").trim()));
					applicationFormBean.setEdu_certno_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_certno_plus2").trim()));
					applicationFormBean.setEdu_rollno_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_rollno_plus2").trim()));
					applicationFormBean.setEdu_date_issue_plus2(ESAPI.encoder()
							.encodeForHTMLAttribute(request.getParameter("edu_date_issue_plus2").trim()));
					applicationFormBean.setStream_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_plus2").trim()));
					applicationFormBean.setUniversity_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_plus2").trim()));
					applicationFormBean.setEdu_year_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_plus2").trim()));
					applicationFormBean.setEdu_marks_plus2(
							ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_plus2").trim()));
				}

				if (request.getParameter("skill_1") != null)
					applicationFormBean
							.setSkill_1(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_1").trim()));
				else
					applicationFormBean.setSkill_1("");

				if (request.getParameter("skill_2") != null)
					applicationFormBean
							.setSkill_2(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_2").trim()));
				else
					applicationFormBean.setSkill_2("");

				if (request.getParameter("skill_3") != null)
					applicationFormBean
							.setSkill_3(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_3").trim()));
				else
					applicationFormBean.setSkill_3("");

				if (request.getParameter("skill_4") != null)
					applicationFormBean
							.setSkill_4(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_4").trim()));
				else
					applicationFormBean.setSkill_4("");

				if (request.getParameter("skill_5") != null)
					applicationFormBean
							.setSkill_5(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_5").trim()));
				else
					applicationFormBean.setSkill_5("");

				if (request.getParameter("skill_6") != null)
					applicationFormBean
							.setSkill_6(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_6").trim()));
				else
					applicationFormBean.setSkill_6("");

				if (request.getParameter("skill_7") != null)
					applicationFormBean
							.setSkill_7(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_7").trim()));
				else
					applicationFormBean.setSkill_7("");

				if (request.getParameter("skill_8") != null)
					applicationFormBean
							.setSkill_8(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_8").trim()));
				else
					applicationFormBean.setSkill_8("");

				if (request.getParameter("skill_9") != null)
					applicationFormBean
							.setSkill_9(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_9").trim()));
				else
					applicationFormBean.setSkill_9("");

				applicationFormBean.setSkills_flag(Boolean
						.parseBoolean(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skills_flag"))));

				request.setAttribute("AcknoweledgementBean", applicationFormBean);
				rd = request.getRequestDispatcher("/pages/acknowledgement.jsp");
				rd.forward(request, res);
			} else {
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("AcknoweledgementServlet",
			// exceptionAsString, null,
			// request.getRemoteAddr(),request.getHeader("User-Agent"));
			// throw new UserDefineException("AcknoweledgementServlet",exceptionAsString);
		}
	}

}
