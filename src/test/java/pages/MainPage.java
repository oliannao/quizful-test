package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {
	private final String URL = "http://www.quizful.net/";

	public MainPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[contains(text(),\"войти\")]")
	private WebElement enter;

	@FindBy(xpath = "//input[@id =\"login\"]")
	private WebElement login;

	@FindBy(xpath = "//input[@name =\"loginForm.password\"]")
	private WebElement password;

	@FindBy(xpath = "//input[@name =\"ok\"]")
	private WebElement ok;

	@FindBy(xpath = "//a[contains(text(),\"oliannao\")]")
	private WebElement user;

	private final String logins = "oliannao";
	private final String passwords = "**********";

	public void open() {
		getDriver().get(URL);
	}

	public void findEnterClicfk() {
		
		enter.click();
	}

	public UserPage enterLoginPassword() {
		login.sendKeys(logins);
		password.sendKeys(passwords);
		ok.click();
		user.click();
		return new UserPage(driver);

	}

}
