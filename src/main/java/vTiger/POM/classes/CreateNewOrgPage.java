package vTiger.POM.classes;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Generic.Utilities.WebDriverUtility2;

public class CreateNewOrgPage extends WebDriverUtility2 {

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewOrgPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getorgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getindustryDropDown() {
		return industryDropDown;
	}

	public WebElement getsaveBtn() {
		return saveBtn;
	}

	public void createNewOrg(String ORGNAME) {
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	public void createNewOrgWithInd(String ORGNAME, String INDUSTRYTYPE) {
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown,INDUSTRYTYPE);
		saveBtn.click();
	}
}
