package com.grupo.basedatos;

import com.grupo.basedatos.itfz.ADatosBasicos;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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

    @Override
    public void decode(DataInputStream inputStream) {
        try {
            articulo =  inputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] encode() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(baos);
        try {
            outputStream.writeUTF(this.articulo);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        byte[] buffer = baos.toByteArray();
        return buffer;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
}
