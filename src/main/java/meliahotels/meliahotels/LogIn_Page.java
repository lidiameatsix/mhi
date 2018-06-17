package meliahotels.meliahotels;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class LogIn_Page {

	WebDriver driver;
	private By email = By.id("login-email");
	private By flechita = By.id("navlogin");
	private By pass = By.id("login-password");
	private By login = By.id("login-btn");
	private By logout = By.id("false-logout-btn");
//	private By logout = By.cssSelector("li[class=\"item default\"]");
	// LogOut_Page logout = new LogOut_Page(driver);

	public LogIn_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void clickFlechita() {
		driver.findElement(flechita).click();
	}

	public void setUserName(String userName) {

		driver.findElement(email).sendKeys(userName);

	}

	public void setPassword(String password) {

		driver.findElement(pass).sendKeys(password);
	}

	public void clickLogIn() {

		driver.findElement(login).click();

	}

	public File capturarPantalla() {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		return SrcFile;
	}

	public void clickLogOut() {

		driver.findElement(logout).click();

	}

	public boolean getLoginUser() {

		return driver.findElement(email) != null;

	}

	/**
	 * 
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * 
	 * 
	 */

	@Parameters({ "browser" })
	public void loginToMelia(String userName, String pass, String browser) throws InterruptedException, IOException {
		
//		if (browser.equals("IE")){
//			System.out.println("empieza espera");
//			Thread.sleep(25000);
//			System.out.println("espera carga pagina hecha");
//		}

//		System.out.println("empieza espera");
//		
//		Thread.sleep(25000);
//		
//		System.out.println("espera carga pagina hecha");
		
		this.clickFlechita();
		
		System.out.println("click flechita");

		Thread.sleep(3000);

		System.out.println("espera completada");

		this.setUserName(userName);

		this.setPassword(pass);

//		WebDriverWait wait = new WebDriverWait(driver, 300);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-btn")));

		Thread.sleep(3000);
		Thread.sleep(3000);

		this.clickLogIn();
//		this.clickLogIn();

		Thread.sleep(12000);

		if (driver.getCurrentUrl().equals("https://www.melia.com/")) {
			System.out.println("HAY CAPTCHA");
			File SrcFile = this.capturarPantalla();
			if (browser.equals("firefox")) {
				File DestFile = new File("./driver/FIREFOX/screen.png");
				FileUtils.copyFile(SrcFile, DestFile);
			} 
			
			else if(browser.equals("chrome")){
				File DestFile = new File("./driver/CHROME/screen.png");
				FileUtils.copyFile(SrcFile, DestFile);
			}
			else if(browser.equals("edge")){
				File DestFile = new File("./driver/EDGE/screen.png");
				FileUtils.copyFile(SrcFile, DestFile);
			}
			else if(browser.equals("IE")){
				File DestFile = new File("./driver/IE/screen.png");
				FileUtils.copyFile(SrcFile, DestFile);
			}
			
			Thread.sleep(1000);
		} 
		else {
			Thread.sleep(3000);
			// logout.logoutToMelia();
			this.clickFlechita();
			Thread.sleep(3000);
			this.clickLogOut();
			System.out.println("se hizo logout");

		}

	}

}
