<xsl:transform
  xmlns:a="http://www.wrox.com/5067/tour" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:xs="http://www.w3.org/2001/XMLSchema" 
  xmlns:fn="http://www.w3.org/2005/xpath-functions" 
  xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes" 
  xmlns:saxon="http://icl.com/saxon" 
  version="2.0"
  exclude-result-prefixes="xs fn a xdt"
  extension-element-prefixes="saxon">
  
  <xsl:template match="/">
  <html>
		<head>
<style type="text/css">
#divChallan {
	width: 100%;
	float: left;
	margin: 0px;
	padding: 0px;
}
#divChallanLeft {
	 width: 31%;
	 margin: 0.5%;
	border-right: 2px dotted #000;
	  padding: 0% 0.8% 0% 0%;
	  
	 float: left;
	
}
#divChallanCenter {
	 width: 31%;
	 margin: 0.5%;
	<!--  padding: 0% 1% 0% 0%;; -->
	  border-right: 2px dotted #000;
	  padding: 0% 0.8% 0% 0%;
	 float: left;
	
}
#divChallanRight {
	 width: 31%;
	 <!-- margin: 1% 1% 1% 0%; -->
	 margin: 0.5%;
	 padding: 0%;
	 float: left;
}
.chalanTable {
	 width: 100%;
	 float: left;
 	border-top: 1px solid #000;
	border-right: 1px solid #000;
	border-left: 1px solid #000;
	 margin: 0px;
	 padding: 0px;
}
.innertable {
	 width: 100%;
	 border: 1px solid #000;
	 float: left;
}
.innertable tr td{
	border-bottom: 1px solid #000;
	border-right: 1px solid #000;
}
.innertable tr td:last-child {
	border-right: none;
}
.detailsTable {
	width: 100%;
	float: left;
	border-bottom: 1px solid #000;
	border-right: 1px solid #000;
	border-left: 1px solid #000;
}
</style>
<style>

ul {
    margin-top: 0px;
    padding: 0px;
    font-size: 13px;
}

ul li {
    margin-left: 17px;
}
</style>
<style type="text/css" media="print">
  @page { size: landscape;   margin: 0px;  }
</style>
<link rel="shortcut icon" href="images/favicon.jpg" />

<script type="text/javascript">

function printpage()
{
window.print();
}
</script>
</head>

<body  onload="printpage()">
<div id="divChallan">
  <div id="divChallanLeft">
     <table class="chalanTable" style="border-bottom: 2px solid #000;">
     <tr>
        <td colspan="2" align="center" style="font-size: 11px;"> Convener (SSB) Copy</td>
      </tr>
      <tr>
        <td align="left"><img src="images/ssb_logo_challan.png" border="0" />  </td>
         <td align="right"> <img src="images/sbi_logo.jpg" border="0" /> </td>
      </tr> 
      <!-- <tr>
        <td colspan="2" align="center"><img src="images/ssb_logo_challan.png" border="0" /><img src="images/sbi_logo.jpg" border="0" /> </td>
      </tr> -->
       <!-- <tr>
        <td colspan="2" align="center"><img src="images/ssb_logo_challan.png" border="0" /> </td>
      </tr> -->
      <tr>
        <td colspan="2" align="center" style="font-size:14px;">  Application Form for the post of <xsl:value-of select="//result//postName" /></td>
      </tr>
    </table>
    <table class="detailsTable">
      <tr>
        <td width="40%">Registration Id:</td>
        <td width="60%"><xsl:value-of select="//result//TransactionId" /></td>
      </tr>
      <tr>
        <td>Candidate Name:</td>
        <td><xsl:value-of select="//result//Name" /></td>
      </tr>
      <tr>
        <td>DOB:</td>
        <td><xsl:value-of select="//result//DOB" /> </td>
      </tr>
       <tr>
        <td>Reference Date:</td>
        <td><xsl:value-of select="//result/ReferenceDate" /></td>
      </tr>
       <tr>
        <td>Mobile No:</td>
        <td><xsl:value-of select="//result/mobileNo" /></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:14px;"><b>CBS SCREEN NUMBER: 8888</b></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:14px;"><b>FEE TYPE: 241</b></td>
      </tr>
      <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="center"><b>Head</b></td>
            <td align="center"><b>Amount</b></td>
            <td align="center"><b>Credit To</b></td>
          </tr>
          <tr>
            <td align="center">Application Fee</td>
            <td align="center"><xsl:value-of select="//result//FeeAmount" /></td>
            <td align="center">3755934400</td>
          </tr>
          <tr>
            <td align="center">Bank Charges</td>
            <td align="center">20</td>
            <td align="center"></td>
          </tr>
          <tr>
            <td align="center" style="border-bottom: none"><b>Total</b></td>
            <td align="center" style="border-bottom: none"><b><xsl:value-of select="//result//FeeAmount + 20"/></b></td>
            <td align="center" style="border-bottom: none"></td>
          </tr>
        </table>
        <table width="100%">
         <tr>
            <td align="center" width="100%" style="font-size:13px;"><b>Amount in Words :One Hundred and Twenty rupees only</b></td>
          </tr>
        </table>
       </td>
      </tr>
      <tr>
        <td colspan="2" align="right"><span style="margin-top: 18px; float:left; text-align: right; width:100%;"> <b>Signature of the Candidate</b></span></td>
      </tr>
     <tr>
        <td colspan="2" align="center"><b>For Receiving Bank Use only</b></td>
      </tr>
     
     <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="center" colspan="2"><b>Branch</b></td>
            <td align="center" style="border-bottom: none"><b>Journal Number</b></td>
          </tr>
          <tr>
            <td align="center" width="30%"><b>Name</b></td>
            <td align="center" width="30%"><b>Code</b></td>
            <td align="center" width="40%"></td>
          </tr>
          <tr>
            <td align="center" style="height:30px; border-bottom: none;"></td>
            <td align="center" style="height:30px; border-bottom: none;"> </td>
            <td align="center" style="height:30px; border-bottom: none;"></td>
          </tr>
         
        </table>
      
       </td>
      </tr>
       <tr>
        <td colspan="2" align="right"><span style="margin-top: 28px; float:left; text-align: right; width:100%;"> <b>Authorized Signatory</b></span></td>
      </tr>
      
    
      <tr>
        <td colspan="2">
        <table width="100%">
         <tr>
            <td align="left" colspan="2"><span style="margin-top: 1px; float:left; font-weight:bold;  font-size:14px;">SEAL :</span></td>
          </tr>
          <tr>
            <td align="left" colspan="2"><span style="float:left; font-weight:bold;  font-size:14px;">DATE :</span></td>
          </tr>
        </table>
        </td>
      </tr>
       <tr>
        <td colspan="2" align="left" style="padding-top:4px; font-weight:bold;">Note: 
        <ul>
        <li> Challan can be submitted any SBI Branch. </li>
        <li> Challan copy furnished at the time of verification. </li>
        <!-- <li><xsl:value-of select="//result/expiry_message" />.</li> -->
        <li>Bank may please accept this challan on or before <xsl:value-of select="//result/postenddate" />.</li>
        </ul>
       
         </td>
      </tr>
    </table>
    </div>
    
     <div id="divChallanCenter">
     <table class="chalanTable" style="border-bottom: 2px solid #000;">
      <tr>
        <td colspan="2" align="center" style="font-size: 11px;">Candidate Copy</td>
      </tr>
      <tr>
        <td align="left"><img src="images/ssb_logo_challan.png" border="0" />  </td>
         <td align="right"> <img src="images/sbi_logo.jpg" border="0" /> </td>
      </tr> 
     <!-- <tr>
        <td colspan="2" align="center"><img src="images/ssb_logo_challan.png" border="0" /><img src="images/sbi_logo.jpg" border="0" /> </td>
      </tr> -->
      <!--  <tr>
        <td colspan="2" align="center"><img src="images/ssb_logo_challan.png" border="0" /> </td>
      </tr> -->
       <tr>
        <td colspan="2" align="center"  style="font-size:14px;">  Application Form for the post of <xsl:value-of select="//result//postName" /></td>
      </tr>
    </table>
    <table class="detailsTable">
      <tr>
        <td width="40%">Registration Id:</td>
        <td width="60%"><xsl:value-of select="//result//TransactionId" /></td>
      </tr>
      <tr>
        <td>Candidate Name:</td>
        <td><xsl:value-of select="//result//Name" /></td>
      </tr>
      <tr>
        <td>DOB:</td>
        <td><xsl:value-of select="//result//DOB" /> </td>
      </tr>
       <tr>
        <td>Reference Date:</td>
        <td><xsl:value-of select="//result/ReferenceDate" /></td>
      </tr>
       <tr>
        <td>Mobile No:</td>
        <td><xsl:value-of select="//result/mobileNo" /></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:15px;"><b>CBS SCREEN NUMBER: 8888</b></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:15px;"><b>FEE TYPE: 241</b></td>
      </tr>
      <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="center"><b>Head</b></td>
            <td align="center"><b>Amount</b></td>
            <td align="center"><b>Credit To</b></td>
          </tr>
          <tr>
            <td align="center">Application Fee</td>
            <td align="center"><xsl:value-of select="//result//FeeAmount" /></td>
            <td align="center">3755934400</td>
          </tr>
          <tr>
            <td align="center">Bank Charges</td>
            <td align="center">20</td>
            <td align="center"></td>
          </tr>
          <tr>
            <td align="center" style="border-bottom: none"><b>Total</b></td>
            <td align="center" style="border-bottom: none"><b><xsl:value-of select="//result//FeeAmount + 20"/></b></td>
            <td align="center" style="border-bottom: none"></td>
          </tr>
        </table>
        <table width="100%">
         <tr>
            <td align="center" width="100%" style="font-size:13px;"><b>Amount in Words : One Hundred and Twenty rupees only</b></td>
          </tr>
        </table>
       </td>
      </tr>
       <tr>
        <td colspan="2" align="right"><span style="margin-top: 18px; float:left; text-align: right; width:100%;"> <b>Signature of the Candidate</b></span></td>
      </tr>
     <tr>
        <td colspan="2" align="center"><b>For Receiving Bank Use only</b></td>
      </tr>
     
     <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="center" colspan="2"><b>Branch</b></td>
            <td align="center" style="border-bottom: none"><b>Journal Number</b></td>
          </tr>
          <tr>
            <td align="center" width="30%"><b>Name</b></td>
            <td align="center" width="30%"><b>Code</b></td>
            <td align="center" width="40%"></td>
          </tr>
          <tr>
            <td align="center" style="height:30px; border-bottom: none;"></td>
            <td align="center" style="height:30px; border-bottom: none;"> </td>
            <td align="center" style="height:30px; border-bottom: none;"></td>
          </tr>
         
        </table>
      
       </td>
      </tr>
       <tr>
        <td colspan="2" align="right"><span style="margin-top: 28px; float:left; text-align: right; width:100%;"> <b>Authorized Signatory</b></span></td>
      </tr>
      
    
      <tr>
        <td colspan="2">
        <table width="100%">
         <tr>
            <td align="left" colspan="2"><span style="margin-top: 1px; float:left; font-weight:bold; font-size:14px;">SEAL :</span></td>
          </tr>
          <tr>
            <td align="left" colspan="2"><span style="float:left; font-weight:bold;  font-size:14px;">DATE :</span></td>
          </tr>
        </table>
        </td>
      </tr>
       <tr>
        <td colspan="2" align="left" style="padding-top:4px; font-weight:bold;">Note: 
        <ul>
        <li> Challan can be submitted any SBI Branch. </li>
        <li> Challan copy furnished at the time of verification. </li>
        <!-- <li><xsl:value-of select="//result/expiry_message" />.</li> -->
        <li>Bank may please accept this challan on or before <xsl:value-of select="//result/postenddate" />.</li>
        </ul>
       
         </td>
      </tr>
    </table>
    </div>
    
  <div id="divChallanRight">
     <table class="chalanTable" style="border-bottom: 2px solid #000;">
     <tr>
        <td colspan="2" align="center" style="font-size: 11px;">Bank Copy</td>
      </tr>
      <tr>
        <td align="left"><img src="images/ssb_logo_challan.png" border="0" />  </td>
         <td align="right"> <img src="images/sbi_logo.jpg" border="0" /> </td>
      </tr> 
    <!--   <tr>
        <td colspan="2" align="center"><img src="images/ssb_logo_challan.png" border="0" /><img src="images/sbi_logo.jpg" border="0" /> </td>
      </tr> -->
      <!--  <tr>
        <td colspan="2" align="center"><img src="images/ssb_logo_challan.png" border="0" /> </td>
      </tr> -->
      <tr>
        <td colspan="2" align="center"  style="font-size:14px;">  Application Form for the post of <xsl:value-of select="//result//postName" /></td>
      </tr>
    </table>
    <table class="detailsTable">
      <tr>
        <td width="40%">Registration Id:</td>
        <td width="60%"><xsl:value-of select="//result//TransactionId" /></td>
      </tr>
      <tr>
        <td>Candidate Name:</td>
        <td><xsl:value-of select="//result//Name" /></td>
      </tr>
      <tr>
        <td>DOB:</td>
        <td><xsl:value-of select="//result//DOB" /> </td>
      </tr>
       <tr>
        <td>Reference Date:</td>
        <td><xsl:value-of select="//result/ReferenceDate" /></td>
      </tr>
       <tr>
        <td>Mobile No:</td>
        <td><xsl:value-of select="//result/mobileNo" /></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size: 15px;"><b>CBS SCREEN NUMBER: 8888</b></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size: 15px;"><b>FEE TYPE: 241</b></td>
      </tr>
      <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="center"><b>Head</b></td>
            <td align="center"><b>Amount</b></td>
            <td align="center"><b>Credit To</b></td>
          </tr>
          <tr>
            <td align="center">Application Fee</td>
            <td align="center"><xsl:value-of select="//result//FeeAmount" /></td>
            <td align="center">3755934400</td>
          </tr>
          <tr>
            <td align="center">Bank Charges</td>
            <td align="center">20</td>
            <td align="center"></td>
          </tr>
          <tr>
            <td align="center" style="border-bottom: none"><b>Total</b></td>
            <td align="center" style="border-bottom: none"><b><xsl:value-of select="//result//FeeAmount + 20"/></b></td>
            <td align="center" style="border-bottom: none"></td>
          </tr>
        </table>
        <table width="100%">
         <tr>
            <td align="center" width="100%" style="font-size:13px;"><b>Amount in Words : One Hundred and Twenty rupees only</b></td>
          </tr>
        </table>
       </td>
      </tr>
      <tr>
        <td colspan="2" align="right"><span style="margin-top: 18px; float:left; text-align: right; width:100%;"> <b>Signature of the Candidate</b></span></td>
      </tr>
     <tr>
        <td colspan="2" align="center"><b>For Receiving Bank Use only</b></td>
      </tr>
     
     <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="center" colspan="2"><b>Branch</b></td>
            <td align="center" style="border-bottom: none"><b>Journal Number</b></td>
          </tr>
          <tr>
            <td align="center" width="30%"><b>Name</b></td>
            <td align="center" width="30%"><b>Code</b></td>
            <td align="center" width="40%"></td>
          </tr>
          <tr>
            <td align="center" style="height:30px; border-bottom: none;"></td>
            <td align="center" style="height:30px; border-bottom: none;"> </td>
            <td align="center" style="height:30px; border-bottom: none;"></td>
          </tr>
         
        </table>
      
       </td>
      </tr>
       <tr>
        <td colspan="2" align="right"><span style="margin-top: 28px; float:left; text-align: right; width:100%;"> <b>Authorized Signatory</b></span></td>
      </tr>
      
    
      <tr>
        <td colspan="2">
        <table width="100%">
         <tr>
            <td align="left" colspan="2"><span style="margin-top: 1px; float:left; font-weight:bold;  font-size:14px;">SEAL :</span></td>
          </tr>
          <tr>
            <td align="left" colspan="2"><span style="float:left; font-weight:bold;  font-size:14px;">DATE :</span></td>
          </tr>
        </table>
        </td>
      </tr>
       <tr>
        <td colspan="2" align="left" style="padding-top:4px; font-weight:bold;">Note: 
        <ul>
        <li> Challan can be submitted any SBI Branch. </li>
        <li> Challan copy furnished at the time of verification. </li>
        <!-- <li><xsl:value-of select="//result/expiry_message" />.</li> -->
        <li>Bank may please accept this challan on or before <xsl:value-of select="//result/postenddate" />.</li>
        </ul>
       
         </td>
      </tr>
      
      
    </table>
  </div>
</div>
</body>
</html>
 </xsl:template>
 
  </xsl:transform>
