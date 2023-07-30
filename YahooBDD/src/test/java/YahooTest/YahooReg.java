package YahooTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class YahooReg {
	
	WebDriver driver;
    String url;
	@Given("User is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    url = "https://login.yahoo.com/account/create?.intl=us&specId=yidregsimplified&done=https%3A%2F%2Fwww.yahoo.com";
		driver.navigate().to(url);
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters details as {string} and {string}")
	public void user_enters_details_as(String firstname, String lastname) {
	    driver.findElement(By.id("usernamereg-firstName")).sendKeys(firstname);
	    driver.findElement(By.id("usernamereg-lastName")).sendKeys(lastname);
	}

	@When("User enters {string} and {string}")
	public void user_enters(String Newemail, String domain) {
	    driver.findElement(By.id("usernamereg-yid")).sendKeys(Newemail);
	    WebElement domainDropdown = driver.findElement(By.id("usernamereg-domain"));
	    Select domainSelect = new Select(domainDropdown);
	    domainSelect.selectByVisibleText(domain);
	}

	@When("User enters {string}")
	public void user_enters(String password) {
	    driver.findElement(By.id("usernamereg-password")).sendKeys(password);
	}

    @When("User enter DOB as month {string} and {string}")
    public void user_enter_dob_as_month_and(String day, String year) {
        driver.findElement(By.id("usernamereg-day")).sendKeys(day);
        driver.findElement(By.id("usernamereg-year")).sendKeys(year);
    }
	@When("User clicks on Countinue")
	public void user_clicks_on_countinue() {
		driver.findElement(By.id("reg-submit-button")).click();
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User enters mobile number")
	public void user_enters_mobile_number(String phn) {
		driver.findElement(By.name("phone")).sendKeys(phn);
		String t = driver.findElement(By.id("usernamereg-phone")).getAttribute("value");
		char[] s = t.toCharArray();
		int count = 0;
		for (int i=0; i<s.length; i++) {
			count++;
		}
		if(count == 10) {
			System.out.println("Entered phone number is valid");
		}else {
			System.out.println("Entered phone number is not valid");
		}
	    throw new io.cucumber.java.PendingException();
	}


}
