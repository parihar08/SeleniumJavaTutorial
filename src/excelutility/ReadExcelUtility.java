package excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtility {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ReadExcelUtility(String path) {
		
		try{
					
			File fo = new File(path); //create file object
			FileInputStream fis = new FileInputStream(fo);
			wb = new XSSFWorkbook(fis); //This class will load complete excel sheet(workbook)
			}
		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
		
	public String getData(int sheetNumber,int row,int column){
		
		sheet1 = wb.getSheetAt(sheetNumber); //Loads sheet at index 0 --> Sheet1
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadExcelUtility excel = new ReadExcelUtility("Workbook1.xlsx");
		System.out.println("Data from the excel sheet: "+excel.getData(0, 0, 0));
}
	
}
