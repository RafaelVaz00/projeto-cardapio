package com.littlechef.main.models;

import com.littlechef.main.enums.Visibilidade;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name="produto", schema = "aplicacao")
public class ProdutoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "aplicacao.produto_id_produto_seq")
    @Column(name = "id_produto")
    private Integer id;

    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    @Column(name = "estado_produto", nullable = false)
    private Visibilidade estadoProduto;

    @Column(name = "preco_produto", nullable = false)
    private Double precoProduto;

    @Column(name = "fk_id_categoria")
    private Integer categoriaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Visibilidade getEstadoProduto() {
        return estadoProduto;
    }

    public void setEstadoProduto(Visibilidade estadoProduto) {
        this.estadoProduto = estadoProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}
