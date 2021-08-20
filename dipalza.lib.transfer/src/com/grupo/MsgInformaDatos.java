package com.grupo;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.grupo.basedatos.itfz.ADatosBasicos;

public class MsgInformaDatos extends ADatosBasicos {

	private static final long serialVersionUID = 1L;
	private String name;
	private int cantidad;

	public void decode(DataInputStream inputStream) {
		try {
			setName(inputStream.readUTF());
			setCantidad(inputStream.readInt());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public byte[] encode() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(baos);
		try {
			outputStream.writeUTF(getName());
			outputStream.writeInt(cantidad);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		byte[] buffer = baos.toByteArray();
		return buffer;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
