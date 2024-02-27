package day21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		String exptext = "New Window";
		String expwindow = "New Window";

		// load the URL
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Click Here")).click();

		// Switch to the newly opened window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindow = new ArrayList<>(windowHandles);
		driver.switchTo().window(lstWindow.get(1));

		String acttext = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();

		// Verify that the text "New Window" is present on the page
		if (acttext.equals(exptext)) {

			System.out.println("New Window is opened");
		} else {
			System.out.println("New Window is not opened");
		}

		// Switch back to the original window
		driver.switchTo().parentFrame();

		// Verify that the original window is active
		String actorginalwindow = driver.getTitle();
		driver.close();
		if (actorginalwindow.equals(expwindow)) {

			System.out.println("original window is active");
		} else {
			System.out.println("original window is inactive");
		}

		//// Close the new window
		driver.quit();
	}

}
