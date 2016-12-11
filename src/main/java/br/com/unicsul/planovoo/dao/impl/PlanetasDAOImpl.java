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

import br.com.unicsul.planovoo.dao.ConnectDAO;
import br.com.unicsul.planovoo.dao.PlanetaDAO;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.ResultsPlanetas;
import br.com.unicsul.planovoo.entity.Voo;
import br.com.unicsul.planovoo.json.GsonHttpMessageConverter;

public class PlanetasDAOImpl implements PlanetaDAO {
	
	private ConnectDAO data = new ConnectDAO();
	private List<Planetas>planetaVisitado=new ArrayList<Planetas>();
	

	
	@Override
	public Planetas selecionarPlaneta(String name) {
		ResultsPlanetas result = (ResultsPlanetas) data.resultPlanetas().getBody();
		List<Planetas>lista = result.getResults();
		if (lista != null && lista.size() > 0) {
			for(Planetas planeta : lista){
				if(planeta.getName().equals(name)){
					return planeta;
				}
			}
		}
		return new Planetas();
	}

	@Override
	public boolean viagemAnterior(Planetas planeta) {
		if(this.planetaVisitado == null){
			this.planetaVisitado = new ArrayList<Planetas>();
			this.planetaVisitado.add(planeta);
			return true;
		}else{
			if(this.planetaVisitado.contains(planeta)){
				return false;
			}else{
				this.planetaVisitado.add(planeta);
				return true;
			}
		}
	}


	@Override
	public List<Planetas> listarDadosPlanetas() {
		ResultsPlanetas result = (ResultsPlanetas) data.resultPlanetas().getBody();
		List<Planetas>lista = result.getResults();
		if (lista != null && lista.size() > 0) {
			return lista;
		} else {
			List<Planetas> listas = new ArrayList<Planetas>();
			return listas;
		}
	}

	
}
