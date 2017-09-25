package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends Page {
	private final String URL = "http://www.quizful.net/user/oliannao";

	public UserPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	@FindBy(xpath = "//a[contains(text(),\"редактировать\")]")
	private WebElement red;

	public SettingsPage findRed() {
		PageFactory.initElements(driver, this);
		red.click();
		return new SettingsPage(driver);
	}

}
