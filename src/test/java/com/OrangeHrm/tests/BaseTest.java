package com.OrangeHrm.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.OrangeHrm.pages.BasePage;
import com.OrangeHrm.pages.LoginPage;
import com.OrangeHrm.utility.ReadConfiguration;
import com.OrangeHrm.utility.Report;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners({Report.class})
public class BaseTest {
	ReadConfiguration readconfiguration=new ReadConfiguration();
	public static WebDriver driver;
	private String BaseURL =readconfiguration.getApplicationURL();
	protected String username=readconfiguration.getUserName();
	protected String password=readconfiguration.getPassword();
	
	protected BasePage basePage;
	protected LoginPage loginPage;
	@BeforeClass
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(BaseURL);
		basePage=new BasePage();
		BasePage.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDonw() {
		driver.quit();
	}

}
