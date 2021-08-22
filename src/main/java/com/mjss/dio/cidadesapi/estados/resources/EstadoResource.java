package com.mjss.dio.cidadesapi.estados.resources;

import com.mjss.dio.cidadesapi.estados.entitys.Estado;
import com.mjss.dio.cidadesapi.estados.repositorys.EstadoRepository;
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

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> estados(){
        return repository.findAll();
    }

    @GetMapping("/paginado")
    public Page<Estado> estadosPaginado(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity estadoPorId(@PathVariable Long id){
        Optional<Estado> optionalEstado = repository.findById(id);
        if(optionalEstado.isPresent()){
            return ResponseEntity.ok().body(optionalEstado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
