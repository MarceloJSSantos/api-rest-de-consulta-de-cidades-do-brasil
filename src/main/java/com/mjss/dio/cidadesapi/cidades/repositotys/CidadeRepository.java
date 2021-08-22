package com.mjss.dio.cidadesapi.cidades.repositotys;

import com.mjss.dio.cidadesapi.cidades.entitys.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
