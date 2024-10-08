package assignment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class CrossBrowser {
	WebDriver driver;
	@Parameters({"bname"})
	
  @Test
  public void testparallel(String bname) throws MalformedURLException, InterruptedException {
  
	  if(bname.equals("Chrome")) {
		  ChromeOptions cap = new ChromeOptions();
		  driver = new RemoteWebDriver(new URL("http://localhost:4444"),cap);
		  System.out.println("Connection established with chrome browser");
		  
		  
	  }else if(bname.equals("Firefox")) {
		  FirefoxOptions ff = new FirefoxOptions();
		  driver = new RemoteWebDriver(new URL("http://localhost:4444"),ff);
		  System.out.println("Connection established with firefox browser");
		  
	  }else if(bname.equals("Edge")) {
		  EdgeOptions eo = new EdgeOptions();
		  driver = new RemoteWebDriver(new URL("http://localhost:4444"),eo);
		  System.out.println("Connection established with edge browser");
	  }
  
	  Thread.sleep(12000);
	  driver.get("https://www.amazon.in");
	  Thread.sleep(5000);
	  System.out.println("Application Excecuting parallelly");
	  driver.quit();
   }

}
