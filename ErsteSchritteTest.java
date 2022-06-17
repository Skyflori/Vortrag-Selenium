package SeleniumErsteSchritte;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErsteSchritteTest {
	public WebDriver driver;

	@Test
	public void alleSchritte() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\flori\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SeleniumTest1\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://google.com");
		String title = driver.getTitle();
		Assertions.assertEquals("Google", title);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement cookie = driver.findElement(By.id("L2AGLb"));
		cookie.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement searchButton = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));

		searchBox.sendKeys("Hochschule Aalen");
		searchButton.click();

		searchBox = driver.findElement(By.name("q"));
		String value = searchBox.getAttribute("value");
		Assertions.assertEquals("Hochschule Aalen", value);
	}
}
