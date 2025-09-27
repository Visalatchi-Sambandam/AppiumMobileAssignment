package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonUtilsOfAppium;
import io.appium.java_client.AppiumDriver;

public class LoginCredentialsPage extends CommonUtilsOfAppium {

	AppiumDriver driver;

	public LoginCredentialsPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Email or username input field
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Enter an e-mail address or username']")
	protected WebElement enterEmailOrUserName;

	// Password input field
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Password']")
	protected WebElement enterPassword;

	// Sign In button
	@FindBy(xpath = "//android.widget.Button[@content-desc='Sign in']/android.view.ViewGroup")
	protected WebElement signInButton;

	// Method to perform login with provided credentials
	public HomePage loginWithUserCredentials(String username, String password) {
		enterEmailOrUserName.sendKeys(username);
		enterPassword.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);

	}

}
