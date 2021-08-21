package com.mjss.dio.cidadesapi.paises.repositorys;

import com.mjss.dio.cidadesapi.paises.entitys.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository  extends JpaRepository<Pais, Long> {
}
