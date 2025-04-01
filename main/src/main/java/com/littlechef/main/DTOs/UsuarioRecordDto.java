package com.littlechef.main.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record UsuarioRecordDto(@NotNull String nomeUsuario, @NotNull String email, @NotNull LocalDate dataNascimento,
                               @NotNull String cpfCnpj, String TipoConta, Integer idCargo, Integer idPlano, @NotNull String senha) {

}
