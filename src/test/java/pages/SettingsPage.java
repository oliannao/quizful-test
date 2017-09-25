package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends Page {
	private final String URL = "http://www.quizful.net/ProfileAction.settings";

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

	@FindBy(xpath = "//b[contains(text(),\"Уведомления\")]")
	private WebElement elementNotice;

	@FindBy(xpath = "//label[@class ='notifications']")
	private WebElement elementNoSwitch;

	@FindBy(xpath = "//label[@class ='notifications']")
	private WebElement elementNoSend;

	@FindBy(xpath = "//input[@name =\"notificationsForm.save\"]")
	private WebElement elementSaiv;

	@FindBy(xpath = "//b[contains(text(),\"Конфиденциальность\")]")
	private WebElement elementCon;

	@FindBy(xpath = "//input[contains(text(),\"Только я\")]")
	private WebElement elementConJastMe;

	@FindBy(xpath = "//input[@name =\"privacyForm.save\"]")
	private WebElement elementSaivTwo;

	@FindBy(xpath = "//input[@name =\"personalForm.avatar\"]")
	private WebElement elementChooseAv;

	private final String nameF = "Anna";
	private final String nameL = "Osadchaya";
	private final String dateB = "2017";
	private final String site = "Epam.by";
	private final String campany = "EPAM";
	private final String cantry = "Беларусь";
	private final String city = "Минск";
	private final String poyas = "Белоруссия/Минск(GMT+3)";
	private final String me = "I'm hard working person = ))";

	public void dataFClicfk() {
		PageFactory.initElements(driver, this);
		dataF.click();
		personalFormF.sendKeys(nameF);
		personalFormL.sendKeys(nameL);
		personalFormB.sendKeys(dateB);
		personalSite.sendKeys(site);
		personalCamp.sendKeys(campany);
		elementC.click();
		new Select(elementC).selectByVisibleText(cantry);
		elementCy.click();
		new Select(elementCy).selectByVisibleText(city);
		elementPoyas.click();
		new Select(elementPoyas).selectByVisibleText(poyas);
		elementAboutMe.sendKeys(me);
		elementNotice.click();
		// elementNoSwitch.click();
		// elementNoSend.click();
		// elementSaiv.click();
		// elementCon.click();
		// elementConJastMe.click();
		// elementSaivTwo.click();
		dataF.click();
		elementChooseAv.click();

		driver.get("file://D:/дрозд.jpg");

		WebElement fileInput = driver.findElement(By.id("file"));

		fileInput.sendKeys("file://D:/дрозд.jpg");

	}

}
