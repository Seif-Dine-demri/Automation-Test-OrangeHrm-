package com.OrangeHrm.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHrm.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends BaseTest {
	LoginPage loginPage=new LoginPage();
	
	@Story ("To check login page title")
	@Description("Getting login page title ")
	@Severity(SeverityLevel.NORMAL)
	@Test (priority=1,description = "Verify  login page title on login page")
	public void verifyLoginPageTitle(){
		boolean loginDisplayed= loginPage.loginPresent();
		Assert.assertTrue(loginDisplayed);
	}

	
	@Story ("To check login functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Description("It will login by filling the fields of Email and password and navigate to the todo page")
	@Test (priority=2,description = "Testing Login functionality with username and Password")
	public void testLoginPage(){
		loginPage.setName(username);
		loginPage.setPassword(password);
		loginPage.clickLogin();
	}
	
	

}
