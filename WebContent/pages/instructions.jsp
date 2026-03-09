<%@ page import="com.ttil.bean.PostsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
<title>Welcome to SSB online application</title>

<script type="text/javascript">
window.onpageshow = function (evt) {
	if (evt.persisted) noBack();
	};
	
</script>

<script>
	function process() {
		var agree_continue = document.instructions.agree_continue.checked;
		if (agree_continue == true) {
			return true;
		} else {
			alert("IT IS MANDATORY FOR THE CANDIDATE TO TAKE PRINT OUT OF 'IMPORTANT INSTRUCTIONS TO THE CANDIDATE' BEFORE FILLING FORM AND READ THE SAME CAREFULLY.");
			return false;
		}

	}
</script>

<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>

</head>
<body onLoad="noBack();" onUnload="" oncontextmenu="return true;">


    <jsp:include page="header.jsp" flush="true" />
    
   <div class="container">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails">
      <form name="instructions" method="post" action="applicationForm">
       
            
            
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          
          <tr>
          
            <td colspan="4" align="left" valign="middle"><h3>GUIDELINES TO FILL-UP THE APPLICATION FORM FOR THE POST OF ASSISTANT SUB-INSPECTOR (STENO) AND HEAD CONSTABLE (MINISTERIAL)-2018</h3>
            <input type="hidden" name="requestFrom" value="instructions"/>
            </td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
              <tr>
                <td colspan="2" align="left" valign="middle"><label>Applicants are advised to go through the instructions and detailed advertisement available on the SSB Website and the Employment News thoroughly before filling up the their application forms.<br />
                  </label></td>
              </tr>
              
              <tr>
                <td colspan="2" align="center" valign="middle"><label><strong>PART - I</strong></label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>1. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Post : </b> Applicant must select the post for which he/she wants to apply for.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>2. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Applicant's name : </b> Applicant must fill his /her first name, middle name & last name as per  name  in his/her matriculation certificate.  Prefix  in the name like Mr/Miss/Mrs/Sri/Shri/Dr etc must be omitted  while entering  in First , Middle & last name fields.</label></td>
              </tr>
             <!--  <tr>
                <td width="4%" align="left" valign="top"><strong>3. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Gender : </b> Should select as applicable (Male or Female).</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>4. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Exam Centre : </b> Examination centre for each State has been decided/fixed. No choice will be available for examination centre. However, SSB ward who residing other than their domicile state may select examination centre other than their domicile State. For details may see para-9 of notification.</label></td>
              </tr> -->
             
              <tr>
                <td width="4%" align="left" valign="top"><strong>3. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Father's /Husband's name : </b> Applicant must  fill  his/her  father's  name  as per name in his / her  matriculation certificate. Prefix  in the name like Mr/Sri/Shri/Dr etc must be omitted  while entering in the  name field.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>4. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Mother's name : </b> Applicant  must  fill his/her mother's name as per name in his / her  matriculation certificate etc. Prefix in the name like Mrs/Smt/Dr.  etc must be omitted  while entering  in the name field.
                 </label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>5. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Date of birth : </b> Date of birth must be entered in DD/MM/YYYY format as per date of birth  in  his / her  matriculation certificate.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>6. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Gender : </b> Applicant  must  select as applicable (Male or Female). </label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>7. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Nationality : </b> Applicant must fill his /her nationality accordingly.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>8. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Religion : </b> Applicant must fill his/her religion i.e. Hindu, Muslims, Christians, Sikhs, Buddhists, Zoroastrians(Parsees) & Jains or  others.  If belongs to other, he /she must enter name of his/her  religion in the given text box against it. </label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>9. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Marital Status : </b> Applicant must  fill  his / her  current marital status  i.e.  Married or Un-married or Divorcee.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>10. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Category : </b> Applicant must  fill  category in which  he /she belongs to   i.e. General/UR , OBC,  SC, ST. Applicants  belonging to OBC/SC/ST category must produce relevant  document /certificate  in  prescribed  format  mentioned in advertisement at the time of documentation.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>11. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Community : </b> Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if he / she belongs to any of the given communities and fill details accordingly. Otherwise opt "No" and  proceed.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>12. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Domiciled ordinarily in J&K : </b> Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if his / her date of birth  falls during the period from 1st. January  1980   Domiciled ordinarily in J&K  Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if his / her date of birth  falls during the period from 1st. January 1980  to 31st. December 1989 and  fill details accordingly. Otherwise opt "No" and proceed.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>13. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Affected in 1984 riots : </b> Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if he / she is a child /dependent of victims killed in 1984 riots in Gujarat and fill details accordingly. Otherwise opt "No" and proceed.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>14. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Affected in 2002 communal riots of Gujarat : </b> Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if he / she is a child/dependent of victims killed in 2002 riots in Gujarat and fill details accordingly. Otherwise opt "No" and proceed.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>15. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Whether Ex-Serviceman : </b> Applicant must  opt  one of the options - "Yes" or "No".  Applicant must opt "Yes" if  he / she  belongs to EX-Serviceman  and  fill details accordingly. Otherwise opt "No" and proceed.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>16. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Whether SSB Employee : </b> Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if  he / she  belongs to SSB employee  and  fill details accordingly. Otherwise opt "No" and proceed.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>17. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Whether Government Employee : </b> Applicant must opt one of the options - "Yes" or "No".  Applicant must opt "Yes" if  he / she  belongs to Government employee  and  fill details accordingly. Otherwise opt "No" and proceed.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>18. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Adhaar Number : </b> Adhaar Number is optional. Applicant must  enter  his /her 12 digit Adhaar number, if he / she posses Adhaar Number.</label> </td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>19. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Identification Marks : </b> Identification  mark of  an applicant   is mandatory.  Applicant  must enter  his/her identification  mark  accordingly.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>20. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Mobile Number : </b> Mobile number is mandatory. Enter a valid mobile number through which communication can be sent from SSB.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>21. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>E-mail ID : </b> E-mail ID is optional. However, an applicant can enter valid email ID for future reference so that information related to recruitment can be sent through the Email-ID.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>22. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Permanent Address : </b>  Applicant must  fill his / her permanent address details in the available fields accordingly.</label></td>
              </tr>
             <tr>
                <td width="4%" align="left" valign="top"><strong>23. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Correspondence Address : </b>  Applicant must opt one of the options "Yes" or "No". If correspondence address is completely the same as the   permanent address, he / she can choose the option "Yes". Otherwise,  details of the correspondence address must be entered accordingly and proceed.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>24. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Essential Qualification : </b> Applicant  must  choose one of the options for essential   qualification  required for the  applied post  if   he /she  posses the qualification.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>25. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Education Qualification details : </b> Applicant must fill /enter  his /her qualification details from matriculation  level  onwards accordingly.</label></td>
              </tr>
             
              <tr>
                <td width="4%" align="left" valign="top"><strong>26. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Criminal Cases Declaration : </b>  Applicant must opt "Yes" or "No". If yes, please enter the details accordingly. Otherwise, opt  "No" and proceed. </label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>Note:- </strong> </td>
                <td width="95%" align="left" valign="top"><label>After clicking Proceed button, the filled up application form will be shown. The filled up application form can be edited, if required,  through  "Edit Details" button and then proceed by clicking  "submit button".</label></td>
              </tr>
              <tr>
                <td colspan="2" align="center" valign="middle"><label><strong>PART - II</strong></label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>1. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Upload Photo : </b> Upload your passport size photograph in 8-JPG format which must be less than 12 kb and greater than 4 kb of resolution 100 pixel widths by 120 pixels height.</label></td>
              </tr>
              <tr>
                <td width="4%" align="left" valign="top"><strong>2. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Upload Signature : </b> Upload your signature in 8-JPG format which must be less than 12 kb and greater than 4 kb of resolution 140 pixel widths by 60 pixels height.</label></td>
              </tr>
              <tr>
                <td colspan="2" align="left" valign="middle"><label><strong>Note 1 :-</strong></label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong></strong> </td>
                <td width="95%" align="left" valign="top"><label>Once photograph and scanned signature uploaded press "Upload" button. Once uploaded successfully, then a page with Post Applied & Registration No. shall be generated. Note down registration number or take out the print out of the Acknowledgement. Applicant can make payment by online / offline. For offline Applicant should take print out of challans. <br/>
                <strong>(Applicant must note down  registration/application number for further reference )</strong></label></td>
              </tr>
              <tr>
                <td colspan="2" align="left" valign="middle"><label><strong>Note 2 :-</strong></label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong></strong> </td>
                <td width="95%" align="left" valign="top"><label>Proper tracking features have already been generated in software to find out the location of Applicants who filling the application form online. If any Applicants fill wrong information in their application form or pastes, fake photograph of any other person/celebrity or object or puts blank photo etc, suitable action will be taken against them as per provision under cyber crime IT Act 2000.</label></td>
              </tr>
              <tr>
                <td colspan="2" align="center" valign="middle"><label><strong>PART - III</strong></label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>1. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Mode of payment : </b> Applicant will pay requisite fee Rs. 100/- along with service charge as applicable through SBI Challan or through net Banking/Credit and Debit Cards of any bank. Net amount to be paid including all applicable charges will be shown on screen and which has to be paid. SC/ST/Women Applicants/Ex-Serviceman are exempted from paying fee. No amount will be refunded in any case. Applicants are advised to be careful while making payment and avoid making multiple payment against single registration, as payment made are nonrefundable. If they are making such payment, it will be their own risk/loss.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>2. </strong> </td>
                <td width="95%" align="left" valign="top"><label> <b>Proof of candidature: </b> Applicant must get a print of application form after final submission. If payment is not applicable then print can be taken out immediately. Applicant belonging to  Gen/OBC can take print out only after payment of applicable fee. In case, payment is not made successfully due to banking error or other network problem, then the Applicant can pay the amount again. The applicant will note down their registration number, which will also be sent to their registered Mobile number  or E-mail ID. For payment they will again log in system and go straight for payment mode, fill in their registration number and date of birth and then proceed for payment.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>3. </strong> </td>
                <td width="95%" align="left" valign="top"><label>Applicants are advised that they should submit their application forms after filling each and every column of application form correctly and to their entire satisfaction.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>4. </strong> </td>
                <td width="95%" align="left" valign="top"><label>After submission of form any request for change/correction in any particulars in the application form shall not be entertained under any circumstances. SSB will not be responsible for any consequences arising out of non acceptance of any correction/addition/deletion in any particular field in application form whatsoever the reasons may be.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>5. </strong> </td>
                <td width="95%" align="left" valign="top"><label>Application form with blurred photograph will summarily be rejected.</label></td>
              </tr>
               <tr>
                <td width="4%" align="left" valign="top"><strong>6. </strong> </td>
                <td width="95%" align="left" valign="top"><label>Application form incomplete in any respect will summarily be rejected. No complaint in this regard will be entertained.</label></td>
              </tr>
              <tr>
                <td align="left" valign="top"><input type="checkbox" name="agree_continue" id="agree_continue" /></td>
                <td align="left" valign="top"><label><strong>Yes, I have read & understood all "Important Instructions and detailed advertisement".</strong></label></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle">
              <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td><div class="buttonWrapper" style="margin:20px 0px 20px 0px;">
      <input name="formBack0" type="submit" class="nextbutton appFormBtmRight" value="Proceed to Fill Application Form" alt="Next step" style="width:320px;"  onclick="return process()"/>
    </div></td>
  </tr>
</table>            </td>
          </tr>
        </table>
        
        </form>
        </div>
        
      </div>
    </div>
    </div>
    </div>
    
    <!--Content div ends here-->

<jsp:include page="footer.jsp" flush="true" />

 
</body>
</html>
