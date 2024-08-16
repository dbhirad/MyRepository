package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxAddressDetailsPage {

	// members
	@FindBy(xpath = "(//input[@type='number'])[1]")
	private WebElement pinCodeField;
	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement mobileNoField;
	@FindBy(xpath = "//div[@class='next-btn']")
	private WebElement continueBtn;
	@FindBy(xpath = "//div[@class='error-ui']")
	private WebElement pinCodeMsg;
	@FindBy(xpath = "//div[text()=' Please enter a valid mobile no. ']")
	private WebElement mobNoMsg;

	// constructor
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void enterPinCode(String pinCode) {
		pinCodeField.sendKeys(pinCode);
	}

	public void enterMobileNumber(String mobileNo) {
		mobileNoField.sendKeys(mobileNo);
	}

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

	public String getPinCodetext()
	{
		String pinCodetext = pinCodeMsg.getText();
		return pinCodetext;
	}
	
	public String getMobNoText()
	{
		String mobNotext = mobNoMsg.getText();
		return mobNotext;
	}
	
	//Extra method
	public void clearPinCode()
	{
		pinCodeField.clear();
	}

}
