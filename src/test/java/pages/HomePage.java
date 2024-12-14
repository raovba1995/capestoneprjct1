package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testcases.BaseClass;

public class HomePage {
 
	WebDriver driver = BaseClass.driver;
	
	// ==================== Locators ======================
	
	//@FindBy(xpath = "//*[@id=\"listProducts\"]/a")
	//WebElement products;
	
	@FindBy(id = "listProducts")
	WebElement products;
	
	
	@FindBy(xpath = "//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[2]")
	WebElement product1;
	
	@FindBy(xpath = "//h3")
	WebElement chkoutmsg;
	
	@FindBy(linkText = "Continue Shopping")
	WebElement ctnshopping;
	
	@FindBy(xpath = "//*[@id=\"productListTable\"]/tbody/tr[2]/td[6]/a[2]")
	WebElement product2;
	
	@FindBy(linkText = "Checkout")
	WebElement chkout;
	
	@FindBy(xpath = "//div[2]/div[1]/div/div/div[1]/div/div/div/a")
	WebElement select;
	
	@FindBy(id = "cardNumber")
	WebElement cardnum;
	
	@FindBy(id = "expityMonth")
	WebElement month;
	
	@FindBy(id = "expityYear")
	WebElement year;
	
	@FindBy(id = "cvCode")
	WebElement cvcode;
	
	@FindBy(xpath = "//div[2]/div[1]/div/div/div[2]/a")
	WebElement pay;
	
	@FindBy(xpath = "/html/body/div/div[1]/div/div[1]/h3")
	WebElement Success;
	
	
	
	
	
	
	
	
	
	
	// ====================== Functions =====================
	
	
		public HomePage() {
			PageFactory.initElements(driver, this);
			
		}
		
		public void addtocart1item() {
	 
			Actions action = new Actions(driver);
            action.moveToElement(products).click().perform();
			products.click();
			
			
            action.moveToElement(product1).click().perform();
			product1.click();
			
		}
		
		public void addtocart2items() {
			
			Actions action = new Actions(driver);
            action.moveToElement(ctnshopping).click().perform();
			ctnshopping.click();
			
			action.moveToElement(product2).click().perform();
			product2.click();
			
		}
		
		public void validateaddtocart(String msg) {
			
			String ActMsg1 = chkoutmsg.getText();
			System.out.println(ActMsg1);
			Assert.assertEquals(msg, ActMsg1);
			
			
		}
		
		public void validatecheckout(String cnum, String mon, String yr, String cvv, String msg) {
			
			Actions action = new Actions(driver);
            action.moveToElement(chkout).click().perform();
			chkout.click();
			action.moveToElement(select).click().perform();
			select.click();
			cardnum.sendKeys(cnum);
			month.sendKeys(mon);
			year.sendKeys(yr);
			cvcode.sendKeys(cvv);
			pay.click();
			
			String ActMsg1 = Success.getText();
			Assert.assertEquals(msg, ActMsg1);
			
		}
		

}
