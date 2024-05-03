package sm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sm.TestComponents.*;
import sm.pageobjects.Dashboard;

public class StandAloneTest extends baseTest{
	//String sidenavbar = "document.querySelector('.mat-sidenav-content').scrollTop=5000";
	//String menunav = "document.querySelector('.mat-drawer-inner-container.ng-tns-c230-0').scrollTop=5000";
	
	@Test(groups= {"alertClear"},enabled=false,retryAnalyzer=Retry.class)
	public void mAlarmClear() throws IOException, InterruptedException {		
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();
		System.out.println("Login Success");
		dashboard.mAlarmClear("M Alarm Clear Test");
		dashboard.logoutApplication();		
	}
	@Test(groups= {"alertClear"},enabled=false)
	public void bAlertClear() throws IOException, InterruptedException {		
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();
		System.out.println("Login Success");
		dashboard.bAlertClear("Beacon Alert Clear Test");
		dashboard.logoutApplication();		
	}

	@Test(enabled=false)
	public void logIn() throws IOException {		
		landingpage.selectLang();		
		landingpage.loginApplication();	
		System.out.println("Login Success");
		
	}
	@Test(enabled=false,dependsOnMethods= {"logIn"})
	public void logOut() throws IOException, InterruptedException {		
		landingpage.loginApplication();
		System.out.println("Login Success");
		Dashboard dashboard = new Dashboard(driver);			
		dashboard.logoutApplication();
	
	}
	@Test(enabled=true)
	public void mableHistory() throws IOException, InterruptedException {		
		landingpage.loginApplication();
		System.out.println("Login Success");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.mabHis();
		SoftAssert a = new SoftAssert();
		//Assert.assertEquals("Mable Alert History information", dashboard.htitle.getText());
		
		a.assertEquals("Mable Alert History information", dashboard.htitle.getText());
		dashboard.logoutApplication();
		a.assertAll();
	
}
	@Test(enabled=true)
	public void alarmHistory() throws IOException, InterruptedException {			
		landingpage.loginApplication();
		System.out.println("Login Success");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.alarmHis();
		//SoftAssert a = new SoftAssert();
		Assert.assertEquals("Alarm History information", dashboard.htitle.getText());
		//a.assertEquals("Alarm History formation", dashboard.htitle.getText());
		dashboard.logoutApplication();
		//a.assertAll();
}
	
}