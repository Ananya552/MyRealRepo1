package vTiger.POM.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
    private WebElement createOrgLookUpImg;
	
	 public OrganisationsPage(WebDriver d) {
		 PageFactory.initElements(d,this);
	 }
	 
	 public WebElement getcreateOrgLookUpImg() {
		 return createOrgLookUpImg;
	 }
	 
	 public void clickOnOrgLookUpImg() {
			createOrgLookUpImg.click();
		}
}
