package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends MainMenu {

	protected WebDriver driver;

	private By numOfProductsInCart = By
			.xpath("//nav[@id=\"main-menu\"]/following-sibling::*//a[@title=\"Koszyk\"]/div");

	private String title = "Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile";

	private String url;

	public HomePage(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public void goToPage(String url) {
		this.url = url;
		driver.get(url);
	}

	public void goToPage() {
		driver.navigate().to(url);
	}

	public boolean numOfProductsInCartIsDisplayed() {
		return driver.findElement(numOfProductsInCart).isDisplayed();
	}

	public boolean checkHomePageIsVisible() {

		return driver.getTitle().equals(title);
	}
}
