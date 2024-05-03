package sm.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sm.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(id = "sel1")
	WebElement selLang;
	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//span[contains(@class,'mat-checkbox-label')]")
	WebElement rememberme;
	@FindBy(className = "btn-primary")
	WebElement login;
	
	@FindBy(css = "p[style='color: red;']")
	WebElement errorMessage;
	
	

	public void goTo(String url) {
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		
	}

	public void selectLang() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		//System.getProperty("user.dir") + "\\src\\main\\java\\sm\\resources\\GlobalData.properties");
		System.getProperty("user.dir") + "//src//main//java//sm//resources//GlobalData.properties");
				prop.load(fis);
		String lang = System.getProperty("language")!=null ? System.getProperty("language") :prop.getProperty("language");
		WebElement Languagedropdown = selLang;
		Select dropdown = new Select(Languagedropdown);
		//dropdown.selectByIndex(x);
		dropdown.selectByValue(lang);

	}

	//public Dashboard loginApplication(String name, String pwd) throws IOException {
	public Dashboard loginApplication() throws IOException {	
	Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		//System.getProperty("user.dir") + "\\src\\main\\java\\sm\\resources\\GlobalData.properties");
		System.getProperty("user.dir") + "//src//main//java//sm//resources//GlobalData.properties");
				prop.load(fis);
		String user = System.getProperty("uname")!=null ? System.getProperty("uname") :prop.getProperty("uname");
		String pwd = System.getProperty("pwd")!=null ? System.getProperty("pwd") :prop.getProperty("pwd");
		username.sendKeys(user);
		password.sendKeys(pwd);
		//username.sendKeys(name);
		//password.sendKeys(pwd);
		rememberme.click();
		login.click();
		//System.out.println("Logged In");
		Dashboard dashboard = new Dashboard(driver);
		return dashboard;
	}
	
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		System.out.println(errorMessage.getText());
		return errorMessage.getText();
	
	}

	public Dashboard logInApp(String un, String pwd) throws IOException {
		selectLang();
		username.sendKeys(un);
		password.sendKeys(pwd);
		rememberme.click();
		login.click();
		//System.out.println("Logged In");
		Dashboard dashboard = new Dashboard(driver);
		return dashboard;
	}

	 

	
	

}
