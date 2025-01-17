package vTiger.POM.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//DECLARATION	
		@FindBy(name = "user_name")
		private WebElement userNameEdt;

		@FindBy(name = "user_password")
		private WebElement passwordEdt;

		@FindBy(id = "submitButton")
		private WebElement loginBtn;

	//INIALISATION
		public LoginPage(WebDriver d) {
			PageFactory.initElements(d, this);
		}

	//UTILISATION
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}

	//BUSINESS LIBRARY
		/**
		 * THIS METHOD WILL LOGIN TO THE APPLICATION
		 * @param USERNAME
		 * @param PASSWORD
		 */

		public void loginToApp(String USERNAME, String PASSWORD) {
			userNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}

	
}
