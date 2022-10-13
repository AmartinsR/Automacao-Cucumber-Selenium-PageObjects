#language: pt

#aqui podemos colocar quandas tags quisermos 
@AdicionarUsiario
Funcionalidade: Adicionar usuario
	Como usuario queroadicionar um novo usuario para ter acesso ao sistema 
	
	@testePositivo
	Cenario: Adicionar um novo usuario
			Dado que esteja com bootstrap v4
			E acione add custumer
			Quando salvar o formulario 
			Entao validamos mensagem de sucesso