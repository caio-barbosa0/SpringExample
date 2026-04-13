package com.senai.dbackend.controle_frequencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.dbackend.controle_frequencia.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
    
}
