package com.senai.dbackend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.dbackend.controle_frequencia.models.Usuario;
import com.senai.dbackend.controle_frequencia.models.pauta;
import com.senai.dbackend.controle_frequencia.repositories.UsuarioRepository;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long contarUsuario() {

        return usuarioRepository.count();
    }

    public Usuario buscarUsuario(Integer id) {

        return usuarioRepository.findById(id).get();

    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Boolean deletarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            return true;
        }
        return false;
    }

    public Usuario cadasUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuario){
        Usuario usuarioRecuperado = buscarUsuario(id);
        if (usuarioRecuperado != null){
            usuarioRecuperado.setId(id);
            if (usuario.getNome() != null) {
                usuarioRecuperado.setNome(usuario.getNome());
            }
        
        if(usuario.getDataNascimento()!= null){
            usuarioRecuperado.setDataNascimento
            (usuario.getDataNascimento());

        }
         return usuarioRepository.save(usuarioRecuperado);
    }

        return null;



}}
