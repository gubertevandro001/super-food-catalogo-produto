package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.mapper.CategoriaMapper;
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
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @PostMapping
    public CadastrarCategoriaResponse cadastrar(@RequestBody CadastrarCategoriaRequest request) {
        var categoria = categoriaMapper.toDomainModel(request);

        categoriaService.salvar(categoria);
        return categoriaMapper.cadastroResponse(categoria);
    }

    @PutMapping("/{categoriaId}")
    public AtualizarCategoriaResponse atualizar(@PathVariable String categoriaId, @RequestBody AtualizarCategoriaRequest request) {
        var categoriaExistente = categoriaService.buscarPorId(categoriaId);

        categoriaMapper.copyToDomainModel(request, categoriaExistente);
        categoriaService.salvar(categoriaExistente);
        return categoriaMapper.atualizacaoResponse(categoriaExistente);
    }
}
