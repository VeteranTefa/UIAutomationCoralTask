package basePackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static String URL="https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
	
	@SuppressWarnings("deprecation")
	public void Initialization() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}

}
