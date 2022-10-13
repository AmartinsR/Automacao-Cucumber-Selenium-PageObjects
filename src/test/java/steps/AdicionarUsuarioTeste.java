package steps;

import java.io.IOException;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import peges.AdicionarUsuarioPage;

public class AdicionarUsuarioTeste {

	AdicionarUsuarioPage addUsuario = new AdicionarUsuarioPage();

	@Dado("que esteja com bootstrap v4")
	public void queEstejaComBootstrapV4() {

		addUsuario.selecionarVersao("Bootstrap V4 Theme");

	}

	@Dado("acione add custumer")
	public void acioneAddCustumer() {

		addUsuario.addUsuario();

	}

	@Quando("salvar o formulario")
	public void salvarOFormulario() {

		addUsuario.salvar();

	}

	@Entao("validamos mensagem de sucesso")
	public void validamosMensagemDeSucesso() throws IOException, InterruptedException {

		addUsuario.validarMensagem("Your data has been successfully stored into the database.");
		
	}

}
