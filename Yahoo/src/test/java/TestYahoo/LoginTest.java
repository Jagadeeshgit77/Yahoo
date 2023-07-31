package TestYahoo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Login.Yahoo.Login;

public class LoginTest extends Login{
	@BeforeMethod
	public void setup() {
		start();
	}
	@Test
	public void enterDetails() {
		Login l = new Login();
		l.Details("Palavalasa", "Jagadeesh", "palavalasarecruit77", "Recruit#77", "20", "1999");
	}
	@Test
	public void phoneNumber() {
		Login p = new Login();
		p.Details("Palavalasa", "Jagadeesh", "palavalasarecruit77", "Recruit#77", "20", "1999");
		p.PhnNum("9023546778");
	}
	@Test
	public void TandC(){
		Login c = new Login();
		c.Terms();
	}
	@Test
	public void SeCo() {
		Login s = new Login();
		phoneNumber();
		s.SC();
	}
	@AfterMethod
	public void end(){
		stop();
}
}
