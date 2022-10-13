package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import drivers.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

//Esta classe chama o cucumberOptions e usa suas Tags

@RunWith(Cucumber.class)
@CucumberOptions(

		// onde criamos a pasta feature e colocaremos as features
		features = "src/test/resources/features",

		// criamos um pacote chamado steps em src/test/java, onde implementamos os
		// metodos gerados pelo cucumber
		glue = "steps",

		// colocamos as tags, podemos colocar uma ou mais tags

		// as tags servem para informar qual teste queremos executar, ex regressivos,
		// carga
		tags = "@AdicionarUsiario",

		// para o console não trazer caracteres especiais desnecessários
		monochrome = true,

		// colocaremos true, quando estivermos fazendo o planejamento, pois podemos ter
		// testes regressivos, e só irá gerar os steps após isso
		// colocaremos o false, quando já quisermos executar todos os testes
		dryRun = false,

		// 1ª "para deixarmos com a experiencia do cucumber" 2ª"colocamos o status
		// report - html ou json "
		// podemos colocar o status report em qualquer pasta, aqui iremos colocar na
		// target, podemos criar uma pasta tb
		/// cucumber-reporto é o nome do aquivo, podemos colocar um outro.html no final
		plugin = { "pretty", "html:target/cucumber-report.html" },

		// iremos utilizar o padra java, sem _
		// devemos tomar cuidado, pois devemos utilizar o snipppet do cucumber options
		snippets = SnippetType.CAMELCASE

)

public class Executa extends DriversFactory {

	@BeforeClass
	public static void iniciarTeste() {

		String urlTest = "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme";
		String navegador = "Chrome";

		if (navegador.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (navegador.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (navegador.equals("edge")) {
			System.setProperty("webdriver.msedge.driver", "./Drivers/edgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(urlTest);
		System.out.println("***************TESTE INICIADO COM SUCESSO!!!***************");

	}

	@AfterClass
	public static void finalizarTest() {
		driver.quit();
		System.out.println("***************TESTE FINALIZADO COM SUCESSO!!!***************");

	}

}
