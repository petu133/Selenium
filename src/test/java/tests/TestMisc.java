package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageDetails;

public class TestMisc extends TestSetup {

	@Test(description="Verification of the color that shows, by default, the product in its detail",enabled=true)
	public void productDet(){
		PageDetails product = new PageDetails(driver);
		product.setProductDetailColor("rgba(243, 156, 17, 1)");
		Assert.assertEquals(product.productRgb(), product.expectedColor(), " Color entered and product color must match ");
	}
	
	
}
