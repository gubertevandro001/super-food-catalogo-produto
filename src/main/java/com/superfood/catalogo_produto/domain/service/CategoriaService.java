package com.superfood.catalogo_produto.domain.service;

import com.superfood.catalogo_produto.api.model.AtualizarCategoriaRequest;
import com.superfood.catalogo_produto.api.model.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.domain.model.Categoria;
import com.superfood.catalogo_produto.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarPorId(String id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria inexistente"));
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria cadastrar(CadastrarCategoriaRequest request) {
        Categoria categoria = Categoria.novaCategoria(request.nome(), request.descricao());
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(String categoriaId, AtualizarCategoriaRequest request) {
        Categoria categoria = buscarPorId(categoriaId);
        categoria.atualizar(request.nome(), request.descricao());
        return categoriaRepository.save(categoria);
    }
}
