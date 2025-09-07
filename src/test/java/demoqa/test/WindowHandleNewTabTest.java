package demoqa.test;

import org.testng.annotations.Test;

import demoqa.pageobjects.WindowHandleNewTabPage;

public class WindowHandleNewTabTest extends BaseTest {

	
	@Test
	public void checkNewTab() {
		WindowHandleNewTabPage newtab= new WindowHandleNewTabPage(driver);
		newtab.goToNewTab();
	}
}
