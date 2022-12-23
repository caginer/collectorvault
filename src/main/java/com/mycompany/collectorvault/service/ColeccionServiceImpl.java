package com.mycompany.collectorvault.service;

import java.lang.System.Logger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycompany.collectorvault.DAO.ColeccionDAO;
import com.mycompany.collectorvault.DTO.ColeccionDTO;
import com.mycompany.collectorvault.DTO.ColeccionRespuesta;
import com.mycompany.collectorvault.entity.Coleccion;
import com.mycompany.collectorvault.entity.Item;

@Service
public class ColeccionServiceImpl implements ColeccionService {

	// need to inject Coleccion dao
	@Autowired
	private ColeccionDAO coleccionDAO;
	
	@Override
	@Transactional
	public ColeccionRespuesta getColecciones(int numeroDePagina,int medidaDePagina, String ordenarPor) {
		
		Pageable pageable = PageRequest.of(numeroDePagina,  medidaDePagina); 
		
		Page<Coleccion>laColeccion = coleccionDAO.findAll(pageable);
		
		List<Coleccion>listaLaColeccion = laColeccion.getContent();
		List<ColeccionDTO> contenido = convertListEntityToDto(listaLaColeccion); 
		
		ColeccionRespuesta coleccionRespuesta = new ColeccionRespuesta();
		
		coleccionRespuesta.setContenido(contenido);
		coleccionRespuesta.setNumeroPagina(laColeccion.getNumber());
		coleccionRespuesta.setMedidaPagina(laColeccion.getSize());
		coleccionRespuesta.setTotalElementos(laColeccion.getTotalElements());
		coleccionRespuesta.setTotalPaginas(laColeccion.getTotalPages());
		coleccionRespuesta.setUltima(laColeccion.isLast());
		
		return coleccionRespuesta;
		
	}

	@Override
	@Transactional
	public ColeccionDTO saveColeccion(ColeccionDTO theColeccionDTO) {                      
		
		Coleccion coleccion = new Coleccion();
		coleccion = convertDtoToEntity(theColeccionDTO);

		coleccion = coleccionDAO.save(coleccion);
		
		//System.out.println(id); 
		
		return convertEntityToDto(coleccion);
		
	}

	@Override
	@Transactional
	public Coleccion getColeccion(int coleccionId) {
		
		return coleccionDAO.findById(coleccionId).get();
		

	}
	
	@Override
	@Transactional
	public ColeccionDTO updateColeccion (ColeccionDTO theColeccionDTO) {
		Coleccion coleccion = new Coleccion();
		
		Coleccion theColeccion = convertDtoToEntity(theColeccionDTO);
		
		coleccion = coleccionDAO.findById(theColeccion.getColeccionId()).get();
		
		Iterator<Item> itemIterator = theColeccion.getItemsDeLaColeccion().iterator();
		
		while (itemIterator.hasNext()) {
			coleccion.addItemsDeLaColeccion(itemIterator.next());  
		}
		
		List <Item> items = coleccion.getItemsDeLaColeccion();
		coleccion = theColeccion;
		coleccion.setItemsDeLaColeccion(items);
		
		theColeccionDTO = convertEntityToDto(coleccion);
		
		return theColeccionDTO;
	}

	@Override
	@Transactional
	public void deleteColeccion(int coleccionId) {
		
		coleccionDAO.deleteById(coleccionId);
	}
	

	private static List<Coleccion> convertListDtoToEntity(List<ColeccionDTO> aDto) {
		return aDto.stream()
				.map(dto -> new Coleccion(dto.getColeccionId(), dto.getNombreCol(), dto.getValor(),
						dto.getNumeroArticulos(), dto.getFechaApertura(), dto.getUsuarioid(), dto.getPlataforma(),
						dto.getItemsDeLaColeccion()))
				.collect(Collectors.toList());
	}


	private static List<ColeccionDTO> convertListEntityToDto(List<Coleccion> Dto) {
		return Dto.stream()
				.map(dto -> new ColeccionDTO(dto.getColeccionId(), dto.getNombreCol(), dto.getValor(),
						dto.getNumeroArticulos(), dto.getFechaApertura(), dto.getUsuarioid(), dto.getPlataforma(),
						dto.getItemsDeLaColeccion()))
				.collect(Collectors.toList());
	}
	
	private static Coleccion convertDtoToEntity (ColeccionDTO theColeccionDTO) {
		
		Coleccion coleccion = new Coleccion();
		coleccion.setColeccionId(theColeccionDTO.getColeccionId());
		coleccion.setNombreCol(theColeccionDTO.getNombreCol());
		coleccion.setPlataforma(theColeccionDTO.getPlataforma());
		coleccion.setUsuarioid(theColeccionDTO.getUsuarioid());
		coleccion.setItemsDeLaColeccion(theColeccionDTO.getItemsDeLaColeccion());
		coleccion.setFechaApertura(theColeccionDTO.getFechaApertura());
		coleccion.setNumeroArticulos(theColeccionDTO.getNumeroArticulos());
		coleccion.setValor(theColeccionDTO.getValor());
		
		return coleccion;
		
		
	}
	
	private static ColeccionDTO convertEntityToDto (Coleccion theColeccion) {
		
		ColeccionDTO coleccionDTO = new ColeccionDTO();
		coleccionDTO.setColeccionId(theColeccion.getColeccionId());
		coleccionDTO.setNombreCol(theColeccion.getNombreCol());
		coleccionDTO.setPlataforma(theColeccion.getPlataforma());
		coleccionDTO.setUsuarioid(theColeccion.getUsuarioid());
		coleccionDTO.setItemsDeLaColeccion(theColeccion.getItemsDeLaColeccion());
		coleccionDTO.setFechaApertura(theColeccion.getFechaApertura());
		coleccionDTO.setNumeroArticulos(theColeccion.getNumeroArticulos());
		coleccionDTO.setValor(theColeccion.getValor());
		
		return coleccionDTO;
		
		
	}

}





