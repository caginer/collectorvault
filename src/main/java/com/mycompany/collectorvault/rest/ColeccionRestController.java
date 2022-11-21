package com.mycompany.collectorvault.rest;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.collectorvault.exceptions.NotFoundException;
import com.mycompany.collectorvault.service.ColeccionService;
import com.mycompany.collectorvault.DAO.ColeccionDAO;
import com.mycompany.collectorvault.entity.Coleccion;
import com.mycompany.collectorvault.entity.Item;

@RestController
@RequestMapping("/api")
public class ColeccionRestController {
	
	@Autowired
	private ColeccionService coleccionService;
	
	
	@Autowired
	public ColeccionRestController (ColeccionService theColeccionService){
		
		coleccionService = theColeccionService;
		
	}
	
	@GetMapping("/coleccion")
	public List <Coleccion> findAll(){
		
		return coleccionService.getColecciones() ;
		
	}
	
	@GetMapping("/coleccion/{coleccionId}")
	public Coleccion findById(@PathVariable int coleccionId){
		
		return coleccionService.getColeccion(coleccionId);
		
	}
	
	@PutMapping("/coleccion")
	public Coleccion updateColeccion(@RequestBody Coleccion theColeccion) {
		
		
		Coleccion coleccion= new Coleccion();
		
		coleccion =coleccionService.updateColeccion(theColeccion);
		
		coleccionService.saveColeccion(coleccion);
		
		return coleccion;
	}
	
	@PostMapping("/coleccion")
	public Coleccion addColeccion (@RequestBody Coleccion theColeccion) {
		
		// also just in case they pass an id in json ... set id to 0
		// this is to force a save of new item ... instead of update
		
		if (theColeccion.getColeccionId() != 0) {
			
		}
		
		theColeccion.setColeccionId(0);
		
		coleccionService.saveColeccion(theColeccion);
		
		return theColeccion;
	}
	
	@DeleteMapping("/coleccion/{coleccionId}")
	public void deleteColeccion(@PathVariable int coleccionId) {
		
		coleccionService.deleteColeccion(coleccionId);
		
	}

}
