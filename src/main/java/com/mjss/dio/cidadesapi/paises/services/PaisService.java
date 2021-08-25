package com.mjss.dio.cidadesapi.paises.services;

import com.mjss.dio.cidadesapi.paises.entitys.Pais;
import com.mjss.dio.cidadesapi.paises.repositorys.PaisRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PaisService {

    private final PaisRepository paisRepository;

    public List<Pais> listaPaises(){
        return paisRepository.findAll();
    }

    public Page<Pais> paginaPaises(Pageable page){
        return paisRepository.findAll(page);
    }

    public ResponseEntity paisPorId(Long id){
        Optional<Pais> paisOptional = paisRepository.findById(id);
        ResponseEntity response;
        if(paisOptional.isPresent()){
            response = ResponseEntity.ok().body(paisOptional.get());
        }else{
            response = ResponseEntity.notFound().build();
        }
        return response;
    }
}
