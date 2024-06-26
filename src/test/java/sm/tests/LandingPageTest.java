package sm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import sm.TestComponents.baseTest;
import sm.pageobjects.LandingPage;

public class LandingPageTest extends baseTest{		

	
	@Test(enabled=false)
	public void invalemailSignIn() throws IOException, InterruptedException {			
		landingpage.logInApp("harani.venkatesh@multitone.com");
		//landingpage.getErrorMessage();
		Assert.assertEquals("No account with login id harani.venkatesh@multitone.com", landingpage.getErrorMessage());
		}
	@Test(enabled=false)
	public void invalpwdSignIn() throws IOException, InterruptedException {			
		LandingPage landingpage =new LandingPage(driver);
		landingpage.logInApp("tharani.venkatesh@multitone.com");
		landingpage.pwdbtn.click();
		landingpage.password.sendKeys("multitone");
		landingpage.submit.click();
		System.out.println(landingpage.pwderr.getText());
		//Assert.assertEquals("Challenge with id f448b373-9726-4d21-9aac-fcda2954f86c failed", landingpage.pwderr.getText());
	Thread.sleep(120000);	
	}
	@Test(enabled=true)
	public void pwdSignIn() throws IOException, InterruptedException {			
		landingpage.loginApplication();
		
		}
	
	
}
