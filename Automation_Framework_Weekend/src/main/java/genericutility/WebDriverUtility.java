package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/**
	 * It is used to maximize the window
	 * @param driver
	 */

	public void maxmize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * It is used capture height and width
	 * @param driver
	 */
	
	public void captureSize(WebDriver driver) {
		driver.manage().window().getSize();
	}
	
	
	/**
	 * Used to perform mouse over on the element
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
	act.moveToElement(element).perform();	
	}
	
	/**
	 * Used to click and hold on element
	 * @param driver
	 * @param element
	 */
	public void clickHold(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * Used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void selectDropDownByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectDropDownByVisibleText(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectDropDownByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchBackToHome(WebDriver driver, WebElement frameElement) {
		driver.switchTo().defaultContent();
	}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void takeScreenshot(WebDriver driver) throws IOException {
		JavaUtility jutil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+jutil.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
		
	}
}
