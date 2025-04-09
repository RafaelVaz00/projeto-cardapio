package com.littlechef.main.models;


import com.littlechef.main.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CARDAPIO_EMPRESA", schema = "aplicacao")
public class CardapioEmpresaModel implements Serializable {
    @Serial
    public final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardapio_empresa_seq")
    @SequenceGenerator(name = "cardapio_empresa_seq", sequenceName = "aplicacao.cardapio_empresa_id_cardapio_seq")
    @Column(name = "ID_CARDAPIO")
    private Integer idCardapio;

    @Column( name = "NOME_EMPRESA")
    private String nomeEmpresa;

    @Column( name = "DESCRICAO_EMPRESA")
    private String descricaoEmpresa;

    @Column( name = "ESTADO_ATUALIZACAO")
    private Status estadoAtualizacao;

    @Column( name = "ULTIMA_ATUALIZACAO")
    private LocalDate ultimaAtualizacao;

    @Column( name = "LINK_PAGINA")
    private String linkPagina;

    @Column( name = "FK_ID_USUARIO")
    private UUID idUsuario;

    @Column( name = "FK_ID_CATEGORIA")
    private Integer idCategoria;

    public Integer getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
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

    public Status getEstadoAtualizacao() {
        return estadoAtualizacao;
    }

    public void setEstadoAtualizacao(Status estadoAtualizacao) {
        this.estadoAtualizacao = estadoAtualizacao;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
