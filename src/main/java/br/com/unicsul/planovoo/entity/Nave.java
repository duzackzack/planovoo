package br.com.unicsul.planovoo.entity;

import java.io.Serializable;

public class Nave implements Serializable {

	private static final long serialVersionUID = -7770515324021376636L;

	private String name;
	private String modelo;
	private int passageiros;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

}
