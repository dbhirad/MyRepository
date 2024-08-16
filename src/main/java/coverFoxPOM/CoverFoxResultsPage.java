package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultsPage {
	// members
	@FindBy(xpath = "//div[contains(text(),'Health Insurance Plans')]")
	private WebElement text;
	@FindBy(xpath = "//div[@id='plans-list']")
	private List<WebElement> noOfBanners;
	@FindBy(xpath="//div[@class='f-select']") private WebElement sortPlanDropdown;

	// constructor
	public CoverFoxResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void validateBanners() {
		String ar[] = text.getText().split(" ");
		int stringConvertedInt = Integer.parseInt(ar[0]);
		int totalbanners = noOfBanners.size();

		if (stringConvertedInt == totalbanners) {
			System.out.println("Test case passed ,No Of banners matched with text");
		} else {
			System.out.println("Test Case failed,No Of banners not matched with text");
		}
	}

	public int getTotalBanners() {
		int totalBanners = noOfBanners.size();
		return totalBanners;
	}

	public int getTextOnHomePage() {
		String ar[] = text.getText().split(" ");
		int stringConvertedInt = Integer.parseInt(ar[0]);
		return stringConvertedInt;
	}
	
	public boolean sortPlanDropdownIsDisplayed()
	{
		boolean result = sortPlanDropdown.isDisplayed();
		return result;
	}

}