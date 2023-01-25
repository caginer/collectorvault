package com.mycompany.collectorvault.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.collectorvault.entity.Rol;

public interface RolDAO extends JpaRepository<Rol,Long> {
	
	public Optional<Rol> findByNombre(String nombre);
	
}
