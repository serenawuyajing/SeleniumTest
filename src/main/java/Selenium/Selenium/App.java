package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        
        WebDriver driver = new FirefoxDriver();
		driver.get("https://ca.indeed.com/?r=us");
		driver.findElement(By.id("what")).sendKeys("Software");;
		driver.findElement(By.id("fj")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		driver.close();
    }
}
