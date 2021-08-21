package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;

public class NroItemesVenta extends ADatosBasicos {

	private static final long serialVersionUID = 1L;
	private int nroItemesVenta;

	public NroItemesVenta() {
	}

	public NroItemesVenta(int nroItemesVenta) {
		this.nroItemesVenta = nroItemesVenta;
	}

	public int getNroItemesVenta() {
		return this.nroItemesVenta;
	}

	public void setNroItemesVenta(int nroItemesVenta) {
		this.nroItemesVenta = nroItemesVenta;
	}

}