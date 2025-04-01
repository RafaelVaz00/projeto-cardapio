package com.littlechef.main.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "usuario", schema = "aplicacao")
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private UUID idUsuario;

    @Column(name = "nome_usuario", nullable = false)
    @NotNull
    private String nomeUsuario;

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull
    private LocalDate dataNascimento;

    @Column(name = "cpf_cnpj", nullable = false)
    @NotNull
    private String cpfCnpj;

    @Column(name = "tipo_conta")
    private String tipoConta;

    @Column(name = "id_cargo")
    private UUID idCargo;

    @Column(name = "id_plano")
    private UUID idPlano;

    @Column(name = "senha", nullable = false)
    @NotNull
    private String senha;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setidUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public UUID getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(UUID idCargo) {
        this.idCargo = idCargo;
    }

    public UUID getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(UUID idPlano) {
        this.idPlano = idPlano;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
