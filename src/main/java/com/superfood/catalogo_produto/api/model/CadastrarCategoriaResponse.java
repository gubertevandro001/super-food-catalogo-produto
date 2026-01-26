package com.superfood.catalogo_produto.api.model;

import com.superfood.catalogo_produto.domain.model.Categoria;

public record CadastrarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static CadastrarCategoriaResponse aPartirDe(Categoria categoria) {
        return  new CadastrarCategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
