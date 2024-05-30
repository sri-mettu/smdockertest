package sm.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import sm.pageobjects.LandingPage;

public class baseTest {
	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializeBrowser() throws IOException {
		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				// System.getProperty("user.dir") +
				// "\\src\\main\\java\\sm\\resources\\GlobalData.properties");
				System.getProperty("user.dir") + "//src//main//java//sm//resources//GlobalData.properties");
		prop.load(fis);
		// Ternary operator
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		String userDataDir = "C://Users//smettu//AppData//Local//Google//Chrome//User Data1";
		String userDataDir1 = "C://Users//smettu//AppData//Roaming//Mozilla//Firefox//Profiles//s2s9okle.Default User";
		String userDataDir2 = "C://Users//smettu//AppData//Local//Microsoft//Edge//User Data//Profile 2";
		if (browserName.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=" + userDataDir);
			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			//options.addArguments("--incognito");
			
			if (browserName.contains("headless")) {
				options.addArguments("headless");}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			//driver.manage().window().setSize(new Dimension(1440, 900));// full Screen
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile(new java.io.File(userDataDir1));
			options.setProfile(profile);
			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			//options.addArguments("-private");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("user-data-dir=" + userDataDir2);
			driver = new EdgeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}/*
		 * public WebDriver driver; public LandingPage landingpage;
		 * 
		 * public WebDriver initializeBrowser() throws IOException { // properties class
		 * Properties prop = new Properties(); FileInputStream fis = new
		 * FileInputStream(System.getProperty("user.dir") +
		 * "//src//main//java//sm//resources//GlobalData.properties"); prop.load(fis);
		 * 
		 * //Ternary operator String browserName = System.getProperty("browser") != null
		 * ? System.getProperty("browser") : prop.getProperty("browser");
		 * 
		 * // Initialize driver variable in the outer scope if
		 * (browserName.contains("chrome")) { ChromeOptions options = new
		 * ChromeOptions(); if (browserName.contains("headless")) {
		 * options.addArguments("headless"); } //
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(options);
		 * driver.manage().window().setSize(new Dimension(1440, 900)); //full Screen }
		 * else if (browserName.equalsIgnoreCase("firefox")) { FirefoxOptions options =
		 * new FirefoxOptions(); if (browserName.contains("headless")) {
		 * options.addArguments("--headless"); } //
		 * WebDriverManager.firefoxdriver().setup(); driver = new
		 * FirefoxDriver(options); } else if (browserName.equalsIgnoreCase("edge")) {
		 * System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe"); driver =
		 * new EdgeDriver(); }
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.manage().window().maximize();
		 * 
		 * return driver; }
		 */

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read Json to String
		String jsonData = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap- Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonData,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				// System.getProperty("user.dir") +
				// "\\src\\main\\java\\sm\\resources\\GlobalData.properties");
				System.getProperty("user.dir") + "//src//main//java//sm//resources//GlobalData.properties");
		prop.load(fis);
		String IP = System.getProperty("browserIP") != null ? System.getProperty("browserIP")
				: prop.getProperty("browserIP");
		// String browserIP = prop.getProperty("browserIP");
		driver = initializeBrowser();
		landingpage = new LandingPage(driver);
		landingpage.goTo(IP);
		return landingpage;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}

	}
}
