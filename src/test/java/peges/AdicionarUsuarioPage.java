package peges;

import java.io.IOException;

import org.openqa.selenium.By;

import elementos.ElementosWeb;
import metodos.MetodosDeTest;

public class AdicionarUsuarioPage {

	MetodosDeTest metodos = new MetodosDeTest();

	ElementosWeb elemento = new ElementosWeb();

	By addUsuario = By.xpath("//a[@href='/v1.x/demo/bootstrap_theme_v4/add']");
	
	By btnSalvar = By.xpath("//button[@id='form-button-save']");
	
	By msg = By.xpath("//div[@id='report-success']/p");

	public void selecionarVersao(String versao) {

		metodos.digitar(elemento.versao, versao);

	}
	public void addUsuario() {
		
		metodos.clicar(addUsuario);
	}
	public void salvar() {
		
		metodos.clicar(btnSalvar);
		
	}
	public void validarMensagem(String string) throws IOException, InterruptedException {
		
		metodos.esperar(3000);
		
		metodos.validarTexto(msg, string);
		
		metodos.screenShot("CT01 - Adicionar usuario");
		
	}
}
