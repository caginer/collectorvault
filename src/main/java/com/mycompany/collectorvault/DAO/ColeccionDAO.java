package com.mycompany.collectorvault.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.collectorvault.entity.Coleccion;

public interface ColeccionDAO extends JpaRepository<Coleccion, Integer> {
	
	Page <Coleccion> findByUsername(String username, Pageable pageable);

}