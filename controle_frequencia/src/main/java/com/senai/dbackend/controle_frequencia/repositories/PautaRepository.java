package com.senai.dbackend.controle_frequencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.dbackend.controle_frequencia.models.pauta;

@Repository
public interface PautaRepository extends JpaRepository <pauta, Integer> {
    
}
