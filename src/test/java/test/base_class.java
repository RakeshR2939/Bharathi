package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base_class {
	public static WebDriver driver;
	public static void browserLaunch(String browserType,String url) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get(url);
			
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get(url);
			break;
			
		default:
			break;
		}
	}
	
	public static  WebElement element (String type, String locator) {
		WebElement ele = null;
		switch (type) {
		case "id":
			ele = driver.findElement(By.id(locator));

			break;
		case "name":
			ele = driver.findElement(By.name(locator));
            break;
		case "classname":
			ele = driver.findElement(By.className(locator));
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(locator));
			break;
		case "tagname":
			ele = driver.findElement(By.tagName(locator));
			break;
		case "textlink":
			ele = driver.findElement(By.partialLinkText(locator));
			break;
		case "css":
			ele = driver.findElement(By.cssSelector(locator));
			break;
		default:
			break;
		}
		return ele;
	}
	
	public static  Sheet getsheetRef (String path,String sheetName ) throws Exception {
		File f= new File(path);
		FileInputStream inp= new FileInputStream(f);
		Workbook w= new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = w.getSheet(sheetName);
		return sheet;				
	}
	 
	
}
