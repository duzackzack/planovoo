package br.com.unicsul.planovoo.entity;

import java.util.List;

public class Voo {

	private Voo vooAtual;
	private VooAnterior vooAnterior;
	private List<Tripulantes> tripulantes;
	private List<Planetas> planetas;

	public Voo getVooAtual() {
		return vooAtual;
	}

	public void setVooAtual(Voo vooAtual) {
		this.vooAtual = vooAtual;
	}

	public VooAnterior getVooAnterior() {
		return vooAnterior;
	}

	public void setVooAnterior(VooAnterior vooAnterior) {
		this.vooAnterior = vooAnterior;
	}

	public List<Tripulantes> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulantes> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public List<Planetas> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planetas> planetas) {
		this.planetas = planetas;
	}

}
