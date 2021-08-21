package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;

/**
 * Created by curso on 29-08-2016.
 */
public class Especiales extends ADatosBasicos {

	private static final long serialVersionUID = 1L;
    String articulo;

    public Especiales()
    {

    }
    public Especiales(int id, String articulo) {
        this.articulo = articulo;
    }


    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
}
