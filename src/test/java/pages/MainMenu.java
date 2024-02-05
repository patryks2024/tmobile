package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu extends DevicesMenu {

	protected WebDriver driver = null;

	// Urządzenia
	private By devices = By.xpath("//*[@id=\"main-menu\"]//button[text()[contains(.,\"Urządzenia\")]]");

	public MainMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickDevices() {

		driver.findElement(devices).click();
	}
}
