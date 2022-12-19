package com.mycompany.collectorvault.service;

import java.util.List;

import com.mycompany.collectorvault.DTO.ColeccionDTO;
import com.mycompany.collectorvault.entity.Coleccion;

public interface ColeccionService {

	public List<ColeccionDTO> getColecciones(int numeroDePagina,int medidaDePagina);

	public ColeccionDTO saveColeccion(ColeccionDTO theColeccionDTO);
	
	public ColeccionDTO updateColeccion(ColeccionDTO theColeccionDTO);

	public Coleccion getColeccion(int theId);

	public void deleteColeccion(int theId);
	
	
}
