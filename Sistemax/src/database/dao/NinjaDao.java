package database.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import model.Ninja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NinjaDao {
    private String insert =
    "INSERT INTO tb_ninja(nome, vila, cla, rank_ninja, natureza_chakra, status) VALUES(?, ?, ?, ?, ?, ?)";

    private String delete =
    "DELETE FROM tb_ninja WHERE id = ?";

    private String update =
    "UPDATE tb_ninja SET vila = ?, cla = ?, rank_ninja = ?, natureza_chakra = ?, status = ? WHERE id = ?";

    private String selectAll =
    "SELECT * FROM tb_ninja";

    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstSelectAll;

    public NinjaDao(Connection conexao) throws SQLException {
        pstInsert = conexao.prepareStatement(insert);
        pstDelete = conexao.prepareStatement(delete);
        pstUpdate = conexao.prepareStatement(update);
        pstSelectAll = conexao.prepareStatement(selectAll);
    }

    public boolean insert(Ninja ninja) throws SQLException {
        pstInsert.setString(1, ninja.getNome());
        pstInsert.setString(2, ninja.getVila());
        pstInsert.setString(3, ninja.getCla());
        pstInsert.setString(4, ninja.getRankNinja());
        pstInsert.setString(5, ninja.getNaturezaChakra());
        pstInsert.setString(6, ninja.getStatus());
        pstInsert.execute();
        return pstInsert.getUpdateCount() > 0;
    }

    public boolean update(Ninja ninja) throws SQLException {
        pstUpdate.setString(1, ninja.getVila());
        pstUpdate.setString(2, ninja.getCla());
        pstUpdate.setString(3, ninja.getRankNinja());
        pstUpdate.setString(4, ninja.getNaturezaChakra());
        pstUpdate.setString(5, ninja.getStatus());
        pstUpdate.setLong(6, ninja.getId());
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<Ninja> selectAll() throws SQLException {

        ArrayList<Ninja> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                Ninja n = new Ninja();
                n.setId(resultado.getLong(1));
                n.setNome(resultado.getString(2));
                n.setVila(resultado.getString(3));
                n.setCla(resultado.getString(4));
                n.setRankNinja(resultado.getString(5));
                n.setNaturezaChakra(resultado.getString(6));
                n.setStatus(resultado.getString(7));
                listaLocal.add(n);
            }
        }
        return listaLocal;
    }

}
