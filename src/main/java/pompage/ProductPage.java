package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;
	@FindBy (xpath="(//button[@type=\"button\"])[2]")
	private WebElement addtocart;

	@FindBy (id="cart_fl")
	private WebElement cartbtn;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public CartPage Addtocartbtn() {
		addtocart.click();
		cartbtn.click();
		return new CartPage(driver);
	}

	public WebElement getProductbtn() {
		return addtocart;
	}

	public WebElement getCartbtn() {
		return cartbtn;
	}
	
}
