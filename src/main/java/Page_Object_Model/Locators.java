package Page_Object_Model;

import org.openqa.selenium.By;

public enum Locators {

	
	UserName_Field(By.name("username")),
	Password_Field(By.name("password")),	
	Login_Button(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")),
	PIM_Button(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")),
	Add_EmployeeButton(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")),
	FirstName_Field(By.name("firstName")),
	lastName_Field(By.name("lastName")),
	Employee_id(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")),
	login_details_toggle(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")),
	UserName (By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")),
	Status_radio(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]")),
	Password(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")),
	ConfirmPassword(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")),
	SaveButton(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")),
	Success_Msg (By.xpath("	//*[@id=\"oxd-toaster_1\"]"));
	private final By locator;
	Locators (By locator){
		this.locator = locator;
	}
	
	public By getLocator() {
		return this.locator;
	}
}

