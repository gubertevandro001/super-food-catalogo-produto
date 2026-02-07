package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.model.AtualizarMarcaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarMarcaRequest;
import com.superfood.catalogo_produto.api.model.MarcaResponse;
import com.superfood.catalogo_produto.domain.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<MarcaResponse> buscarTodas() {
        return marcaService.buscarTodas().stream().map(MarcaResponse::aPartirDe).toList();
    }

    @GetMapping("/{marcaId}")
    public MarcaResponse buscarPorId(@PathVariable String marcaId) {
        return MarcaResponse.aPartirDe(marcaService.buscarPorId(marcaId));
    }

    @PostMapping
    public MarcaResponse cadastrar(@RequestBody CadastrarMarcaRequest request) {
        return MarcaResponse.aPartirDe(marcaService.cadastrar(request));
    }

    @PutMapping("/{marcaId}")
    public MarcaResponse atualizar(@PathVariable String marcaId, @RequestBody AtualizarMarcaRequest request) {
        return MarcaResponse.aPartirDe(marcaService.atualizar(marcaId, request));
    }
}
