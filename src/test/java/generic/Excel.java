package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel implements Auto_const{

	public static String ReadData(String sheet, int row, int cell) 
	{
		String val="";
		try
		{
			FileInputStream fis=new FileInputStream(Excel_path);
			Workbook wb=WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
			val=c.getStringCellValue();
		}
		catch(Exception e)
		{
			Reporter.log("failed to read data", true);
			
		}
		return val;
	}
	public static void writeData(String sheet, int row, int cell, String val) 
	{
		
		try
		{
			FileInputStream fis=new FileInputStream(Excel_path);
			Workbook wb=WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).createCell(cell);
			c.setCellValue(val);
			FileOutputStream fout=new FileOutputStream(Excel_path);
			wb.write(fout);
			
		}
		catch(Exception e)
		{
			Reporter.log("failed to read data", true);;
			
		}
	
	}


}
