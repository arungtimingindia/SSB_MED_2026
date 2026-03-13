package com.ttil.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.util.StringUtils;

/**
 * @author Timing Technologies India Pvt Ltd
 * 
 *         This class defines The PreView page of submitted form
 *         All the properties will set to Bean and Bean object will save into
 *         session
 *         This class will validate some Constraints of the two Form page and
 *         Submit/set the data to the next jsp page.
 *         redirects to confirmdetails.jsp (Preview) page
 */

@MultipartConfig
public class ApplicationPreviewServlet extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;

	public void dopost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.service(req, res);
	}

	public void service(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ApplicationFormBean applicationFormBean = null;
		try {
			HttpSession session = request.getSession();
			if (session != null && session.isNew()) {
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			} else {
				String requestFrom = ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("requestFrom"));
				// System.out.println("requestFrom="+requestFrom);
				if (requestFrom != null && "apllicationform".equalsIgnoreCase(requestFrom)) {
					String requestAppForm = ESAPI.encoder()
							.encodeForHTMLAttribute((String) session.getAttribute("requestAppForm"));
					if (requestAppForm != null && "applicationForm".equalsIgnoreCase(requestAppForm)) {
						applicationFormBean = new ApplicationFormBean();
						applicationFormBean.setNoOfRequests(1);
						// LogsGeneration.generateAccessLogWithMobileNumber("ApplicationPreview",applicationFormBean.getMobileNumber(),
						// request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId());

						/** Page-5 Photo Uploads **/
						/*
						 * String imagesPath=request.getServletContext().getRealPath("candidateImages");
						 * //System.out.println("***** imagesPath: " + imagesPath);
						 * // Get part using HttpServletRequest�s getPart() method
						 * Part photoFilePart = request.getPart("photofileData");
						 * Part sigFilePart = request.getPart("sigfileData");
						 * // Extract image name from content-disposition header of part
						 * long lDateTime = new Date().getTime();
						 * // Copy input file to destination path
						 * String photoFileName=lDateTime+"_photo.jpg";
						 * String sigFileName=lDateTime+"_sig.jpg";
						 * this.savePhoto(imagesPath, photoFileName, photoFilePart);
						 * this.savePhoto(imagesPath, sigFileName, sigFilePart);
						 * 
						 * applicationFormBean.setPhotoFileName(photoFileName);
						 * applicationFormBean.setSigFileName(sigFileName);
						 */

						/** Page-1 Personal Details **/

						applicationFormBean.setFirst_name(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("first_name").trim()));
						applicationFormBean.setMiddle_name(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("middle_name").trim()));
						applicationFormBean.setLast_name(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("last_name").trim()));
						String fullname = "";
						if (applicationFormBean.getFirst_name() != null
								&& applicationFormBean.getFirst_name().length() >= 1)
							fullname = fullname + applicationFormBean.getFirst_name() + " ";
						if (applicationFormBean.getMiddle_name() != null
								&& applicationFormBean.getMiddle_name().length() >= 1)
							fullname = fullname + applicationFormBean.getMiddle_name() + " ";
						if (applicationFormBean.getLast_name() != null
								&& applicationFormBean.getLast_name().length() >= 1)
							fullname = fullname + applicationFormBean.getLast_name();

						applicationFormBean.setFullname(fullname.trim());
						applicationFormBean.setFather_name(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("father_name").trim()));
						applicationFormBean.setMother_name(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("mother_name").trim()));
						// applicationFormBean.setDomicile_state(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter(
						// "domicile_state" ).trim()));
						applicationFormBean.setPost_applied(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("post_applied").trim()));

						if (request.getParameter("marrital_status") != null)
							applicationFormBean.setMarrital_status(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("marrital_status").trim()));
						else
							applicationFormBean.setMarrital_status("");

						if (request.getParameter("nationality") != null)
							applicationFormBean.setNationality(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("nationality").trim()));
						else
							applicationFormBean.setNationality("");

						applicationFormBean.setAadharNo(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("aadharNo").trim()));
						applicationFormBean.setIdentity_type(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("identity_type").trim()));

						if (request.getParameter("sex") != null)
							applicationFormBean
									.setSex(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("sex").trim()));
						else
							applicationFormBean.setSex("");
						applicationFormBean
								.setDob(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("dob").trim()));
						if (request.getParameter("religion") != null)
							applicationFormBean.setReligion(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("religion").trim()));
						else
							applicationFormBean.setReligion("");

						if (request.getParameter("other_religion") != null)
							applicationFormBean.setOther_religion(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("other_religion").trim()));
						else
							applicationFormBean.setOther_religion("");

						if (request.getParameter("other_nationality") != null)
							applicationFormBean.setOther_nationality(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("other_nationality").trim()));
						else
							applicationFormBean.setOther_nationality("");

						applicationFormBean.setAge(Integer.parseInt(request.getParameter("age")));
						applicationFormBean.setIdentification_mark(ESAPI.encoder()
								.encodeForHTMLAttribute(request.getParameter("identification_mark").trim()));
						applicationFormBean.setMobileNumber(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("mobileNumber").trim()));
						applicationFormBean.setEmailaddress(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("emailaddress").trim()));

						if (request.getParameter("community") != null)
							applicationFormBean.setCommunity(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("community").trim()));
						else
							applicationFormBean.setCommunity("");

						if (request.getParameter("category") != null)
							applicationFormBean.setCategory(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("category").trim()));
						else
							applicationFormBean.setCategory("");

						if (request.getParameter("categoty_belongs") != null)
							applicationFormBean.setCategoty_belongsS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("categoty_belongs").trim()));
						else
							applicationFormBean.setCategoty_belongsS("");

						if (request.getParameter("jk_domiciled") != null)
							applicationFormBean.setJk_domiciledS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("jk_domiciled").trim()));
						else
							applicationFormBean.setJk_domiciledS("");

						if (request.getParameter("riots_affected") != null)
							applicationFormBean.setRiots_affectedS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_affected").trim()));
						else
							applicationFormBean.setRiots_affectedS("");

						if (request.getParameter("riots_gujarat") != null)
							applicationFormBean.setRiots_gujaratS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_gujarat").trim()));
						else
							applicationFormBean.setRiots_gujaratS("");

						if (request.getParameter("ex_serviceman") != null)
							applicationFormBean.setEx_servicemanS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("ex_serviceman").trim()));
						else
							applicationFormBean.setEx_servicemanS("");

						if (request.getParameter("employee_ssb") != null)
							applicationFormBean.setEmployee_ssbS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("employee_ssb").trim()));
						else
							applicationFormBean.setEmployee_ssbS("");

						if (request.getParameter("govt_service") != null)
							applicationFormBean.setGovt_serviceS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("govt_service").trim()));
						else
							applicationFormBean.setGovt_serviceS("");

						// System.err.println("request ): " + request.getParameter("nursing_council"));

						if (request.getParameter("hc_lab_asst_cert") != null) {
							applicationFormBean
									.setHcLabAsstCert(Boolean.parseBoolean(request.getParameter("hc_lab_asst_cert")));
						} else {
							applicationFormBean.setHcLabAsstCertValue("");
						}

						if (request.getParameter("hc_lab_asst_exp") != null) {
							applicationFormBean
									.setHcLabAsstExp(Boolean.parseBoolean(request.getParameter("hc_lab_asst_exp")));
						} else {
							applicationFormBean.setHcLabAsstExpValue("");
						}

						if (request.getParameter("hc_physio_asst_cert") != null) {
							applicationFormBean.setHcPhysioAsstCert(
									Boolean.parseBoolean(request.getParameter("hc_physio_asst_cert")));
						} else {
							applicationFormBean.setHcPhysioAsstCertValue("");
						}

						if (request.getParameter("hc_physio_asst_exp") != null) {
							applicationFormBean.setHcPhysioAsstExp(
									Boolean.parseBoolean(request.getParameter("hc_physio_asst_exp")));
						} else {
							applicationFormBean.setHcPhysioAsstExpValue("");
						}

						if (request.getParameter("ct_nursing_asst_cert") != null) {
							applicationFormBean.setCtNursingCert(
									Boolean.parseBoolean(request.getParameter("ct_nursing_asst_cert")));
						} else {
							applicationFormBean.setCtNursingCertValue("");
						}

						if (request.getParameter("ct_nursing_asst_exp") != null) {
							applicationFormBean
									.setCtNursingExp(Boolean.parseBoolean(request.getParameter("ct_nursing_asst_exp")));
						} else {
							applicationFormBean.setCtNursingExpValue("");
						}

						if (request.getParameter("nursing_council") != null) {
							applicationFormBean
									.setNursing_council(Boolean.parseBoolean(request.getParameter("nursing_council")));
						} else {
							applicationFormBean.setNurse("");
						}

						if (request.getParameter("hospital_experience") != null) {
							applicationFormBean.setHospital_experience(
									Boolean.parseBoolean(request.getParameter("hospital_experience")));
						} else {
							applicationFormBean.setHospital("");
						}

						if (request.getParameter("tradesmen_certificate") != null) {
							applicationFormBean.setTradesmen_certificate(
									Boolean.parseBoolean(request.getParameter("tradesmen_certificate")));
						} else {
							applicationFormBean.setTrade("");
						}

						if (request.getParameter("autocad_certificate") != null) {
							applicationFormBean.setAutocad_certificate(
									Boolean.parseBoolean(request.getParameter("autocad_certificate")));
						} else {
							applicationFormBean.setAutocad("");
						}

						if (request.getParameter("draughtsmanship_exp") != null) {
							applicationFormBean.setDraughtsmanship_exp(
									Boolean.parseBoolean(request.getParameter("draughtsmanship_exp")));
						} else {
							applicationFormBean.setDraft("");
						}

						applicationFormBean
								.setEmployee_ssb(Boolean.parseBoolean(applicationFormBean.getEmployee_ssbS()));
						applicationFormBean
								.setGovt_service(Boolean.parseBoolean(applicationFormBean.getGovt_serviceS()));
						applicationFormBean
								.setEx_serviceman(Boolean.parseBoolean(applicationFormBean.getEx_servicemanS()));
						applicationFormBean
								.setCategoty_belongs(Boolean.parseBoolean(applicationFormBean.getCategoty_belongsS()));
						applicationFormBean
								.setJk_domiciled(Boolean.parseBoolean(applicationFormBean.getJk_domiciledS()));
						applicationFormBean
								.setRiots_affected(Boolean.parseBoolean(applicationFormBean.getRiots_affectedS()));
						applicationFormBean
								.setRiots_gujarat(Boolean.parseBoolean(applicationFormBean.getRiots_gujaratS()));

						if (applicationFormBean.isCategoty_belongs()) {
							applicationFormBean.setCat_cert_no(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("cat_cert_no").trim()));
							applicationFormBean.setCat_date_Issue(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("cat_date_Issue").trim()));
							applicationFormBean.setCat_issue_authority(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("cat_issue_authority").trim()));
						}
						if (applicationFormBean.isJk_domiciled()) {
							applicationFormBean.setJk_cert_no(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("jk_cert_no").trim()));
							applicationFormBean.setJk_date_Issue(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("jk_date_Issue").trim()));
							applicationFormBean.setJk_issue_authority(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("jk_issue_authority").trim()));
						}
						if (applicationFormBean.isRiots_affected()) {
							applicationFormBean.setRiots_cert_no(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_cert_no").trim()));
							applicationFormBean.setRiots_date_Issue(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_date_Issue").trim()));
							applicationFormBean.setRiots_issue_authority(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_issue_authority").trim()));
						}
						if (applicationFormBean.isRiots_gujarat()) {
							applicationFormBean.setRiots_guj_cert_no(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_guj_cert_no").trim()));
							applicationFormBean.setRiots_guj_date_Issue(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_guj_date_Issue").trim()));
							applicationFormBean.setRiots_guj_issue_authority(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("riots_guj_issue_authority").trim()));
						}
						boolean payExempted = false;
						int fee_amount = 0;
						if ("Female".equalsIgnoreCase(applicationFormBean.getSex()))
							payExempted = true;
						if ("SC".equalsIgnoreCase(applicationFormBean.getCommunity()))
							payExempted = true;
						if ("ST".equalsIgnoreCase(applicationFormBean.getCommunity()))
							payExempted = true;

						/*
						 * if(applicationFormBean.getPost_applied().
						 * equalsIgnoreCase("Sub-Inspector (Communication)")){
						 * fee_amount=200;
						 * }else if(applicationFormBean.getPost_applied().
						 * equalsIgnoreCase("Assistant Sub-Inspector (Communication)")){
						 * fee_amount=100;
						 * }else if(applicationFormBean.getPost_applied().
						 * equalsIgnoreCase("Head Constable (Communication)")){
						 * fee_amount=100;
						 * }
						 */

						if (applicationFormBean.isEx_serviceman()) {
							payExempted = true;
							applicationFormBean.setExman_enrollment_date(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exman_enrollment_date").trim()));
							applicationFormBean.setExman_retirement_date(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exman_retirement_date").trim()));
							applicationFormBean.setExman_med_cat(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exman_med_cat").trim()));
							/*
							 * applicationFormBean.setExman_awd_dec(ESAPI.encoder().encodeForHTMLAttribute(
							 * request.getParameter("exman_awd_dec").trim()));
							 */
							applicationFormBean.setExman_discharge_reason(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exman_discharge_reason").trim()));
							if (request.getParameter("exman_edu_qual") != null)
								applicationFormBean.setExman_edu_qual(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("exman_edu_qual").trim()));
							else
								applicationFormBean.setExman_edu_qual("");
						}
						if (applicationFormBean.isEmployee_ssb()) {
							applicationFormBean.setEmp_date_since(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("emp_date_since").trim()));
							applicationFormBean.setPresent_employer(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("present_employer").trim()));
							applicationFormBean.setPost_held(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("post_held").trim()));
							applicationFormBean.setNocdesignation(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("nocdesignation").trim()));
						}
						if (applicationFormBean.isGovt_service()) {
							applicationFormBean.setEmp_date_since2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("emp_date_since2").trim()));
							applicationFormBean.setPresent_employer2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("present_employer2").trim()));
							applicationFormBean.setPost_held2(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("post_held2").trim()));
							applicationFormBean.setNocdesignation2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("nocdesignation2").trim()));
						}
						if (payExempted == true) {
							fee_amount = 0;
						} else {
							fee_amount = 100;
						}
						applicationFormBean.setFee_amount(fee_amount);
						applicationFormBean.setPayExempted(payExempted);

						/** Page-2 Education Qualification **/
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
						applicationFormBean.setEdu_date_issue_1(ESAPI.encoder()
								.encodeForHTMLAttribute(request.getParameter("edu_date_issue_1").trim()));
						applicationFormBean.setStream_1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_1").trim()));
						applicationFormBean.setUniversity_1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("university_1").trim()));
						applicationFormBean.setEdu_year_1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_1").trim()));
						applicationFormBean.setEdu_marks_1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_1").trim()));

						if (request.getParameter("exam_passed_2") != null) {
							applicationFormBean.setExam_passed_2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exam_passed_2").trim()));
							applicationFormBean.setEdu_certno_2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_certno_2").trim()));
							applicationFormBean.setEdu_rollno_2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_rollno_2").trim()));
							applicationFormBean.setEdu_date_issue_2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_date_issue_2").trim()));
							applicationFormBean.setStream_2(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_2").trim()));
							applicationFormBean.setUniversity_2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("university_2").trim()));
							applicationFormBean.setEdu_year_2(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_2").trim()));
							applicationFormBean.setEdu_marks_2(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_2").trim()));
						}

						if (request.getParameter("exam_passed_3") != null) {

							applicationFormBean.setExam_passed_3(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exam_passed_3").trim()));
							applicationFormBean.setEdu_certno_3(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_certno_3").trim()));
							applicationFormBean.setEdu_rollno_3(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_rollno_3").trim()));
							applicationFormBean.setEdu_date_issue_3(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_date_issue_3").trim()));
							applicationFormBean.setStream_3(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_3").trim()));
							applicationFormBean.setUniversity_3(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("university_3").trim()));
							applicationFormBean.setEdu_year_3(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_3").trim()));
							applicationFormBean.setEdu_marks_3(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_3").trim()));
						}

						if (request.getParameter("exam_passed_4") != null) {
							applicationFormBean.setExam_passed_4(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exam_passed_4").trim()));
							applicationFormBean.setEdu_certno_4(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_certno_4").trim()));
							applicationFormBean.setEdu_rollno_4(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_rollno_4").trim()));
							applicationFormBean.setEdu_date_issue_4(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_date_issue_4").trim()));
							applicationFormBean.setStream_4(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_4").trim()));
							applicationFormBean.setUniversity_4(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("university_4").trim()));
							applicationFormBean.setEdu_year_4(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_4").trim()));
							applicationFormBean.setEdu_marks_4(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_4").trim()));
						}

						if (request.getParameter("exam_passed_plus2") != null) {
							applicationFormBean.setExam_passed_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exam_passed_plus2").trim()));
							applicationFormBean.setEdu_certno_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_certno_plus2").trim()));
							applicationFormBean.setEdu_rollno_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_rollno_plus2").trim()));
							applicationFormBean.setEdu_date_issue_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_date_issue_plus2").trim()));
							applicationFormBean.setStream_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("stream_plus2").trim()));
							applicationFormBean.setUniversity_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("university_plus2").trim()));
							applicationFormBean.setEdu_year_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_year_plus2").trim()));
							applicationFormBean.setEdu_marks_plus2(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_marks_plus2").trim()));
						}

						if (request.getParameter("exam_passed_5") != null) {
							applicationFormBean.setExam_passed_5(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("exam_passed_5").trim()));
							applicationFormBean.setEdu_certno_5(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_certno_5").trim()));
							applicationFormBean.setEdu_rollno_5(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_rollno_5").trim()));
							applicationFormBean.setEdu_date_issue_5(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("edu_date_issue_5").trim()));
							applicationFormBean.setStream_5(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("stream_5").trim()));
							applicationFormBean.setUniversity_5(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("university_5").trim()));
							applicationFormBean.setEdu_year_5(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_year_5").trim()));
							applicationFormBean.setEdu_marks_5(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("edu_marks_5").trim()));
						}

						/*
						 * applicationFormBean.setExam_passed_3(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("exam_passed_3").trim()));
						 * applicationFormBean.setEdu_certno_3(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_certno_3").trim()));
						 * applicationFormBean.setEdu_rollno_3(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_rollno_3").trim()));
						 * applicationFormBean.setEdu_date_issue_3(ESAPI.encoder().
						 * encodeForHTMLAttribute(request.getParameter("edu_date_issue_3").trim()));
						 * applicationFormBean.setStream_3(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("stream_3").trim()));
						 * applicationFormBean.setUniversity_3(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("university_3").trim()));
						 * 
						 * applicationFormBean.setExam_passed_4(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("exam_passed_4").trim()));
						 * applicationFormBean.setEdu_certno_4(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_certno_4").trim()));
						 * applicationFormBean.setEdu_rollno_4(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_rollno_4").trim()));
						 * applicationFormBean.setEdu_date_issue_4(ESAPI.encoder().
						 * encodeForHTMLAttribute(request.getParameter("edu_date_issue_4").trim()));;
						 * applicationFormBean.setStream_4(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("stream_4").trim()));
						 * applicationFormBean.setUniversity_4(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("university_4").trim()));
						 * 
						 * applicationFormBean.setExam_passed_6(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("exam_passed_6").trim()));
						 * applicationFormBean.setEdu_certno_6(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_certno_6").trim()));
						 * applicationFormBean.setEdu_rollno_6(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_rollno_6").trim()));
						 * applicationFormBean.setEdu_date_issue_6(ESAPI.encoder().
						 * encodeForHTMLAttribute(request.getParameter("edu_date_issue_6").trim()));
						 * applicationFormBean.setStream_6(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("stream_6").trim()));
						 * applicationFormBean.setUniversity_6(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("university_6").trim()));
						 * 
						 * applicationFormBean.setExam_passed_7(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("exam_passed_7").trim()));
						 * applicationFormBean.setEdu_certno_7(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_certno_7").trim()));
						 * applicationFormBean.setEdu_rollno_7(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_rollno_7").trim()));
						 * applicationFormBean.setEdu_date_issue_7(ESAPI.encoder().
						 * encodeForHTMLAttribute(request.getParameter("edu_date_issue_7").trim()));
						 * applicationFormBean.setStream_7(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("stream_7").trim()));
						 * applicationFormBean.setUniversity_7(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("university_7").trim()));
						 */

						/*
						 * applicationFormBean.setEdu_marks_3(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_marks_3").trim()));
						 * applicationFormBean.setEdu_marks_4(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_marks_4").trim()));
						 * applicationFormBean.setEdu_marks_6(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_marks_6").trim()));
						 * applicationFormBean.setEdu_marks_7(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("edu_marks_7").trim()));
						 */
						/** Page-3 Address **/
						if (request.getParameter("correspondence_address") != null)
							applicationFormBean.setCorrespondence_addressS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("correspondence_address").trim()));
						else
							applicationFormBean.setCorrespondence_addressS("");

						applicationFormBean.setCorrespondence_address(
								Boolean.parseBoolean(applicationFormBean.getCorrespondence_addressS()));
						applicationFormBean.setVillage(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("village").trim()));
						applicationFormBean.setPostoffice(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("postoffice").trim()));
						applicationFormBean.setPolicestation(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("policestation").trim()));
						applicationFormBean.setTehsil(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("tehsil").trim()));
						applicationFormBean
								.setState(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("state").trim()));
						applicationFormBean.setDistrict(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("district").trim()));
						applicationFormBean.setPincode(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("pincode").trim()));

						applicationFormBean.setVillage1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("village1").trim()));
						applicationFormBean.setPostoffice1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("postoffice1").trim()));
						applicationFormBean.setPolicestation1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("policestation1").trim()));
						applicationFormBean.setTehsil1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("tehsil1").trim()));
						applicationFormBean.setState1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("state1").trim()));
						applicationFormBean.setDistrict1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("district1").trim()));
						applicationFormBean.setPincode1(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("pincode1").trim()));

						/** Page-4 Criminal Cases **/
						if (request.getParameter("debarment") != null)
							applicationFormBean.setDebarmentS(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("debarment").trim()));
						else
							applicationFormBean.setDebarmentS("");

						if (request.getParameter("fir_cases") != null)
							applicationFormBean.setFir_casesS(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("fir_cases").trim()));
						else
							applicationFormBean.setFir_casesS("");

						if (request.getParameter("fir_cases_pending") != null)
							applicationFormBean.setFir_cases_pendingS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("fir_cases_pending").trim()));
						else
							applicationFormBean.setFir_cases_pendingS("");

						if (request.getParameter("arrested") != null)
							applicationFormBean.setArrestedS(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("arrested").trim()));
						else
							applicationFormBean.setArrestedS("");

						if (request.getParameter("criminal_case_acquitted") != null)
							applicationFormBean.setCriminal_case_acquittedS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("criminal_case_acquitted").trim()));
						else
							applicationFormBean.setCriminal_case_acquittedS("");

						if (request.getParameter("good_behavior_bond") != null)
							applicationFormBean.setGood_behavior_bondS(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("good_behavior_bond").trim()));
						else
							applicationFormBean.setGood_behavior_bondS("");

						applicationFormBean.setGood_behavior_bond(
								Boolean.parseBoolean(applicationFormBean.getGood_behavior_bondS()));
						applicationFormBean.setFir_cases(Boolean.parseBoolean(applicationFormBean.getFir_casesS()));
						applicationFormBean.setFir_cases_pending(
								Boolean.parseBoolean(applicationFormBean.getFir_cases_pendingS()));
						applicationFormBean.setCriminal_case_acquitted(
								Boolean.parseBoolean(applicationFormBean.getCriminal_case_acquittedS()));
						applicationFormBean.setArrested(Boolean.parseBoolean(applicationFormBean.getArrestedS()));
						applicationFormBean.setDebarment(Boolean.parseBoolean(applicationFormBean.getDebarmentS()));

						applicationFormBean.setFirdate(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firdate").trim()));
						applicationFormBean.setFirdistrict(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firdistrict").trim()));
						applicationFormBean
								.setFirno(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firno").trim()));

						applicationFormBean.setFirsection(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firsection").trim()));
						/*
						 * if("Others".equalsIgnoreCase(applicationFormBean.getFirsection()))
						 * applicationFormBean.setFirsection(ESAPI.encoder().encodeForHTMLAttribute(
						 * request.getParameter("fir_other_section").trim()));
						 */ applicationFormBean.setFirstatus(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("firstatus").trim()));

						applicationFormBean.setExamorganizer(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("examorganizer").trim()));
						applicationFormBean.setExamname(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("examname").trim()));
						applicationFormBean.setExamdate(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("examdate").trim()));
						applicationFormBean.setDebarenddate(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("debarenddate").trim()));
						applicationFormBean.setDebar_reason(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("debar_reason").trim()));
						applicationFormBean.setOther_reason(
								ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("other_reason").trim()));

						int post_applied = Integer.parseInt(applicationFormBean.getPost_applied());

						if (post_applied == 12 || post_applied == 14 || post_applied == 16 || post_applied == 17
								|| post_applied == 19 || post_applied == 21 || post_applied == 23
								|| post_applied == 24 || post_applied == 25) {
							applicationFormBean.setSkills_flag(true);
							if (request.getParameter("skill_1") != null)
								applicationFormBean.setSkill_1(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_1").trim()));
							else
								applicationFormBean.setSkill_1("");

							if (request.getParameter("skill_2") != null)
								applicationFormBean.setSkill_2(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_2").trim()));
							else
								applicationFormBean.setSkill_2("");

							if (request.getParameter("skill_3") != null)
								applicationFormBean.setSkill_3(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_3").trim()));
							else
								applicationFormBean.setSkill_3("");

							if (request.getParameter("skill_4") != null)
								applicationFormBean.setSkill_4(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_4").trim()));
							else
								applicationFormBean.setSkill_4("");

							if (request.getParameter("skill_5") != null)
								applicationFormBean.setSkill_5(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_5").trim()));
							else
								applicationFormBean.setSkill_5("");

							if (request.getParameter("skill_6") != null)
								applicationFormBean.setSkill_6(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_6").trim()));
							else
								applicationFormBean.setSkill_6("");

							if (request.getParameter("skill_7") != null)
								applicationFormBean.setSkill_7(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_7").trim()));
							else
								applicationFormBean.setSkill_7("");

							if (request.getParameter("skill_8") != null)
								applicationFormBean.setSkill_8(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_8").trim()));
							else
								applicationFormBean.setSkill_8("");

							if (request.getParameter("skill_9") != null)
								applicationFormBean.setSkill_9(
										ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("skill_9").trim()));
							else
								applicationFormBean.setSkill_9("");
						} else {
							applicationFormBean.setSkill_1("");
							applicationFormBean.setSkill_2("");
							applicationFormBean.setSkill_3("");
							applicationFormBean.setSkill_4("");
							applicationFormBean.setSkill_5("");
							applicationFormBean.setSkill_6("");
							applicationFormBean.setSkill_7("");
							applicationFormBean.setSkill_8("");
							applicationFormBean.setSkill_9("");
							applicationFormBean.setSkills_flag(false);
						}

						if (post_applied == 7) {
							if (request.getParameter("qual_6_option_1") != null) {
								applicationFormBean.setQualification1(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_6_option_1").trim()));
								applicationFormBean
										.setQualification1_text("Matriculation or equivalent from a recognized Board");
							} else {
								applicationFormBean.setQualification1(null);
								applicationFormBean.setQualification1_text(null);
							}

							if (request.getParameter("qual_6_option_2") != null) {
								applicationFormBean.setQualification2(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_6_option_2").trim()));
								applicationFormBean
										.setQualification2_text("Must possess valid Heavy Vehicle Driving license. ");
							} else {
								applicationFormBean.setQualification2(null);
								applicationFormBean.setQualification2_text(null);
							}
						} else if (post_applied == 8) {
							if (request.getParameter("qual_7_option_1") != null) {
								applicationFormBean.setQualification1(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_7_option_1").trim()));
								applicationFormBean.setQualification1_text(
										"Matriculation with Science from a recognized Board or Institution");
							} else {
								applicationFormBean.setQualification1(null);
								applicationFormBean.setQualification1_text(null);
							}

							if (request.getParameter("qual_7_option_2") != null) {
								applicationFormBean.setQualification2(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_7_option_2").trim()));
								applicationFormBean.setQualification2_text(
										"Should have certificate in Laboratory Assistant Course from an Institution recognized by Central Government or State Government.");
							} else {
								applicationFormBean.setQualification2(null);
								applicationFormBean.setQualification2_text(null);
							}
						} else if (post_applied == 9) {
							if (request.getParameter("qual_8_option_1") != null) {
								applicationFormBean.setQualification1(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_8_option_1").trim()));
								applicationFormBean.setQualification1_text(
										"Tenth or Matriculation Examination Pass with Science as main subject from a recognized Board or University");
							} else {
								applicationFormBean.setQualification1(null);
								applicationFormBean.setQualification1_text(null);
							}

							if (request.getParameter("qual_8_option_2") != null) {
								applicationFormBean.setQualification2(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_8_option_2").trim()));
								applicationFormBean.setQualification2_text(
										"One year experience in treatment of different species of animals, in a recognized Veterinary Hospital.");
							} else {
								applicationFormBean.setQualification2(null);
								applicationFormBean.setQualification2_text(null);
							}
						} else if (post_applied == 11) {
							if (request.getParameter("qual_9_option_1") != null) {
								applicationFormBean.setQualification1(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_9_option_1").trim()));
								applicationFormBean.setQualification1_text(
										"Matriculation with science from a recognized Board or Institution");
							} else {
								applicationFormBean.setQualification1(null);
								applicationFormBean.setQualification1_text(null);
							}

							if (request.getParameter("qual_9_option_2") != null) {
								applicationFormBean.setQualification2(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_9_option_2").trim()));
								applicationFormBean.setQualification2_text(
										"Should possess First Aid Examination pass certificate from Red Cross Society or should be trained Dai.");
							} else {
								applicationFormBean.setQualification2(null);
								applicationFormBean.setQualification2_text(null);
							}

							if (request.getParameter("qual_9_option_3") != null) {
								applicationFormBean.setQualification3(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_9_option_3").trim()));
								applicationFormBean
										.setQualification3_text("Should have one-year experience in relevant field.");
							} else {
								applicationFormBean.setQualification3(null);
								applicationFormBean.setQualification3_text(null);
							}
						} else if (post_applied == 3 || post_applied == 10 || post_applied == 26 || post_applied == 27
								|| post_applied == 12 || post_applied == 14 || post_applied == 16 || post_applied == 17
								|| post_applied == 19 || post_applied == 21 || post_applied == 23
								|| post_applied == 24 || post_applied == 25) {

							if (request.getParameter("qual_3_option_1") != null) {
								applicationFormBean.setQualification1(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_3_option_1").trim()));
								applicationFormBean.setQualification1_text(
										"Matriculation pass or equivalent from a recognized Board");
							} else {
								applicationFormBean.setQualification1(null);
								applicationFormBean.setQualification1_text(null);
							}

							if (request.getParameter("qual_3_option_2") != null) {
								applicationFormBean.setQualification2(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_3_option_2").trim()));
								applicationFormBean
										.setQualification2_text("Two years work experience in respective trade");
							} else {
								applicationFormBean.setQualification2(null);
								applicationFormBean.setQualification2_text(null);
							}

							if (request.getParameter("qual_3_option_3") != null) {
								applicationFormBean.setQualification3(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_3_option_3").trim()));
								applicationFormBean.setQualification3_text(
										"One year certificate course from a recognized Industrial Training Institute or Vocational Institute with at least one year experience in the respective trade");
							} else {
								applicationFormBean.setQualification3(null);
								applicationFormBean.setQualification3_text(null);
							}

							if (request.getParameter("qual_3_option_4") != null) {
								applicationFormBean.setQualification4(ESAPI.encoder()
										.encodeForHTMLAttribute(request.getParameter("qual_3_option_4").trim()));
								applicationFormBean.setQualification4_text(
										"Two years Diploma from a recognized Industrial Training Institute in the respective trade or similar trade");
							} else {
								applicationFormBean.setQualification4(null);
								applicationFormBean.setQualification4_text(null);
							}

						}

						// String post_name= StringUtils.getPostName(post_applied);
						String post_name = StringUtils.getPostNameById(post_applied + "");
						// applicationFormBean.setPost_selected_name(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter(
						// "post_selected_name" ).trim()));
						applicationFormBean.setPost_selected_name(post_name);

						applicationFormBean.setMessage("");
						applicationFormBean.setMessage1("");
						if (request.getParameter("password") != null) {
							applicationFormBean.setPassword(
									ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("password").trim()));
							applicationFormBean.setConfirm_password(ESAPI.encoder()
									.encodeForHTMLAttribute(request.getParameter("confirm_password").trim()));
						} else {
							applicationFormBean.setMessage("Password is Empty, please set password");
						}

						List<String> messageOb = new ArrayList<String>();
						ServerSideSanitizationValidation serverSideSanitizationValidation = new ServerSideSanitizationValidation();
						serverSideSanitizationValidation.checkValidation(applicationFormBean, messageOb);
						if (messageOb != null && messageOb.size() > 0) {
							request.setAttribute("messageOb", messageOb);
						}

						session.setAttribute("ApplicationFormBean", applicationFormBean);
						rd = request.getRequestDispatcher("/pages/confirmdetails.jsp");
						rd.forward(request, res);
					} else {
						rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
						rd.forward(request, res);
					}
				} else {
					rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(request, res);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(applicationFormBean!=null)
			 * LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationPreview",
			 * exceptionAsString, applicationFormBean.getMobileNumber(),
			 * request.getRemoteAddr(),request.getHeader("User-Agent"));
			 * else
			 * LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationPreview",
			 * exceptionAsString, null,
			 * request.getRemoteAddr(),request.getHeader("User-Agent"));
			 * throw new UserDefineException("ApplicationPreview", exceptionAsString);
			 */
		}
	}

	// Extract image name from content-disposition header of part
	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		// System.out.println("***** partHeader: " + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	public void savePhoto(String imagesPath, String imageName, Part filePart) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			File outputFilePath = new File(imagesPath + File.separator + imageName);
			// System.out.println("***** outputFilePath: " +
			// outputFilePath.getAbsolutePath());
			inputStream = filePart.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);

			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
			// responseMessage = "Image Upload Failed!!";
		} catch (Exception e) {
			e.printStackTrace();
			// responseMessage = "Image Upload Failed!!";
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
