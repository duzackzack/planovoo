package br.com.unicsul.planovoo.dao;

import java.util.List;

import br.com.unicsul.planovoo.entity.Planetas;

public interface CrudDAO {
	public List<Planetas> listarDadosPlanetas();
	public Planetas selecionarPlaneta(String name);
	public boolean viagemAnterior(Planetas planeta);
}
