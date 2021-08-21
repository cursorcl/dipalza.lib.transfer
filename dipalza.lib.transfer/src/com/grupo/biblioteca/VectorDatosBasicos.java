package com.grupo.biblioteca;

import java.util.ArrayList;
import java.util.List;

import com.grupo.basedatos.itfz.ADatosBasicos;

public abstract class VectorDatosBasicos<T extends ADatosBasicos> extends ADatosBasicos {

	private static final long serialVersionUID = 1L;
	List<T> vector;

	public VectorDatosBasicos() {
		vector = new ArrayList<T>();
	}
	
	public void add(T value) {
		vector.add(value);
	}
	
	public void remove(T value) {
		vector.remove(value);
	}
	
	public void remove(int index) {
		vector.remove(index);
	}
	
	public int size() {
		return vector.size();
	}
	
	public T elementAt(int index) {
		return vector.get(index);
	}
	
	public List<T> asVector() {
		return vector;
	}


	

}
