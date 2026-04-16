package com.senai.dbackend.controle_frequencia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.dbackend.controle_frequencia.services.UsuarioServices;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController { 

    private UsuarioServices usuarioServices;
    
}
