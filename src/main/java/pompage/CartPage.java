package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()=\"Buy Now\"]")
	private WebElement buybtn;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public AddressPage Buynow() {
		buybtn.click();
		return new AddressPage(driver);
		
	}

	public WebElement getBuybtn() {
		return buybtn;
	}
	
}
