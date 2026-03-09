<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to SSB online application</title>
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
 <link rel="shortcut icon" type="image/ico" href="images/favicon.ico" />
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <link href="css/jquery.datepick.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.datepick.js"></script>
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
	
	<%--This function is define to check candidate authentication in forgot Registration id --%>
function validation() {
	
	if (trim1(document.applicationSearch.post_applied.value) == "") {
		alert("Please Select Which Post You Applied");
		return false;
	}
	
	if (trim1(document.applicationSearch.mobilenumber.value) == "") {
		alert("Please enter Mobile Number");
		return false;
	} else if (document.applicationSearch.mobilenumber.value.length != 10) {
			alert("Mobile Number should be 10 digits only");
			return false;
	}
	if (trim1(document.applicationSearch.dob.value) == "") {
		alert("Please select Date of birth");
		return false;
	} 	
	return true;
}

	
	</script>
<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>
<script type="text/javascript">
	$(function() {
		//var changeMonth = $( ".selector" ).datepicker( "option", "changeMonth" );
		//var changeYear = $( ".selector" ).datepicker( "option", "changeYear" );
		//var minDate = $( ".selector" ).datepicker( "option", "minDate" );
		$('#recordClientDob').datepick({
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : "-67:-18",
			onSelect: function(evnt) {
		         getAge();
		    }
		});
	});
	</script>		
</head>
<body onLoad="noBack();" onUnload="" oncontextmenu="return false;">

  <jsp:include page="header.jsp" flush="true" />
  
 
 
<div class="container" id="mainWrapper">



<div class="row">
    <div class="col-md-12">  
      <div class="panel mainPanel">
        <div class="panel-body" style="padding:0;margin-bottom:30px;">
            <div class="row registration_sec">
                <div class="col-md-9" style="margin-left:170px;">
                    <div class="panel panel-default registrationBlock">
                        <div class="panel-heading">Forgot Registration Id &amp; Password</div>
                        
                        <div class="panel-body" style="min-height: 350px;">
                            <div class="text-center" style="height:70px;">
                            </div>
                            
                            <form name="applicationSearch" id="applicationSearch" method="post" action="retrieveRegId">
                                
								 <div class="row">
                                    <div class="col-md-2"></div>
                                    <div class="col-md-3">Select Post Applied</div>
                                     <div class="col-md-5">
                                         <select class="drop1 pageRequired" style="margin-bottom: 10px;"name=post_applied id=post_applied>
										  <option value="">Select</option>
										  <!-- <option value="21">Assistant Commandant (Veterinary)</option>  -->
										  
										   <option value="1">Sub Inspector (Pioneer)</option>
										   <option value="2">Sub Inspector (Draughtsman)</option>
										   <option value="3">Sub Inspector (Communication)  </option>
										   <option value="4">Sub Inspector (Staff Nurse Female)</option>
										  
										  <!--  <option value="1">ASI(Pharmacist)</option>
										   <option value="2">ASI(Radiographer)</option>
										   <option value="3">ASI(Operation Theater Technician)</option>
										   <option value="4">ASI(Dental Technician)</option>
										   -->
										  <!--  <option value="1">Assistant Sub-Inspector (Stenographer)</option>										
										   
										   <option value="1">Head Constable (Electrician)</option>
										   <option value="2">Head Constable (Mechanic) Male</option>
										   <option value="3">Head Constable (Steward)</option>
										   <option value="4">Head Constable (Veterinary)</option>
										   <option value="5">Head Constable (Communication)</option> 
										 
										   <option value="1">Constable (Carpenter)</option>
										   <option value="2">Constable (Blacksmith)</option>
										   <option value="3">Constable (Driver) Male</option>
										   <option value="4">Constable (Tailor)</option>
										   <option value="5">Constable (Gardner)</option>
										   <option value="6">Constable (Cobbler)</option>
										   <option value="7">Constable (Veterinary)</option>
										   <option value="8">Constable (Painter)</option>
										   <option value="9">Constable (Washerman) Male</option>
										   <option value="10">Constable (Barber) Male</option> 
										   <option value="11">Constable (Safaiwala) Male</option>
										   <option value="12">Constable (Cook)</option>
										   <option value="13">Constable (Water Carrier) Male</option> -->
										 </select></div>
                                </div>
                                							
                                
                                <div class="row">
                                 <input type="hidden" name="requestFrom" value="ForgotPassword"/>
                                    <div class="col-md-2"></div>
                                    <div class="col-md-3">Mobile Number</div>
                                    <div class="col-md-5"><input type="text"  maxlength="10" autocomplete="off" oncut="return false;" oncopy="return false;" onpaste="return false;" id="mobilenumber" name="mobilenumber" 
                                    onKeyPress="return numbersonly_mobile(this,event)" /></div>
                                </div>
                                 <div class="row">
                                  <div class="col-md-2"></div>
                                    <div class="col-md-3">Date of Birth</div>
                                    <div class="col-md-5"><input type="text"  name="dob" id="recordClientDob" readonly class="date1"/></div>
                                </div>
                                 <div class="row">
                                  <div class="col-md-2"></div>
                                    <div class="col-md-3">Enter Below Text</div>
                                    <div class="col-md-5"><input type="text" name="answer" maxlength="6" autocomplete="off" oncut="return false;" oncopy="return false;" onpaste="return false;"/></div>
                                </div>
                                 <div class="row">
                                    <div class="col-md-5"></div>
                                    <div class="col-md-3">
                                        <img alt="" id="captcha" src="simpleCaptcha.png" width="150" />
                                    </div>
                                    <div class="col-md-4" style="text-align:center;">
                                     Letters are not case sensitive
                                     </div>
                                   </div>  
                                <%String message=(String)request.getAttribute("message");
                                String success_message=(String)request.getAttribute("success_message");
                                if(message!=null && !"".equalsIgnoreCase(message)){ %>
                                 <div class="row">
                                 <div class="col-md-12 colorText" style="text-align:center;">
                                   <%=message %>
                                     </div>
                                  </div>   
                                <%} else  if(success_message!=null && !"".equalsIgnoreCase(success_message)){ %>
                                <div class="row">
                                <div class="col-md-12" style="color:green; text-align:center;">
                                  <%=success_message %>
                                    </div>
                                 </div>   
                               <%}  %>
							<div class="text-center">
								<button type="submit" class="btn blue_btn btn-lg registerBtn" onclick="return validation()">  SUBMIT </button>
							</div>
							 </form>
                        </div>
                       
                    </div>
                </div>
               
            </div>
        </div>
      </div>  
    </div>
  </div>
  
  
 
  
  
  
</div>

  
  



   <jsp:include page="footer.jsp" flush="true" />                                            
</body>
</html>

