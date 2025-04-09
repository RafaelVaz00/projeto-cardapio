package com.littlechef.main.models;


import com.littlechef.main.enums.Visibilidade;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "plano", schema = "aplicacao")
public class PlanoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_plano")
    private UUID idPlano;

    @Column(name = "nome_plano", nullable = false, length = 16)
    private String nomePlano;

    @Column(name ="descricao_plano", nullable = false, length = 230)
    private String descricaoPlano;

    @Column (name ="valor_Plano", nullable = false)
    private Double valorPlano;

    @Column (name ="estado_Plano")
    private String estadoPlano;

    @Column (name ="FK_ID_USUARIO")
    private UUID idUsuario;

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

    public Double getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(Double valorPlano) {
        this.valorPlano = valorPlano;
    }

    public String getEstadoPlano() {
        return estadoPlano;
    }

    public void setEstadoPlano(String estadoPlano) {
        this.estadoPlano = estadoPlano;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }
}
