package com.grupo.biblioteca;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.grupo.basedatos.Cliente;

public class VectorClientes extends VectorDatosBasicos<Cliente> {

	private static final long serialVersionUID = 1L;

	@Override
	public void decode(DataInputStream inputStream) {
		try {
			int size = inputStream.readInt();
			vector = new ArrayList<Cliente>(size);
			for (int n = 0; n < size; ++n) {
				Cliente c = new Cliente();
				c.decode(inputStream);
				vector.add(c);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
