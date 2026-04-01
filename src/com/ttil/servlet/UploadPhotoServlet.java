package com.ttil.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.owasp.esapi.ESAPI;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ttil.bean.AppDataBean;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.dao.ApplicationFormDAO;

@MultipartConfig
public class UploadPhotoServlet extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;

	public void dopost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.service(req, res);
	}

	public void service(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ApplicationFormBean applicationFormBean = null;
		// PostsBean postBean=null;
		try {
			HttpSession session = request.getSession();
			if (session != null && session.isNew()) {
				// System.out.println("Session Time Out Page Called in session.isNew()");
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			} else {
				String requestFrom = ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("requestFrom1"));
				String transIds = request.getParameter("final_transaction_id");
				int final_transaction_id = 0;
				if (transIds != null)
					final_transaction_id = Integer.parseInt(transIds);
				if (requestFrom != null && "uploadPhotoPage".equalsIgnoreCase(requestFrom)
						&& final_transaction_id > 0) {
					applicationFormBean = (ApplicationFormBean) session.getAttribute("ApplicationFormBean");
					if (applicationFormBean != null && applicationFormBean.getTransactionid() == final_transaction_id) {
						// final_transaction_id
						request.setAttribute("final_transaction_id", final_transaction_id);
						rd = request.getRequestDispatcher("/pages/uploadPhotoForm.jsp");
						rd.forward(request, res);
					} else {
						rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
						rd.forward(request, res);
					}
				} else if (requestFrom != null && "uploadPhoto".equalsIgnoreCase(requestFrom)
						&& final_transaction_id > 0) {
					applicationFormBean = (ApplicationFormBean) session.getAttribute("ApplicationFormBean");
					// postBean=(PostsBean)session.getAttribute("postDetails");
					if (applicationFormBean != null && applicationFormBean.getTransactionid() == final_transaction_id) {
						ApplicationFormDAO applicationFormDAO = new ApplicationFormDAO();
						int responseId = applicationFormDAO.checkDuplicateRecord(applicationFormBean);
						if (responseId >= 0) {

							String path = this.getServletContext().getRealPath("path.properties");
							String imagesPath = "";
							Properties props = new Properties();
							try {
								props.load(new FileInputStream(path));
								imagesPath = props.getProperty("imagesPath");
							} catch (Exception e) {
								e.printStackTrace();
								// System.out.println("Unalble to load Path connection property file");
								imagesPath = "/opt/apache-tomcat-7.0.42/webapps/ssb_uploads/candidateImages/MEDICAL";
								// imagesPath="D:\\HSSC_UPLOADED_FILES\\";
							}

							List<String> messageOb = new ArrayList<String>();
							int transaction_id = applicationFormBean.getTransactionid();
							request.setAttribute("final_transaction_id", final_transaction_id);
							/** Photo Uploads **/
							// String imagesPath=request.getServletContext().getRealPath("candidateImages");
							Part photoFilePart = request.getPart("photofileData");
							Part sigFilePart = request.getPart("sigfileData");

							String photo_type = photoFilePart.getContentType();
							String sign_type = sigFilePart.getContentType();

							if (photo_type != null && !"application/octet-stream".equalsIgnoreCase(photo_type)) {

							} else {
								messageOb.add("Please Upload Photograph");
							}

							if (sign_type != null && !"application/octet-stream".equalsIgnoreCase(sign_type)) {

							} else {
								messageOb.add("Please Upload Signature");
							}

							String photoFileName = transaction_id + "_photo.jpg";
							String sigFileName = transaction_id + "_sig.jpg";
							applicationFormBean.setPhotoFileName(photoFileName);
							applicationFormBean.setSigFileName(sigFileName);

							this.savePhoto(imagesPath, photoFileName, photoFilePart);
							this.savePhoto(imagesPath, sigFileName, sigFilePart);

							File outputFilePath = new File((new StringBuilder(String.valueOf(imagesPath)))
									.append(File.separator).append(photoFileName).toString());
							File outputFilePath1 = new File((new StringBuilder(String.valueOf(imagesPath)))
									.append(File.separator).append(sigFileName).toString());

							/*
							 * AmazonS3 s3 = new AmazonS3Client(new
							 * ClasspathPropertiesFileCredentialsProvider());
							 * this.savePhotoS3Bucket(imagesPath, photoFileName, s3,
							 * "onlinedatafiles","ssb_advt_comb_CT_338_2018/photos");
							 * this.savePhotoS3Bucket(imagesPath, sigFileName, s3,
							 * "onlinedatafiles","ssb_advt_comb_CT_338_2018/signature");
							 */
							if (outputFilePath.exists()) {
								long bytes = outputFilePath.length();
								long kilobytes = (bytes / 1024);
								if (kilobytes < 20) {
									messageOb.add("Photo Should be atleast minimum 20 kb,  Upload Bigger size again");
								}
							} else {
								messageOb.add("Please Upload Photo");
							}

							if (outputFilePath1.exists()) {
								long bytes = outputFilePath1.length();
								long kilobytes = (bytes / 1024);
								if (kilobytes < 10) {
									messageOb.add(
											"Signature Should be atleast minimum 10 kb,  Upload Bigger size again");
								}
							} else {
								messageOb.add("Please Upload Signature");
							}

							// LogsGeneration.generateOTPactivatedLog("OTP",
							// applicationFormBean.getMobileNumber(),enteredOtp,request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId());
							if (messageOb != null && messageOb.size() > 0) {
								request.setAttribute("message",
										"Your Photo & Signature Not uploaded, please try again");
								request.setAttribute("messageOb", messageOb);
								rd = request.getRequestDispatcher("/pages/uploadPhotoForm.jsp");
								rd.forward(request, res);
							} else {
								String message = applicationFormDAO.updatePhotoPath(applicationFormBean,
										request.getRemoteAddr());
								// System.out.println("final_transaction_id="+final_transaction_id);
								if (message != null && "Success".equalsIgnoreCase(message)) {
									// request.setAttribute("postDetails", postBean);
									request.setAttribute("ApplicationFormBean", applicationFormBean);
									session.removeAttribute("ApplicationFormBean");
									session.removeAttribute("postDetails");
									session.removeAttribute("requestFromSession");

									AppDataBean appDataBean = new AppDataBean();
									appDataBean.setTransactionid(applicationFormBean.getTransactionid());
									appDataBean.setFee_amount(applicationFormBean.getFee_amount());
									session.setAttribute("AppDataBean", appDataBean);

									// session.invalidate();
									// LogsGeneration.generateFormSuccessLog(applicationFormBean.getTransactionid(),
									// applicationFormBean.getMobileNumber(),request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId());
									rd = request.getRequestDispatcher("/pages/transaction.jsp");
									rd.forward(request, res);

								} else if (message != null && "It seems Database Server is busy , please try again."
										.equalsIgnoreCase(message)) {
									request.setAttribute("message",
											"It seems Database Server is busy , please try again.");
									rd = request.getRequestDispatcher("/pages/uploadPhotoForm.jsp");
									rd.forward(request, res);
								} else {
									request.setAttribute("message", "Application Details not saved, please try again");
									rd = request.getRequestDispatcher("/pages/uploadPhotoForm.jsp");
									rd.forward(request, res);
								}
							}
						} else {
							request.setAttribute("message",
									"Your details (Name, Fathername, Mothername,DOB or mobilenumber or emailaddress) already submitted for this Advertisement, you can not submit again");
							rd = request.getRequestDispatcher("/pages/uploadPhotoForm.jsp");
							rd.forward(request, res);
						}

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
			 * LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationAfterSave",
			 * exceptionAsString, applicationFormBean.getMobileNumber(),
			 * request.getRemoteAddr(),request.getHeader("User-Agent"));
			 * else
			 * LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationAfterSave",
			 * exceptionAsString, null,
			 * request.getRemoteAddr(),request.getHeader("User-Agent"));
			 * throw new UserDefineException("ApplicationAfterSave", exceptionAsString);
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

	public void savePhotoS3Bucket(String imagesPath, String imageName, AmazonS3 amazonS3, String bucketName,
			String folderName) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		PutObjectRequest putObj = null;
		try {
			File outputFilePath = new File(imagesPath + File.separator + imageName);
			// System.out.println(outputFilePath.getAbsolutePath());
			// System.out.println(bucketName+"/"+folderName+"/"+imageName);
			putObj = new PutObjectRequest(bucketName, folderName + "/" + imageName, outputFilePath);
			putObj.setCannedAcl(CannedAccessControlList.PublicRead);
			amazonS3.putObject(putObj);

		} catch (Exception e) {
			e.printStackTrace();
			// responseMessage = "Image Upload Failed!!";
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogs("S3 Bucket
			// Catch-"+bucketName,exceptionAsString, null,transactionid, ipaddress, null);

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
