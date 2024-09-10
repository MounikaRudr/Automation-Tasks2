package Automation_Tasks;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.cucumber.java.en.And;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class Login {WebDriver driver;
	Actions action;

	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
	driver = new ChromeDriver();
	}

	@Given("the user navigaties to the url")
	public void the_user_navigaties_to_the_url() {
	driver.get("https://www.saucedemo.com/inventory.html");
	driver.manage().window().maximize();

	}

	@When("The user enter the user Name")
	public void the_user_enter_the_user_name() {
	driver.findElement(By.name("user-name")).sendKeys("standard_user");

	}

	@When("The user enters the password")
	public void the_user_enters_the_password() {
	driver.findElement(By.name("password")).sendKeys("secret_sauce");

	}

	@When("The User click on the login button")
	public void the_user_click_on_the_login_button() {
	driver.findElement(By.name("login-button")).click();
	}

	@Given("Add a backpack product to cart")
	public void add_a_product_to_cart() throws InterruptedException {
	driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
	Thread.sleep(2000);

	}

	@And("Add Another jacket product to cart")
	public void add_another_product_to_cart() {
	driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']")).click();
	}

	@And("Add Another light product to cart")
	public void i_verify_the_success_in_step() {
	driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']")).click();
	}

	@Then("Click on the add to cart Icon")
	public void click_on_the_add_to_cartIcon() throws InterruptedException {
	driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

	Thread.sleep(2000);

	}

	@Then("click on the checkout button")
	public void click_on_the_checkout_button() {
	driver.findElement(By.id("checkout")).click();

	}

	@Then("Fill the information")
	public void fill_the_information() throws InterruptedException {
	driver.findElement(By.id("first-name")).sendKeys("Manohar");
	driver.findElement(By.id("last-name")).sendKeys("yadav");
	driver.findElement(By.id("postal-code")).sendKeys("505501");
	Thread.sleep(2000);


	}

	@Then("Click on the continue")
	public void click_on_the_continue() {
	driver.findElement(By.id("continue")).click();

	}

	@Then("Click on the Finish button")
	public void click_on_the_finish_button() {
	driver.findElement(By.id("finish")).click();

	}

	@Then("quit the application")
	public void quit() {
	driver.quit();
	}

	}

