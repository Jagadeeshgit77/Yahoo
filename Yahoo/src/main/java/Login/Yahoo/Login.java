package Login.Yahoo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Login extends Yahoo {
	public void Details(String fn, String ln, String nye, String pass, String day, String yr) {
		driver.findElement(By.id("usernamereg-firstName")).sendKeys(fn);
		driver.findElement(By.id("usernamereg-lastName")).sendKeys(ln);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(nye);
		
		//Selecting domain
		WebElement dom =  driver.findElement(By.id("yid-domain-selector"));
		Select d = new Select(dom);
		d.selectByVisibleText("myyahoo.com");
		
		//Enter password
		driver.findElement(By.id("usernamereg-password")).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Select month in DOB
		WebElement mnth =  driver.findElement(By.id("usernamereg-month"));
		Select m = new Select(mnth);
		m.selectByVisibleText("September");
		
		//Selecting day and year in DOB
		driver.findElement(By.id("usernamereg-day")).sendKeys(day);
		driver.findElement(By.id("usernamereg-year")).sendKeys(yr);
		
		//To continue after entering details
		driver.findElement(By.id("reg-submit-button")).click();
	}
	
	public void PhnNum(String phn){
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
		
	}
	public void Terms() {
        driver.get(url);
		String parentWindowHandle = driver.getWindowHandle();

	    driver.findElement(By.xpath("//a[text()='Terms']")).click();
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    for (String windowHandle : allWindowHandles) {
	        if (!windowHandle.equals(parentWindowHandle)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }
	    String termsPage = driver.getCurrentUrl();
	    System.out.println("Current URL: " + termsPage);

	    String expUrl = "https://legal.yahoo.com/us/en/yahoo/terms/otos/index.html";
	    if (termsPage.equals(expUrl)) {
	        System.out.println("Terms and Conditions Page is displayed in a new tab");
	    } else {
	        System.out.println("Terms and Conditions Page is not displayed in a new tab");
	    }
	}
	public void SC() {
		driver.findElement(By.xpath("//button[text()='Send code']")).click();
	}
}

