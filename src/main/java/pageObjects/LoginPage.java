package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="input[id*='user_email']")
	private WebElement userName;
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement passWord;
	@FindBy(css="input[class*='btn']")
	private WebElement LogIn;
	public WebElement getUserName() {
		return userName;
	}
	public void setUserName(WebElement userName) {
		this.userName = userName;
	}
	public WebElement getPassWord() {
		return passWord;
	}
	public void setPassWord(WebElement passWord) {
		this.passWord = passWord;
	}
	public WebElement getLogIn() {
		return LogIn;
	}
	public void setLogIn(WebElement logIn) {
		LogIn = logIn;
	}

}
