package Automation_Tasks;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ExcelDataRead {
	WebDriver driver;
  @Test
  public void VerifySampleData() throws Exception {
	  String path = System.getProperty("user.dir");
		 System.out.println(path);
		 
		 File file = new File(path +"\\src\\test\\resources\\SampleTestData.xlsx" );
		 FileInputStream fis = new FileInputStream(file);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet =  wb.getSheetAt(0);
		 int rowscount = sheet.getPhysicalNumberOfRows();
		 System.out.println("Rows: +rowsCount");
		 for (int i=0; i< rowscount; i++) {
			  
			 Row row = sheet.getRow(i);
			 
			 String Search = row.getCell(0).getStringCellValue();
			 System.out.println(Search);
			 
			WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
			search.clear();
			search.sendKeys("Search");
		     driver.findElement(By.id("nav-search-submit-button"));
		     search.click();
		     
  }
  }
  @BeforeTest
  public void beforeTest() {
	        driver = new ChromeDriver();
			driver.get("https://www.amazon.in//");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
