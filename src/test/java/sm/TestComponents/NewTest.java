package sm.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import sm.pageobjects.Dashboard;
import sm.pageobjects.LandingPage;

public class NewTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public Dashboard dashboard;
	
	public WebDriver initializeBrowser() throws IOException
	{
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\srimettu\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();		
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();			
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\srimettu\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserIP = prop.getProperty("IP");
		driver = initializeBrowser();
		landingpage = new LandingPage(driver);		
		landingpage.goTo(browserIP);
		return landingpage;
	}
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	}

}
