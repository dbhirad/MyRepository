package coverFoxBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class BaseClass {
	
	protected WebDriver driver;
	public void launchBrowser()
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver=new ChromeDriver(opt);
		driver.get("https://www.coverfox.com/");
		Reporter.log("Launchig the browser",true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}
	
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		Reporter.log("Closing the browser",true);
		driver.close();
		
	}

}
