package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevicesMenu {

	protected WebDriver driver = null;

	private String subMenuElement;

	private By subMenuElementBy;

	private By devicesMenu = By.xpath(
			"//button[text()[contains(.,\"Urządzenia\")]]/following-sibling::div[@class[contains(.,\"menu-dropdown-submenu\")]]");

	public DevicesMenu(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkDevicesMenuIsVisible() {

		return driver.findElement(devicesMenu).isDisplayed();
	}

	public void clickSubMenuElement(String option, String column) {

		this.subMenuElement = "//li/p[text()[contains(.,\"" + column + "\")]]/parent::*//span[text()=\"" + option
				+ "\"]/parent::*";

		subMenuElementBy = By.xpath(subMenuElement);
		driver.findElement(subMenuElementBy).click();
	}

}
