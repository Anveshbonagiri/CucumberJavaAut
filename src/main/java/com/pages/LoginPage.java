package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// By locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotpwdLink = By.linkText("Forgot your password?");

	// constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Page Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public Boolean isForgotpwdLinkExist() {
		return driver.findElement(forgotpwdLink).isDisplayed();
	}

	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}

	public void enterUserPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public AccountsPage doLogin(String userName, String pwd) {
		System.out.println("Login with UName: " + userName + " and pwd: " + pwd);
		driver.findElement(emailId).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}

}
