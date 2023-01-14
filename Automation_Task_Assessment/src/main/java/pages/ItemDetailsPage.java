package pages;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailsPage extends PageBase {

	public ItemDetailsPage(WebDriver driver) {
		super(driver);
	}

	// elements
	@FindBy(id = "submit.add-to-cart")
	public WebElement addToCartButton;

	//@FindBy(xpath = "/html/body/div[1]/div[21]/div/div/div/div[2]/div[3]/div/div[1]/div/div/div/a[2]")	
	//public WebElement element;
	
	@FindBy(id = "productTitle")
	public WebElement titleofSelectedItem;

	
	// methods
	public void clickOnaddToCartButton() {
		addToCartButton.click();
	}

	public void clickOnAnElement(WebElement element) {
		element.click();
	}

	public void waitAnElementUntillBeClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public void saveTitleToFile(WebElement elment)
	{
		try {
            FileWriter writer = new FileWriter("MyFile.txt", false);
            writer.write(getText(elment));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	}

}
