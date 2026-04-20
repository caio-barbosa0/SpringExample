package com.senai.dbackend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.dbackend.controle_frequencia.models.pauta;
import com.senai.dbackend.controle_frequencia.repositories.PautaRepository;

@Service
public class PautaService {
   
   @Autowired
   private PautaRepository pautaRepository;
   
   public Long contarPautas(){
    return pautaRepository.count();
   } 

    public pauta buscarPauta (Integer id) {
    return pautaRepository.findById(id).get();
   }

   public List<pauta> listarpautas() {

    return pautaRepository.findAll();
   }   
   
  public Boolean deletarPauta (Integer id){
    if (pautaRepository.existsById(id)){
        pautaRepository.deleteById(id);
        return true;
    }
    return false;

  }
 
  public pauta cadastrarPauta(pauta pauta){
    return pautaRepository.save(pauta);
  }

public pauta atualizarPauta(Integer id, pauta pauta) {
    pauta pautaRecuperada = buscarPauta(id);
    if (pautaRecuperada != null){
        pautaRecuperada.setId(id);
        if(pauta.getTurma()!=null){
            pautaRecuperada.setTurma(pauta.getTurma());
        }
   
        return pautaRepository.save(pautaRecuperada);

    }
    return null;
}









}
