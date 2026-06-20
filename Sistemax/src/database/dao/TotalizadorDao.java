package database.dao;

import java.sql.Connection;
import database.model.Totalizador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class TotalizadorDao {
    private String insert =
    "INSERT INTO tb_totalizador(descricao, quantidade, datageracao) VALUES(?, ?, ?)";

    private String delete =
    "DELETE FROM tb_totalizador WHERE id = ?";

    private String update =
    "UPDATE tb_totalizador SET descricao = ?, quantidade = ?, datageracao = ? WHERE id = ?";

    private String selectAll =
    "SELECT * FROM tb_totalizador";

    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstSelectAll;

    public TotalizadorDao(Connection conexao) throws SQLException {
        pstInsert = conexao.prepareStatement(insert);
        pstDelete = conexao.prepareStatement(delete);
        pstUpdate = conexao.prepareStatement(update);
        pstSelectAll = conexao.prepareStatement(selectAll);
    }

    public boolean insert(Totalizador totalizador) throws SQLException {
        pstInsert.setString(1, totalizador.getDescricao());
        pstInsert.setInt(2, totalizador.getQuantidade());
        pstInsert.setTimestamp(3, totalizador.getDatageracao());
        pstInsert.execute();
        return pstInsert.getUpdateCount() > 0;
    }

    public boolean update(Totalizador totalizador) throws SQLException {
        pstUpdate.setString(1, totalizador.getDescricao());
        pstUpdate.setInt(2, totalizador.getQuantidade());
        pstUpdate.setTimestamp(3, totalizador.getDatageracao());
        pstUpdate.setInt(4, totalizador.getId());
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<Totalizador> selectAll() throws SQLException {

        ArrayList<Totalizador> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                Totalizador t = new Totalizador();
                t.setId(resultado.getInt("id"));
                t.setDescricao(resultado.getString("descricao"));
                t.setQuantidade(resultado.getInt("quantidade"));
                t.setDatageracao(resultado.getTimestamp("datageracao"));
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
