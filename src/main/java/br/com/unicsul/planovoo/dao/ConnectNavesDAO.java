package br.com.unicsul.planovoo.dao;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.unicsul.planovoo.constant.Constantes;
import br.com.unicsul.planovoo.entity.ResultsNave;
import br.com.unicsul.planovoo.json.GsonHttpMessageConverter;
public class ConnectNavesDAO {
	public ResponseEntity<?> resultNave() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		Object responseEntity = restTemplate.exchange(Constantes.urlNave, HttpMethod.GET, Cabecario.getCabecario(),ResultsNave.class);
		return (ResponseEntity<ResultsNave>) responseEntity;
		
	}
	
}