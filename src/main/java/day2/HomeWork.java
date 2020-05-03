package day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HomeWork {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.aero");
		dc.setCapability("appActivity", "com.aero.HomeActivity");
		dc.setCapability("deviceName", "RealMe5");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Appiumtest']").click();	
		
		driver.findElementById("com.aero:id/entry").sendKeys("Haiii");
		
		driver.findElementByAccessibilityId("Send").click();
		
		driver.findElementByClassName("android.widget.ImageView").click();
		
		System.out.println("Message Send Successfully");
		
		}

}
