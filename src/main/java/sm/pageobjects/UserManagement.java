package sm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sm.AbstractComponents.AbstractComponent;

public class UserManagement extends AbstractComponent {
	WebDriver driver;

	public UserManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(css = "a[href='#/residentManagement']")
	WebElement usermanag;
	@FindBy(css = "button[class*='addButtonContent']")
	WebElement adduser;
	@FindBy(id = "firstname-input")
	WebElement ufirstname;
	@FindBy(id = "surname-input")
	WebElement usurname;
	@FindBy(id = "dob-input")
	WebElement udob;
	@FindBy(id = "hometel-input")
	WebElement uphone;
	@FindBy(id = "email-input")
	WebElement uemail;
	@FindBy(css = "span[class*='multiselect__caret']")
	WebElement ucountry;
	@FindBy(id = "notes-input")
	WebElement unote;
	@FindBy(css = "button[type='submit']")
	WebElement usubmit;
	@FindBy(css = "button[class*='backbutton']")
	WebElement uback;
	@FindBy(xpath="(//i[@class='icon-pencil icon'])[4]")
	WebElement uedit;
	@FindBy(xpath="(//i[@class='icon-wrench icon'])[4]")
	WebElement uassign;
	@FindBy(xpath="(//div[@class='ng-star-inserted'])[2]")
	WebElement seldevtype;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[1]")
	WebElement devtypedrop;
	@FindBy(xpath="(//div[@class='ng-star-inserted'])[7]")
	WebElement seldev;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[2]")
	WebElement devdrop;
	@FindBy(xpath = "(//i[@class='icon-trash icon'])[1]")
	WebElement deletedev;
	@FindBy(id = "reason-input")
	WebElement reasonBox;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement dsubmit;
	@FindBy(xpath="(//i[@class='icon-trash icon'])[4]")
	WebElement udelete;
	
	

	public void addUser(String ufn,String usn, String dob, String phone, String email, String note)  {
		usermanag.click();
		menubutton();
		adduser.click();
		ufirstname.sendKeys(ufn);
		usurname.sendKeys(usn);
		udob.sendKeys(dob);
		uphone.sendKeys(phone);		
		uemail.sendKeys(email);		
		unote.sendKeys(note);
		usubmit.click();		
		   }		
   public void selectCountry(){
	   ucountry.click();
	   List<WebElement> countries = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement country:countries) {
			if (country.getText().equalsIgnoreCase("Hungary")) {
				country.click();
				break;
			}
			}
		
}
	public void eidtUser(String ufn,String usn) throws InterruptedException {
		usermanag.click();
		menubutton();
		uedit.click();
		ufirstname.clear();
		ufirstname.sendKeys(ufn);
		usurname.clear();
		usurname.sendKeys(usn);			
		selectCountry();		
		usubmit.click();			
		   }
	 public void seldevtype(){
		 seldevtype.click();
		   List<WebElement> devtypes = driver.findElements(By.xpath("//div/ul[2]/li"));
			for (WebElement devtype:devtypes) {
				if (devtype.getText().equalsIgnoreCase("Call point")) {
					devtype.click();
					break;
				}
				}
			
		
	}
	 public void seldev(){
		 seldev.click();
		   List<WebElement> devices = driver.findElements(By.xpath("//div/ul/li"));
			for (WebElement device:devices) {
				if (device.getText().equalsIgnoreCase("0012739-Grey Keyed Call Point")) {
					device.click();
					break;
				}
				}			
		
	}
	 public void assignDev() {
		 usermanag.click();
		 menubutton();
		 uassign.click();		 
		 seldevtype();
		 //devtypedrop.click();		 
		 seldev();
		// devdrop.click();
		 usubmit.click();		 
		 
	 }
	 public void unassignDev(String reason) throws InterruptedException {
		 usermanag.click();
		 menubutton();
		 uassign.click();			 
		 deletedev.click();	
		 reasonBox.sendKeys(reason);
		 //Thread.sleep(2000);
		 dsubmit.click();
	 }
	 public void userDel(String reason) {
		 usermanag.click();
		 menubutton();
		 udelete.click();
		 reasonBox.sendKeys(reason);
		 usubmit.click();		 
	 }
	
	 }


