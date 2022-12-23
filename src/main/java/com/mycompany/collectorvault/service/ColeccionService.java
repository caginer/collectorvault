package com.mycompany.collectorvault.service;



import com.mycompany.collectorvault.DTO.ColeccionDTO;
import com.mycompany.collectorvault.DTO.ColeccionRespuesta;
import com.mycompany.collectorvault.entity.Coleccion;

public interface ColeccionService {

	public ColeccionRespuesta getColecciones(int numeroDePagina,int medidaDePagina, String ordenarPor);

	public ColeccionDTO saveColeccion(ColeccionDTO theColeccionDTO);
	
	public ColeccionDTO updateColeccion(ColeccionDTO theColeccionDTO);

	public Coleccion getColeccion(int theId);

	public void deleteColeccion(int theId);
	
	
}
