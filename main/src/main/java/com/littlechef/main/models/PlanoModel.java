package com.littlechef.main.models;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "plano")
public class PlanoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @PrimaryKeyJoinColumn
    private UUID idPlano;
    @Column(name = "nome_plano")
    private String nomePlano;
    @Column(name ="descricao_plano")
    private String descricaoPlano;
    @Column (name ="valor_Plano")
    private Integer valorPlano;
    @Column (name ="Estado_Plano")
    private String EstadoPlano;
    @Column (name ="id_Usuario")
    private Integer idUsuario;

    public UUID getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(UUID idPlano) {
        this.idPlano = idPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescricaoPlano() {
        return descricaoPlano;
    }

    public void setDescricaoPlano(String descricaoPlano) {
        this.descricaoPlano = descricaoPlano;
    }

    public Integer getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(Integer valorPlano) {
        this.valorPlano = valorPlano;
    }

    public String getEstadoPlano() {
        return EstadoPlano;
    }

    public void setEstadoPlano(String estadoPlano) {
        EstadoPlano = estadoPlano;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
