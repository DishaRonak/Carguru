package newCarSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.util.Excelutil;

public class SearchNewCar {
	WebDriver driver;
	
	 @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver","C:\\DELL\\chromedriver.exe" );
	    driver = new ChromeDriver();
	   // baseUrl = "https://www.katalon.com/";
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  }
	 
	 @DataProvider 
	 public Iterator<Object[]> getTestData() {
		 ArrayList<Object[]> testData = Excelutil.getDataFromExcel();
		 return testData.iterator();
		 
	 }

	  @Test(dataProvider="getTestData")
	  public void testSearchNeewCar(
		  String selectMake,String selectModel,String selectYear,String selectTrim,String distance,String zipcode) {
	    driver.get("https://www.cargurus.com/");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Used Cars'])[1]/following::span[1]")).click();
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_makerSelect")).click();
	    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_makerSelect"))).selectByVisibleText("selectMake");
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_makerSelect")).click();
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_modelSelect")).click();
	    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_modelSelect"))).selectByVisibleText("selectModel");
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_modelSelect")).click();
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_year1Select")).click();
	    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_year1Select"))).selectByVisibleText("selectYear");
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_year1Select")).click();
	    driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_trimSelect")).click();
	    new Select(driver.findElement(By.id("submitTopicForm_entitySelectingHelper_selectedEntity_trimSelect"))).selectByVisibleText("selectTrim");
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
	  
