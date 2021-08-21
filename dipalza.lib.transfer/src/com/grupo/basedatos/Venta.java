package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;
import com.grupo.utilitarios.FechaFormateada;

public class Venta extends ADatosBasicos {

	private static final long serialVersionUID = 1L;
	private EncabezadoVenta encabezado;
	private ItemesVenta ventas;
	private FechaFormateada fecha;

	public Venta() {
		encabezado = new EncabezadoVenta();
		ventas = new ItemesVenta();
	}

	public Venta(EncabezadoVenta encabezado, ItemesVenta ventas, FechaFormateada fecha) {
		super();
		this.encabezado = encabezado;
		this.ventas = ventas;
		this.fecha = fecha;
	}

	/**
	 * @return
	 * @uml.property name="encabezado"
	 */
	public EncabezadoVenta getEncabezado() {
		return encabezado;
	}

	/**
	 * @param encabezado
	 * @uml.property name="encabezado"
	 */
	public void setEncabezado(EncabezadoVenta encabezado) {
		this.encabezado = encabezado;
	}

	/**
	 * @return
	 * @uml.property name="ventas"
	 */
	public ItemesVenta getVentas() {
		return ventas;
	}

	/**
	 * @param ventas
	 * @uml.property name="ventas"
	 */
	public void setVentas(ItemesVenta ventas) {
		this.ventas = ventas;
	}

	/**
	 * @param fecha
	 * @uml.property name="fecha"
	 */
	public void setFecha(FechaFormateada fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return
	 * @uml.property name="fecha"
	 */
	public FechaFormateada getFecha() {
		return fecha;
	}

}
