package assignment.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonUtilsOfAppium;
import io.appium.java_client.AppiumDriver;

public class WelcomePage extends CommonUtilsOfAppium {

	AppiumDriver driver;

	public WelcomePage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locates the "Sign in" button on the welcome page
	@FindBy(xpath = "//android.widget.TextView[@text='Sign in']")
	protected WebElement signInButton;

	// Checks if the Sign in button is visible; returns false if element is not
	public boolean isSignInButtonDisplayed() {
		try {
			return signInButton.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Navigates to the login/register page by clicking the Sign in button
	public SignInSignUpPage goToLoginRegisterPage() {
		waitForAnElementToClickable(signInButton);
		signInButton.click();
		return new SignInSignUpPage(driver);
	}
}
