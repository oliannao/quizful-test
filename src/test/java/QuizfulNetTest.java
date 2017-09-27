
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class QuizfulNetTest {
    private WebDriver driver;
    private MainPage mainPage;
    private UserPage userPage;
    private SettingsPage settingsPage;

    @BeforeClass
    public void initBrowes() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
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
    public void enterDataTest() throws InterruptedException {
        settingsPage.dataFClick();
    }

    @Test(priority = 6)
    public void selectTest() {
        settingsPage.select();
    }

    @Test(priority = 7)
    public void enterNoticeTest() throws InterruptedException{
        settingsPage.noticeClick(userPage);
    }
    @Test(priority = 8)
    public void enterConfTest() throws InterruptedException{
        settingsPage.confClick(userPage);
    }
    @Test(priority = 9)
    public void enterAvatarTest() throws InterruptedException{
        settingsPage.avatarClick(userPage);
    }
}
