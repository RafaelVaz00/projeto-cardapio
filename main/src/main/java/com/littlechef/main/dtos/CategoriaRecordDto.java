package com.littlechef.main.dtos;

import jakarta.validation.constraints.NotNull;

public record CategoriaRecordDto(@NotNull String nomeCategoria, @NotNull String visibilidade) {
}
