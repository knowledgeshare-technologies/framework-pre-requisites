/*
 * package org.selenium4;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.remote.RemoteWebDriver; import
 * org.testng.annotations.AfterClass; import org.testng.annotations.BeforeClass;
 * import org.testng.annotations.Test; import java.net.MalformedURLException;
 * import java.net.URL; import static org.junit.Assert.*; public class Intern {
 * 
 * public static void main(String[] args) {
 * 
 * WebDriver driver = null; String URL =
 * "https://manytools.org/http-html-text/browser-language/"; public static
 * String status = "passed"; String username = "user-name"; String access_key =
 * "access-key";
 * 
 * ChromeOptions chromeOptions = new ChromeOptions();
 * chromeOptions.addArguments("--lang=he-IL");
 * 
 * ((Object) chromeOptions).setCapability("build",
 * "[Java] Locale Testing with Chrome & Windows on LambdaTest Selenium Grid");
 * chromeOptions.setCapability("name",
 * "[Java] Locale Testing with Chrome & Windows on LambdaTest Selenium Grid");
 * chromeOptions.setCapability("platform", "Windows 10");
 * chromeOptions.setCapability("browserName", "Chrome");
 * chromeOptions.setCapability("version","80.0");
 * chromeOptions.setCapability("tunnel",false);
 * chromeOptions.setCapability("network",true);
 * chromeOptions.setCapability("console",true);
 * chromeOptions.setCapability("visual",true);
 * 
 * driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key
 * + "@hub.lambdatest.com/wd/hub"), chromeOptions);
 * System.out.println("Started session");
 * 
 * 
 * driver.navigate().to(URL); driver.manage().window().maximize();
 * 
 * JavascriptExecutor executor = (JavascriptExecutor) driver; String language =
 * executor.
 * executeScript("return window.navigator.userlanguage || window.navigator.language"
 * ).toString(); driver.manage().timeouts().implicitlyWait(10,
 * TimeUnit.SECONDS); Not a good programming practice, added for demonstration
 * Thread.sleep(5000);
 * 
 * assertEquals(language, "he-IL"); Thread.sleep(2000);
 * 
 * if (driver != null) { ((JavascriptExecutor)
 * driver).executeScript("lambda-status=" + status); driver.quit(); } }
 * 
 * 
 * }
 */