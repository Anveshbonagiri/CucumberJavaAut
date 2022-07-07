package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialTable) {
		List<Map<String, String>> credList = credentialTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		System.out.println("Accounts Page Title: " + accountsPage.getAccountsPageTitle());
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expectedSections = sectionsTable.asList();
		System.out.println("Expected Accounts Section list: " + expectedSections);
		List<String> actualAccountSections = accountsPage.getAccountsSectionList();
		System.out.println("Actual Sections List: " + actualAccountSections);
		Assert.assertTrue(expectedSections.containsAll(actualAccountSections));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedAccounts) {
		Assert.assertTrue(expectedAccounts == accountsPage.getAccountsSectionCount());
	}
}
