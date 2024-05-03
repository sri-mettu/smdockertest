package sm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import sm.AbstractComponents.AbstractComponent;

public class Dashboard extends AbstractComponent {
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='pageName']")
	WebElement pageNameDB;

	@FindBy(xpath = "(//p[@class='title'])[6]")
	WebElement maintenanceAlarm;
	@FindBy(xpath = "(//textarea[@type='text'])[1]")
	WebElement MtextBox;
	@FindBy(xpath = "(//mat-row/mat-cell/span/button)[1]")
	WebElement mClear;
	@FindBy(xpath = "(//p[@class='title'])[9]")
	WebElement beaconAlert;
	@FindBy(xpath = "(//button[@class='clearbutton'])[1]")
	WebElement bClear;
	@FindBy(id = "reason-input")
	WebElement reasonBox;		
	@FindBy(css = "button[type='submit']")
	WebElement bSubmit;
	@FindBy(css="button[class='close']")
	WebElement bclose;
	@FindBy(css = "i[class*='logout']")
	WebElement logout;
	@FindBy(css = "#mat-button-toggle-3-button")
	WebElement mableHistory;
	@FindBy(css = "div[class='tableTitle']")
	public
	WebElement htitle;
	@FindBy(id = "mat-button-toggle-2-button")
	public
	WebElement alarmHistory;


	public String getPageName() {
		
		waitForWebElementToAppear(pageNameDB);
		return pageNameDB.getText();
		
	}

	public void mAlarmClear(String reason) {
		maintenanceAlarm.click();
		MtextBox.sendKeys(reason);
		mClear.click();
		System.out.println("Maintenance Alarm Cleared");
		
		

	}

	public void bAlertClear(String reason) {
		beaconAlert.click();
		bClear.click();
		reasonBox.sendKeys(reason);		
		bSubmit.click();
		bclose.click();
		System.out.println("Beacon Alert Cleared");

	}
	public void logoutApplication() throws InterruptedException {
		
		menubutton();			
		scrollLogout();
		logout.click();
		System.out.println("Logged Out");
		
	}
public String mabHis() throws InterruptedException {
	
		scrollWindow();
		mableHistory.click();
		System.out.println(htitle.getText());
		return htitle.getText();
		
		
	}
public String alarmHis() throws InterruptedException {				
	scrollWindow();
	alarmHistory.click();
	System.out.println(htitle.getText());
	return htitle.getText();
	
	
}
}
