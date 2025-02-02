package Page_Object_Model;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	private Base_Class_Wrapper selenium;

	public Login_Page(WebDriver driver) throws IOException
		{
		
		this.selenium = new Base_Class_Wrapper(driver);
		PageFactory.initElements(driver, this);
		}
	
	
//	@FindBy(name = "username")
//	private WebElement username;
//	
//	@FindBy(name = "password")
//	private WebElement Password;
//	
//	@FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement click_btn;
	
	public void enterUsername(String Username)
	{
		selenium.enterText(Locators.UserName_Field.getLocator(), Username);
		
		//selenium.enterText(username, Username);
	}
	
	
	public void enterPassword(String password)
	{
		selenium.enterText(Locators.Password_Field.getLocator(), password);
	}
	
	public void ClickButton()
	{
		selenium.ClickButton(Locators.Login_Button.getLocator());
	}
	
	
}
