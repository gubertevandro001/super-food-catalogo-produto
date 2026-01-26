package com.superfood.catalogo_produto.api.model;

import com.superfood.catalogo_produto.domain.model.Categoria;

public record AtualizarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static AtualizarCategoriaResponse aPartirDe(Categoria categoria) {
        return new AtualizarCategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
