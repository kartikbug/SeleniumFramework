package com.dashboard;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.config.SeleniumTest;
import com.util.ScreenRecorderUtil;

public class FunctionalDashboardPage extends SeleniumTest {

	private DashboardPage dashboardPage;
	private long startTime;
	private long stopTime;
	private long elapsedTime;
	public String pageName = "Dashboard Module";
	
	@BeforeClass(alwaysRun=true)
	public void befoeClass() throws Exception{
		ScreenRecorderUtil.startRecord("DashboardPage");
		
		System.out.println("========== Inside Dashboard ==========");
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		startTime = System.currentTimeMillis();
		dashboardPage
			.validate_home_page();
		
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}	
		
	@Test(priority = 1, groups={"regression","preProdSanity","prodSanity"}, description = "Validate Dashboard Page")
	public void validate_report_a_claim_functionality(){
		System.out.println("Inside validate_report_a_claim_functionality");
		startTime = System.currentTimeMillis();
		dashboardPage
			
			.click_on_report_claim_btn()
			.enter_contact_name()
			.click_on_search_policy_btn();
		
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() throws Exception{
		ScreenRecorderUtil.stopRecord();
	}

}
	

