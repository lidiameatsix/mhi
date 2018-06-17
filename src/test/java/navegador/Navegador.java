package navegador;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Navegador {
	private WebDriver driver;
	private String url;

	public Navegador(String Url) {
		this.setUrl(Url);
	}

	public void nav(String URL, String browser) {
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			setDriver(new ChromeDriver(options));
			
		} 
		else if (browser.equals("firefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			options.setCapability("marionette", true);
			setDriver(new FirefoxDriver(options));
			
		}
		else if (browser.equals("IE")){
			
			InternetExplorerOptions options = new InternetExplorerOptions();
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver(options);
			
		}
		else if (browser.equals("edge")){
			
			System.setProperty("webdriver.edge.driver", "./driver/MicrosoftWebDriver.exe");
			EdgeOptions capabilities = new EdgeOptions();
			driver = new EdgeDriver(capabilities);
			
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(URL);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
