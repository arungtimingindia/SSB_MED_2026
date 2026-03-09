package com.ttil.bean;

import java.io.Serializable;

public class ApplicationFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152543486844793358L;
	
	private int transactionid=0;
	private String language=null;
	private String first_name=null;
	private String middle_name=null;
	private String last_name=null;
	private String fullname=null;
	private String father_name=null;
	private String mother_name=null;
	private String village=null;
	private String postoffice=null;
	
	private String nurse=null;
	private String hospital=null;
	private String trade=null;
	private String autocad=null;
	private String draft=null;
	
	private String tehsil=null;
	private String policestation =null;
	private String district=null;
	private String state=null;
	private String pincode=null;
	private String village1=null;
	private String postoffice1=null;
	private String tehsil1=null;
	private String policestation1=null;
	private String district1=null;
	private String state1=null;
	private String pincode1=null;
	private String mobileNumber=null;
	private String emailaddress=null;
	private String other_religion=null;
	private String religion=null;
	private String sex=null;
	private String category=null;
	private String community=null;
	private String dob=null;
	private String dob_name=null;
	private String identification_mark =null;
	private String date_created=null;
	private String ipAddress=null;
	private String bank_name=null;
	private String affected_cat_ids[]=null;
	private String affected_categories=null;
	private String affected_category_names=null;
	private boolean payExempted;
	private int fee_amount=0;
	private boolean ex_serviceman=false;
	private boolean employee_ssb=false;
	private boolean govt_service=false;
	
	private boolean nursing_council=false;
	private boolean draughtsmanship_exp = false;
	private boolean hospital_experience=false;
	private boolean tradesmen_certificate=false;
	private boolean autocad_certificate=false;
	
	private boolean correspondence_address=false;
	private boolean debarment=false;
	private boolean fir_cases=false;;
	private boolean fir_cases_pending=false;
	private boolean arrested=false;
	private boolean criminal_case_acquitted=false;
	private boolean good_behavior_bond=false;
	
	private String ex_servicemanS=null;;
	private String govt_serviceS=null;
	private String employee_ssbS=null;;
	private String correspondence_addressS=null;;
	private String debarmentS=null;;
	private String fir_casesS=null;;
	private String fir_cases_pendingS=null;;
	private String arrestedS=null;;
	private String criminal_case_acquittedS=null;
	private String good_behavior_bondS=null;
	
	private String exman_enrollment_date=null;
	private String exman_retirement_date=null;
	private String exman_enrollment_date_name=null;
	private String exman_retirement_date_name=null;
	private String exman_med_cat=null;
	private String exman_awd_dec=null;
	private String exman_discharge_reason=null;
	private String exman_edu_qual=null;
	
	private String firno=null;
	private String firdate=null;
	private String firsection=null;
	private String firdistrict=null;
	private String firstatus=null;
	
	private String present_employer=null;
	private String emp_date_since=null;
	private String post_held=null;
	private String nocdesignation=null;
	
	private String present_employer2=null;
	private String emp_date_since2=null;
	private String post_held2=null;
	private String nocdesignation2=null;
	
	private String exam_passed_1=null;
	private String edu_instistute_1=null;
	private String edu_subject_1=null;
	private String edu_marks_1=null;
	private String exam_passed_2=null;
	private String edu_instistute_2=null;
	private String edu_subject_2=null;
	private String edu_marks_2=null;
	private String exam_passed_3=null;
	private String edu_instistute_3=null;
	private String edu_subject_3=null;
	private String edu_marks_3=null;
	private String exam_passed_4=null;
	private String edu_instistute_4=null;
	private String edu_subject_4=null;
	private String edu_marks_4=null;
	
	private String exam_passed_5=null;
	private String exam_passed_6=null;
	private String edu_instistute_6=null;
	private String edu_subject_6=null;
	private String edu_marks_6=null;
	private String edu_marks_5=null;
	
	private String exam_passed_7=null;
	private String edu_instistute_7=null;
	private String edu_subject_7=null;
	private String edu_marks_7=null;
	
	private String stream_1=null;
	private String stream_2=null;
	private String stream_3=null;
	private String stream_4=null;
	private String stream_5=null;
	private String stream_6=null;
	private String stream_7=null;
	
	private String university_1=null;
	private String university_2=null;
	private String university_3=null;
	private String university_4=null;
	private String university_5=null;
	private String university_6=null;
	private String university_7=null;
	
	private String edu_year_1=null;
	private String edu_year_2=null;
	private String edu_year_3=null;
	private String edu_year_4=null;
	private String edu_year_5=null;
	private String edu_year_6=null;
	private String edu_year_7=null;
	
	private String edu_date_issue_1=null;
	private String edu_date_issue_2=null;
	private String edu_date_issue_3=null;
	private String edu_date_issue_4=null;
	private String edu_date_issue_5=null;
	private String edu_date_issue_6=null;
	private String edu_date_issue_7=null;
	
	private String edu_certno_1=null;
	private String edu_certno_2=null;
	private String edu_certno_3=null;
	private String edu_certno_4=null;
	private String edu_certno_5=null;
	private String edu_certno_6=null;
	private String edu_certno_7=null;
	
	private String edu_rollno_1=null;
	private String edu_rollno_2=null;
	private String edu_rollno_3=null;
	private String edu_rollno_4=null;
	private String edu_rollno_5=null;
	private String edu_rollno_6=null;
	private String edu_rollno_7=null;
	
	
	private boolean categoty_belongs=false;
	private boolean jk_domiciled=false;
	private boolean riots_affected=false;
	private boolean riots_gujarat=false;
	
	private String categoty_belongsS=null;
	private String cat_cert_no=null;
	private String cat_date_Issue=null;
	private String cat_issue_authority=null;
	
	private String jk_domiciledS=null;
	private String jk_cert_no=null;
	private String jk_date_Issue=null;
	private String jk_issue_authority=null;
	
	private String riots_affectedS=null;
	private String riots_cert_no=null;
	private String riots_date_Issue=null;
	private String riots_issue_authority=null;
	
	private String riots_gujaratS=null;
	private String riots_guj_cert_no=null;
	private String riots_guj_date_Issue=null;
	private String riots_guj_issue_authority=null;
	
	
	private String examorganizer=null;
	private String examname=null;
	private String examdate=null;
	private String debarenddate=null;
	private String debar_reason=null;
	private String other_reason=null;
	private String fir_other_section=null;
	
	
	private String post_applied=null;
	private String marrital_status=null;
	private String nationality=null;
	private String other_nationality=null;
	private String aadharNo=null;
	private String identity_type=null;
	
	private String domicile_state=null;
	
	private String inter_cert_no=null;
	private String inter_date_issue=null;
	private String matric_cert_no=null;
	private String matric_date_issue=null;
	private String diploma_institute=null;
	private String diploma_cert_no=null;
	private String diploma_date_issue=null;
	private String prof_institute=null;
	private String prof_cert_no=null;
	private String prof_date_issue=null;
	
	private String password=null;
	private String confirm_password=null;
	private String application_status=null;
	private String payment_status=null;
	private String application_final_status=null;
	
	private int noOfRequests=0;
	private int post_id=0;
	private int org_id=0;
	private int age=0;
	private String message=null;
	private String message1=null;
	private String edu_qual=null;
	public String post_selected_name=null;
	
	private String exam_passed_plus2=null;
	private String edu_instistute_plus2=null;
	private String edu_subject_plus2=null;
	private String edu_marks_plus2=null;
	private String edu_rollno_plus2=null;
	private String edu_date_issue_plus2=null;
	private String stream_plus2=null;
	private String university_plus2=null;
	private String edu_year_plus2=null;
	private String edu_certno_plus2=null;
	
	private String photoFileName=null;
	private String sigFileName=null;
	private String catFileName=null;
	private String comFileName=null;
	private String matricFileName=null;
	private String profQualFileName=null;
	private String identityFileName=null;
	
	private String skill_1=null;
	private String skill_2=null;
	private String skill_3=null;
	private String skill_4=null;
	private String skill_5=null;
	private String skill_6=null;
	private String skill_7=null;
	private String skill_8=null;
	private String skill_9=null;
	private String skills=null;
	private boolean skills_flag=false;
	
	private String qualification1=null;
	private String qualification2=null;
	private String qualification3=null;
	private String qualification4=null;
	
	private String qualification1_text=null;
	private String qualification2_text=null;
	private String qualification3_text=null;
	private String qualification4_text=null;
	private boolean post_change_eligible=false;
	private boolean is_rejected=false;
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPostoffice() {
		return postoffice;
	}
	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}
	public String getTehsil() {
		return tehsil;
	}
	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}
	public String getPolicestation() {
		return policestation;
	}
	public void setPolicestation(String policestation) {
		this.policestation = policestation;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getVillage1() {
		return village1;
	}
	public void setVillage1(String village1) {
		this.village1 = village1;
	}
	public String getPostoffice1() {
		return postoffice1;
	}
	public void setPostoffice1(String postoffice1) {
		this.postoffice1 = postoffice1;
	}
	public String getTehsil1() {
		return tehsil1;
	}
	public void setTehsil1(String tehsil1) {
		this.tehsil1 = tehsil1;
	}
	public String getPolicestation1() {
		return policestation1;
	}
	public void setPolicestation1(String policestation1) {
		this.policestation1 = policestation1;
	}
	public String getDistrict1() {
		return district1;
	}
	public void setDistrict1(String district1) {
		this.district1 = district1;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getPincode1() {
		return pincode1;
	}
	public void setPincode1(String pincode1) {
		this.pincode1 = pincode1;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getOther_religion() {
		return other_religion;
	}
	public void setOther_religion(String other_religion) {
		this.other_religion = other_religion;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDob_name() {
		return dob_name;
	}
	public void setDob_name(String dob_name) {
		this.dob_name = dob_name;
	}
	public String getIdentification_mark() {
		return identification_mark;
	}
	public void setIdentification_mark(String identification_mark) {
		this.identification_mark = identification_mark;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String[] getAffected_cat_ids() {
		return affected_cat_ids;
	}
	public void setAffected_cat_ids(String[] affected_cat_ids) {
		this.affected_cat_ids = affected_cat_ids;
	}
	public String getAffected_categories() {
		return affected_categories;
	}
	public void setAffected_categories(String affected_categories) {
		this.affected_categories = affected_categories;
	}
	public String getAffected_category_names() {
		return affected_category_names;
	}
	public void setAffected_category_names(String affected_category_names) {
		this.affected_category_names = affected_category_names;
	}
	public boolean isPayExempted() {
		return payExempted;
	}
	public void setPayExempted(boolean payExempted) {
		this.payExempted = payExempted;
	}
	public boolean isEx_serviceman() {
		return ex_serviceman;
	}
	public void setEx_serviceman(boolean ex_serviceman) {
		this.ex_serviceman = ex_serviceman;
	}
	public boolean isEmployee_ssb() {
		return employee_ssb;
	}
	public void setEmployee_ssb(boolean employee_ssb) {
		this.employee_ssb = employee_ssb;
	}
	public boolean isGovt_service() {
		return govt_service;
	}
	public void setGovt_service(boolean govt_service) {
		this.govt_service = govt_service;
	}
	public boolean isCorrespondence_address() {
		return correspondence_address;
	}
	public void setCorrespondence_address(boolean correspondence_address) {
		this.correspondence_address = correspondence_address;
	}
	public boolean isDebarment() {
		return debarment;
	}
	public void setDebarment(boolean debarment) {
		this.debarment = debarment;
	}
	public boolean isFir_cases() {
		return fir_cases;
	}
	public void setFir_cases(boolean fir_cases) {
		this.fir_cases = fir_cases;
	}
	public boolean isFir_cases_pending() {
		return fir_cases_pending;
	}
	public void setFir_cases_pending(boolean fir_cases_pending) {
		this.fir_cases_pending = fir_cases_pending;
	}
	public boolean isArrested() {
		return arrested;
	}
	public void setArrested(boolean arrested) {
		this.arrested = arrested;
	}
	public boolean isCriminal_case_acquitted() {
		return criminal_case_acquitted;
	}
	public void setCriminal_case_acquitted(boolean criminal_case_acquitted) {
		this.criminal_case_acquitted = criminal_case_acquitted;
	}
	public boolean isGood_behavior_bond() {
		return good_behavior_bond;
	}
	public void setGood_behavior_bond(boolean good_behavior_bond) {
		this.good_behavior_bond = good_behavior_bond;
	}
	public String getEx_servicemanS() {
		return ex_servicemanS;
	}
	public void setEx_servicemanS(String ex_servicemanS) {
		this.ex_servicemanS = ex_servicemanS;
	}
	public String getGovt_serviceS() {
		return govt_serviceS;
	}
	public void setGovt_serviceS(String govt_serviceS) {
		this.govt_serviceS = govt_serviceS;
	}
	public String getEmployee_ssbS() {
		return employee_ssbS;
	}
	public void setEmployee_ssbS(String employee_ssbS) {
		this.employee_ssbS = employee_ssbS;
	}
	public String getCorrespondence_addressS() {
		return correspondence_addressS;
	}
	public void setCorrespondence_addressS(String correspondence_addressS) {
		this.correspondence_addressS = correspondence_addressS;
	}
	public String getDebarmentS() {
		return debarmentS;
	}
	public void setDebarmentS(String debarmentS) {
		this.debarmentS = debarmentS;
	}
	public String getFir_casesS() {
		return fir_casesS;
	}
	public void setFir_casesS(String fir_casesS) {
		this.fir_casesS = fir_casesS;
	}
	public String getFir_cases_pendingS() {
		return fir_cases_pendingS;
	}
	public void setFir_cases_pendingS(String fir_cases_pendingS) {
		this.fir_cases_pendingS = fir_cases_pendingS;
	}
	public String getArrestedS() {
		return arrestedS;
	}
	public void setArrestedS(String arrestedS) {
		this.arrestedS = arrestedS;
	}
	public String getCriminal_case_acquittedS() {
		return criminal_case_acquittedS;
	}
	public void setCriminal_case_acquittedS(String criminal_case_acquittedS) {
		this.criminal_case_acquittedS = criminal_case_acquittedS;
	}
	public String getGood_behavior_bondS() {
		return good_behavior_bondS;
	}
	public void setGood_behavior_bondS(String good_behavior_bondS) {
		this.good_behavior_bondS = good_behavior_bondS;
	}
	public String getExman_enrollment_date() {
		return exman_enrollment_date;
	}
	public void setExman_enrollment_date(String exman_enrollment_date) {
		this.exman_enrollment_date = exman_enrollment_date;
	}
	public String getExman_retirement_date() {
		return exman_retirement_date;
	}
	public void setExman_retirement_date(String exman_retirement_date) {
		this.exman_retirement_date = exman_retirement_date;
	}
	public String getExman_enrollment_date_name() {
		return exman_enrollment_date_name;
	}
	public void setExman_enrollment_date_name(String exman_enrollment_date_name) {
		this.exman_enrollment_date_name = exman_enrollment_date_name;
	}
	public String getExman_retirement_date_name() {
		return exman_retirement_date_name;
	}
	public void setExman_retirement_date_name(String exman_retirement_date_name) {
		this.exman_retirement_date_name = exman_retirement_date_name;
	}
	public String getExman_med_cat() {
		return exman_med_cat;
	}
	public void setExman_med_cat(String exman_med_cat) {
		this.exman_med_cat = exman_med_cat;
	}
	public String getExman_awd_dec() {
		return exman_awd_dec;
	}
	public void setExman_awd_dec(String exman_awd_dec) {
		this.exman_awd_dec = exman_awd_dec;
	}
	public String getExman_discharge_reason() {
		return exman_discharge_reason;
	}
	public void setExman_discharge_reason(String exman_discharge_reason) {
		this.exman_discharge_reason = exman_discharge_reason;
	}
	public String getFirno() {
		return firno;
	}
	public void setFirno(String firno) {
		this.firno = firno;
	}
	public String getFirdate() {
		return firdate;
	}
	public void setFirdate(String firdate) {
		this.firdate = firdate;
	}
	public String getFirsection() {
		return firsection;
	}
	public void setFirsection(String firsection) {
		this.firsection = firsection;
	}
	public String getFirdistrict() {
		return firdistrict;
	}
	public void setFirdistrict(String firdistrict) {
		this.firdistrict = firdistrict;
	}
	public String getFirstatus() {
		return firstatus;
	}
	public void setFirstatus(String firstatus) {
		this.firstatus = firstatus;
	}
	public int getNoOfRequests() {
		return noOfRequests;
	}
	public void setNoOfRequests(int noOfRequests) {
		this.noOfRequests = noOfRequests;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	public String getExman_edu_qual() {
		return exman_edu_qual;
	}
	public void setExman_edu_qual(String exman_edu_qual) {
		this.exman_edu_qual = exman_edu_qual;
	}
	public String getPresent_employer() {
		return present_employer;
	}
	public void setPresent_employer(String present_employer) {
		this.present_employer = present_employer;
	}
	public String getEmp_date_since() {
		return emp_date_since;
	}
	public void setEmp_date_since(String emp_date_since) {
		this.emp_date_since = emp_date_since;
	}
	public String getPost_held() {
		return post_held;
	}
	public void setPost_held(String post_held) {
		this.post_held = post_held;
	}
	public String getNocdesignation() {
		return nocdesignation;
	}
	public void setNocdesignation(String nocdesignation) {
		this.nocdesignation = nocdesignation;
	}
	public String getExam_passed_1() {
		return exam_passed_1;
	}
	public void setExam_passed_1(String exam_passed_1) {
		this.exam_passed_1 = exam_passed_1;
	}
	public String getEdu_instistute_1() {
		return edu_instistute_1;
	}
	public void setEdu_instistute_1(String edu_instistute_1) {
		this.edu_instistute_1 = edu_instistute_1;
	}
	public String getEdu_subject_1() {
		return edu_subject_1;
	}
	public void setEdu_subject_1(String edu_subject_1) {
		this.edu_subject_1 = edu_subject_1;
	}
	public String getEdu_marks_1() {
		return edu_marks_1;
	}
	public void setEdu_marks_1(String edu_marks_1) {
		this.edu_marks_1 = edu_marks_1;
	}
	public String getExam_passed_2() {
		return exam_passed_2;
	}
	public void setExam_passed_2(String exam_passed_2) {
		this.exam_passed_2 = exam_passed_2;
	}
	public String getEdu_instistute_2() {
		return edu_instistute_2;
	}
	public void setEdu_instistute_2(String edu_instistute_2) {
		this.edu_instistute_2 = edu_instistute_2;
	}
	public String getEdu_subject_2() {
		return edu_subject_2;
	}
	public void setEdu_subject_2(String edu_subject_2) {
		this.edu_subject_2 = edu_subject_2;
	}
	public String getEdu_marks_2() {
		return edu_marks_2;
	}
	public void setEdu_marks_2(String edu_marks_2) {
		this.edu_marks_2 = edu_marks_2;
	}
	public String getExam_passed_3() {
		return exam_passed_3;
	}
	public void setExam_passed_3(String exam_passed_3) {
		this.exam_passed_3 = exam_passed_3;
	}
	public String getEdu_instistute_3() {
		return edu_instistute_3;
	}
	public void setEdu_instistute_3(String edu_instistute_3) {
		this.edu_instistute_3 = edu_instistute_3;
	}
	public String getEdu_subject_3() {
		return edu_subject_3;
	}
	public void setEdu_subject_3(String edu_subject_3) {
		this.edu_subject_3 = edu_subject_3;
	}
	public String getEdu_marks_3() {
		return edu_marks_3;
	}
	public void setEdu_marks_3(String edu_marks_3) {
		this.edu_marks_3 = edu_marks_3;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getSigFileName() {
		return sigFileName;
	}
	public void setSigFileName(String sigFileName) {
		this.sigFileName = sigFileName;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getExamorganizer() {
		return examorganizer;
	}
	public void setExamorganizer(String examorganizer) {
		this.examorganizer = examorganizer;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getExamdate() {
		return examdate;
	}
	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}
	public String getDebarenddate() {
		return debarenddate;
	}
	public void setDebarenddate(String debarenddate) {
		this.debarenddate = debarenddate;
	}
	public String getDebar_reason() {
		return debar_reason;
	}
	public void setDebar_reason(String debar_reason) {
		this.debar_reason = debar_reason;
	}
	public String getOther_reason() {
		return other_reason;
	}
	public void setOther_reason(String other_reason) {
		this.other_reason = other_reason;
	}
	public String getFir_other_section() {
		return fir_other_section;
	}
	public void setFir_other_section(String fir_other_section) {
		this.fir_other_section = fir_other_section;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEdu_qual() {
		return edu_qual;
	}
	public void setEdu_qual(String edu_qual) {
		this.edu_qual = edu_qual;
	}
	public String getExam_passed_4() {
		return exam_passed_4;
	}
	public void setExam_passed_4(String exam_passed_4) {
		this.exam_passed_4 = exam_passed_4;
	}
	public String getEdu_instistute_4() {
		return edu_instistute_4;
	}
	public void setEdu_instistute_4(String edu_instistute_4) {
		this.edu_instistute_4 = edu_instistute_4;
	}
	public String getEdu_subject_4() {
		return edu_subject_4;
	}
	public void setEdu_subject_4(String edu_subject_4) {
		this.edu_subject_4 = edu_subject_4;
	}
	public String getEdu_marks_4() {
		return edu_marks_4;
	}
	public void setEdu_marks_4(String edu_marks_4) {
		this.edu_marks_4 = edu_marks_4;
	}
	public String getPost_applied() {
		return post_applied;
	}
	public void setPost_applied(String post_applied) {
		this.post_applied = post_applied;
	}
	public String getMarrital_status() {
		return marrital_status;
	}
	public void setMarrital_status(String marrital_status) {
		this.marrital_status = marrital_status;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getDomicile_state() {
		return domicile_state;
	}
	public void setDomicile_state(String domicile_state) {
		this.domicile_state = domicile_state;
	}
	public String getInter_cert_no() {
		return inter_cert_no;
	}
	public void setInter_cert_no(String inter_cert_no) {
		this.inter_cert_no = inter_cert_no;
	}
	public String getInter_date_issue() {
		return inter_date_issue;
	}
	public void setInter_date_issue(String inter_date_issue) {
		this.inter_date_issue = inter_date_issue;
	}
	public String getMatric_cert_no() {
		return matric_cert_no;
	}
	public void setMatric_cert_no(String matric_cert_no) {
		this.matric_cert_no = matric_cert_no;
	}
	public String getMatric_date_issue() {
		return matric_date_issue;
	}
	public void setMatric_date_issue(String matric_date_issue) {
		this.matric_date_issue = matric_date_issue;
	}
	public String getDiploma_institute() {
		return diploma_institute;
	}
	public void setDiploma_institute(String diploma_institute) {
		this.diploma_institute = diploma_institute;
	}
	public String getDiploma_cert_no() {
		return diploma_cert_no;
	}
	public void setDiploma_cert_no(String diploma_cert_no) {
		this.diploma_cert_no = diploma_cert_no;
	}
	public String getDiploma_date_issue() {
		return diploma_date_issue;
	}
	public void setDiploma_date_issue(String diploma_date_issue) {
		this.diploma_date_issue = diploma_date_issue;
	}
	public String getProf_institute() {
		return prof_institute;
	}
	public void setProf_institute(String prof_institute) {
		this.prof_institute = prof_institute;
	}
	public String getProf_cert_no() {
		return prof_cert_no;
	}
	public void setProf_cert_no(String prof_cert_no) {
		this.prof_cert_no = prof_cert_no;
	}
	public String getProf_date_issue() {
		return prof_date_issue;
	}
	public void setProf_date_issue(String prof_date_issue) {
		this.prof_date_issue = prof_date_issue;
	}
	public String getApplication_status() {
		return application_status;
	}
	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}
	public String getExam_passed_6() {
		return exam_passed_6;
	}
	public void setExam_passed_6(String exam_passed_6) {
		this.exam_passed_6 = exam_passed_6;
	}
	public String getEdu_instistute_6() {
		return edu_instistute_6;
	}
	public void setEdu_instistute_6(String edu_instistute_6) {
		this.edu_instistute_6 = edu_instistute_6;
	}
	public String getEdu_subject_6() {
		return edu_subject_6;
	}
	public void setEdu_subject_6(String edu_subject_6) {
		this.edu_subject_6 = edu_subject_6;
	}
	public String getEdu_marks_6() {
		return edu_marks_6;
	}
	public void setEdu_marks_6(String edu_marks_6) {
		this.edu_marks_6 = edu_marks_6;
	}
	public String getExam_passed_7() {
		return exam_passed_7;
	}
	public void setExam_passed_7(String exam_passed_7) {
		this.exam_passed_7 = exam_passed_7;
	}
	public String getEdu_instistute_7() {
		return edu_instistute_7;
	}
	public void setEdu_instistute_7(String edu_instistute_7) {
		this.edu_instistute_7 = edu_instistute_7;
	}
	public String getEdu_subject_7() {
		return edu_subject_7;
	}
	public void setEdu_subject_7(String edu_subject_7) {
		this.edu_subject_7 = edu_subject_7;
	}
	public String getEdu_marks_7() {
		return edu_marks_7;
	}
	public void setEdu_marks_7(String edu_marks_7) {
		this.edu_marks_7 = edu_marks_7;
	}
	public String getStream_1() {
		return stream_1;
	}
	public void setStream_1(String stream_1) {
		this.stream_1 = stream_1;
	}
	public String getStream_2() {
		return stream_2;
	}
	public void setStream_2(String stream_2) {
		this.stream_2 = stream_2;
	}
	public String getStream_3() {
		return stream_3;
	}
	public void setStream_3(String stream_3) {
		this.stream_3 = stream_3;
	}
	public String getStream_4() {
		return stream_4;
	}
	public void setStream_4(String stream_4) {
		this.stream_4 = stream_4;
	}
	public String getStream_5() {
		return stream_5;
	}
	public void setStream_5(String stream_5) {
		this.stream_5 = stream_5;
	}
	public String getStream_6() {
		return stream_6;
	}
	public void setStream_6(String stream_6) {
		this.stream_6 = stream_6;
	}
	public String getStream_7() {
		return stream_7;
	}
	public void setStream_7(String stream_7) {
		this.stream_7 = stream_7;
	}
	public String getUniversity_1() {
		return university_1;
	}
	public void setUniversity_1(String university_1) {
		this.university_1 = university_1;
	}
	public String getUniversity_2() {
		return university_2;
	}
	public void setUniversity_2(String university_2) {
		this.university_2 = university_2;
	}
	public String getUniversity_3() {
		return university_3;
	}
	public void setUniversity_3(String university_3) {
		this.university_3 = university_3;
	}
	public String getUniversity_4() {
		return university_4;
	}
	public void setUniversity_4(String university_4) {
		this.university_4 = university_4;
	}
	public String getUniversity_5() {
		return university_5;
	}
	public void setUniversity_5(String university_5) {
		this.university_5 = university_5;
	}
	public String getUniversity_6() {
		return university_6;
	}
	public void setUniversity_6(String university_6) {
		this.university_6 = university_6;
	}
	public String getUniversity_7() {
		return university_7;
	}
	public void setUniversity_7(String university_7) {
		this.university_7 = university_7;
	}
	public String getEdu_year_1() {
		return edu_year_1;
	}
	public void setEdu_year_1(String edu_year_1) {
		this.edu_year_1 = edu_year_1;
	}
	public String getEdu_year_2() {
		return edu_year_2;
	}
	public void setEdu_year_2(String edu_year_2) {
		this.edu_year_2 = edu_year_2;
	}
	public String getEdu_year_3() {
		return edu_year_3;
	}
	public void setEdu_year_3(String edu_year_3) {
		this.edu_year_3 = edu_year_3;
	}
	public String getEdu_year_4() {
		return edu_year_4;
	}
	public void setEdu_year_4(String edu_year_4) {
		this.edu_year_4 = edu_year_4;
	}
	public String getEdu_year_5() {
		return edu_year_5;
	}
	public void setEdu_year_5(String edu_year_5) {
		this.edu_year_5 = edu_year_5;
	}
	public String getEdu_year_6() {
		return edu_year_6;
	}
	public void setEdu_year_6(String edu_year_6) {
		this.edu_year_6 = edu_year_6;
	}
	public String getEdu_year_7() {
		return edu_year_7;
	}
	public void setEdu_year_7(String edu_year_7) {
		this.edu_year_7 = edu_year_7;
	}
	public String getEdu_date_issue_1() {
		return edu_date_issue_1;
	}
	public void setEdu_date_issue_1(String edu_date_issue_1) {
		this.edu_date_issue_1 = edu_date_issue_1;
	}
	public String getEdu_date_issue_2() {
		return edu_date_issue_2;
	}
	public void setEdu_date_issue_2(String edu_date_issue_2) {
		this.edu_date_issue_2 = edu_date_issue_2;
	}
	public String getEdu_date_issue_3() {
		return edu_date_issue_3;
	}
	public void setEdu_date_issue_3(String edu_date_issue_3) {
		this.edu_date_issue_3 = edu_date_issue_3;
	}
	public String getEdu_date_issue_4() {
		return edu_date_issue_4;
	}
	public void setEdu_date_issue_4(String edu_date_issue_4) {
		this.edu_date_issue_4 = edu_date_issue_4;
	}
	public String getEdu_date_issue_5() {
		return edu_date_issue_5;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEdu_date_issue_5(String edu_date_issue_5) {
		this.edu_date_issue_5 = edu_date_issue_5;
	}
	public String getEdu_date_issue_6() {
		return edu_date_issue_6;
	}
	public void setEdu_date_issue_6(String edu_date_issue_6) {
		this.edu_date_issue_6 = edu_date_issue_6;
	}
	public String getEdu_date_issue_7() {
		return edu_date_issue_7;
	}
	public void setEdu_date_issue_7(String edu_date_issue_7) {
		this.edu_date_issue_7 = edu_date_issue_7;
	}
	public String getEdu_certno_1() {
		return edu_certno_1;
	}
	public void setEdu_certno_1(String edu_certno_1) {
		this.edu_certno_1 = edu_certno_1;
	}
	public String getEdu_certno_2() {
		return edu_certno_2;
	}
	public void setEdu_certno_2(String edu_certno_2) {
		this.edu_certno_2 = edu_certno_2;
	}
	public String getEdu_certno_3() {
		return edu_certno_3;
	}
	public void setEdu_certno_3(String edu_certno_3) {
		this.edu_certno_3 = edu_certno_3;
	}
	public String getEdu_certno_4() {
		return edu_certno_4;
	}
	public void setEdu_certno_4(String edu_certno_4) {
		this.edu_certno_4 = edu_certno_4;
	}
	public String getEdu_certno_5() {
		return edu_certno_5;
	}
	public void setEdu_certno_5(String edu_certno_5) {
		this.edu_certno_5 = edu_certno_5;
	}
	public String getEdu_certno_6() {
		return edu_certno_6;
	}
	public void setEdu_certno_6(String edu_certno_6) {
		this.edu_certno_6 = edu_certno_6;
	}
	public String getEdu_certno_7() {
		return edu_certno_7;
	}
	public void setEdu_certno_7(String edu_certno_7) {
		this.edu_certno_7 = edu_certno_7;
	}
	public String getEdu_rollno_1() {
		return edu_rollno_1;
	}
	public void setEdu_rollno_1(String edu_rollno_1) {
		this.edu_rollno_1 = edu_rollno_1;
	}
	public String getEdu_rollno_2() {
		return edu_rollno_2;
	}
	public void setEdu_rollno_2(String edu_rollno_2) {
		this.edu_rollno_2 = edu_rollno_2;
	}
	public String getEdu_rollno_3() {
		return edu_rollno_3;
	}
	public void setEdu_rollno_3(String edu_rollno_3) {
		this.edu_rollno_3 = edu_rollno_3;
	}
	public String getEdu_rollno_4() {
		return edu_rollno_4;
	}
	public void setEdu_rollno_4(String edu_rollno_4) {
		this.edu_rollno_4 = edu_rollno_4;
	}
	public String getEdu_rollno_5() {
		return edu_rollno_5;
	}
	public void setEdu_rollno_5(String edu_rollno_5) {
		this.edu_rollno_5 = edu_rollno_5;
	}
	public String getEdu_rollno_6() {
		return edu_rollno_6;
	}
	public void setEdu_rollno_6(String edu_rollno_6) {
		this.edu_rollno_6 = edu_rollno_6;
	}
	public String getEdu_rollno_7() {
		return edu_rollno_7;
	}
	public void setEdu_rollno_7(String edu_rollno_7) {
		this.edu_rollno_7 = edu_rollno_7;
	}
	public boolean isCategoty_belongs() {
		return categoty_belongs;
	}
	public void setCategoty_belongs(boolean categoty_belongs) {
		this.categoty_belongs = categoty_belongs;
	}
	public boolean isJk_domiciled() {
		return jk_domiciled;
	}
	public void setJk_domiciled(boolean jk_domiciled) {
		this.jk_domiciled = jk_domiciled;
	}
	public boolean isRiots_affected() {
		return riots_affected;
	}
	public void setRiots_affected(boolean riots_affected) {
		this.riots_affected = riots_affected;
	}
	public boolean isRiots_gujarat() {
		return riots_gujarat;
	}
	public void setRiots_gujarat(boolean riots_gujarat) {
		this.riots_gujarat = riots_gujarat;
	}
	public String getCategoty_belongsS() {
		return categoty_belongsS;
	}
	public void setCategoty_belongsS(String categoty_belongsS) {
		this.categoty_belongsS = categoty_belongsS;
	}
	public String getCat_cert_no() {
		return cat_cert_no;
	}
	public void setCat_cert_no(String cat_cert_no) {
		this.cat_cert_no = cat_cert_no;
	}
	public String getCat_date_Issue() {
		return cat_date_Issue;
	}
	public void setCat_date_Issue(String cat_date_Issue) {
		this.cat_date_Issue = cat_date_Issue;
	}
	public String getCat_issue_authority() {
		return cat_issue_authority;
	}
	public void setCat_issue_authority(String cat_issue_authority) {
		this.cat_issue_authority = cat_issue_authority;
	}
	public String getJk_domiciledS() {
		return jk_domiciledS;
	}
	public void setJk_domiciledS(String jk_domiciledS) {
		this.jk_domiciledS = jk_domiciledS;
	}
	public String getJk_cert_no() {
		return jk_cert_no;
	}
	public void setJk_cert_no(String jk_cert_no) {
		this.jk_cert_no = jk_cert_no;
	}
	public String getJk_date_Issue() {
		return jk_date_Issue;
	}
	public void setJk_date_Issue(String jk_date_Issue) {
		this.jk_date_Issue = jk_date_Issue;
	}
	public String getJk_issue_authority() {
		return jk_issue_authority;
	}
	public void setJk_issue_authority(String jk_issue_authority) {
		this.jk_issue_authority = jk_issue_authority;
	}
	public String getRiots_affectedS() {
		return riots_affectedS;
	}
	public void setRiots_affectedS(String riots_affectedS) {
		this.riots_affectedS = riots_affectedS;
	}
	public String getRiots_cert_no() {
		return riots_cert_no;
	}
	public void setRiots_cert_no(String riots_cert_no) {
		this.riots_cert_no = riots_cert_no;
	}
	public String getRiots_date_Issue() {
		return riots_date_Issue;
	}
	public void setRiots_date_Issue(String riots_date_Issue) {
		this.riots_date_Issue = riots_date_Issue;
	}
	public String getRiots_issue_authority() {
		return riots_issue_authority;
	}
	public void setRiots_issue_authority(String riots_issue_authority) {
		this.riots_issue_authority = riots_issue_authority;
	}
	public String getRiots_gujaratS() {
		return riots_gujaratS;
	}
	public void setRiots_gujaratS(String riots_gujaratS) {
		this.riots_gujaratS = riots_gujaratS;
	}
	public String getRiots_guj_cert_no() {
		return riots_guj_cert_no;
	}
	public void setRiots_guj_cert_no(String riots_guj_cert_no) {
		this.riots_guj_cert_no = riots_guj_cert_no;
	}
	public String getRiots_guj_date_Issue() {
		return riots_guj_date_Issue;
	}
	public void setRiots_guj_date_Issue(String riots_guj_date_Issue) {
		this.riots_guj_date_Issue = riots_guj_date_Issue;
	}
	public String getRiots_guj_issue_authority() {
		return riots_guj_issue_authority;
	}
	public void setRiots_guj_issue_authority(String riots_guj_issue_authority) {
		this.riots_guj_issue_authority = riots_guj_issue_authority;
	}
	public int getFee_amount() {
		return fee_amount;
	}
	public void setFee_amount(int fee_amount) {
		this.fee_amount = fee_amount;
	}
	public String getOther_nationality() {
		return other_nationality;
	}
	public void setOther_nationality(String other_nationality) {
		this.other_nationality = other_nationality;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getIdentity_type() {
		return identity_type;
	}
	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}
	public String getApplication_final_status() {
		return application_final_status;
	}
	public void setApplication_final_status(String application_final_status) {
		this.application_final_status = application_final_status;
	}
	public String getPost_selected_name() {
		return post_selected_name;
	}
	public void setPost_selected_name(String post_selected_name) {
		this.post_selected_name = post_selected_name;
	}
	public String getExam_passed_plus2() {
		return exam_passed_plus2;
	}
	public void setExam_passed_plus2(String exam_passed_plus2) {
		this.exam_passed_plus2 = exam_passed_plus2;
	}
	public String getEdu_instistute_plus2() {
		return edu_instistute_plus2;
	}
	public void setEdu_instistute_plus2(String edu_instistute_plus2) {
		this.edu_instistute_plus2 = edu_instistute_plus2;
	}
	public String getEdu_subject_plus2() {
		return edu_subject_plus2;
	}
	public void setEdu_subject_plus2(String edu_subject_plus2) {
		this.edu_subject_plus2 = edu_subject_plus2;
	}
	public String getEdu_marks_plus2() {
		return edu_marks_plus2;
	}
	public void setEdu_marks_plus2(String edu_marks_plus2) {
		this.edu_marks_plus2 = edu_marks_plus2;
	}
	public String getEdu_rollno_plus2() {
		return edu_rollno_plus2;
	}
	public void setEdu_rollno_plus2(String edu_rollno_plus2) {
		this.edu_rollno_plus2 = edu_rollno_plus2;
	}
	public String getEdu_date_issue_plus2() {
		return edu_date_issue_plus2;
	}
	public void setEdu_date_issue_plus2(String edu_date_issue_plus2) {
		this.edu_date_issue_plus2 = edu_date_issue_plus2;
	}
	public String getStream_plus2() {
		return stream_plus2;
	}
	public void setStream_plus2(String stream_plus2) {
		this.stream_plus2 = stream_plus2;
	}
	public String getUniversity_plus2() {
		return university_plus2;
	}
	public void setUniversity_plus2(String university_plus2) {
		this.university_plus2 = university_plus2;
	}
	public String getEdu_year_plus2() {
		return edu_year_plus2;
	}
	public void setEdu_year_plus2(String edu_year_plus2) {
		this.edu_year_plus2 = edu_year_plus2;
	}
	public String getEdu_certno_plus2() {
		return edu_certno_plus2;
	}
	public void setEdu_certno_plus2(String edu_certno_plus2) {
		this.edu_certno_plus2 = edu_certno_plus2;
	}
	public String getCatFileName() {
		return catFileName;
	}
	public void setCatFileName(String catFileName) {
		this.catFileName = catFileName;
	}
	public String getComFileName() {
		return comFileName;
	}
	public void setComFileName(String comFileName) {
		this.comFileName = comFileName;
	}
	public String getMatricFileName() {
		return matricFileName;
	}
	public void setMatricFileName(String matricFileName) {
		this.matricFileName = matricFileName;
	}
	public String getProfQualFileName() {
		return profQualFileName;
	}
	public void setProfQualFileName(String profQualFileName) {
		this.profQualFileName = profQualFileName;
	}
	public String getIdentityFileName() {
		return identityFileName;
	}
	public void setIdentityFileName(String identityFileName) {
		this.identityFileName = identityFileName;
	}
	public String getExam_passed_5() {
		return exam_passed_5;
	}
	public void setExam_passed_5(String exam_passed_5) {
		this.exam_passed_5 = exam_passed_5;
	}
	public String getEdu_marks_5() {
		return edu_marks_5;
	}
	public void setEdu_marks_5(String edu_marks_5) {
		this.edu_marks_5 = edu_marks_5;
	}
	public String getSkill_1() {
		return skill_1;
	}
	public void setSkill_1(String skill_1) {
		this.skill_1 = skill_1;
	}
	public String getSkill_2() {
		return skill_2;
	}
	public void setSkill_2(String skill_2) {
		this.skill_2 = skill_2;
	}
	public String getSkill_3() {
		return skill_3;
	}
	public void setSkill_3(String skill_3) {
		this.skill_3 = skill_3;
	}
	public String getSkill_4() {
		return skill_4;
	}
	public void setSkill_4(String skill_4) {
		this.skill_4 = skill_4;
	}
	public String getSkill_5() {
		return skill_5;
	}
	public void setSkill_5(String skill_5) {
		this.skill_5 = skill_5;
	}
	public String getSkill_6() {
		return skill_6;
	}
	public void setSkill_6(String skill_6) {
		this.skill_6 = skill_6;
	}
	public String getSkill_7() {
		return skill_7;
	}
	public void setSkill_7(String skill_7) {
		this.skill_7 = skill_7;
	}
	public String getSkill_8() {
		return skill_8;
	}
	public void setSkill_8(String skill_8) {
		this.skill_8 = skill_8;
	}
	public String getSkill_9() {
		return skill_9;
	}
	public void setSkill_9(String skill_9) {
		this.skill_9 = skill_9;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public boolean isSkills_flag() {
		return skills_flag;
	}
	public void setSkills_flag(boolean skills_flag) {
		this.skills_flag = skills_flag;
	}
	
	
	public String getQualification1() {
		return qualification1;
	}
	public void setQualification1(String qualification1) {
		this.qualification1 = qualification1;
	}
	public String getQualification2() {
		return qualification2;
	}
	public void setQualification2(String qualification2) {
		this.qualification2 = qualification2;
	}
	public String getQualification3() {
		return qualification3;
	}
	public void setQualification3(String qualification3) {
		this.qualification3 = qualification3;
	}
	public String getQualification4() {
		return qualification4;
	}
	public void setQualification4(String qualification4) {
		this.qualification4 = qualification4;
	}
	public String getQualification1_text() {
		return qualification1_text;
	}
	public void setQualification1_text(String qualification1_text) {
		this.qualification1_text = qualification1_text;
	}
	public String getQualification2_text() {
		return qualification2_text;
	}
	public void setQualification2_text(String qualification2_text) {
		this.qualification2_text = qualification2_text;
	}
	public String getQualification3_text() {
		return qualification3_text;
	}
	public void setQualification3_text(String qualification3_text) {
		this.qualification3_text = qualification3_text;
	}
	public String getQualification4_text() {
		return qualification4_text;
	}
	public void setQualification4_text(String qualification4_text) {
		this.qualification4_text = qualification4_text;
	}
	public boolean isPost_change_eligible() {
		return post_change_eligible;
	}
	public void setPost_change_eligible(boolean post_change_eligible) {
		this.post_change_eligible = post_change_eligible;
	}
	public boolean isIs_rejected() {
		return is_rejected;
	}
	public void setIs_rejected(boolean is_rejected) {
		this.is_rejected = is_rejected;
	}
	public String getPresent_employer2() {
		return present_employer2;
	}
	public void setPresent_employer2(String present_employer2) {
		this.present_employer2 = present_employer2;
	}
	public String getEmp_date_since2() {
		return emp_date_since2;
	}
	public void setEmp_date_since2(String emp_date_since2) {
		this.emp_date_since2 = emp_date_since2;
	}
	public String getPost_held2() {
		return post_held2;
	}
	public void setPost_held2(String post_held2) {
		this.post_held2 = post_held2;
	}
	public String getNocdesignation2() {
		return nocdesignation2;
	}
	public void setNocdesignation2(String nocdesignation2) {
		this.nocdesignation2 = nocdesignation2;
	}
	public boolean isNursing_council() {
		return nursing_council;
	}
	public void setNursing_council(boolean nursing_council) {
		this.nursing_council = nursing_council;
	}
	public boolean isHospital_experience() {
		return hospital_experience;
	}
	public void setHospital_experience(boolean hospital_experience) {
		this.hospital_experience = hospital_experience;
	}
	public boolean isTradesmen_certificate() {
		return tradesmen_certificate;
	}
	public void setTradesmen_certificate(boolean tradesmen_certificate) {
		this.tradesmen_certificate = tradesmen_certificate;
	}
	public boolean isAutocad_certificate() {
		return autocad_certificate;
	}
	public void setAutocad_certificate(boolean autocad_certificate) {
		this.autocad_certificate = autocad_certificate;
	}
	public boolean isDraughtsmanship_exp() {
		return draughtsmanship_exp;
	}
	public void setDraughtsmanship_exp(boolean draughtsmanship_exp) {
		this.draughtsmanship_exp = draughtsmanship_exp;
	}
	public String getNurse() {
		return nurse;
	}
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getAutocad() {
		return autocad;
	}
	public void setAutocad(String autocad) {
		this.autocad = autocad;
	}
	public String getDraft() {
		return draft;
	}
	public void setDraft(String draft) {
		this.draft = draft;
	}
    
		
	

}
