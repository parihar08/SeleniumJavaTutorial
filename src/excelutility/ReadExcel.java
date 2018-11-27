package excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		String file = "Workbook1.xlsx";
		
		String sheetname = "Sheet1";
		
		File fo = new File(file); //create file object
		
		FileInputStream fis = new FileInputStream(fo);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis); //This class will load complete excel sheet(workbook)
		
		XSSFSheet sheet1 = wb.getSheetAt(0); //Loads sheet at index 0 --> Sheet1
		
		String row1 = sheet1.getRow(0).getCell(0).getStringCellValue(); //specify from which row and column we want to read the data and get the value of that cell
		
		System.out.println("Data from excel is: "+ row1);
		
		int rowCount = sheet1.getLastRowNum();
		
		System.out.println("Row Count is: "+rowCount);
		
		for(int i=0; i<=rowCount; i++){
			
			String rows = sheet1.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println("Test Data from row "+i+" is: "+rows);
		}
		
		wb.close();
	}

}
