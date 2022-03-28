package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.PageLogin;

public class TestLogin extends TestSetup {

	@Test(description=" Login with incorrect username and password should return invalid email text ",enabled=true)
	@Parameters({"UserTyping" , "PwTyping"}) 
	public void loginInvalidMail(String ramdomUser, String ramdomPw) {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.setLogin(ramdomUser, ramdomPw);
		Assert.assertTrue(pageLogin.invalidMailMessage().contains("Invalid email address.")," intentional failure. checking that the text \\ \"Invalid email address. \\\" is correctly displayed when entering an incorrect username and pw ");
	}	
	
	@Test(description=" Login failed without user input and password, returns the email request in the account as text ",enabled=true)
	public void loginMailRequire() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.setLogin("","");
		Assert.assertNotNull(pageLogin.requireMail(), " Cannot find the box that refers to the lack of mail on the page ");
		Assert.assertTrue(pageLogin.textMail().contains("An email address required.")," User and password entered must be null and the server response should be   -An email address required.  ");
	}
}
