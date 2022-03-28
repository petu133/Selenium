package tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.PageHome;

public class TestHomeStatus extends TestSetup {

	@Test(description=" Verify that the prices on sale on the Home page are shown in a certain color box ",enabled=true)
	public void verifColorOffPrices(){
		PageHome priceOffColor = new PageHome(driver);
		priceOffColor.setColorOffPrice("rgba(241, 51, 64, 1)");
		Assert.assertTrue(priceOffColor.colorCoincidence(), " Color of element found in PageHome does not match the one assigned as parameter through method setColorPriceOff ");  
		}
	
	@Test(description="Checking element format in the lower block of CMS information", timeOut=8000, enabled=true)
	public void formatInf() {
		PageHome blockCD = new PageHome(driver);
		SoftAssert check = new SoftAssert();
		blockCD.setCmsInfo("242, 242, 242, 1", "#ffffff");
		check.assertEquals(blockCD.blockColor(), "rgba("+blockCD.expectedColorBlock()+")"," The block background color must match the one entered as a parameter ");
		check.assertEquals(blockCD.frameColor(), blockCD.expectedColorFrame()," The background color of the frame selenium box must match the one entered as a parameter ");
		blockCD.setCmsInfo("21px", "13px", "#333333");
		check.assertEquals(blockCD.fontSizeTitleCB(),blockCD.pxTitle(), " Pixels observed in the browser must match the parameter entered for the title of the lower right block of information ");
		check.assertEquals(blockCD.fontSizeSubTitleCB(),blockCD.pxSub(), " Pixels observed in the browser must match the parameter entered for the subtitle of the lower right block of information ");
		String colorRgb = blockCD.colorSubTitleCB();
		String colorHex = Color.fromString(colorRgb).asHex();
		check.assertEquals(colorHex, blockCD.colorFontSub()," Font color that is observed in the browser must match the parameter entered for the text of the lower right block of information ");
		check.assertAll();
	}
	
	
		
	
	
}
