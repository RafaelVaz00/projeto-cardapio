package com.littlechef.main.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioRecordDto(@NotNull String nomeUsuario, @NotNull String email, @NotNull LocalDate dataNascimento,
                               @NotNull String cpfCnpj, UUID idPlano, Integer idCardapio, @NotNull String senha) {

}
