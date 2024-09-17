package shop;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ramya\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung s24 ultra 5g mobile");
		driver.findElement(By.id("nav-search-submit-button")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	    driver.findElement(By.linkText("Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Yellow, 12GB, 256GB Storage)")).click();
	    Set<String> window=driver.getWindowHandles();
	    Iterator<String> it=window.iterator();
	    String parent=it.next();
	    String child=it.next();
	    driver.switchTo().window(child);
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,500)");    
      WebElement d=driver.findElement(By.xpath("//select[@id='quantity']"));
      Select s=new Select(d);
      s.selectByIndex(1);
     driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
     driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']")).click();
      
	    
	}

}
