package todo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TODOAppium {
	static AndroidDriver driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	@BeforeSuite
	public void StartTest() throws MalformedURLException {
		cap.setCapability("appium:devicename", "moto");
		cap.setCapability("appium:deviceId", "ZD2226LYBB");
		cap.setCapability("appium:Platformname", "Android");
		cap.setCapability("appium:Platformversion", "12");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability("appium:shouldTerminateApp", true);
	}
	@Test
	public void test() throws MalformedURLException {
		cap.setCapability("appium:apppackage", "com.tvisha.kanbantodo");
		cap.setCapability("appium:appactivity", "com.tvisha.kanbantodo.MainActivity");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver (url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"TODO\"]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Email\"]")).sendKeys("");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password (at least 8 characters)\"]")).sendKeys("");
		driver.findElement(By.id("Login")).click();
	}
	@AfterSuite
	public void endTest() {
		
	}
}
