package com.jstech.BDD.stepDef;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.jstech.BDD.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MMTFlightSearch {

	public static WebDriver driver;
	PropertiesFileReader obj= new PropertiesFileReader();  
    
	
	
	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{
		Properties properties=obj.getProperty();   
		 
		System.setProperty("webdriver.chrome.driver", "../BDD/src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();			
		driver.get(properties.getProperty("browser.baseURL"));
		Thread.sleep(3000);	 	   
	}

	@When("^Enter search criteria$")
	public void enter_search_creteria() throws Throwable 
	{
		driver.findElement(By.linkText("Flights")).click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='fromCity']/input")).sendKeys("Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[@for='toCity']/input")).sendKeys("Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
		Thread.sleep(1500);
	}

	@Then("^Click on search button$")
	public void click_on_search_button() throws Throwable 
	{
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")).click();
		Thread.sleep(3000);	 	
		driver.quit();
	}
}
