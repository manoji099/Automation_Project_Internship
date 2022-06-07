package com.workpackages.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class custamizeReport {
	
	
	public static void updateResult(int SI,  String testCaseName,String response, String screen, File resultFile ) {
		try {
			String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
		

			if (!resultFile.exists()) {
				
				FileWriter fw = new FileWriter(resultFile.getAbsoluteFile(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("<html>" + "\n");
				bw.write("<head><title>" + "Test execution report" + "</title>" + "\n");
				bw.write("</head>" + "\n");
				bw.write("<body>");
				bw.write("<font face='Tahoma'size='2'>" + "\n");
				bw.write("<u><h1 align='center'>" + "Test execution report" + "</h1></u>" + "\n");
				bw.write("<u><h2 align='center'>" + "AstraZe-suppport Workpackages module" + "</h2></u>" + "\n");
				bw.flush();
				bw.close();
			}
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(resultFile, true));
			if (SI == 1) {

				bw1.write("<table align='center' border='0' width='70%' height='15'>");
				bw1.write("<tr><td width='70%' </td></tr>");
				bw1.write("<table align='center' border='1' width='70%' height='47'>");
				bw1.write("<tr>");
				bw1.write("<td colspan='1' align='center'><b><font color='#000000' face='Tahoma' size='2'>ScriptName :&nbsp;&nbsp;&nbsp;</font><font color='#0000FF'' face='Tahoma' size='2'>MainProject Test </font></b></td>");
				bw1.write("<td colspan='2' align='left'><b><font color='#000000' face='Tahoma' size='2'>Start Time :&nbsp;</font></b><font color='#0000FF'' face='Tahoma' size='1'>" + startDateTime + " </font></td>");
				bw1.write("</tr>");
				bw1.write("</tr>");
				bw1.write("<td  bgcolor='#FEE6EE' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");
				bw1.write("<td  bgcolor='#FEE6EE' align='left'><b><font color='#000000' face='Tahoma' size='2'>Detail</font></b></td>");
				bw1.write("<td  bgcolor='#FEE6EE' align='center'><b><font color='#000000' face='Tahoma' size='2'>Response </font></b></td>");
				bw1.write("<td  bgcolor='#FEE6EE' align='center'><b><font color='#000000' face='Tahoma' size='2'>ScreenShot </font></b></td>");
				
				bw1.write("</tr>");
			}
			  String direc = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\workpackages\\screenShot\\" + dateUtils.getTimeStamp() +".png'>";
			
			bw1.write("<tr>" + "\n");
			bw1.write("<td bgcolor='#FED8B1'align='Center'><font color='#000000' face='Tahoma' size='2'>" + SI + "</font></td>" + "\n");
			bw1.write("<td  bgcolor='#FED8B1' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>" + testCaseName + "</font></b></td>" + "\n");
			bw1.write("<td  bgcolor='#FED8B1' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>" + response + "</font></b></td>" + "\n");
			bw1.write("<td bgcolor='#FED8B1' align='left'>"+"<a href = ' "+ direc + screen + "</a>"+"</td>");
			bw1.write("</tr>" + "\n");
			bw1.write("</body>" + "\n");
			bw1.write("</html>");
			bw1.flush();
			bw1.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



}
