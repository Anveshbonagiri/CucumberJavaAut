package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

	private By accountsSection = By.cssSelector("div#center_column span");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getAccountsSectionCount() {
		return driver.findElements(accountsSection).size();
	}

	public List<String> getAccountsSectionList() {
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountsSection);
		for (WebElement e : accountsHeaderList) {
			System.out.println(e.getText());
			accountsList.add(e.getText());
		}
		return accountsList;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
}
