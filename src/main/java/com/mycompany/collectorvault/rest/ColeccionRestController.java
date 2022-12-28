package com.mycompany.collectorvault.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.collectorvault.service.ColeccionService;
import com.mycompany.collectorvault.utilities.AppConstants;
import com.mycompany.collectorvault.DTO.ColeccionDTO;
import com.mycompany.collectorvault.DTO.ColeccionRespuesta;
import com.mycompany.collectorvault.entity.Coleccion;

@RestController
@RequestMapping("/api")
public class ColeccionRestController {

	@Autowired
	private ColeccionService coleccionService;

	@Autowired
	public ColeccionRestController(ColeccionService theColeccionService) {

		coleccionService = theColeccionService;

	}

	@GetMapping("/coleccion")
	public ColeccionRespuesta findAll(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
			@RequestParam(value = "sortBy", defaultValue = "coleccionId", required = false) String ordenarPor,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir) {

		return coleccionService.getColecciones(numeroDePagina, medidaDePagina, ordenarPor, sortDir);

	}

	@GetMapping("/coleccion/{coleccionId}")
	public Coleccion findById(@PathVariable int coleccionId) {

		return coleccionService.getColeccion(coleccionId);

	}

	@PutMapping("/coleccion")
	public ColeccionDTO updateColeccion(@RequestBody ColeccionDTO theColeccionDTO) {

		ColeccionDTO coleccionDTO = new ColeccionDTO();

		coleccionDTO = coleccionService.updateColeccion(theColeccionDTO);

		coleccionService.saveColeccion(coleccionDTO);

		return coleccionDTO;
	}

	@PostMapping("/coleccion")
	public ColeccionDTO addColeccion(@RequestBody ColeccionDTO theColeccionDTO) {

		// also just in case they pass an id in json ... set id to 0
		// this is to force a save of new item ... instead of update

		if (theColeccionDTO.getColeccionId() != 0) {
			theColeccionDTO.setColeccionId(0);
		}

		return coleccionService.saveColeccion(theColeccionDTO);
	}

	@DeleteMapping("/coleccion/{coleccionId}")
	public void deleteColeccion(@PathVariable int coleccionId) {

		coleccionService.deleteColeccion(coleccionId);

	}

}
