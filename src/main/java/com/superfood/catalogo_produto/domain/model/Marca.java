package com.superfood.catalogo_produto.domain.model;

import com.superfood.catalogo_produto.domain.util.IdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "MARCA")
public class Marca {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    protected Marca() {}

    private Marca(String nome, String descricao) {
        this.id = IdGenerator.generateId();
        this.nome = nome;
        this.descricao = descricao;
    }

    public static Marca novaMarca(String nome, String descricao) {
        return new Marca(nome, descricao);
    }

    public Marca atualizar(String nome, String descricao) {
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
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}