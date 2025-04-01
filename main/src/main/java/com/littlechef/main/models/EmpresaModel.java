package com.littlechef.main.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table( name = "EMPRESA")
public class EmpresaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( generator = "UUID")
    private UUID idEmpresa;
    @Column( name = "NOME_EMPRESA")
    private String nomeEmpresa;
    @Column( name = "DESCRICAO_EMPRESA")
    private String descricaoEmpresa;
    @Column( name = "ESTADO_ATUALIZACAO")
    private String estadoAtualizacao;
    @Column( name = "ULTIMA_ATUALIZACAO")
    private Date ultimaAtualizacao;
    @Column( name = "LINK_PAGINA")
    private String linkPagina;
    @Column( name = "ID_USUARIO")
    private Integer idUsuario;

    public UUID getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(UUID idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }

    public String getEstadoAtualizacao() {
        return estadoAtualizacao;
    }

    public void setEstadoAtualizacao(String estadoAtualizacao) {
        this.estadoAtualizacao = estadoAtualizacao;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
