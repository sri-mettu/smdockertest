package sm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sm.AbstractComponents.AbstractComponent;

public class DeviceManagement extends AbstractComponent {
	WebDriver driver;

	public DeviceManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(css = "a[href='#/deviceManagement']")
	public
	WebElement devicemanag;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[1]")
	WebElement devices;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[2]")
	WebElement mabledev;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[3]")
	WebElement alarmarea;	
	@FindBy(xpath = "//div/input")
	WebElement search;
	@FindBy(css = "button[class*='addButtonContent']")
	WebElement loaddev;
	@FindBy(id = "ip-input")
	WebElement hubIP;
	@FindBy(css = "button[type='submit']")	
	WebElement submit;
	@FindBy(css= "div[aria-label*='Finished Loading']")
	WebElement loadsuccess;
	@FindBy(css= "div[aria-label='Success']")
	WebElement success;	
	@FindBy(css = "i[class='icon-pencil")
	WebElement edit;
	@FindBy(xpath = "//span/div")
	WebElement selarea;
	@FindBy(xpath = "(//span[@class='mat-radio-inner-circle'])[2]")
	WebElement seluserradio;
	@FindBy(xpath = "(//input[@class='mat-radio-input'])[1]")
	WebElement selstaffradio;
	@FindBy(xpath = "(//div/span)[3]")
	WebElement selstaffdrop;
	@FindBy(xpath = "(//div/span)[2]")
	WebElement seluserdrop;
	@FindBy(xpath= "(//span[@class='dropdown-multiselect__caret'])[1]")
	WebElement multiCaretarea;
	@FindBy(xpath= "(//span[@class='dropdown-multiselect__caret'])[2]")
	WebElement multiCaretstaff;
	@FindBy(xpath= "(//span[@class='dropdown-multiselect__caret'])[2]")
	WebElement multiCaretuser;
	
	public void devLoad(String ipadd)  {
		devicemanag.click();
		menubutton();
		loaddev.click();
		hubIP.sendKeys(ipadd);
		submit.click();	
		waitForWebElementToAppear(loadsuccess);		
		System.out.println(loadsuccess.getText());
		
		   }		
  public void editDev(String ar,String usr) throws InterruptedException{
	  edit.click();
	  selectArea(ar);	  
	  seluserradio.click();
	  selectUser(usr);
	 multiCaretuser.click();
	  submit.click();	  
	  
  }
  public void selectArea(String ar){
	  selarea.click();
	   List<WebElement> areas = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement area:areas) {
			if (area.getText().equalsIgnoreCase(ar)) {
				area.click();
				break;
			}
}
		}
  public void selectStaff(String stff){
	  selstaffdrop.click();
	   List<WebElement> staffs = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement staff:staffs) {
			if (staff.getText().equalsIgnoreCase(stff)) {
				staff.click();
				break;
			}
}
		}
  public void selectUser(String usr){
	  seluserdrop.click();
	   List<WebElement> users = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement user:users) {
			if (user.getText().equalsIgnoreCase(usr)) {
				user.click();
				break;
			}
}
		}
  }
	