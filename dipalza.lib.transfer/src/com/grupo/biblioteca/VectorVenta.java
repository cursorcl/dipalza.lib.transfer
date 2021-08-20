package com.grupo.biblioteca;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.grupo.basedatos.Venta;

public class VectorVenta extends VectorDatosBasicos<Venta>{

	private static final long serialVersionUID = 1L;

	@Override
	public void decode(DataInputStream inputStream) {
	    try
	    {
	      int size = inputStream.readInt();
	      vector = new ArrayList<Venta>(size);
	      for (int n = 0; n < size; ++n) {
	        Venta v = new Venta();
	        v.decode(inputStream);
	        vector.add(v);
	      }
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
		
	}

}
