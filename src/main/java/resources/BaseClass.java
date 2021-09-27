package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeBrowser() throws Throwable{
		prop=new Properties();
		FileInputStream in=new FileInputStream("C:\\Users\\PREMA\\eclipse-workspace\\E2EProject\\src\\main\\java\\data.properties");
		prop.load(in);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\PREMA\\eclipse-workspace\\E2EProject\\Drivers\\chromedriver.exe");	
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\PREMA\\eclipse-workspace\\E2EProject\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\PREMA\\eclipse-workspace\\E2EProject\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenshotPath(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destination));
		return destination;
		
	}
}
