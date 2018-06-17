package meliahotels.meliahotels;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import navegador.Navegador;
import meliahotels.meliahotels.Buscador;

public class TestBuscador {
	
	String url = "https://www.melia.com/";
	Buscador objLogin;
	Navegador navegador = new Navegador(url);

	@Parameters ({"browser"})
	@BeforeTest
	public void setup(String browser){
		navegador.nav(url, browser);
	}
	
	@Parameters({"browser"})
	@Test(priority = 0)
	public void test_Login(String browser) throws InterruptedException {
		objLogin = new Buscador(navegador.getDriver());
		objLogin.buscar(browser);
	}
	
	@AfterTest
	public void cerrar() {
		navegador.getDriver().quit();
	}

}
