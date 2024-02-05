package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesInfo {

	protected WebDriver driver = null;

	private By cookiesInfo = By.id("FirstNoticeHeader");

	private By acceptCookies = By.id("didomi-notice-agree-button");

	private By changeCookies = By.id("didomi-notice-learn-more-button");

	public void acceptCookies() {

		if (checkCookiesInfo()) {
			driver.findElement(acceptCookies).click();
		}
	}

	public CookiesInfo(WebDriver driver) {

		this.driver = driver;
	}

	public void changeCookies() {

		driver.findElement(changeCookies).click();
	}

	public boolean checkCookiesInfo() {
		try {
			if (driver.findElement(cookiesInfo).isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Cookies info not found.");
		}
		return false;
	}
}
