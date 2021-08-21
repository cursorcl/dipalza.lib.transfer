package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;

public class Producto extends ADatosBasicos {
  private static final long serialVersionUID = 1L;
  private String articulo;
  private short idProducto;
  private String nombre;
  private float stock;
  private float precio;
  private String unidad;
  private String proveedor;
  private float costo;
  private float ila;

  public Producto() {
    this.articulo = "";
    this.idProducto = 0;
    this.nombre = "Producto";
    this.stock = 0.0F;
    this.precio = 0.0F;
    this.unidad = "pack";
    this.proveedor = "Colun";
    this.costo = 0.0F;
    this.ila = 0.0F;
  }

  public Producto(String articulo, short id, String nombre, float stock, float precio,
      String unidad, String prov, float costo, float ila) {
    this.articulo = articulo;
    this.idProducto = id;
    this.nombre = nombre;
    this.stock = stock;
    this.precio = precio;
    this.unidad = unidad;
    this.proveedor = prov;
    this.costo = costo;
    this.ila = ila;
  }

  public short getIdProducto() {
    return this.idProducto;
  }

  public String getNombre() {
    return this.nombre;
  }
  public float getPrecio() {
    return this.precio;
  }

  public String getProveedor() {
    return this.proveedor;
  }

  public float getStock() {
    return this.stock;
  }

  public String getUnidad() {
    return this.unidad;
  }

  public void setIdProducto(short idProducto) {
    this.idProducto = idProducto;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  public void setProveedor(String proveedor) {
    this.proveedor = proveedor;
  }

  public void setStock(float stock) {
    this.stock = stock;
  }

  public void setUnidad(String unidad) {
    this.unidad = unidad;
  }


  public String toString() {
    String retValue = this.nombre.trim();
    return retValue;
  }

  public String getArticulo() {
    return this.articulo;
  }

  public void setArticulo(String articulo) {
    this.articulo = articulo;
  }

  public float getCosto() {
    return this.costo;
  }

  public void setCosto(float costo) {
    this.costo = costo;
  }

  public float getIla() {
    return this.ila;
  }

  public void setIla(float ila) {
    this.ila = ila;
  }
}
