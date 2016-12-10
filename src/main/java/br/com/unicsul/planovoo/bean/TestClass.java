package br.com.unicsul.planovoo.bean;

import br.com.unicsul.planovoo.dao.impl.CrudDAOImpl;

public class TestClass {

	public static void main(String[] args) {
		CrudDAOImpl dao = new  CrudDAOImpl();
			dao.listarDadosPlanetas();
			dao.selecionarPlaneta("Alderaan");
			dao.selecionarPlaneta("Alderaan");
	}

}
