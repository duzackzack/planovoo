package br.com.unicsul.planovoo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.unicsul.planovoo.dao.ConnectDAO;
import br.com.unicsul.planovoo.dao.TripulantesDAO;
import br.com.unicsul.planovoo.entity.Nave;
import br.com.unicsul.planovoo.entity.ResultsNave;
import br.com.unicsul.planovoo.entity.ResultsTripulantes;
import br.com.unicsul.planovoo.entity.Tripulantes;

public class TripulantesDAOImpl implements TripulantesDAO{
	ConnectDAO data = new ConnectDAO();
	@Override
	public List<Tripulantes> listarTripulantes() {
			ResultsTripulantes result = (ResultsTripulantes) data.resultTripulantes().getBody();
			List<Tripulantes>lista = result.getResults();
			if (lista != null && lista.size() > 0) {
				return lista;
			} else {
				List<Tripulantes> listas = new ArrayList<Tripulantes>();
				return listas;
			}
	}

	@Override
	public Tripulantes listarTripulantes(String nome) {
		ResultsTripulantes result = (ResultsTripulantes) data.resultTripulantes().getBody();
		List<Tripulantes>lista = result.getResults();
		if (lista != null && lista.size() > 0) {
			for(Tripulantes tripulante : lista){
				if(tripulante.getName().equals(nome)){
					return tripulante;
				}
			}
		}
		return new Tripulantes();
	}

}
