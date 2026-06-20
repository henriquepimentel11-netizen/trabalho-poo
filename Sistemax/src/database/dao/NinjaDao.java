package database.dao;


import java.sql.Connection;
import database.model.Ninja;
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
    "UPDATE tb_ninja SET nome = ?, vila = ?, cla = ?, rank_ninja = ?, natureza_chakra = ?, status = ? WHERE id = ?";

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
        pstUpdate.setString(1, ninja.getNome());
        pstUpdate.setString(2, ninja.getVila());
        pstUpdate.setString(3, ninja.getCla());
        pstUpdate.setString(4, ninja.getRankNinja());
        pstUpdate.setString(5, ninja.getNaturezaChakra());
        pstUpdate.setString(6, ninja.getStatus());
        pstUpdate.setInt(7, ninja.getId());
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<Ninja> selectAll() throws SQLException {

        ArrayList<Ninja> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                Ninja n = new Ninja();
                n.setId(resultado.getInt("id"));
                n.setNome(resultado.getString("nome"));
                n.setVila(resultado.getString("vila"));
                n.setCla(resultado.getString("cla"));
                n.setRankNinja(resultado.getString("rank_ninja"));
                n.setNaturezaChakra(resultado.getString("natureza_chakra"));
                n.setStatus(resultado.getString("status"));
                listaLocal.add(n);
            }
        }
        return listaLocal;
    }

    public boolean delete(int id) throws SQLException {
        pstDelete.setInt(1, id);
        pstDelete.execute();
        return pstDelete.getUpdateCount() > 0;
    }

}
