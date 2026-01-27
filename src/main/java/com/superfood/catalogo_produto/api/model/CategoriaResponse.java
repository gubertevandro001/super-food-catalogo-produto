package com.superfood.catalogo_produto.api.model;

import com.superfood.catalogo_produto.domain.model.Categoria;

public record CategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static CategoriaResponse aPartirDe(Categoria categoria) {
        return  new CategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
