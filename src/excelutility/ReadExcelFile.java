package excelutility;

public class ReadExcelFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadExcelUtility excel = new ReadExcelUtility("Workbook1.xlsx");
		System.out.println("Data from the excel sheet: "+excel.getData(0, 0, 0));

	}

}
