package com.littlechef.main.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "cargo")
public class CargoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( generator = "UUID")
    private UUID idCargo;
    @Column(name = "NOME_CARGO")
    private String nomeCargo;
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
}



