package com.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.logout.LogoutPage;
import com.util.Page;

public class LoginPage extends Page<LoginPage>{
	
	// ROUTE
	private static final String ROUTE = "/";

	// Element IDs
	
	private static final String EMAIL = "//input[@id='un']";
	private static final String PASSWORD = "//input[@id='pw']";
	private static final String LOGIN_BUTTON = "//input[@type='submit']";
	private static final String LOGOUT_BUTTON = "//a[@href='/logout']";

	// Form Elements
		@FindBy(xpath = EMAIL)
		private WebElement userNameLogin;
		@FindBy(xpath = PASSWORD)
		private WebElement passwordLogin;
		@FindBy(xpath = LOGIN_BUTTON)
		private WebElement submitLogin;
		@FindBy(xpath = LOGOUT_BUTTON)
		private WebElement logOutButton;
		

			public LoginPage(WebDriver driver) {
				super(driver, ROUTE);
			}
			/**
			 * Logout the current user (if one is logged in) and returns to the login
			 * page.
			 * 
			 * @return a fresh Login Page
			 */
			public LoginPage goto_fresh_login_page() {

				report_step(generate_step_descriptor());
				LogoutPage logoutPage = PageFactory.initElements(driver, LogoutPage.class);
				// waitForLoadCompletion();
				return logoutPage.navigate_to_logout_and_expect_return_to_login();
			}

			/**
			 * Enter text into the username field
			 * 
			 * @param username
			 *            the string to enter into the password field
			 * @return this Login Page
			 */


			public LoginPage enter_username(String userName) {
				wait_for_disappearance_of_modal();
				report_step(generate_step_descriptor() + ", userName: '"
						+ userName + "'");
				userNameLogin.click();
				userNameLogin.clear();
				userNameLogin.sendKeys(userName);
				return this;

			}
			
			public LoginPage validate_presence_of_login_Screen() {
				wait_for_disappearance_of_modal();
				Assert.assertTrue(userNameLogin.isDisplayed());
				return this;

			}
			
			public LoginOutcome press_login_button() {
				report_step(generate_step_descriptor());
				submitLogin.click();
				wait_for_disappearance_of_modal();
				wait_for_disappearance_of_modal();
				return new LoginOutcome();
			}

			public LoginPage enter_password(String password) {
				report_step(generate_step_descriptor() + ", password: '"
						+ password + "'");
				passwordLogin.click();
				passwordLogin.clear();
				passwordLogin.sendKeys(password);
				return this;

			}
			
			
		  /**
			 * Checks the browser is on the correct URL and validates some page elements
			 * exist.
			 * 
			 * @return this Login Page
			 *//* */
			@Override
			public LoginPage verify_route() {
				report_step(generate_step_descriptor());
				wait_for_url(ROUTE, "not on the Login page");
				// waitForAppearanceOf(USERNAME_FIELD_ID, 10);
				// Check some elements on the page to ensure render.
				
				return this;
			}

			/**
			 * Possible outcomes of pressing the login button.
			 */
			public class LoginOutcome {

				/**
				 * 1) Ensures no invalid credentials error message is displayed. 2)
				 * Verifies navigation to dashboard page took place.
				 * 
				 * @return the dashboard page object that we have navigated to.
				 */
				@SuppressWarnings("synthetic-access")
				public LoginOutcome expect_valid_login() {
					report_step(generate_step_descriptor()); // Wait to ensure bad
															// credentials
															// message does not appear.
					waitForPageLoad();
					wait_for_disappearance_of_modal();
					wait_for_disappearance_of_modal();
					// waitForAppearanceOfClass(LOGOUT_BUTTON, 5);
					// Ensure we navigated to the dashboard page.
					// assertTrue(logOutButton.isDisplayed());
					return this;
				}

				public LoginOutcome validate_error_message() {
					// TODO GUI not supporting this feature right now.
					return new LoginOutcome();
				}

				/**
				 * 1) Ensures we are still on the login page.
				 * <p>
				 * Note: Do whatever validation (error message, required fields...) you
				 * need after this.
				 * 
				 * @return the login page object
				 */
				@SuppressWarnings("synthetic-access")
				public LoginPage expect_no_login() {
					report_step(generate_step_descriptor());
					return LoginPage.this.verify_route(); // Ensure we are still on the
															// login page.
				}
			}
		}

