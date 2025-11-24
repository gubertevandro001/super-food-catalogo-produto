package com.superfood.catalogo_produto.domain.repository;

import com.superfood.catalogo_produto.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
