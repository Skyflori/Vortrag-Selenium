package SeleniumLiveDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WebTester {
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\flori\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SeleniumTest1\\lib\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://imgur.com/");

		// Cookie akzeptieren
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement cookie = driver.findElement(By.className("css-1hy2vtq"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		cookie.click();

		// Neuen Post auswählen
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement newPost = driver.findElement(By.className("newPostLabel"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		newPost.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		// Datei auswählen
		WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		// File zum Uploaden hineinlegen

		// int a == 1 -> large file
		// int a == 2 -> normal file
		int a = 1;
		if (a == 1) {
			chooseFile.sendKeys(
					"C:\\Users\\flori\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SeleniumTest1\\bilder\\Welt.jpg");
			boolean thrown = false;
			try {
				WebElement test = driver.findElement(By.className("UploadPost-postTitle"));
			}catch (org.openqa.selenium.NoSuchElementException e){ // Wenn diese geworfen wird, wurde das Element nicht gefunden
				thrown = true;
			}
			Assertions.assertTrue(thrown);
		} else if (a == 2) {
			chooseFile.sendKeys(
					"C:\\Users\\flori\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SeleniumTest1\\bilder\\Hund.png");

			WebElement title = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[1]/div/div[1]/div/span"));
			WebElement test = driver.findElement(By.className("UploadPost-postTitle"));
			String value = test.getText();
			Assertions.assertEquals("", value);
			
			title.sendKeys("Bild eines Hundes");
			WebElement description = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[1]/div/div[2]/div[2]/div[1]"));
			description.sendKeys("Ein Bild eines Hundes, der in den Bergen sitzt");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
			
			WebElement titleInput = driver.findElement(By.className("UploadPost-postTitle"));
			String pictureTitle = titleInput.getText();
			Assertions.assertEquals("Bild eines Hundes", pictureTitle);
		}
	}	
}
