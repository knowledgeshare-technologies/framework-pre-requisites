package framework.prerequisites;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class video_titles {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://studio.youtube.com/channel/UC_XAnOgrfi07e4f0r96P8lA/videos/upload?filter=%5B%5D&sort=%7B%22columnType%22%3A%22date%22%2C%22sortOrder%22%3A%22DESCENDING%22%7D");
		driver.get("http://www.youtube.com");
		driver.findElement(By.xpath("(//*[@class='yt-simple-endpoint style-scope ytd-button-renderer'])[4]")).click();
		List<WebElement> video_titles= driver.findElements(By.xpath("//a[@id='video-title']"));

			for( WebElement product : video_titles)
			{
					System.out.println(product.getText());
					System.out.println("*********************************************************************");
			}
		
	}

}
