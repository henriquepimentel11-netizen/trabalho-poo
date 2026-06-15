package database.model;

import java.sql.Timestamp;

public class Totalizador {
    private int id;
    private String descricao;
    private int quantidade;
    private Timestamp datageracao;

    public Totalizador(int id,
                        String descricao,
                        int quantidade,
                        Timestamp datageracao) {

            this.id = id;
            this.descricao = descricao;
            this.quantidade = quantidade;
            this.datageracao = datageracao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Timestamp getDatageracao() {
        return datageracao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDatageracao(Timestamp datageracao) {
        this.datageracao = datageracao;
    }
}
