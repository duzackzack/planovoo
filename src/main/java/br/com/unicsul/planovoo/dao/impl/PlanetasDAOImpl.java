package br.com.unicsul.planovoo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.unicsul.planovoo.dao.ConnectDAO;
import br.com.unicsul.planovoo.dao.PlanetaDAO;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.ResultsPlanetas;

public class PlanetasDAOImpl implements PlanetaDAO {
	
	private ConnectDAO data = new ConnectDAO();
	private List<Planetas>planetaVisitado=new ArrayList<Planetas>();
	
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
