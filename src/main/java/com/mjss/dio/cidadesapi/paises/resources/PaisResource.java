package com.mjss.dio.cidadesapi.paises.resources;

import com.mjss.dio.cidadesapi.paises.entitys.Pais;
import com.mjss.dio.cidadesapi.paises.repositorys.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/paises")
public class PaisResource {

    //@Autowired (usado o construtor abaixo)
    private PaisRepository repository;

    public PaisResource(PaisRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pais> paises(){
        return repository.findAll();
    }
}
