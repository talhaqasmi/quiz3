package autoTest1;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mytest {
	WebDriver driver;
	objectFile object;
	@BeforeTest
	public void before() {
	driver =new ChromeDriver();
	driver.get("http://release01.curemd.com/curemdy/datlogin.asp");
	driver.manage().window().maximize();
	}
	@Test(priority=0)
	public void login() throws InterruptedException {
		PropertyConfigurator.configure("log4j.properties");
		object=new objectFile(driver);
		object.login1();
	}
	@Test(priority=1)
	public void patients() throws InterruptedException {
		PropertyConfigurator.configure("log4j.properties");
		object=new objectFile(driver);
		object.patientAll();
		}
	@Test(priority=2)
	public void data() throws InterruptedException {
		PropertyConfigurator.configure("log4j.properties");
		object=new objectFile(driver);
		object.biodata();
		}
	@AfterTest
	public void closetab() {
		driver.close();
	}
}
