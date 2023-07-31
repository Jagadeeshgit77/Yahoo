package Login.Yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yahoo {
	static public  WebDriver driver;
	static public String url;
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    url = "https://login.yahoo.com/account/create?.intl=us&specId=yidregsimplified&done=https%3A%2F%2Fwww.yahoo.com";
		driver.navigate().to(url);
	}
	
	public void stop() {
		driver.quit();
	}

}


