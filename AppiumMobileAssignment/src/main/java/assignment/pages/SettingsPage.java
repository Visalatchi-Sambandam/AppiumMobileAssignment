package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonUtilsOfAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class SettingsPage extends CommonUtilsOfAppium {
	AppiumDriver driver;

	public SettingsPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Back button to navigate to previous page after sign out
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	protected WebElement backToSignInPage;

	// "OK" button on sign-out confirmation frame
	@FindBy(id = "android:id/button1")
	protected WebElement signOutFrameButton;

	// Method to perform sign out action
	public void signingOut() {
		WebElement scrolling = driver
				.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"Sign out\"));"));
		scrolling.click();
		signOutFrameButton.click();
		waitForAnElementVisibility(backToSignInPage);
		backToSignInPage.click();

	}

}
