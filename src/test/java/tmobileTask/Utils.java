package tmobileTask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	static int time = 10;

	private static WebDriverWait setWait(WebDriver driver) {

		return new WebDriverWait(driver, Duration.ofSeconds(time));
	}

	public static WebElement waitForElement(WebDriver driver, By by) {
		try {
			WebElement webElement = setWait(driver).until(ExpectedConditions.visibilityOfElementLocated(by));
			return webElement;
		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
			System.exit(1);
		}

		return null;
	}
}
