package br.com.unicsul.planovoo.entity;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Planetas implements Serializable {

	private static final long serialVersionUID = -2786476259589039126L;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rotation_period")
	private String rotation_period;

	@JsonProperty("orbital_period")
	private String orbital_period;

	@JsonProperty("diameter")
	private String diameter;

	@JsonProperty("climate")
	private String climate;

	@JsonProperty("terrain")
	private String terrain;

	@JsonProperty("population")
	private String population;

	@JsonProperty("gravity")
	private String gravity;

	@JsonProperty("surface_water")
	private String surface_water;

	@JsonProperty("residents")
	private String[] residents;
	

	@JsonProperty("films")
	private String[] films;
	@JsonProperty("created")
	private String created;

	@JsonProperty("edited")
	private String edited;
	@JsonProperty("url")
	private String url;


	public String[] getFilms() {
		return films;
	}

	public void setFilms(String[] films) {
		this.films = films;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	public String getRotation_period() {
		return rotation_period;
	}

	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}

	public String getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}


	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getSurface_water() {
		return surface_water;
	}

	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}


	public String[] getResidents() {
		return residents;
	}

	public void setResidents(String[] residents) {
		this.residents = residents;
	}




}
