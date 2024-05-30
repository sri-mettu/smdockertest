package sm.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "appSidebarTogglerv")
	WebElement menubutton;
	@FindBy(xpath = "//div/input")
	WebElement search;
	@FindBy(css= "i[class*='logout']")
	WebElement logout;
	@FindBy(css= ".mat-drawer-inner-container.ng-tns-c230-0")
	WebElement menuscroll;
	@FindBy(css= ".mat-drawer-content.mat-sidenav-content")
	WebElement sidenav;
	//

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForWebElementTodisAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	public void waitForWebElementToclick(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	

	public void maxbrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	public void scrollToLogout() throws InterruptedException {
		//WebElement logout = driver.findElement(By.cssSelector("i[class*='logout']"));	
		waitForWebElementToAppear(logout);
		new Actions(driver).scrollToElement(logout).click();

	}
	public void scrollWindow() throws InterruptedException {
		waitForWebElementToAppear(sidenav);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;			
		//js.executeScript(navbar);
		js.executeScript("document.querySelector('.mat-sidenav-content').scrollBy(0,700)");
		Thread.sleep(2000);		
	}
	public void scrollLogout() throws InterruptedException {
		waitForWebElementToAppear(menuscroll);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;			
		js.executeScript("document.querySelector('.mat-drawer-inner-container').scrollBy(0,700)");
				
	}
	public void menubutton() {
		waitForWebElementToAppear(menubutton);
		menubutton.click();
		
	}
	public void search(String text) throws InterruptedException{
		Thread.sleep(2000);
		   search.sendKeys(text);		   
		   search.sendKeys(Keys.ENTER);		   
				}
	public void invokeBrowser() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

}
