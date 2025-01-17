package vTiger.POM.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Generic.Utilities.WebDriverUtility2;

public class CreateNewContactPage extends WebDriverUtility2 {
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement orgLookUpImg;
	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	public CreateNewContactPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getlastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getsaveBtn() {
		return saveBtn;
	}

	public WebElement getorgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getorgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getorgSearchBtn() {
		return orgSearchBtn;
	}
	/**
	 * THIS METHOD WILL CREATE A NEW CONTACT WITH MANDATORY FIELDS.
	 * @param LastName
	 */
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	/**
	 * THIS METHOD WILL CREATE A NEW CONTACT WITH ORGANISATION NAME.
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param d
	 */
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver d) {
		lastNameEdt.sendKeys(LASTNAME);	
		orgLookUpImg.click();
		switchToWindow(d,"Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
        d.findElement(By.xpath("//a[.='"+ ORGNAME + "']")).click();
        switchToWindow(d,"Contacts");
        saveBtn.click();
        
	}

}
