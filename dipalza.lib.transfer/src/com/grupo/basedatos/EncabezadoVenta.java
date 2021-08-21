package com.grupo.basedatos;

import java.util.Date;

import com.grupo.basedatos.itfz.ADatosBasicos;
import com.grupo.utilitarios.FechaFormateada;

public class EncabezadoVenta extends ADatosBasicos {
	private static final long serialVersionUID = 1L;
	private String nombreCliente = null;
	private FechaFormateada fecha;
	private byte condicionVenta;
	private String rut;
	private float neto;
	private float porcentajeIva;
	private String vendedor;
	private boolean droped = false;
	private String codigoCliente = "";

	public EncabezadoVenta(String nombreCliente, String rut, Date fecha, byte condicionVenta, float neto, float iva,
			String vendedor, String codigoCliente) {
		this.nombreCliente = nombreCliente;
		this.rut = rut;
		this.fecha = new FechaFormateada(fecha.getTime());
		this.condicionVenta = condicionVenta;
		this.neto = neto;
		this.porcentajeIva = iva;
		this.vendedor = vendedor;
		this.codigoCliente = codigoCliente;
	}

	public EncabezadoVenta() {
		this("", "", new Date(), (byte) 0, 0.0F, 0.0F, "000", "");
	}

	

	/**
	 * @return
	 * @uml.property name="condicionVenta"
	 */
	public byte getCondicionVenta() {
		return this.condicionVenta;
	}

	/**
	 * @return
	 * @uml.property name="fecha"
	 */
	public FechaFormateada getFecha() {
		return this.fecha;
	}

	/**
	 * @param condicionVenta
	 * @uml.property name="condicionVenta"
	 */
	public void setCondicionVenta(byte condicionVenta) {
		this.condicionVenta = condicionVenta;
	}

	/**
	 * @param fecha
	 * @uml.property name="fecha"
	 */
	public void setFecha(FechaFormateada fecha) {
		this.fecha = fecha;
	}

	public void setFecha(Date fecha) {
		if (this.fecha != null)
			this.fecha.setTime(fecha.getTime());
		else
			this.fecha = new FechaFormateada(fecha.getTime());
	}

	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj instanceof EncabezadoVenta) {
			equal = ((EncabezadoVenta) obj).getCodigoCliente().equals(this.codigoCliente);
		}
		return equal;
	}

	public String toString() {
		String out = "NO VALIDO";
		String str = "[ ]";
		if (this.droped) {
			str = "[X]";
		}
		if (this.rut != null) {
			String r = this.nombreCliente;
			out = str + r + " : " + String.valueOf((int) (this.neto * (1.0F + this.porcentajeIva / 100.0F)));
		} else {
			out = str + this.codigoCliente + " : " + this.fecha.toString();
		}

		return out;
	}

	/**
	 * @return
	 * @uml.property name="nombreCliente"
	 */
	public String getNombreCliente() {
		return this.nombreCliente;
	}

	/**
	 * @param nombreCliente
	 * @uml.property name="nombreCliente"
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return
	 * @uml.property name="rut"
	 */
	public String getRut() {
		return this.rut;
	}

	/**
	 * @param rut
	 * @uml.property name="rut"
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * @return
	 * @uml.property name="neto"
	 */
	public float getNeto() {
		return this.neto;
	}

	/**
	 * @param neto
	 * @uml.property name="neto"
	 */
	public void setNeto(float neto) {
		this.neto = neto;
	}

	/**
	 * @return
	 * @uml.property name="porcentajeIva"
	 */
	public float getPorcentajeIva() {
		return this.porcentajeIva;
	}

	/**
	 * @param porcentajeIva
	 * @uml.property name="porcentajeIva"
	 */
	public void setPorcentajeIva(float porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	/**
	 * @return
	 * @uml.property name="vendedor"
	 */
	public String getVendedor() {
		return this.vendedor;
	}

	/**
	 * @param vendedor
	 * @uml.property name="vendedor"
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * @return
	 * @uml.property name="droped"
	 */
	public boolean isDroped() {
		return this.droped;
	}

	/**
	 * @param droped
	 * @uml.property name="droped"
	 */
	public void setDroped(boolean droped) {
		this.droped = droped;
	}

	/**
	 * @return
	 * @uml.property name="codigoCliente"
	 */
	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	/**
	 * @param codigoCliente
	 * @uml.property name="codigoCliente"
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
