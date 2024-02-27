package day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Qes1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// load the URL
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Switch to the iframe context
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='tox-edit-area__iframe']"));
		driver.switchTo().frame(iframe);
		
		//Locate the "p" tag 
		WebElement tag = driver.findElement(By.tagName("p"));
		tag.clear();
		tag.sendKeys("Hello People");
		
		// Close the browser 
		//driver.quit();
		
		
	}

}
