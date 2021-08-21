package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;

public class Cliente extends ADatosBasicos {
	private static final long serialVersionUID = 1L;
	private String rut;
	private String razonSocial;
	private String comuna;
	private String direccion;
	private String ciudad;
	private String telefono;
	private boolean borrado;
	private int estado = 0;
	private String vendedor = "000";
	private String ruta = "000";
	private String codigo;

	public Cliente() {
		this.codigo = "   ";
	}

	public String getRut() {
		return this.rut;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String toString() {
		return this.codigo + ":" + getRazonSocial().toUpperCase();
	}

		/**
	 * @return
	 * @uml.property name="borrado"
	 */
	public boolean isBorrado() {
		return this.borrado;
	}

	/**
	 * @param borrado
	 * @uml.property name="borrado"
	 */
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	/**
	 * @return
	 * @uml.property name="comuna"
	 */
	public String getComuna() {
		return this.comuna;
	}

	/**
	 * @param comuna
	 * @uml.property name="comuna"
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	/**
	 * @param estado
	 * @uml.property name="estado"
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return
	 * @uml.property name="estado"
	 */
	public int getEstado() {
		return this.estado;
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
	 * @uml.property name="ruta"
	 */
	public String getRuta() {
		return this.ruta;
	}

	/**
	 * @param ruta
	 * @uml.property name="ruta"
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return
	 * @uml.property name="codigo"
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo
	 * @uml.property name="codigo"
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
