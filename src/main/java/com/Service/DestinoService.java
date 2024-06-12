package com.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.DestinoRepository;
import com.entities.Destino;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public Destino salvarDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    public List<Destino> listarDestinos() {
        return destinoRepository.findAll();
    }

    public Destino obterDestino(Long id) {
        Optional<Destino> destino = destinoRepository.findById(id);
        return destino.orElse(null);
    }

    public void excluirDestino(Long id) {
        destinoRepository.deleteById(id);
    }

    public List<Destino> pesquisarDestinos(String nome) {
        return destinoRepository.findByNomeContaining(nome);
    }
}