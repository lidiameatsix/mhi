package meliahotels.meliahotels;

import java.io.IOException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import navegador.Navegador;
import meliahotels.meliahotels.LogIn_Page;


public class TestLogin {
	String url = "https://www.melia.com/";
	LogIn_Page objLogin;
	Navegador navegador = new Navegador(url);

	@Parameters ({"browser"})
	@BeforeTest
	public void setup(String browser){
		navegador.nav(url, browser);
	}

	// @SuppressWarnings("deprecation")
	// @BeforeTest
	// public void nav() {
	// System.setProperty("webdriver.chrome.driver",
	// "./driver/chromedriver.exe");
	// ChromeOptions options = new ChromeOptions();
	// options.addArguments("--incognito");
	// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	// driver = new ChromeDriver(capabilities);
	// driver.manage().window().maximize();
	// driver.manage().deleteAllCookies();
	// driver.get("https://www.melia.com/");
	// }

	@Parameters({"username", "password", "browser"})
	@Test(priority = 0)
	public void test_Login(String username, String password, String browser) throws InterruptedException, IOException {
		objLogin = new LogIn_Page(navegador.getDriver());
		objLogin.loginToMelia(username, password, browser);
	}

	// @Test(priority=1)
	// public void test_Logout(){
	// objLogout = new LogOut_Page(driver);
	// objLogout.logoutFcb();
	// objLogin = new LogIn_Page(driver);
	// Assert.assertTrue(objLogin.getLoginUser());
	// }

	@AfterTest
	public void cerrar() {
		navegador.getDriver().quit();
	}

}
