package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;

	@FindBy (id="search")
	private WebElement searchtb;
	
	@FindBy(id="search_prod")
	private WebElement searchbtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public ProductPage searchElement(String productname) {
		searchtb.sendKeys(productname);
		searchbtn.click();
		return new ProductPage(driver);
	}

	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
	
}
