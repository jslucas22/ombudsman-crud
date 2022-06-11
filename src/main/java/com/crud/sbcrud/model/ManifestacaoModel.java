package com.crud.sbcrud.model;

import javax.persistence.*;

@Entity
@Table(name = "OUVIDORIA_MANIFESTACAO")
public class ManifestacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManifestacao() {
        return manifestacao;
    }

    public void setManifestacao(String manifestacao) {
        this.manifestacao = manifestacao;
    }

    public String manifestacao;

    @ManyToOne
    @JoinColumn(name = "manifestante_id")
    public Manifestante manifestante;

    @ManyToOne
    @JoinColumn(name = "manifestado_id")
    public Manifestado manifestado;

    @ManyToOne
    @JoinColumn(name = "tipo_manifestacao_id")
    public TipoManifestacao tipoManifestacao;


    @ManyToOne
    @JoinColumn(name = "tag_id")
    public Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public TipoManifestacao getTipoManifestacao() {
        return tipoManifestacao;
    }

    public void setTipoManifestacao(TipoManifestacao tipoManifestacao) {
        this.tipoManifestacao = tipoManifestacao;
    }

    public Manifestado getManifestado() {
        return manifestado;
    }

    public void setManifestado(Manifestado manifestado) {
        this.manifestado = manifestado;
    }

    public Manifestante getManifestante() {
        return manifestante;
    }

    public void setManifestante(Manifestante manifestante) {
        this.manifestante = manifestante;
    }

}
