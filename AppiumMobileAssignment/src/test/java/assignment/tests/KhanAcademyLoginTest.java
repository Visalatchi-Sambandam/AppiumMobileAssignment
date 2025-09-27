package assignment.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import assignment.pages.HomePage;
import assignment.pages.LoginCredentialsPage;
import assignment.pages.SettingsPage;
import assignment.pages.SignInSignUpPage;
import assignment.pages.WelcomePage;
import assignment.utils.JsonUtil;

public class KhanAcademyLoginTest extends BaseClassAppium {

	@Test(dataProvider = "getCredentials")
	public void loginTest(HashMap<String, String> input) {
		WelcomePage welcomePage = new WelcomePage(driver);
		SoftAssert sAssert = new SoftAssert(); // For collecting assertions

		// Check if Sign In button is displayed
		boolean signInVisible = welcomePage.isSignInButtonDisplayed();
		sAssert.assertTrue(signInVisible,
				"Sign In button not visible. User may already be logged in. Logout to continue.");

		// Navigate to Sign In/Sign Up page
		SignInSignUpPage signInToApp = welcomePage.goToLoginRegisterPage();

		// Navigate to login form
		LoginCredentialsPage logintoApp = signInToApp.goToSignInPage();

		// Perform login with credentials from DataProvider
		HomePage homePage = logintoApp.loginWithUserCredentials(input.get("username"), input.get("password"));

		// Validate home page title after login [ There is no “Login Successful” message
		// prompt in the app. Therefore, the assertion was designed using the Home Page
		// title to validate successful login.]
		final String expectedTitle = "Khan Academy";
		String actualTitle = homePage.getTitleFromHomePage();
		sAssert.assertEquals(actualTitle, expectedTitle);

		// Navigate to settings and log out
		SettingsPage settings = homePage.goToSettings();
		settings.signingOut();

		// Trigger all soft assertions
		sAssert.assertAll();
	}

	@DataProvider(name = "getCredentials")
	public Object[] getData() {
		// Load login details from JSON file
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\loginDetails.json";
		List<Map<String, String>> map = JsonUtil.readDataFromJson(filePath);

		// Return data as Object[] to be used in @Test
		 Object[][] data = new Object[map.size()][1]; // 1 column for HashMap
		    for (int i = 0; i < map.size(); i++) {
		        data[i][0] = map.get(i); // each HashMap becomes one row
		    }
		    return data;
	}
}
