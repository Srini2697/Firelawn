package scripts;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.Ecommerce.Firelawn.genericLIB.BaseClass;

import pompage.AddressPage;
import pompage.AddressformPage;
import pompage.CartPage;
import pompage.HomePage;
import pompage.LoginPage;
import pompage.PaymentPage;
import pompage.ProductPage;
import pompage.Welcome;

public class TestCase1 extends BaseClass  {

	@Test
	public void openapp() throws IOException, InterruptedException, SQLException {
	Welcome w=new Welcome(driver);
	LoginPage l = w.loginbutton();
	HomePage h = l.Logindetails(fu.getthepropertydata("username"),fu.getthepropertydata("psw"));
	
	Thread.sleep(10000);
	ProductPage p = h.searchElement(fu.getexcelData("Sheet1", 1, 0));
	Thread.sleep(10000);
	
	CartPage c = p.Addtocartbtn();
	Thread.sleep(10000);
	 AddressPage a = c.Buynow();
	 AddressformPage ad = a.AddAdress();
	 ad.Addressdetail(fu.getexcelData("Sheet1", 1, 1),fu.getexcelData("Sheet1", 1, 2),fu.getexcelData("Sheet1", 1, 3),fu.getexcelData("Sheet1", 1, 4));
	 webutilies.dropdown(ad.getCountry(),fu.getthepropertydata("country"));
	 webutilies.dropdown(ad.getState(),fu.getthepropertydata("state"));
	 webutilies.dropdown(ad.getCity(), fu.getthepropertydata("city"));
	 a=ad.pincod(fu.getexcelData("Sheet1", 1, 5),fu.getexcelData("Sheet1", 1, 6));
	 Thread.sleep(10000);
	 PaymentPage pa = a.Selectaddress();
	 pa.Carddetails(fu.queyExecution(1, "srinivas"),fu.queyExecution(2, " 5014401191606483") ,
			fu.queyExecution( 3, "9365"),fu.queyExecution( 4, "12"),
			fu.queyExecution( 5, "27"),fu.queyExecution( 6, "562"));
	 Thread.sleep(20000);
	 pa.cards(fu.queyExecution( 3, "9365"));

	}
}
