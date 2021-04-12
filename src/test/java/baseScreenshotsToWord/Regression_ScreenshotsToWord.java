package baseScreenshotsToWord;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import methods.Reusable_methods;

public class Regression_ScreenshotsToWord {

	public static String[] ScreenshotNames= new String[100];
	public static int array_increment=0;
	public static WebDriver driver;
	private static Reusable_methods reuse;
	
	public static void main(String[] args) throws IOException, XmlException 
	{
		
		WebDriverManager.firefoxdriver().setup();
		driver =new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		
		reuse.captureScreenshot(ScreenshotNames[array_increment++]="HomePage", driver);
		driver.findElement(By.name("q")).sendKeys("Knowledge Share");
		reuse.captureScreenshot(ScreenshotNames[array_increment++]="TextTyped", driver);
		System.out.println("Test");
		reuse.saveScreenshotsToWordDocument("Regression_Results",ScreenshotNames);
		
	}

}
