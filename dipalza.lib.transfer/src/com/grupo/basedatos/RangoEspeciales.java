package com.grupo.basedatos;

/**
 * Clase que representa un registro de la tabla Especiales en la BD. 
 * @author curso
 *
 */
public class RangoEspeciales {
  int id = -1;
  String articuloInicial ="";
  String articuloFinal = "";
  
  public RangoEspeciales() {
  }

  public RangoEspeciales( String articuloInicial, String articuloFinal) {
    super();
    this.articuloInicial = articuloInicial;
    this.articuloFinal = articuloFinal;
  }
  
  
  public RangoEspeciales(int id, String articuloInicial, String articuloFinal) {
    super();
    this.id = id;
    this.articuloInicial = articuloInicial;
    this.articuloFinal = articuloFinal;
  }


  public final int getId() {
    return id;
  }
  public final void setId(int id) {
    this.id = id;
  }
  public final String getArticuloInicial() {
    return articuloInicial;
  }
  public final void setArticuloInicial(String articuloInicial) {
    this.articuloInicial = articuloInicial;
  }
  public final String getArticuloFinal() {
    return articuloFinal;
  }
  public final void setArticuloFinal(String articuloFinal) {
    this.articuloFinal = articuloFinal;
  }


  @Override
  public String toString() {
    return "[" +  articuloInicial + "-" +  articuloFinal + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((articuloFinal == null) ? 0 : articuloFinal.hashCode());
    result = prime * result + ((articuloInicial == null) ? 0 : articuloInicial.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RangoEspeciales other = (RangoEspeciales) obj;
    if (articuloFinal == null) {
      if (other.articuloFinal != null)
        return false;
    } else if (!articuloFinal.equals(other.articuloFinal))
      return false;
    if (articuloInicial == null) {
      if (other.articuloInicial != null)
        return false;
    } else if (!articuloInicial.equals(other.articuloInicial))
      return false;
    return true;
  }
  
  
  
  
}
