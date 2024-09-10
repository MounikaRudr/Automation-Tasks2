package Automation_Tasks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Demoqa {
	WebDriver driver;
	Actions actions;
  @Test
  public void VerifyDemoQaLogin(String firstname, String lastname,String Email,String GenderRadiobutton, int number,String DOB) {
	  System.out.println(firstname);
	  System.out.println(lastname);
	  System.out.println(Email);
	  System.out.println(GenderRadiobutton);
	  System.out.println(number);
	  System.out.println(DOB);
	  
  }
  @DataProvider
  public void loginData() throws InterruptedException {
	  
	 actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	  driver.findElement(By.className("avatar mx-auto white")).click();
	  driver.findElement(By.className("Practice Form")).click();
	  actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	 WebElement fn = driver.findElement(By.id("firstName"));
	 fn.clear();
	 fn.sendKeys("Mounika");
	 Thread.sleep(2000);
	 //*****************************
	 WebElement ln =  driver.findElement(By.id("lastName"));
	 ln.clear();
	 ln.sendKeys("Rudrarapu");
	 Thread.sleep(2000);
	//******************************
	 WebElement ue = driver.findElement(By.id("userEmail"));
	 ue.clear();
	 ue.sendKeys("mounika@gmail.com");
	 Thread.sleep(2000);
	 //*****************************
	  WebElement maleRadiobutton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
	  WebElement femaleRadiobutton = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
	  WebElement otherRadiobutton = driver.findElement(By.xpath("//label[@for='\"gender-radio-3']"));

	  String Gender = Gender;
	  if (Gender.equals("male")) {
		  maleRadiobutton.click();
	  }else if (Gender.equals("female")) {
		  femaleRadiobutton.click();
	  }else if (Gender.equals("other")) {
		  otherRadiobutton.click();
	  }else {
		  System.out.println("Invalid gender input: + Gender");
	  }
	 WebElement mb = driver.findElement(By.id("userNumber"));
	 mb.clear();
	 mb.sendKeys("9876543211");
	 Thread.sleep(2000);
	 //************************************
	 WebElement date = driver.findElement(By.id("dateOfBirthInput"));
	 date.click();
	String month = date.split(" ")[1];
	System.out.println(Integer.valueOf(month));
	driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
	Thread.sleep(2000);
	
	Select select = new Select(dd_month);
	select.selectByIndex(Integer.valueOf(month));
	Thread.sleep(2000);
	
	String year = .split(" ")[0];
	System.out.println((year));
	 
	driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	Thread.sleep(2000);
	
	String day=DT.split(" ")[2]; //13SUBJECT
	WebElement dt=driver.findElement(By.xpath("(//div[@class='react-datepicker__week'])[3]"));//div[contains(@class,'"+date+"')];
	dt.click();
	Thread.sleep(2000);
	//*********************************
	WebElement sub=driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
	Thread.sleep(2000);

	Select select2=new Select(sub);
	select2.selectByVisibleText(Subject);
	sub.click();
	
	driver.findElement(By.xpath("//button[@id='submit']")).click();
	
		  
 @DataProvider
  public Object[][] loginData1() {
	  Object[][] data = new Object[3][2];
	  //1st Row
	  data[0][0] = "mounika";
	  //2nd Row
	  data[0][1] = "Rudrarapu";
	   
	  //3rd Row
	  data[1][0] = "mounika@gmail.com";
	 
	  //4th Row
	  data [2][0] = "female";
	  data [2][1] = "male";
	  data [2][2] = "other";
	   
	  //5th Row
	  data [3][0] = "9876543211";
	  //6th Row
	  data [4][0] = "2024 august 05";
//	  data [4][1] = "15";
//	  data [4][2] = "2024";
 }
	  
	 @BeforeTest
    public void beforeTest() {
	  driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 actions = new Actions(driver);
  }

  @AfterTest
  public void afterTest() {
  }

}
