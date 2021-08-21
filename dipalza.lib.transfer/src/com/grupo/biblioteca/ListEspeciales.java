package com.grupo.biblioteca;

import java.util.List;

import com.grupo.basedatos.Especiales;
import com.grupo.basedatos.itfz.ADatosBasicos;

/**
 * Created by curso on 29-08-2016.
 */
public class ListEspeciales extends ADatosBasicos {

  private static final long serialVersionUID = 1L;
  
    List<Especiales> especialesList;

    public ListEspeciales(List<Especiales> especialesList) {
        this.especialesList =  especialesList;
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
