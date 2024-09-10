package Automation_Tasks;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Task04 {
	WebDriver driver;
  @Test(dataProvider = "loginData")
  public void VerifySauseDemo(String username, String password) throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.id("user-name")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("login-button")).click();
	  driver.quit();
	  
  }
  @DataProvider
  public Object[][] loginData() {
	Object[][]data = new Object[6][2];
	     //1st Row
	     data[0][0] = "standard_user";
	     data[0][1] = "secret_sauce";
	     //2nd Row
	     data[1][0] = "locked_out_user";
	     data[1][1] = "secret_sauce";
	     //3rd Row
	     data[2][0] = "problem_user";
	     data[2][1] = "secret_sauce";
	     //4th row
	     data[3][0] = "performance_glitch_user";
	     data[3][1] = "secret_sauce";
	     //5th Row
	     data[4][0] = "error_user";
	     data[4][1] = "secret_sauce";
	     //6th Row
	     data[5][0] = "visual_user";
	     data[5][1] = "secret_sauce";
	     return data;
	     
  }
	 @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
