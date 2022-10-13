package metodos;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import drivers.DriversFactory;

public class MetodosDeTest extends DriversFactory {

	// METODO PARA CLICAR EM UM ELEMENTO WEB, PASSANDO UM BY
	public void clicar(By elemento) {
		driver.findElement(elemento).click();

	}

	// METODO PARA CLICAR EM UM ELEMENTO WEB, PASSANDO UM WEBELEMENT
	public void clicar(WebElement elemento) {
		elemento.click();
	}

	public void digitar(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);

	}

	// VALIDA SE O TEXTO CAPTURADO CONTEM O TEXTO ESPERADO
	public void validarTexto(By elemento, String textoEsperado) {

		String textoCapturado = driver.findElement(elemento).getText();
		assertTrue(textoCapturado.contains(textoEsperado));

	}

	public void esperar(int tempo) throws InterruptedException {
		Thread.sleep(tempo);

	}

	public void screenShot(String nomeEvidencia) throws IOException {

		// aqui colocamamos o takeScreenshot na frente do driver para que ele possa
		// receber o takeScreenshor, pois não são da mesma classe
		TakesScreenshot scrShot = (TakesScreenshot) driver;

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);// output pega o arquivo//geramos foto

		File destFile = new File("./evidencias/" + nomeEvidencia + ".png");// destino da foto//geramos arquivo

		FileUtils.copyFile(srcFile, destFile);// pegamos o srcFile e colocamos no destino//pegamos a foto e colocamos no
												// caminho destino

	}

}
