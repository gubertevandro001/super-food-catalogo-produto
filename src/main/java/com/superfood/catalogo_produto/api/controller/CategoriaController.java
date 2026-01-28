package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.model.AtualizarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CategoriaResponse;
import com.superfood.catalogo_produto.domain.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaResponse> buscarTodas() {
        return categoriaService.buscarTodas().stream().map(CategoriaResponse::aPartirDe).toList();
    }

    @GetMapping("/{categoriaId}")
    public CategoriaResponse buscarPorId(@PathVariable String categoriaId) {
        return CategoriaResponse.aPartirDe(categoriaService.buscarPorId(categoriaId));
    }

    @PostMapping
    public CategoriaResponse cadastrar(@RequestBody CadastrarCategoriaRequest request) {
        return CategoriaResponse.aPartirDe(categoriaService.cadastrar(request));
    }

    @PutMapping("/{categoriaId}")
    public CategoriaResponse atualizar(@PathVariable String categoriaId, @RequestBody AtualizarCategoriaRequest request) {
        return CategoriaResponse.aPartirDe(categoriaService.atualizar(categoriaId, request));
    }
}
