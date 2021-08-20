package com.grupo.biblioteca;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.grupo.basedatos.Producto;

public class VectorProductos extends VectorDatosBasicos<Producto>{

	private static final long serialVersionUID = 1L;

	@Override
	public void decode(DataInputStream inputStream) {
	    try
	    {
	      int size = inputStream.readInt();
	      vector = new ArrayList<Producto>(size);
	      for (int n = 0; n < size; ++n) {
	        Producto p = new Producto();
	        p.decode(inputStream);
	        vector.add(p);
	      }
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
		
	}

}
