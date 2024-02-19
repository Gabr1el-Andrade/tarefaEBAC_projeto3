package br.com.tgabriel.dao.dao;

import br.com.tgabriel.dao.jdbc.ConnectionFactory;
import br.com.tgabriel.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO {
    @Override
    public Integer register(Client client) throws SQLException {
        Connection connection = null;
        PreparedStatement pts = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (ID, CPF, NOME) VALUES (nextval('SQL_CLI'), ?, ?)";

        pts = connection.prepareStatement(sql);

            pts.setString(1, client.getCpf());
            pts.setString(2, client.getNome());
            return pts.executeUpdate();
        }catch (Exception e){
        throw e;

        }finally {
            if (pts != null && !pts.isClosed()){
            pts.close();}

            if (connection != null && !connection.isClosed()){
                connection.close();}
        }

    }

    @Override
    public Client consult(String cpf) throws SQLException {
        Connection connection = null;
        PreparedStatement pts = null;
        ResultSet rs ;
        Client client = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE WHERE cpf = ?";
            pts = connection.prepareStatement(sql);

            pts.setString(1, cpf);
            rs = pts.executeQuery();
            if (rs.next()){
                client = new Client();
                client.setId(rs.getLong("id"));
                client.setCpf(rs.getString("cpf"));
                client.setNome(rs.getString("nome"));
            }
            return client;
        }catch (Exception e){
            throw e;

        }finally {
            if (pts != null && !pts.isClosed()){
                pts.close();}

            if (connection != null && !connection.isClosed()){
                connection.close();}
        }
}

    @Override
    public Integer delete(Client client) throws SQLException {
        Connection connection = null;
        PreparedStatement pts = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_CLIENTE WHERE cpf = ?";
            pts = connection.prepareStatement(sql);

            pts.setString(1, client.getCpf());
            return pts.executeUpdate();
        }catch (Exception e){
            throw e;

        }finally {
            if (pts != null && !pts.isClosed()){
                pts.close();}

            if (connection != null && !connection.isClosed()){
                connection.close();}
        }

    }

    @Override
    public List<Client> searchAll() throws SQLException {
        Connection connection = null;
        PreparedStatement pts = null;
        ResultSet rs = null ;
        List<Client> list = new ArrayList<>();
        Client client = new Client();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE";
            pts = connection.prepareStatement(sql);
            rs = pts.executeQuery();
           while (rs.next()){
               Long id = rs.getLong("id");
               String nome = rs.getString("cpf");
               String cpf = rs.getString("nome");

               client.setId((id));
               client.setCpf((cpf));
               client.setNome((nome));
               list.add(client);
           }
        }catch (Exception e){
            throw e;

        }finally {
            if (pts != null && !pts.isClosed()){
                pts.close();}

            if (connection != null && !connection.isClosed()){
                connection.close();}
        }
        return list;
    }

    @Override
    public Integer upDate(Client client)throws SQLException {
        Connection connection = null;
        PreparedStatement pts = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_CLIENTE SET NOME = ?, CPF = ? ";
            pts = connection.prepareStatement(sql);
            pts.setString(1, client.getNome());
            pts.setString(2, client.getCpf());

            return pts.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            if (pts != null && !pts.isClosed()){
                pts.close();}

            if (connection != null && !connection.isClosed()){
                connection.close();}
        }
    }
}
