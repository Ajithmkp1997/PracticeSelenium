package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login {
	//public ChromeDriver driver;
@Test
	public static void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//to lanch chrome
		ChromeDriver driver=new ChromeDriver();
		//to maximize the browser
		driver.manage().window().maximize();
		//to load the URL
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(3000);
		WebElement vendorbtn = driver.findElementByXPath("//button[text()=' Vendors']");
		Actions builder=new Actions(driver);
		builder.moveToElement(vendorbtn).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
        driver.findElementById("buttonSearch").click();
        String text = driver.findElementByXPath("//td[text()='France']").getText();
        System.out.println(text);
        driver.findElementByLinkText("Log Out");
        driver.close();
        

	}

}
