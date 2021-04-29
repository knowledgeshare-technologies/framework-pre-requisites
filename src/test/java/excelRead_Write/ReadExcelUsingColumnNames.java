package excelRead_Write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUsingColumnNames {

	public static void main(String[] args) throws IOException 
	{
		File file=new File(System.getProperty("user.dir") + "\\TestData\\" + "Regression_TestData" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		
		// 1. Getting Number of Columns And Getting the Column Name ( Header Names ) 
		// 2. Printing all the values from the Column
		// 3. Storing Values in to Variables to pass to the Web Applications for testing.
		
		// 1. Getting Number of Columns
		
		//UnComment below Code
		// Getting Column Count and Printing Columns Nmaes ( to read the value using Column Names later )
		/*
		 * XSSFRow row=sheet.getRow(0);
		 * 
		 * // Getting the Column Count int Column_Count=row.getLastCellNum();
		 * System.out.println("Column Count is :  "+ Column_Count); XSSFCell cell=null;
		 * 
		 * // Getting Column Names for (int i=0;i<Column_Count;i++) {
		 * cell=row.getCell(i); String Column_Name=cell.getStringCellValue();
		 * System.out.println("Column Name is : " + Column_Name); }
		 */
		
		// UnComment below Code
		// Printing all Values from all rows and all Columns
		
		/*
		 * XSSFRow row=null; XSSFCell cell=null;
		 * 
		 * for(int i=0;i<=sheet.getLastRowNum();i++) //Navigate through the Row {
		 * row=sheet.getRow(i);
		 * 
		 * for(int j=0;j<row.getLastCellNum();j++) // Navigate through the Columns {
		 * cell=row.getCell(j); String my_cell_value=cell.getStringCellValue();
		 * System.out.println("My Cell value is : " + my_cell_value); } }
		 */
		
		// Storing Values in to Variables ( In this case, Usernames and Passwords )
		
		XSSFRow row=null;
		XSSFCell cell=null;
		String userName=null;
		String password=null;
		
		for (int i=1; i<=sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
			for ( int j=0;j<row.getLastCellNum();j++)
			{
				cell=row.getCell(j);
				
				if(j==0) // We can use Column Name as well, will see in upcoming sessions
				{
					userName=cell.getStringCellValue();
				}
				if(j==1) // We can use Column Name as well, will see in upcoming sessions
				{
					password=cell.getStringCellValue();
					
				}
				
			}
			System.out.println("User Name : " + userName + " ---- > " + "Password : "  + password);
			// We can pass this values in to web application for testing Test user Accounts.
		}
		
		
		
		
	}

}
