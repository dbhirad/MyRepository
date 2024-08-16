package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHomePage {
	
	//https://www.coverfox.com/
	//suing encapsulation as data members are private and methods are public
	
	//variables
	@FindBy(xpath="//button[@title='Get Started']") private WebElement Get_Started_Btn;
	
	//constructor
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void clickOnGetStarted()
	{
		Get_Started_Btn.click();
	}
	
	//1.complete this 4 page for cover fox which sir have added
	//2.ask homework of coverfox 
	//practice swaglabb addtocart example using common methods or normally as practiced for coverfoxTC

}