package com.grupo.biblioteca;

import java.util.ArrayList;
import java.util.List;

import com.grupo.basedatos.IdentificacionPalm;

public class Message {
	private byte tipoMessage;
	private List<byte[]> messages = null;
	private IdentificacionPalm idPalm;

	public Message() {
		messages = new ArrayList<byte[]>();
	}

	public byte getTipoMessage() {
		return tipoMessage;
	}

	public void setTipoMessage(byte tipoMessage) {
		this.tipoMessage = tipoMessage;
	}

	public List<byte[]> getMessages() {
		return messages;
	}

	public void addData(byte[] data) {

		messages.add(data);

	}

	public void clear() {
		messages.clear();
	}

	public IdentificacionPalm getIdPalm() {
		return idPalm;
	}

	public void setIdPalm(IdentificacionPalm idPalm) {
		this.idPalm = idPalm;
	}

}
