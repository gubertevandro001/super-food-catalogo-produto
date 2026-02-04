package com.superfood.catalogo_produto.domain.model;

import com.superfood.catalogo_produto.domain.util.IdGenerator;
import com.superfood.catalogo_produto.domain.util.SkuGenerator;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "CODIGO_SKU")
    private String codigoSku;

    @Column(name = "UNIDADE_COMERCIAL")
    @Enumerated(EnumType.STRING)
    private UnidadeComercial unidadeComercial;

    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "PRODUTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORIA_ID"))
    private List<Categoria> categorias = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "MARCA_ID")
    private Marca marca;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "USA_CONTROLE_LOTE")
    private Boolean usaControleDeLote;

    @Column(name = "CODIGO_DE_BARRAS")
    private String codigoDeBarras;

    @Column(name = "PRECO_VENDA")
    private BigDecimal precoVenda;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    protected Produto() {}

    private Produto(String nome, String descricao, UnidadeComercial unidadeComercial,
                    Marca marca, Boolean usaControleDeLote, String codigoDeBarras,
                    BigDecimal precoVenda) {
        this.id = IdGenerator.generateId();
        this.nome = nome;
        this.codigoSku = SkuGenerator.gerarSku();
        this.descricao = descricao;
        this.ativo = true;
        this.unidadeComercial = unidadeComercial;
        this.marca = marca;
        this.usaControleDeLote = usaControleDeLote;
        this.codigoDeBarras = codigoDeBarras;
        this.precoVenda = precoVenda;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public static Produto novoProduto(String nome, String descricao, UnidadeComercial unidadeComercial,
                                      Marca marca, Boolean usaControleDeLote, String codigoDeBarras,
                                      BigDecimal precoVenda) {
        return new Produto(nome, descricao, unidadeComercial, marca, usaControleDeLote, codigoDeBarras, precoVenda);
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

    public String getCodigoSku() {
        return codigoSku;
    }

    public UnidadeComercial getUnidadeComercial() {
        return unidadeComercial;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Marca getMarca() {
        return marca;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Boolean getUsaControleDeLote() {
        return usaControleDeLote;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
