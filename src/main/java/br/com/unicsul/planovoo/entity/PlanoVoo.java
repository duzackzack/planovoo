package br.com.unicsul.planovoo.entity;

import java.util.List;

public class PlanoVoo {

	private List<Tripulantes> tripulantes;
	private Planetas planetas;
	private Nave nave;

	public List<Tripulantes> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulantes> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public Planetas getPlanetas() {
		return planetas;
	}

	public void setPlanetas(Planetas planetas) {
		this.planetas = planetas;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

}
