<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page pageEncoding="utf-8"%>
<title>SSB Online</title>
 <link rel="shortcut icon" href="images/favicon.jpg" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
<link href="css/jquery.datepick.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.datepick.js"></script>
<style>
.nursing {
display:none
}
.hc_lab_asst {
	display:none
}
.hc_lab_asst_work {
	display:none
}

.hc_physio_asst {
	display:none
}
.hc_physio_asst_work {
	display:none
}

.ct_nursing_asst {
	display:none
}
.ct_nursing_asst_work {
	display:none
}


.hospital {
display:none
}
.tradesmen {
display:none
}
.autocad {
display:none
}
.draughtsmanship{
display:none
}
</style>
<script type="text/javascript">
	var maxDOBDateValue = "11-04-2008"; //max dob picker
		var maxDateValue = "11-04-2026"; //app last date
		var dateSincemaxDate = "11-04-2023"; //dept.
		var lessEqualCheck = "12-04-2026"; //app last date +1 (education certificates validation)
		
	$(function() { 
		//var changeMonth = $( ".selector" ).datepicker( "option", "changeMonth" );
		//var changeYear = $( ".selector" ).datepicker( "option", "changeYear" );
		//var minDate = $( ".selector" ).datepicker( "option", "minDate" );
		
		/**
		Creating Calnedar with Predifined limit dates. This could be cut-ff date
		*/
		$('#recordClientDob').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:-18",
			//  maxDate: "18-06-2005",
			 maxDate: maxDOBDateValue,
			onSelect: function(evnt) {
		         getAge();
		    }
		});
		$('#edu_date_issue1').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0"
		});
		$('#edu_date_issue2').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0"
		});
		$('#edu_date_issue3').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0"
		});
		$('#edu_date_issue4').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0"
		});
		$('#date').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0"
		});
		$('#recordClientExmanEnrlment').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			// maxDate: "18-06-2023",
			maxDate: maxDateValue,
			onSelect: function(evnt) {
				getExmanService();
		    }
		});
		$('#recordClientExmanRetirement').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			onSelect: function(evnt) {
				getExmanService();
		    }
		});
		$('#recordClientJKDateIssue').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			maxDate: 0
		});
		$('#recordClientCatDateIssue').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			maxDate: 0
		});
		$('#recordClientRiotsDateIssue').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			maxDate: 0
		});
		$('#recordClientRiotsGujDateIssue').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			maxDate: 0
		});
		
		
		 $('#recordClientEduDateIssue1').datepick({
			 changeMonth : true,
			 changeYear : true,
			 showButtonPanel : true,
			 yearRange : "-50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		}); 
		$('#recordClientEduDateIssue2').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		$('#recordClientEduDateIssuePlus2').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		
		$('#recordClientEduDateIssue3').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		
		$('#recordClientEduDateIssue33').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		$('#recordClientEduDateIssue4').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		$('#recordClientEduDateIssue5').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "50:+0",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		$('#recordClientEduDateIssue6').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "50:-2",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		$('#recordClientEduDateIssue7').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "50:-2",
			//  maxDate: "18-06-2023"
			 maxDate: maxDateValue
		});
		
		$('#recordClientEmpDateSince').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			//  maxDate: "18-06-2020"
			 maxDate: dateSincemaxDate
		});
		
		$('#recordClientEmpDateSince2').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			//  maxDate: "18-06-2020"
			 maxDate: dateSincemaxDate
		});
		$('#recordClientFirdate').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			maxDate: 0
		});
		$('#recordClientExamdate').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+0",
			maxDate: 0
		});
		$('#recordClientDebarEnddate').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:+7"
		});
		
	});
</script>


<script>
/**
 * Charcater Restriction Functions ( Numbers , charcaters  & special characters)
 */
function numbersonly_mobile(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)){return true;}else{if((("0123456789").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return false;}else{return false;}}}}
function numericsonly_mobile(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)){return true;}else{if((("0123456789.").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return false;}else{return false;}}}}
function charactersonly_mobile(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)||(a==32)){return true;}else{if((("abcdefghijklmnopqrstuvwxyz").indexOf(c)>-1)){return true;}else{if((("ABCDEFGHIJKLMNOPQRSTUVWXYZ").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return true;}else{return false;}}}}}
function charsAndNumbersOnly(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)||(a==32)){return true;}else{if((("abcdefghijklmnopqrstuvwxyz1234567890.").indexOf(c)>-1)){return true;}else{if((("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return true;}else{return false;}}}}}
function charsNumbersAndSpecialCharsOnly(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)||(a==32)){return true;}else{if((("abcdefghijklmnopqrstuvwxyz1234567890.,()-_/@").indexOf(c)>-1)){return true;}else{if((("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,()-_/@").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return true;}else{return false;}}}}}
function trim1(a){return a;}
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		/**
		This function will call when First Page Next button clicked.
		All the Validations will be done in this function
		*/
		$("#firstDivNext").click(function() {
	var i = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	var g=/^[0-9]*$/;
	var k=/^[a-zA-Z \\s]*$/;
	var name_nospace=/^[a-zA-Z]*$/;
	var cn=/^[a-zA-Z0-9 \\s]*$/;
	$(".error").hide();
	var l=false;
	var m=trim1($("#firstName").val());
	var middleName=trim1($("#middleName").val());
	var n=trim1($("#lastName").val());
	var o=trim1($("#fathername").val());
	var mo=trim1($("#mothername").val());
	var h=trim1($("#religion").val());
	var post_applied=trim1($("#post_applied").val());
	var dob=trim1($("#recordClientDob").val());
	var or=trim1($("#other_religion").val());
	var im=trim1($("#personalMoal").val());
	var sex = trim1($("#sex").val());
	var mobile=trim1($("#recordClientPhone").val());
	var email = trim1($("#recordClientEmail").val());
	var aadhar = trim1($("#aadharNo").val());
	var identity_type = trim1($("#identity_type").val());
	var marrital = trim1($("#marrital_status").val());
	var nation = trim1($("#nationality").val());
	
	var com = trim1($("#community").val());
	var category_belongs = $("input[name=categoty_belongs]:checked").length;
	var jk_domiciled = $("input[name=jk_domiciled]:checked").length;
	var riots_affected = $("input[name=riots_affected]:checked").length;
	var exman = $("input[name=ex_serviceman]:checked").length;
	var emp_ssb = $("input[name=employee_ssb]:checked").length;
	//var govt_service = $("input[name=govt_service]:checked").length;   
	var nursing_council = $("input[name=nursing_council]:checked").length;
	var hc_lab_asst_cert = $("input[name=hc_lab_asst_cert]:checked").length;
	var hc_lab_asst_exp = $("input[name=hc_lab_asst_exp]:checked").length;
	var hc_physio_asst_cert = $("input[name=hc_physio_asst_cert]:checked").length;
	var hc_physio_asst_exp = $("input[name=hc_physio_asst_exp]:checked").length;
	var ct_nursing_asst_cert = $("input[name=ct_nursing_asst_cert]:checked").length;
	var ct_nursing_asst_exp = $("input[name=ct_nursing_asst_exp]:checked").length;
	var hospital_experience = $("input[name=hospital_experience]:checked").length;
	var tradesmen_certificate = $("input[name=tradesmen_certificate]:checked").length;
	var autocad_certificate = $("input[name=autocad_certificate]:checked").length;
	var draughtsmanship_exp = $("input[name=draughtsmanship_exp]:checked").length;
	var post_applied_value = $("#post_applied option:selected").html();
	
	
	
	if(post_applied==""){
		$("#post_applied_errormessage").show();
		l=true;
	}
	if(sex==""){
		$("#errormessageSex").show();
		l=true;
	}
	
	//  if(post_applied=="4" && sex=="Male"){
	// 	alert("Gender should not be Male for the post :"+post_applied_value);
	// 	$("#sex").val("");
	// 	return false;
	// } 
	 
	//  if((post_applied=="1" || post_applied=="4") && nation=="Others"){
	// 		alert("Nationality should be Indian for the selected Post");
	// 		return false;
	// 	} 
	 
	if(m==""){
		$("#firstNameErrorMessage").show();
		l=true;
	}
    else if((m.length<1))
		{
		$("#firstNameLengthErrorMessage").show();
		l=true;
	} 
	else{
		if(!k.test(m)){
			$("#firstNameCharsErrorMessage").show();
		l=true;
		}
	}

		if(!k.test(middleName)){
			$("#middleNameCharsErrorMessage").show();
		l=true;
		}
	
	 if(!k.test(n)){
			$("#lastNameCharsErrorMessage").show();
		l=true;
	}
	
	if(o==""){
		$("#fatherNameErrorMessage").show();
		l=true;
	}
    else if((o.length<2))
		{
		$("#fatherNameLengthErrorMessage").show();
		l=true;
	} 
	else if(!k.test(o)){
			$("#fatherNameCharsErrorMessage").show();
		l=true;
	}
	
	if(mo==""){
		$("#motherNameErrorMessage").show();
		l=true;
	}
    else if((mo.length<2))
		{
		$("#motherNameLengthErrorMessage").show();
		l=true;
	} 
	else if(!k.test(mo)){
			$("#motherNameCharsErrorMessage").show();
		l=true;
	}
	
	if(dob==""){
		$("#doberrormessage").show();
		l=true;
	}
	
	
	if(h==""){
		$("#religionerrormessage").show();
		l=true;
	}else if(h=="Others"){
		if(or==""){
			$("#religionerrormessage1").show();
			l=true;
		}
		else if(!k.test(or)){
				$("#religionerrormessage2").show();
			l=true;
		}
	}
	
	

    
	if(marrital==""){
		$("#marrital_errormessage").show();
		l=true;
	}
	if(nation==""){
		$("#nationality_errormessage").show();
		l=true;
	}else{
		/* if(nation=="Others"){
			if(post_applied=="2" || post_applied=="28" || post_applied=="3" || post_applied=="6" || post_applied=="30" || post_applied=="7" || post_applied=="9" || post_applied=="10" || post_applied=="26" || post_applied=="27"){
			}else{
				 $("#indian_nationality_errormessage").show();
				  l=true;
			}
		} */
	}
	
	if(aadhar==""){
		$("#aadharCharsError").show();
		l=true;
	}
	if(identity_type==""){
		$("#identity_errormessage").show();
		l=true;
	}
    
	if(im==""){
		$("#identificationError").show();
		l=true;
	}else  if(!k.test(im)){
		$("#identificationCharsError").show();
		l=true;
	}
	
	if(mobile==""){
		$("#mobileError").show();
		l=true;
	}
	else if(!g.test(mobile)){
			$("#mobileNosError").show();
			l=true;
	}else if(mobile.length<10){
		$("#mobileLengthError").show();
		l=true;
	}
	
	if (email == "") {
        $("#eMailErrorMessage").show();
        l = true;
    } else {
        if (!i.test(email)) {
            $("#eMailErrorMessageValidate").show();
            l = true;
        } else {
            $("#eMailErrorMessageValidate").hide();
        }
    }   
	
	if (com == ""){
        $("#communityErrorMessage").show();
		l=true;
    }
	
	if (category_belongs < 1){
        $("#categoryErrorMessage").show();
		l=true;
    }
    
	var dob1 = document.applicationForm.dob.value;
	var dobArr = dob1.split("-");
	var byr=parseInt(dobArr[2]);
	//if(byr>=1980 && byr<=1989){
		if (jk_domiciled < 1){
	        $("#jkDomicileErrorMessage").show();
			l=true;
	    }
	//}
	
	
	
	if (riots_affected < 1){
        $("#riotsErrorMessage").show();
		l=true;
    }

	if (exman < 1){
        $("#exmanErrorMessage").show();
		l=true;
    }
	if (emp_ssb < 1){
        $("#ssb_emp_ErrorMessage").show();
		l=true;
    }
   /*  if (govt_service < 1){
        $("#govt_emp_ErrorMessage").show();
		l=true;
    }  */

	if(post_applied == "1"){
		 var status_hc_lab_asst_cert = $("input:radio[name=hc_lab_asst_cert]:checked").val();

		 if(hc_lab_asst_cert < 1) {
			$("#hc_lab_asst_cert_ErrorMessage").show();
		l=true;
		 }

		 if(status_hc_lab_asst_cert=="false"){
		alert("Should have Certificate course of a duration of minimum one year in Laboratory Assistant Course from a recognized institution. ");
		return false;
	}

		 var status_hc_lab_asst_exp = $("input:radio[name=hc_lab_asst_exp]:checked").val();

		 if(hc_lab_asst_exp < 1) {
			$("#hc_lab_asst_exp_ErrorMessage").show();
		l=true;
		 }

		 if(status_hc_lab_asst_exp=="false"){
		alert("Should have Working experience of duration of minimum One year as Lab Assistant in Laboratory Diagnostic Centre or hospital or institution lab recognized by the Central Government or State Government");
		return false;
	}
	} 
	if(post_applied == "3"){
		 var status_hc_physio_asst_cert = $("input:radio[name=hc_physio_asst_cert]:checked").val();

		 if(hc_physio_asst_cert < 1) {
			$("#hc_physio_asst_cert_ErrorMessage").show();
		l=true;
		 }

		 if(status_hc_physio_asst_cert=="false"){
		alert("Should have Certificate course of  duration of  minimum one year in Physiotherapy from a recognized institute . ");
		return false;
	}

	
		 var status_hc_physio_asst_exp = $("input:radio[name=hc_physio_asst_exp]:checked").val();

		 if(hc_physio_asst_exp < 1) {
			$("#hc_physio_asst_exp_ErrorMessage").show();
		l=true;
		 }

		 if(status_hc_physio_asst_exp=="false"){
		alert("Should have Experience of duration of minimum one year as Physiotherapy Assistant from a Physiotherapy Centre or minimum hundred bedded hospital or institute recognised by the Central Government or State Government. ");
		return false;
	}

		 
	}
 
    
    if(post_applied=="4"){
      var status_ct_nursing_asst_cert = $("input:radio[name=ct_nursing_asst_cert]:checked").val();

		 if(ct_nursing_asst_cert < 1) {
			$("#ct_nursing_asst_cert_ErrorMessage").show();
		l=true;
		 }

		 if(status_ct_nursing_asst_cert=="false"){
		alert("Should have First Aid certificate course from St. John’s Ambulance Organization or Red Cross Society of India ");
		return false;
	}

	 var status_ct_nursing_asst_exp = $("input:radio[name=ct_nursing_asst_exp]:checked").val();

		 if(ct_nursing_asst_exp < 1) {
			$("#ct_nursing_asst_exp_ErrorMessage").show();
		l=true;
		 }

		 if(status_ct_nursing_asst_exp=="false"){
		alert("Should have Experience of duration of minimum one year as Nursing Assistant in a minimum fifty bedded Hospital or Institution recognised by the Central Government or State Governments. ");
		return false;
	  
	
    }
} 
    
    
	if(l==true){
		alert("Details not correct. Please make sure all required fields are filled out correctly");
		return false;
	}
	else{
		var age=AgeCaluclate();
		$("#age").attr("value", age);
		
		if(!secondPagevalidation()){return false;}
		else if(!firstPagevalidation()){return false;}
	else{}}
	
	
//validation end for first div
      
		$("#div1").hide();
		$("#div3").show();
		 window.scrollTo(0,0);
		
		
}); // end of firstDivNext


$("#post_applied").change(function(){
	
	if(!($("#post_applied").val()==""))
		{
		$("#post_applied_errormessage").hide();
		}
});


/** On keyup functions */
$("#firstName").keyup(function(){
	if(!($("#firstName").val()==""))
	{
	$("#firstNameErrorMessage").hide();
	 if(!($("#firstName").val().length<1))
		{
		$("#firstNameLengthErrorMessage").hide();
		}
	}
});

$("#fathername").keyup(function(){
	if(!($("#fathername").val()==""))
		{
		$("#fatherNameErrorMessage").hide();
		 if(!($("#fathername").val().length<2))
			{
			$("#fatherNameLengthErrorMessage").hide();
			}
		}
});

$("#mothername").keyup(function(){
	if(!($("#mothername").val()==""))
		{
		$("#motherNameErrorMessage").hide();
		 if(!($("#mothername").val().length<2))
			{
			$("#motherNameLengthErrorMessage").hide();
			}
		}
});



$("#religion").change(function(){
	
	if(!($("#religion").val()==""))
		{
		$("#religionerrormessage").hide();
		}
});
$("#other_religion").keyup(function(){
	if(!($("#other_religion").val()==""))
		{
		$("#religionerrormessage1").hide();
		}
});
$("#sex").change(function(){
	
	if(!($("#sex").val()==""))
		{
		$("#errormessageSex").hide();
		}
});
 $('#recordClientDob').change(function(){
	if(!($("#recordClientDob").val()==""))
		{
		$("#doberrormessage").hide();
		}
}); 
 
 $("#marrital_status").change(function(){
		if(!($("#marrital_status").val()==""))
			{
			$("#marrital_errormessage").hide();
			}
	});
 
 $("#nationality").change(function(){
		if(!($("#nationality").val()==""))
			{
			$("#nationality_errormessage").hide();
			$("#indian_nationality_errormessage").hide();
			
			}
	});
 
 $('#aadharNo').keyup(function(){
		$("#aadharCharsError").hide();
	});

$("#identity_type").change(function(){
		if(!($("#identity_type").val()==""))
			{
			$("#identity_errormessage").hide();
			}
	});
	
$('#personalMoal').keyup(function(){
	if(!($("#personalMoal").val()==""))
		{
		$("#identificationError").hide();
		}
});
$("#recordClientPhone").keyup(function(){
	if(!($("#recordClientPhone").val()==""))
		{$("#mobileError").hide();}
});

$("#recordClientEmail").keyup(function () {
    if (!($("#recordClientEmail").val() == "")) {
        $("#eMailErrorMessage").hide();
    }
});



$("#community").change(function(){
	
	if(!($("#community").val()==""))
		{
		$("#communityErrorMessage").hide();
		}
});

$("#categotybelongs").change(function(){
	var exman = $("input[name=categoty_belongs]:checked").length;
	if(exman==1)
		{
		$("#categoryErrorMessage").hide();
		}
});
$("#jkdomiciled").change(function(){
	var exman = $("input[name=jk_domiciled]:checked").length;
	if(exman==1)
		{
		$("#jkDomicileErrorMessage").hide();
		}
});
$("#riotsaffected").change(function(){
	var exman = $("input[name=riots_affected]:checked").length;
	if(exman==1)
		{
		$("#riotsErrorMessage").hide();
		}
});

$("#exserviceman").change(function(){
	var exman = $("input[name=ex_serviceman]:checked").length;
	if(exman==1)
		{
		$("#exmanErrorMessage").hide();
		}
});

$("#employee_ssb").change(function(){
	var employee_ssb = $("input[name=employee_ssb]:checked").length;
	if(employee_ssb==1)
		{
		$("#ssb_emp_ErrorMessage").hide();
		}
});

/* $("#govt_service").change(function(){
	var govt_service = $("input[name=govt_service]:checked").length;
	if(govt_service==1)
		{
		$("#govt_emp_ErrorMessage").hide();
		}
});
 */
$("#hc_lab_asst_cert").change(function(){
	var hc_lab_asst_cert = $("input[name=hc_lab_asst_cert]:checked").length;
	if(hc_lab_asst_cert==1)
		{
		$("#hc_lab_asst_cert_ErrorMessage").hide();
		}
});
$("#hc_lab_asst_exp").change(function(){
	var hc_lab_asst_exp = $("input[name=hc_lab_asst_exp]:checked").length;
	if(hc_lab_asst_exp==1)
		{
		$("#hc_lab_asst_exp_ErrorMessage").hide();
		}
});

$("#hc_physio_asst_cert").change(function(){
	var hc_physio_asst_cert = $("input[name=hc_physio_asst_cert]:checked").length;
	if(hc_physio_asst_cert==1)
		{
		$("#hc_physio_asst_cert_ErrorMessage").hide();
		}
});

$("#hc_physio_asst_exp").change(function(){
	var hc_physio_asst_exp = $("input[name=hc_physio_asst_exp]:checked").length;
	if(hc_physio_asst_exp==1)
		{
		$("#hc_physio_asst_exp_ErrorMessage").hide();
		}
});


$("#ct_nursing_asst_cert").change(function(){
	var ct_nursing_asst_cert = $("input[name=ct_nursing_asst_cert]:checked").length;
	if(ct_nursing_asst_cert==1)
		{
		$("#ct_nursing_asst_cert_ErrorMessage").hide();
		}
});

$("#ct_nursing_asst_exp").change(function(){
	var ct_nursing_asst_exp = $("input[name=ct_nursing_asst_exp]:checked").length;
	if(ct_nursing_asst_exp==1)
		{
		$("#ct_nursing_asst_exp_ErrorMessage").hide();
		}
});

$("#nursing_council").change(function(){
	var nursing_council = $("input[name=nursing_council]:checked").length;
	if(nursing_council==1)
		{
		$("#nursing_council_ErrorMessage").hide();
		}
});

$("#tradesmen_certificate").change(function(){
	var tradesmen_certificate = $("input[name=tradesmen_certificate]:checked").length;
	if(tradesmen_certificate==1)
		{
		$("#tradesmen_certificate_ErrorMessage").hide();
		}
});

$("#autocad_certificate").change(function(){
	var autocad_certificate = $("input[name=autocad_certificate]:checked").length;
	if(autocad_certificate==1)
		{
		$("#autocad_certificate_ErrorMessage").hide();
		}
});

 $("#draughtsmanship_exp").change(function(){
	var draughtsmanship_exp = $("input[name=draughtsmanship_exp]:checked").length;
	if(draughtsmanship_exp==1)
		{
		$("#draughtsmanship_exp_ErrorMessage").hide();
		}
});
 
$("#hospital_experience").change(function(){
	var hospital_experience = $("input[name=hospital_experience]:checked").length;
	if(hospital_experience==1)
		{
		$("#hospital_experience_ErrorMessage").hide();
		}
});

/**
This function will call when Second Page Next button clicked.
All the Validations will be done in this function
*/
$("#thirdDivNext").click(function() {
	var e=/^[a-zA-Z \\s]*$/;
	var g=/^[0-9]*$/;
	$(".error").hide();
    var d=false;
	var village=trim1($("#village").val());
	var postoffice=trim1($("#postoffice").val());
	var tehsil=trim1($("#tehsil").val());
	var policestation=trim1($("#policestation").val());
	var state=trim1($("#state").val());
	var district=trim1($("#district").val());
	var pincode=trim1($("#recordZipcode").val());
	
	var village1=trim1($("#village1").val());
	var postoffice1=trim1($("#postoffice1").val());
	var tehsil1=trim1($("#tehsil1").val());
	var policestation1=trim1($("#policestation1").val());
	var state1=trim1($("#state1").val());
	var district1=trim1($("#district1").val());
	var pincode1=trim1($("#recordZipcode1").val());
	
	
	if(village==""){
		$("#villageError1").show();
		d=true;
	}
	if(postoffice==""){
		$("#postofficeError1").show();
		d=true;
	}
	
	if(state==""){
		$("#stateError1").show();
		d=true;
	}
	if(district==""){
		$("#districtError1").show();
		d=true;
	}
	
	if(pincode==""){
		$("#pincodeError1").show();
		d=true;
	}
	else if(!g.test(pincode)){
			$("#pincodeNosError1").show();
			d=true;
	}
	else if(pincode.length<6){
		$("#pinLengthError1").show();
		d=true;
	}
	if(village1==""){
		$("#villageError1").show();
		d=true;
	}
	if(postoffice1==""){
		$("#postofficeError1").show();
		d=true;
	}
	if(state1==""){
		$("#stateError1").show();
		d=true;
	}
	if(district1==""){
		$("#districtError1").show();
		d=true;
	}
	if(pincode1==""){
		$("#pincodeError1").show();
		d=true;
	}
	else if(!g.test(pincode1)){
			$("#pincodeNosError1").show();
			d=true;
	}else if(pincode1.length<6){
		$("#pinLengthError1").show();
		d=true;
	}
	
	
	var debarment = $("input[name=debarment]:checked").length;
	var fc = $("input[name=fir_cases]:checked").length;
	var fcp = $("input[name=fir_cases_pending]:checked").length;
	var arrested = $("input[name=arrested]:checked").length;
	var cca = $("input[name=criminal_case_acquitted]:checked").length;
	var ghb = $("input[name=good_behavior_bond]:checked").length;
	
	var firno=trim1($("#firno").val());
	var firdate=trim1($("#recordClientFirdate").val());
	var firsection=trim1($("#firsection").val());
	//var fir_other_section=trim1($("#fir_other_section").val());
	var firdistrict=trim1($("#firdistrict").val());
	var firstatus=trim1($("#firstatus").val());
	
	var examorganizer=trim1($("#examorganizer").val());
	var examname=trim1($("#examname").val());
	var examdate=trim1($("#recordClientExamdate").val());
	var debarenddate=trim1($("#recordClientDebarEnddate").val());
	var debar_reason=trim1($("#debar_reason").val());
	var other_reason=trim1($("#other_reason").val());
	
	if (debarment < 1){
        $("#errormessage").show();
		d=true;
    }
	if (fc < 1){
        $("#errormessage1").show();
		d=true;
    }
	if (fcp < 1){
        $("#errormessage2").show();
		d=true;
    }
	if (arrested < 1){
        $("#errormessage3").show();
		d=true;
    }
	if (cca < 1){
        $("#errormessage4").show();
		d=true;
    }
	if (ghb < 1){
        $("#errormessage5").show();
		d=true;
    }
	var debarmentValue = $('input:radio[name=debarment]:checked').val();
	if(debarmentValue=="true")
	{
		if(examorganizer==""){
			$("#deb_errormessage1").show();
			d=true;
		}
		if(examname==""){
			$("#deb_errormessage2").show();
			d=true;
		}
		if(examdate==""){
			$("#deb_errormessage3").show();
			d=true;
		}
		if(debarenddate==""){
			$("#deb_errormessage4").show();
			d=true;
		}
		if(debar_reason==""){
			$("#deb_errormessage5").show();
			d=true;
		}else if(debar_reason=="Others"){
			if(other_reason==""){
				$("#deb_errormessage6").show();
				d=true;
			}
		}
	}
	
	var fcValue = $("input:radio[name=fir_cases]:checked").val();
	var fcpValue = $("input:radio[name=fir_cases_pending]:checked").val();
	var arrestedValue = $("input:radio[name=arrested]:checked").val();
	var ccaValue = $("input:radio[name=criminal_case_acquitted]:checked").val();
	var ghbValue = $("input:radio[name=good_behavior_bond]:checked").val();
	if(fcValue=="true" || fcpValue=="true" || arrestedValue=="true" || ccaValue=="true" || ghbValue=="true"){
		if(firno==""){
			$("#errormessage6").show();
			d=true;
		}
		if(firdate==""){
			$("#errormessage7").show();
			d=true;
		}else{
			if(!dateDiff(document.applicationForm.dob.value,firdate)){
				alert("Fir Date should be Greater than Date of birth");
				return false;
			}
		}
		if(firsection==""){
			$("#errormessage8").show();
			d=true;
		}
		if(firdistrict==""){
			$("#errormessage9").show();
			d=true;
		}
		if(firstatus==""){
			$("#errormessage10").show();
			d=true;
		}
	}
	
	var password=trim1($("#password").val());
	var confirm_password=trim1($("#confirm_password").val());
	if(password==""){
		$("#passwordError").show();
		d=true;
	}else if(password.length<6){
		$("#passwordLengthError").show();
		d=true;
	}else if(password!=confirm_password){
		$("#passwordMatchError").show();
		d=true;
	}
	
	
	
	
	if(d==true){
		return false;
	}else{
	    var agree_save = document.applicationForm.agree_save.checked;
	    var agree_save1 = document.applicationForm.agree_save1.checked;
		if (agree_save == true && agree_save1 == true) { 
			if(secondPagevalidation()){
	    		if((firstPagevalidation)){
	    			if(fourthPagevalidation()){
	    				if(ageValidation()){
	    					document.applicationForm.district_h.value = document.applicationForm.district.value;
	    					document.applicationForm.district_h1.value = document.applicationForm.district1.value;
	    					
	    					if(fcValue=="true" || fcpValue=="true" || arrestedValue=="true" || ccaValue=="true" || ghbValue=="true"){
	    						alert("Your application is provissionally accepted subject to outcome of CourtCase, in case you found convicted by court, your application will be rejected.");	
	    					}
	    					return true;
	    					}
	    				}}}
			
	    		} else{
	    			alert("Please check Declaration to continue");
	   			     return false;
	    		} 
		 return false;
	}
	    
	
});

$("#village").keyup(function(){
	if(!($("#village").val()==""))
		{$("#villageError1").hide();}
});
$("#postoffice").keyup(function(){
	if(!($("#postoffice").val()==""))
		{$("#postofficeError1").hide();}
});
$("#tehsil").keyup(function(){
	if(!($("#tehsil").val()==""))
		{$("#tehsilError1").hide();}
});
$("#policestation").keyup(function(){
	if(!($("#policestation").val()==""))
		{$("#policestationError1").hide();}
});
$("#state").change(function(){
	if(!($("#state").val()==""))
		{$("#stateError1").hide();}
});
$("#recordZipcode").keyup(function(){
	if(!($("#recordZipcode").val()==""))
		{$("#pincodeError1").hide();}
});
$("#district").change(function(){
	if(!($("#district").val()==""))
		{$("#districtError1").hide();}
});
$("#village1").keyup(function(){
	if(!($("#village1").val()==""))
		{$("#villageError1").hide();}
});
$("#postoffice1").keyup(function(){
	if(!($("#postoffice1").val()==""))
		{$("#postofficeError1").hide();}
});
$("#tehsil1").keyup(function(){
	if(!($("#tehsil1").val()==""))
		{$("#tehsilError1").hide();}
});
$("#policestation1").keyup(function(){
	if(!($("#policestation1").val()==""))
		{$("#policestationError1").hide();}
});
$("#state1").change(function(){
	if(!($("#state1").val()==""))
		{$("#stateError1").hide();}
});
$("#recordZipcode1").keyup(function(){
	if(!($("#recordZipcode1").val()==""))
		{$("#pincodeError1").hide();}
});
$("#district1").change(function(){
	if(!($("#district1").val()==""))
		{$("#districtError1").hide();}
});



$("#debarment").change(function(){
	var debarment = $("input[name=debarment]:checked").length;
	if(debarment==1)
		{$("#errormessage").hide();}
});
$("#fir_cases").change(function(){
	var fc = $("input[name=fir_cases]:checked").length;
	if(fc==1)
		{$("#errormessage1").hide();}
});
$("#fir_cases_pending").change(function(){
	var fcp = $("input[name=fir_cases_pending]:checked").length;
	if(fcp==1)
		{$("#errormessage2").hide();}
});
$("#arrested").change(function(){
	var arrested = $("input[name=arrested]:checked").length;
	if(arrested==1)
		{$("#errormessage3").hide();}
});
$("#criminal_case_acquitted").change(function(){
	var cca = $("input[name=criminal_case_acquitted]:checked").length;
	if(cca==1)
		{$("#errormessage4").hide();}
});
$("#good_behavior_bond").change(function(){
	var ghb = $("input[name=good_behavior_bond]:checked").length;
	if(ghb==1)
		{$("#errormessage5").hide();}
});
$("#firno").keyup(function(){
	if(!($("#firno").val()==""))
		{$("#errormessage6").hide();}
});
$("#recordClientFirdate").keyup(function(){
	if(!($("#recordClientFirdate").val()==""))
		{$("#errormessage7").hide();}
});
$("#firsection").keyup(function(){
	if(!($("#firsection").val()==""))
		{$("#errormessage8").hide();}
});
$("#fir_other_section").keyup(function(){
	if(!($("#fir_other_section").val()==""))
		{$("#errormessage8_other").hide();}
});

$("#firdistrict").keyup(function(){
	if(!($("#firdistrict").val()==""))
		{$("#errormessage9").hide();}
});
$("#firstatus").keyup(function(){
	if(!($("#firstatus").val()==""))
		{$("#errormessage10").hide();}
});
$("#examorganizer").keyup(function(){
	if(!($("#examorganizer").val()==""))
		{$("#deb_errormessage1").hide();}
});
$("#examname").keyup(function(){
	if(!($("#examname").val()==""))
		{$("#deb_errormessage2").hide();}
});
$("#debar_reason").change(function(){
	if(!($("#debar_reason").val()==""))
		{$("#deb_errormessage5").hide();}
});
$("#other_reason").keyup(function(){
	if(!($("#other_reason").val()==""))
		{$("#deb_errormessage6").hide();}
});

		

		$("#secondDivBack").click(function() {
			$("#div1").show();
			$("#div3").hide();
			window.scrollTo(0,0);

		});

		/**
		This function will call when Select the Post in Post Dropdown and sets the Validation rules (Age & Education) against selected post
		*/	
		$('#post_applied').change(function() {
			communityText();
			var min_qual="",min_qual1="",max_age1="",min_age="";
			var post_applied=$( "#post_applied" ).val();
			var post_applied_value = $("#post_applied option:selected").html();
			$( "#post_selected_name" ).val(post_applied_value);
			
			$('#post_selected_name_declaration').text(post_applied_value);
			max_age="27";
			min_age="18";
			$('#gender_select').show();
			$('#gender_label').hide();
			 $("#sex").val("");
			
			$('#post_selected_id').text(post_applied_value);
			
			if(post_applied=="1" || post_applied=="4"){
				document.getElementById("others").style.display = "none";
			}
			else{
				document.getElementById("others").style.display = "block";
			}
			
			if(post_applied=="1"){
				 min_age="18";
				max_age="27"; 
				//  alert(1.1)
				$('#hc_lab_asst').removeClass('hc_lab_asst'); 
				$('#hc_lab_asst_work').removeClass('hc_lab_asst_work'); 
				$('#hc_physio_asst').addClass('hc_physio_asst'); 
				$('#hc_physio_asst_work').addClass('hc_physio_asst_work'); 
				$('#ct_nursing_asst').addClass('ct_nursing_asst'); 
				$('#ct_nursing_asst_work').addClass('ct_nursing_asst_work'); 

				$('input[name="hc_physio_asst_cert"]:checked').each(function() {
				    $(this).prop('checked', false);
				});
				$('input[name="hc_physio_asst_exp"]:checked').each(function() {
				    $(this).prop('checked', false);
				}); 

				$('input[name="ct_nursing_asst_cert"]:checked').each(function() {
				    $(this).prop('checked', false);
				});
				// alert(1.2)
				$('input[name="ct_nursing_asst_exp"]:checked').each(function() {
				    $(this).prop('checked', false);
				}); 

			}
			 
			else if(post_applied=="3"){
				 max_age="27";
					min_age="18";
// alert(2.1)
					$('#hc_lab_asst').addClass('hc_lab_asst'); 
				$('#hc_lab_asst_work').addClass('hc_lab_asst_work');

					$('#hc_physio_asst').removeClass('hc_physio_asst'); 
				$('#hc_physio_asst_work').removeClass('hc_physio_asst_work'); 

				$('#ct_nursing_asst').addClass('ct_nursing_asst'); 
					$('#ct_nursing_asst_work').addClass('ct_nursing_asst_work'); 
				 
					
					$('input[name="hc_lab_asst_cert"]:checked').each(function() {
				    $(this).prop('checked', false);
				});
				$('input[name="hc_lab_asst_exp"]:checked').each(function() {
				    $(this).prop('checked', false);
				});

				$('input[name="ct_nursing_asst_cert"]:checked').each(function() {
				    $(this).prop('checked', false);
				});

				$('input[name="ct_nursing_asst_exp"]:checked').each(function() {
				    $(this).prop('checked', false);
				}); 
				// alert(2.2)
				


			}
			else if(post_applied=="4"){
				 max_age="27"; 
					min_age="18"; 
					// alert(3.1)

				$('#hc_lab_asst').addClass('hc_lab_asst'); 
				$('#hc_lab_asst_work').addClass('hc_lab_asst_work');
				   
					$('#hc_physio_asst').addClass('hc_physio_asst'); 
				$('#hc_physio_asst_work').addClass('hc_physio_asst_work');  

				$('#ct_nursing_asst').removeClass('ct_nursing_asst'); 
				$('#ct_nursing_asst_work').removeClass('ct_nursing_asst_work');  
					
				$('input[name="hc_lab_asst_cert"]:checked').each(function() {
					$(this).prop('checked', false);
				});
				$('input[name="hc_lab_asst_exp"]:checked').each(function() {
				    $(this).prop('checked', false);
				}); 

				$('input[name="hc_physio_asst_cert"]:checked').each(function() {
				    $(this).prop('checked', false);
				});
				$('input[name="hc_physio_asst_exp"]:checked').each(function() {
				    $(this).prop('checked', false);
				}); 
				// alert(3.2)
					
			}
			
			
			
			 $("#min_qual").val(min_qual);
			 $("#min_qual1").val(min_qual1);
			
			$("#max_age").val(max_age);
			$("#min_age").val(min_age);
				
			
		});
		
		
		/**
		Below functions willc all when radio group options selected yes / No. and respective table will hide /show
		*/	
		
		$("input:radio[id=categotybelongsid]").click(function() {
			var value = $(this).val();
			if (value == "true")
				$("#catdetailsdiv").show();
			else
				$("#catdetailsdiv").hide();

		});
		
		$("input:radio[id=jkdomiciledid]").click(function() {
			var value = $(this).val();
			if (value == "true")
				$("#jkdomiciledetailsdiv").show();
			else
				$("#jkdomiciledetailsdiv").hide();

		});
		
		$("input:radio[id=riotsaffectedid]").click(function() {
			var value = $(this).val();
			if (value == "true")
				$("#riotsdetailsdiv").show();
			else
				$("#riotsdetailsdiv").hide();

		});
		
		/* $("input:radio[id=riotsgujaratid]").click(function() {
			var value = $(this).val();
			if (value == "true")
				$("#riots_gujarat_detailsdiv").show();
			else
				$("#riots_gujarat_detailsdiv").hide();

		});
		 */
		$("input:radio[id=exservicemanid]").click(function() {
			var value = $(this).val();
			if (value == "true")
				$("#exdetailsdiv").show();
			else
				$("#exdetailsdiv").hide();

		});
		$("input:radio[id=debarmentid]").click(function() {
			var value = $(this).val();
			if (value == "true")
				$("#debardetailsdiv").show();
			else
				$("#debardetailsdiv").hide();
		});
		
		/**
		This function will call when Select the Permanent State in State Dropdown and sets Districts in district dropdown against selected state
		*/	
		$('#state').change(function() {
			var state=$( "#state" ).val();
			//alert("state="+state);
			$('#district').empty().append('<option selected="selected" value="">Select District</option>');
			 $.getJSON("districts_json.txt",function(result){
			      $.each(result, function(i, field){
			    	  //alert("field="+field);
			    	  if(state==i){
			    		
				    	var districtsArr = field.split(",");
				        districtsArr.forEach(function(item) {
					        $('#district').append($('<option>', { 
					            value: item,
					            text : item 
					        }));
				        });
			    	  }
			      });
			 }); 
		});
		
		/**
		This function will call when Select the Correespondance State in State Dropdown and sets Districts in district dropdown against selected state
		*/	
		$('#state1').change(function() {
			var state=$( "#state1" ).val();
			$('#district1').empty().append('<option selected="selected" value="">Select District</option>');
			 $.getJSON("districts_json.txt",function(result){
			      $.each(result, function(i, field){
			    	  if(state==i){
				    	var districtsArr = field.split(",");
				        districtsArr.forEach(function(item) {
					        $('#district1').append($('<option>', { 
					            value: item,
					            text : item 
					        }));
				        });
			    	  }
			      });
			 }); 
		});
		 
		/* $("input:radio[id=categoryid]").click(function() {
	         categoryText();
		});	
		
		$("input:radio[id=communityid]").click(function() {
			communityText();
			ssbServiceText();
			govtServiceText();
		}); */
		
		$("#category").change(function(){
				 categoryText();
		});
		
		$("#religion").change(function(){
			var religion = trim1($("#religion").val());
			if(religion=="Others"){
				 $("#other_religion_id").show();
			}else{
				 $("#other_religion_id").hide();
			}
	     });
		
		$("#nationality").change(function(){
			var nationality = trim1($("#nationality").val());
			if(nationality=="Others"){
				var post_applied=$( "#post_applied" ).val();
				//if(post_applied=="2" || post_applied=="28" || post_applied=="3" || post_applied=="6" || post_applied=="30" || post_applied=="7" || post_applied=="9" || post_applied=="10" || post_applied=="26" || post_applied=="27"){
				     $("#other_nationality_id").show();
				/* }else{
					 $("#other_nationality_id").hide();
					 alert("A Citizen of India Only can apply for this post");
				} */
			}else{
				 $("#other_nationality_id").hide();
			}
	     });
		
	
		$("#community").change(function(){
				communityText();
				ssbServiceText();
				//govtServiceText();
		});
	    $("input:checkbox[id=affected_cat_ids]").click(function() {
	    	 affectedIdsText();
	    });
	    $("input:radio[id=employee_ssb_id]").click(function() {
			ssbServiceText();
		});
		/* $("input:radio[id=govt_service_id]").click(function() {
			govtServiceText();
		}); */

	      $("input:radio[name=fir_cases]").click(function() {
				  showFirDetails();
		   });
		  
		  $("input:radio[name=fir_cases_pending]").click(function() {
			  showFirDetails();
			});
		  
		  $("input:radio[name=arrested]").click(function() {
			  showFirDetails();
			});
		  
		  $("input:radio[name=criminal_case_acquitted]").click(function() {
			  showFirDetails();
			});
		  
		  $("input:radio[name=good_behavior_bond]").click(function() {
			  showFirDetails();
			});
		  
	
	});
</script>
<script type="text/javascript">
function communityText(){
	//var gender = $("input:radio[name=sex]:checked").val();
	var gender = trim1($("#sex").val());
	//var value = $("input:radio[name=community]:checked").val();
	var value = trim1($("#community").val());
	var post_applied = trim1($("#post_applied").val())
	
   if(post_applied=="1"){
		$('#postCert').show();
	    $('#postCert').html("(i) 12th class pass with Biology as a subject from a recognized Board, <br/> (ii) Certificate course of a duration of minimum one year in Laboratory Assistant Course from a recognized institution, and <br/>(iii) Working experience of duration of minimum One year as Lab Assistant in Laboratory Diagnostic Centre or hospital or institution lab recognized by the Central Government or State Government. ");
	}
	
	// if(post_applied=="2"){
	// 	$('#postCert').show();
	//     $('#postCert').html("(i) 12th class pass from a recognized Board. <br/> (ii)  Certificate course of  duration of  minimum one year in Physiotherapy from a recognized institute, and <br/>(iii) Experience of duration of minimum one year as Physiotherapy Assistant from a Physiotherapy Centre or minimum hundred bedded hospital or institute recognised by the Central Government or State Government. ");
	// }
	
	if(post_applied=="3"){
		$('#postCert').show();
	     $('#postCert').html("(i) 12th class pass from a recognized Board. <br/> (ii)  Certificate course of  duration of  minimum one year in Physiotherapy from a recognized institute, and <br/>(iii) Experience of duration of minimum one year as Physiotherapy Assistant from a Physiotherapy Centre or minimum hundred bedded hospital or institute recognised by the Central Government or State Government. ");
	}
	
	if(post_applied=="4"){
		$('#postCert').show();
	    $('#postCert')
		.html("(i) 10th class pass from a recognized Board,  <br/> (ii)  First Aid certificate course from St. John’s Ambulance Organization or Red Cross Society of India, and <br/>(iii) Experience of duration of minimum one year as Nursing Assistant in a minimum fifty bedded Hospital or Institution recognised by the Central Government or State Governments. ");
	}
	// (i) Should have passed 10+2 in Science or equivalent from a recognized University or Board or Institution. <br />(ii) Should have three years Diploma in General nursing from an Institution recognized by the State or Central Government.<br />(iii) Must be registered with Central or State Nursing Council.<br />(iv) Two years Experience in a recognised Hospital  <br/><br/><br/> 
	
	
	
	if(value=="" || value==undefined ){
		$('#communityCert').hide();
		$('#communityCertAge').hide();
	} if(value=="General" ){
		$('#communityCert').hide();
		$('#communityCertAge').show();
		 $('#communityCertAge').html("Note: You have selected "+value+" Category, There will be no relaxation in age");
	}else if(value=="EWS"){ 
		$('#communityCert').show();
		$('#communityCertAge').show();
	    $('#communityCert').html("Note: 1. You have selected "+value+" Category. <br/>Please make sure to Submit Relevant Certificate at the time of Document Verification. (Please refer Advertisement of Job Notification for the format of relevant Certificate)");
	    $('#communityCertAge').html("2. There will be no relaxation in age");
   }else if(value=="OBC"){ 
		$('#communityCert').show();
		$('#communityCertAge').show();
	    $('#communityCert').html("Note: 1. You have selected "+value+" Category. <br/>Please make sure to Submit Relevant Certificate at the time of Document Verification. (Please refer Advertisement of Job Notification for the format of relevant Certificate)");
	    $('#communityCertAge').html("2. There will be relaxation in age for 3 years");
   }else if(value=="SC" || value=="ST"){ 
		$('#communityCert').show();
		$('#communityCertAge').show();
	    $('#communityCert').html("Note: 1. You have selected "+value+" Category. <br/>Please make sure to Submit Relevant Certificate at the time of Document Verification. (Please refer Advertisement of Job Notification for the format of relevant Certificate)");
	    $('#communityCertAge').html("2. There will be relaxation in age for 5 years");
	}
}
function categoryText(){
	var value = trim1($("#category").val());
	if(value=="" || value==undefined){
		$('#categoryCert').hide();
	}else if(value=="None"){
		$('#categoryCert').hide();
	}else{
		$('#categoryCert').show();
		$('#categoryCert').html("Note: 1. You have selected "+value+". <br/>Please make sure to Submit Relevant Certificate at the time of Document Verification. (Please refer Advertisement of Job Notification for the format of relevant Certificate)");
	}
}
function ssbServiceText(){
	var value = $("input:radio[name=employee_ssb]:checked").val();
	if(value==undefined){
		$('#ssbtextdiv').hide();
	}else if(value=="true"){
		//var community = $("input:radio[name=community]:checked").val();
		var community = trim1($("#community").val());
		$('#ssbtextdiv').show();
		var ageText="";
		if(community=="General" || community=="EWS")
			ageText="Maximum age up to 40 years.";
		else if (community=="OBC")
			ageText="Maximum age up to 43 years.";
		else{
			ageText="Maximum age up to 45 years.";
		}
		$('#ssbtextdiv').html("Note:You have selected Employed In Departmental is Yes. <br/>"+ageText);
	}else if(value=="false"){
		$('#ssbtextdiv').hide();
	}
}
function govtServiceText(){
	var value = $("input:radio[name=govt_service]:checked").val();
	if(value==undefined){
		$('#govtservicetextdiv').hide();
	}else if(value=="true"){
		$('#govtservicetextdiv').show();
		//var community = $("input:radio[name=community]:checked").val();
		var community = trim1($("#community").val());
		var ageText;
		ageText="The upper age limit up to 5 years is relaxable for Government Service";
		$('#govtservicetextdiv').html("Note:You have selected Government service is Yes. <br/>");
	}else if(value=="false"){
		$('#govtservicetextdiv').hide();
	}
}
function affectedIdsText(){
	var checkbox1=false;
	var checkbox2=false;
	var checkbox3=false;
	$('input:checkbox[name=affected_cat_ids]').each(function() 
	{    
	    if($(this).is(':checked')){
	      var value=$(this).val();
	      if(value=="1")
	    	  checkbox1=true;
	      if(value=="2")
	    	  checkbox2=true;
	      if(value=="3")
	    	  checkbox3=true;
	    }
	});
	//var community = $("input:radio[name=community]:checked").val();
	var community = trim1($("#community").val());
	var count=0;
	if(checkbox1){
		count++;
		$('#checkbox1div').show();
		$('#checkbox1div').html("Note: 1. You have selected Domiciled ordinarily in J&amp;K during 1980 to 1989. <br/>You have to produce a certificate from concerned District Collector to claim such relaxation in age.");
	}else
		$('#checkbox1div').hide();
	
	if(checkbox2){
		count++;
		$('#checkbox2div').show();
		$('#checkbox2div').html("Note: 1. You have selected Affected in 1984 riots. <br/>You have to produce a certificate to the effect, issued by the concerned District Collector to claim such relaxation in age.");
	}else
		$('#checkbox2div').hide();
	
	if(checkbox3){
		count++;
		$('#checkbox3div').show();
		$('#checkbox3div').html("Note: 1. You have selected Affected in 2002 communal riots of Gujarat. <br/>You have to produce a certificate to the effect, issued by the concerned District Collector to claim such relaxation in age.");
	}else
		$('#checkbox3div').hide();
	
	$('#relaxationTextdiv').hide();
	var relaxationText="";
	if(count>=1){
		$('#relaxationTextdiv').show();
		if(community=="SC" || community=="ST")
		relaxationText="The Relaxation in upper age limit of 10 years";
		else if(community=="OBC")
			relaxationText="The Relaxation in upper age limit of 8 years";
		else if(community=="General")
			relaxationText="The Relaxation in upper age limit of 5 years";
		$('#relaxationTextdiv').html(relaxationText);
	}/* else if(count>1){
		$('#relaxationTextdiv').show();
		relaxationText="The Relaxation in upper age limit of 5 years";
		$('#relaxationTextdiv').html(relaxationText);
	} */else{
		$('#relaxationTextdiv').hide();
	}
	
	
}
function showFirDetails()
{
	    var fcValue = $("input:radio[name=fir_cases]:checked").val();
		var fcpValue = $("input:radio[name=fir_cases_pending]:checked").val();
		var arrestedValue = $("input:radio[name=arrested]:checked").val();
		var ccaValue = $("input:radio[name=criminal_case_acquitted]:checked").val();
		var ghbValue = $("input:radio[name=good_behavior_bond]:checked").val();
		if(fcValue=="true" || fcpValue=="true" || arrestedValue=="true" || ccaValue=="true" || ghbValue=="true"){
			$('#fir_details').show();
		}else{
			$('#fir_details').hide();
		}
}

/** Education Validation function */
function firstPagevalidation(){
	
	//var v=getCheckedRadio(document.applicationForm.edu_qual);
	//var edu_qual=v.value;
	var edu_qual="Senior Secondary School Certificate(10+2) examination or Intermediate Or equivalent examination of a Recognized board/University";	
	
	var ep1=document.applicationForm.exam_passed_1.value;
	var stream1=document.applicationForm.stream_1.value;
	var uni1=document.applicationForm.university_1.value;
	var es1=document.applicationForm.edu_rollno_1.value;
	var ey1=document.applicationForm.edu_certno_1.value;
	var em1=document.applicationForm.edu_date_issue_1.value;
	var edm1=document.applicationForm.edu_marks_1.value;
	var eyear1=document.applicationForm.edu_year_1.value;
	
	
	
	
	var post_applied=document.applicationForm.post_applied.value;
	var post_applied_value = $("#post_applied option:selected").html();
	
	var dob = document.applicationForm.dob.value;
	var dobArr = dob.split("-");
	
	var byr=(dobArr[2]);
	var bmo=(dobArr[1]);
	var bday=(dobArr[0]);
	var years_ssc=Number(byr)+12;
	var date_ssc=bday+"-"+bmo+"-"+years_ssc;
	
	var date_ug="";
	
		var edu1=false,edu2=false,edu3=false,edu4=false,edu6=false,edu7=false;
		
		if(ep1!="" && ey1!="" && es1!="" && em1!="" && uni1!="" && stream1!="" && edm1!="" && eyear1!="")
		{
			edu1=true;
			if(!dateDiff(dob,em1)){
				alert("Date Of Issued should be Greater than Date of birth for Matriculation Certificate");
				return false;
			}
			var arr = em1.split("-",3);
			if(eyear1>arr[2]){
				alert("Date Of Issued should be Greater than or equal to year of exam for Matriculation Certificate");
				return false;
			}
			
			if(!dateDiff(em1,lessEqualCheck)){ //"19-06-2023"
				alert(`Matriculation Certificate Issued Date / Passing Year & Date should be less than or equal to ${maxDateValue}`); // 18-06-2023
				return false;
			}
			if(eyear1<years_ssc){
				alert("Matriculation Year of Exam should be atleast 12 years after Date of birth");
				return false;
			}
			if(!dateDiff(date_ssc,em1)){
				alert("Matriculation Certificate Issued Date / Passing Year & Date should be atleast 12 years after Date of birth");
				return false;
			}
			if(parseFloat(edm1,10)>100 || parseFloat(edm1,10)<=0){
				alert("Please select valid aggregate percentage of marks for Matriculation Certificate");
				return false;
			}
			
			 var em1Arr = em1.split("-");
				var em1yr=(em1Arr[2]);
				var em1mo=(em1Arr[1]);
				var em1day=(em1Arr[0]);
				var years_ug=Number(em1yr)+1;
				date_ug=em1day+"-"+em1mo+"-"+years_ug;
		}
		
		 
				 if(edu1==false){
					alert("Please enter Matriculation Education details  ");
					return false;
				 }
				
					 
					    var ep2=document.applicationForm.exam_passed_plus2.value;
						var stream2=document.applicationForm.stream_plus2.value;
						var uni2=document.applicationForm.university_plus2.value;
						var es2=document.applicationForm.edu_rollno_plus2.value;
						var ey2=document.applicationForm.edu_certno_plus2.value;
						var em2=document.applicationForm.edu_date_issue_plus2.value;
						var edm2=document.applicationForm.edu_marks_plus2.value;
						var eyear2=document.applicationForm.edu_year_plus2.value;
						var edu3=false;
						var interStatus = false;
						if(ep2!="" && ey2!="" && es2!="" && em2!="" && uni2!="" && stream2!="" && edm2!="" && eyear2!="")
						{
							edu3=true;
							
							if(!dateDiff(dob,em2)){
								alert("Date Of Issued should be Greater than Date of birth for 10+2 Certificate");
								return false;
							}
							var arr = em2.split("-",3);
							if(eyear2>arr[2]){
								alert("Date Of Issued should be Greater than or equal to year of exam for 10+2 Certificate");
								return false;
							}
							
							if(!dateDiff(em2,lessEqualCheck)){ //"19-06-2023"
								alert(`10+2 Certificate Issued Date / Passing Year & Date should be less than or equal to ${maxDateValue} `); // 18-06-2023
								return false;
							}
							if(edu1==true){
								if(!dateDiff(date_ug,em2)){
									alert("10+2 Certificate Issued Date should be atleast 1 year after Matriculation Passing Date");
									return false;
								}
								
								
							}
							if(parseFloat(edm2,10)>100 || parseFloat(edm2,10)<=0){
								alert("Please select valid aggregate percentage of marks for 10+2 Certificate");
								return false;
							}
						}
						else{
						 if(post_applied=="1" || post_applied=="3" ){
								alert("Please enter 10+2 details  ");
								return false;
						 } 
						  
						}
						 
						 
						 
						    var ep3=document.applicationForm.exam_passed_3.value;
							var stream3=document.applicationForm.stream_3.value;
							var uni3=document.applicationForm.university_3.value;
							var es3=document.applicationForm.edu_rollno_3.value;
							var ey3=document.applicationForm.edu_certno_3.value;                                                                                                                                                                                                                                        
							var em3=document.applicationForm.edu_date_issue_3.value;
							var edm3=document.applicationForm.edu_marks_3.value;
							var eyear3=document.applicationForm.edu_year_3.value;
							var edug3=false;
							var edug4=false;
							if(ep3!="" && ey3!="" && es3!="" && em3!="" && uni3!="" && stream3!="" && edm3!="" && eyear3!=""){
								if(!dateDiff(dob,em3)){
									alert("Date Of Issuedd should be Greater than Date of birth for Graduation Certificate");
									return false;
								}
								
								var arr = em3.split("-",3);
								if(eyear3>arr[2]){
									alert("Date Of Issued should be Greater than or equal to year of exam for Graduation Certificate");
									return false;
								}
								
								if(!dateDiff(em3,lessEqualCheck)){ //"19-06-2023"
									alert(`Graduation Certificate Issued Date / Passing Year & Date should be less than or equal to ${maxDateValue} `); // 18-06-2023
									return false;
								}
								 
								
								if(parseFloat(edm3,10)>100 || parseFloat(edm3,10)<=0){
									alert("Please select valid aggregate percentage of marks for Graduation Certificate");
									return false;
								}
							}

							 
							
							    var ep4=document.applicationForm.exam_passed_4.value;
								var stream4=document.applicationForm.stream_4.value;
								var uni4=document.applicationForm.university_4.value;
								var es4=document.applicationForm.edu_rollno_4.value;
								var ey4=document.applicationForm.edu_certno_4.value;
								var em4=document.applicationForm.edu_date_issue_4.value;
								var edm4=document.applicationForm.edu_marks_4.value;
								var eyear4=document.applicationForm.edu_year_4.value;
								var edu4=false;
								if(ep4!="" && ey4!="" && es4!="" && em4!="" && uni4!="" && stream4!="" && edm4!="" && eyear4!=""){
									if(!dateDiff(dob,em4)){
										alert("Date Of Issued should be Greater than Date of birth for Post Graduation Certificate");
										return false;
									}
									
									var arr = em4.split("-",3);
									if(eyear4>arr[2]){
										alert("Date Of Issued should be Greater than or equal to year of exam for Post Graduation Certificate");
										return false;
									}
									
									if(!dateDiff(em4,lessEqualCheck)){ //"19-06-2023"
										alert(`Post Graduation Certificate Issued Date / Passing Year & Date should be less than or equal to ${maxDateValue} `); // 18-06-2023
										return false;
									}
									
									if(parseFloat(edm4,10)>100 || parseFloat(edm4,10)<=0){
										alert("Please select valid aggregate percentage of marks for Post Graduation Certificate");
										return false;
									}
								}
								
								
								
								    var epd4=document.applicationForm.exam_passed_5.value;
									var streamd4=document.applicationForm.stream_5.value;
									var unid4=document.applicationForm.university_5.value;
									var esd4=document.applicationForm.edu_rollno_5.value;
									var eyd4=document.applicationForm.edu_certno_5.value;
									var emd4=document.applicationForm.edu_date_issue_5.value;
									var edmd4=document.applicationForm.edu_marks_5.value;
									var eyeard4=document.applicationForm.edu_year_5.value;
									var edud4=false;
									if(epd4!="" && eyd4!="" && esd4!="" && emd4!="" && unid4!="" && streamd4!="" && edmd4!="" && eyeard4!=""){
										if(!dateDiff(dob,emd4)){
											alert("Date Of Issued should be Greater than Date of birth for Diploma Certificate");
											return false;
										}
										
										var arr = emd4.split("-",3);
										if(eyeard4>arr[2]){
											alert("Date Of Issued should be Greater than or equal to year of exam for Diploma Certificate");
											return false;
										}
										if(!dateDiff(emd4,lessEqualCheck)){ //"19-06-2023"
											alert(`Diploma Certificate Issued Date / Passing Year & Date should be less than or equal to ${maxDateValue} `); // 18-06-2023
											return false;
										} 
										
										if(parseFloat(edmd4,10)>100 || parseFloat(edmd4,10)<=0){
											alert("Please select valid aggregate percentage of marks for Diploma Certificate");
											return false;
										}
									}  

									if(post_applied=="1"){
										var inter = $("#stream_plus2").val();   
										 
										if(inter=="Biology" ){}  
										else{
											alert("You should have Biology as your subject in 12th class ");
											return false;
										}
									} 

		
		return true;
	}
	

	
	/** Category validations */
	function secondPagevalidation(){
		
		var dob=document.applicationForm.dob.value;
		var cat_belongs=getCheckedRadio(document.applicationForm.categoty_belongs);
		<%--Category Validations Start --%>
		if(cat_belongs){
			var cbv=cat_belongs.value;if(cbv=="true"){
			if(trim1(document.applicationForm.category.value)==""){alert("Please Select Community belongs to");return false;}
			if(trim1(document.applicationForm.cat_cert_no.value)==""){alert("Please Enter Certificate No for Community Certificate");return false;}
			if(trim1(document.applicationForm.cat_date_Issue.value)==""){alert("Please Select Date Of Issuedd for Community Certificate");return false;}
			if(trim1(document.applicationForm.cat_issue_authority.value)==""){alert("Please Enter Issuing Authority for Community Certificate");return false;}
			
			
			if(!dateDiff(dob,document.applicationForm.cat_date_Issue.value)){
				alert("Date Of Issuedd should be Greater than Date of birth for Community Certificate");
				return false;
			}
			
	      }
	   }
		
		var dobArr = dob.split("-");
		var byr=parseInt(dobArr[2]);
		//if(byr>=1980 && byr<=1989){
		
		var jk_domiciled=getCheckedRadio(document.applicationForm.jk_domiciled);
		<%--Category Validations Start --%>
		if(jk_domiciled){var jk_domiciledV=jk_domiciled.value;if(jk_domiciledV=="true"){
			if(trim1(document.applicationForm.jk_cert_no.value)==""){alert("Please Enter Certificate No for J&K Domicile Certificate");return false;}
			if(trim1(document.applicationForm.jk_date_Issue.value)==""){alert("Please Select Date Of Issued for J&K Domicile Certificate");return false;}
			if(trim1(document.applicationForm.jk_issue_authority.value)==""){alert("Please Enter Issuing Authority for J&K Domicile Certificate");return false;}
			
			if(!dateDiff(dob,document.applicationForm.jk_date_Issue.value)){
				alert("Date Of Issued should be Greater than Date of birth for J&K Domicile Certificate");
				return false;
			}
			
	      }
	   }
		//}
		
		var riots_affected=getCheckedRadio(document.applicationForm.riots_affected);
		<%--Category Validations Start --%>
		if(riots_affected){var riots_affectedV=riots_affected.value;if(riots_affectedV=="true"){
			if(trim1(document.applicationForm.riots_cert_no.value)==""){alert("Please Enter Certificate No for riots Certificate");return false;}
			if(trim1(document.applicationForm.riots_date_Issue.value)==""){alert("Please Select Date Of Issued for riots Certificate");return false;}
			if(trim1(document.applicationForm.riots_issue_authority.value)==""){alert("Please Enter Issuing Authority for riots Certificate");return false;}
			
			if(!dateDiff(dob,document.applicationForm.riots_date_Issue.value)){
				alert("Date Of Issued should be Greater than Date of birth for riots Certificate");
				return false;
			}
			
	      }
	   }
		
		
		var v=getCheckedRadio(document.applicationForm.ex_serviceman);
		
		<%-- Ex-Service man Validations Start --%>
		if(v){var i=v.value;if(i=="true"){
			
			var bmo=(dobArr[1]);
			var bday=(dobArr[0]);
			var years_exman=Number(byr)+16;
			var date_exman=bday+"-"+bmo+"-"+years_exman;
			
			
			if(trim1(document.applicationForm.exman_enrollment_date.value)==""){alert("Please Enter Date of Enrollment for Ex-Serviceman Certificate");return false;}
			if(trim1(document.applicationForm.exman_retirement_date.value)==""){alert("Please Enter Date of Retirement / Discharge for Ex-Serviceman Certificate");return false;}
			if(trim1(document.applicationForm.exman_med_cat.value)==""){alert("Please Enter Medical Category for Ex-Serviceman Certificate");return false;}
			/* if(trim1(document.applicationForm.exman_awd_dec.value)==""){alert("Please Enter Award or Decoration for Ex-Serviceman Certificate");return false;} */
			if(trim1(document.applicationForm.exman_discharge_reason.value)==""){alert("Please Enter Reasons for release/Discharge for Ex-Serviceman Certificate");return false;}
			var edq=getCheckedRadio(document.applicationForm.exman_edu_qual);
			if(!edq){
				alert("Please Select Education Qualification");
				return false;
			}
			
		 if(!dateDiff(dob,document.applicationForm.exman_enrollment_date.value)){
				alert("Date of Enrollment should be Greater than Date of birth for Ex-Serviceman");
				return false;
			} 
			if(!dateDiff(date_exman,document.applicationForm.exman_enrollment_date.value)){  //
				alert("Date of Enrollment should be Greater than 16 years after Date of birth for Ex-Serviceman");
				return false;
			}
			if(!dateDiff(dob,document.applicationForm.exman_retirement_date.value)){ //
				alert("Date of Retirement / Discharge should be Greater than Date of birth for Ex-Serviceman");
				return false;
			}
			var age = {};
			age=getAgeOfTwoDates(document.applicationForm.exman_enrollment_date.value,document.applicationForm.exman_retirement_date.value);
			//alert("diff="+age.years+"-"+age.months+"-"+age.days);
			if(age.years==0 && age.months<6){//
				alert("Date of Retirement / Discharge should be at least 6 Months after Date of Enrollment for Ex-Serviceman");
				return false;
			}
			 if(!dateDiff(document.applicationForm.exman_enrollment_date.value,document.applicationForm.exman_retirement_date.value)){
				alert("Date of Retirement / Discharge should be Greater than Date of Enrollment for Ex-Serviceman");
				return false;
			} 
			
	      }
	   }
		
		//var gs=getCheckedRadio(document.applicationForm.govt_service);
		var es=getCheckedRadio(document.applicationForm.employee_ssb);
		var govt_value=false;
		var emp_value=false;
		 
	/* 	if(gs){var gsv=gs.value; if(gsv=="true"){
			govt_value=true;
		}}  */
		if(es){var esv=es.value; if(esv=="true"){
			emp_value=true;
		}}
		<%-- Govt service Validations Start --%>
		if(emp_value){
			if(trim1(document.applicationForm.present_employer.value)==""){alert("Please Enter Name of Present Organization for Employment Certificate");return false;}
			if(trim1(document.applicationForm.emp_date_since.value)==""){alert("Please Enter Date Since When for Employment Certificate");return false;}
			if(trim1(document.applicationForm.post_held.value)==""){alert("Please Enter Post held for Employment Certificate");return false;}
			if(trim1(document.applicationForm.nocdesignation.value)==""){alert("Please Enter Issuing Authority (NOC) for Employment Certificate");return false;}
			if(!dateDiff(dob,document.applicationForm.emp_date_since.value)){
				alert("Date Since should be Greater than Date of birth for Employment");
				return false;
			}
			var dob = document.applicationForm.dob.value;
			var dobArr = dob.split("-");
			
			var byr=(dobArr[2]);
			var bmo=(dobArr[1]);
			var bday=(dobArr[0]);
			var years_ssc=Number(byr)+12;
			var date_ssc=bday+"-"+bmo+"-"+years_ssc;
			
			if(!dateDiff(date_ssc,document.applicationForm.emp_date_since.value)){
				alert("Date Since should be atleast 12 years after Date of birth for Employment");
				return false;
			}
		}
		
		/* if(govt_value){
			if(trim1(document.applicationForm.present_employer2.value)==""){alert("Please Enter Name of Present Organization for Government service");return false;}
			if(trim1(document.applicationForm.emp_date_since2.value)==""){alert("Please Enter Date Since When for Government service");return false;}
			if(trim1(document.applicationForm.post_held2.value)==""){alert("Please Enter Post held for Government service");return false;}
			if(trim1(document.applicationForm.nocdesignation2.value)==""){alert("Please Enter Issuing Authority (NOC) for Government service");return false;}
			if(!dateDiff(dob,document.applicationForm.emp_date_since2.value)){
				alert("Date Since should be Greater than Date of birth for Government service");
				return false;
			}
			var dob = document.applicationForm.dob.value;
			var dobArr = dob.split("-");
			
			var byr=(dobArr[2]);
			var bmo=(dobArr[1]);
			var bday=(dobArr[0]);
			var years_ssc=Number(byr)+12;
			var date_ssc=bday+"-"+bmo+"-"+years_ssc;
			if(!dateDiff(date_ssc,document.applicationForm.emp_date_since2.value)){
				alert("Date Since should be atleast 12 years after Date of birth for Government service");
				return false;
			}
		} */
		if(ageValidation()){
			return true;
		} 
		
		return false;
 	}
	
	/** FIR Page validations*/
	function fourthPagevalidation()
	{
		var db=getCheckedRadio(document.applicationForm.debarment);
		if(db){var dbv=db.value; if(dbv=="true"){
			if(!dateDiff(document.applicationForm.dob.value,document.applicationForm.examdate.value)){
				alert("Exam Date should be Greater than Date of birth");
				return false;
			}
			if(!dateDiff(document.applicationForm.examdate.value,document.applicationForm.debarenddate.value)){
				alert("Debarment End Date should be Greater than Exam Date");
				return false;
			}
			var debarenddate=document.applicationForm.debarenddate.value;
			var dobArr = debarenddate.split("-");
			var byr=(dobArr[2]);
			var bmo=(dobArr[1]);
			var bday=(dobArr[0]);
			debarenddate=byr+"-"+bmo+"-"+bday;
			var varDate = new Date(debarenddate); 
			var today = new Date();
			if(varDate > today) {
			   alert("Validity of Debarment is not yet completed.");
			   return false;
			}
			/* if(!dateDiff(document.applicationForm.dob.value,document.applicationForm.firdate.value)){
				alert("FIR Date Of Issued should be Greater than Date of birth");
				return false;
			} */
			/* if(!dateDiff(firdate,"22-08-2021")){
				alert("Fir Date should be less than 22-08-2021");
				d=true;
			} */
		}}
		
		return true;
	}
	
	function validation(){
		  var agree_save = document.applicationForm.agree_save.checked;
			if (agree_save == true) { 
				if(secondPagevalidation()){
		    		if((firstPagevalidation)){
		    			if(fourthPagevalidation()){
		    			   if(ageValidation()){
		    					document.applicationForm.district_h.value = document.applicationForm.district.value;
		    					document.applicationForm.district_h1.value = document.applicationForm.district1.value;
		    					return true;
		    				}
		    				}}}
		    		} else{
		    			alert("Please check Declaration to continue");
		   			     return false;
		    		} 
		    	return false;
		    }
			
	function dateDiff(startD,endD)
	{
		var dobArr = startD.split("-");
		var byr=(dobArr[2]);
		var bmo=(dobArr[1]);
		var bday=(dobArr[0]);
			startD=byr+"-"+bmo+"-"+bday;
		
		var dobArr1 = endD.split("-");
		var byr1=(dobArr1[2]);
		var bmo1=(dobArr1[1]);
		var bday1=(dobArr1[0]);
			endD=byr1+"-"+bmo1+"-"+bday1;
		
		var start = new Date(startD);
		var end = new Date(endD);
		var diff = new Date(end - start);
		var days = diff/1000/60/60/24;
		if(days>0){
			return true;
		}
		return false;
	}
	function dateDiffEqual(startD,endD)
	{
		var dobArr = startD.split("-");
		var byr=(dobArr[2]);
		var bmo=(dobArr[1]);
		var bday=(dobArr[0]);
			startD=byr+"-"+bmo+"-"+bday;
		
		var dobArr1 = endD.split("-");
		var byr1=(dobArr1[2]);
		var bmo1=(dobArr1[1]);
		var bday1=(dobArr1[0]);
			endD=byr1+"-"+bmo1+"-"+bday1;
			
		var start = new Date(startD);
		var end = new Date(endD);
		var diff = new Date(end - start);
		var days = diff/1000/60/60/24;
		if(days>=0){
			return true;
		}
		return false;
	}
	
	/** age validation*/
	function ageValidation(){
		
		var age_value=document.applicationForm.age_value.value;
		var age=document.applicationForm.age.value;
		var min_age=Number(document.applicationForm.min_age.value);
		var max_age=Number(document.applicationForm.max_age.value);
		var post_applied=document.applicationForm.post_applied.value;
		
		var sc_rel=Number(5);
		var obc_rel=Number(3);
		var gen_rel=Number(0);
		var exm_rel=Number(3);
		var riot_rel=Number(5);
		var exman=getCheckedRadio(document.applicationForm.ex_serviceman).value;
		var community = document.applicationForm.community.value;
		var jk_domiciled=false;
		var dob1 = document.applicationForm.dob.value;
		var dobArr = dob1.split("-");
		var byr=parseInt(dobArr[2]);
		//if(byr>=1980 && byr<=1989){
			jk_domiciled=getCheckedRadio(document.applicationForm.jk_domiciled).value;
		/* }else{
			jk_domiciled=false;
		} */
		var riots_gujarat="false";
		var riots_affected=getCheckedRadio(document.applicationForm.riots_affected).value;
		//var riots_gujarat=getCheckedRadio(document.applicationForm.riots_gujarat).value;
		//var govt_service=getCheckedRadio(document.applicationForm.govt_service).value;
		var ssb_service=getCheckedRadio(document.applicationForm.employee_ssb).value;
		//var affected_cat_ids = $("input[name=affected_cat_ids]:checked").length;
		var date_since=document.applicationForm.emp_date_since.value;
         
		
		var agevalidated=false;
		if(age<min_age){
			alert("Your age must be more than or equal to "+min_age+" years");
			return false;
		}
		if(!age_value.match("/0/0"))
		{
			age=Number(age)+1;
		}
		
		
		  if(exman=="true")
		{
			var exman_retirement_date=document.applicationForm.exman_retirement_date.value;
			var exman_enrollment_date=document.applicationForm.exman_enrollment_date.value;
			var exman_service=AgeCaluclateFor2Dates(exman_enrollment_date,exman_retirement_date);
			//alert("exman_service "+exman_service);
			//alert("age "+age);
			var exman_ser_age_diff=(age-exman_service);
		    //alert("exman_ser_age_diff "+exman_ser_age_diff);
			
			if(community=="General" || community=="EWS")
			{
				if(exman_ser_age_diff<=(max_age+3)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age is Not in Permissible Limit "+min_age+" TO "+(max_age+exman_service+3)+" for Ex-serviceman Candidates.");
				// 	return false;
				// }
			}
			if(community=="OBC")
			{
				if(exman_ser_age_diff<=(max_age+6)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age is Not in Permissible Limit "+min_age+" TO "+(max_age+exman_service+6)+" for Ex-serviceman Candidates.");
				// 	return false;
				// }
			}
		    if(community=="SC" || community=="ST")
		    {
				if(exman_ser_age_diff<=(max_age+8)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age is Not in Permissible Limit "+min_age+" TO "+(max_age+exman_service+8)+" for Ex-serviceman Candidates.");
				// 	return false;
				// }
			}
			
			
		}
		 
		  if(agevalidated==false && ssb_service=="true")
		  {
				var govtservice=AgeCaluclateFor2Dates(date_since,maxDateValue); // 18-06-2023
				if(govtservice>=3)
				{
					
							if(community=="SC" || community=="ST")
							{
								// if(age>=min_age && age<=40){
								if(age>=min_age && age<=45){
									agevalidated=true;
								}
								// else{
								// 	// alert("Your age must be in between "+min_age+" TO 40 for Departmental Candidates.");
								// 	alert("Your age must be in between "+min_age+" TO 45 for Departmental Candidates.");
								// 	return false;
								// }
							}
							else if(community=="OBC"){
								// if(age>=min_age && age<=38){
								if(age>=min_age && age<=43){
									agevalidated=true;
								}
								// else{
								// 	// alert("Your age must be in between "+min_age+" TO 38 for Departmental Candidates.");
								// 	alert("Your age must be in between "+min_age+" TO 43 for Departmental Candidates.");
								// 	return false;
								// }
							}else if(community=="General" || community=="EWS"){
								// if(age>=min_age && age<=35){
								if(age>=min_age && age<=40){
									agevalidated=true;
								}
								// else{
								// 	// alert("Your age must be in between "+min_age+" TO 35 for Departmental Candidates.");
								// 	alert("Your age must be in between "+min_age+" TO 40 for Departmental Candidates.");
								// 	return false;
								// }
							}else{
								alert("Please select Category.");
								return false;
							}
					
					
					
				}
				// else{
				// 	alert("You are not eligible for Departmental Candidates, due to service is less than 3 years");
				// 	return false;
				// }
			}
		
		
		if(agevalidated==false && (jk_domiciled=="true" || riots_gujarat=="true" || riots_affected=="true")){
			
			if(community=="SC" || community=="ST"){
				if(age>=min_age && age<=(max_age+10)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age must be in between "+min_age+" TO "+(max_age+10)+".");
				// 	return false;
				// }
			}else if(community=="OBC"){
				if(age>=min_age && age<=(max_age+8)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age must be in between "+min_age+" TO "+(max_age+8)+".");
				// 	return false;
				// }
			}else if(community=="General" || community=="EWS"){
				if(age>=min_age && age<=(max_age+5)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age must be in between "+min_age+" TO "+(max_age+5)+".");
				// 	return false;
				// }
			}else{
				alert("Please select Category.");
				return false;
			}
		}
		 if(agevalidated==false)
		{
			if(community=="SC" || community=="ST")
			{
				if(age>=min_age && age<=(max_age+sc_rel)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age must be in between "+min_age+" TO "+(max_age+sc_rel)+".");
				// 	return false;	
				// }	
			}
			if(community=="OBC")
			{
				if(age>=min_age && age<=(max_age+obc_rel)){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age must be in between "+min_age+" TO "+(max_age+obc_rel)+".");
				// 	return false;	
				// }
			}
			if(community=="General" || community=="EWS")
			{
				if(age>=min_age && age<=max_age){
					agevalidated=true;
				}
				// else{
				// 	alert("Your age must be in between "+min_age+" TO "+(max_age)+".");
				// 	return false;	
				// }
			}
	   } 
		
		if(agevalidated==false){
			// alert("Your age must be in between "+min_age+" TO "+(max_age)+".");
			alert("As per Advertisement cut off dates, You are not eligible due to OVER AGE");
			return false;	
		}else{
			return true;
		}  
		
	
		
	}
		

	function AgeCaluclate()
	{
		
		var dob = document.applicationForm.dob.value;
		var dobArr = dob.split("-");
		var byr=parseInt(dobArr[2]);
		var bmo=(dobArr[1]);
		var bday=parseInt(dobArr[0]);
		var tmpage=0,age=0;
		// tday=18;
		// tmo=06;
		// tyr=2023;
		tday=11;
		tmo=04;
		tyr=2026;
		
		if((tmo > bmo)||(tmo==bmo & tday>=bday))
		{tmpage=byr;}
		else
		{
			tmpage=byr+1;
		}
		age=(tyr-tmpage);
		
		return age;
	}
	
	
	function getAge() {
		
		//var now = new Date("2021","08","22");
		// var now = new Date("2023","06","18");
		var now = new Date("2026","04","11");
		var dob1 = document.applicationForm.dob.value;
		var dobArr = dob1.split("-");
		var byr=parseInt(dobArr[2]);
		var bmo=(dobArr[1]);
		var bday=parseInt(dobArr[0]);
		
		var yearNow = now.getYear();
		var monthNow = now.getMonth();
		var dateNow = now.getDate();

		/* if(byr>=1980 && byr<=1989){
			$('#jkdomicilerow').show();
		}
		else{
			$('#jkdomicilerow').hide();
				$("#jkdomiciledetailsdiv").hide();
		} */
		var dob = new Date(byr, bmo, bday );

		var yearDob = dob.getYear();
		var monthDob = dob.getMonth();
		var dateDob = dob.getDate();
		var age = {};
		var ageString = "";
		var yearString = "";
		var monthString = "";
		var dayString = "";
		yearAge = yearNow - yearDob;

		if (monthNow >= monthDob)
		var monthAge = monthNow - monthDob;
		else {
		yearAge--;
		var monthAge = 12 + monthNow -monthDob;
		}

		if (dateNow >= dateDob)
		var dateAge = dateNow - dateDob;
		else {
		monthAge--;
		var dateAge = 31 + dateNow - dateDob;

		if (monthAge < 0) {
		monthAge = 11;
		yearAge--;
		}
		}

		age = {
		years: yearAge,
		months: monthAge,
		days: dateAge
		};

		if ( age.years > 1 ) yearString = "Y";
		else yearString = "Y";
		if ( age.months> 1 ) monthString = "M";
		else monthString = "M";
		if ( age.days > 1 ) dayString = "D";
		else dayString = "D";

		if(age.years<=0)
			age.years=0;
		if(age.months<=0)
			age.months=0;
		if(age.days<=0)
			age.days=0;
		ageString=age.years+ "/" + age.months+ "/" + age.days;
		/* if ( (age.years > 0) && (age.months > 0) && (age.days > 0) )
		ageString = age.years + yearString + "/" + age.months + monthString + "/" + age.days + dayString ;
		else if ( (age.years == 0) && (age.months == 0) && (age.days > 0) )
		ageString = age.days + dayString;
		else if ( (age.years > 0) && (age.months == 0) && (age.days == 0) )
		ageString = age.years + yearString;
		else if ( (age.years > 0) && (age.months > 0) && (age.days == 0) )
		ageString = age.years + yearString + "/" + age.months + monthString ;
		else if ( (age.years == 0) && (age.months > 0) && (age.days > 0) )
		ageString = age.months + monthString + "/" + age.days + dayString ;
		else if ( (age.years > 0) && (age.months == 0) && (age.days > 0) )
		ageString = age.years + yearString + "/" + age.days + dayString ;
		else if ( (age.years == 0) && (age.months > 0) && (age.days == 0) )
		ageString = age.months + monthString ;
		else ageString = "NA"; */
		document.getElementById('age_as_on').innerHTML = "Age as on (11-Apr-2026): (YY/MM/DD) "+ageString;
		document.applicationForm.age_value.value=ageString;
		return ageString;
	}
	
   function getExmanService() {
	   var age = {};
	   var ageString="";
	   var exman_enrollment_date = document.applicationForm.exman_enrollment_date.value;
	   var exman_retirement_date = document.applicationForm.exman_retirement_date.value;
	   if(exman_enrollment_date=="" || exman_retirement_date==""){
		   
	   }
	   else{
	     age=getAgeOfTwoDates(document.applicationForm.exman_enrollment_date.value,document.applicationForm.exman_retirement_date.value);
		ageString=age.years+ "/" + age.months+ "/" + age.days;
		document.getElementById('exman_service_ason').innerHTML = "Service (YY/MM/DD): "+ageString;
		document.applicationForm.exman_service_value.value=ageString;
	   }
	   return ageString;
	}
	
	

function getAgeOfTwoDates(date1,date2) {
	
		var dobArr = date1.split("-");
		var byr=parseInt(dobArr[2]);
		var bmo=(dobArr[1]);
		var bday=parseInt(dobArr[0]);
		
		var date1Arr = date2.split("-");
		var byr1=parseInt(date1Arr[2]);
		var bmo1=(date1Arr[1]);
		var bday1=parseInt(date1Arr[0]); 
			
		var date_s = new Date(byr, bmo, bday );
		var date_e = new Date(byr1, bmo1, bday1 );
			
		var yearNow = date_e.getYear();
		var monthNow = date_e.getMonth();
		var dateNow = date_e.getDate();

		var yearDob = date_s.getYear();
		var monthDob = date_s.getMonth();
		var dateDob = date_s.getDate();
		var age = {};
		yearAge = yearNow - yearDob;

		if (monthNow >= monthDob)
		var monthAge = monthNow - monthDob;
		else {
		yearAge--;
		var monthAge = 12 + monthNow -monthDob;
		}

		if (dateNow >= dateDob)
		var dateAge = dateNow - dateDob;
		else {
		monthAge--;
		var dateAge = 31 + dateNow - dateDob;

		if (monthAge < 0) {
		monthAge = 11;
		yearAge--;
		}
		}

		age = {
		years: yearAge,
		months: monthAge,
		days: dateAge
		};

		if(age.years<=0)
			age.years=0;
		if(age.months<=0)
			age.months=0;
		if(age.days<=0)
			age.days=0;
		
		return age;
	}
	
	function AgeCaluclateFor2Dates(date1,date2)
	{
		var date1Arr = date1.split("-");
		var byr=parseInt(date1Arr[2]);
		var bmo=(date1Arr[1]);
		var bday=parseInt(date1Arr[0]);
		
		var date2Arr = date2.split("-");
		var tyr=parseInt(date2Arr[2]);
		var tmo=(date2Arr[1]);
		var tday=parseInt(date2Arr[0]);
		var tmpage=0,age=0;
		
		if((tmo > bmo)||(tmo==bmo & tday>=bday))
		{tmpage=byr;}
		else
		{tmpage=byr+1;}
		age=(tyr-tmpage);
		return age;
	}
	function showEmpDiv() {
		var govt_service_value = "";
		var employee_ssb_value = "";
		//var govt_service = getCheckedRadio(document.applicationForm.govt_service);
		var employee_ssb = getCheckedRadio(document.applicationForm.employee_ssb);
		/*  if (govt_service)
			govt_service_value = govt_service.value;  */

		if (employee_ssb)
			employee_ssb_value = employee_ssb.value;

		if (  employee_ssb_value == "true") {
			$("#exdetailsdiv1").show();
		} else {
			$("#exdetailsdiv1").hide();
		}
		
		/* if (  govt_service_value == "true") {
			$("#exdetailsdiv2").show();
		} else {
			$("#exdetailsdiv2").hide();
		} */
	}
	function correspondanceAddress() {
		var correspondence_address = getCheckedRadio(document.applicationForm.correspondence_address);
		if (correspondence_address) {
			var correspondence_address_value = correspondence_address.value;
			if (correspondence_address_value == "true") {
				document.applicationForm.village1.value = document.applicationForm.village.value;
				document.applicationForm.postoffice1.value = document.applicationForm.postoffice.value;
				document.applicationForm.tehsil1.value = document.applicationForm.tehsil.value;
				document.applicationForm.policestation1.value = document.applicationForm.policestation.value;
				document.applicationForm.state1.value = document.applicationForm.state.value;
				document.applicationForm.pincode1.value = document.applicationForm.pincode.value;
				var district=document.applicationForm.district.value;
				var state=$( "#state" ).val();
				localStorage.setItem('DIS_2', district);
				$('#district1').empty().append('<option value="">Select District</option>');
				 $.getJSON("districts_json.txt",function(result){
				      $.each(result, function(i, field){
				    	  if(state==i){
					    	var districtsArr = field.split(",");
					        districtsArr.forEach(function(item) {
					        	if(district==item){
							        $('#district1').append($('<option>', { 
							            value: item,
							            text : item,
							            selected:true
							        }));
					            }else{
					            	$('#district1').append($('<option>', { 
							            value: item,
							            text : item 
							        }));
					            }
					        });
				    	  }
				      });
				 });
				 $("#district1").val(district);
				 //document.applicationForm.district1.value = document.applicationForm.district.value;
			}else{
				document.applicationForm.village1.value = "";
				document.applicationForm.postoffice1.value = "";
				document.applicationForm.tehsil1.value = "";
				document.applicationForm.policestation1.value = "";
				document.applicationForm.state1.value = "";
				document.applicationForm.pincode1.value = "";
				document.applicationForm.district1.value="";
				localStorage.removeItem("DIS_2");
		}
		}
	}
	function getDistricts(){
		var state=$( "#state" ).val();
		//var district_h=$( "#district_h" ).val();
		var district_h=localStorage.getItem('DIS_1');
		$('#district').empty().append('<option value="">Select District</option>');
		 $.getJSON("districts_json.txt",function(result){
		      $.each(result, function(i, field){
		    	  if(state==i){
			    	var districtsArr = field.split(",");
			        districtsArr.forEach(function(item) {
			        	if(district_h==item){
					        $('#district').append($('<option>', { 
					            value: item,
					            text : item,
					            selected:true
					        }));
			            }else{
			            	$('#district').append($('<option>', { 
					            value: item,
					            text : item 
					        }));
			            }
			        });
		    	  }
		      });
		 }); 
	}
	function getDistricts1(){
		var state=$( "#state1" ).val();
		//var district_h=$( "#district_h1" ).val();
		var district_h=localStorage.getItem('DIS_2');
		$('#district1').empty().append('<option value="">Select District</option>');
		 $.getJSON("districts_json.txt",function(result){
		      $.each(result, function(i, field){
		    	  if(state==i){
			    	var districtsArr = field.split(",");
			        districtsArr.forEach(function(item) {
			        	if(district_h==item){
					        $('#district1').append($('<option>', { 
					            value: item,
					            text : item,
					            selected:true
					        }));
			            }else{
			            	$('#district1').append($('<option>', { 
					            value: item,
					            text : item 
					        }));
			            }
			        });
		    	  }
		      });
		 }); 
	}
	function getCheckedRadio(c) {
		for ( var b = 0; b < c.length; b++) {
			var a = c[b];
			if (a.checked) {
				return a;
			}
		}
		return undefined;
	}
	
	function goToInstructions() {
		document.location.href = "applicationAfterIndex";
	}
	
	function check(){
		showEmpDiv();
		getDistricts();
		getDistricts1();
		showFirDetails();
		$("#post_applied").val("");
		var dob1 = document.applicationForm.dob.value;
		var dobArr = dob1.split("-");
		var byr=parseInt(dobArr[2]);
		/* if(byr>=1980 && byr<=1989){
			 $("#jkdomicilerow").show();
		}else{
			 $("#jkdomicilerow").hide();
		} */
		
		var religion = trim1($("#religion").val());
		if(religion=="Others"){
			 $("#other_religion_id").show();
		}else{
			 $("#other_religion_id").hide();
		}
		var nationality = trim1($("#nationality").val());
		if(nationality=="Others"){
			var post_applied=$( "#post_applied" ).val();
			//if(post_applied=="2" || post_applied=="28" || post_applied=="3" || post_applied=="6" || post_applied=="30" || post_applied=="7" || post_applied=="9" || post_applied=="10" || post_applied=="26" || post_applied=="27"){
			     $("#other_nationality_id").show();
			/* }else{
				 $("#other_nationality_id").hide();
				 alert("A Citizen of India Only can apply for this post");
			} */
		}else{
			 $("#other_nationality_id").hide();
		}
		
		var min_qual="",min_qual1="",max_age="",min_age="";
			var post_applied=$( "#post_applied" ).val();
			var post_applied_value = $("#post_applied option:selected").html();
			$( "#post_selected_name" ).val(post_applied_value);
			$('#post_selected_name_declaration').text(post_applied_value);
			max_age="27";
			min_age="18";
			$('#gender_select').show();
			$('#gender_label').hide();
			 $("#sex").val("");
			
			 
			 var post_applied=$( "#post_applied" ).val();
			
				 
				 
			$('#post_selected_id').text(post_applied_value);
			if(post_applied==""){
			 min_age="18";
				max_age="27";
			}else{
				if(post_applied=="1"){
					 min_age="18";
					max_age="27"; 
				}else if(post_applied=="2"){
					 max_age="27";
					min_age="18";
		     	 }
				else if(post_applied=="3"){
					 max_age="27";
						min_age="18";
				}
				else if(post_applied=="4"){
					 max_age="27";
						min_age="18";
				}
				
			}
			
			 $("#min_qual").val(min_qual);
				$("#min_qual1").val(min_qual1);
				 $("#max_age").val(max_age);
				 $("#min_age").val(min_age);
				
		
		var categoty_belongs=getCheckedRadio(document.applicationForm.categoty_belongs);
		if(categoty_belongs){
			var categoty_belongsValue=categoty_belongs.value;
			if(categoty_belongsValue== "true")
				$("#catdetailsdiv").show();
			else
				$("#catdetailsdiv").hide();
		}
		
		var jk_domiciled=getCheckedRadio(document.applicationForm.jk_domiciled);
		if(jk_domiciled){
			var dob1 = document.applicationForm.dob.value;
			var dobArr = dob1.split("-");
			var byr=parseInt(dobArr[2]);
			//if(byr>=1980 && byr<=1989){
			
				var jk_domiciledValue=jk_domiciled.value;
				if(jk_domiciledValue== "true")
					$("#jkdomiciledetailsdiv").show();
				else
					$("#jkdomiciledetailsdiv").hide();
			/* }else{
				$("#jkdomiciledetailsdiv").hide();
			} */
		}
		
		var riots_affected=getCheckedRadio(document.applicationForm.riots_affected);
		if(riots_affected){
			var riots_affectedValue=riots_affected.value;
			if(riots_affectedValue== "true")
				$("#riotsdetailsdiv").show();
			else
				$("#riotsdetailsdiv").hide();
		}
		
		/* var riots_gujarat=getCheckedRadio(document.applicationForm.riots_gujarat);
		if(riots_gujarat){
			var riots_gujaratValue=riots_gujarat.value;
			if(riots_gujaratValue== "true")
				$("#riots_gujarat_detailsdiv").show();
			else
				$("#riots_gujarat_detailsdiv").hide();
		} */
		
		var c=getCheckedRadio(document.applicationForm.ex_serviceman);
		if(c){
			var e=c.value;
			if(e== "true")
				$("#exdetailsdiv").show();
			else
				$("#exdetailsdiv").hide();
		}
		
		var db=getCheckedRadio(document.applicationForm.debarment);
		if(db){
			var dbv=db.value;
			if(dbv== "true")
				$("#debardetailsdiv").show();
			else
				$("#debardetailsdiv").hide();
		}
		
		
	}
</script>
<script type="text/javascript">
	
	function getMaxAge(post_applied){
		alert("called getMaxAge="+post_applied);
		var max_age=0;
		$.getJSON("postsdata.json",function(result){
		      $.each(result, function(i, field){
		    	  for (i=0;i<=field.length;i++) {
		    		  var json_post_id=field[i].post_id;
		    		  
		        	    if(post_applied==json_post_id){
		        		    min_age= field[i].min_age;
				            max_age = field[i].max_age;
				            //alert("json_post_id="+json_post_id);
				            alert("max age selected="+max_age);
				            $("#max_age").val(max_age);
							 $("#min_age").val(min_age);
				           return max_age;
		            }
			    	  
		    	  }
		    	 
		      });
		 });
	}
	function parsePostsJSON(){
		var post_applied=$( "#post_applied" ).val();
	/* 	$('#post_applied').empty().append('<option value="">Select Post</option>');
		 $.getJSON("postsdata.json",function(result){
		      $.each(result, function(i, field){
		    	  for (i=0;i<=field.length;i++) {
			    	  var json_post_id=field[i].post_id;
		        	if(post_applied==json_post_id){
				        $('#post_applied').append($('<option>', { 
				            value: field[i].post_id,
				            text : field[i].post_name,
				            selected:true
				        }));
		            }else{
		            	$('#post_applied').append($('<option>', { 
				            value: field[i].post_id,
				            text : field[i].post_name 
				        }));
		            }
			    	  
		    	  }
		    	 
		      });
		 });  */
	}
</script>
</head>
<body onload="check(); parsePostsJSON();">
<jsp:include page="header.jsp" flush="true" />
	<!--wrapper div starts here-->
	   <div class="container-fluid">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails1" >

			<!--Content div starts here-->
			<form name=applicationForm id=applicationForm method=post
				action=applicationPreview enctype="multipart/form-data">
				<div class="contentoutter">
					<div class="contentinner">

						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding: 30px 0px 0px 0px;">


							<tr>
								<td colspan="4" align="center" valign="middle">
								<div id="div1">
										<table width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0" class="display" >
											
														
											<tr>
												<td class="bdr"><h2>Personal Details</h2>
													<input type=hidden name=requestFrom value="apllicationform" />
													<input type=hidden name=age id=age value="0" />
													<input type=hidden name="post_selected_name" id="post_selected_name" value="Head Constable (Ministerial)" />
													<input type=hidden name=max_age id=max_age value="27" />
													<input type=hidden name=min_age id=min_age value="18" />
													<input type=hidden name=min_qual id=min_qual value="" />
													<input type=hidden name=min_qual1 id=min_qual1 value="" />
													<input type=hidden name=district_h id=district_h  />
													<input type=hidden name=district_h1 id=district_h1 /></td>
											</tr>
											<tr>
												<td>
												<table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
														
														
														 <tr>
				                                            <td  colspan=3>
				                                            <i style="margin-left: 9px;  font-weight: bold;"><font size="3" color="#00008B">Note:</font></i>
				                                            <ul style="margin-left:-16px;">
				                                             
				                                            <li><font size="4" color="#ff003b">Please enter Full Name as mentioned in X/SSLC/Matric Certificate.</font></li>
				                                            <li><font size="4" color="#ff003b">Please don't use the prefix in Name, Father Name &amp; Mother Name  e.g:Mr,Mrs,Shri,Smt,etc.</font></li>
				                                            <li><font size="4" color="#ff003b">Please Select Date of Birth as mentioned in Matriculation Certificate.</font></li>
				                                            </ul>
				                                            </td>
				                                        </tr>
				                                      
				                                        
				                                        <tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Post Applying For :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle">
																<!-- <select class="drop1 pageRequired" name=post_applied id=post_applied>
																		<option value="">Select</option>
																</select> -->
																
																<select class="drop1 pageRequired" name="post_applied" id="post_applied">
																  <option value="" selected>Select Post</option>
																   <option value="1">Head Constable (Laboratory Assistant)</option>
																   <!-- <option value="2">Sub Inspector (Draughtsman)</option> -->
																   <option value="3">Head Constable (Physiotherapy Assistant)</option>
																   <option value="4">Constable (Nursing Assistant cum Medic) </option>
																
																</select>
															</td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="post_applied_errormessage" class="error"
																		style="display: none;">Please Select Post</div>
																</div></td>
														</tr>
														<tr>
														<td colspan="3" align="left" valign="middle" class="note">
															<div id="postCert" style="display: none; margin:2px 0px 2px 0px;color:#FF5400;font-size:80%">
															</div>															
															</td>
														 </tr>
														
														<tr>
															<td width="38.5%" align="left" valign="middle"><label style="font-weight:bold;">
																	Name :<span style="color: red">*</span>  </label></td>
															<td width="30%" align="left" valign="middle">
															   <input oncut="return false" oncopy="return false"
																onpaste="return false" name=first_name id=firstName
																maxlength=30 class="text_small pageRequired"
																placeholder=" First Name"
																onKeyPress="return charactersonly_mobile(this,event)" />
																
																<input oncut="return false" oncopy="return false"
																onpaste="return false" name=middle_name id=middleName
																maxlength=30 class="text_small pageRequired"
																placeholder=" Middle Name"
																onKeyPress="return charactersonly_mobile(this,event)" />
																
																<input oncut="return false" oncopy="return false"
																onpaste="return false" name=last_name id=lastName
																maxlength=30 class="text_small pageRequired"
																placeholder=" Surname"
																onKeyPress="return charactersonly_mobile(this,event)" />
																
																</td>
															<td width="30%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div style="display: none;" class="error" id="firstNameErrorMessage">Please Enter Name.</div>
															</div>
															<div class="rightsideErrorClassR">
																<div style="display: none;" class="error" id="firstNameLengthErrorMessage">Name should contain at least 1 characters.</div>
															</div>
															<div class="rightsideErrorClassR">
																<div style="display: none;" class="error" id="firstNameCharsErrorMessage">Name accepts only characters (No Spaces Allowed).</div>
															</div>
															</td>
														</tr>
														 
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">
																	Father's Name :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><input
																oncut="return false" oncopy="return false"
																onpaste="return false" name=father_name id=fathername
																maxlength=50 class="text1 pageRequired"
																placeholder=" Father's Name"
																onKeyPress="return charactersonly_mobile(this,event)" /></td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div style="display: none;" class="error" id="fatherNameErrorMessage">Please Enter Father Name.</div>
																<div style="display: none;" class="error" id="fatherNameLengthErrorMessage">Father name should contain at least 2 characters.</div>
																<div style="display: none;" class="error" id="fatherNameCharsErrorMessage">Father name accepts only characters (No Spaces Allowed).</div>
															</div>
															</td>
														</tr>
														
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;"> Mother's Name :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><input
																oncut="return false" oncopy="return false"
																onpaste="return false" name=mother_name id=mothername
																maxlength=50 class="text1 pageRequired"
																placeholder=" Mother's Name"
																onKeyPress="return charactersonly_mobile(this,event)" /></td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div style="display: none;" class="error" id="motherNameErrorMessage">Please Enter Mother Name.</div>
																<div style="display: none;" class="error" id="motherNameLengthErrorMessage">Mother name should contain at least 2 characters.</div>
																<div style="display: none;" class="error" id="motherNameCharsErrorMessage">Mother name accepts only characters.</div>
															</div>
															</td>
														</tr>
														
														<!--  <tr> <td></td>
				                                            <td  colspan=2>
				                                            <i><font size="2" color="#00008B">Note: Please Select Date of Birth as mentioned in Matriculation Certificate.</font></i>
				                                            </td>
				                                        </tr> -->
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Date of Birth :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><input name="dob"
																type="text" id="recordClientDob" class="date2"
																placeholder="Date of Birth"  onchange="getAge()"  />
																<input type="hidden" name="age_value" value=""/>
															 <div id="age_as_on" style="font-size:12px; font-weight: bold;"></div>
																</td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
															 <div id="doberrormessage" class="error" style="display: none;">Please Select Date of birth</div>
															</div>
															</td>
														</tr>
														
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Gender :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle">
																 <!--  <select class="drop1 pageRequired" name=sex id=sex>
																		<option value="">Select</option>
																		<option value="Male">Male</option>
																		<option value="Female">Female</option>
																   </select> -->
																   
														  <div id="gender_select">
															<select class="drop1 pageRequired" name=sex id=sex>
																	<option value="">Select</option>
																	<option id="male" value="Male">Male</option>
																	 <option  value="Female">Female</option>
															</select>
														   </div>
														    <div id="gender_label" style="display:none;">
															</div>
															
															</td>
															<td align="left" valign="middle">
															  <div class="rightsideErrorClassR">
																	<div id="errormessageSex" class="error" style="display: none;">Please Select Gender</div>
																</div></td>
														</tr>
														
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Nationality :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><select
																class="drop1 pageRequired" name=nationality
																id=nationality>
																	<option value="">Select Nationality</option>
																	<option value="Indian">Indian</option>
																	<option id="others" value="Others">Others</option>
															</select></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="nationality_errormessage" class="error" style="display: none;">Please Select Nationality</div>
																	<div id="indian_nationality_errormessage" class="error" style="display: none;">A Citizen of India Only can apply for this post</div>
																</div></td>
														</tr>
														<tr  id="other_nationality_id" style="display:none;">
															<td align="left" valign="middle"><label style="font-weight:bold;">Other Nationality :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><select
																class="drop1 pageRequired" name=other_nationality
																id=other_nationality>
																	<option value="Subject of Nepal">Subject of Nepal</option>
																	<option value="Subject of Bhutan">Subject of Bhutan</option>
															</select></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="other_nationality_errormessage" class="error"
																		style="display: none;">Please Select Nationality</div>
																</div></td>
														</tr>
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Religion :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><select
																class="drop1 pageRequired" name=religion
																id=religion>
																	<option value="">Select Religion</option>
																	<option value="Hindu">Hindu</option>
																	<option value="Muslim">Muslim</option>
																	<option value="Sikh">Sikh</option>
																	<option value="Christian">Christian</option>
																	<option value="Buddhist">Buddhist</option>
																	<option value="Zoroastrians(Parsees)">Zoroastrians(Parsees)</option>
																	<option value="Jain">Jain</option>
																	<option value="Others">Others</option>
															</select></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="religionerrormessage" class="error"
																		style="display: none;">Please Select Religion</div>
																</div></td>
														</tr>
														<tr  id="other_religion_id" style="display:none;">
															<td align="left" valign="middle"><label style="font-weight:bold;">Specify, Others</label></td>
															<td align="left" valign="middle"><input type="text"
																oncut="return false" oncopy="return false"
																onpaste="return false" name=other_religion
																id=other_religion maxlength=20 class=text1
																placeholder="Specify Other Religion"
																onKeyPress="return charactersonly_mobile(this,event)" /></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="religionerrormessage1" class="error"
																		style="display: none;">Please Specify Other
																		Religion</div>
																	<div id="religionerrormessage2" class="error"
																		style="display: none;">Other Religion accepts only characters.</div>	
																</div></td>
														</tr>
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Marital Status :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><select
																class="drop1 pageRequired" name=marrital_status
																id=marrital_status>
																	<option value="">Select Marital Status</option>
																	<option value="Unmarried">Unmarried</option>
																	<option value="Married">Married</option>
																	<option value="Divorce">Divorce </option>
																	<option value="Widowed ">Widowed </option>
															</select></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="marrital_errormessage" class="error"
																		style="display: none;">Please Select Marital Status</div>
																</div></td>
														</tr>
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Category :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><select
																class="drop1 pageRequired" name=community
																id=community>
																	<option value="">Select</option>
																	<option value="General">General / UR</option>
																	<option value="EWS">EWS</option>
																	<option value="OBC">OBC</option>
																	<option value="SC">SC</option>
																	<option value="ST">ST</option>
															</select></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="communityErrorMessage" class="error"
																		style="display: none;">Please Select Category</div>
																</div></td>
														</tr>
														<tr>
															<td colspan="3" align="left" valign="middle" class="note">
															<div id="communityCert" style="display: none; margin:2px 0px 2px 0px;">
															</div>
															<div id="communityCertAge" style="display: none; margin:2px 0px 2px 0px;">
															</div>
															<!-- <div id="communityCertHeight" style="display: none; margin:2px 0px 2px 0px;">
															</div>  -->
															</td>
														</tr>
													</table></td></tr>	
													<tr>
												    <td> <table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
													
														<tr>
															<td align="left" valign="middle" width="50%"><label style="font-weight:bold;">Whether you belong to Community [Garhawalis, Kumaonis, Gorkhas, Dogras, Marathas] :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle" id="categotybelongs" width="12%">
															  <label> <input type="radio" name="categoty_belongs" id="categotybelongsid" value="true" /> Yes </label> 
															  <label> <input type="radio" name="categoty_belongs" id="categotybelongsid" value="false" /> No </label>
															 </td>
															<td align="left" valign="middle" width="27%"><div
																	class="rightsideErrorClassR">
																	<div id="categoryErrorMessage" class="error"
																		style="display: none;">Please Select Yes / No</div>
																</div></td>
														</tr>
														
														<tr>
												   <td colspan="3">
													<div id="catdetailsdiv" style="display:none">
														<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" class="border1">
																<tr>
																	<td width="25%" align="center" class="border1"><label>Community</label></td>
																	<td width="25%" align="center" class="border1"><label>Certificate No</label></td>
																	<td width="16%" align="center" class="border1"><label>Date Of Issued</label></td>
																	<td width="35%" align="center" class="border1"><label>Issuing authority</label></td>
																</tr>
																<tr>
																    <td class="border1" align="center" valign="middle">
																     <select class="drop1 pageRequired" name=category id=category>
																		<option value="">Select</option>
																		<option value="Garhawalis">Garhawalis</option>
																		<option value="Kumaonis">Kumaonis</option>
																		<option value="Gorkhas">Gorkhas</option>
																		<option value="Dogras">Dogras</option>
																		<option value="Marathas">Marathas</option>
																		<!-- <option value="Sikkimies">Sikkimies</option>
																		<option value="Adivasis">Adivasis</option>
																		<option value="Tribals">Tribals including Mizos and Nagas</option> -->
																      </select>
																  </td> 
													               <td class="border1" align="center">
													                   <input type="text" name="cat_cert_no" id="cat_cert_no" maxlength=30 class="date" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" />
													               </td>
																	<td class="border1" align="center">
																	   <input type="text"  name="cat_date_Issue" id="recordClientCatDateIssue" readonly class="date1">
																	</td>
																	
																	<td class="border1" align="center">
																	  <input type="text" name="cat_issue_authority" id="cat_issue_authority"  maxlength=40  class="date" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/>
																	</td>
																	
																</tr>
																
																<tr>
																	<td colspan="4" align="left" valign="middle" class="note">
																	<div id="categoryCert" style="display: none; margin:2px 0px 2px 0px;">
																	</div>
																	<div id="categoryCertHeight" style="display: none; margin:2px 0px 2px 0px;">
																	</div> 
																	</td>
																</tr>

															</table>
													</div>
												</td>
												</tr>
												
														
														<tr id="jkdomicilerow">
															<td align="left" valign="middle"><label style="font-weight:bold;">Whether domiciled ordinary in J&amp;K during 1980 to 1989 :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle" id="jkdomiciled">
															  <label> <input type="radio" name="jk_domiciled" id="jkdomiciledid" value="true" /> Yes </label> 
															  <label> <input type="radio" name="jk_domiciled" id="jkdomiciledid" value="false" /> No </label>
															 </td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="jkDomicileErrorMessage" class="error"
																		style="display: none;">Please Select Yes / No</div>
																</div></td>
														</tr>
														
														<tr>
												   <td colspan="3">
													<div id="jkdomiciledetailsdiv" style="display:none">
														<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" class="border1">
																<tr>
																	<td width="25%" align="center" class="border1"><label>Certificate No</label></td>
																	<td width="16%" align="center" class="border1"><label>Date Of Issued</label></td>
																	<td width="35%" align="center" class="border1"><label>Issuing authority</label></td>
																</tr>
																<tr>
													              <td class="border1" align="center">
													                   <input type="text" name="jk_cert_no" id="jk_cert_no" class="date" maxlength=30 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/>
													               </td>
																	<td class="border1" align="center">
																	   <input type="text"  name="jk_date_Issue" id="recordClientJKDateIssue" readonly class="date1">
																	</td>
																	
																	<td class="border1" align="center">
																	  <input type="text" name="jk_issue_authority" id="jk_issue_authority" class="date" maxlength=40 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/>
																	</td>
																	
																</tr>

															</table>
													</div>
												</td>
												</tr>
												
												
												<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Whether affected in 1984 riots or communal riots of 2002 Gujarat :<span style="color: red">*</span><br/>
															<span style="font-size:10px">(Children/dependent of victim killed in the riots)</span>  </label></td>
															<td align="left" valign="middle" id="riotsaffected">
															  <label> <input type="radio" name="riots_affected" id="riotsaffectedid" value="true" /> Yes </label> 
															  <label> <input type="radio" name="riots_affected" id="riotsaffectedid" value="false" /> No </label>
															 </td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="riotsErrorMessage" class="error"
																		style="display: none;">Please Select Yes / No</div>
																</div></td>
														</tr>
														
														<tr>
												   <td colspan="3">
													<div id="riotsdetailsdiv" style="display:none">
														<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" class="border1">
																<tr>
																	<td width="25%" align="center" class="border1"><label>Certificate No</label></td>
																	<td width="16%" align="center" class="border1"><label>Date Of Issued</label></td>
																	<td width="35%" align="center" class="border1"><label>Issuing authority</label></td>
																</tr>
																<tr>
													              <td class="border1" align="center">
													                   <input type="text" name="riots_cert_no" id="riots_cert_no" class="date" maxlength=30 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/>
													               </td>
																	<td class="border1" align="center">
																	   <input type="text"  name="riots_date_Issue" id="recordClientRiotsDateIssue" readonly class="date1">
																	</td>
																	
																	<td class="border1" align="center">
																	  <input type="text" name="riots_issue_authority" id="riots_issue_authority" class="date" maxlength=40 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/>
																	</td>
																	
																</tr>

															</table>
													</div>
												</td>
												</tr>
												
												
												<tr>
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether Ex-serviceman :<span style="color: red">*</span>  </label></td>
													<td align="left" valign="middle" id="exserviceman"><label>
															<input type="radio" 
															name="ex_serviceman" id="exservicemanid" value="true" /> Yes
													</label> <label> <input type="radio" 
															name="ex_serviceman" id="exservicemanid" value="false" /> No
													</label></td>
													<td  align="left" valign="middle"><div
															class="rightsideErrorClassR">
															<div id="exmanErrorMessage" class="error"
																style="display: none;">Please Select Yes / No</div>
														</div></td>
												</tr>
														
											     <tr>
												   <td colspan="3">
													<div id="exdetailsdiv" style="display: none">
														<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" class="border1">
																		<tr>
																			<td width="16%" align="center" class="border1"><label>Date
																					of Enrollment</label></td>
																			<td width="21%" align="center" class="border1"><label>Date
																					of Retirement / Discharge</label></td>
																			<td width="13%" align="center" class="border1"><label>Medical
																					Category</label></td>
																		<!-- 	<td width="14%" align="center" class="border1"><label>Award
																					or Decoration</label></td> -->
																			<td width="18%" align="center" class="border1"><label>Reasons
																					for release/Discharge</label></td>
																			<td width="17%" align="center" class="border1"><label>Education
																					Qualification</label></td>
																		</tr>
																		<tr>
																			<td class="border1" align="center">
																			<input type="text"  name="exman_enrollment_date" id="recordClientExmanEnrlment" readonly class="date1"  onchange="getExmanService()" ></td>
																			<td class="border1" align="center">
																			<input type="text"  name="exman_retirement_date" id="recordClientExmanRetirement" readonly class="date1"  onchange="getExmanService()" >
																			<input type="hidden" name="exman_service_value" value=""/>
															 <div id="exman_service_ason" style="font-size:12px; font-weight: bold;"></div>
																			</td>
																			<td class="border1" align="center">
																			<select class="drop2 pageRequired" name=exman_med_cat id=exman_med_cat>
																				<option value="">Select</option>
																				<option value="AYE"> "A" (AYE)</option>
																				<option value="SHAPE-ONE">SHAPE-ONE</option>
																		     </select>
																	       </td>
																			<!-- <td class="border1" align="center"><input
																				type="text" name="exman_awd_dec" id="exman_awd_dec"
																				class="date" maxlength=40 /></td> -->
																			<td class="border1" align="center"><input
																				type="text" name="exman_discharge_reason"
																				id="exman_discharge_reason" class="date"  maxlength=60 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																			<td class="border1" align="left"><label>
																					<input type="radio" name="exman_edu_qual"
																					id="exman_edu_qual" value="Civil" />
																					Civil
																			</label> <br /> <label> <input type="radio"
																					name="exman_edu_qual"
																					id="exman_edu_qual" value="Military" /> Military
																			</label> <br /></td>
																		</tr>

																	</table>
													</div>
												</td>
												</tr>
												
												<tr>
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether Departmental Candidates with three years continuous service in Central Government :<span style="color: red">*</span>  </label></td>
													<td align="left" valign="middle" id="employee_ssb">
														 <label> <input type="radio" name="employee_ssb" id="employee_ssb_id" value="true" onClick="showEmpDiv()" /> Yes </label> 
														 <label> <input type="radio" name="employee_ssb" id="employee_ssb_id" value="false"  onClick="showEmpDiv()" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="ssb_emp_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>
												<tr>
												   <td colspan="3">
												<div id="exdetailsdiv1" style="display: none">
														<table width="100%" border="0"
																		align="center" cellpadding="5" cellspacing="0"
																		class="border1">
																		<tr>
																			<td width="24%" align="center" class="border1"><label>Name of Organization</label></td>
																			<td width="21%" align="center" class="border1"><label>Posted since</label></td>
																			<td width="16%" align="center" class="border1"><label>Post held</label></td>
																			<td width="39%" align="center" class="border1"><label>Issuing Authority (NOC)</label></td>
																		</tr>
																		<tr>
																			<td align="center" valign="middle" class="border1"><input
																				type="text" name="present_employer" id="present_employer"
																				class="date" maxlength=60 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																			<td align="center" valign="middle" class="border1"><label>
																			<input type="text"  name="emp_date_since" id="recordClientEmpDateSince" readonly class="date1">
																			</label></td>
																			<td align="center" valign="middle" class="border1"><input
																				type="text" name="post_held" id="post_held"
																				class="date" maxlength=60 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																			<td align="center" valign="middle" class="border1"><input
																				type="text" name="nocdesignation" id="nocdesignation"
																				class="text1" maxlength=80 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/> <label></label></td>
																		</tr>
																	</table>
													</div>
												</td></tr>
											 <!--    <tr>
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether in Government Service :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="govt_service">
														 <label> <input type="radio" name="govt_service" id="govt_service_id" value="true" onClick="showEmpDiv()" /> Yes </label> 
														 <label> <input type="radio" name="govt_service" id="govt_service_id" value="false"  onClick="showEmpDiv()" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="govt_emp_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr> -->
												
											<!-- 	
												<tr>
												   <td colspan="3">
												<div id="exdetailsdiv2" style="display: none">
														<table width="100%" border="0"
																		align="center" cellpadding="5" cellspacing="0"
																		class="border1">
																		<tr>
																			<td width="24%" align="center" class="border1"><label>Name of Organization</label></td>
																			<td width="21%" align="center" class="border1"><label>Posted since</label></td>
																			<td width="16%" align="center" class="border1"><label>Post held</label></td>
																			<td width="39%" align="center" class="border1"><label>Issuing Authority (NOC)</label></td>
																		</tr>
																		<tr>
																			<td align="center" valign="middle" class="border1"><input
																				type="text" name="present_employer2" id="present_employer2"
																				class="date" maxlength=60 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																			<td align="center" valign="middle" class="border1"><label>
																			<input type="text"  name="emp_date_since2" id="recordClientEmpDateSince2" readonly class="date1">
																			</label></td>
																			<td align="center" valign="middle" class="border1"><input
																				type="text" name="post_held2" id="post_held2"
																				class="date" maxlength=60 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																			<td align="center" valign="middle" class="border1"><input
																				type="text" name="nocdesignation2" id="nocdesignation2"
																				class="text1" maxlength=80 onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/> <label></label></td>
																		</tr>
																	</table>
													</div>
												</td></tr> -->
												<!-- hc-lab asst -->
												<tr id="hc_lab_asst" class="hc_lab_asst">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether have Certificate course of a duration of minimum one year in Laboratory Assistant Course from a recognized institution :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="hc_lab_asst_cert">
														 <label> <input type="radio" name="hc_lab_asst_cert" id="hc_lab_asst_cert_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="hc_lab_asst_cert" id="hc_lab_asst_cert_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="hc_lab_asst_cert_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>
												<tr id="hc_lab_asst_work" class="hc_lab_asst_work">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether have Working experience of duration of minimum One year as Lab Assistant in Laboratory Diagnostic Centre or hospital or institution lab recognized by the Central Government or State Government <span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="hc_lab_asst_exp">
														 <label> <input type="radio" name="hc_lab_asst_exp" id="hc_lab_asst_exp_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="hc_lab_asst_exp" id="hc_lab_asst_exp_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="hc_lab_asst_exp_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>

												<!-- hc-physio asst -->
												<tr id="hc_physio_asst" class="hc_physio_asst">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether have  Certificate course of duration of minimum one year in Physiotherapy from a recognized institute <span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="hc_physio_asst_cert">
														 <label> <input type="radio" name="hc_physio_asst_cert" id="hc_physio_asst_cert_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="hc_physio_asst_cert" id="hc_physio_asst_cert_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="hc_physio_asst_cert_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>

												<tr id="hc_physio_asst_work" class="hc_physio_asst_work">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether have Experience of duration of minimum one year as Physiotherapy Assistant from a Physiotherapy Centre or minimum hundred bedded hospital or institute recognised by the Central Government or State Government <span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="hc_physio_asst_exp">
														 <label> <input type="radio" name="hc_physio_asst_exp" id="hc_physio_asst_exp_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="hc_physio_asst_exp" id="hc_physio_asst_exp_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="hc_physio_asst_exp_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>

												<!-- ct-nursing asst -->
												<tr id="ct_nursing_asst" class="ct_nursing_asst">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether have  First Aid certificate course from St. John’s Ambulance Organization or Red Cross Society of India <span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="ct_nursing_asst_cert">
														 <label> <input type="radio" name="ct_nursing_asst_cert" id="ct_nursing_asst_cert_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="ct_nursing_asst_cert" id="ct_nursing_asst_cert_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="ct_nursing_asst_cert_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>

												<tr id="ct_nursing_asst_work" class="ct_nursing_asst_work">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether have Experience of duration of minimum one year as Nursing Assistant in a minimum fifty bedded Hospital or Institution recognised by the Central Government or State Governments. <span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="ct_nursing_asst_exp">
														 <label> <input type="radio" name="ct_nursing_asst_exp" id="ct_nursing_asst_exp_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="ct_nursing_asst_exp" id="ct_nursing_asst_exp_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="ct_nursing_asst_exp_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>


												<!-- <tr id="nursing" class="nursing">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether Registered with Central nursing council or State nursing council as a General Nurse and Mid-wife :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="nursing_council">
														 <label> <input type="radio" name="nursing_council" id="nursing_council_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="nursing_council" id="nursing_council_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="nursing_council_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr> -->
												
												<!-- <tr id="hospital" class="hospital">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether has Two years Experience in a recognised Hospital :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="hospital_experience">
														 <label> <input type="radio" name="hospital_experience" id="hospital_experience_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="hospital_experience" id="hospital_experience_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="hospital_experience_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr> -->
												
												
												<tr id="tradesmen" class="tradesmen">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether has Two years National Tradesmen certificate issued by a recognised Industrial Training Institute or equivalent recognised institution :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="tradesmen_certificate">
														 <label> <input type="radio" name="tradesmen_certificate" id="tradesmen_certificate_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="tradesmen_certificate" id="tradesmen_certificate_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="tradesmen_certificate_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>
												
												<tr id="autocad" class="autocad">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether has One year certificate course or one year experience in AUTOCAD from a Government Institution or a recognised institution :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="autocad_certificate">
														 <label> <input type="radio" name="autocad_certificate" id="autocad_certificate_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="autocad_certificate" id="autocad_certificate_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="autocad_certificate_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>
												
												
												<tr id="draughtsmanship" class="draughtsmanship ">
													<td  align="left" valign="middle"><label style="font-weight:bold;">Whether has one year experience in Draughtsmanship from a recognised Architect Consultancy Firm of Category ‘B’ and ‘C’(Desirable) :<span style="color: red">*</span>  </label></td>
													<td  align="left" valign="middle" id="draughtsmanship_exp">
														 <label> <input type="radio" name="draughtsmanship_exp" id="draughtsmanship_exp_id" value="true"  /> Yes </label> 
														 <label> <input type="radio" name="draughtsmanship_exp" id="draughtsmanship_exp_id" value="false" /> No </label>
													 </td>
													<td  align="left" valign="middle">
													  <div class="rightsideErrorClassR">
															<div id="draughtsmanship_exp_ErrorMessage" class="error" style="display: none;">Please Select Yes / No</div>
														</div>
													</td>
												</tr>
												
												
												
												
												
												</table></td></tr>	
												    
													<tr>
												    <td> <table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
											
												       
												       <tr>
															<td align="left" valign="middle" ><label style="font-weight:bold;">Select Identity Card Type : <span style="color: red">*</span> </label></td>
															<td align="left" valign="middle"><select
																class="drop1 pageRequired" name=identity_type
																id=identity_type>
																	<option value="">Select Identity Card Type</option>
																	<option value="Aadhar Card">Aadhar Card</option>
																	<option value="Voter Id">Voter Id</option>
																	<option value="PAN Card">PAN Card</option>
																	<option value="Passport">Passport</option>
																	<option value="Driving License">Driving License</option>
																	<option value="Ration Card">Ration Card</option>
																	<option value="Birth Certificate">Birth Certificate</option>
																	<option value="University / College Id Card">University / College Id Card</option>
															</select></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="identity_errormessage" class="error"
																		style="display: none;">Select Identity Card Type</div>
																</div></td>
														</tr>
														
														<tr>
															<td align="left" valign="middle" width="38.5%"><label style="font-weight:bold;">Enter Identity Card No  : <span style="color: red">*</span> </label> <!-- <span style="display:inline-block;color:#EC7063;width:10px;">(Optional)</span> --></td>
															<td align="left" valign="middle" width="30%"><input type="text"
																class="text1" oncut="return false" oncopy="return false"
																onpaste="return false" id=aadharNo
																name=aadharNo maxlength=20 placeholder="Identity Card No"
																placeholder="" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															
														    <td align="left" valign="middle" width="30%">
														      <div class="rightsideErrorClassR">
																	<div id="aadharCharsError" class="error" style="display: none;">Enter Identity Card No</div>	
																</div>
															 </td>		
														</tr>
														
														<tr>
															<td align="left" valign="middle"><label style="font-weight:bold;">Identification
																	Marks :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="middle"><input type="text"
																class="text1" oncut="return false" oncopy="return false"
																onpaste="return false" id=personalMoal
																name=identification_mark maxlength=80
																placeholder=" Identification Marks "
																onKeyPress="return charactersonly_mobile(this,event)" /></td>
															<td align="left" valign="middle"><div
																	class="rightsideErrorClassR">
																	<div id="identificationError" class="error"
																		style="display: none;">Please Enter
																		Identification Marks</div>
																	<div id="identificationCharsError" class="error"
																		style="display: none;">Identification Marks accepts characters only.</div>	
																</div></td>
														</tr>
														<tr>
															<td><label style="font-weight:bold;">Mobile Number :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=mobileNumber id=recordClientPhone maxlength=10
																placeholder=" Mobile Number"
																class="text1 pageRequired"
																onKeyPress="return numbersonly_mobile(this,event)" /></td>
															<td width="40%" align="left" valign="middle">
															<div id="mobileError" class="error" style="display: none;">Please Enter Mobile Number</div>
															<div id="mobileNosError" class="error" style="display: none;">Mobile Number accepts only numbers</div>
															<div id="mobileLengthError" class="error" style="display: none;">Mobile Number should be 10 Digits</div>
																</td>
														</tr>
														
														<tr>
															<td><label style="font-weight:bold;">Email address :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=emailaddress id=recordClientEmail maxlength=40
																placeholder=" Email address" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"
																class="text1 pageRequired" /></td>
															<td width="40%" align="left" valign="middle">
															<div id="eMailErrorMessage" class="error" style="display: none;">Please Enter Email address</div>
															<div id="eMailErrorMessageValidate" class="error" style="display: none;">Please Enter Valid Email address</div>
																</td>
														</tr>
													</table></td>
											</tr>
											
											<tr>
		<td colspan="3" class="bdr"><h2><span id="post_selected_id"></span> Educational Qualification details  </h2></td>
	</tr>
												
	 	 <tr> <td colspan="3"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="15%" align="center" valign="middle"
					class="border1"><label><strong>Exam Passed</strong></label></td>
				<td width="18%" align="center" valign="middle"
					class="border1"><label><strong> Name of School/ Board/ University/ Institute</strong> </label></td>
				<td width="5%" align="center" valign="middle" class="border1"><label><strong> Year of Exam</strong></label></td>
				<td width="15%" align="center" valign="middle" class="border1"><label><strong> Roll No</strong></label></td>
				<td width="10%" align="center" valign="middle"
					class="border1"><label><strong>Certificate No</strong></label></td>
				<td width="10%" align="center" valign="middle"
					class="border1"><label><strong>Date Of Issued</strong> </label></td>
				<td width="15%" align="center" valign="middle"
					class="border1"><label><strong>Subject</strong> </label></td>	
				<td width="10%" align="center" valign="middle"
					class="border1"><label><strong>Aggregate Percentage of Marks/ Grading</strong> </label></td>	
			</tr>
<tr>
	<td align="center" valign="middle" class="border1"><label><input type="hidden" name="exam_passed_1" value="Matriculation"/><strong>Matriculation <span style="color: red">*</span> </strong> </label></td>
	
	<td align="center" valign="middle" class="border1"><input
		type="text" class="board" oncut="return false"
		oncopy="return false" onpaste="return false"
		id="university_1" name="university_1" maxlength=80
		onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
		<td align="center" valign="middle" class="border1"><input name="edu_year_1" type="text" class="marks" maxlength=4  onKeyPress="return numericsonly_mobile(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_rollno_1" type="text" class="board" maxlength=20  onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_certno_1" maxlength=20 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
 <td class="border1" valign="middle" align="center">
   <input type="text"  name="edu_date_issue_1" id="recordClientEduDateIssue1" readonly class="date1">
</td>
  <td align="center" valign="middle" class="border1">
  <!-- <label><input type="hidden" name="stream_1" value="Matric"/>Matric</label> -->
   
    <input name="stream_1" maxlength=50 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" />
  </td>	
  <td align="center" valign="middle" class="border1">
   <input name="edu_marks_1" type="text" maxlength=10 class="marks" onKeyPress="return numericsonly_mobile(this,event)" /></td>	
</tr>

																
<tr>
	<td align="center" valign="middle" class="border1"><label><input type="hidden" name="exam_passed_plus2" value="12"/><strong>10+2 <span style="color: red">*</span> </strong></label></td>
	<td align="center" valign="middle" class="border1">
	<input type="text" class="board" oncut="return false" oncopy="return false" onpaste="return false" id="university_plus2" name="university_plus2" maxlength=80
		onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
		<td align="center" valign="middle" class="border1"><input name="edu_year_plus2" type="text" class="marks" maxlength=4  onKeyPress="return numericsonly_mobile(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_rollno_plus2" type="text" class="board" maxlength=20  onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
<td align="center" valign="middle" class="border1"><input name="edu_certno_plus2" maxlength=20 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
 <td class="border1" valign="middle" align="center">
   <input type="text"  name="edu_date_issue_plus2" id="recordClientEduDateIssuePlus2" readonly class="date1">
</td>
<td align="center" valign="middle" class="border1">
     <select  class="drop1 pageRequired" name="stream_plus2" id="stream_plus2" style="width: 60%;padding-left: 2%;">
  <option value="" Selected>Select</option> 
  <option value="Biology">Biology</option>
  <option value="others">Any other</option>
   </select>
	</td>
	<td align="center" valign="middle" class="border1">
   <input name="edu_marks_plus2" type="text" maxlength=10 class="marks" onKeyPress="return numericsonly_mobile(this,event)" /></td>	
</tr>


<!-- <tr>
				<td width="15%" align="center" valign="middle"
					class="border1"><label><strong>Exam Passed</strong></label></td>
				<td width="18%" align="center" valign="middle"
					class="border1"><label><strong> Name of Board/ University</strong> </label></td>
				<td width="5%" align="center" valign="middle" class="border1"><label><strong> Year of Exam</strong></label></td>
				<td width="15%" align="center" valign="middle" class="border1"><label><strong> Roll No</strong></label></td>
				<td width="10%" align="center" valign="middle"
					class="border1"><label><strong>Certificate No</strong></label></td>
				<td width="10%" align="center" valign="middle"
					class="border1"><label><strong>Date Of Issued</strong> </label></td>
				<td width="15%" align="center" valign="middle"
					class="border1"><label><strong>Subject</strong> </label></td>	
				<td width="10%" align="center" valign="middle"
					class="border1"><label><strong>Aggregate Percentage of Marks/ Grading</strong> </label></td>	
			</tr> -->
			
			
			<tr>
	<td align="center" valign="middle" class="border1"><label><input type="hidden" name="exam_passed_5" value="Diploma"/><strong>Diploma</strong>  </label></td>
	  <!-- <span style="color: red">*</span>  -->
	
	<td align="center" valign="middle" class="border1"><input
		type="text" class="board" oncut="return false"
		oncopy="return false" onpaste="return false"
		id="university_diploma" name="university_5" maxlength=80
		onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
		<td align="center" valign="middle" class="border1"><input name="edu_year_5" type="text" class="marks" maxlength=4  onKeyPress="return numericsonly_mobile(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_rollno_5" type="text" class="board" maxlength=20  onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_certno_5" maxlength=20 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
 <td class="border1" valign="middle" align="center">
   <input type="text"  name="edu_date_issue_5" id="recordClientEduDateIssue3" readonly class="date1">
</td>
  <td align="center" valign="middle" class="border1">
  <!-- <label><input type="hidden" name="stream_3" value="Matric"/>Matric</label> -->
   <select  class="drop1 pageRequired" name="stream_5" id="stream_5" style="width: 60%;padding-left: 2%;">
  <option value="" Selected>Select</option> 
  <option value="civil_Engineering">Civil Engineering</option>
  <option value="general_nursing_and_midwifery">General nursing and Midwifery</option>
  <option value="general_nursing_and_midwifery_with_internship">General nursing and Midwifery with Internship</option>
  <option value="others">Any other</option>
   </select>
  </td>	
  <td align="center" valign="middle" class="border1">
   <input name="edu_marks_5" type="text" maxlength=10 class="marks" onKeyPress="return numericsonly_mobile(this,event)" /></td>	
</tr>
			
			
			
			
<tr>
	<td align="center" valign="middle" class="border1"><label><input type="hidden" name="exam_passed_3" value="Graduation"/><strong>Graduation </strong> </label></td>
	
	<td align="center" valign="middle" class="border1"><input
		type="text" class="board" oncut="return false"
		oncopy="return false" onpaste="return false"
		id="university_3" name="university_3" maxlength=80
		onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
		<td align="center" valign="middle" class="border1"><input name="edu_year_3" type="text" class="marks" maxlength=4  onKeyPress="return numericsonly_mobile(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_rollno_3" type="text" class="board" maxlength=20  onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_certno_3" maxlength=20 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
 <td class="border1" valign="middle" align="center">
   <input type="text"  name="edu_date_issue_3" id="recordClientEduDateIssue33" readonly class="date1">
</td>
  <td align="center" valign="middle" class="border1">
  <!-- <label><input type="hidden" name="stream_3" value="Matric"/>Matric</label> -->
   <select  class="drop1 pageRequired" name="stream_3" id="stream_3" style="width: 60%;padding-left: 2%;">
  <option value="" Selected>Select</option> 
  <option value="Electronics_and_Communication">Electronics and Communication</option>
  <option value="Computer_Science">Computer Science</option>
  <option value="Information_Technology_Engineering">Information Technology Engineering</option>
  <option value="Science(Physics,Chemistry and Mathematics)">Science(Physics, Chemistry and Mathematics)</option>
  <option value="civil_Engineering">Civil Engineering</option>
  <option value="others">Any other</option>
   </select>
  </td>	
  <td align="center" valign="middle" class="border1">
   <input name="edu_marks_3" type="text" maxlength=10 class="marks" onKeyPress="return numericsonly_mobile(this,event)" /></td>	
</tr>

																
<tr>
	<td align="center" valign="middle" class="border1"><label><input type="hidden" name="exam_passed_4" value="Post Graduation"/><strong>Post Graduation</strong></label></td>
	<td align="center" valign="middle" class="border1">
	<input type="text" class="board" oncut="return false" oncopy="return false" onpaste="return false" id="university_4" name="university_4" maxlength=80
		onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
		<td align="center" valign="middle" class="border1"><input name="edu_year_4" type="text" class="marks" maxlength=4  onKeyPress="return numericsonly_mobile(this,event)"/></td>
<td align="center" valign="middle" class="border1"><input name="edu_rollno_4" type="text" class="board" maxlength=20  onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
<td align="center" valign="middle" class="border1"><input name="edu_certno_4" maxlength=20 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
 <td class="border1" valign="middle" align="center">
   <input type="text"  name="edu_date_issue_4" id="recordClientEduDateIssue4" readonly class="date1">
</td>
<td align="center" valign="middle" class="border1">
     <input name="stream_4" maxlength=50 type="text" class="board" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/>
	</td>
	<td align="center" valign="middle" class="border1">
   <input name="edu_marks_4" type="text" maxlength=10 class="marks" onKeyPress="return numericsonly_mobile(this,event)" /></td>	
</tr>				
				

																
																
</table>
</td>
</tr>				
		
					
				
		
	
												
				
	
											
										<!-- Vertical & Horizontal Reservation Ends -->
										
											<tr>
												<td><table width="96%" border="0" cellspacing="0"
														cellpadding="5" align="center">
														<tr>
															<td><div class="buttonWrapper">
																	<input type="button" class="nextbutton appFormBtmleft"
																		value="Home" onClick="goToInstructions()"> <input
																		name="formBack0" type="button" id="firstDivNext"
																		class="nextbutton appFormBtmRight" value="Next"
																		alt="Next step">
																</div></td>
														</tr>
													</table></td>
											</tr>
										</table>
									</div>

									
									
								<div id="div3" style="display: none">
							     <table width="100%" border="0" cellspacing="0" cellpadding="0">
							     
							     		
    

								<tr>
									<td class="bdr"><h2>Address Details </h2></td>
								</tr>
								<tr>
									<td>
										<table width="95%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											
											<tr>
												<td width="34%">
												    <table width="100%" border="0"
														align="center" cellpadding="5" cellspacing="0">
														<tr>
															<td colspan="2"><h4>Permanent Address </h4></td>
														</tr>
														<tr>
															<td width="34%"><label style="font-weight:bold;">Village/ Town :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=village id=village maxlength=40
																placeholder="Enter Village/ Town"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<!-- <td width="40%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="villageError" class="error" style="display: none;">Please Enter Village</div>
																<div id="villageCharsError" class="error" style="display: none;">Village accepts only characters</div>
															</div>
															</td> -->
														</tr>
														<tr>
															<td><label style="font-weight:bold;">Post Office :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=postoffice id=postoffice maxlength=40
																placeholder="Enter Post Office"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<!-- <td width="40%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="postofficeError" class="error" style="display: none;">Please Enter Post Office</div>
																<div id="postofficeCharsError" class="error" style="display: none;">Post Office accepts only characters</div>
															</div>
															</td> -->
														</tr>
														<tr>
															<td><label style="font-weight:bold;">Tehsil :  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false" name=tehsil
																id=tehsil maxlength=40 placeholder="Enter Tehsil"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<!-- <td width="40%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="tehsilError" class="error" style="display: none;">Please Enter Tehsil</div>
																<div id="tehsilCharsError" class="error" style="display: none;">Tehsil accepts only characters</div>
															</div>
																</td> -->
														</tr>
														<tr>
															<td><label style="font-weight:bold;">Police Station :  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=policestation id=policestation maxlength=40
																placeholder="Enter Police Station"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<!-- <td width="40%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="policestationError" class="error" style="display: none;">Please Enter Police Station</div>
																<div id="policestationCharsError" class="error" style="display: none;">Police Station accepts only characters</div>
															</div>
															</td> -->
														</tr>
														<tr>
															<td><label style="font-weight:bold;">State :<span style="color: red">*</span>  </label></td>
															<td><select class="drop1_medium pageRequired" id=state name=state>
																	<option value="">Select State</option>
																	<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
																	<option value="Andhra Pradesh">Andhra Pradesh</option>
																	<option value="Arunachal Pradesh">Arunachal Pradesh</option>
																	<option value=Assam>Assam</option>
																	<option value=Bihar>Bihar</option>
																	<option value=Chandigarh>Chandigarh</option>
																	<option value=Chhattisgarh>Chhattisgarh</option>
																	<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
																	<option value="Daman and Diu">Daman and Diu</option>
																	<option value=Delhi>Delhi</option>
																	<option value=Goa>Goa</option>
																	<option value=Gujarat>Gujarat</option>
																	<option value=Haryana>Haryana</option>
																	<option value="Himachal Pradesh">Himachal Pradesh</option>
																	<option value="Jammu and Kashmir">Jammu and Kashmir</option>
																	<option value=Jharkhand>Jharkhand</option>
																	<option value=Karnataka>Karnataka</option>
																	<option value=Kerala>Kerala</option>
																	<option value=Lakshadweep>Lakshadweep</option>
																	<option value="Madhya Pradesh">Madhya Pradesh</option>
																	<option value=Maharashtra>Maharashtra</option>
																	<option value=Manipur>Manipur</option>
																	<option value=Meghalaya>Meghalaya</option>
																	<option value=Mizoram>Mizoram</option>
																	<option value=Nagaland>Nagaland</option>
																	<option value=Orissa>Orissa</option>
																	<option value=Pondicherry>Pondicherry</option>
																	<option value=Punjab>Punjab</option>
																	<option value=Rajasthan>Rajasthan</option>
																	<option value=Sikkim>Sikkim</option>
																	<option value="Tamil Nadu">Tamil Nadu</option>
																	<option value="Telangana">Telangana</option>
																	<option value=Tripura>Tripura</option>
																	<option value=Uttarakhand>Uttarakhand</option>
																	<option value="Uttar Pradesh">Uttar Pradesh</option>
																	<option value="West Bengal">West Bengal</option>
																	<option value="Nepal">Nepal</option>
																	<option value="Bhutan">Bhutan</option>
															</select></td>
															 
														</tr>
														
														
														<!-- <tr>
															<td><label style="font-weight:bold;">State :<span style="color: red">*</span>  </label></td>
															<td><select class="drop1_medium pageRequired" id=state name=state>
																	<option value="">Select State</option>
																	 <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
																	<option value="Arunachal Pradesh">Arunachal Pradesh</option>
																	<option value=Assam>Assam</option>
																	<option value="Himachal Pradesh">Himachal Pradesh</option>
																	<option value="Jammu and Kashmir">Jammu and Kashmir</option>
																	<option value=Manipur>Manipur</option>
																	<option value=Meghalaya>Meghalaya</option>
																	<option value=Mizoram>Mizoram</option>
																	<option value=Nagaland>Nagaland</option>
																	<option value=Sikkim>Sikkim</option>
																	<option value=Tripura>Tripura</option>
															</select></td>
														</tr> -->
														<tr>
															<td><label style="font-weight:bold;">District :<span style="color: red">*</span>  </label></td>
															<td><select class="drop1_medium pageRequired" id=district name=district onchange="storeDistrict1(event)">
<script>
function storeDistrict1(event) {
    var dis=event.target.value;
    localStorage.setItem('DIS_1', dis);
}

</script>
																	<option value="">Select District</option>
															</select></td>
															<!-- <td width="40%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="districtError" class="error" style="display: none;">Please Select District</div>
															</div>
																</td> -->
														</tr>
														<tr>
															<td><label style="font-weight:bold;">Pin Code :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=pincode id=recordZipcode maxlength=6
																placeholder=" Pin Code" class="text1_medium pageRequired"
																onKeyPress="return numbersonly_mobile(this,event)" /></td>
															<!-- <td width="40%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="pincodeError" class="error" style="display: none;">Please Enter Pin Code</div>
																<div id="pincodeNosError" class="error" style="display: none;">Pin Code accepts only numbers</div>
																<div id="pinLengthError" class="error" style="display: none;">Pin Code should be 6 Digits</div>
															</div>
																</td> -->
														</tr>
												</table>
												</td>
												
												<td>
												<label style="font-weight:bold;">Whether it is same as
																	Permanent address
															</label> &nbsp; &nbsp;
															 <label> <input type="radio"
																	name="correspondence_address" value="true"
																	id="correspondence_address" onclick="correspondanceAddress()" /> Yes
															</label> <label> <input type="radio"
																	name="correspondence_address" value="false"
																	id="correspondence_address" onclick="correspondanceAddress()"  /> No
															</label>
												</td>
												
												<td width="49%">
										<table width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											
											           <tr>
															<td colspan="3"><h4 style="text-align:left;">Correspondence Address</h4></td>
														</tr>
														
														<!-- <tr>
															<td colspan="2"><label style="font-weight:bold;">Whether it is same as
																	Permanent address
															</label> &nbsp; &nbsp;
															 <label> <input type="radio"
																	name="correspondence_address" value="true"
																	id="correspondence_address" onclick="correspondanceAddress()" /> Yes
															</label> <label> <input type="radio"
																	name="correspondence_address" value="false"
																	id="correspondence_address" /> No
															</label></td>
														</tr> -->
														<tr>
														    <td width="25%"><label style="font-weight:bold;">Village/ Town :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=village1 id=village1 maxlength=40
																placeholder=" Village/ Town"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<td width="38%" align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="villageError1" class="error" style="display: none;">Please Enter Village</div>
																<div id="villageCharsError1" class="error" style="display: none;">Village accepts only characters</div>
															</div>
																</td>
														</tr>
														<tr>
														<td><label style="font-weight:bold;">Post Office :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=postoffice1 id=postoffice1 maxlength=40
																placeholder=" Post Office"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="postofficeError1" class="error" style="display: none;">Please Enter Post Office</div>
																<div id="postofficeCharsError1" class="error" style="display: none;">Post Office accepts only characters</div>
															</div>
															</td>
														</tr>
														<tr>
														<td><label style="font-weight:bold;">Tehsil :  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=tehsil1 id=tehsil1 maxlength=40
																placeholder=" Tehsil" class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="tehsilError1" class="error" style="display: none;">Please Enter Tehsil</div>
																<div id="tehsilCharsError1" class="error" style="display: none;">Tehsil accepts only characters</div>
															</div>
																</td>
														</tr>
														<tr>
														<td><label style="font-weight:bold;">Police Station :  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=policestation1 id=policestation1 maxlength=40
																placeholder=" Police Station"
																class="text1_medium pageRequired"
																onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
															<td  align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="policestationError1" class="error" style="display: none;">Please Enter Police Station</div>
																<div id="policestationCharsError1" class="error" style="display: none;">Police Station accepts only characters</div>
															</div>
															</td>
														</tr>
														<tr>
														<td><label style="font-weight:bold;">State :<span style="color: red">*</span>  </label></td>
															<td><select class="drop1_medium pageRequired" id=state1
																name=state1>
																	<option value="">Select State</option>
																	<option value="Andaman and Nicobar Islands">Andaman
																		and Nicobar Islands</option>
																	<option value="Andhra Pradesh">Andhra Pradesh</option>
																	<option value="Arunachal Pradesh">Arunachal
																		Pradesh</option>
																	<option value=Assam>Assam</option>
																	<option value=Bihar>Bihar</option>
																	<option value=Chandigarh>Chandigarh</option>
																	<option value=Chhattisgarh>Chhattisgarh</option>
																	<option value="Dadra and Nagar Haveli">Dadra
																		and Nagar Haveli</option>
																	<option value="Daman and Diu">Daman and Diu</option>
																	<option value=Delhi>Delhi</option>
																	<option value=Goa>Goa</option>
																	<option value=Gujarat>Gujarat</option>
																	<option value=Haryana>Haryana</option>
																	<option value="Himachal Pradesh">Himachal
																		Pradesh</option>
																	<option value="Jammu and Kashmir">Jammu and
																		Kashmir</option>
																	<option value=Jharkhand>Jharkhand</option>
																	<option value=Karnataka>Karnataka</option>
																	<option value=Kerala>Kerala</option>
																	<option value=Lakshadweep>Lakshadweep</option>
																	<option value="Madhya Pradesh">Madhya Pradesh</option>
																	<option value=Maharashtra>Maharashtra</option>
																	<option value=Manipur>Manipur</option>
																	<option value=Meghalaya>Meghalaya</option>
																	<option value=Mizoram>Mizoram</option>
																	<option value=Nagaland>Nagaland</option>
																	<option value=Orissa>Orissa</option>
																	<option value=Pondicherry>Pondicherry</option>
																	<option value=Punjab>Punjab</option>
																	<option value=Rajasthan>Rajasthan</option>
																	<option value=Sikkim>Sikkim</option>
																	<option value="Tamil Nadu">Tamil Nadu</option>
																	<option value="Telangana">Telangana</option>
																	<option value=Tripura>Tripura</option>
																	<option value=Uttarakhand>Uttarakhand</option>
																	<option value="Uttar Pradesh">Uttar Pradesh</option>
																	<option value="West Bengal">West Bengal</option>
																	<option value="Nepal">Nepal</option>
																	<option value="Bhutan">Bhutan</option>
																	
																		<!-- <option value="">Select State</option>
																	 <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
																	<option value="Arunachal Pradesh">Arunachal Pradesh</option>
																	<option value=Assam>Assam</option>
																	<option value="Himachal Pradesh">Himachal Pradesh</option>
																	<option value="Jammu and Kashmir">Jammu and Kashmir</option>
																	<option value=Manipur>Manipur</option>
																	<option value=Meghalaya>Meghalaya</option>
																	<option value=Mizoram>Mizoram</option>
																	<option value=Nagaland>Nagaland</option>
																	<option value=Sikkim>Sikkim</option>
																	<option value=Tripura>Tripura</option> -->
																	
															</select></td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="stateError1" class="error" style="display: none;">Please Select State</div>
															</div>
																</td>
														</tr>
														<tr>
														<td><label style="font-weight:bold;">District :<span style="color: red">*</span>  </label></td>
															<td><select class="drop1_medium pageRequired" id=district1 name=district1 onchange="storeDistrict2(event)">
<script>

function storeDistrict2(event) {
var dis=event.target.value;
localStorage.setItem('DIS_2', dis);
}
</script>																
																	<option value="">Select District</option>
															</select></td>
															<td align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="districtError1" class="error" style="display: none;">Please Select District</div>
															</div>
																</td>
														</tr>
														<tr>
														<td><label style="font-weight:bold;">Pin Code :<span style="color: red">*</span>  </label></td>
															<td><input type="text" oncut="return false"
																oncopy="return false" onpaste="return false"
																name=pincode1 id=recordZipcode1 maxlength=6
																placeholder=" Pin Code" class="text1_medium pageRequired"
																onKeyPress="return numbersonly_mobile(this,event)" /></td>
															<td  align="left" valign="middle">
															<div class="rightsideErrorClassR">
																<div id="pincodeError1" class="error" style="display: none;">Please Enter Pin Code</div>
																<div id="pincodeNosError1" class="error" style="display: none;">Pin Code accepts only numbers</div>
																<div id="pinLengthError1" class="error" style="display: none;">Pin Code should be 6 Digits</div>
															</div>
																</td>
														</tr>
													</table></td>
													
												</tr>
														
													
								
										</table>
									</td>
								</tr>
								
								<tr>
									<td class="bdr"><h2>Declaration of Criminal Cases</h2></td>
								</tr>
								<tr>
									<td>
										<table width="95%" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="69%" align="left" valign="top"><label style="font-weight:bold;" colspan="2">Have
														you ever been debarred by UPSC, SSC or SPSC or any
														recruitment board from appearing in any exam? :<span style="color: red">*</span>  </label></td>
												<td width="10%" align="left" valign="top" id="debarment"><label>
														<input type="radio" name="debarment" id="debarmentid" value="true"/> Yes
												</label> <label> <input type="radio" name="debarment" id="debarmentid" value="false"/> No
												</label></td>
												<td width="18%" align="left" valign="top">
													<div class="rightsideErrorClassR" style="margin: 1px 0px 0px 0px">
															<div id="errormessage" class="error" style="display: none;">Please select any option</div>
													</div>
												</td>
											</tr>
											
										   <tr>
													<td colspan="4" align="left" valign="top">
													<div id="debardetailsdiv" style="display: none">
														<table width="100%" border="0" align="center"	cellpadding="5" cellspacing="0">
															 <tr>
																<td colspan="3" align="left" valign="top"><label><strong>Debarred reference</strong></label></td>
															  </tr>
															<tr>
																<td class="note" colspan="3">
																   Note: You have to submit your debarred certificate at the time of Document Verification, otherwise your candidature will be cancelled.
																</td>
															</tr>
															<tr>
																<td width="55%" align="left" valign="middle"><label>Exam Organizer</label></td>
																<td width="19%" align="left" valign="middle"><input
																	name="examorganizer" type="text" class="text1" id="examorganizer" maxlength="40" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																<td width="28%" align="left" valign="middle"><div
																		class="rightsideErrorClassR">
																		<div id="deb_errormessage1" class="error" style="display: none;">Please Enter Exam Organizer </div>
																	</div></td>
															</tr>
															<tr>
																<td width="53%" align="left" valign="middle"><label>Exam Name</label></td>
																<td width="19%" align="left" valign="middle"><input
																	name="examname" type="text" class="text1" id="examname" maxlength="40" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																<td width="28%" align="left" valign="middle"><div
																		class="rightsideErrorClassR">
																		<div id="deb_errormessage2" class="error" style="display: none;">Please Enter Exam Name </div>
																	</div></td>
															</tr>
															<tr>
																<td align="left" valign="middle"><label>Exam Date</label></td>
																<td align="left" valign="middle">
																<input type="text" name="examdate" id="recordClientExamdate" readonly class="date2">
																</td>
																<td align="left" valign="middle"><div
																		class="rightsideErrorClassR">
																		<div id="deb_errormessage3" class="error" style="display: none;">Please Enter Exam Date </div>
																	</div></td>
															</tr>
															<tr>
																<td align="left" valign="middle"><label>Debarment End Date</label></td>
																<td align="left" valign="middle">
																<input type="text" name="debarenddate" id="recordClientDebarEnddate" readonly class="date2">
																</td>
																<td align="left" valign="middle"><div
																		class="rightsideErrorClassR">
																		<div id="deb_errormessage4" class="error" style="display: none;">Please Enter Debarment End Date </div>
																	</div></td>
															</tr>
															<tr>
																<td><label>Reason</label></td>
																<td><select class="drop1 pageRequired" id=debar_reason name=debar_reason>
																		<option value="">Select Reason</option>
																		<option value="Impersonation">Impersonation</option>
																		<option value="Using Unfair Means">Using Unfair Means</option>
																		<option value="Misbehaviour/Criminal Act">Misbehaviour/Criminal Act</option>
																		<option value="Others">Others</option>
																		</select>
																 </td>
																 <td width="40%" align="left" valign="middle">
																		<div class="rightsideErrorClassR">
																			<div id="deb_errormessage5" class="error" style="display: none;">Please Select Reason</div>
																		</div>
																 </td>
															</tr>
															<tr>
																<td width="53%" align="left" valign="middle"><label>Specify, If others</label></td>
																<td width="19%" align="left" valign="middle"><input
																	name="other_reason" type="text" class="text1" id="other_reason" maxlength="50"  onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																<td width="28%" align="left" valign="middle"><div class="rightsideErrorClassR">
																		<div id="deb_errormessage6" class="error" style="display: none;">Please Enter Other Reason</div>
																	</div></td>
															</tr>
													</table>
												 </div>		
												</td>
											</tr>
										  						
											<tr>
												<td colspan="4" align="left" valign="middle"><label><strong>Criminal
															Proceeding details, if any</strong></label></td>
											</tr>
											<tr>
												<td colspan="4" align="left" valign="middle">
												<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
														<tr>
															<td width="2%" align="center" valign="top"><label style="font-weight:bold;"> a) </label></td>
															<td width="69%" align="left" valign="top"><label style="font-weight:bold;">Whether
																	any FIR or criminal case(s) has ever been registered
																	against you? :<span style="color: red">*</span>  </label></td>
															<td width="10%" align="left" valign="top" id="fir_cases">
															<label><input type="radio" name="fir_cases" value="true"/>  Yes </label>
															<label>	<input type="radio" name="fir_cases" value="false"/> No
															</label>
															</td>
															<td width="18%" align="left" valign="top">
																<div class="rightsideErrorClassR" style="margin: 1px 0px 0px 0px">
																		<div id="errormessage1" class="error" style="display: none;">Please select any option</div>
																</div>
															</td>
														</tr>
														<tr>
															<td align="center" valign="top"><label style="font-weight:bold;"> b) </label></td>
															<td align="left" valign="top"><label style="font-weight:bold;">Whether
																	any criminal complaint case or FIR or criminal case(s)
																	is pending against you in Court of Law, <br/> or with police
																	at the time of submitting the application form? :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="top" id="fir_cases_pending"><label> <input
																	type="radio" name="fir_cases_pending" value="true"/> Yes
															</label> <label> <input type="radio"
																	name="fir_cases_pending" value="false"/> No
															</label></td>
															<td width="20%" align="left" valign="top">
																<div class="rightsideErrorClassR" style="margin: 1px 0px 0px 0px">
																		<div id="errormessage2" class="error" style="display: none;">Please select any option</div>
																</div>
															</td>
														</tr>
														<tr>
															<td align="center" valign="top"><label style="font-weight:bold;"> b) </label></td>
															<td align="left" valign="top"><label style="font-weight:bold;">Have
																	you ever been arrested/detained in any criminal
																	case(s)? :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="top" id="arrested"><label> <input
																	type="radio" name="arrested" value="true"  />
																	Yes
															</label> <label> <input type="radio" name="arrested"
																	value="false" /> No
															</label></td>
															<td width="20%" align="left" valign="top">
																<div class="rightsideErrorClassR" style="margin: 1px 0px 0px 0px">
																		<div id="errormessage3" class="error" style="display: none;">Please select any option</div>
																</div>
															</td>
														</tr>
														<tr>
															<td align="center" valign="top"><label style="font-weight:bold;"> d) </label></td>
															<td align="left" valign="top"><label style="font-weight:bold;">Have
																	you ever been tried &amp; convicted or acquitted by a
																	Court of Law in any criminal  case(s)?
															 :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="top" id="criminal_case_acquitted"><label> <input
																	type="radio" name="criminal_case_acquitted"
																	value="true" /> Yes
															</label> <label> <input type="radio"
																	name="criminal_case_acquitted" value="false"/> No
															</label></td>
															<td width="20%" align="left" valign="top">
																<div class="rightsideErrorClassR" style="margin: 1px 0px 0px 0px">
																		<div id="errormessage4" class="error" style="display: none;">Please select any option</div>
																</div>
															</td>
														</tr>
														<tr>
															<td align="center" valign="top"><label style="font-weight:bold;"> e) </label></td>
															<td align="left" valign="top"><label style="font-weight:bold;">Have
																	you ever been tried &amp; convicted by the Court by
																	filling any bond for good behaviour etc.?
															 :<span style="color: red">*</span>  </label></td>
															<td align="left" valign="top" id="good_behavior_bond" ><label> <input
																	type="radio" name="good_behavior_bond" value="true"/> Yes
															</label> <label> <input type="radio"
																	name="good_behavior_bond" value="false"/> No
															</label></td>
															<td width="20%" align="left" valign="top">
																<div class="rightsideErrorClassR" style="margin: 1px 0px 0px 0px">
																		<div id="errormessage5" class="error" style="display: none;">Please select any option</div>
																</div>
															</td>
														</tr>
														<tr id="fir_details" style="display:none; border:1px solid black;">
															<td colspan="4" align="left" valign="top">
																<table width="100%" border="0" align="center"
																	cellpadding="5" cellspacing="0">
																	<tr>
																		<td colspan="4" align="left" valign="top"><label><strong>Case reference</strong></label></td>
																	</tr>
																	<tr>
																		<td width="55%" align="left" valign="middle"><label>FIR No.</label></td>
																		<td width="19%" align="left" valign="middle"><input
																			name="firno" type="text" class="text1" id="firno"  maxlength="40" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																		<td width="28%" align="left" valign="middle"><div
																				class="rightsideErrorClassR">
																				<div id="errormessage6" class="error" style="display: none;">Please Enter FIR No </div>
																			</div></td>
																	</tr>
																	<tr>
																		<td align="left" valign="middle"><label>Date</label></td>
																		<td align="left" valign="middle">
																		<input type="text" name="firdate" id="recordClientFirdate" readonly class="date2">
																		</td>
																		<td align="left" valign="middle"><div
																				class="rightsideErrorClassR">
																				<div id="errormessage7" class="error" style="display: none;">Please Enter FIR Date </div>
																			</div></td>
																	</tr>
																	<tr>
																		<td align="left" valign="middle"><label>Under Section</label></td>
																		<td align="left" valign="middle"><input
																			name="firsection" id="firsection" type="text"
																			class="text1"  maxlength="40" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																		<td align="left" valign="middle"><div
																				class="rightsideErrorClassR">
																				<div id="errormessage8" class="error" style="display: none;">Please Enter Under Section </div>
																			</div></td>
																	</tr>
					
																  <!--  <tr>
																		<td align="left" valign="middle"><label>Specify, Other Section</label></td>
																		<td align="left" valign="middle"><input
																			name="fir_other_section" id="fir_other_section" type="text"
																			class="text1"  maxlength="40" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)"/></td>
																		<td align="left" valign="middle"><div
																				class="rightsideErrorClassR">
																				<div id="errormessage8_other" class="error" style="display: none;">Please Enter Other Section </div>
																			</div></td>
																	</tr> -->
																	<tr>
																		<td align="left" valign="middle"><label>District</label></td>
																		<td align="left" valign="middle"><input
																			name="firdistrict" id="firdistrict" type="text"
																			class="text1"  maxlength="80" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
																		<td align="left" valign="middle"><div
																				class="rightsideErrorClassR">
																				<div id="errormessage9" class="error" style="display: none;">Please Enter District</div>
																			</div></td>
																	</tr>
																	<tr>
																		<td align="left" valign="middle"><label>Present
																				status of the case at the time of filling up
																				this application form
																		</label></td>
																		<td align="left" valign="middle"><input
																			name="firstatus" id="firstatus" type="text"
																			class="text1"  maxlength="80" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" /></td>
																		<td align="left" valign="middle"><div
																				class="rightsideErrorClassR">
																				<div id="errormessage10" class="error" style="display: none;">Please Enter Present status </div>
																			</div></td>
																	</tr>
																	<tr>
																		<td colspan="3" align="left" valign="middle"
																			class="note">(Note: If after submission of this
																			application form, any criminal case(s) is registered
																			against you or arrested/detained by Police in any
																			criminal case relevant details of same should be
																			communicated immediately to the concerned Chairman of
																			Recruitment Board conducting recruitment failing
																			which it shall be deemed to be suppression of factual
																			information.)</td>
																	</tr>
																</table>
															</td>
														</tr>
													</table></td>
											</tr>
										</table>
									</td>
								</tr>
											
								
							</table>
							
							
							<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
								<tr>
									<td class="bdr"><h2>Create Password</h2></td>
								</tr>
								
								<tr>
								<td align="left" valign="middle" >
									<table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
									<tr>
									<td width="10%"><label style="font-weight:bold;">Password :<span style="color: red">*</span>  </label></td>
									  <td width="20%">
										 <input type="password" oncut="return false" oncopy="return false" onpaste="return false" name=password id=password maxlength=6 placeholder=" Password (6 characters)" class="text1_medium pageRequired" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" />
									  </td>
									  <td width="15%"><label style="font-weight:bold;">Confirm Password :<span style="color: red">*</span>  </label></td>
									  <td width="20%">
										 <input type="password" oncut="return false" oncopy="return false" onpaste="return false" name=confirm_password id=confirm_password maxlength=6 placeholder=" Confirm Password" class="text1_medium pageRequired" onKeyPress="return charsNumbersAndSpecialCharsOnly(this,event)" />
									  </td>
									  <td width="30%" align="left" valign="middle">
										<div class="rightsideErrorClassR">
											<div id="passwordError" class="error" style="display: none;">Please Enter Password</div>
											<div id="passwordLengthError" class="error" style="display: none;">Password must contain at least six characters</div>
											<div id="passwordMatchError" class="error" style="display: none;">Password and confirmed password does not match</div>
										</div>
										</td>
								 </tr>
								</table>
								</td>
								</tr> 
														
							</table>
							
							<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
								<tr>
									<td class="bdr"><h2>Declaration by the Candidate</h2></td>
								</tr>
								
								<tr>
									<td align="left" valign="middle" class="bdr">
									<table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
											
									<tr>
										<td align="left" valign="middle" >	
													<label> <input type="checkbox" name="agree_save1" id="agree_save1" /> &nbsp;&nbsp;  I have applied only for this post (<span id="post_selected_name_declaration"> </span>) .</label>
										 </td>
								     </tr>
									 <tr>
										<td align="left" valign="middle" >	
													<label> <input type="checkbox" name="agree_save" id="agree_save" /> &nbsp;&nbsp; I hereby declare that the information given above is true to the best of my knowledge and belief and nothing has been concealed therein. I am well aware of the fact that if the information given by me is proved not true, I will have to face the consequences as per the Law. Also, all the benefits availed by me shall be summarily withdrawn.</label>
										 </td>
								     </tr>
								     </table>
								     </td>
								 </tr>
							</table>
					
						<% 
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        Date date1 = sdf.parse("2021-07-23 00:00:00");
			        Date date2 = new Date();
			        if (date1.compareTo(date2) < 0) {
			        %>
			        
							<table width="95%" border="0" align="center" cellpadding="5"
								cellspacing="0">
								<tr>
									<td><div class="buttonWrapper">
											<input name="back" type="button"
												class="open1 prevbutton appFormBtmleft" value="Back"
												alt="Back" id="secondDivBack" /> <input name="Proceed"
												id="thirdDivNext" type="submit" class="open3 nextbutton appFormBtmRight"
												value="Proceed" alt="Proceed" style="width: 150px;"  />
										</div></td>
								</tr>
							</table>
						<%} %>	
						</div>
									
									
							</td>
							</tr>
							
						</table>

						

					</div>
					</div>
			</form>
		</div>
		<!--Content div ends here-->
</div>
</div>
</div>
</div>

		<jsp:include page="footer.jsp" flush="true" />

	
	
	<!--Wrapper div ends here-->
</body>
</html>