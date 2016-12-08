package br.com.unicsul.planovoo.entity;

import java.io.Serializable;

public class Planetas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2786476259589039126L;

	private String name;
	private int diameter;
	private String climate;
	private String terrain;
	private int population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
