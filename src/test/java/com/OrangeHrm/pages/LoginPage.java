package com.OrangeHrm.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage  {
	private By userName =By.cssSelector("input[name='username']");
	private By password = By.name("password");
	private By login=By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	private By loginText=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5");
	
	public void setName(String username) {
		sendText(userName,username);
	}
	public void setPassword(String password) {
		sendText(this.password,password);
	}
	public PIMPage clickLogin() {
		click(login);
		return new PIMPage();
	}
	public boolean loginPresent(){
		return find(loginText).isDisplayed();
	}
	
	
}
