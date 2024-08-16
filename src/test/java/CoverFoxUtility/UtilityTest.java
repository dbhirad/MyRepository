package CoverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class UtilityTest {

	// excelData
	// screenSHot
	// click
	// scroll
	// wait-->implicit

	// scroll to the particular element
	public static void scrollIntoViewElement(WebDriver driver, WebElement element)

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	// take screenshot
	public static void getScreenShot(WebDriver driver, String FileName) throws IOException

	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\HP\\Desktop\\Selenium\\Self-Study\\" + FileName + ".png");
		FileHandler.copy(src, dest);
	}

	// take screenshot
	public static void getScreenShotForMaven(WebDriver driver, String filePath,String FileName) throws IOException

	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath + FileName + ".png");
		System.out.println(filePath);
		FileHandler.copy(src, dest);
	}

	// read excel data
	public static String getExcelData(String filePath, String SheetName, int row, int cell)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		FileInputStream fi = new FileInputStream(filePath);
		Cell c = WorkbookFactory.create(fi).getSheet(SheetName).getRow(row).getCell(cell);
		String cellvalue = c.getStringCellValue();

		return cellvalue;
	}

	// add sleep time
	public static void getWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(seconds));
	}

	// scroll and click
	public static void clickElement(WebDriver driver, WebElement element) {
		scrollIntoViewElement(driver, element);
		element.click();
	}

	// reading data from properties file
	public static String readDataFromPeroperties(String key) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\coverFoxTest.properties";
		FileInputStream file = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}

}
