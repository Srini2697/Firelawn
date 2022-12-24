package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy (id="fl_email")
	private WebElement usernametb;
	
	@FindBy (id="fl_password")
	private WebElement passwordtb;
	
	@FindBy (xpath="//span[text()=\"Login\"]")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public HomePage Logindetails(String username,String psw) {
		usernametb.sendKeys(username);
		passwordtb.sendKeys(psw);
		loginbtn.click();
		return new HomePage(driver);
		
	}

	public WebElement getUsernametb() {
		return usernametb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
}
