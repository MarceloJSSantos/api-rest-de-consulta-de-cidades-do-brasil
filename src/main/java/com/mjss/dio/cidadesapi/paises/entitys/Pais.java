package com.mjss.dio.cidadesapi.paises.entitys;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@Getter
@NoArgsConstructor
public class Pais {

    @Id
    private Long id;

    private String nome;

    @Column(name="nome_pt")
    private String nomePortugues;

    @Column(name = "sigla")
    private String codigo;

    private Integer bacen;

}
