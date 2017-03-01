package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
      
        WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("u_0_1")).sendKeys("Yajing");
		driver.findElement(By.id("u_0_3")).sendKeys("Wu");
		driver.findElement(By.id("u_0_6")).sendKeys("wuyajing527@gmail.com");
		driver.findElement(By.id("u_0_9")).sendKeys("wuyajing527@gmail.com");
		driver.findElement(By.id("u_0_d")).sendKeys("adlslslferw");
		Thread.sleep(1000);
		Select dropdown = new Select(driver.findElement(By.id("u_0_f")).findElement(By.id("month")));
		dropdown.selectByVisibleText("May");
		dropdown = new Select(driver.findElement(By.id("u_0_f")).findElement(By.id("day")));
		dropdown.selectByVisibleText("27");
		dropdown = new Select(driver.findElement(By.id("u_0_f")).findElement(By.id("year")));
		dropdown.selectByVisibleText("1988");
	
		Thread.sleep(1000);
		driver.findElement(By.id("u_0_k")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("u_0_h")).click();
	    driver.close();
    }
}
