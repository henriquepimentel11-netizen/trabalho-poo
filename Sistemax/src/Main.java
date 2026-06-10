import connection.ConnectionFactory;
import database.dao.ClienteDAO;
import database.model.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conexao = ConnectionFactory.getConnection
                (
                    "localhost",
                    "5432",
                    "sistemax",
                    "postgres",
                    "admin"
                );
        if (conexao != null) {
            System.out.println("CONECTADO COM SUCESSO!");

            //Cliente cliente = new Cliente();
            //cliente.setNome("Vanessa Rocha Alexandre");
            //cliente.setCpf("9999999999");

            ClienteDAO dao = new ClienteDAO(conexao);
            //if (dao.insert(cliente)) {
            //    System.out.println("FEZ INSERT!!!");
            //} else {
            //    System.out.println("DEU ERRO DEMAIS!");
            //}
            dao.update("123.456.789", 2);

        } else {
            System.out.println("DEU RUIM!");
        }

    }
}