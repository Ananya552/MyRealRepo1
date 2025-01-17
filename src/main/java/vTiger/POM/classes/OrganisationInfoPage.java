package vTiger.POM.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement orgHeader;

public OrganisationInfoPage(WebDriver d ) {
	PageFactory.initElements(d,this);
}
public WebElement getorgHeader() {
	return orgHeader;
}
public String orgHeaderText() {
	return orgHeader.getText();
}
}
