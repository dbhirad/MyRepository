package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemberDetailsPage {

	//members
	@FindBy(id="Age-You") private WebElement ageDropDown;
	@FindBy(xpath="//div[text()='Next']") private WebElement nextBtn;
	
	//constructors
	public CoverFoxMemberDetailsPage(WebDriver driver)
	{
		//initializing data members and they are global so using this
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void selectAgeDropDown(String age)
	{
		Select s= new Select(ageDropDown);
		s.selectByValue(age+"y");
	}
	
	public void clickOnNextBtn()
	{
		nextBtn.click();
	}
	
}
