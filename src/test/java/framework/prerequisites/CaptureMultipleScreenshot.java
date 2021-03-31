package framework.prerequisites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureMultipleScreenshot {

	public static void main(String[] args) throws IOException 
	{
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();	
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		CaptureMultipleScreenshot.capture_with_name(driver,"homepage");
		driver.findElement(By.name("q")).sendKeys("Knowledge Share");
		CaptureMultipleScreenshot.capture_with_name(driver,"texttyped");
		
		
	}
	
	/*
	 * public static void capture(WebDriver driver) throws IOException { File src=
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(src, new
	 * File("E:\\Selenium + Java - Youtube\\Screenshots_Captures\\" + System.currentTimeMillis() + "
	 * Screenshot.png")); }
	 */
	
	public static void capture_with_name(WebDriver driver,String name) throws IOException 
	{ 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Selenium + Java - Youtube\\Screenshots_Captures\\" + name + ".png")); 
	}

}
