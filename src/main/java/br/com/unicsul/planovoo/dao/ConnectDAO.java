package br.com.unicsul.planovoo.dao;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.unicsul.planovoo.constant.Constantes;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.ResultsNave;
import br.com.unicsul.planovoo.entity.ResultsPlanetas;
import br.com.unicsul.planovoo.entity.ResultsTripulantes;
import br.com.unicsul.planovoo.entity.Tripulantes;
import br.com.unicsul.planovoo.json.GsonHttpMessageConverter;

public class ConnectDAO {

	public ResponseEntity<?> resultPlanetas() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		ResponseEntity<ResultsPlanetas> responseEntity = restTemplate.exchange(Constantes.urlPlaneta, HttpMethod.GET, getCabecario(),ResultsPlanetas.class);
		return responseEntity;
	}

	public ResponseEntity<?> resultTripulantes() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		ResponseEntity<ResultsTripulantes> responseEntity = restTemplate.exchange(Constantes.urlTripulante, HttpMethod.GET, getCabecario(),ResultsTripulantes.class);
		return responseEntity;
	}
	
	public ResponseEntity<?> resultNave() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		ResponseEntity<ResultsNave> responseEntity = restTemplate.exchange(Constantes.urlNave, HttpMethod.GET, getCabecario(),ResultsNave.class);
		return responseEntity;
	}
	
	public HttpEntity getCabecario() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);

		return requestEntity;
	}

}