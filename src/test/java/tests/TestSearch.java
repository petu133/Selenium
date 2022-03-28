package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageSearch;

public class TestSearch extends TestSetup {
	
	@Test(description=" Search without result within the list corresponding to the women product ",enabled=true)
	public void searchWomen() {
		PageSearch women  = new PageSearch(driver);
		women.search("Women");
		Assert.assertNotNull(women.women(), " Cannot find the referenced web element in the women () method ");
		Assert.assertNotNull(women.womenTextOfPage(), " Cannot find the referenced web element in the womenTextOfPage () method ");
		Assert.assertEquals(women.womenTextOfPage(), "No results were found for your search \"" + women.womenText() +"\"" );
		}
		
	@Test(description=" Verify that the search result (dress) shows a quantity of product in the list equal to seven (7) ",enabled=true)
	public void searchDress() {
		PageSearch dress  = new PageSearch(driver);
		dress.search("DrEsS");
		Assert.assertNotNull(dress.productCountDress(), dress.productNotFound());
		Assert.assertEquals(dress.dressCantInfoUpperField(), dress.dressCantInfoLowerField());
		Assert.assertEquals(dress.dressCantInfoUpperField(), "Showing 1 - 7 of 7 items");
	}	
	
	@Test(description="Verify that the search with empty parameter returns the text \"Please enter a search keyword\" ",enabled=true)
	public void searchEmpty() {
		PageSearch pressEnter = new PageSearch(driver);
		pressEnter.search();
		Assert.assertNotNull(pressEnter.emptyBoxText(), "The search method of the pressEnter object does not allow the sending of parameters");
		Assert.assertEquals(pressEnter.textInEmptyBox(), "Please enter a search keyword");
	}	
	
	@Test(description=" Verify that the search result for X product returns the quantity on the list equal to the number entered (n) expected ",enabled=true)
	public void searchCantDress() {
		PageSearch cantDress = new PageSearch(driver);
		cantDress.searchVerifCant("dress",7);
		cantDress.productList();
		Assert.assertEquals(cantDress.cantProdList(), cantDress.cantProd()," The quantity of products must match the number entered in the method parameter searchVerifCant");
	}
	
	@Test(description=" Verify that the search result for X product returns the quantity on the list equal to the number entered (n) expected ",enabled=true)
	public void searchCantShirt() {
		PageSearch cantShirt = new PageSearch(driver);
		cantShirt.searchVerifCant("shirt",1);
		cantShirt.productList();
		Assert.assertEquals(cantShirt.cantProdList(), cantShirt.cantProd()," The quantity of products must match the number entered in the searchVerifCant method parameter. ");
	}
}
