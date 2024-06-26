package sm.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.network.Network;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sm.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signin;
	@FindBy(id = "input")
	WebElement email;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement cotnue;
	@FindBy(xpath = "(//p[contains(@class,'MuiTypography-root MuiTypography-p1')])[2]")
	WebElement error;
	@FindBy(xpath ="//p[contains(@class,'MuiTypography-root MuiTypography-p1')]")
	public
	//p[contains(@class,'MuiTypography-root MuiTypography-p1')]
	WebElement pwderr;
	@FindBy(css = "button[class*='MuiTypography-root ']")
	WebElement back;
	@FindBy(xpath = "//p[text()='Password']")
	public	
	WebElement pwdbtn;
	@FindBy(xpath = "//p[text()='Email link']")
	WebElement emaillink;
	@FindBy(css = "input[type='password']")
	public	
	WebElement password;
	@FindBy(css = "button[type='submit']")
	public
	WebElement submit;
	@FindBy(xpath = "//button[text()='Forgot password?']")
	WebElement forgotpwd;
	@FindBy(xpath = "//p[text()='Resend Email']")
	WebElement rsndemail;
	@FindBy(xpath = "//p[text()='Contact Support']")
	WebElement cntsuprt;
	@FindBy(xpath = "//h1[@id='headingText']")
	WebElement headtext;
	@FindBy(css = "a[href*='signin']")
	WebElement gsignin;
	@FindBy(css = "input[type='email']")
	WebElement gmail;
	@FindBy(xpath = "//span[text()='Next']")
	WebElement next;
	@FindBy(css = "input[type='password']")
	WebElement gpassword;
	@FindBy(xpath = "(//a[@title='Gmail'])[2]")
	WebElement gtitle;
	@FindBy(css = "input[placeholder*='Search']")
	WebElement gsearch;
	@FindBy(xpath = "(//b[text()='Your verification code'])[1]")
	WebElement gclick;
	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr/td/div/p/span)[2]")
	WebElement gvercode;
	@FindBy(xpath = "(//div[@aria-label='Delete'])[3]")
	WebElement gdelete;
	@FindBy(xpath = "div[class='gb_b gb_x gb_4f gb_K']")
	WebElement glout;
	@FindBy(xpath = "(//div[@class='SedFmc'])[2]")
	WebElement glogout;
	@FindBy(css = "input[type='password']")
	WebElement codepwd;
	

	public void goTo(String url) {
		driver.get(url);
		System.out.println(driver.getTitle());

	}
	/*
	 * 
	 * public void selectLang() throws IOException { Properties prop = new
	 * Properties(); FileInputStream fis = new FileInputStream(
	 * //System.getProperty("user.dir") +
	 * "\\src\\main\\java\\sm\\resources\\GlobalData.properties");
	 * System.getProperty("user.dir") +
	 * "//src//main//java//sm//resources//GlobalData.properties"); prop.load(fis);
	 * String lang = System.getProperty("language")!=null ?
	 * System.getProperty("language") :prop.getProperty("language"); WebElement
	 * Languagedropdown = selLang; Select dropdown = new Select(Languagedropdown);
	 * //dropdown.selectByIndex(x); dropdown.selectByValue(lang);
	 * 
	 * }
	 */

	public Dashboard loginApplication() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//sm//resources//GlobalData.properties");
		prop.load(fis);
		String user = System.getProperty("uname") != null ? System.getProperty("uname") : prop.getProperty("uname");
		String pwd = System.getProperty("pwd") != null ? System.getProperty("pwd") : prop.getProperty("pwd");
		signin.click();
		email.sendKeys(user);
		cotnue.click();
		pwdbtn.click();
		password.sendKeys(pwd);
		submit.click();
		switchtab(user);
		Thread.sleep(3000);
		Dashboard dashboard = new Dashboard(driver);
		return dashboard;
	}

	public void switchtab(String user) throws InterruptedException {
		String aurora = driver.getWindowHandle();
		// Open a new tab using JavaScript
		((JavascriptExecutor) driver).executeScript("window.open();");
		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(allWindows);
		// Switch to the new tab (second in the list)
		driver.switchTo().window(windowList.get(1));	
		gmailLogin("appse@multitone.com","Multitone1");	
		waitForWebElementToAppear(gsearch);
		gsearch.sendKeys("Your verification code");
		waitForWebElementToclick(gclick);
		gclick.click();
		String verfcode = gvercode.getText();
		System.out.println("Your verification code: " + verfcode);
		//gdelete.click();

		/*
		 * String regex = "(?i)\\bDatabase\\b"; Pattern pattern =
		 * Pattern.compile(regex); Matcher matcher = pattern.matcher(copiedtext); String
		 * matchedword = ""; if (matcher.find()) { matchedword = matcher.group(); }
		 */
		//waitForWebElementToclick(glout);
		//glout.click();
		//glogout.click();
		Thread.sleep(3000);
		driver.switchTo().window(aurora);
		codepwd.sendKeys(verfcode);
		Thread.sleep(3000);
		signin.click();
		// if (!matchedword.isEmpty()) {
		// email.sendKeys(matchedword);}
		Thread.sleep(3000);
	}
	public void gmailLogin(String email,String gpwd) {
		driver.get("https://gmail.com/");
		if (driver.getCurrentUrl().contains("https://accounts.google.com/v3/signin/identifier?")) {
		gsignin.click();                             
		gmail.sendKeys(email);
		next.click();
		waitForWebElementToAppear(gpassword);
		gpassword.sendKeys(gpwd);
		next.click();}
		else if (driver.getCurrentUrl().contains("https://mail.google.com/mail/u/0/#inbox")) {
		waitForWebElementToAppear(gtitle);}
		waitForWebElementToAppear(gtitle);
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(error);
		System.out.println(error.getText());
		return error.getText();
		

	}

	public void extractText() {
		String copiedtext = gtitle.getText();
		System.out.println(copiedtext);
		String regex = "(?i)\\bDatabase\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(copiedtext);
		String matchedword = "";
		if (matcher.find()) {
			matchedword = matcher.group();
		}
	}

	public void logInApp(String un) throws IOException, InterruptedException {
		signin.click();
		email.sendKeys(un);
		System.out.println(email.getAttribute("value"));
		cotnue.click();
		
		// getErrorMessage();
	}

}
