package day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		
		//Amazon drive
		//dc.setCapability("appPackage", "com.amazon.drive");
		//dc.setCapability("appActivity", "com.amazon.drive.activity.MainActivity");
		
		
		//Message
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		
		
		dc.setCapability("deviceName", "RealMe5");
		dc.setCapability("platformName", "Android");
		//dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("New Message").click();
		
		driver.findElementById("com.android.mms:id/recipients_editor").sendKeys("9976102824");
		
		driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("Hai .. This message is from appium Script");
		
		
		driver.findElementByAccessibilityId("Send").click();
		
		driver.findElementByAccessibilityId("Go to last level").click();
		
		
		int count = driver.findElementsByCssSelector("#android:id/list android.view.ViewGroup").size();
		
		System.out.println(count);
		
		
		Thread.sleep(5000);
		
		driver.findElementById("com.android.mms:id/animated_hint").click();
		
		driver.findElementById("com.android.mms:id/search_src_text").sendKeys("Hai .. This message is from appium Script");
		
		String message = driver.findElementById("com.android.mms:id/subtitle").getText();
		
		System.out.println("Message is " + message);
		
		System.out.println("Completed");

	} 

}