package demoqa.pageobjects;

import java.util.Set;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTabPage {
	
	WebDriver driver;
	
	public NewTabPage(WebDriver driver) {
		this.driver= driver;
	}
	By newtab_btn_ele= By.xpath("//button[@id='tabButton']");
	
	public void checkNewTab() {
		driver.findElement(newtab_btn_ele).click();
		String parentwindow= driver.getWindowHandle(); 
		Set<String> allwindows= driver.getWindowHandles();
	
		for(String childwindow:allwindows) {
			//String windowURL= driver.switchTo().window(childwindow).getCurrentUrl();
			//System.out.println(windowURL);
			//if (windowURL.equals("https://demoqa.com/sample")) 
			if (!childwindow.equals(parentwindow)) 
			{
				driver.switchTo().window(childwindow);
				String newtabheading= driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(newtabheading);
				Assert.assertEquals(newtabheading, "This is a sample page");	
			}
			else continue;
		}
		
		driver.switchTo().window(parentwindow);
	}

}