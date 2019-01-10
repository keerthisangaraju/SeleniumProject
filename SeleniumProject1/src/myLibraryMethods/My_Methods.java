package myLibraryMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class My_Methods 
{

	public static void HighLightElement(WebDriver driver ,WebElement web_element)
	{
		JavascriptExecutor JE=(JavascriptExecutor)driver;
		JE.executeScript("arguments[0].setAttribute('style','background: yellow;');", web_element);
		try 
		{
			Thread.sleep(1000);	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		JE.executeScript("arguments[0].setAttribute('style','background: white;');", web_element);
	
	}
	
	public static void CaptureScreenShot(WebDriver driver)
	{
		TakesScreenshot TS = (TakesScreenshot)driver;
		File srcFile = TS.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+System.currentTimeMillis()+".png");
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Captured Screenshot");
		
	}
}


