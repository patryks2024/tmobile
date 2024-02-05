package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	protected WebDriver driver = null;

	public Browser(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver openAndMaximizeBrowser() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public boolean checkBrowserIsOpened() {
		int openBrowserCount = driver.getWindowHandles().size();

		if (openBrowserCount > 0)
			return true;
		else
			return false;
	}
}
