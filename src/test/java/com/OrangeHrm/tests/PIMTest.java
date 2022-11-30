package com.OrangeHrm.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.OrangeHrm.pages.LoginPage;
import com.OrangeHrm.pages.PIMPage;

import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class PIMTest extends BaseTest {
	PIMPage pimPage;
	LoginPage loginPage;

	
	@Story("Add employee")
    @Description("It will add new employee ")
	@Test(priority=1,dataProvider="loginData",enabled =true, description = "Should be able to add new employee correctly")
	public void addemployeeTest(String name, String middlename,String lastname) throws IOException, AWTException, InterruptedException {
		pimPage.clicladdEMployee();
		pimPage.setName(name);
		pimPage.setmiddleName(middlename);
		pimPage.setlastName(lastname);
		pimPage.uploadImage();
		Thread.sleep(20);
		pimPage.clicksave();
		String actualResult=pimPage.getSavedMessage();
		String expectedResult="Successfully Saved";
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	@Story("Delete employee")
    @Description("It will delete last add employee ")
	@Test(priority=2,dataProvider="loginData",enabled =true,description = "Should be able to delete employee correctly")
	public void deleteEmployee(String name, String middlename,String lastname) throws InterruptedException {
		pimPage =new PIMPage();
		pimPage.clickpim();
		pimPage.clickemployeelist();
		pimPage.putemplyeName(name,middlename,lastname);
		pimPage.clickSearch();
		pimPage.clickDelete();
		pimPage.clickyesdelete();
		String actualResult=pimPage.getDeletedMessage();
		String expectedMessage="Successfully Deleted";
		Assert.assertTrue(actualResult.contains(expectedMessage));
	}
	
	@BeforeClass
	public void loadlogin() {
		loginPage= new LoginPage();
		loginPage.setName(username);
		loginPage.setPassword(password);
		pimPage= loginPage.clickLogin();
		pimPage.clickpim();
	}
	@AfterClass
	public void close(){
		
	}
	@DataProvider
	protected Object [][] loginData(){
		Object[][] data= {{"Seif","Dine","Tunisia"}};
		return data;
	}
	


}
