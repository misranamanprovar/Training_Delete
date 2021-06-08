package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page(title = "AmazonHome", summary = "", relativeUrl = "", connection = "AmazonConnection")
public class AmazonHome {

	WebDriver driver;

	public AmazonHome(WebDriver driver) {

		this.driver = driver;
	}

	@TextType()
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	public WebElement globalSerach;

	@ButtonType()
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	public WebElement globalSearchBtn;

	/*-------All Methods Start-------*/
	public void gotTo_HorizontalMenu(String category) {

		driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]")).click();

	}
}
