package com.grupo.basedatos;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.grupo.basedatos.itfz.ADatosBasicos;
import com.grupo.exception.DiaSemanaInvalido;

public class IDUnit extends ADatosBasicos {
	private static final long serialVersionUID = 1L;
	private String idUnit;
	private String idRuta;
	private String idRutaAdicional;

	public IDUnit() {
		this("000");
	}

	public IDUnit(String idVendedor) {
		this(idVendedor, "000");
	}

	public IDUnit(String idVendedor, String idRuta) {
		this(idVendedor, idRuta, "000");
	}

	public IDUnit(String idVendedor, String idRuta, String idRutaAdicional) {
		this.idUnit = idVendedor;
		this.idRuta = idRuta;
		this.idRutaAdicional = idRutaAdicional;
	}

	public IDUnit(DatosInicializacion init) {
		actualizar(init, new Date());
	}

	public IDUnit(DatosInicializacion init, Date date) {
		actualizar(init, date);
	}

	private void actualizar(DatosInicializacion init, Date date) {
		if (init != null) {
			this.idUnit = init.getVendedor();

			Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
			c.setTime(date);
			int r = c.get(7);
			r = (r == 0) ? 7 : r;
			try {
				this.idRuta = init.getRuta(r);
				this.idRutaAdicional = "000";
			} catch (DiaSemanaInvalido e) {
				this.idRuta = "000";
			}
		}
	}

	/**
	 * @return
	 * @uml.property name="idUnit"
	 */
	public String getIdUnit() {
		return this.idUnit;
	}

	/**
	 * @param idPalm
	 * @uml.property name="idUnit"
	 */
	public void setIdUnit(String idPalm) {
		this.idUnit = idPalm;
	}

	/**
	 * @return
	 * @uml.property name="idRuta"
	 */
	public String getIdRuta() {
		return this.idRuta;
	}

	/**
	 * @param idRuta
	 * @uml.property name="idRuta"
	 */
	public void setIdRuta(String idRuta) {
		this.idRuta = idRuta;
	}

	/**
	 * @return
	 * @uml.property name="idRutaAdicional"
	 */
	public String getIdRutaAdicional() {
		return this.idRutaAdicional;
	}

	/**
	 * @param idRutaAdicional
	 * @uml.property name="idRutaAdicional"
	 */
	public void setIdRutaAdicional(String idRutaAdicional) {
		this.idRutaAdicional = new String(idRutaAdicional);
	}


	public String toString() {
		return this.idUnit + " - " + this.idRuta + " - " + this.idRutaAdicional;
	}
}
