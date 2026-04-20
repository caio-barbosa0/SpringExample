package com.senai.dbackend.controle_frequencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.dbackend.controle_frequencia.models.Usuario;
import com.senai.dbackend.controle_frequencia.services.UsuarioServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Usuario")
public class UsuarioController { 
    
    @Autowired
    private UsuarioServices usuarioServices;
    

    @GetMapping("/contar-usuarios")
    public Long contarUsuarios(){
        return usuarioServices.contarUsuario();
    }
    
    @GetMapping("/buscar-usuarios/ (id)")
    public Usuario buscarUsuario (@PathVariable Integer id){
          return usuarioServices.buscarUsuario(id);
    }
 
    @GetMapping("listar-usuarios/(id)")
    public List<Usuario> listarUsuarios(){
       return usuarioServices.listarUsuarios(); 
    }
    
 @GetMapping("/deletar-usuario/(id)")
    public String deletarUsuario(@PathVariable Integer id) {
        if(usuarioServices.deletarUsuario(id)){
            return "Usuario removido com sucesso";
        }
        return "falha ao remover usuario";
    }
 
    @GetMapping("/salvar-usuario")
     public Usuario cadastrasUsuario(@RequestBody Usuario usuario){
        return usuarioServices.cadasUsuario(usuario);     
    }

   public String atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
    if (usuarioServices.atualizarUsuario(id, usuario) !=null){
        return "Usuario atualizado com sucesso";
    }
    return "falha ao atualizar usuario";
   }


    
}
