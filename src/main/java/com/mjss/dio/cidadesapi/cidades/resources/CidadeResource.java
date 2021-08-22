package com.mjss.dio.cidadesapi.cidades.resources;

import com.mjss.dio.cidadesapi.cidades.entitys.Cidade;
import com.mjss.dio.cidadesapi.cidades.repositotys.CidadeRepository;
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
@RequestMapping("/cidades")
public class CidadeResource {

    private CidadeRepository cidadeRepository;

    public CidadeResource(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @GetMapping
    public List<Cidade> cidades(){
        return cidadeRepository.findAll();
    }

    @GetMapping("/paginado")
    public Page<Cidade> cidadesPaginado(Pageable page){
        return cidadeRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity cidadePorId(@PathVariable Long id){
        Optional<Cidade> optionalCidade = cidadeRepository.findById(id);
        if(optionalCidade.isPresent()){
            return ResponseEntity.ok().body(optionalCidade.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
