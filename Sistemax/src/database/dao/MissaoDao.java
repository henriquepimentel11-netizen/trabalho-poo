package database.dao;

import java.sql.Connection;
import database.model.Missao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class MissaoDao {
    private String insert =
    "INSERT INTO tb_missao(titulo, descricao, dificuldade, prazo) VALUES(?, ?, ?, ?)";

    private String delete =
    "DELETE FROM tb_missao WHERE id = ?";

    private String update =
    "UPDATE tb_missao SET titulo = ?, descricao = ?, dificuldade = ?, prazo = ? WHERE id = ?";

    private String selectAll =
    "SELECT * FROM tb_missao";

    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstSelectAll;

    public MissaoDao(Connection conexao) throws SQLException {
        pstInsert = conexao.prepareStatement(insert);
        pstDelete = conexao.prepareStatement(delete);
        pstUpdate = conexao.prepareStatement(update);
        pstSelectAll = conexao.prepareStatement(selectAll);
    }

    public boolean insert(Missao missao) throws SQLException {
        pstInsert.setString(1, missao.getTitulo());
        pstInsert.setString(2, missao.getDescricao());
        pstInsert.setString(3, missao.getRank_missao());
        pstInsert.setString(4, missao.getVila_origem());
        pstInsert.setString(5, missao.getStatus());
        pstInsert.execute();
        return pstInsert.getUpdateCount() > 0;
    }

    public boolean update(Missao missao) throws SQLException {
        pstUpdate.setString(1, missao.getTitulo());
        pstUpdate.setString(2, missao.getDescricao());
        pstUpdate.setString(3, missao.getRank_missao());
        pstUpdate.setString(4, missao.getVila_origem());
        pstUpdate.setString(5, missao.getStatus());
        pstUpdate.setInt(6, missao.getId());
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<Missao> selectAll() throws SQLException {

        ArrayList<Missao> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                Missao m = new Missao();
                m.setId(resultado.getInt(1));
                m.setTitulo(resultado.getString(2));
                m.setDescricao(resultado.getString(3));
                m.setRank_missao(resultado.getString(4));
                m.setVila_origem(resultado.getString(5));
                m.setStatus(resultado.getString(6));
                listaLocal.add(m);
            }
        }
        return listaLocal;
    }
}
