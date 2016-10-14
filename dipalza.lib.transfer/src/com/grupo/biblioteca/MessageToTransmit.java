package com.grupo.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.grupo.MsgInformaDatos;
import com.grupo.basedatos.Cliente;
import com.grupo.basedatos.DatosInicializacion;
import com.grupo.basedatos.EncabezadoVenta;
import com.grupo.basedatos.Especiales;
import com.grupo.basedatos.IDUnit;
import com.grupo.basedatos.ItemVenta;
import com.grupo.basedatos.NroItemesVenta;
import com.grupo.basedatos.Producto;
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

  public void decode(byte[] buffer) {
    ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
    DataInputStream inputStream = new DataInputStream(bais);
    try {
      type = EMessagesTypes.values()[inputStream.readInt()];
      idPalm = new IDUnit();
      idPalm.decode(inputStream);
      switch (type) {
        case MSG_CLIENTE:
          data = new Cliente();
          break;
        case MSG_DATOSINICIALIZACION:
          data = new DatosInicializacion();
          break;
        case MSG_ENCABEZADO:
          data = new EncabezadoVenta();
          break;
        case MSG_ITEMVENTA:
          data = (DatosBasicos) new ItemVenta();
          break;
        case MSG_NROITEMESVENTA:
          data = new NroItemesVenta();
          break;
        case MSG_INITIALIZE_PRODUCTO:
          data = new Producto();
          break;
        case MSG_INITIALIZE_CLIENTE:
          data = new Cliente();
        case MSG_INITIALIZE_CLIENTE_FINALIZED:
          data = null;
          break;
        case MSG_INITIALIZE_PRODUCTO_FINALIZED:
          data = null;
          break;
        case MSG_INFORMATIVE:
          data = new MsgInformaDatos();
          break;
        case MSG_VECTORCLIENTES:
          data = new VectorClientes();
          break;
        case MSG_VECTORPRODUCTOS:
          data = new VectorProductos();
          break;
        case MSG_ESPECIALES:
          data = new Especiales();
          break;
        case MSG_VECTORVENTAS:
          break;
        default:
          break;
      }
      if (data != null) {
        data.decode(inputStream);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public byte[] encode() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream outputStream = new DataOutputStream(baos);
    try {
      outputStream.writeInt(getType().ordinal());
      outputStream.write(getIdPalm().encode());
      if (getData() != null) {
        outputStream.write(getData().encode());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    byte[] buffer = baos.toByteArray();
    return buffer;
  }

  @Override
  public void decode(DataInputStream inputStream) {
    try {
      type = EMessagesTypes.values()[inputStream.readInt()];
      idPalm = new IDUnit();
      idPalm.decode(inputStream);
      switch (type) {
        case MSG_CLIENTE:
          data = new Cliente();
          break;
        case MSG_DATOSINICIALIZACION:
          data = new DatosInicializacion();
          break;
        case MSG_ENCABEZADO:
          data = new EncabezadoVenta();
          break;
        case MSG_ITEMVENTA:
          data = (DatosBasicos) new ItemVenta();
          break;
        case MSG_NROITEMESVENTA:
          data = new NroItemesVenta();
          break;
        case MSG_INITIALIZE_PRODUCTO:
          data = new Producto();
          break;
        case MSG_INITIALIZE_CLIENTE:
          data = new Cliente();
        case MSG_INITIALIZE_CLIENTE_FINALIZED:
          data = null;
          break;
        case MSG_INITIALIZE_PRODUCTO_FINALIZED:
          data = null;
          break;
        case MSG_INFORMATIVE:
          data = new MsgInformaDatos();
          break;
        case MSG_VECTORCLIENTES:
          data = new VectorClientes();
          break;
        case MSG_VECTORPRODUCTOS:
          data = new VectorProductos();
          break;
        case MSG_ESPECIALES:
          data = new Especiales();
          break;
      }
      if (data != null) {
        data.decode(inputStream);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
