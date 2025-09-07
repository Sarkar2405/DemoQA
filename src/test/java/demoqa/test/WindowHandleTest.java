package demoqa.test;

import org.testng.annotations.Test;

import demoqa.pageobjects.NewTabPage;
import demoqa.pageobjects.NewWindowPage;



public class WindowHandleTest extends BaseTest {

	
	@Test
	public void testNewTab() {
		NewTabPage newtab= new NewTabPage(driver);
		newtab.checkNewTab();
	}
	
	@Test
	public void testNewWindow() {
		NewWindowPage newtab= new NewWindowPage(driver);
		newtab.checkNewWindow();
	}
}
