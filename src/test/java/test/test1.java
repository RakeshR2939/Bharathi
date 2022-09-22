package test ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1  extends test.Initialtest{
public static void main(String[] args) throws Exception {
	File f = new File("C:\\Users\\sudharshan\\Music\\edfgbkj\\Maven\\excel\\maven.xlsx");

	FileInputStream file = new FileInputStream(f);
	Workbook workbook = new XSSFWorkbook(file);
	Sheet sheet = workbook.getSheet("sheet1");
	Row row = sheet.getRow(0);
	Cell createCell = row.createCell(4);
	createCell.setCellValue("Apple");
	FileOutputStream o= new FileOutputStream(f);
	workbook.write(o);
	System.out.println("done");
	
	Row createRow = sheet.createRow(4);
	Cell createCell2 = createRow.createCell(0);
	createCell2.setCellValue("November");
    workbook.write(o);
    Sheet createSheet = workbook.createSheet();
        
}
}
