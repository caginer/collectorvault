package com.mycompany.collectorvault.DAO;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.collectorvault.entity.Plataforma;

public interface PlataformaDAO extends JpaRepository<Plataforma, Integer> {
	
	
}
