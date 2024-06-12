package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.DestinoService;
import com.entities.Destino;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    public Destino cadastrarDestino(@RequestBody Destino destino) {
        return destinoService.salvarDestino(destino);
    }

    @GetMapping
    public List<Destino> listarDestinos() {
        return destinoService.listarDestinos();
    }

    @GetMapping("/{id}")
    public Destino obterDestino(@PathVariable Long id) {
        return destinoService.obterDestino(id);
    }

    @DeleteMapping("/{id}")
    public void excluirDestino(@PathVariable Long id) {
        destinoService.excluirDestino(id);
    }
}