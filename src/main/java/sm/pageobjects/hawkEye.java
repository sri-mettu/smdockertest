package sm.pageobjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sm.AbstractComponents.AbstractComponent;

public class hawkEye extends AbstractComponent {
	WebDriver driver;

	public hawkEye(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(css = "input[name='first-name']")
	WebElement firstnm;
	@FindBy(css = "input[name='last-name']")
	WebElement lastnm;
	@FindBy(id = "comp-ku2rmt7t2label")
	WebElement technology;	
	@FindBy(id = "textarea_comp-kwagucb12")
	WebElement msginput;
	@FindBy(id = "comp-ku2rmt7t3label")
	WebElement careers;
	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement accptall;
	@FindBy(css = "select[name='locationId']")
	WebElement location;
	@FindBy(css = "select[name='employmentType']")
	WebElement emptyp;
	@FindBy(css = "select[name='departmentId']")
	WebElement dept;
	@FindBy(css = "input[name='email']")
	WebElement email;
	@FindBy(css = "input[name='company']")
	WebElement company;
	@FindBy(xpath="//span[text()='Submit']")
	WebElement submit;
	@FindBy(xpath="//h3[text()='QA Automation Engineer (Frontend)']")
	WebElement qaJob;
	@FindBy(xpath="//span[text()='TRACK']")
	WebElement techTrack;	

	public void askusTrack(String ufn,String usn, String mail,String cmpny, String note) throws IOException  {
		technology.click();
		techTrack.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000);");		
		firstnm.sendKeys(ufn);
		lastnm.sendKeys(usn);					
		email.sendKeys(mail);
		company.sendKeys(cmpny);
		msginput.sendKeys(note);
		screenShot();
		submit.click();		
		   }
	public void launchHEApp() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hawkeyeinnovations.com/");
	}
	public void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"//reports//"+"screenshot" + ".png");
		FileUtils.copyFile(source, file);
	}
	public void quit() {
		driver.quit();
	}
  /* public void selectCountry(){
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
	 } */
	
	 }


