package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Newexcelcreation {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\sudharshan\\Music\\edfgbkj\\Maven\\excel\\data.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.createSheet("FBDATE");
		FileOutputStream fileOutputStream = new FileOutputStream(f);

		System.out.println("done");
		String url = "https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sudharshan\\Music\\edfgbkj\\Selinium\\drive\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement crtnew = driver.findElement(By.linkText("Create New Account"));
		crtnew.click();
		Thread.sleep(3000);
		WebElement month = driver.findElement(By.id("month"));
		month.click();
		Select select = new Select(month);

		List<WebElement> all = select.getOptions();
		System.out.println(all.size());

		WebElement day = driver.findElement(By.id("day"));
		day.click();
		Select s = new Select(day);

		List<WebElement> c = s.getOptions();
		System.out.println(c.size());

		for (int i = 0; i < all.size(); i++) {
			WebElement webElement = all.get(i);
			String attribute = webElement.getAttribute("text");
			System.out.println(attribute);
			FileOutputStream o = new FileOutputStream(f);
			Row createRow = createSheet.createRow(i);
			Cell cell = createRow.createCell(0);
			cell.setCellValue(attribute);
			workbook.write(fileOutputStream);

			workbook.write(fileOutputStream);
		}

		for (int j = 0; j <  c.size(); j++) {
			if (j==12) {
				break;
			}
			WebElement web = c.get(j);
			String d = web.getAttribute("value");
			System.out.println(d);
			Row row = createSheet.getRow(j);
			Cell createCell = row.createCell(1);
			createCell.setCellValue(d);
			workbook.write(fileOutputStream);
		}
	/*	for (int j = 0; j < c.size(); j++) {
			WebElement web = c.get(j);
			String d = web.getAttribute("value");
			System.out.println(d);
			FileInputStream fileInputStream = new FileInputStream(f);
			Workbook workbook1 = new XSSFWorkbook(fileInputStream);
			Sheet createSheet1 = workbook1.getSheet("FBDATE");

			FileOutputStream p = new FileOutputStream(f);
			Row r = createSheet1.getRow(j);
			Cell m = r.createCell(1);
			m.setCellValue(d);
			FileOutputStream fileOutputStream = new FileOutputStream(f);
			workbook.write(fileOutputStream);

		}*/
	}

}
