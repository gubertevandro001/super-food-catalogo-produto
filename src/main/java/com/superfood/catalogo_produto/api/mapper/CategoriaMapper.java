package com.superfood.catalogo_produto.api.mapper;

import com.superfood.catalogo_produto.api.model.AtualizarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.AtualizarCategoriaResponse;
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

    public CadastrarCategoriaResponse cadastroResponse(Categoria categoria) {
        return modelMapper.map(categoria, CadastrarCategoriaResponse.class);
    }

    public AtualizarCategoriaResponse atualizacaoResponse(Categoria categoria) {
        return modelMapper.map(categoria, AtualizarCategoriaResponse.class);
    }

    public void copyToDomainModel(AtualizarCategoriaRequest request, Categoria categoria) {
        modelMapper.map(request, categoria);
    }
}
