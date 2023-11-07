package com.dashboard;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.util.Page;

public class DashboardPage extends Page<DashboardPage> {
	/**
	 * @param driver the webdriver
	 */
	public DashboardPage(WebDriver driver) {
		super(driver, ROUTE);
	}

	@Override
	public DashboardPage verify_route() {
		return this;
	}

	Actions actions = new Actions(driver);	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	private static final String ROUTE = "/";
	
	private static final String REPORT_NEW_CLAIM = "//a[text()=' REPORT NEW CLAIM']";
	private static final String CLAIM_VIA_DOCUMENT = "//a[text()=' CLAIM VIA DOCUMENT']";
	private static final String REPORT_CLAIM_TXT_BOXES = ".PickerWidget---default_direction .PickerWidget---picker_value.PickerWidget---placeholder_visible>input";
	private static final String SEARCH_POLICY_BTN = "//span[text()='Search Policy']/ancestor::button";
	
	@FindBys({ @FindBy(xpath = REPORT_NEW_CLAIM) })
	private WebElement reportNewClaimBtn;
	@FindBys({ @FindBy(xpath = CLAIM_VIA_DOCUMENT) })
	private WebElement claimViaDocumentBtn;
	@FindBys({ @FindBy(css = REPORT_CLAIM_TXT_BOXES) })
	private List<WebElement> reportClaimTxtBoxes;
	@FindBys({ @FindBy(xpath = SEARCH_POLICY_BTN) })
	private WebElement searchPolicyBtn;
	
	public DashboardPage validate_home_page()
	{
		Assert.assertTrue(reportNewClaimBtn.isDisplayed());
		Assert.assertTrue(claimViaDocumentBtn.isDisplayed());
		return this;
	}
	
	/*
	 * public DashboardPage search_customer_role() {
	 * searchBox.sendKeys("Customer Roles"); wait_for_disappearance_of_modal();
	 * dropdownValues.get(0).click(); wait_for_disappearance_of_modal();
	 * Assert.assertEquals(driver.getCurrentUrl(),
	 * "https://admin-demo.nopcommerce.com/Admin/CustomerRole/List"); return this; }
	 */
	
	public DashboardPage click_on_report_claim_btn()
	{
		reportNewClaimBtn.click();
		return this;
	}
	
	public DashboardPage enter_contact_name()
	{
		reportClaimTxtBoxes.get(1).sendKeys("Jon Smith - jonsmith@yopmail.com");
		wait_for_page_loader(0);
		actions.sendKeys(Keys.ENTER).build().perform();
		return this;
	}

	public DashboardPage click_on_search_policy_btn()
	{
		//wait_for_appearance_of_xpath(SEARCH_POLICY_BTN, 20);
		wait_for_page_loader(0);
		searchPolicyBtn.click();
		return this;
	}
	
	
}
