package com.grupo.basedatos;

import java.util.Calendar;
import java.util.TimeZone;

import com.grupo.basedatos.itfz.ADatosBasicos;
import com.grupo.exception.DiaSemanaInvalido;

@SuppressWarnings("serial")
public class DatosInicializacion extends ADatosBasicos
{
private String vendedor;
private String[] rutas = new String[7];

private float iva = 19.0F;
private float ila = 14.0F;
private String ip = "192.168.0.2";

  public DatosInicializacion()
  {
    this.vendedor = "000";
    this.rutas[0] = "000";
    this.rutas[1] = "000";
    this.rutas[2] = "000";
    this.rutas[3] = "000";
    this.rutas[4] = "000";
    this.rutas[5] = "000";
    this.rutas[6] = "000";
    this.iva = 19.0F;
    this.ila = 14.0F;
    this.ip = "192.168.0.2";
  }


  public String toString()
  {
    return this.vendedor + ":" + this.rutas[0] + " " + this.rutas[1] + " " + this.rutas[2] + 
      " " + this.rutas[3] + " " + this.rutas[4] + " " + this.rutas[5] + " " + this.rutas[6];
  }

 
 
public String getVendedor() {
    return this.vendedor;
  }

 
public void setVendedor(String vendedor) {
    this.vendedor = vendedor;
  }

  public void setRuta(int diaSemana, String ruta)
    throws DiaSemanaInvalido
  {
    if ((diaSemana > 0) && (diaSemana < 6))
      this.rutas[(diaSemana - 1)] = ruta;
    else
      throw new DiaSemanaInvalido();
  }

  public String getRuta(int diaSemana)
    throws DiaSemanaInvalido
  {
    String ruta = "000";
    if ((diaSemana > 0) && (diaSemana <= 7))
      ruta = this.rutas[(diaSemana - 1)];
    else {
      throw new DiaSemanaInvalido();
    }
    return ruta;
  }

  public String getRuta()
  {
    Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
    int r = c.get(7);
    String ruta = "";
    try {
      ruta = setThreeZeroes(getRuta(r));
    } catch (DiaSemanaInvalido localDiaSemanaInvalido) {
    }
    return ruta;
  }

  /**
 * @return
 * @uml.property  name="rutas"
 */
public String[] getRutas() {
    return this.rutas;
  }

  /**
 * @param rutas
 * @uml.property  name="rutas"
 */
public void setRutas(String[] rutas) {
    this.rutas = rutas;
  }

  public void setRutaLunes(String ruta)
  {
    this.rutas[0] = setThreeZeroes(ruta);
  }
  public void setRutaMartes(String ruta) {
    this.rutas[1] = setThreeZeroes(ruta);
  }
  public void setRutaMiercoles(String ruta) {
    this.rutas[2] = setThreeZeroes(ruta);
  }
  public void setRutaJueves(String ruta) {
    this.rutas[3] = setThreeZeroes(ruta);
  }
  public void setRutaViernes(String ruta) {
    this.rutas[4] = setThreeZeroes(ruta);
  }
  public void setRutaSabado(String ruta) {
    this.rutas[5] = setThreeZeroes(ruta);
  }
  public void setRutaDomingo(String ruta) {
    this.rutas[6] = setThreeZeroes(ruta);
  }

  private String setThreeZeroes(String txt)
  {
    String resultado = "000";
    if (txt != null) {
      int len = txt.length();
      resultado = txt;
      if (len < 3) {
        resultado = "000".substring(3 - len) + txt;
      }
      else if (len > 3) {
        resultado = txt.substring(3);
      }
    }
    return resultado;
  }

  /**
 * @return
 * @uml.property  name="iva"
 */
public float getIva() {
    return this.iva;
  }

  /**
 * @param iva
 * @uml.property  name="iva"
 */
public void setIva(float iva) {
    this.iva = iva;
  }

  /**
 * @return
 * @uml.property  name="ip"
 */
public String getIp() {
    return this.ip;
  }

  /**
 * @param ip
 * @uml.property  name="ip"
 */
public void setIp(String ip) {
    this.ip = new String(ip);
  }

  /**
 * @return
 * @uml.property  name="ila"
 */
public float getIla() {
    return this.ila;
  }

  /**
 * @param ila
 * @uml.property  name="ila"
 */
public void setIla(float ila) {
    this.ila = ila;
  }
}
