package br.com.tgabriel.dao.dao;

import br.com.tgabriel.domain.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientDAO {
     Integer register(Client client) throws SQLException;

     Client consult(String cpf) throws SQLException;

     Integer delete(Client client1)throws SQLException;

     List<Client> searchAll()throws SQLException;

     Integer upDate(Client client1) throws SQLException;
}
