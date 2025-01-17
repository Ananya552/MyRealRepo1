package vTiger.POM.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Generic.Utilities.WebDriverUtility2;

public class HomePage extends WebDriverUtility2 {
	//DECLARATION
	@FindBy(xpath = "//td[@align='center']/a[text()='Organizations']")
	private WebElement organizationsLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//INITIALIZATION
	public HomePage(WebDriver d)
	{
		PageFactory.initElements(d,this);
	}
	//UTILIZATION
	public WebElement getorganizationsLink() {
		return organizationsLink;
	}
	public WebElement getcontactsLink() {
		return contactsLink;
	}
	public WebElement getproductsLink() {
		return productsLink;
	}
	public WebElement getadministratorImg() {
		return administratorImg;
	}
	public WebElement getsignOutLink() {
		return signOutLink;
	}
	//BUSINESS LIBRARY
	/**
	 * THIS METHOD WILL CLICK ON THE ORGANISATIONS LINK.
	 */
	public void clickOnOrganisations() {
		organizationsLink.click();
	}
	/**
	 * 
	 */
	public void clickOnContact() {
		contactsLink.click();
	}
	public void logOut(WebDriver d) throws Throwable {
		mouseHoverAction(d,administratorImg);
		Thread.sleep(1000);
		signOutLink.click();
	}
}
