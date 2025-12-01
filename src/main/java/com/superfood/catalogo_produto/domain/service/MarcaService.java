package com.superfood.catalogo_produto.domain.service;

import com.superfood.catalogo_produto.domain.model.Marca;
import com.superfood.catalogo_produto.domain.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public Marca salvar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca buscarPorId(String id) {
        return marcaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Marca inexistente")
        );
    }

    public void excluir(String id) {
        buscarPorId(id);
        marcaRepository.deleteById(id);
    }
}
