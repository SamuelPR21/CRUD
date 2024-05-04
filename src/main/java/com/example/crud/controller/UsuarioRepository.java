package com.example.crud.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository <Usuarios, Integer>{

      Optional<Usuarios> findUserByusername(String username);
}
