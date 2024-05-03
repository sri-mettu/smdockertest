package sm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sm.AbstractComponents.AbstractComponent;

public class EscortManagement extends AbstractComponent {
	WebDriver driver;

	public EscortManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(css = "a[href='#/escortManagement']")
	WebElement escortmanag;
	@FindBy(css = "button[class*='addButtonContent']")
	WebElement addescort;
	@FindBy(xpath = "(//span/div[@class='ng-star-inserted'])[1]")	
	WebElement selescoter;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[1]")
	WebElement multiselect1;
	@FindBy(xpath = "//div//span[@class='ng-star-inserted']")
	WebElement selescortee;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[2]")
	WebElement multiselect2;
	@FindBy(xpath = "(//span/div[@class='ng-star-inserted'])[2]")
	WebElement seldest;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[3]")
	WebElement multiselect3;
	@FindBy(xpath = "(//div/span/i[@class='icon-calendar'])[1]")
	WebElement starttime;
	@FindBy(xpath = "(//input[@class='owl-dt-timer-input'])[1]")
	WebElement hour;
	@FindBy(xpath = "(//input[@class='owl-dt-timer-input'])[2]")
	WebElement minute;
	@FindBy(xpath = "(//span[contains(@class, 'owl-dt-control-content')])[2]")
	WebElement apply;
	@FindBy(xpath = "(//span[contains(@class, 'owl-dt-control-content')])[1]")
	WebElement cancel;
	@FindBy(xpath = "(//div/span/i[@class='icon-calendar'])[2]")
	WebElement endtime;	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;	
	@FindBy(xpath="(//i[@class='icon-ban icon'])[1]")
	WebElement delete;
	@FindBy(id="reason-input")
	WebElement reason;
	
	
	/* public void selesctr() throws InterruptedException{
		 selescoter.click();
		   List<WebElement> escorters = driver.findElements(By.xpath("//div/ul[2]/li/div"));
			for (WebElement escorter:escorters) {
				if (escorter.getText().equalsIgnoreCase("s02 test")) {
					escorter.click();
					break;			}				
				}
		
			Thread.sleep(2000);
			}
	 public void selesctee() throws InterruptedException{
		 selescortee.click();
		   List<WebElement> escortees = driver.findElements(By.xpath("//div/ul[2]/li/div"));
			for (WebElement escortee:escortees) {
				if (escortee.getText().equalsIgnoreCase("u 596e")) {
					escortee.click();
					break;
				}				
;				}
			multiselect2.click();
			//selescortee.click();
			Thread.sleep(2000);
			}		
	 
   public void seldestination() throws InterruptedException{
	   seldest.click();
	   List<WebElement> destinations = driver.findElements(By.xpath("//div/ul[2]/li/div"));
		for (WebElement destination:destinations) {
			if (destination.getText().equalsIgnoreCase("Andy-Desk")) {
				
			destination.click();
				break;
			}	
			
			}
		//multiselect3.click();
		Thread.sleep(2000);
		}	*/
	public void selesctr(int index) throws InterruptedException{
		 selescoter.click();
		   List<WebElement> escorters = driver.findElements(By.xpath("(//div/ul[2])[1]/li/div"));
		   if (index >= 0 && index < escorters.size()) {
		        WebElement escorter = escorters.get(index);
		        escorter.click();
		    } else {
		        System.out.println("Invalid index: " + index);
		    }	
		
			Thread.sleep(2000);
			}
	public void selesctee(int[] indexes) throws InterruptedException{
		 selescortee.click();
		   List<WebElement> escortees = driver.findElements(By.xpath("(//div/ul[2])[2]/li"));
		   for (int index : indexes) {
		   if (index >= 0 && index < escortees.size()) {
		        WebElement escortee = escortees.get(index);
		        escortee.click();
		    } else {
		        System.out.println("Invalid index: " + index);
		    }	}
		  multiselect2.click();
			//selescortee.click();
			Thread.sleep(2000);
			}
	
			
			
   public void seldestination(int index) throws InterruptedException {
	    seldest.click();
	    List<WebElement> destinations = driver.findElements(By.xpath("(//div/ul[2])[3]/li"));
	    
	    if (index >= 0 && index < destinations.size()) {
	        WebElement destination = destinations.get(index);
	        destination.click();
	    } else {
	        System.out.println("Invalid index: " + index);
	    }
	}

	public void strttime(int hr,int min) throws InterruptedException {
		waitForWebElementToAppear(starttime);
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();", starttime);
		starttime.click();
		hour.sendKeys(String.valueOf(hr));
		minute.sendKeys(String.valueOf(min));
		//apply.click();
		cancel.click();
		
		starttime.click();
		Thread.sleep(2000);
		
		
		 }
	public void endtime(int hr1,int min1) throws InterruptedException {
		waitForWebElementToAppear(endtime);
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();", endtime);
		//endtime.click();
		hour.sendKeys(String.valueOf(hr1));
		minute.sendKeys(String.valueOf(min1));
		//apply.click();
		cancel.click();
		
		endtime.click();
		Thread.sleep(2000);
		
		 }	
	public void addEvent(int hr,int min,int hr1,int min1) throws InterruptedException {
		int[] indexesToSelect = {0,1};
		escortmanag.click();
		menubutton();
		addescort.click();
		selesctr(1);
		selesctee(indexesToSelect);
		seldestination(0);
		//strttime(hr, min);
		//endtime(hr1, min1);	
		submit.click();		
	}
	
public void delEvent(String reas) throws InterruptedException {
		
		escortmanag.click();
		menubutton();
		delete.click();
		reason.sendKeys(reas);	
		submit.click();
	}
	 
	 }


