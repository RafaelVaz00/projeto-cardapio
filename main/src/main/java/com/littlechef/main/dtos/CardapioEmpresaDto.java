package com.littlechef.main.dtos;

import com.littlechef.main.enums.Status;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CardapioEmpresaDto(@NotNull String nomeEmpresa, @NotNull String descricaoEmpresa, Status estadoAtualizacao,
                                 LocalDate ultimaAtualizacao, String linkPagina, @NotNull UUID idUsuario) {
}
