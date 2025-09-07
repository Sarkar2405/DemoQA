package demoqa.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewWindowPage {
	
	WebDriver driver;
	
	public NewWindowPage(WebDriver driver) {
		this.driver= driver;
	}
	By add_new_window_btn_ele= By.id("windowButton");
	By new_window_heading= By.id("sampleHeading");
	
	public void checkNewWindow() {
		
		driver.findElement(add_new_window_btn_ele).click();
		
		String parentwindow= driver.getWindowHandle();
		Set<String> windows= driver.getWindowHandles();
		
		for(String childwindow:windows) {
			if(childwindow.equals(parentwindow))
			continue;
			else {
				driver.switchTo().window(childwindow);
				String new_window_heading_text= driver.findElement(new_window_heading).getText();
				Assert.assertEquals(new_window_heading_text, "This is a sample page");
			}
		}
		
		driver.switchTo().window(parentwindow);
	}
	

}
