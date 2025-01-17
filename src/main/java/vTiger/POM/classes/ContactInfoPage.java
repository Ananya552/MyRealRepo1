package vTiger.POM.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;

	public ContactInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getcontactHeader() {
	return contactHeader;
	}

	public String ContactHeaderText() {
		return contactHeader.getText();
	}
}
