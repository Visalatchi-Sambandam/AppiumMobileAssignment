package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonUtilsOfAppium;
import io.appium.java_client.AppiumDriver;

public class SignInSignUpPage extends CommonUtilsOfAppium {

	AppiumDriver driver;

	public SignInSignUpPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Element for "Sign up with email" option
	@FindBy(xpath = "//android.widget.TextView[@text='Sign up with email']")
	protected WebElement signUpWithEmail;

	// Element for "Sign in" option
	@FindBy(xpath = "//android.widget.TextView[@text='Sign in']")
	protected WebElement signInWithUser;

	// Clicks on "Sign in" and navigates to LoginCredentialsPage
	public LoginCredentialsPage goToSignInPage() {
		waitForAnElementToClickable(signInWithUser);
		signInWithUser.click();
		return new LoginCredentialsPage(driver);
	}
}
