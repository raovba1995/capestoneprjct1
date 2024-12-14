package testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

public class Alltestcases extends BaseClass {
	
	@Test
	public void tc01_Signup() {
		SignupPage sp = new SignupPage();
		sp.clicksignup("Sign Up - Personal");
		sp.SingupPersonalDetails("vibha", "rao", "abc@xyzii.com", "8888888888", "abc@123", "Sign Up - Address");
		sp.SignupAddress("mgroad","navanagar", "Hubli", "583772", "karnataka", "India", "Personal Details");
		sp.ValidateSucess("You can use your email address as username to login!");
	}
	
	
	@Test
	public void tc02_loginsucess() {
		LoginPage lp =new LoginPage();
		lp.loginmethod("abc@xyz.com", "abc@123");
		lp.validateloginsucess("Vibha Rao");
	}
	
	
	@Test
	public void tc03_loginfailure() {
		LoginPage lp =new LoginPage();
		lp.loginmethod("abc@123.com", "qwe@123");
		lp.validateloginfailure("Username and Password is invalid!");
	}
	
	
	@Test
	public void tc04_add1itemchkout() {
		LoginPage lp =new LoginPage();
		lp.loginmethod("abc@xyz.com", "abc@123");
		HomePage hp = new HomePage();
		hp.addtocart1item();
		hp.validateaddtocart("Product has been successfully added inside cart!");
		hp.validatecheckout("123456789", "12", "95", "222", "Your Order is Confirmed!!");
		
	}
	
	@Test
	public void tc05_add2itemchkout() {
		
		LoginPage lp =new LoginPage();
		lp.loginmethod("abc@xyz.com", "abc@123");
		HomePage hp = new HomePage();
		hp.addtocart1item();
		hp.addtocart2items();
		hp.validateaddtocart("Product has been successfully added inside cart!");
		hp.validatecheckout("123456789", "12", "95", "222", "Your Order is Confirmed!!");
		
	}
	

}
