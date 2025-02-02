package Page_Object_Model;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v128.page.Page.CaptureScreenshotFormat;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class Tests {
	private WebDriver driver;
	private Base_Class_Wrapper LoginWrapper;
    private Login_Page loginpage;	
    private Search_Page Search;
    private Add_Employee Employee;
	
    @BeforeClass
	public void OpenBrowser() throws IOException {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LoginWrapper = new Base_Class_Wrapper(driver);
        loginpage = new Login_Page(driver);
        Search = new Search_Page(driver);
        LoginWrapper.openurl("https://opensource-demo.orangehrmlive.com/");
        Employee = new Add_Employee(driver);
	}
	
//	@Test
//	public void Login_tescase() {
//		
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		loginpage.enterUsername("Admin");
//		loginpage.enterPassword("admin123");
//		loginpage.ClickButton();
//	}
	
	
//	@Test
//	   public void Search_TestCase() {
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		loginpage.enterUsername("Admin");
//		loginpage.enterPassword("admin123");
//		loginpage.ClickButton();
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			Search.SearchText("Admin");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			Search.SearchFilter_Click();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			Search.Search_text("David");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			Search.SearchButton_Click();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	
//	
	

	//*[@id="oxd-toaster_1"]
	
	@Test
	   public void Add_Employee_PIM() throws InterruptedException {
	
		 for (String[] row : LoginWrapper.getTestData()) {
	            String username = row[0];
	            String password = row[1];
			loginpage.enterUsername(username);
			loginpage.enterPassword(password);
			loginpage.ClickButton();
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Employee.Navigation_PimBtn();
		
			Employee.Navigation_Add_EmployeeBtn();
			Employee.Add_Employee_FirstName("Shosbur");
			Employee.Add_Employee_LastName("Tasneem980");
			Employee.Add_Employee_ID("20149");
			Employee.Employee_details_toggle(true);
			Employee.Employee_UserName("shosh70");
			String valueToSelect = "Enabled";
			Employee.Employee_Status(valueToSelect);
			Employee.Employee_Password("shosh12345");
			Employee.Employee_ConfirmPassword("shosh12345");	
			
			Thread.sleep(4000);
			Employee.Employee_SaveBtn();
			String GetText = Employee.Success_Screen();
			try {
			Assert.assertEquals(GetText, "Success Successfully" , "Test Case Passed");
		}
			catch (AssertionError e)
			{
				LoginWrapper.takeScreenshot("Add Employe Case Failture");
			throw e;
	}

		 }	
	}
		
	

	
	
	@AfterClass
	public void CloseBrowser()
	{
		//driver.close();
	}	
}
