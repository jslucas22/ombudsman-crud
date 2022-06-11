package com.crud.sbcrud.model;

import javax.persistence.*;

@Entity
@Table(name = "OUVIDORIA_TIPO_MANIFESTACAO")
public class TipoManifestacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer id;
    public String tipo;
    public String descricao;
}
