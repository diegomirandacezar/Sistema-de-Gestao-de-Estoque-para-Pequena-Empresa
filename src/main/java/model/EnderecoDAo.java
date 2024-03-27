package model;

import controller.ConexaoSQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAo {
    private Connection conn;

    public EnderecoDAo() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }

    public ArrayList<Endereco> ListarEndereco() throws SQLException {
        ArrayList<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM endereco ; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Endereco endereco = new Endereco();
            endereco.setId(resultSet.getInt("id"));
            endereco.setLogradouro(resultSet.getString("logradouro"));
            endereco.setNumero(resultSet.getString("numero"));
            endereco.setComplemento(resultSet.getString("complemento"));
            endereco.setBairro(resultSet.getString("bairro"));
            endereco.setCidade(resultSet.getString("cidade"));
            endereco.setEstado(resultSet.getString("estado"));
            endereco.setCep(resultSet.getInt("cep"));
            endereco.setTelefone(resultSet.getInt("telefone"));
            endereco.setEmail(resultSet.getString("email"));

            enderecos.add(endereco);
        }
        return enderecos;
    }

    public void inserirEndereco(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO endereco VALUES (null, ?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, endereco.getId());
        preparedStatement.setString(2, endereco.getLogradouro());
        preparedStatement.setString(3, endereco.getNumero());
        preparedStatement.setString(4, endereco.getComplemento());
        preparedStatement.setString(5, endereco.getBairro());
        preparedStatement.setString(6, endereco.getCidade());
        preparedStatement.setString(7, endereco.getEstado());
        preparedStatement.setInt(8,endereco.getCep() );
        preparedStatement.setInt(9,endereco.getTelefone() );
        preparedStatement.setString(10,endereco.getEmail() );

        preparedStatement.executeUpdate();
    }
}