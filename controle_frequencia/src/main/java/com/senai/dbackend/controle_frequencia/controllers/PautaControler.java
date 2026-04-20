package com.senai.dbackend.controle_frequencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.dbackend.controle_frequencia.models.pauta;
import com.senai.dbackend.controle_frequencia.services.PautaService;

@RestController
@RequestMapping("/pauta")
public class PautaControler {
    
    @Autowired
    private PautaService pautaservice;
    
    @GetMapping("/cotar-pautas")
    public Long contarpautas(){
        return pautaservice.contarPautas();
    }
    
    @GetMapping("/listar-pautas")
    public List<pauta> listarPautas(){ 
        return pautaservice.listarpautas();
    }
 
    @DeleteMapping("/deletar-pauta/(id)")
   public String deletarPauta(@PathVariable Integer id){
    if (pautaservice.deletarPauta(id)){
        return "pauta excluida com sucesso";
    }
    return "falha na exclusão da pauta";
   }
 
   @PostMapping("/salvar-pauta")
   public pauta cadastrarPauta(@RequestBody pauta pauta){
    return pautaservice.cadastrarPauta(pauta);
   }
   

   @PutMapping("/atualizar-pauta(id)")
   public String atualizarPauta(
    @PathVariable Integer id,
    @RequestBody pauta pauta
   ){
    if(pautaservice.atualizarPauta(id,pauta) !=null){
        return"Pauta atualizada com sucesso";
    }
    return"falha na atualização da pauta";
   }







}
