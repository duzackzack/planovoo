package br.com.unicsul.planovoo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.unicsul.planovoo.dao.ConnectTripulantesDAO;
import br.com.unicsul.planovoo.dao.TripulantesDAO;
import br.com.unicsul.planovoo.entity.ResultsTripulantes;
import br.com.unicsul.planovoo.entity.Tripulantes;

public class TripulantesDAOImpl implements TripulantesDAO{
	ConnectTripulantesDAO data = new ConnectTripulantesDAO();
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

	

}
