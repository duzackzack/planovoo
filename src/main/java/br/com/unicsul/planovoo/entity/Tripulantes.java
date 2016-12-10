package br.com.unicsul.planovoo.entity;

import java.io.Serializable;

public class Tripulantes implements Serializable {

	private static final long serialVersionUID = -2785546929069900977L;

	private String name;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
