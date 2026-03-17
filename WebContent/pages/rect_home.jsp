 <%-- This is the Second page of the Web page 
  <%--New candidate can register and read the  Advertisement documents and Instruction  
  Existing Candidate Can log in--%>
  
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>SSB Recruitment</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="css/bootstrap.min.css" />		
		<link rel="stylesheet" href="css/style_login.css" />		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body oncontextmenu="return true;">
		<jsp:include page="header.jsp" flush="true" />
		<div class="divider hidden-xs">
		<span class="span_head">  </span> 
		</div>
		<div class="container">
			<div class="registrationblock">
				<div class="row">
					<div class="col-md-5">
						<div class="panelBlock">
							<div class="panelHeader">
								Registration Division
							</div>
							<div class="panelBody">
							<%
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        Date date1 = sdf.parse("2023-05-17 00:00:00");
			        Date date2 = new Date();
			        if (date1.compareTo(date2) < 0) {
			      %>
								
								<div class="text-center">
								<h4>Registration Division</h4>
									<a href="applicationForm">  <button class="btn btn-primary registrationBtn" type="button">REGISTER</button> </a>
								</div>
						
								<div class="registrationFields">
								<h4>View Application Status</h4>
									<form name="applicationSearch" id="applicationSearch" method="post" action="applicationSearch">
										<div class="form-group">
										<input type="hidden" name="requestFrom" value="ApplicationHome"/>
											<label>Registration ID</label>
											<input type="text" class="form-control" placeholder="Enter your Registration ID" maxlength="8" autocomplete="off" oncut="return false;" oncopy="return false;" onpaste="return false;" id="transactionid" name="transactionid" 
                                    onKeyPress="return numbersonly_mobile(this,event)" />
										</div>
										<div class="form-group">
											<label>Password</label>
											<input type="password" class="form-control" placeholder="Enter your Password"  name="password" maxlength="20"  autocomplete="off" oncut="return false;" oncopy="return false;" onpaste="return false;" id="password" />
										</div>
										<div class="form-group">
											<label>Enter Captcha <span class="importantField">*</span></label>
											<input type="text" class="form-control" placeholder="Enter Below Text" name="answer" maxlength="6" autocomplete="off" oncut="return false;" oncopy="return false;" onpaste="return false;"/>
										</div>
										<div class="text-center">
											<div class="col-md-4 col-md-offset-3">
                                        <img alt="" id="captcha" src="simpleCaptcha.png" width="150" />
                                    </div>
											<%String message=(String)request.getAttribute("message");
                                if(message!=null && !"".equalsIgnoreCase(message)){ %>
                                 <div class="row">
                                 <div class="col-md-12 colorText" style="text-align:center;">
                                   <%=message %>
                                     </div>
                                  </div>   
                                <%} %>
                                
												<button type="submit" class="btn btn-primary btnSubmit" onclick="return validation()"> Login
												<span class="glyphicon glyphicon-ok"></span>
											</button>
											
											<a href="forgotPassword" class="forgotPassword">Forgot Password?</a>
											<a href="forgotRegId" class="forgotPassword">Forgot Registration Id?</a>
											
										
										</div>
									</form>
								</div>
								
								<%}else{
							%>		
							<div class="text-center">
									<h4>Registrations will open from 20-05-2023 12AM</h4>
								</div>
						<% } %>
						
							</div>
						</div>
					</div>
					<div class="col-md-7">
						<div class="candidatesBlock">
							<div class="panelBlock">
								<div class="panelHeader">
									Candidates Corner
								</div>
								<div class="panelBody">
									<ul class="candidatesNote">
										<li>
											<a href="pdfs/Medical_cadre_Ct__HC.pdf" target="_blank"><button type="button" class="btn btn-primary advBtn">Advertisement</button></a>
										</li>
										<li>
											<a href="pdfs/SSB_ADVT_GUIDELINES.pdf" target="_blank"><button type="button" class="btn btn-primary instructionBtn">Instruction to the Candidates</button></a>
										</li>
										
										
										<li>
											<a href="pdfs/Guidelines_Photo_Signature.pdf" target="_blank"><button type="button" class="btn btn-primary uploadBtn">How to upload Photographs and Signatures</button></a>
										</li>
									</ul>
									
									 
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
		
		<script type="text/javascript">
window.onpageshow = function (evt) {
	if (evt.persisted) noBack();
	};
	
	function goToHome(post_id)
	{
		document.selectPost.post.value=post_id;
			return true;
		
	}
</script>
<script>
function trim1(a){return a;}
function numbersonly_mobile(f,b,d){
	var a;var c;
	if(window.event){
		a=window.event.keyCode;
		}
	else{
		if(b){a=b.which;}
		else{return true;}
		}
	c=String.fromCharCode(a);
	if((a==null)||(a==0)||(a==8)||(a==9)||(a==13)||(a==27))
	{return true;}
	else{
		if((("0123456789").indexOf(c)>-1)){return true;}
		else{
			if(d&&(c==".")){f.form.elements[d].focus();return false;}
			else{return false;}
			}
		}
 }
	

function validation() {
	
	if (trim1(document.applicationSearch.transactionid.value) == "") {
		alert("Please enter Registration Id");
		return false;
	} else if (document.applicationSearch.transactionid.value.length != 8) {
			alert("Registration Id should be 8 digits only");
			return false;
	}
	if (trim1(document.applicationSearch.password.value) == "") {
		alert("Please Enter Password");
		return false;
	} 	
	return true;
}

	
	</script>
<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>
	<jsp:include page="footer.jsp" flush="true" />
	</body>
</html>
