package pageobjects;

import java.util.*;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page(title = "AmazonProductView", summary = "", relativeUrl = "", connection = "AmazonConnection")
public class AmazonProductView {

	WebDriver driver;

	@TestLogger
	public Logger testLogger;

	public AmazonProductView(WebDriver driver) {
		this.driver = driver;
	}

	@TextType()
	@FindBy(xpath = "//td[text()='M.R.P.:']/following-sibling::td//span[1]")
	public WebElement mrp;

	@TextType()
	@FindBy(xpath = "//td[text()='Price:']/following-sibling::td/span[1]")
	public WebElement price;

	/*----------All Methods Start--------*/
	public void closeAllTabs() {

		String currentWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		for (String win : handles) {

			if (!win.equals(currentWindow)) {

				testLogger.info(win + "   " + currentWindow);

				driver.switchTo().window(win);
				driver.close();
			}

		}

		driver.switchTo().window(currentWindow);
	}

	/*----------All Methods Ends--------*/
}
