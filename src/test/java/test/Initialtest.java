package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initialtest {

	public static <workbook> void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\sudharshan\\Music\\edfgbkj\\Maven\\excel\\maven.xlsx");

		FileInputStream file = new FileInputStream(f);

		Workbook workbook = new XSSFWorkbook(file);

		Sheet sheet = workbook.getSheet("sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		 System.out.println(rowcount);

		for (int i = 0; i < rowcount; i++) {
		Row row = sheet.getRow(i);
			int cellcount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellcount; j++) {
				Cell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
				org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();
				System.out.println(cellType);
				
				switch (cellType) {
				case STRING:
					
					break;

				default:
					break;
				}
			}}
	
		
		
			
          
	 
	   
	   
	   
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		Cell cell2 = row.getCell(1);
//		String id = cell.getStringCellValue();
//		String pass = cell2.getStringCellValue();
//		System.out.println(id);
//		System.out.println(pass);
//		System.out.println();
//		
//		Row row2 = sheet.getRow(1);
//		Cell cell3 = row2.getCell(0);
//		Cell cell4 = row2.getCell(1);
//		String id1 = cell3.getStringCellValue();
//		String pass1 = cell4.getStringCellValue();
//		System.out.println(id1);
//		System.out.println(pass1);
//		System.out.println();
//		
//		Row row3 = sheet.getRow(2);
//		Cell cell5 = row3.getCell(0);
//		Cell cell6 = row3.getCell(1);
//		String id2 = cell5.getStringCellValue();
//		String pass2 = cell6.getStringCellValue();
//		System.out.println(id2);
//		System.out.println(pass2);
//		System.out.println();
//		Row row4 = sheet.getRow(3);
//		Cell cell7 = row4.getCell(0);
//		Cell cell8 = row4.getCell(1);
//		String id3 = cell7.getStringCellValue();
//		String pass3 = cell8.getStringCellValue();
//		System.out.println(id3);
//		System.out.println(pass3);
//		System.out.println();
			}

}
