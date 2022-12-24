package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressformPage {
	
	public WebDriver driver;
	
	@FindBy (id="outlined-size-small")
	private WebElement nametb;
	
	@FindBy (xpath="//input[@placeholder=\"eg-142/87, ABC Apartment\"]")
	private WebElement housetb;
	
	@FindBy (xpath="//input[@placeholder=\"eg-4th streetInfo\"]")
	private WebElement streettb;
	
	@FindBy (xpath="//input[@placeholder=\"eg-near This and That\"]")
	private WebElement landmarktb;
	
	@FindBy (xpath="(//select[@id=\"demo-simple-select-placeholder-label\"])[1]")
	private WebElement country;
	
	@FindBy (xpath="(//select[@id=\"demo-simple-select-placeholder-label\"])[2]")
	private WebElement state;
	
	@FindBy (xpath="(//select[@id=\"demo-simple-select-placeholder-label\"])[3]")
	private WebElement city;
	
	@FindBy (id="outlined-adornment-pincode")
	private WebElement pincodetb;
	
	@FindBy (xpath="//input[@placeholder=\"9876543210\"]")
	private WebElement phnotb;
	
	@FindBy (xpath="//button[text()='Add Address']")
	private WebElement addaddress;
	
	public AddressformPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void Addressdetail(String name,String house,String street,String landmark) {
		nametb.sendKeys(name);
		housetb.sendKeys(house);
		streettb.sendKeys(street);
		landmarktb.sendKeys(landmark);
	}
	
	public AddressPage pincod(String pincode,String phonenum) {
		pincodetb.sendKeys(pincode);
		phnotb.sendKeys(phonenum);
		addaddress.click();
		return new AddressPage (driver);
	}

	public WebElement getNametb() {
		return nametb;
	}

	public WebElement getHousetb() {
		return housetb;
	}

	public WebElement getStreettb() {
		return streettb;
	}

	public WebElement getLandmarktb() {
		return landmarktb;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPincodetb() {
		return pincodetb;
	}

	public WebElement getPhnotb() {
		return phnotb;
	}

	public WebElement getAddaddress() {
		return addaddress;
	}
	
}
