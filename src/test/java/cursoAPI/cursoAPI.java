package cursoAPI;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


import utils.RestUtils;

public class cursoAPI {

	RestUtils restUtils = new RestUtils();

	public String mediaNotas(int nota1, int nota2) {

		int soma = nota1 + nota2;

		String situacao = "";

		if (soma < 10) {
			situacao = "reprovado";
		} else {
			situacao = "aprovado";
		}

		return situacao;
	}

	@Test
	public void testValidaAprovado() {

		String resultadoAtual = mediaNotas(5, 5);
		assertEquals("Aprovado", resultadoAtual);

	}

	@Test
	public void testValidaReprovado() {

		String resultadoAtual = mediaNotas(5, 3);
		assertEquals("Reprovado", resultadoAtual);

	}

	@Test
	public void testError() throws Exception {

		throw new Exception("erro!");

	}

	@Test
	public void assertTrue() throws Exception {

		throw new Exception("erro!");

	}

	@Test
	public void realizarGet() {

		// viacep.com.br/ws/{{CEP}}/json/
		
		restUtils.get("http://viacep.com.br/ws/", "06172226/json/");
		String logradouro = restUtils.key("logradouro");
		String complemento = restUtils.key("complemento");

		assertEquals("Rua Olívio Basílio Marçal", logradouro);
		assertEquals("(Jardim Cirino)", complemento);
		assertEquals("Osasco", restUtils.key("localidade"));     
	
	}

	@Test
	public void buscaCep() {
		// viacep.com.br/ws/{{CEP}}/json/

		restUtils.get("http://viacep.com.br/ws/", "06273110/json/");
		String logradouro = restUtils.key("logradouro");
		String complemento = restUtils.key("complemento");

		assertEquals("Rua São Francisco", logradouro);
		assertEquals("", complemento);
		assertEquals("Osasco", restUtils.key("localidade"));
	}
	
	@Test
	public void realizaPost() {
		
		String json = " {\"titulo\": \"testeServico\",\"cliente\": [{\"nome\": \"Vinicius\",\"idade\": \"24\"},{\"nome\": \"Thais\",\"idade\": \"26\"}]} ";
		
		restUtils.post("https://jsonplaceholder.typicode.com", "/posts", json);
		
		assertEquals("Vinicius", restUtils.key("cliente[0].nome"));
		assertEquals("24", restUtils.key("cliente[0].idade"));
		assertEquals("Thais", restUtils.key("cliente[1].nome"));
		
	}
	
	@Test
	public void realizaPOSTMap() {
		
		Map<String, Object> json = new HashMap<>();
		List<Map<String, Object>> listDeClientes = new ArrayList<Map<String, Object>>();
		Map<String, Object> cliente = new HashMap<>();
		Map<String, Object> clienteDois = new HashMap<>();
		cliente.put("nome", "Vinicius");
		cliente.put("idade", "24");
		clienteDois.put("nome", "Thais");
		clienteDois.put("idade", "26");
		listDeClientes.add(cliente);
		listDeClientes.add(clienteDois);
		json.put("titulo", "testeServico");
		json.put("cliente", listDeClientes);
		
		restUtils.post("https://jsonplaceholder.typicode.com", "/posts", json);
		
		assertEquals("Vinicius", restUtils.key("cliente[0].nome"));
		assertEquals("24", restUtils.key("cliente[0].idade"));
		assertEquals("Thais", restUtils.key("cliente[1].nome"));
		
	}

}
