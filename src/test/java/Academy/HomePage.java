package Academy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass{
	public WebDriver driver;
	public  static Logger log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initialize() throws Throwable {
		driver = initializeBrowser();
		log.info("browser launched successfully..");
		//driver.get(prop.getProperty("url"));
		//because we are using 2 diff data types
		//bftest run and launch url only once if we write the driver here
	}
	//dataprovider inbetween bfclass and bfmethod
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		//row--->how many different datattype test should be run
		//column-->how many values per each test
		data[0][0]="restricted_user@123";
		data[0][1]="user@123";
		data[0][2]="restricteduser";
		data[1][0]="unres_user@456";
		data[1][1]="user@456";
		data[1][2]="unrestricted";
		return data;
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password, String text) throws Throwable {
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getLoginBtn().click();
		LoginPage ln=new LoginPage(driver);	
		ln.getUserName().sendKeys(username);
		ln.getPassWord().sendKeys(password);
		log.info(text);
		ln.getLogIn().click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
