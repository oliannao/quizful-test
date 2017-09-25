import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import pages.MainPage;
import pages.SettingsPage;
import pages.UserPage;

public class QuizfulNetTest {
	private WebDriver driver;
	private MainPage mainPage;
	private UserPage userPage;
	private SettingsPage settingsPage;

	@BeforeClass
	public void initBrowes() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void openMainTest() {
		mainPage = new MainPage(driver);
		mainPage.open();
		System.out.println(driver.getTitle());
		// Assert.assertEquals("Mail.Ru: почта, поиск в интернете, новости, игры",

	}

	@Test(priority = 2)
	public void findLoginMainTest() {
		mainPage.findEnterClicfk();
	}

	@Test(priority = 3)
	public void enterLoginPassword() {
		userPage = mainPage.enterLoginPassword();
	}

	@Test(priority = 4)
	public void userClick() {
		settingsPage = userPage.findRed();
	}

	@Test(priority = 5)
	public void enterDataTest() {
		settingsPage.dataFClicfk();
	}
}
