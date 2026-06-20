package database.dao;

import java.sql.Connection;
import database.model.NinjaMissao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class NinjaMissaoDao {
    private String insert =
    "INSERT INTO tb_ninja_missao (id_ninja, id_missao, funcao, data_participacao) VALUES (?, ?, ?, ?)";

    private String delete =
    "DELETE FROM tb_ninja_missao WHERE id = ?";
    
    private String update =
    "UPDATE tb_ninja_missao SET id_ninja = ?, id_missao = ?, funcao = ?, data_participacao = ? WHERE id = ?";

    private String selectAll =
    "SELECT * FROM tb_ninja_missao";

    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstSelectAll;

    public NinjaMissaoDao(Connection conexao) throws SQLException {
        pstInsert = conexao.prepareStatement(insert);
        pstDelete = conexao.prepareStatement(delete);
        pstUpdate = conexao.prepareStatement(update);
        pstSelectAll = conexao.prepareStatement(selectAll);
    }

    public boolean insert(NinjaMissao ninjaMissao) throws SQLException {
        pstInsert.setInt(1, ninjaMissao.getId_ninja());
        pstInsert.setInt(2, ninjaMissao.getId_missao());
        pstInsert.setString(3, ninjaMissao.getFuncao());
        pstInsert.setDate(4, ninjaMissao.getData_participacao());
        pstInsert.execute();
        return pstInsert.getUpdateCount() > 0;
    }

    public boolean update(NinjaMissao ninjaMissao) throws SQLException {
        pstUpdate.setInt(1, ninjaMissao.getId_ninja());
        pstUpdate.setInt(2, ninjaMissao.getId_missao());
        pstUpdate.setString(3, ninjaMissao.getFuncao());
        pstUpdate.setDate(4, ninjaMissao.getData_participacao());
        pstUpdate.setInt(5, ninjaMissao.getId());
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<NinjaMissao> selectAll() throws SQLException {

        ArrayList<NinjaMissao> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                NinjaMissao nm = new NinjaMissao();
                nm.setId(resultado.getInt("id"));
                nm.setId_ninja(resultado.getInt("id_ninja"));
                nm.setId_missao(resultado.getInt("id_missao"));
                nm.setFuncao(resultado.getString("funcao"));
                nm.setData_participacao(resultado.getDate("data_participacao"));
                listaLocal.add(nm);
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
