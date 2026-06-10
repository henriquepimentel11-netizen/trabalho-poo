package database.dao;

import database.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private String insert =
    "INSERT INTO tb_clientes(nome, cpf) VALUES(?, ?)";

    private String delete =
    "DELETE FROM tb_clientes WHERE id = ?";

    private String update =
    "UPDATE tb_clientes SET cpf = ? WHERE id = ?";

    private String selectAll =
    "SELECT * FROM tb_clientes";

    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstSelectAll;

    public ClienteDAO(Connection conexao) throws SQLException {
        pstInsert = conexao.prepareStatement(insert);
        pstDelete = conexao.prepareStatement(delete);
        pstUpdate = conexao.prepareStatement(update);
        pstSelectAll = conexao.prepareStatement(selectAll);
    }

    public boolean insert(Cliente cliente) throws SQLException {
        pstInsert.setString(1, cliente.getNome());
        pstInsert.setString(2, cliente.getCpf());
        pstInsert.execute();
        return pstInsert.getUpdateCount() > 0;
    }

    public boolean update(String cpfAtualizado, long id) throws SQLException {
        pstUpdate.setString(1, cpfAtualizado);
        pstUpdate.setLong(2, id);
        pstUpdate.execute();
        return pstUpdate.getUpdateCount() > 0;
    }

    public ArrayList<Cliente> selectAll() throws SQLException {

        ArrayList<Cliente> listaLocal = new ArrayList<>();
        ResultSet resultado = pstSelectAll.executeQuery();
        if (resultado != null) {
            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setId(resultado.getLong(1));
                c.setNome(resultado.getString(2));
                c.setCpf(resultado.getString(3));
                listaLocal.add(c);
            }
        }
        return listaLocal;
    }

}
