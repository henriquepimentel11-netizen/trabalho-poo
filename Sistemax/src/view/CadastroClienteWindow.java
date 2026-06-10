package view;

import connection.ConnectionFactory;
import database.dao.ClienteDAO;
import database.model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroClienteWindow extends JFrame {

    private JTextField txfCliente, txfCPF;
    private JButton btnAdicionar;

    private JTable tblClientes;
    private DefaultTableModel modelClientes;
    private JScrollPane scrollClientes;

    public CadastroClienteWindow() {
        setSize(500,300);
        setLayout(null);
        componentesCriar();
        bancoDeDadosCarregar();
        setVisible(true);
    }

    private void bancoDeDadosCarregar() {
        try {
            Connection conexao = ConnectionFactory.getConnection(
                    "localhost",
                    "5432",
                    "sistemax",
                    "postgres",
                    "admin"
            );

            ClienteDAO dao = new ClienteDAO(conexao);
            ArrayList<Cliente> listaClientes = dao.selectAll();
            for (Cliente c : listaClientes) {
                modelClientes.addRow(new String[]{c.getNome(), c.getCpf()});
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void componentesCriar() {
        txfCliente = new JTextField();
        txfCliente.setBounds(10, 10, 250, 25);
        getContentPane().add(txfCliente);

        txfCPF = new JTextField();
        txfCPF.setBounds(300, 10, 150, 25);
        getContentPane().add(txfCPF);

        btnAdicionar = new JButton(new AbstractAction("SALVAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clienteDigitado = txfCliente.getText();
                String cpfDigitado = txfCPF.getText();

                Cliente c = new Cliente();
                c.setNome(clienteDigitado);
                c.setCpf(cpfDigitado);

                try {
                    Connection conexao = ConnectionFactory.getConnection(
                        "localhost",
                        "5432",
                        "sistemax",
                        "postgres",
                        "admin"
                    );

                    ClienteDAO dao = new ClienteDAO(conexao);
                    if (dao.insert(c)) {
                        JOptionPane.showMessageDialog(null, "Cliente Inserido!");
                        modelClientes.addRow(new String[]{clienteDigitado, cpfDigitado});
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        btnAdicionar.setBounds(10,50, 250, 25);
        getContentPane().add(btnAdicionar);

        modelClientes = new DefaultTableModel();
        modelClientes.addColumn("Cliente");
        modelClientes.addColumn("CPF");

        tblClientes = new JTable(modelClientes);

        scrollClientes = new JScrollPane(tblClientes);
        scrollClientes.setBounds(10, 85, 400, 200);
        getContentPane().add(scrollClientes);

    }

    public static void main(String[] args) {
        new CadastroClienteWindow();
    }

}
