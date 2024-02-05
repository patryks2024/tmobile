package tmobileTask;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasketPage;
import pages.Browser;
import pages.CookiesInfo;
import pages.DevicesPage;
import pages.HomePage;
import pages.ProductPage;

public class Steps {

	WebDriver driver;

	HomePage homePage;

	DevicesPage devicesPage;

	ProductPage productPage;

	Browser browser = new Browser(driver);

	@Given("Otwórz przeglądarkę")
	public void openBrowser() {
		System.out.println("Otwieranie przeglądarki");
		this.driver = browser.openAndMaximizeBrowser();
	}

	@Then("Przeglądarka otworzona")
	public void checkBrowserOpened() {

		if (!browser.checkBrowserIsOpened()) {
			System.out.println("Przeglądarka nie została poprawnie uruchomiona");
			driver.quit();
		}
	}

	@When("Przejdź na stronę {string}")
	public void goToHomePage(String string) {
		this.homePage = new HomePage(driver);
		CookiesInfo cookiesInfo = new CookiesInfo(driver);
		System.out.println("Przejście do strony głównej");
		homePage.goToPage(string);
		System.out.println("Akceptacja cookies");
		cookiesInfo.acceptCookies();
	}

	@Then("Strona główna jest widoczna")
	public void checkHomePageDisplayed() {
		if (this.homePage.checkHomePageIsVisible()) {
			System.out.println("Strona główna jest widoczna");
		} else {
			System.out.println("Brak nie wczytana poprawnie");
			driver.quit();
		}
	}

	@When("Z górnej belki wybierz Urządzenia")
	public void clickDevices() {
		System.out.println("Wybranie menu Urządzenia");
		homePage.clickDevices();
	}

	@Then("Widoczna rozwijana lista")
	public void checkDevicesListDisplayed() {
		System.out.println("Sprawdzenie podmenu Urządzenia");
		if (!homePage.checkDevicesMenuIsVisible()) {
			System.out.println("Brak rozwijanej listy");
			driver.quit();
		}
	}

	@When("Kliknij {string} z kolumny {string}")
	public void clickDropDownElement(String string, String string2) {

		homePage.clickSubMenuElement(string, string2);
	}

	@Then("Widoczna lista smartwatchy")
	public void checkSmartphoneListDisplayed() {
		this.devicesPage = new DevicesPage(driver);
		devicesPage.checkDevicesPageHeader();
	}

	@When("Kliknij w pierwszy element z listy")
	public void clickFirstListElement() {
		devicesPage.clickFirstElement();
	}

	@Then("Widoczna strona produktu")
	public void checkProductPageDisplayed() {
		productPage = new ProductPage(driver);
		productPage.checkDevicesPageHeader();
	}

	double priceStartValue;
	double pricePerMonthValue;

	@And("Zapamiętaj kwoty {string} oraz {string}")
	public void rememberPrices(String string, String string2) {
		ProductPage productPage = new ProductPage(driver);
		priceStartValue = productPage.priceStartValue();
		pricePerMonthValue = productPage.pricePerMonthValue();
	}

	@When("Dodaj produkt do koszyka")
	public void clickAddToBasket() {
		ProductPage productPage = new ProductPage(driver);
		productPage.clickButtonAddToBasket();
	}

	@Then("Widoczna strona Twój koszyk.")
	public void checkBasketPageDisplayed() {
		BasketPage basketPage = new BasketPage(driver);
		basketPage.checkBasketPageHeader();
	}

	@And("Kwoty {string} oraz {string} zgadzają się z kwotami z poprzedniej strony.")
	public void checkPricesConsistent(String string, String string2) {
		BasketPage basketPage = new BasketPage(driver);
		basketPage.checkBasketPageHeader();

		double priceStartAtBasketValue = basketPage.priceStartValueAtBasket();
		double pricePerMonthAtBasketValue = basketPage.pricePerMonthValueAtBasket();

		System.out.print("Kwota " + string + " w koszyku, zgadza się z kwotą " + string + " na stronie produktu: ");
		System.out.println(priceStartValue == priceStartAtBasketValue);

		System.out.print("Kwota " + string2 + " w koszyku, zgadza się z kwotą " + string2 + " na stronie produktu: ");
		System.out.println(pricePerMonthValue == pricePerMonthAtBasketValue);
	}

	@When("Przejdź na stronę główną sklepu")
	public void goToHomepage() {
		homePage.goToPage();
	}

	@Then("Widoczna strona główna.")
	public void checkHomePageisDisplayed() {
		System.out.println("tytuł strony jest:" + driver.getTitle());
		System.out
				.println("tytuł strony powinien być: Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile");
		assertEquals(driver.getTitle(), "Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile");
	}

	@Then("W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku.")
	public void checkCartIconDisplayed() {
		if (homePage.numOfProductsInCartIsDisplayed()) {
			System.out.println("Liczba produktów w koszyku wyświetla się");
			driver.quit();
		}
		;
	}

}
