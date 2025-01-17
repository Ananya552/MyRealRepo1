package vTiger.POM.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
@FindBy(css = "[title='Create Contact...']")
private WebElement createContactLookUpImg;
 
public ContactsPage(WebDriver d) {
	PageFactory.initElements(d,this);
}
public WebElement getcreateContactLookUpImg() {
	return createContactLookUpImg;
}

public void clickOnCreateContact() {
	createContactLookUpImg.click();
}


}
