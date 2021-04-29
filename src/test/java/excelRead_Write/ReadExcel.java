package excelRead_Write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException 
	{
		File file=new File(System.getProperty("user.dir") + "\\TestData\\" + "Regression_TestData" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		XSSFRow row=sheet.getRow(2);
		XSSFCell cell=row.getCell(0); // Get 1st username 
		
		String username=cell.getStringCellValue();
		System.out.println("User Name is : " + username );
		
		cell=row.getCell(1);
		
		String password=cell.getStringCellValue();
		System.out.println("Password  is : " + password );
		
		// driver.findElemnt(by.xpath("ajsdkjas")).sendKeys(username));
		
		
	}

}
