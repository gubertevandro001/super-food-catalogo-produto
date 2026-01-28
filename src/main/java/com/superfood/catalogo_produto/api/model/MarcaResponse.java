package com.superfood.catalogo_produto.api.model;

import com.superfood.catalogo_produto.domain.model.Marca;

public record MarcaResponse(
        String id,
        String nome,
        String descricao
) {

    public static MarcaResponse aPartirDe(Marca marca) {
        return  new MarcaResponse(
                marca.getId(),
                marca.getNome(),
                marca.getDescricao()
        );
    }
}
