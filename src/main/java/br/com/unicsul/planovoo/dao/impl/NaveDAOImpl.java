package br.com.unicsul.planovoo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.unicsul.planovoo.dao.NaveDAO;
import br.com.unicsul.planovoo.dao.TripulantesDAO;
import br.com.unicsul.planovoo.entity.Nave;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.ResultsNave;
import br.com.unicsul.planovoo.entity.ResultsPlanetas;
import br.com.unicsul.planovoo.entity.ResultsTripulantes;
import br.com.unicsul.planovoo.entity.Tripulantes;

public class NaveDAOImpl implements NaveDAO{
	private static final String url = "https://swapi.co/api/starships/?format=json";
	ConnectDAO data = new ConnectDAO();
	@Override
	public List<Nave> listarNaves() {
			ResultsNave result = (ResultsNave) data.resultNave(url).getBody();
			List<Nave>lista = result.getResults();
			if (lista != null && lista.size() > 0) {
				return lista;
			} else {
				List<Nave> listas = new ArrayList<Nave>();
				return listas;
			}
	}

	@Override
	public Nave listarNaves(String nome) {
		ResultsNave result = (ResultsNave) data.resultNave(url).getBody();
		List<Nave>lista = result.getResults();
		if (lista != null && lista.size() > 0) {
			for(Nave nave : lista){
				if(nave.getName().equals(nome)){
					return nave;
				}
			}
		}

		return new Nave();
	}

}
