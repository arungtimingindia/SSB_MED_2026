package XMLTransform;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Pradeep Yarlagadda, 
 * Copyright (c) 2009, ThoughtGreen Technologies Pvt Ltd.
 * Created Date Aug 19, 2009
 */
public class XMLTransformer {
	private String xslFile=null;
	//private String outPut=null;
	/**
	 * This function takes the xml and xsl streamsource, transform it  and return the string 
	 * DoTransform
	 * XMLTransformer
	 * String
	 * @param Xml
	 * @param Xsl
	 * @return String
	 */
	private static String DoTransform(StreamSource Xml, StreamSource Xsl){
		java.lang.System.setProperty("javax.xml.transform.TransformerFactory",
				"net.sf.saxon.TransformerFactoryImpl");



		StreamResult outResult = new StreamResult();



		java.io.ByteArrayOutputStream outputXmlResult = new
				java.io.ByteArrayOutputStream();



		outResult.setOutputStream(outputXmlResult);



		TransformerFactory trans = TransformerFactory.newInstance();



		Transformer transformer=null;
		try
		{
			transformer = trans.newTransformer(Xsl);
		}
		catch (TransformerConfigurationException e1) 
		{
			//e1.printStackTrace();
		}

		//transformer.setParameter("dir", "output");
		try
		{
			transformer.transform(Xml, outResult);
		} 
		catch (TransformerException e) 
		{
			//e.printStackTrace();
		}

		return outputXmlResult.toString();


	}
	public String GetTransformedString(StringReader xmlObj, String format,String reportFileName,int session)throws Exception, TransformerException
	{

		java.text.SimpleDateFormat sf= new java.text.SimpleDateFormat();
		sf.applyPattern("dd-MM-yyyy_HH-mm-s");

		String reportExt=sf.format(new java.util.Date());
		String filename=null;
		String tempname=reportFileName;
		//reportFileName="sys/"+reportFileName;
		try
		{
			if(format.equals("pdf"))
			{
				reportFileName+="_fo";	
			}
			//xslFile= reportFileName+".xsl";
			xslFile= reportFileName;
			////System.out.println(xslFile);

		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		try
		{
			StreamSource inputXml_Source = new StreamSource(xmlObj);
			StreamSource inputXsl_Source = new StreamSource(new
					java.io.FileInputStream(xslFile));

			inputXsl_Source.setSystemId(xslFile);

			File f=null;

			//			f=new File(location+"\\\\"+reportFileName+"_"+reportExt+"."+format);
			f=new File(reportFileName+"."+format);

			try
			{
				if(!format.equals("pdf"))
				{
					BufferedWriter out = new BufferedWriter(new FileWriter(f));
					//out.write(DoTransform(inputXml_Source, inputXsl_Source).toString());
					//out.close();
					return DoTransform(inputXml_Source, inputXsl_Source).toString();
				}

			}
			catch (Exception e)
			{
				filename=null;
				//e.printStackTrace();
			}

		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}

		return filename;
	}
}


