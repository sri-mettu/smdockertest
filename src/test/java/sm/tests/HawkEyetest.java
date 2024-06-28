package sm.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import sm.TestComponents.baseTest;
import sm.pageobjects.hawkEye; 
import org.openqa.selenium.By;

public class HawkEyetest extends baseTest{
@Test (enabled=true)
	public void Hwkeye () throws InterruptedException, IOException{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hawkeyeinnovations.com/");
	driver.findElement(By.id("comp-ku2rmt7t2label")).click();
	driver.findElement(By.xpath("//span[text()='TRACK']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,10000);");
	driver.findElement(By.cssSelector("input[name='first-name']")).sendKeys("sri");
	driver.findElement(By.cssSelector("input[name='last-name']")).sendKeys("m");
	driver.findElement(By.cssSelector("input[name='email']")).sendKeys("m.sri@gmail.com");
	driver.findElement(By.cssSelector("input[name='company']")).sendKeys("m.sri");
	driver.findElement(By.id("textarea_comp-kwagucb12")).sendKeys("Hi Hawk-Eye I am Comming");
	Thread.sleep(4000);
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir") +"//reports//"+"screenshot" + ".png");
	FileUtils.copyFile(source, file);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']"))); 
	driver.findElement(By.xpath("//span[text()='Submit']")).click();
	Thread.sleep(4000);
	driver.quit();
	}
@Test (enabled=false)
public void HwkeyeJobsearch () throws InterruptedException, IOException{
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.hawkeyeinnovations.com/");
driver.findElement(By.id("comp-ku2rmt7t3label")).click();
//((JavascriptExecutor) driver).executeScript("window.open();");
Set<String> allWindows = driver.getWindowHandles();
List<String> windowList = new ArrayList<>(allWindows);
//Switch to the new tab (second in the list)
driver.switchTo().window(windowList.get(1));
driver.findElement(By.id("onetrust-accept-btn-handler")).click();
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,6400);");
//WebElement department = driver.findElement(By.xpath("(//div[@class='_filterContainer_12ylk_278'])[1]"));
WebElement location = driver.findElement(By.cssSelector("select[name='locationId']"));
WebElement employment = driver.findElement(By.cssSelector("select[name='employmentType']"));
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//wait.until(ExpectedConditions.elementToBeClickable(department));
//Select dept = new Select(department);
//dept.selectByValue("bdf1cf3b-e210-42f2-92cb-1668fe51cc1c");
Select loc = new Select(location);
loc.selectByValue("2768c69c-133a-4a84-8be5-41673c8a3f61");
Select emptyp = new Select(employment);
emptyp.selectByValue("FullTime"); 
driver.findElement(By.xpath("//h3[text()='QA Automation Engineer (Frontend)']")).click();

Thread.sleep(4000);
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
File file = new File(System.getProperty("user.dir") +"//reports//"+"screenshot" + ".png");
FileUtils.copyFile(source, file);
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']"))); 
//driver.findElement(By.xpath("//span[text()='Submit']")).click();
Thread.sleep(4000);
driver.quit();
}

@Test (enabled=false)
public void askTRACK() throws IOException {
	hawkEye he =new hawkEye(driver);
	//he.launchHEApp();
	he.askusTrack("sri", "m", "sri.m@gmail.com", "mcompany", "Hello H E");
	//he.quit();
}
}
