package com.mjss.dio.cidadesapi.cidades.entitys;

import com.mjss.dio.cidadesapi.cidades.utils.PointType;
import com.mjss.dio.cidadesapi.estados.entitys.Estado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@TypeDefs(value={
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class Cidade {

    @Id
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private Estado uf; //TODO tratar o relacionamento para trazer só o valor do campo 'uf'

    private Integer ibge;

    //implementamos o mesmo campo do BD de 2 maneiras
    //opção 1
    @Column(name = "lat_lon")
    private String geolocalizacao;
    //opção 2
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point localizacao;

    private Double latitude;
    private Double longitude;
    private Integer cod_tom;
}
