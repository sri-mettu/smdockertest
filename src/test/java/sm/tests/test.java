package sm.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test; 

public class test {
@Test
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
}
