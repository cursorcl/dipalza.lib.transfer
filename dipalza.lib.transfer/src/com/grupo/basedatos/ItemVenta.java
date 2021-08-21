package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;

public class ItemVenta extends ADatosBasicos {
	private static final long serialVersionUID = 1L;
	private short codigoProducto;
	private String articulo;
	private float cantidad;
	private float neto;
	private float descuento;
	private float ila;
	private float oldCantidad = 0.0F;
	private float precio;

	public ItemVenta() {
		this.codigoProducto = 0;
		this.articulo = "";
		this.cantidad = 0.0F;
		this.neto = 0.0F;
		this.descuento = 0.0F;
		this.ila = 0.0F;
		this.precio = 0f;
	}

	public ItemVenta(short codigo, String articulo, float cantidad, float total, float descuento, float ila,
			float precio) {

		this.codigoProducto = codigo;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.neto = total;
		this.descuento = descuento;
		this.ila = ila;
		this.precio = precio;
	}

	/**
	 * @return
	 */
	public float getCantidad() {
		return this.cantidad;
	}

	/**
	 * @return
	 */
	public short getCodigoProducto() {
		return this.codigoProducto;
	}

	/**
	 * @return
	 */
	public float getNeto() {
		return this.neto;
	}

	/**
	 * @return
	 */
	public float getIla() {
		return this.ila;
	}

	/**
	 * @param ila
	 */
	public void setIla(float ila) {
		this.ila = ila;
	}

	/**
	 * @param cantidad
	 */
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @param codigoProducto
	 */
	public void setCodigoProducto(short codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * @param total
	 */
	public void setNeto(float total) {
		this.neto = total;
	}

	/**
	 * @return
	 */
	public String getArticulo() {
		return this.articulo;
	}

	/**
	 * @param articulo
	 */
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return
	 */
	public float getDescuento() {
		return this.descuento;
	}

	/**
	 * @param descuento
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return
	 */
	public float getOldCantidad() {
		return this.oldCantidad;
	}

	/**
	 * @param oldCantidad
	 */
	public void setOldCantidad(float oldCantidad) {
		this.oldCantidad = oldCantidad;
	}

	 public final float getPrecio() {
	 return precio;
	 }
	
	public final void setPrecio(float precio) {
		this.precio = precio;
	}

	public String toString() {
		return this.articulo + "  " + this.cantidad;
	}

	
}
