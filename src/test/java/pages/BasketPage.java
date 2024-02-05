package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {

	WebDriver driver;

	private By basketPageHeader = By.xpath("//h1[text()=\"Twój koszyk\"]");

	private By priceStartBasket = By.xpath("//span[@data-qa=\"BKT_TotalupFront\"]");

	private By pricePerMonthBasket = By.xpath("//span[@data-qa=\"BKT_TotalMonthly\"]");

	public BasketPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkBasketPageHeader() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(basketPageHeader));
			return true;
		} catch (Exception e) {
			System.out.println("basketPageHeader not found.");
			driver.quit();
		}
		return false;
	}

	public double priceStartValueAtBasket() {

		double priceStartValueAtBasket = Double
				.parseDouble(driver.findElement(priceStartBasket).getText().split(" ")[0]);
		System.out.println("Do zapłaty na start (koszyk) " + priceStartValueAtBasket);
		return priceStartValueAtBasket;
	}

	public double pricePerMonthValueAtBasket() {

		double pricePerMonthValueAtBasket = Double
				.parseDouble(driver.findElement(pricePerMonthBasket).getText().split(" ")[0]);
		System.out.println("Do zapłaty na miesiąc (koszyk) " + pricePerMonthValueAtBasket);
		return pricePerMonthValueAtBasket;
	}
}
