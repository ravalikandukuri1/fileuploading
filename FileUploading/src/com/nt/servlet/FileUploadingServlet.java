package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

public class FileUploadingServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		MultipartFormDataRequest d=null;
	
		UploadBean bean=null;
		Hashtable ht=null;
		Enumeration upload=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
			//prepare special request object
			d=new MultipartFormDataRequest(req);
			//specify file uploading
			bean=new UploadBean();
			bean.setFolderstore("D:\\store");
			bean.setOverwrite(false);
			//compleate file uploading
			bean.store(d);
			//display the names of upload files
			pw.println("<h1>the uploaded files are</h1>");
			ht=d.getFiles();
			upload=ht.elements();
			while(upload.hasMoreElements()) {
				UploadFile file=(UploadFile)upload.nextElement()	;
				pw.println("<br>"+file.getFileName()+""+file.getFileSize());
						}//while
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doPost(-,-)
		public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doPost(req,res);
		}
		

}//class
