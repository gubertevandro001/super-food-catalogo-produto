package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.model.AtualizarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.AtualizarCategoriaResponse;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.domain.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CadastrarCategoriaResponse cadastrar(@RequestBody CadastrarCategoriaRequest request) {
        return CadastrarCategoriaResponse.aPartirDe(categoriaService.cadastrar(request));
    }

    @PutMapping("/{categoriaId}")
    public AtualizarCategoriaResponse atualizar(@PathVariable String categoriaId, @RequestBody AtualizarCategoriaRequest request) {
        return AtualizarCategoriaResponse.aPartirDe(categoriaService.atualizar(categoriaId, request));
    }
}
