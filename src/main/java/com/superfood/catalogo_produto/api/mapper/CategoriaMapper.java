package com.superfood.catalogo_produto.api.mapper;

import com.superfood.catalogo_produto.api.model.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.domain.model.Categoria;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {

    private final ModelMapper modelMapper;

    public Categoria toDomainModel(CadastrarCategoriaRequest request) {
        var categoria = new Categoria();
        categoria.setId(UUID.randomUUID().toString());
        modelMapper.map(request, categoria);
        return categoria;
    }

    public CadastrarCategoriaResponse toResponse(Categoria categoria) {
        return modelMapper.map(categoria, CadastrarCategoriaResponse.class);
    }
}
