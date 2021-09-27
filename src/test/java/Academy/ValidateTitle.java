package Academy;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.*;

public class ValidateTitle extends BaseClass {
	public WebDriver driver;
	public  static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws Throwable {
		driver = initializeBrowser();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	@Test
	public void validateTitle() throws Throwable {
		LandingPage le=new LandingPage(driver);
		Assert.assertEquals(le.getGetTitle().getText(),"FEATURED CO123URSES");	
		log.info("Successfuly validated text messages");
		System.out.println("Test completed...");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
