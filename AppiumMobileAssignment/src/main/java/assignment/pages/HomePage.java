package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonUtilsOfAppium;
import io.appium.java_client.AppiumDriver;

public class HomePage extends CommonUtilsOfAppium {

	AppiumDriver driver;

	public HomePage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Element representing the home page title
	@FindBy(xpath = "//android.view.View[@text='Khan Academy']")
	protected WebElement actualTitle;

	// Settings button element
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Settings']")
	protected WebElement settingsButton;

	// Method to get the text of the home page title
	public String getTitleFromHomePage() {
		waitForAnElementVisibility(actualTitle);
		return actualTitle.getText();
	}

	// Navigate to Settings page
	public SettingsPage goToSettings() {
		settingsButton.click();
		return new SettingsPage(driver);
	}

}
