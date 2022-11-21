package com.mycompany.collectorvault.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mycompany.collectorvault.DAO.PlataformaDAO;
import com.mycompany.collectorvault.entity.Plataforma;

@RestController
@RequestMapping("/api")
public class PlataformaRestController {
	
	@Autowired
	private PlataformaDAO plataformaDAO;
	
	
	@Autowired
	public PlataformaRestController (PlataformaDAO thePlataformaDAO){
		
		plataformaDAO = thePlataformaDAO;
		
	}
	
	@GetMapping("/plataforma")
	public List <Plataforma> findAll(){
		
		return plataformaDAO.findAll() ;
		
	}

}
