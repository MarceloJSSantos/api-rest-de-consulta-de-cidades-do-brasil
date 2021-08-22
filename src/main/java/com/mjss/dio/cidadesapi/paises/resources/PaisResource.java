package com.mjss.dio.cidadesapi.paises.resources;

import com.mjss.dio.cidadesapi.paises.entitys.Pais;
import com.mjss.dio.cidadesapi.paises.repositorys.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/paginado")
    public Page<Pais> paisesPaginado(Pageable page){
        return  repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity paisPorId(@PathVariable Long id){
        Optional<Pais> optionalPais = repository.findById(id);
        if(optionalPais.isPresent()){
            return ResponseEntity.ok().body(optionalPais.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
