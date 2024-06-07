package sm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import sm.TestComponents.baseTest;

public class LandingPageTest extends baseTest{		

	
	@Test(enabled=true)
	public void incorrectSignIn() throws IOException, InterruptedException {			
		landingpage.logInApp("harani.venkatesh@multitone.com");
		//landingpage.getErrorMessage();
		Assert.assertEquals("No account with login id harani.venkatesh@multitone.com", landingpage.getErrorMessage());
		}
	@Test(enabled=false)
	public void pwdSignIn() throws IOException, InterruptedException {			
		landingpage.loginApplication();
		
		}
	
	
}
