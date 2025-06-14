package computer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectutility.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_010_Test extends BaseClass{

	@Test
	public void clickOnComputers() {
		test.log(Status.INFO, "test execution started");
		HomePage hp=new HomePage(driver);
		hp.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers");
		test.log(Status.PASS, "computer page is disaplyed");
	}	
	
}
