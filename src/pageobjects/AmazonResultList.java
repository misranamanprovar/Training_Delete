package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page(title = "AmazonResultList", summary = "", relativeUrl = "", connection = "AmazonConnection")
public class AmazonResultList {

	@FindBy(xpath = "(//span[@class='a-truncate-full a-offscreen'])[2]/following-sibling::span")
	public WebElement horizontalItem1;
	@LinkType()
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	public WebElement verticalItem1;

}
