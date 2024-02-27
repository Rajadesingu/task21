package day21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesAutomation {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name=\"frame-top\"]"));
		driver.switchTo().frame(topFrame);

		// Verify that there are three frames on the page
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		if (frames.size() == 3) {
			System.out.println("There are three frames on the page");
		} else {
			System.out.println("There are not three frames on the page");
		}

		// Switch to the left frame
		driver.switchTo().frame("frame-left");
		String leftFrame = driver.findElement(By.tagName("body")).getText();
		if (leftFrame.contains("LEFT")) {
			System.out.println("Left frame has text \"LEFT\"");
		} else {
			System.out.println("Left frame does not have text \"LEFT\"");
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");

		// Switch to the middle frame
		driver.switchTo().frame("frame-middle");
		String middleFrame = driver.findElement(By.tagName("body")).getText();
		if (middleFrame.contains("MIDDLE")) {
			System.out.println("Middle frame has text \"MIDDLE\"");
		} else {
			System.out.println("Middle frame does not have text \"MIDDLE\"");
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");

		// Switch to the right frame
		driver.switchTo().frame("frame-right");
		String rightFrame = driver.findElement(By.tagName("body")).getText();
		if (rightFrame.contains("RIGHT")) {
			System.out.println("Right frame has text \"RIGHT\"");
		} else {
			System.out.println("Right frame does not have text \"RIGHT\"");
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();

		// Switch to the bottom frame
		driver.switchTo().frame(1);

		String bottomFrame = driver.findElement(By.tagName("body")).getText();
		if (bottomFrame.contains("BOTTOM")) {
			System.out.println("Bottom frame has text \"BOTTOM\"");
		} else {
			System.out.println("Bottom frame does not have text \"BOTTOM\"");
		}

		// Switch back to the top frame
		driver.switchTo().parentFrame();

		// Verify that the page title is "Frames"
		String pageTitle = driver.getCurrentUrl();

		if (pageTitle.contains("nested_frames")) {
			System.out.println("Page title is \"Frames\"");
		} else {
			System.out.println("Page title is not \"Frames\"");
		}

		// Close the browser instance
		driver.quit();
	}

}
