package steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import utils.RestUtils;

public class JsonPlaceholderSteps {
	
	String url = "";
	String endpoint = "";
	Map<String, Object> json = new HashMap<>();
	List<Map<String, Object>> listDeClientes = new ArrayList<Map<String, Object>>();
	Map<String, Object> cliente = new HashMap<>();
	Map<String, Object> clienteDois = new HashMap<>();
	RestUtils restUtils = new RestUtils();
	
	@Dado("que acesso a url {string} com o endpoint {string}")
	public void que_acesso_a_url_com_o_endpoint(String url, String endpoint) {
	  this.url = url;
	  this.endpoint = endpoint;
	}

	@Quando("preencho o campo {string} com {string} no objeto json")
	public void preencho_o_campo_com_no_objeto_json(String key, String value) {
	 json.put(key, value);
	 
	}

	@Quando("preencho o campo {string} com {string} no objeto cliente")
	public void preencho_o_campo_com_no_objeto_cliente(String key, String value) {
	    cliente.put(key, value);
	}

	@Quando("preencho o campo {string} com {string} no objeto clienteDois")
	public void preencho_o_campo_com_no_objeto_clienteDois(String key, String value) {
		clienteDois.put(key, value);
	}

	@Quando("adiciono o objeto cliente na lista clientes")
	public void adiciono_o_objeto_cliente_na_lista_clientes() {
		listDeClientes.add(cliente);
	}

	@Quando("adiciono o objeto clienteDois na lista clientes")
	public void adiciono_o_objeto_clienteDois_na_lista_clientes() {
		listDeClientes.add(clienteDois);
	}

	@Quando("adiciono o campo {string} com a lista clientes no objeto json")
	public void adiciono_o_campo_com_a_lista_clientes_no_objeto_json(String value) {
	    json.put("cliente", listDeClientes);
	}

	@Quando("realizo a requisicao post")
	public void realizo_a_requisicao_post() {
	   restUtils.post(url, endpoint, json);
	}

	@Entao("valido que no campo {string} recebo o valor {string}")
	public void valido_que_no_campo_recebo_o_valor(String key, String value) {
		assertEquals(value, restUtils.key(key));
		restUtils.key(key);   
	}



	
}
