package com.mjss.dio.cidadesapi.paises.resources;

import com.mjss.dio.cidadesapi.paises.entitys.Pais;
import com.mjss.dio.cidadesapi.paises.repositorys.PaisRepository;
import com.mjss.dio.cidadesapi.paises.services.PaisService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PaisResource {

    private final PaisService paisService;

    @GetMapping
    public List<Pais> paises(){
        return paisService.listaPaises();
    }

    @GetMapping("/paginado")
    public Page<Pais> paisesPaginado(Pageable page){
        return  paisService.paginaPaises(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity paisPorId(@PathVariable Long id){
        return paisService.paisPorId(id);
    }
}
