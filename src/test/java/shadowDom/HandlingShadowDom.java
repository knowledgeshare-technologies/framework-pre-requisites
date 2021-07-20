package shadowDom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingShadowDom {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
			driver.get("https://books-pwakit.appspot.com/");
		
		
		//This Element is inside single shadow DOM.
String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
Thread.sleep(1000);
WebElement shadowDomHostElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
WebElement last = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement);
Thread.sleep(1000);
last.findElement(By.cssSelector("input[aria-label='Search Books']")).sendKeys("Knowledge Share");	
	}

}
