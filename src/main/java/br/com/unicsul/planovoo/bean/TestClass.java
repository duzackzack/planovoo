package br.com.unicsul.planovoo.bean;

import br.com.unicsul.planovoo.dao.impl.PlanetasDAOImpl;

public class TestClass {

	public static void main(String[] args) {
		PlanetasDAOImpl dao = new  PlanetasDAOImpl();
			dao.listarDadosPlanetas();
			dao.selecionarPlaneta("Alderaan");
			dao.selecionarPlaneta("Alderaan");
	}

}
