package model;

import controller.ConexaoSQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO()throws SQLException {
        conn = ConexaoSQLite.getConexao();
    }
    public ArrayList<Produto> listar() throws SQLException {

        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();

            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPrecoUnitario(resultSet.getDouble("preco_unitario"));
            produto.setQuantidade(resultSet.getDouble("quantidade"));
            produto.setId_fornecedor(resultSet.getInt("id_fornecedor"));
            produto.setMarca(resultSet.getString("marca"));
            //produto.setData_validade(resultSet.getString("data_validade"));
            //produto.setData_validade(LocalDate.parse(resultSet.getString("data_validade")));
            produto.setLote(resultSet.getString("lote"));
            produto.setId_categoria(resultSet.getInt("id_categoria"));

            produtos.add(produto);
        }

            return produtos;
        }

        public Produto buscarUm (Integer id) throws SQLException {
            String sql = "SELECT * FROM produto WHERE id = ?;";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Produto produto = new Produto();

            while (resultSet.next()) {
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPrecoUnitario(resultSet.getDouble("preco_unitario"));
                produto.setQuantidade(resultSet.getDouble("quantidade"));
                produto.setId_fornecedor(resultSet.getInt("id_fornecedor"));
                produto.setMarca(resultSet.getString("marca"));
                //produto.setData_validade(LocalDate.parse(resultSet.getString("data_validade")));
                produto.setLote(resultSet.getString("lote"));
                produto.setId_categoria(resultSet.getInt("id_categoria"));
            }
            return produto;
        }
        public void inserir(Produto produto) throws SQLException {
            String sql = "INSERT INTO produto VALUES (null, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.executeUpdate();
    }
    public void atualizar(Produto produto)throws SQLException{
        String sql = "UPDATE produto SET nome = ? WHERE id = ?;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setInt(2, produto.getId());

        preparedStatement.executeUpdate();
    }
    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
