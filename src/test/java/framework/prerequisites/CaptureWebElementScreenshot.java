package framework.prerequisites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureWebElementScreenshot {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("kstest101@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		
		WebElement email_display=driver.findElement(By.className("account"));
		
		File scrfile=email_display.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("E:\\Selenium + Java - Youtube\\WebElements\\email_display.png"));
		
	}

}
