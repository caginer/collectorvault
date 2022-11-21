package com.mycompany.collectorvault.service;

import java.util.List;

import com.mycompany.collectorvault.entity.Coleccion;

public interface ColeccionService {

	public List<Coleccion> getColecciones();

	public void saveColeccion(Coleccion theColeccion);
	
	public Coleccion updateColeccion(Coleccion theColeccion);

	public Coleccion getColeccion(int theId);

	public void deleteColeccion(int theId);
	
}
