package com.mycompany.collectorvault.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycompany.collectorvault.DAO.ColeccionDAO;
import com.mycompany.collectorvault.entity.Coleccion;
import com.mycompany.collectorvault.entity.Item;

@Service
public class ColeccionServiceImpl implements ColeccionService {

	// need to inject Coleccion dao
	@Autowired
	private ColeccionDAO coleccionDAO;
	
	@Override
	@Transactional
	public List<Coleccion> getColecciones() {
		
		return coleccionDAO.findAll();
		
	}

	@Override
	@Transactional
	public void saveColeccion(Coleccion theColeccion) {

		coleccionDAO.save(theColeccion);
	}

	@Override
	@Transactional
	public Coleccion getColeccion(int coleccionId) {
		
		return coleccionDAO.findById(coleccionId).get();
		

	}
	
	@Override
	@Transactional
	public Coleccion updateColeccion (Coleccion theColeccion) {
		Coleccion coleccion = new Coleccion();
		
		coleccion = coleccionDAO.findById(theColeccion.getColeccionId()).get();
		
		Iterator<Item> itemIterator = theColeccion.getitemsDeLaColeccion().iterator();
		
		while (itemIterator.hasNext()) {
			coleccion.addItemsDeLaColeccion(itemIterator.next());  
		}
		
		List <Item> items = coleccion.getitemsDeLaColeccion();
		coleccion = theColeccion;
		coleccion.setitemsDeLaColeccion(items);
		
		return coleccion;
	}

	@Override
	@Transactional
	public void deleteColeccion(int coleccionId) {
		
		coleccionDAO.deleteById(coleccionId);
	}
}





