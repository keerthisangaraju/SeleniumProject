package co.edureka.selenium.course;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Edureka_Assignment 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Keerthi\\SeleniumDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		// 1 . Verify presence of Username & Password field
		boolean Username_Field_Present= false;
		boolean Password_Field_Present= false;
		try
		{
			WebElement Username = driver.findElement(By.id("email"));
			Username_Field_Present = true;
			Username.clear();
			
		}
		catch(NoSuchElementException e)
		{
			Username_Field_Present= false;
		}
		
		try 
		{
			WebElement Password = driver.findElement(By.id("pass"));
			Password_Field_Present = true;
			Password.clear();

		}
		catch(NoSuchElementException e)
		{
			Username_Field_Present= false;
		}

		if(Username_Field_Present)
			System.out.println("Username field present");
		else
			System.out.println("Username field NOT present");
		
		if(Password_Field_Present)
			System.out.println("Password field present");
		else
			System.out.println("Password field NOT present");
		
		System.out.println("Verified the Username and password presence");
		//Entering the values
		WebElement Username = driver.findElement(By.id("email"));
		
		// 2. Enter values 
		driver.findElement(By.id("pass")).sendKeys("pass");
		Username.sendKeys("abcd@gmail");
		Thread.sleep(3000);
		
		// 3. Verify entered value is same
		String data = Username.getAttribute("value");
		System.out.println(data);
		int chk = data.compareTo("abcd@gmail");
		if(chk == 0)
			System.out.println("Input field has same data");
		else
			System.out.println("Input field has NO same data");
		
		// 4. Get Page Source content print on console
		System.out.println("PageSource"+driver.getPageSource());
			
	}

}
