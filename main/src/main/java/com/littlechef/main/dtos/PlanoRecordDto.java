package com.littlechef.main.dtos;

import com.littlechef.main.enums.Visibilidade;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PlanoRecordDto(@NotNull String nomePlano, @NotNull String descricaoPlano, @NotNull Double valorPlano,
                             @NotNull String estadoPlano, @NotNull UUID idUsuario) {
}
