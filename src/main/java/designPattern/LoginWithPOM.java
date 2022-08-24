package designPattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseClass;
import dev.failsafe.internal.util.Assert;

public class LoginWithPOM extends BaseClass{
	
	public LoginWithPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='Customer Login']")
	WebElement customerLogin;
	public void click_on_CustomerLoginButton() {
		customerLogin.click();
	}
	@FindBy(name = "userSelect")
	WebElement selectOption;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/form/button")
	WebElement loginClick;
	public void select_name_and_login() {
		Select names = new Select(selectOption);
		names.selectByValue("4");
		loginClick.click();
		
	}	
	
	@FindBy(css = "body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(2)")
	WebElement depositClick;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
	WebElement deposit;
	@FindBy(xpath = "//*[text()='Deposit']")
	WebElement make_deposit;
	@FindBy(css ="body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(3)")
	WebElement withdrawClick;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
	WebElement withdraw;
	@FindBy(xpath = "//*[text()='Withdraw']")
	WebElement make_withdraw;
	
	public void makeA_DepositAnd_Withdraw(Integer deposit , Integer withdraw) throws InterruptedException  {
		
		depositClick.click();
		this.deposit.sendKeys(deposit.toString());
		this.make_deposit.click();
		Thread.sleep(2000);
		withdrawClick.click();
		Thread.sleep(2000);
		this.withdraw.sendKeys(withdraw.toString());
		this.make_withdraw.click();
		
		
	}
	
	@FindBy(css="body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(1)")
	WebElement transaction;
	public void click_on_transaction() {
		transaction.click();
	}
	
	public void close_Browser() {
		driver.quit();
	}
	

}
