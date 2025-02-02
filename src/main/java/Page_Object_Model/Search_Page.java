package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page {

	private Base_Class_Wrapper selenium;
	private WebDriver driver;

	public Search_Page(WebDriver driver)
		{
		
		this.selenium = new Base_Class_Wrapper(driver);
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")
	private WebElement searchtext;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a")
	private WebElement searchFilter;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	private WebElement enter_text;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	private WebElement search_btn;
	
	
	public void SearchText(String Search_text) {
		selenium.enterText(this.searchtext, Search_text);	
	}
	
	
	public void SearchFilter_Click() {
		selenium.ClickButton(this.searchFilter);	
	}
	
	
	public void Search_text(String Searchtext) {
		selenium.enterText(this.enter_text, Searchtext);	
	}

	
	public void SearchButton_Click() {
		selenium.ClickButton(this.search_btn);	
	}
	
	
	
	
}
