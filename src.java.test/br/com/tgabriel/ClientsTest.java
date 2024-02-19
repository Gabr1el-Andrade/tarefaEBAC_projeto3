package br.com.tgabriel;

import br.com.tgabriel.dao.dao.ClientDAO;
import br.com.tgabriel.dao.dao.IClientDAO;
import br.com.tgabriel.domain.Client;
import org.junit.Test;
import java.sql.SQLException;

import static org.junit.Assert.*;


public class ClientsTest {
   @Test
   public void castrateTest() throws SQLException {
      IClientDAO dao = new ClientDAO();
      Client client = new Client();

      client.setCpf("123");
      client.setNome("test");
      Integer qtd = dao.register(client);
      assertEquals(1, (int) qtd);

      Client client1 = dao.consult(client.getCpf());
      assertNotNull(client1);
      assertNotNull(client1.getId());
      assertEquals(client.getCpf(), client1.getCpf());
      assertEquals(client.getNome(), client1.getNome());

      Integer qtdDell = dao.delete(client1);
      assertNotNull(qtdDell == 1);
   }
   @Test
   public void consulterTest()throws SQLException{
      Client client = new Client();
      IClientDAO dao = new ClientDAO();


      client.setCpf("321");
      client.setNome("ttttt");
      Integer qtd = dao.register(client);
      assertEquals(1, (int) qtd);

      Client client1 = dao.consult(client.getCpf());
      assertNotNull(client1);
      assertNotNull(client1.getId());
      assertEquals(client.getCpf(), client1.getCpf());
      assertEquals(client.getNome(), client1.getNome());

      Integer qtdDell = dao.delete(client1);
      assertNotNull(qtdDell == 1);
   }
   @Test
   public void excluirTest()throws SQLException{
      Client client = new Client();
      IClientDAO dao = new ClientDAO();


      client.setCpf("142");
      client.setNome("eeeeee");
      Integer qtd = dao.register(client);
      assertEquals(1, (int) qtd);

      Client client1 = dao.consult(client.getCpf());
      assertNotNull(client1);
      assertNotNull(client1.getId());
      assertEquals(client.getCpf(), client1.getCpf());
      assertEquals(client.getNome(), client1.getNome());

      Integer qtdDell = dao.delete(client1);
      assertNotNull(qtdDell == 1);
   }
   @Test
   public void searchAllTest()throws SQLException{
      Client client = new Client();
      IClientDAO dao = new ClientDAO();
      client.setCpf("222");
      client.setNome("eeeeee");
      Integer qtd = dao.register(client);
      assertEquals(1, (int) qtd);

      client.setCpf("777");
      client.setNome("ttttt");
      Integer qtd2 = dao.register(client);
      assertEquals(1, (int) qtd2);


      Integer qtdDell = dao.delete(client);
      assertNotNull(qtdDell == 2);
      }

   @Test
   public void upDateTest() throws SQLException {
//      Client client = new Client();
//      ClientDAO dao = new ClientDAO();
//
//      client.setCpf("1567");
//      client.setNome("ssssss");
//      Integer qtd = dao.register(client);
//      assertEquals(1, (int) qtd);
//
//      Client client1 = dao.consult("1567");
//      assertNotNull(client1);
//      assertEquals(client.getCpf(), client1.getCpf());
//      assertEquals(client.getNome(), client1.getNome());
//
//      client1.setCpf("1234");
//      client1.setNome("test2");
//      Integer qtdUpDate = dao.upDate(client1);
//      assertTrue(qtdUpDate == 1);
//
//      Client client2 = dao.consult("1567");
//      assertNull( client2);
//
//      Client client3 = dao.consult("1234");
//      assertNotNull(client3);
//      assertNotNull(client3.getId());
//      assertEquals(client.getCpf(), client3.getCpf());
//      assertEquals(client.getNome(), client3.getNome());
//
//      List<Client> list = dao.searchAll();
//      for (Client cli : list){
//         dao.delete(cli);
//      }
//   }
//}

      Client client = new Client();
      ClientDAO dao = new ClientDAO();

      client.setCpf("1567");
      client.setNome("ssssss");
      Integer qtd = dao.register(client);
      assertEquals(1, (int) qtd);

      Client client1 = dao.consult("1567");
      assertNotNull(client1.getId());
      assertEquals(client.getCpf(), client1.getCpf());
      assertEquals(client.getNome(), client1.getNome());

      client1.setCpf("1234");
      client1.setNome("test2");
      Integer qtdUpDate = dao.upDate(client1);
      assertTrue(qtdUpDate == 1);

      Client client2 = dao.consult("1234");
      assertNotNull(client2);
      assertNotNull(client2.getId());
      assertEquals(client1.getCpf(), client2.getCpf());
      assertEquals(client1.getNome(), client2.getNome());

      Integer qtdDell = dao.delete(client2);
      assertNotNull(qtdDell == 1);
      }
   }
