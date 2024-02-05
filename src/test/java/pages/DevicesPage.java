package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevicesPage extends MainMenu {

	protected WebDriver driver;

	private By devicesPageHeader = By.xpath("//h1[@data-qa=\"LST_Header\"]");

	private By firstElement = By.xpath("//div[@data-qa=\"LST_ProductCard0\"]/a");

	public DevicesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean checkDevicesPageHeader() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(devicesPageHeader));
			return true;
		} catch (Exception e) {
			System.out.println("devicesPageHeader not found.");
			driver.quit();
		}
		return false;
	}

	public void clickFirstElement() {
		driver.findElement(firstElement).click();
	}
}
