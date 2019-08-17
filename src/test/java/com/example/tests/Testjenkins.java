

package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class Testjenkins {


  WebDriver driver;
 
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\DELL\\chromedriver.exe" );
	    driver = new ChromeDriver();
    
   // baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSearchNeewCar() throws Exception {
    driver.get("https://www.cargurus.com/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Used Cars'])[1]/following::span[1]")).click();
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_makerSelect")).click();
    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_makerSelect"))).selectByVisibleText("Audi");
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_makerSelect")).click();
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_modelSelect")).click();
    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_modelSelect"))).selectByVisibleText("A8");
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_modelSelect")).click();
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_year1Select")).click();
    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_year1Select"))).selectByVisibleText("2019");
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_year1Select")).click();
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_trimSelect")).click();
    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_trimSelect"))).selectByVisibleText("L 3.0T quattro AWD");
    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_trimSelect")).click();
    driver.findElement(By.id("distance")).click();
    new Select(driver.findElement(By.id("distance"))).selectByVisibleText("75 mi");
    driver.findElement(By.id("distance")).click();
    driver.findElement(By.id("stepOneSearchZip")).click();
    driver.findElement(By.id("submitTopicForm_0")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  
    }
  }
  


  

