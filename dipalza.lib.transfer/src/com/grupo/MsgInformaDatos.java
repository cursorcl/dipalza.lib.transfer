package com.grupo;

import com.grupo.basedatos.itfz.ADatosBasicos;

public class MsgInformaDatos extends ADatosBasicos {

	private static final long serialVersionUID = 1L;
	private String name;
	private int cantidad;


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
