package com.mycompany.collectorvault.service;

import java.lang.System.Logger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@Autowired
	private ModelMapper modelMapper;

	// need to inject Coleccion dao
	@Autowired
	private ColeccionDAO coleccionDAO;

	@Override
	@Transactional
	public ColeccionRespuesta getColecciones(int numeroDePagina, int medidaDePagina, String ordenarPor,
			String sortDir) {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
         String username = userDetails.getUsername();
		
        if (username != "admin") {	
        	
        	System.out.println("----------------" + username + "dentro del if");
        	return getColeccionesByUsername(numeroDePagina, medidaDePagina,ordenarPor,
        			sortDir,username);     	
        }
        
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
				: Sort.by(ordenarPor).descending();

		Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

		
		
		Page<Coleccion> laColeccion = coleccionDAO.findAll(pageable);

		List<Coleccion> listaLaColeccion = laColeccion.getContent();
		List<ColeccionDTO> contenido = convertListEntityToDto(listaLaColeccion);

		ColeccionRespuesta coleccionRespuesta = new ColeccionRespuesta();

		coleccionRespuesta.setContenido(contenido);
		coleccionRespuesta.setNumeroPagina(laColeccion.getNumber());
		coleccionRespuesta.setMedidaPagina(laColeccion.getSize());
		coleccionRespuesta.setTotalElementos(laColeccion.getTotalElements());
		coleccionRespuesta.setTotalPaginas(laColeccion.getTotalPages());
		coleccionRespuesta.setUltima(laColeccion.isLast());

		
		System.out.println("----------------" + username + "fuera del if");
		
		return coleccionRespuesta;

	}
	
	@Override
	@Transactional
	public ColeccionRespuesta getColeccionesByUsername(int numeroDePagina, int medidaDePagina, String ordenarPor,
			String sortDir, String username) {

		System.out.println("----------------" + username + "dentro del if");
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
				: Sort.by(ordenarPor).descending();

		Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

		
		Page<Coleccion> laColeccion = coleccionDAO.findByUsername(username, pageable);

		List<Coleccion> listaLaColeccion = laColeccion.getContent();
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

		// System.out.println(id);

		return convertEntityToDto(coleccion);

	}

	@Override
	@Transactional
	public Coleccion getColeccion(int coleccionId) {

		return coleccionDAO.findById(coleccionId).get();

	}

	@Override
	@Transactional
	public ColeccionDTO updateColeccion(ColeccionDTO theColeccionDTO) {
		Coleccion coleccion = new Coleccion();

		Coleccion theColeccion = convertDtoToEntity(theColeccionDTO);

		coleccion = coleccionDAO.findById(theColeccion.getColeccionId()).get();

		Iterator<Item> itemIterator = theColeccion.getItemsDeLaColeccion().iterator();

		while (itemIterator.hasNext()) {
			coleccion.addItemsDeLaColeccion(itemIterator.next());
		}

		List<Item> items = coleccion.getItemsDeLaColeccion();
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
						dto.getNumeroArticulos(), dto.getFechaApertura(), dto.getUsername(), dto.getPlataforma(),
						dto.getItemsDeLaColeccion()))
				.collect(Collectors.toList());
	}

	private static List<ColeccionDTO> convertListEntityToDto(List<Coleccion> Dto) {
		return Dto.stream()
				.map(dto -> new ColeccionDTO(dto.getColeccionId(), dto.getNombreCol(), dto.getValor(),
						dto.getNumeroArticulos(), dto.getFechaApertura(), dto.getUsername(), dto.getPlataforma(),
						dto.getItemsDeLaColeccion()))
				.collect(Collectors.toList());
	}

	private Coleccion convertDtoToEntity(ColeccionDTO theColeccionDTO) {

		Coleccion coleccion = modelMapper.map(theColeccionDTO, Coleccion.class);

		return coleccion;

	}

	private ColeccionDTO convertEntityToDto(Coleccion theColeccion) {

		ColeccionDTO coleccionDTO = modelMapper.map(theColeccion, ColeccionDTO.class);

		return coleccionDTO;

	}

}
