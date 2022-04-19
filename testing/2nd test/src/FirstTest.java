import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {

	public static void main(String[] args) {
		// Declare ad instialize Object
		System.setProperty("webdriver.chrome.driver","W:\\PG_DAC\\SDM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Virat Kohli");
		
		driver.findElement(By.name("btnK")).submit();
		
		driver.getTitle();
      
      //WebElement searchBox = driver.findElement(By.name("q"));
      
      //searchBox.sendKeys("Prof. Ajit Vishwakarma");
      
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/div[2]/div[3]/a")).click();

		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	}

}