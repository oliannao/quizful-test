package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends Page {
    private final String URL = "http://www.quizful.net/ProfileAction.settings";
    private  UserPage userPage;
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(URL);
    }

    @FindBy(xpath = "//b[contains(text(),\"Личные данные\")]")
    private WebElement dataF;

    @FindBy(xpath = "//input[@name =\"personalForm.name\"]")
    private WebElement personalFormF;

    @FindBy(xpath = "//input[@name =\"personalForm.surname\"]")
    private WebElement personalFormL;

    @FindBy(xpath = "//input[@name =\"personalForm.birthyear\"]")
    private WebElement personalFormB;

    @FindBy(xpath = "//input[@name =\"personalForm.site\"]")
    private WebElement personalSite;

    @FindBy(xpath = "//input[@name =\"personalForm.company\"]")
    private WebElement personalCamp;

    @FindBy(xpath = "//select[@name =\"personalForm.countryId\"]")
    private WebElement elementC;

    @FindBy(xpath = "//select[@name =\"personalForm.cityId\"]")
    private WebElement elementCy;

    @FindBy(xpath = "//select[@name =\"personalForm.zone\"]")
    private WebElement elementPoyas;

    @FindBy(xpath = "//textarea[@name =\"personalForm.about\"]")
    private WebElement elementAboutMe;

    @FindBy(xpath = "//input[@name =\"personalForm.save\"]")
    private WebElement elementSaveMe;

    @FindBy(xpath = "//b[contains(text(),\"Уведомления\")]")
    private WebElement elementNotice;

    @FindBy(xpath = "//label[contains(.,\"Включить уведомления\")]")
    private WebElement elementNoSwitch;

    @FindBy(xpath = "//label[contains(.,\"Получать рассылку\")]")
    private WebElement elementNoSend;

    @FindBy(xpath = "//input[@name =\"notificationsForm.save\"]")
    private WebElement elementSaiv;

    @FindBy(xpath = "//b[contains(text(),\"Конфиденциальность\")]")
    private WebElement elementCon;

    @FindBy(xpath = "//label[contains(.,\"Только я\")]")
    private WebElement elementConJastMe;

    @FindBy(xpath = "//input[@name =\"personalForm.avatar\"]")
    private WebElement elementChooseAv;

    @FindBy(xpath = "//input[@name =\"personalForm.save\"]")
    private WebElement saiv;

    private final String nameF = "Anna";
    private final String nameL = "Osadchaya";
    private final String dateB = "2017";
    private final String site = "Epam.by";
    private final String campany = "EPAM";
    private final String cantry = "Беларусь";
    private final String city = "Минск";
    private final String poyas = "Белоруссия/Минск(GMT+3)";
    private final String me = "I'm hard working person = ))";

    public void dataFClick() throws InterruptedException {
        PageFactory.initElements(driver, this);
        Thread.sleep(5000);
        dataF.click();
        personalFormF.clear();
        personalFormF.sendKeys(nameF);
        personalFormL.clear();
        personalFormL.sendKeys(nameL);
        personalFormB.clear();
        personalFormB.sendKeys(dateB);
        personalSite.clear();
        personalSite.sendKeys(site);
        personalCamp.clear();
        personalCamp.sendKeys(campany);


    }
    public void select() {
        elementC.click();
        new Select(elementC).selectByVisibleText(cantry);
        elementCy.click();
        new Select(elementCy).selectByVisibleText(city);
        elementPoyas.click();
        new Select(elementPoyas).selectByVisibleText(poyas);
        elementAboutMe.sendKeys(me);
        // elementSaveMe.click();

    }
    public void  noticeClick(UserPage userPage) throws InterruptedException {
        Thread.sleep(2000);
        elementNotice.click();
        WebDriverWait wait = new WebDriverWait(driver, 300);

        WebElement elementNoSwitchOne = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//label[contains(.,\"Включить уведомления\")]")));
        elementNoSwitchOne.click();
        WebElement elementNoSend = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//label[contains(.,\"Получать рассылку\")]")));
        elementNoSend.click();
        WebElement elementSaiv = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//input[@name =\"notificationsForm.save\"]")));
        elementSaiv.click();
        userPage.findRed();

    }

    public void confClick(UserPage userPage) throws InterruptedException {
        Thread.sleep(2000);
         elementCon.click();
        WebDriverWait wait = new WebDriverWait(driver, 300);
        WebElement elementConJastMeOne = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//label[contains(.,\"Только я\")]")));
         elementConJastMe.click();
        WebElement elementSaiv = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//input[@name =\"privacyForm.save\"]")));
        elementSaiv.click();
        userPage.findRed();
    }
    public void avatarClick(UserPage userPage)throws InterruptedException{
        Thread.sleep(2000);
        dataF.click();
        File file = new File("C:\\Osa.jpg");
        elementChooseAv.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
        saiv.click();
        userPage.findRed();
    }

}
