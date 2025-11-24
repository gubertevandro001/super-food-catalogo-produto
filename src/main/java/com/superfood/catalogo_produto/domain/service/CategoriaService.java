package com.superfood.catalogo_produto.domain.service;

import com.superfood.catalogo_produto.domain.model.Categoria;
import com.superfood.catalogo_produto.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(String id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria inexistente")
        );
    }

    public void excluir(String id) {
        var categoriaExistente = buscarPorId(id);
        categoriaRepository.delete(categoriaExistente);
    }
}
