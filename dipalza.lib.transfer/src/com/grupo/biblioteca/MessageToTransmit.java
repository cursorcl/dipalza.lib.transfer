package com.grupo.biblioteca;

import com.grupo.basedatos.IDUnit;
import com.grupo.basedatos.itfz.ADatosBasicos;

public class MessageToTransmit extends ADatosBasicos {

  private static final long serialVersionUID = 1L;
  private EMessagesTypes type;
  private IDUnit idPalm;
  private DatosBasicos data;

  public EMessagesTypes getType() {
    return type;
  }

  public void setType(EMessagesTypes type) {
    this.type = type;
  }

  public IDUnit getIdPalm() {
    return idPalm;
  }

  public void setIdPalm(IDUnit idPalm) {
    this.idPalm = idPalm;
  }

  public DatosBasicos getData() {
    return data;
  }

  public void setData(DatosBasicos data) {
    this.data = data;
  }

  
 

}
