package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.BaseClass;
import designPattern.LoginWithPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginforCustomer extends BaseClass{
	LoginWithPOM login;
	@Given("customer access to website")
	public void customer_access_to_website() {
	    Initialization();
	}

	@When("customer click login")
	public void customer_click_login() {
		login=new LoginWithPOM();
		login.click_on_CustomerLoginButton();
	}

	@When("select a name and click login button")
	public void select_a_name_and_click_login_button() {
	  login=new LoginWithPOM();
	  login.select_name_and_login();
	}

	@When("make a deposit {int} and withdraw {int} confirm on balance")
	public void make_a_deposit_and_withdraw_confirm_on_balance(Integer deposit, Integer withdraw) throws InterruptedException {
		 login=new LoginWithPOM();
		 login.makeA_DepositAnd_Withdraw(deposit, withdraw);
		 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")));
		 Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText(),"600");
		 
	}


	@When("click transaction button and show result")
	public void click_transaction_button_and_show_result() {
	 login= new LoginWithPOM();
	 login.click_on_transaction();
	}

	@When("confirmation about transaction type of withdraw")
	public void confirmation_about_transaction_type_of_withdraw() {
	 String type_of_withdraw="Debit";
	 String withdraw_actualResult=driver.findElement(By.xpath("//*[@id=\"anchor1\"]/td[3]")).getText();
	 Assert.assertEquals(withdraw_actualResult,type_of_withdraw);
	}

	@Then ("after all the successful processes, will close the browser")
	public void CloseBrowser() {
		login= new LoginWithPOM();
		login.close_Browser();
	}

}
