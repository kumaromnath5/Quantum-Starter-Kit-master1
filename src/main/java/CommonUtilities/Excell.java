package CommonUtilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Excell implements IAutoConst  {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	static String value;
	static FileInputStream fis;
	
	
	
	public static void main(String[] args) throws IOException {
////		 String value=getcelldata(0,3);
////		 System.out.println(value);
	
   String un = getcelldata(1, 0);
	String pw = getcelldata(2, 1);
	//String ppow = getcelldata(2, 2);		
	System.err.println(un);
	System.err.println(pw);
	//System.err.println(ppow);
	}
	// to get value from excel sheet to application
	public static  String getcelldata(int rownum ,int column) throws IOException{
		
		fis = new FileInputStream(XLPATH);
		
		 wb= new XSSFWorkbook(fis);
		 sheet = wb.getSheet(SheetTABname);
		row = sheet.getRow(rownum);
		 cell = row.getCell(column);
		return value = cell.getStringCellValue();
		
	}
	
	// to enter value to excel sheet
public String setcelldata(String text,int rownum ,int col) throws IOException{
		
		fis = new FileInputStream(XLPATH);
		
		 wb= new XSSFWorkbook(fis);
		 sheet = wb.getSheet(SheetTABname);
		row = sheet.getRow(rownum);
		 cell = row.getCell(col);
		cell.setCellValue(text);
		return value= cell.getStringCellValue();
	      


		
		
	}
}
