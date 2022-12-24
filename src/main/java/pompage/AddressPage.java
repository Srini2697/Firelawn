package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	
	public WebDriver driver;

	@FindBy (xpath="//span[text()='Add New Address']")
	private WebElement addAddressbtn;
	
	@FindBy (xpath="//input[@type=\"radio\"]")
	private WebElement selectadd;

	@FindBy (xpath="//button[text()='Proceed']")
	private WebElement procedbtn;
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public AddressformPage  AddAdress() {
		addAddressbtn.click();
		return new AddressformPage(driver);
	}
	
	public PaymentPage Selectaddress() {
		selectadd.click();
		procedbtn.click();
		return new PaymentPage(driver);
	}

	public WebElement getAddAddressbtn() {
		return addAddressbtn;
	}

	public WebElement getSelectadd() {
		return selectadd;
	}

	public WebElement getProcedbtn() {
		return procedbtn;
	}
	
	
}
