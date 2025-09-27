package assignment.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;

public class BaseClassAppium {
	public AppiumDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities caps = new DesiredCapabilities();
		// Mandatory device/platform details
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2"); // Appium automation engine
		caps.setCapability("appium:deviceName", "CPH2467"); // Device name (can be anything if udid is given)
		caps.setCapability("appium:udid", "175ea12a"); // Unique Device ID from adb devices

		// Reset settings
		caps.setCapability("appium:noReset", true); // Don’t reset app state
		caps.setCapability("appium:fullReset", false); // Don’t uninstall app

		// Application under test
		caps.setCapability("appium:appPackage", "org.khanacademy.android"); // Package name of the app
		caps.setCapability("appium:appActivity", "org.khanacademy.android.ui.library.MainActivity"); // Entry activity

		// Appium server URL
		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		// Initialize AndroidDriver with capabilities and server URL
		driver = new AndroidDriver(url, caps);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null)
			((InteractsWithApps) driver).terminateApp("org.khanacademy.android");
			driver.quit(); // Closes the session and shuts down driver
	}

}
