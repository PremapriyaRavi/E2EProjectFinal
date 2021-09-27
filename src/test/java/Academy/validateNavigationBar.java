package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.BaseClass;

public class validateNavigationBar extends BaseClass {
	public WebDriver driver;
	public  static Logger log=LogManager.getLogger(validateNavigationBar.class.getName());
	@BeforeTest
	public void initialize() throws Throwable {
		driver = initializeBrowser();
		log.info("Browser is launched..");
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws Throwable {
		
		LandingPage le=new LandingPage(driver);
		Assert.assertTrue(le.getGetNavigationBar().isDisplayed());		
		log.info("Navigationbar is displayed");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
