package com.OrangeHrm.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage extends BasePage {
	private By pim=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");
	private By addEmployee=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a");
	private By name=By.name("firstName");
	private By middleName=By.name("middleName");
	private By lastName=By.name("lastName");
	private By save =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
	private By employeeNamee=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");
	private By searchbtn=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
	private By deletebtn=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[1]");
	private By yesdeletebtn=By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
	private By employeelistbtn=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a");
    private By messageSaved=By.xpath("//*[@id=\"oxd-toaster_1\"]/div");
    private By deleteMessage=By.xpath("//*[@id=\"oxd-toaster_1\"]/div");
	private By uploadBtn=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button");

    
	
	public void clickpim() {
		click(pim);
		}
	
	public void clicladdEMployee() {
		click(addEmployee);
	}
	public void setName(String nname) {
		sendText(name,nname);
	}
	public void setmiddleName(String middlename) {
		sendText(middleName,middlename);
	}
	public void setlastName(String lastname) {
		sendText(lastName,lastname);
	}
	public void clicksave() {
		click(save);
	}
	

	public void putemplyeName(String name,String middlename,String lastname ) {
		sendText(employeeNamee,name+" "+middlename);
	}
	public void clickSearch() {
		click(searchbtn);
	}
	public void clickDelete() {
		try {			
			WebDriverWait wait=new WebDriverWait(driver,10);
		    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(deletebtn));
			click(deletebtn);
		}
		catch(StaleElementReferenceException ex)
		{
		       PageFactory.initElements(driver, this);

		}
	}
	public void clickyesdelete() {
		try {
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(yesdeletebtn));
			click(yesdeletebtn);
		}
		catch(StaleElementReferenceException ex)
		{
		       PageFactory.initElements(driver, this);

		}
	}
	public void clickemployeelist() {
		click(employeelistbtn);
	}
	
	public String getSavedMessage() {
		return getText(messageSaved);
	}
	
	public String getDeletedMessage() {
		return getText(deleteMessage);
	}
	WebElement btnupload;
	public void uploadImage() throws IOException, AWTException, InterruptedException {
		
		Robot rb =new Robot();
		find(uploadBtn).click();
		Thread.sleep(3500);
		StringSelection ss = new StringSelection("C:\\Users\\pc\\Desktop\\Nouveau dossier (4)\\OIP.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
	}



}
