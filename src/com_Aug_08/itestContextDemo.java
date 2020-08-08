package com_Aug_08;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class itestContextDemo {
	
	WebDriver driver = null;
	@BeforeMethod
	public void SetUp(ITestContext data) 
	{
		String Unm="abc";
		String Pwd="test";
		data.setAttribute("U1", Unm);
		data.setAttribute("P1", Pwd);
		
		 System.setProperty("webdriver.chrome.driver", "C:\\AutomationSoftware\\chrome\\new\\chromedriver.exe");
		 driver = new ChromeDriver();
	
	}
  @Test
  public void facebook(ITestContext data)  {
		 driver.get("https://www.facebook.com/");
		 driver.findElement(By.id("email")).sendKeys((String) data.getAttribute("U1"));
		 driver.findElement(By.id("pass")).sendKeys((String) data.getAttribute("P1"));
		 driver.findElement(By.id("loginbutton")).click();
  }
  
  @Test
  public void Amazon(ITestContext data) {
		 driver.get("https://www.amazon.com/");
  }
  @AfterMethod
	public void TearDown() 
	{
	  driver.close();
	}
}
