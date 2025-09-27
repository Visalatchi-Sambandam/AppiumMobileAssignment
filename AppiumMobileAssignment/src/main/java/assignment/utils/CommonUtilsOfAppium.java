package assignment.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class CommonUtilsOfAppium {
	AppiumDriver driver;

	public CommonUtilsOfAppium(AppiumDriver driver) {
		this.driver = driver;
	}

	// Waits until the given element is clickable
	public void waitForAnElementToClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Waits until the given element is visible
	public void waitForAnElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Captures a screenshot and saves it with timestamp
	public static void takeScreenshot(AppiumDriver driver, String testName) {
		 if (driver == null) {
		        System.out.println("⚠ Driver is null, cannot take screenshot for " + testName);
		        return;
		    }

		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    File source = screenshot.getScreenshotAs(OutputType.FILE);
		    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		    try {
		        String fileName = testName + "_" + date + ".png";
		        FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\target\\screenshots\\" + fileName));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
}