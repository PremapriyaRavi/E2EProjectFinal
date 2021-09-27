package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginBtn;
	@FindBy(xpath="//h2[text()='Featured Courses']")
	private WebElement getTitle;
	@FindBy(xpath="//ul[contains(@class,'navbar-right')]")
	private WebElement getNavigationBar;
	
	public WebElement getGetNavigationBar() {
		return getNavigationBar;
	}

	public void setGetNavigationBar(WebElement getNavigationBar) {
		this.getNavigationBar = getNavigationBar;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	public WebElement getGetTitle() {
		return getTitle;
	}

	public void setGetTitle(WebElement getTitle) {
		this.getTitle = getTitle;
	}
	
	
	
}
