package com.workpacakges.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {

	
	public Vector readExcelFile() {
		//log.info("Entering Into Method readExcelFile");
		Vector cellVectorHolder = new Vector();
		try {File fs = new File("E:\\workspace\\INTQAE21QE007_Team1_WorkPackages\\src\\test\\resources\\com\\workpackages\\excel\\MAIN_PROJECT_TEAM1_DATA.xlsx");
			FileInputStream inputFile = new FileInputStream(fs);
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			XSSFSheet workSheet = workbook.getSheetAt(0);
			int lastColIndex = workSheet.getRow(0).getLastCellNum();
			Iterator rowIter = workSheet.rowIterator();
			while (rowIter.hasNext()) {
				XSSFRow row = (XSSFRow) rowIter.next();
				Vector cellStoreVector = new Vector();
				for (int cn = 0; cn < lastColIndex; cn++) {
					XSSFCell cell = row.getCell(cn);
					cellStoreVector.addElement(cell);
				}
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cellVectorHolder;
	}
	
}
