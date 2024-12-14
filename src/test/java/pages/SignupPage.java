package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testcases.BaseClass;
import java.time.Duration;

public class SignupPage {
	
	WebDriver driver = BaseClass.driver;
	
	// ==================== Locators ======================
	
	@FindBy(id = "signup")
	WebElement SignUp;
	
	@FindBy(xpath = "//h4")
	WebElement Success;
	
	
	@FindBy(id = "firstName")
	WebElement FirstName;
	
	@FindBy(id = "lastName")
	WebElement LastName;
	
	@FindBy(id = "email")
	WebElement Email;
	
	@FindBy(id = "contactNumber")
	WebElement ContactNumber;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(id = "confirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(id = "role1")
	WebElement Role;
	
	@FindBy(name = "_eventId_billing")
	WebElement NextButton;
	
	@FindBy(xpath = "//div[2]/div[1]/div/div/div/div/div[1]/h4")
	WebElement Success1;
	
	@FindBy(id = "addressLineOne")
	WebElement AddressLineOne;
	
	@FindBy(id = "addressLineTwo")
	WebElement AddressLineTwo;
	
	@FindBy(id = "city")
	WebElement City;
	
	@FindBy(id = "postalCode")
	WebElement PostalCode;
	
	@FindBy(id = "state")
	WebElement State;
	
	@FindBy(id = "country")
	WebElement Country;
	
	@FindBy(name = "_eventId_confirm")
	WebElement NextButton1;
	
	@FindBy(xpath = "//div[2]/div[1]/div/div[1]/div[1]/div/div[1]/h4")
	WebElement Success2;
	
	@FindBy(xpath = "//div[2]/div[1]/div/div[2]/div/div/a")
	WebElement Cbutton;
	
	
	@FindBy(xpath = "//h6")
	WebElement Success3;
	
	
	
	
	
	
	
	
	
	
	
	
// ====================== Functions =====================
	
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clicksignup(String msg) {
		SignUp.click();
		String ActMsg1 = Success.getText();
		System.out.println(ActMsg1);
		Assert.assertEquals(msg, ActMsg1);
		;
	}
	
	public void SingupPersonalDetails(String fname, String lname, String mail, String phone, String pwd, String msg) {
		
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Email.sendKeys(mail);
		ContactNumber.sendKeys(phone);
		Password.sendKeys(pwd);
		ConfirmPassword.sendKeys(pwd);
		Role.click();
		NextButton.click();
		/*String ActMsg1 = Success1.getText();
		System.out.println("Nxt"+ ActMsg1);
		Assert.assertEquals(msg, ActMsg1);*/
		
		
	}
	
	public void SignupAddress(String add1,String add2, String city, String pcode, String state, String ctry, String msg) {
		
		AddressLineOne.sendKeys(add1);
		AddressLineTwo.sendKeys(add2);
		City.sendKeys(city);
		PostalCode.sendKeys(pcode);
		State.sendKeys(state);
		Country.sendKeys(ctry);
		NextButton1.click();
		String ActMsg1 = Success2.getText();
		System.out.println("Nxt2"+ ActMsg1);
		Assert.assertEquals(msg, ActMsg1);
	}
	
   public void ValidateSucess(String msg) {
	  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Cbutton);
	   Actions action = new Actions(driver);
       action.moveToElement(Cbutton).click().perform();
	   
	   Cbutton.click();
		
		String ActMsg1 = Success3.getText();
		System.out.println("Nxt3"+ ActMsg1);
		Assert.assertEquals(msg, ActMsg1);
		
	}
	

}
