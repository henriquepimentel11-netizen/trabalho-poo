import connection.ConnectionFactory;
import database.dao.MissaoDao;
import database.dao.NinjaDao;
import database.model.Missao;
import database.model.Ninja;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.conectar();

        if(con != null) {
            System.out.println("Conectado com sucesso!");
        } else {
            System.out.println("Erro na conexão!");
        }
    }
}