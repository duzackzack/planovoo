package br.com.unicsul.planovoo.dao;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.unicsul.planovoo.constant.Constantes;
import br.com.unicsul.planovoo.entity.ResultsTripulantes;
import br.com.unicsul.planovoo.json.GsonHttpMessageConverter;
public class ConnectTripulantesDAO {


	public ResponseEntity<?> resultTripulantes() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		Object responseEntity = restTemplate.exchange(Constantes.urlTripulante, HttpMethod.GET, Cabecario.getCabecario(),ResultsTripulantes.class);
		return (ResponseEntity<ResultsTripulantes>) responseEntity;
	}
	
	


}