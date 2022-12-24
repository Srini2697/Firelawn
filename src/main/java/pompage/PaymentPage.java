package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	@FindBy (xpath="//button[text()='Add Card']")
	private WebElement addcardbtn;
	

	@FindBy (xpath="//input[@placeholder=\"John Wick\"]")
	private WebElement cardname;
	
	@FindBy (xpath="//input[@placeholder=\"4567098712345678\"]")
	private WebElement cardnum;
	
	@FindBy (xpath="//input[@placeholder=\"1234\"]")
	private WebElement pin;
	
	@FindBy (xpath="//input[@placeholder=\"08\"]")
	private WebElement month;
	
	@FindBy (xpath="//input[@placeholder=\"33\"]")
	private WebElement year;
	
	@FindBy (xpath="//input[@placeholder=\"678\"]")
	private WebElement cvv;
	
	@FindBy (xpath="//input[@value=\"DEBIT\"]")
	private WebElement debitcard;
	
	@FindBy (xpath="//button[text()='Add']")
	private WebElement add;
	
	@FindBy (xpath="(//input[@type=\"radio\"])[1]")
	private WebElement radio;
	
	@FindBy (xpath="(//input[@type=\"text\"])[2]")
	private WebElement pinno;
	
	@FindBy (xpath="//button[text()=\"Submit\"]")
	private WebElement submitbtn;
	
	@FindBy (xpath="//button[text()=\"Proceed\"]")
	private WebElement procedbtn;
	
	
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void Carddetails(String cardholdername,String cardnumber,String pinnumber,String expirymonth,String expiryyear,String cvvnumber) {
		addcardbtn.click();
		cardname.sendKeys(cardholdername);
		cardnum.sendKeys(cardnumber);
		pin.sendKeys(pinnumber);
		month.sendKeys(expirymonth);
		year.sendKeys(expiryyear);
		cvv.sendKeys(cvvnumber);
		debitcard.click();
		add.click();
		
	}
	
	public void cards(String pinnumber) {
		radio.click();
	pinno.sendKeys(pinnumber);
	submitbtn.click();
	procedbtn.click();
		
	}



	public WebElement getAddcardbtn() {
		return addcardbtn;
	}



	public WebElement getCardname() {
		return cardname;
	}



	public WebElement getCardnum() {
		return cardnum;
	}



	public WebElement getPin() {
		return pin;
	}



	public WebElement getMonth() {
		return month;
	}



	public WebElement getYear() {
		return year;
	}



	public WebElement getCvv() {
		return cvv;
	}



	public WebElement getDebitcard() {
		return debitcard;
	}



	public WebElement getAdd() {
		return add;
	}



	public WebElement getRadio() {
		return radio;
	}



	public WebElement getPinno() {
		return pinno;
	}



	public WebElement getSubmitbtn() {
		return submitbtn;
	}



	public WebElement getProcedbtn() {
		return procedbtn;
	}
	
	
	
}
