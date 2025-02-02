package Page_Object_Model;
import org.apache.poi.ss.usermodel.*;
import java.time.Duration;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ExcelUtils;
public class Base_Class_Wrapper {

	private WebDriver driver;
	private WebDriverWait wait;
	private Random random;
	private Workbook workbook;
	private ExcelUtils excelUtil;
	private List<String[]> testData;
	
	public Base_Class_Wrapper(WebDriver driver) throws IOException{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.random = new Random();
		String filePath = "C:\\Users\\MuhammadShoaib1\\Documents\\Data_info.xlsx";
		String sheetName = "UserData";
		    // Initialize Excel utility and load test data
		    excelUtil = new ExcelUtils(filePath);
		    testData = excelUtil.getDataFromSheet(sheetName);
	}
	
    protected List<String[]> getTestData() {
        return testData;
    }
	
	public void openurl(String url) {
		driver.get(url);
	}
	
	protected WebElement WaitForVisibility(By locator)
	{
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
 	
	
	protected List <WebElement> waitWebElements(By locator)
	{
		

		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}	
	protected boolean WaitForElements(By locator)
	{
	
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	 return true;
	}
	
	
	public void enterText(By locator,  String text) {
	//waitForVisibility(element);
	WebElement element = WaitForVisibility(locator);
	element.clear();
	element.sendKeys(text);
	}
	
	public void ClickButton(By locator) {
		WebElement element = WaitForVisibility(locator);
		element.click();
	}
	
	
	public String GetElementText(By locator) {
		WebElement element = WaitForVisibility(locator);
		return element.getText();
	}


	
	 public void selectByVisibleText(WebElement dropdown_element, String Visible_Text) {
		 
		 Select dropdown = new Select(dropdown_element);
		 dropdown.selectByVisibleText(Visible_Text);
		 
	 }
	 
 public void selectByValue(WebElement dropdown_element, String Value) {
		 
		 Select dropdown = new Select(dropdown_element);
		 dropdown.selectByValue(Value);
		 
	 }
 
 public void selectByIndex(WebElement dropdown_element, int index) {
	 
	 Select dropdown = new Select(dropdown_element);
	 dropdown.selectByIndex(index);
	 
 }
 
 public void selectedRadioButton(By locator, String value) {
	    // Wait for the elements to be visible
	    List<WebElement> radiobuttons = waitWebElements(locator);
	    boolean isSelected = true;

	    // Iterate through the radio buttons
	    for (WebElement radiobutton : radiobuttons) {
	        String radioButtonValue = radiobutton.getAttribute("value");
	        
	        // Check for null to avoid NullPointerException
	        if (radioButtonValue != null && radioButtonValue.equalsIgnoreCase(value)) {
	            if (!radiobutton.isSelected()) {
	                radiobutton.click();
	            }
	            isSelected = true;
	            break;
	        }
	    }

	    // If no radio button is selected, throw an exception
	    if (!isSelected) {
	        throw new RuntimeException("Radio button with value '" + value + "' not found or has no 'value' attribute.");
	    }
	}


 public void toggleCheckbox(By locator, boolean shouldbcheck)
 {
	 WebElement checkbox = WaitForVisibility(locator);
	 if(checkbox.isSelected() != shouldbcheck) {
		 checkbox.click();
	 }
	 
 }
 
 public void SelectDate(By locator, String Date)
 {
	 
	 WebElement dateField = WaitForVisibility(locator);
	 dateField.clear();
 }
 
 public int GetRandonNumber(int min, int max)
 {
	 return random.nextInt((max - min)+ 1) + min;
 }
 
 
 //Get all rows in a Table
 protected List <WebElement> getTableRows (By tablelocator)
 {
	 WebElement table = WaitForVisibility (tablelocator);
	 return table.findElements(By.tagName("tr"));	 
 }
 
 
 // Get all cells of specific row in a Table
 protected List <WebElement> getTableCols (WebElement row)
 {
	
	 return row.findElements(By.tagName("td"));	 
 }
 
 //Get all items from List
 protected List <WebElement> getListItems (By tablelocator)
 {
	 WebElement list = WaitForVisibility (tablelocator);
	 return list.findElements(By.tagName("li"));	 
 }
 
 public void uploadpicture (By locator, String filepath)
 {
	 WebElement fileinput = WaitForVisibility(locator);
	 fileinput.sendKeys(filepath);
	 
 }
 
 protected void takeScreenshot (String screenshotName)
 {
	 
	 File screenshotDir = new File ("Screenshots");
	 if(!screenshotDir.exists())
		 screenshotDir.mkdir();
	 TakesScreenshot sreenshotScreenshot = (TakesScreenshot) driver;
	 File ScrenshotFileLocation =  sreenshotScreenshot.getScreenshotAs(OutputType.FILE);
	
	 String DestionanPath = "Screenshots/" +screenshotName+ "_" +".png";
	 File desitionanFile = new File(DestionanPath);

	 try {
		FileHandler.copy(ScrenshotFileLocation, desitionanFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			 
	 System.out.println("Screenshot Saved to" +DestionanPath);
			 
 }
}
