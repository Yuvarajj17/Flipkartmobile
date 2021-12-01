package com.Flipkart.steps;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Flipkart  {
	 static WebDriver driver;
	 static long starttime;
@BeforeClass
public static void launch() {
	System.out.println("Before class");
	WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@AfterClass
public static void quit() {

	System.out.println("After class");
	driver.quit();
}
@Before
public void starttime() {

	System.out.println("Before");
	starttime = System.currentTimeMillis();
	System.out.println(starttime);
	
}
@After
public  void endtime() {

	System.out.println("After");
	long endtime = System.currentTimeMillis();
	System.out.println(endtime);
	System.out.println("Timetaken is:" +(endtime-starttime));
}
@Test
public  void test1() {
try {
	WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
	button.isDisplayed();
	button.click();
}catch(Exception e) {
	System.out.println("Button is not displayed"); 
}
	
	WebElement searchbox = driver.findElement(By.name("q"));
	searchbox.sendKeys("realme",Keys.ENTER);
}
		
	static String Mobname;	
@Test
public   void test2()  {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement mobname = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[2]"));
	Mobname = mobname.getText();
	System.out.println(Mobname);
	wait.until(ExpectedConditions.elementToBeClickable(mobname));
    }
@Test
public  void test3() {
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String x : child) {
		if(!parent.equals(child)) {
			driver.switchTo().window(parent);
		}}}
@Test
public  void test4() {
	WebElement newmobname = driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
	String Newmob = newmobname.getText();
	System.out.println(Newmob);
	Assert.assertTrue(Newmob.equals(Mobname));
		}
		
}
