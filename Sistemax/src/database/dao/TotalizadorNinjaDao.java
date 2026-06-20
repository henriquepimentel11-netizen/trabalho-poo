package database.dao;

import java.sql.Connection;
import database.model.TotalizadorNinja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class TotalizadorNinjaDao {
    private String insert =
    "INSERT INTO tb_totalizador_ninja(descricao, quantidade, data_geracao) VALUES(?, ?, ?)";

    private String delete =
    "DELETE FROM tb_totalizador_ninja WHERE id = ?";

    private String update =
    "UPDATE tb_totalizador_ninja SET descricao = ?, quantidade = ?, data_geracao = ? WHERE id = ?";

    private String selectAll =
    "SELECT * FROM tb_totalizador_ninja";

    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstSelectAll;

    public TotalizadorNinjaDao(Connection conexao) throws SQLException {
        pstInsert = conexao.prepareStatement(insert);
        pstDelete = conexao.prepareStatement(delete);
        pstUpdate = conexao.prepareStatement(update);
        pstSelectAll = conexao.prepareStatement(selectAll);
    }

    public boolean insert(TotalizadorNinja totalizador) throws SQLException {
        pstInsert.setString(1, totalizador.getDescricao());
        pstInsert.setInt(2, totalizador.getQuantidade());
        pstInsert.setTimestamp(3, totalizador.getDatageracao());
        pstInsert.execute();
        return pstInsert.getUpdateCount() > 0;
    }

    public boolean update(TotalizadorNinja totalizador) throws SQLException {
        pstUpdate.setString(1, totalizador.getDescricao());
        pstUpdate.setInt(2, totalizador.getQuantidade());
        pstUpdate.setTimestamp(3, totalizador.getDatageracao());
        pstUpdate.setInt(4, totalizador.getId());
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<TotalizadorNinja> selectAll() throws SQLException {

        ArrayList<TotalizadorNinja> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                TotalizadorNinja t = new TotalizadorNinja();
                t.setId(resultado.getInt("id"));
                t.setDescricao(resultado.getString("descricao"));
                t.setQuantidade(resultado.getInt("quantidade"));
                t.setDatageracao(resultado.getTimestamp("data_geracao"));
                listaLocal.add(t);
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
