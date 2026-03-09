<%@ page import="com.ttil.bean.ApplicationFormBean" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page pageEncoding="utf-8"%>
<title>SSB Online</title>
 <link rel="shortcut icon" href="images/favicon.jpg" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>

<script>function numbersonly_mobile(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)){return true;}else{if((("0123456789").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return false;}else{return false;}}}}
function numericsonly_mobile(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)){return true;}else{if((("0123456789.").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return false;}else{return false;}}}}
function charactersonly_mobile(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)||(a==32)){return true;}else{if((("abcdefghijklmnopqrstuvwxyz").indexOf(c)>-1)){return true;}else{if((("ABCDEFGHIJKLMNOPQRSTUVWXYZ").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return true;}else{return false;}}}}}function charsAndNumbersOnly(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)||(a==32)){return true;}else{if((("abcdefghijklmnopqrstuvwxyz1234567890.").indexOf(c)>-1)){return true;}else{if((("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return true;}else{return false;}}}}}function charsNumbersAndSpecialCharsOnly(f,b,d){var a;var c;if(window.event){a=window.event.keyCode;}else{if(b){a=b.which;}else{return true;}}c=String.fromCharCode(a);if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27)||(a==32)){return true;}else{if((("abcdefghijklmnopqrstuvwxyz1234567890.,()&-_/':;").indexOf(c)>-1)){return true;}else{if((("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,()&-_/:;").indexOf(c)>-1)){return true;}else{if(d&&(c==".")){f.form.elements[d].focus();return true;}else{return false;}}}}}
function trim1(a){return a;}
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		
		

		/* <!-- upload js--> */
		/* var wrapper = $('<div/>').css({
			height : 0,
			width : 0,
			'overflow' : 'hidden'
		});
		var fileInput = $(':file').wrap(wrapper);

		fileInput.change(function() {
			$this = $(this);
			$('#file').text($this.val());
		})

		$('#file').click(function() {
			fileInput.click();
		}).show(); */
		/* <!--for signature-->
		 <!-- upload js--> */
		/* var wrapper = $('<div/>').css({
			height : 0,
			width : 0,
			'overflow' : 'hidden'
		});
		var fileInput = $(':file').wrap(wrapper);

		fileInput.change(function() {
			$this = $(this);
			$('#file1').text($this.val());
		})

		$('#file1').click(function() {
			fileInput.click();
		}).show(); 
	*/
	});
</script>
<script type="text/javascript">
	function fifthPagevalidation()
	{
		var image = document.getElementById("photosrc").value;
		if(image==""){
			alert("Please select Photograph");
			return false;
		}
		else {
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
				alert("Please select .jpg/.png images only.");
				document.getElementById("photosrc").focus();
				return false;
			}
		}
		var image1 = document.getElementById("sigsrc").value;
		if(image1==""){
			alert("Please select Signature");
			return false;
		}
		else {
			var checkimg = image1.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
				alert("Please select .jpg/.png images only.");
				document.getElementById("sigsrc").focus();
				return false;
			}
		}
		
		/* var image2 = document.getElementById("matricsrc").value;
		if(image2==""){
			alert("Please Upload Matriculation Certificate");
			return false;
		}
		else {
			var checkimg = image2.toLowerCase();
			if (!checkimg.match(/(\.pdf|\.PDF|\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
				alert("Please select ./pdf/.jpg/.png Files only.");
				document.getElementById("matricsrc").focus();
				return false;
			}
		}
		
		if(document.getElementById("sportssrc")!=null){
			var image3 = document.getElementById("sportssrc").value;
			if(image3==""){
				alert("Please Upload Professional Qualification  Certificate");
				return false;
			}
			else {
				var checkimg = image3.toLowerCase();
				if (!checkimg.match(/(\.pdf|\.PDF|\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
					alert("Please select ./pdf/.jpg/.png Files only.");
					document.getElementById("sportssrc").focus();
					return false;
				}
			}
		}
		
		if(document.getElementById("identitysrc")!=null){
			var image6 = document.getElementById("identitysrc").value;
			if(image6==""){
				alert("Please Upload Identity File");
				return false;
			}
			else {
				var checkimg = image6.toLowerCase();
				if (!checkimg.match(/(\.pdf|\.PDF|\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
					alert("Please select ./pdf/.jpg/.png Files only.");
					document.getElementById("identitysrc").focus();
					return false;
				}
			}
		}
		
		
		if(document.getElementById("categorysrc")!=null){
			var image4 = document.getElementById("categorysrc").value;
			if(image4==""){
				alert("Please Upload Category Certificate");
				return false;
			}
			else {
				var checkimg = image4.toLowerCase();
				if (!checkimg.match(/(\.pdf|\.PDF|\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
					alert("Please select ./pdf/.jpg/.png Files only.");
					document.getElementById("categorysrc").focus();
					return false;
				}
			}
		}
		
		if(document.getElementById("communitysrc")!=null){
			var image5 = document.getElementById("communitysrc").value;
			if(image5==""){
				alert("Please Upload Community Belonging Certificate");
				return false;
			}
			else {
				var checkimg = image5.toLowerCase();
				if (!checkimg.match(/(\.pdf|\.PDF|\.jpg|\.JPG|\.jpeg|\.JPEG|\.png|\.PNG)$/)) {
					alert("Please select ./pdf/.jpg/.png Files only.");
					document.getElementById("communitysrc").focus();
					return false;
				}
			}
		} */
		
		
		
		return true;
	}
	function validation(){
    	
			if(fifthPagevalidation()){
				return true;
			}
    	return false;
    }
	
	
	function goToInstructions() {
		document.location.href = "applicationAfterIndex";
	}
	
	function check(){
		
			/* var input=document.applicationForm.photofileData;
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#photoblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			}
			
			var sigfileinput=document.applicationForm.sigfileData;
			if (sigfileinput.files && sigfileinput.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#sigblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(sigfileinput.files[0]);
			} */
		
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		function readURL1(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 500 * 1024) {
			    	document.applicationForm.photofileData.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
					var reader = new FileReader();
					reader.onload = function(e) {
						$('#photoblah').attr('src', e.target.result);
					};
					reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#photosrc").change(function() {
			readURL1(this);
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		function readURL(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 200 * 1024) {
			    	document.applicationForm.sigfileData.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#sigblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#sigsrc").change(function() {
			readURL(this);
		});
		
		
		/* function readURLMatric(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 500 * 1024) {
			    	document.applicationForm.matricCertificate.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#matricblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#matricsrc").change(function() {
			readURLMatric(this);
		});
		
		function readURLSports(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 500 * 1024) {
			    	document.applicationForm.profQualCertificate.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#sportsblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#sportssrc").change(function() {
			readURLSports(this);
		});
		
		function readURLIdentity(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 500 * 1024) {
			    	document.applicationForm.identityCertificate.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#identityblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#identitysrc").change(function() {
			readURLIdentity(this);
		});
		
		function readURLCategory(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 500 * 1024) {
			    	document.applicationForm.categoryCertificate.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#categoryblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#categorysrc").change(function() {
			readURLCategory(this);
		});
		
		
		function readURLCommunity(input) {
			if (input.files && input.files[0]) {
				var oFile = input.files[0];
				// check for file size
			    if (oFile.size > 500 * 1024) {
			    	document.applicationForm.communityCertificate.value="";
			    	alert("You have selected too big file, please select a one smaller image file");
			        return false;
			    }else{
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#communityblah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			    }
			}
		}
		$("#communitysrc").change(function() {
			readURLCommunity(this);
		}); */
	});
</script>
<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>
</head>
<body  onLoad="noBack();" onUnload="" oncontextmenu="return true;">
	<!--wrapper div starts here-->
	
	<jsp:include page="header.jsp" flush="true" />
	<!--wrapper div starts here-->
	   <div class="container-fluid">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails">

			<!--Content div starts here-->
			<form name=applicationForm id=applicationForm method=post action=uploadPhoto enctype="multipart/form-data">
				<div class="contentoutter">
					<div class="contentinner">
						<%
				          ApplicationFormBean applicationFormBean= (ApplicationFormBean)session.getAttribute("ApplicationFormBean");
						String message = (String)request.getAttribute("message");
						int final_transaction_id=(Integer)request.getAttribute("final_transaction_id");
						if(message!=null){
						%>
						
						    <table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
							       <td colspan="2" class="center rightbodernoneclass colorText"><b>message</b></td>
						        </tr>
							</table>
						<%} %>
						<%if(applicationFormBean!=null && applicationFormBean.getTransactionid()==final_transaction_id){ %>	
							
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							 <tr>
					            <td height="100"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle2">Please Note Down RegistrationID : <%=applicationFormBean.getTransactionid() %></div></td>
					          </tr>
          
								<tr>
									<td class="bdr">
									<input type="hidden" name="requestFrom1" value="uploadPhoto" />
									<input type="hidden" name="final_transaction_id" value="<%=final_transaction_id %>" />
									
									<h2>Upload Photo and Signature</h2></td>
								</tr>
							</table>
							<table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
								<tr>
									<td width="30%" align="left" valign="top"><span
										class="style2"> <label><strong>Photo Specifications</strong></label>
									</span></td>
									<td align="left" valign="top"><span class="style3">
											<label><strong>The Photograph must be:</strong></label>
									</span></td>
									<td width="30%" align="left" valign="middle"><div
											class="rightsideErrorClassR">
											<div id="errormessage6" class="error" style="display: none;">Please Select Photo</div>
										</div></td>
								</tr>

								<tr style="border-bottom:2pt solid black;">
									<td align="left" valign="middle"><table width="100%"
											border="0" align="center" cellpadding="0" cellspacing="0">
											<tr>
												<td><img src="images/photo.png" alt="" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
											
											<tr>
												<td>
												<img id="photoblah" width="200" height="200" src="images/photo1.png" alt="" />
												</td>
											</tr>
											<tr>
												<td><div id="file">
														<!-- <input type="button" value="Upload Image" class="browse" /> -->
													</div> <input name="photofileData" type="file" id="photosrc" value="Browse Photo" /></td>
											</tr>
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%" align="left" valign="middle"><label>No
														more than 6 months old</label></td>
											</tr>
											<!-- <tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>35-40mm
														in width</label></td>
											</tr> -->
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>In
														sharp focus and clear</label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														type must be .jpg /.png</label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 500KB</label></td>
											</tr>
										</table></td>
								</tr>
								<tr style="border-bottom:1pt solid black;">
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Upload
												Signature</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Points
												to follow</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><div
											class="rightsideErrorClassR">
											<div id="errormessage" class="error" style="display: none;">Please
												Select Ex-serviceman</div>
										</div></td>
								</tr>
								<tr>
									<td align="left" valign="middle"><table width="100%"
											border="0" align="center" cellpadding="0" cellspacing="0">
											
											<tr>
												<td>
												<img id="sigblah" width="200" height="200" src="" alt="" />
												</td>
											</tr>
											<tr>
												<td><div id="file">
														<!-- <input type="button" value="Upload Image" class="browse" /> -->
													</div> <input name="sigfileData" type="file" id="sigsrc" value="Browse Signature" /></td>
											</tr>
											
											<!-- <tr>
												<td><img src="images/photo1.png" alt="" /></td>
											</tr>
											<tr>
												<td><div id="file1">
														<input type="button" value="Upload Signature"
															class="browse" />
													</div> <input name="fileData" type="file" id="src" value="Browse" /></td>
											</tr> -->
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%" align="left" valign="middle"><label>Signature
														must be on white paper</label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>It
														should be in Black or Blue Ink</label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File type must be .jpg /.png </label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 200KB</label></td>
											</tr>
										</table></td>
								</tr>
								
							<%-- 	<!--  Matric Certificate -->
								<tr style="border-bottom:1pt solid black;">
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Upload
												Matriculation(SSC) Certificate</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Points
												to follow</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><div class="rightsideErrorClassR"> </div></td>
								</tr>
								<tr>
									<td align="left" valign="middle"><table width="100%"
											border="0" align="center" cellpadding="0" cellspacing="0">
											
											<tr>
												<td>
												<img id="matricblah" width="200" height="200" src="" alt="" />
												</td>
											</tr>
											
											<tr>
												<td><div id="file">
													</div> <input name="matricCertificate" type="file" id="matricsrc" value="Browse Matric Certificate" /></td>
											</tr>
											
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%"  align="left" valign="middle"><label>File type must be .jpg /.pdf </label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 500KB</label></td>
											</tr>
										</table></td>
								</tr>
								
								
								<!--  Sports Certificate -->
								
								<tr style="border-bottom:1pt solid black;">
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Upload Professional Qualification Certificate</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Points to follow</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><div class="rightsideErrorClassR"> </div></td>
								</tr>
								<tr>
									<td align="left" valign="middle"><table width="100%"
											border="0" align="center" cellpadding="0" cellspacing="0">
											
											<tr>
												<td>
												<img id="sportsblah" width="200" height="200" src="" alt="" />
												</td>
											</tr>
											
											<tr>
												<td><div id="file">
													</div> <input name="profQualCertificate" type="file" id="sportssrc" value="Browse Professional Qualification Certificate" /></td>
											</tr>
											
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%"  align="left" valign="middle"><label>File type must be .jpg /.pdf </label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 500KB</label></td>
											</tr>
										</table></td>
								</tr>
								
								
								<!--  Identity Certificate -->
								
								<tr style="border-bottom:1pt solid black;">
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Upload Identity (<%=applicationFormBean.getIdentity_type() %>) File</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Points to follow</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><div class="rightsideErrorClassR"> </div></td>
								</tr>
								<tr>
									<td align="left" valign="middle"><table width="100%"
											border="0" align="center" cellpadding="0" cellspacing="0">
											
											<tr>
												<td>
												<img id="identityblah" width="200" height="200" src="" alt="" />
												</td>
											</tr>
											
											<tr>
												<td><div id="file">
													</div> <input name="identityCertificate" type="file" id="identitysrc" value="Browse Identity File" /></td>
											</tr>
											
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%"  align="left" valign="middle"><label>File type must be .jpg /.pdf </label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 500KB</label></td>
											</tr>
										</table></td>
								</tr>
								
								
								<!--  Category Certificate -->
								<% if(applicationFormBean.getCommunity()!=null && ("OBC".equalsIgnoreCase(applicationFormBean.getCommunity()) || "SC".equalsIgnoreCase(applicationFormBean.getCommunity()) || "ST".equalsIgnoreCase(applicationFormBean.getCommunity()) || "EWS".equalsIgnoreCase(applicationFormBean.getCommunity()) ) ) {  %>
								<tr style="border-bottom:1pt solid black;">
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Upload Category (<%=applicationFormBean.getCommunity() %>) Certificate</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Points to follow</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><div class="rightsideErrorClassR"> </div></td>
								</tr>
								<tr>
									<td align="left" valign="middle"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
											
											<tr>
												<td>
												<img id="categoryblah" width="200" height="200" src="" alt="" />
												</td>
											</tr>
											
											<tr>
												<td><div id="file">
													</div> <input name="categoryCertificate" type="file" id="categorysrc" value="Browse Category Certificate" /></td>
											</tr>
											
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%"  align="left" valign="middle"><label>File type must be .jpg /.pdf </label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 500KB</label></td>
											</tr>
										</table></td>
								</tr>
								<%} %>
								
								<!--  Community Certificate -->
								<%if(applicationFormBean.isCategoty_belongs()){ %>
								<tr style="border-bottom:1pt solid black;">
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Upload Community belonging Certificate</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><label><strong>Points to follow</strong></label></td>
									<td align="left" valign="middle" style="padding-top: 60px;"><div class="rightsideErrorClassR"> </div></td>
								</tr>
								<tr>
									<td align="left" valign="middle"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
											
											<tr>
												<td>
												<img id="communityblah" width="200" height="200" src="" alt="" />
												</td>
											</tr>
											
											<tr>
												<td><div id="file">
													</div> <input name="communityCertificate" type="file" id="communitysrc" value="Browse Community Certificate" /></td>
											</tr>
											
										</table></td>
									<td colspan="2" align="left" valign="top"><table
											width="100%" border="0" align="center" cellpadding="5"
											cellspacing="0">
											<tr>
												<td width="6%" align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td width="94%"  align="left" valign="middle"><label>File type must be .jpg /.pdf </label></td>
											</tr>
											<tr>
												<td align="left" valign="middle"><img
													src="images/dot.png" alt="" /></td>
												<td align="left" valign="middle"><label>File
														Size must be less than 500KB</label></td>
											</tr>
										</table></td>
								</tr>
								<%} %> --%>
								
							</table>
							
							
							<table width="95%" border="0" align="center" cellpadding="5"
								cellspacing="0">
								<tr>
									<td><div class="buttonWrapper">
											 <input name="Proceed"
												type="submit" class="open3 nextbutton appFormBtmRight"
												value="Proceed" alt="Proceed" style="width: 150px;" onClick="return validation()" />
										</div></td>
								</tr>
							</table>
							
							<%} else{%>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
							       <td colspan="2" class="center rightbodernoneclass colorText"><b>Session Expired or Invalid Page</b></td>
						        </tr>
							</table>
							<%} %>
						</div>
   </div>
			</form>
		</div>
		<!--Content div ends here-->
</div>
	<!--Wrapper div ends here-->
	</div>
	</div>
	</div>
	
		<jsp:include page="footer.jsp" flush="true" />

	
</body>
</html>