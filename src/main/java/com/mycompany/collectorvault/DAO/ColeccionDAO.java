package com.mycompany.collectorvault.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.collectorvault.entity.Coleccion;

public interface ColeccionDAO extends JpaRepository<Coleccion, Integer> {

}