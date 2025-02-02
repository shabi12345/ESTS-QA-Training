package Page_Object_Model;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Add_Employee {
	private Base_Class_Wrapper selenium;
//	private final By locator;
	
	
	private WebDriver driver;
	public Add_Employee(WebDriver driver) throws IOException
		{
		
		this.selenium = new Base_Class_Wrapper(driver);
		PageFactory.initElements(driver, this);
		}
	
	
	public WebDriver getDriver()

	{
		return driver;
	}
	public void Navigation_PimBtn()
	{
		selenium.ClickButton(Locators.PIM_Button.getLocator());
	}
	
	
	public void Navigation_Add_EmployeeBtn()
	{
		selenium.ClickButton(Locators.Add_EmployeeButton.getLocator());
	}
	
	public void Add_Employee_FirstName(String firstName)
	{
		selenium.enterText(Locators.FirstName_Field.getLocator(), firstName);
	}
	

	public void Add_Employee_LastName(String lastName)
	{
		selenium.enterText(Locators.lastName_Field.getLocator(), lastName);
	}
	public void Add_Employee_ID(String EmpID)
	{
		selenium.enterText(Locators.Employee_id.getLocator(), EmpID);
	}
	
	public void Employee_details_toggle(Boolean bool)
	{
		selenium.toggleCheckbox(Locators.login_details_toggle.getLocator(), bool);
	}
	
	public void Employee_UserName(String Username)
	{
		selenium.enterText(Locators.UserName.getLocator(), Username);
	}
	
	public void Employee_Status(String radio_value)
	{
		selenium.selectedRadioButton(Locators.Status_radio.getLocator(), radio_value);
	}
	
	public void Employee_Password(String Password)
	{
		selenium.enterText(Locators.Password.getLocator(), Password);
	}
	
	public void Employee_ConfirmPassword(String ConfirmPassword)
	{
		selenium.enterText(Locators.ConfirmPassword.getLocator(), ConfirmPassword);
	}
	
	public void Employee_SaveBtn()
	{
		selenium.ClickButton(Locators.SaveButton.getLocator());
	}
	
	public String Success_Screen()
	{
		return selenium.GetElementText(Locators.Success_Msg.getLocator());
	}
	
}

