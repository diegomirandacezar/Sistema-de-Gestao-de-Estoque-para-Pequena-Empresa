package model;

import java.time.LocalDate;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private double quantidade;
    private Integer id_fornecedor;
    private String marca;
    private LocalDate data_validade;
    private String lote;
    private Integer id_categoria;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(int id, String nome, String descricao, double precoUnitario, double quantidade, Integer id_fornecedor, String marca, LocalDate data_validade, String lote, Integer id_categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.id_fornecedor = id_fornecedor;
        this.marca = marca;
        this.data_validade = data_validade;
        this.lote = lote;
        this.id_categoria = id_categoria;
    }
    public Produto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Integer id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                ", id_fornecedor=" + id_fornecedor +
                ", marca='" + marca + '\'' +
                ", data_validade=" + data_validade +
                ", lote='" + lote + '\'' +
                ", id_categoria=" + id_categoria +
                '}';
    }
}
