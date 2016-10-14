package com.grupo.biblioteca;

import com.grupo.basedatos.Especiales;
import com.grupo.basedatos.itfz.ADatosBasicos;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by curso on 29-08-2016.
 */
public class ListEspeciales extends ADatosBasicos {

  private static final long serialVersionUID = 1L;
  
    List<Especiales> especialesList;

    public ListEspeciales(List<Especiales> especialesList) {
        this.especialesList =  especialesList;
    }

    @Override
    public void decode(DataInputStream inputStream) {
        try
        {
            int size = inputStream.readInt();
            especialesList = new ArrayList<Especiales>(size);
            for (int n = 0; n < size; ++n) {
                Especiales especial = new Especiales();
                especial.decode(inputStream);
                especialesList.add(especial);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public byte[] encode() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(baos);
        try {
            outputStream.writeInt(especialesList.size());
            for(Especiales especial: especialesList) {
                outputStream.write(especial.encode());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        byte[] buffer = baos.toByteArray();
        return buffer;
    }

    public boolean isEmpty()
    {
        return especialesList == null || especialesList.isEmpty();
    }

    public List<Especiales> getEspecialesList() {
        return especialesList;
    }

    public void setEspecialesList(List<Especiales> especialesList) {
        this.especialesList = especialesList;
    }
}
