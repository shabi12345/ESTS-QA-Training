package Page_Object_Model;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener{

	public void onTestFailture(ITestResult result) throws IOException {
		Object currentClass= result.getInstance();
		//WebDriver driver = ((Login_Page) currentClass).getDriver();
		WebDriver driver = ((Add_Employee) currentClass).getDriver();
		if (driver != null)
		{
			String methdoName=result.getName();
			new Base_Class_Wrapper(driver).takeScreenshot(methdoName+ "Failture");
		}
	}
}
	