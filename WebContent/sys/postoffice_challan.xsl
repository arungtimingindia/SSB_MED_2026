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
	 width: 47.5%;
	 margin: 1%;
	 padding: 0% 1% 0% 0%;;
	 float: left;
	 border-right: 2px dotted #000;
}
#divChallanRight {
	 width: 47.5%;
	 margin: 1% 1% 1% 0%;
	 padding: 0px;
	 float: left;
}

.chalanTable {
	 width: 100%;
	 float: left;
 	border-top: 1px solid #000;
	border-bottom: 1px solid #000;
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
     <table class="chalanTable">
     <tr>
       <td colspan="2" align="center" style="font-size:11px;">PAY IN SLIP</td>
     </tr>
      <tr>
        <td colspan="2" align="center"><img src="images/indianpostlogo.jpg" border="0" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center" style="font-size: 13px;" >APPLICATION FEE PAYABLE AT ALL DESIGNATED POST OFFICES</td>
      </tr>
      <tr>
        <td align="center" style="font-size: 13px;" colspan="2"><b>Organization : Government of India, Ministry of Home Affairs (Sashastra Seema Bal)
         </b></td>
      </tr>
       <tr>
        <td align="center" style="font-size: 13px;" colspan="2"><b>Application Form for the post of <xsl:value-of select="//result//organizationName" /></b></td>
      </tr>
       <!-- <tr>
        <td align="center" style="font-size: 13px;" colspan="2"><b>E.N.NO : <xsl:value-of select="//result//notificationNo" /></b></td>
      </tr> -->
      <tr>
        <td colspan="2" style="border-bottom:1px solid #000; padding-bottom:2px;" align="center">
        <b> Transaction Id: <xsl:value-of select="//result//TransactionId" /> </b>
        </td>
      </tr>
      <tr>
        <td width="50%" style="font-size:16px;">Candidate Name</td>
        <td width="50%"  style="font-size:16px;"><xsl:value-of select="//result//Name" /></td>
      </tr>
      <tr>
        <td width="50%" style="font-size:16px;">Mobile No</td>
        <td width="50%"  style="font-size:16px;"><xsl:value-of select="//result//MOBILENO" /></td>
      </tr>
      <tr>
        <td width="50%" style="font-size:16px;">Date of Birth</td>
        <td width="50%"  style="font-size:16px;"><xsl:value-of select="//result//DOB" /></td>
      </tr>
       <tr>
        <td width="50%" style="font-size:16px;"><b>Reference Date</b></td>
        <td width="50%"  style="font-size:16px;"><b><xsl:value-of select="//result/ReferenceDate" /></b></td>
      </tr>
      
      <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="left" style="font-size:16px;">Exam fee</td>
            <td align="right" style="font-size:16px;">Rs. <xsl:value-of select="//result//FeeAmount" />.00/-</td>
          </tr>
          <tr>
            <td align="left" style="font-size:16px;">Postal Charges</td>
            <td align="right" style="font-size:16px;">Rs. 00.00/-</td>
          </tr>
          <tr>
            <td align="left"  style="border-bottom: none; font-size:16px;">Total</td>
            <td align="right" style="border-bottom: none; font-size:16px;">Rs. <xsl:value-of select="//result//FeeAmount" />.00/-</td>
          </tr>
        </table>
       </td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:16px;">Amount : Rs. <xsl:value-of select="//result//FeeAmount" />.00</td>
      </tr>
      <tr>
        <td style="font-size:16px;">Amount in words:</td>
        <td style="border-bottom: 1px solid #000; font-size:16px;">(Rupees One Hundred Only)</td>
      </tr>
      <tr>
        <td style="font-size:16px;">Name of the receiving branch</td>
        <td style="border-bottom: 1px solid #000;">&amp;nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:16px;"><span style="margin-top: 30px; width:100%; text-align:right; float:left;">Signature of the Candidate</span></td>
      </tr>
      <tr>
	        <td align="center" colspan="2" style="font-size:16px;"><b>Post Office may please accept this challan on or before <br/> <xsl:value-of select="//result/postenddate" />.</b></td>
      </tr>
      
    </table>
    </div>

  <div id="divChallanRight">
     <table class="chalanTable">
     <tr>
       <td colspan="2" align="center"  style="font-size:11px;">PAY IN SLIP</td>
     </tr>
      <tr>
        <td colspan="2" align="center"><img src="images/indianpostlogo.jpg" border="0" /></td>
      </tr>
       <tr>
        <td colspan="2" align="center" style="font-size: 13px;" >APPLICATION FEE PAYABLE AT ALL DESIGNATED POST OFFICES</td>
      </tr>
     <tr>
        <td align="center" style="font-size: 13px;" colspan="2"><b>Organization : Government of India, Ministry of Home Affairs (Sashastra Seema Bal)
         </b></td>
      </tr>
       <tr>
        <td align="center" style="font-size: 13px;" colspan="2"><b>Application Form for the post of <xsl:value-of select="//result//organizationName" /></b></td>
      </tr>
      <!--  <tr>
        <td align="center" style="font-size: 13px;" colspan="2"><b>E.N.NO : <xsl:value-of select="//result//notificationNo" /></b></td>
      </tr> -->
      <tr>
        <td colspan="2" style="border-bottom:1px solid #000; padding-bottom:2px;" align="center">
        <b> Transaction Id: <xsl:value-of select="//result//TransactionId" /> </b>
        </td>
      </tr>
      <tr>
        <td width="50%" style="font-size:16px;">Candidate Name</td>
        <td width="50%" style="font-size:16px;"><xsl:value-of select="//result//Name" /></td>
      </tr>
      <tr>
        <td width="50%" style="font-size:16px;">Mobile No</td>
        <td width="50%" style="font-size:16px;"><xsl:value-of select="//result//MOBILENO" /></td>
      </tr>
      <tr>
        <td width="50%" style="font-size:16px;">Date of Birth</td>
        <td width="50%" style="font-size:16px;"><xsl:value-of select="//result//DOB" /></td>
      </tr>
       <tr>
        <td width="50%" style="font-size:16px;"><b>Reference Date</b></td>
        <td width="50%" style="font-size:16px;"><b><xsl:value-of select="//result/ReferenceDate" /></b></td>
      </tr>
      <tr>
       <td colspan="2">
        <table class="innertable">
          <tr>
            <td align="left" style="font-size:16px;">Exam fee</td>
            <td align="right" style="font-size:16px;">Rs. <xsl:value-of select="//result//FeeAmount" />.00/-</td>
          </tr>
          <tr>
            <td align="left" style="font-size:16px;">Postal Charges</td>
            <td align="right" style="font-size:16px;">Rs. 00.00/-</td>
          </tr>
          <tr>
            <td align="left"  style="border-bottom: none; font-size:16px;">Total</td>
            <td align="right" style="border-bottom: none; font-size:16px;">Rs. <xsl:value-of select="//result//FeeAmount" />.00/-</td>
          </tr>
        </table>
       </td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:16px;">Amount : Rs. <xsl:value-of select="//result//FeeAmount" />.00</td>
      </tr>
      <tr>
        <td style="font-size:16px;">Amount in words:</td>
        <td style="border-bottom: 1px solid #000; font-size:16px;">(Rupees One Hundred Only)</td>
      </tr>
      <tr>
        <td style="font-size:16px;">Name of the receiving branch</td>
        <td style="border-bottom: 1px solid #000;">&amp;nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:16px;"><span style="margin-top: 30px; width:100%; text-align:right; float:left;">Signature of the Candidate</span></td>
      </tr>
      <tr>
	        <td align="center" colspan="2" style="font-size:16px;"><b>Post Office may please accept this challan on or before <br/> <xsl:value-of select="//result/postenddate" />.</b></td>
      </tr>
      
    </table>
    </div>
</div>
</body>
</html>
</xsl:template>
</xsl:transform>
