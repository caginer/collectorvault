package com.mycompany.collectorvault.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.collectorvault.entity.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	public Optional<Usuario> findByEmail(String email);
	
	public Optional<Usuario> findByUsernameOrEmail(String email, String username);
	
	public Optional<Usuario> findByUsername(String username);
	
	public boolean existsByUsername(String username);
	
	public boolean existsByEmail(String email);
	

}
