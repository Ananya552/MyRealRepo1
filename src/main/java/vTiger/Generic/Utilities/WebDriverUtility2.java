package vTiger.Generic.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Ananya THIS CLASS CONSISTS OF UTILITY METHODS RELATED TO WEBDRIVER.
 */
public class WebDriverUtility2 {
	
	/**
	 * THIS METHOD WILL MAXIMIZE THE SCREEN.
	 * @param d
	 */
	public void maximizeWindow(WebDriver d) {
		d.manage().window().maximize();
	}
    /**
	 * THIS METHOD WILL MINIMIZE THE SCREEN.
	 * @param d
	 */
	public void minimizeWindow(WebDriver d) {
		d.manage().window().minimize();
	}
	/**
	 * THIS METHOD WILL OPEN THE WINDOW IN FULLSCREEN MODE.
	 * @param d
	 */
	public void fullScreenWindow(WebDriver d) {
		d.manage().window().fullscreen();
	}
	/**
	 * THIS METHOD WILL WAIT FOR THE SPECIFIED TIME DURATION FOR ALL THE WEBELEMENTS
	 * TO GET LOADED.
	 * @param d
	 */
	public void waitForPageLoading(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * THIS METHOD WILL WAIT FOR THE SPECIFIED TIME DURATION FOR THE ELEMENT TO BE
	 * VISIBLE.
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
    /**
	 * THIS METHOD WILL WAIT FOR THE SPECIFIED TIME DURATION FOR THE
	 * ELEMENT TO BE CLICKABLE.
	 */
	public void waitForElementToBeClickable(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * THIS METHOD WILL HANDLE A DROPDOWN USING INDEX.
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * THIS METHOD WILL HANDLE A DROPDOWN USING VALUE.
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * THIS METHOD WILL HANDLE A DROPDOWN USING VISIBLETEXT.
	 * @param visibleText
	 * @param element
	 */
	public void handleDropdown(String visibleText, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * THIS METHOD WILL MOUSE HOVER ON A SPECIFIC ELEMENT ON THE WEB PAGE. 
	 * @param d
	 * @param element
	 */
	public void mouseHoverAction(WebDriver d, WebElement element) {
		Actions act = new Actions(d);
		act.moveToElement(element).perform();
	}
	/**
	 * THIS METHOD WILL RIGHT-CLICK ANYWHERE ON THE WEB PAGE. 
	 * @param d
	 */
	public void rightClick(WebDriver d) {
		Actions act = new Actions(d);
		act.contextClick().perform();
	}

	/**
	 * THIS METHOD WILL RIGHT-CLICK ON A PARTICULAR ELEMENT ON THE WEB PAGE.
	 * @param d
	 * @param element
	 */
	public void rightClick(WebDriver d, WebElement element) {
		Actions act = new Actions(d);
		act.contextClick(element).perform();
	}
	/**
	 * THIS METHOD WILL DOUBLE-CLICK ANYWHERE ON THE WEB PAGE.
	 * @param d
	 */
	public void doubleClick(WebDriver d) {
		Actions act = new Actions(d);
		act.doubleClick().perform();
	}
	/**
	 * THIS METHOD WILL DOUBLE-CLICK ON A PARTICULAR ELEMENT ON THE WEB PAGE.
	 * @param d
	 * @param element
	 */
	public void doubleClick(WebDriver d, WebElement element) {
		Actions act = new Actions(d);
		act.doubleClick(element).perform();
	}
	/**
	 * THIS METHOD WILL DO DRAG AND DROP ACTION FOR THE WEB ELEMENTS GIVEN.
	 * @param d
	 * @param drag
	 * @param drop
	 */
	public void dragAndDrop(WebDriver d, WebElement drag, WebElement drop) {
		Actions act = new Actions(d);
		act.dragAndDrop(drag, drop).perform();
	}

	/**
	 * THIS METHOD WILL MOVE THE CURSOR BY THE GIVEN OFFSET AND CLICK.
	 * @param d
	 * @param x
	 * @param y
	 */
	public void moveTheCursorandClick(WebDriver d, int x, int y) {
		Actions act = new Actions(d);
		act.moveByOffset(x, y).click().build().perform();
	}
/**
 * THIS METHOD WILL SCROLL DOWN THE WINDOW BY 500 UNITS.
 * @param d
 */
	public void scrollAction(WebDriver d) {
		JavascriptExecutor jse = (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,500)");
	}
/**
 * THIS METHOD WILL SCROLL DOWN UNTIL A PARTICULAR WEB ELEMENT. 
 * @param d
 * @param element
 */
	public void scrollAction(WebDriver d, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) d;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
   /**
    * THIS METHOD WILL CLICK THE GIVEN WEB ELEMENT.
    * @param element
    * @param d
    */
	public void clickAnElement(WebElement element, WebDriver d) {
		JavascriptExecutor jse = (JavascriptExecutor) d;
		jse.executeScript("arguments[0].click();",element);
	}
	/**
	 * THIS METHOD WILL ACCEPT AN ALERT POP-UP.
	 * @param d
	 */
	public void acceptAlert(WebDriver d) {
		d.switchTo().alert().accept();
	}
	/**
	 * THIS METHOD WILL DISMISS AN ALERT POP-UP.
	 * @param d
	 */
	public void dismissAlert(WebDriver d) {
		d.switchTo().alert().dismiss();
	}
	/**
	 * THIS METHOD WILL GET THE TEXT OF AN ALERT POP-UP.
	 * @param d
	 * @return
	 */
	public String getAlertText(WebDriver d) {
		return d.switchTo().alert().getText();
	}
	/**
	 * THIS METHOD WILL SWITCH TO A PARTICULAR FRAME USING INDEX.
	 * @param d
	 * @param index
	 */
	public void switchToFrame(WebDriver d, int index) {
		d.switchTo().frame(index);
	}
	/**
	 * THIS METHOD WILL SWITCH TO A PARTICULAR FRAME USING NAME OR ID.
	 * @param d
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver d,String nameOrID) {
		d.switchTo().frame(nameOrID);
		}
	/**
	 * THIS METHOD WILL SWITCH TO A PARTICULAR FRAME USING A GIVEN WEB ELEMENT.
	 * @param d
	 * @param element
	 */
	public void switchToFrame(WebDriver d,WebElement element) {
		d.switchTo().frame(element);
	}
	/**
	 * THIS METHOD WILL SWITCH TO THE IMMEDIATE PARENT FRAME.
	 * @param d
	 */
	public void switchToParentFrame(WebDriver d) {
		d.switchTo().parentFrame();
	}
	/**
	 * THIS METHOD WILL SWITCH TO THE DEFAULT FRAME.
	 * @param d
	 */
	public void switchToDefaultContent(WebDriver d) {
		d.switchTo().defaultContent();
	}
	/**
	 * THIS METHOD WILL SWITCH THE DRIVER CONTROL FROM ONE WINDOW TO ANOTHER.
	 * @param d
	 */
	public void switchToWindow(WebDriver d,String partialWinTitle) {
		Set<String> winIDs = d.getWindowHandles();
		for (String ID : winIDs) {
			String title= d.switchTo().window(ID).getTitle();
			if (title.contains(partialWinTitle)) {
				d.switchTo().window(ID);
			}
		}
	}
	/**
	 * THIS METHOD WILL CAPTURE SCREENSHOT AND STORE IT IN A FOLDER.
	 * @param d
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String captureScreenshot(WebDriver d, String screenShotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots1\\"+screenShotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();//USED FOR EXTENT REPORTING
	}
	
}
