package shadowDom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingShadowDomNormalMethod {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
		
		  // 1- Shadow Host
		  
		  WebElement root_ShadowHost=driver.findElement(By.cssSelector(
		  "book-app[apptitle='BOOKS']"));
		  
		  // Use JavaScript statement to get the Shadow root
		  
		  JavascriptExecutor js= (JavascriptExecutor) driver; WebElement shadowDOM=
		  (WebElement) js.executeScript("return arguments[0].shadowRoot",
		  root_ShadowHost);
		  
		  //2 - Get app header 
		  WebElement appheader=shadowDOM.findElement(By.tagName("app-header"));
		  
		  //3 - Get app toolar 
		  WebElement apptoolbar=appheader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		  
		  //4 Get book input decorator 
		  WebElement bookinputdecorator=apptoolbar.findElement(By.tagName("book-input-decorator"))
		  ;
		  
		  //5 Get the input search box 
		  WebElement searchBox=bookinputdecorator.findElement(By.cssSelector("input[aria-label='Search Books']"));
		  
		  searchBox.sendKeys("Knowledge Share");
		  
		  System.out.println("Succesfully typed in to Search box ");
		 
		/*
		 * 
		 * //This Element is inside single shadow DOM. String cssSelectorForHost1 =
		 * "book-app[apptitle='BOOKS']"; Thread.sleep(1000); WebElement
		 * shadowDomHostElement =
		 * driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")); WebElement
		 * last = (WebElement) ((JavascriptExecutor)
		 * driver).executeScript("return arguments[0].shadowRoot",
		 * shadowDomHostElement); Thread.sleep(1000);
		 * last.findElement(By.cssSelector("input[aria-label='Search Books']")).
		 * sendKeys("Knowledge Share");
		 * 
		 */
		
	
	}

}
