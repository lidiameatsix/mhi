package meliahotels.meliahotels;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class Buscador {
	int mes = 0;
	int dia = 0;
	int year = 2018;
	String aux = fechaAleatoria();
	String auxV = fechaVuelta();
	String aux2 = "li[class=\"day "+aux+" available\"]";
	String auxV2 = "li[class=\"day "+auxV+" available available-checkOut\"]";
	WebDriver driver;
	private By destino = By.id("mbe-destination-input");
//	private By elemento = By.cssSelector("li[class=\"item\"]");
	private By elemento = By.cssSelector("li[class=\"item default\"]");
	private By fechaIN = By.cssSelector(aux2);
	private By fechaOUT = By.cssSelector(auxV2);
	private By fechaINC = By.cssSelector("li[class=\"day d2018-7-12 available\"]");
	private By fechaOUTC = By.cssSelector("li[class=\"day d2018-7-20 available available-checkOut\"]");
	private By buscar = By.cssSelector("div[class=\"mbe-form-field mbe-button\"]");
	private ArrayList<String> cities = new ArrayList<String>();
	String nombre = Ciudades();
	
		
	public Buscador(WebDriver driver) {
		this.driver = driver;
	}
	
	@SuppressWarnings("deprecation")
	public String fechaAleatoria(){
		java.util.Date hoy = new Date();
		mes = (int) (Math.random()*12+1);
		if ((mes == 1)||(mes == 3)||(mes == 5)||(mes == 7)||(mes == 8)||(mes == 10)||(mes == 12)){
			dia = (int) (Math.random()*31+1);
		}
		else if ((mes == 4)||(mes == 6)||(mes == 9)||(mes == 11)){
			dia = (int) (Math.random()*30+1);
		}
		else if (mes == 2){
			dia = (int) (Math.random()*28+1);
		}
		if (mes == (int) hoy.getMonth()){
			if (dia < hoy.getDay()){
				year = 2019;
			}
		}
		else if (mes < (int) hoy.getMonth()){
			year = 2019;
		}
		String fecha = "d"+year+"-"+mes+"-"+dia;
		return fecha;
	}
	
	public String fechaVuelta(){
		int nNoches = (int) (Math.random()*62+1);
		System.out.println(nNoches);
		int daux = dia+nNoches;
		int mesOut = mes;
		int dOut = dia;
		int yearOut = year;
		String fechaOut = "";
		if ((mes == 1)||(mes == 3)||(mes == 5)||(mes == 7)||(mes == 8)||(mes == 10)||(mes == 12)){
			if (daux > 31){
				dOut = 31 - dia;
				dOut = nNoches - dOut;
				mesOut = mes+1;
				if ((dOut > 28)&&(mesOut==2)){
					int a1 = dOut - 28;
					dOut = a1;
					mesOut = mesOut+1;
				}
				else if ((dOut > 30)&&((mes == 4)||(mes == 6)||(mes == 9)||(mes == 11))){
					int a1 = dOut - 30;
					dOut = a1;
					mesOut = mesOut+1;
				}
				else if ((dOut > 31)&&((mes == 1)||(mes == 3)||(mes == 5)||(mes == 7)||(mes == 8)||(mes == 10)||(mes == 12))){
					int a1 = dOut - 31;
					dOut = a1;
					mesOut = mesOut+1;
				}
			}
			else {
				dOut = daux;
			}
		} 
		else if ((mes == 4)||(mes == 6)||(mes == 9)||(mes == 11)){
			if (daux > 30){
				dOut = 30 - dia;
				dOut = nNoches - dOut;
				mesOut = mes+1;
				if ((dOut > 28)&&(mesOut==2)){
					int a1 = dOut - 28;
					dOut = a1;
					mesOut = mesOut+1;
				}
				else if ((dOut > 30)&&((mes == 4)||(mes == 6)||(mes == 9)||(mes == 11))){
					int a1 = dOut - 30;
					dOut = a1;
					mesOut = mesOut+1;
				}
				else if ((dOut > 31)&&((mes == 1)||(mes == 3)||(mes == 5)||(mes == 7)||(mes == 8)||(mes == 10)||(mes == 12))){
					int a1 = dOut - 31;
					dOut = a1;
					mesOut = mesOut+1;
				}
			}
			else {
				dOut = daux;
			}
		}
		else if (mes == 2){
			if (daux > 28){
				dOut = 28 - dia;
				dOut = nNoches - dOut;
				mesOut = mes+1;
				if ((dOut > 28)&&(mesOut==2)){
					int a1 = dOut - 28;
					dOut = a1;
					mesOut = mesOut+1;
				}
				else if ((dOut > 30)&&((mes == 4)||(mes == 6)||(mes == 9)||(mes == 11))){
					int a1 = dOut - 30;
					dOut = a1;
					mesOut = mesOut+1;
				}
				else if ((dOut > 31)&&((mes == 1)||(mes == 3)||(mes == 5)||(mes == 7)||(mes == 8)||(mes == 10)||(mes == 12))){
					int a1 = dOut - 31;
					dOut = a1;
					mesOut = mesOut+1;
				}
			}
			else {
				dOut = daux;
			}
		}
		if (mesOut > 12){
			mesOut = mesOut - 12;
			yearOut = year+1;
		}
		fechaOut = "d"+yearOut+"-"+mesOut+"-"+dOut;
		return fechaOut;
	}
	
	public String Ciudades(){
		cities.add("MAD");
		cities.add("NUE");
		cities.add("PUN");
		cities.add("DEL");
		cities.add("LLOR");
		cities.add("BAR");
		cities.add("ALA");
		cities.add("MIA");
		cities.add("ANG");
		cities.add("ARGEN");
		cities.add("CAN");
		cities.add("AUS");
		int nCiu = (int) (Math.random()*9);
		System.out.println(nCiu);
		String ciu = cities.get(nCiu);
		System.out.println(ciu);
		return ciu;
	}

	public void clickBuscador() {
		driver.findElement(destino).click();
	}

	public void setDestino(String nombre, String browser) {
		if (browser.equals("IE")){
			nombre = "MAD";
		}
		driver.findElement(destino).sendKeys(nombre);

	}

	public void clickElemento() {

		driver.findElement(elemento).click();

	}
	
	public void fechaIN(String browser){
		if (browser.equals("chrome")){
			driver.findElement(fechaINC).click();
		}
		else {
			driver.findElement(fechaIN).click();
		}
		
	}
	
	public void fechaOUT(String browser){
		if (browser.equals("chrome")){
			driver.findElement(fechaOUTC).click();
		}
		else {
			driver.findElement(fechaOUT).click();
		}	
	}

	public void busqueda(){
		driver.findElement(buscar).click();
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
	 * @throws ParseException 
	 * @throws IOException
	 * 
	 * 
	 */

	@Parameters ({"browser"})
	public void buscar(String browser) throws InterruptedException{
		System.out.println(aux);
		System.out.println(auxV);
		this.clickBuscador();
		System.out.println("click buscador");
		Thread.sleep(5000);
		System.out.println("espera");
		this.setDestino(nombre, browser);
		System.out.println("introduce Madrid");
		Thread.sleep(5000);
		System.out.println("espera2");
		this.clickElemento();
		System.out.println("click elemento");
		Thread.sleep(8000);
		System.out.println("espera3");
		this.fechaIN(browser);
		Thread.sleep(1000);
		System.out.println("click fecha in");
		Thread.sleep(4000);
		this.fechaOUT(browser);
		System.out.println("click fecha out");
		Thread.sleep(5000);
		this.busqueda();
		System.out.println("click buscar");
		Thread.sleep(15000);
	}
}
