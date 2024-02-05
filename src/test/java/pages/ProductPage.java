package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tmobileTask.Utils;

public class ProductPage extends MainMenu {

	protected WebDriver driver;

	private By productNameHeader = By.xpath("//h1[@data-qa=\"PRD_ProductName\"]");

	private By priceStart = By.xpath("//span//div[@data-qa=\"PRD_TotalUpfront\"]/div/div");

	private By pricePerMonth = By
			.xpath("//span//div[@class=\"priceRightSection rightAlignment\"]//div[@class=\"dt_price_change\"]/div");

	private By buttonAddToBasket = By.xpath("//span//button[@data-qa=\"PRD_AddToBasket\"]");

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean checkDevicesPageHeader() {

		return Utils.waitForElement(driver, productNameHeader).isDisplayed();
	}

	public double priceStartValue() {

		double priceStartValue = Double.parseDouble(Utils.waitForElement(driver, priceStart).getText().split(" ")[0]);
		System.out.println("Do zapłaty na start " + priceStartValue);
		return priceStartValue;
	}

	public double pricePerMonthValue() {

		double pricePerMonthValue = Double.parseDouble(driver.findElement(pricePerMonth).getText().split(" ")[0]);
		System.out.println("Do zapłaty na miesiąc " + pricePerMonthValue);
		return pricePerMonthValue;
	}

	public void clickButtonAddToBasket() {

		driver.findElement(buttonAddToBasket).click();
	}
}
