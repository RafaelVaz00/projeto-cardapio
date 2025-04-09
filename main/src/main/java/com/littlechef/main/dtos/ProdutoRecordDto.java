package com.littlechef.main.dtos;

import com.littlechef.main.enums.Visibilidade;
import jakarta.validation.constraints.NotNull;

public record ProdutoRecordDto(@NotNull String nomeProduto, String descricaoProduto, @NotNull Visibilidade estadoProduto, @NotNull Double precoProduto) {

}
