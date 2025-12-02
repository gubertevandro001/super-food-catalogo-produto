package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.model.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.domain.model.Categoria;
import com.superfood.catalogo_produto.domain.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ModelMapper modelMapper;

    @PostMapping
    public CadastrarCategoriaResponse cadastrar(CadastrarCategoriaRequest categoria) {
        var novaCategoria = new Categoria();
        novaCategoria.setId(UUID.randomUUID().toString());
        modelMapper.map(categoria, novaCategoria);
        return modelMapper.map(categoriaService.salvar(novaCategoria), CadastrarCategoriaResponse.class);
    }
}
