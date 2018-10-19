package br.com.unicsul.planovoo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.unicsul.planovoo.dao.ConnectNavesDAO;
import br.com.unicsul.planovoo.dao.NaveDAO;
import br.com.unicsul.planovoo.entity.Nave;
import br.com.unicsul.planovoo.entity.ResultsNave;

public class NaveDAOImpl implements NaveDAO{
	ConnectNavesDAO data = new ConnectNavesDAO();
	@Override
	public List<Nave> listarNaves() {
			ResultsNave result = (ResultsNave) data.resultNave().getBody();
			List<Nave>lista = result.getResults();
			if (lista != null && lista.size() > 0) {
				return lista;
			} else {
				List<Nave> listas = new ArrayList<Nave>();
				return listas;
			}
	}


}
