import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		
		// Declare ad instialize Object
		System.setProperty("webdriver.chrome.driver","W:\\PG_DAC\\SDM\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver1 = new ChromeDriver();
		
		driver1.navigate().to("http://commerce.vinayavish.com/");
		
		driver1.manage().window().maximize();
		driver1.manage().deleteAllCookies();
		driver1.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		
//		Select degree college 
		driver1.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
//		select Post graduation
		driver1.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
//		select M.Sc information Technology
		driver1.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li[3]/a")).click();
//		select add to cart for artificial intelligence book
		driver1.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]")).click();
		
		// checkout 
		driver1.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/i")).click();
		
		//continue
		driver1.findElement(By.id("button-account")).click();
		
		
		
		
		
	}

}
