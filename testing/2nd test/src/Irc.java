import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Irc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		// Declare ad instialize Object
		System.setProperty("webdriver.chrome.driver","W:\\PG_DAC\\SDM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.navigate().to("https://www.irctc.co.in/nget/train-search");

		
		
		driver1.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button")).click();
		driver1.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[1]")).click();
		driver1.findElement(By.xpath("//*[@id=\"2081518\"]")).sendKeys("Wali42");
		driver1.findElement(By.xpath("//*[@id=\"780083\"]")).sendKeys("Daniyal888");
		try {
			driver1.findElement(By.xpath("//*[@id=\"nlpAnswer\"]")).wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver1.findElement(By.xpath("//*[@id=\"login_header_disable\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/span/button")).click();
		driver1.findElement(By.xpath("")).click();
		
		
//		TimeUnit.MINUTES.sleep(1);
//		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();

		
		
		
		
		
	}

}
