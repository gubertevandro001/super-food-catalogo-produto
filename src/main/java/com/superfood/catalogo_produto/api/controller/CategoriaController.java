package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.mapper.CategoriaMapper;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.domain.model.Categoria;
import com.superfood.catalogo_produto.domain.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    @PostMapping
    public CadastrarCategoriaResponse cadastrar(@RequestBody CadastrarCategoriaRequest categoria) {
        return categoriaMapper.toResponse(categoriaService.salvar(categoriaMapper.toDomainModel(categoria)));
    }
}
