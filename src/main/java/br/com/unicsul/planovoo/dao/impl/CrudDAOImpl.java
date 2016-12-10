package br.com.unicsul.planovoo.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.unicsul.planovoo.dao.CrudDAO;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.Results;
import br.com.unicsul.planovoo.entity.Voo;
import br.com.unicsul.planovoo.json.GsonHttpMessageConverter;

public class CrudDAOImpl implements CrudDAO {
	private static final String url = "http://swapi.co/api/planets/?format=json";
	private List<Planetas>planetaVitidado;
	
	@Override
	public List<Planetas> listarDadosPlanetas() {
		Results result = result().getBody();
		List<Planetas>lista = result.getResults();
		if (lista != null && lista.size() > 0) {
			return lista;
		} else {
			List<Planetas> listas = new ArrayList<Planetas>();
			return listas;
		}
	}

	public ResponseEntity<Results> result() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		ResponseEntity<Results> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getCabecario(),
				Results.class);
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

	@Override
	public Planetas selecionarPlaneta(String name) {
		Results result = result().getBody();
		List<Planetas>lista = result.getResults();
		if (lista != null && lista.size() > 0) {
			for(Planetas planeta : lista){
				if(planeta.getName().equals(name)){
					return planeta;
				}
			}
		}
		return null;
	}

	@Override
	public boolean viagemAnterior(Planetas planeta) {
		if(this.planetaVitidado == null){
			planetaVitidado = new ArrayList<Planetas>();
			planetaVitidado.add(planeta);
			return true;
		}else{
			if(planetaVitidado.contains(planeta)){
				return false;
			}else{
				return true;
			}
		}
	}

	
}
