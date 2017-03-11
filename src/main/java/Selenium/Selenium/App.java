package Selenium.Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Facebook sign up page test
 *
 */
public class App 
{
	public static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul","Aug","Sep", "Oct", "Nov","Dec"};
    public static void main( String[] args ) throws InterruptedException, SQLException
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql driver is not found!");
			e.printStackTrace();
		}
		String dbUrl = "jdbc:mysql://localhost/test";
		Connection conn = DriverManager.getConnection(dbUrl, "root", "988527");
		Statement statement = conn.createStatement();
         // Result set get the result of the SQL query
        ResultSet result = statement.executeQuery("select * from Client");
        WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
         while(result.next()){
        	 String firstName = result.getString("FirstName");
        	 System.out.println(firstName);
        	 driver.findElement(By.id("u_0_1")).sendKeys(firstName);
        	 
        	 String lastName = result.getString("LastName");
        	 System.out.println(lastName);
     		 driver.findElement(By.id("u_0_3")).sendKeys(lastName);
     		 
     		 String email = result.getString("Email");
     		 driver.findElement(By.id("u_0_6")).sendKeys(email);
     		 driver.findElement(By.id("u_0_9")).sendKeys(email);
     		 
     		 String password = result.getString("Password");
     		 driver.findElement(By.id("u_0_d")).sendKeys(password);
     		 Thread.sleep(1000);
     		 
     		 String date = result.getString("Birth");
     		 System.out.println(date);
     		 
     		 Select dropdown = new Select(driver.findElement(By.id("u_0_e")).findElement(By.id("month")));
     		 int monthIndex = Integer.parseInt(date.substring(5,7))-1;
     		 dropdown.selectByVisibleText(months[monthIndex]);
     		 dropdown = new Select(driver.findElement(By.id("u_0_e")).findElement(By.id("day")));
     		 dropdown.selectByVisibleText(date.substring(8));
     		 dropdown = new Select(driver.findElement(By.id("u_0_e")).findElement(By.id("year")));
     		 dropdown.selectByVisibleText(date.substring(0, 4));
     		 Thread.sleep(1000);
     		 
     		 String sex= result.getString("Sex");
     		 if(sex.equals("Female")){
     			 driver.findElement(By.id("u_0_k")).click();
     		 }else{
     			 driver.findElement(By.id("u_0_l")).click();
     		 }		
     		 Thread.sleep(1000);
     		 driver.findElement(By.id("u_0_h")).click();
         }
         conn.close();
         driver.close();
    }
}
