package com.superfood.catalogo_produto.domain.service;

import com.superfood.catalogo_produto.api.model.AtualizarMarcaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarMarcaRequest;
import com.superfood.catalogo_produto.domain.model.Marca;
import com.superfood.catalogo_produto.domain.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca buscarPorId(String id) {
        return marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca inexistente"));
    }

    public List<Marca> buscarTodas() {
        return marcaRepository.findAll();
    }

    public Marca cadastrar(CadastrarMarcaRequest request) {
        Marca marca = Marca.novaMarca(request.nome(), request.descricao());
        return marcaRepository.save(marca);
    }

    public Marca atualizar(String marcaId, AtualizarMarcaRequest request) {
        Marca marca = buscarPorId(marcaId);
        marca.atualizar(request.nome(), request.descricao());
        return marcaRepository.save(marca);
    }
}
