package com.superfood.catalogo_produto.domain.model;

import com.superfood.catalogo_produto.domain.util.IdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    protected Categoria() {}

    private Categoria(String nome, String descricao) {
        this.id = IdGenerator.generateId();
        this.nome = nome;
        this.descricao = descricao;
    }

    public static Categoria novaCategoria(String nome, String descricao) {
        return new Categoria(nome, descricao);
    }

    public Categoria atualizar(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}