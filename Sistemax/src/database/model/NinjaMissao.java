package database.model;

import java.sql.Date;

public class NinjaMissao {
    private int id;
    private int id_ninja;
    private int id_missao;
    private String funcao;
    private Date data_participacao;


    public NinjaMissao() {
    }

    public NinjaMissao(int id, int id_ninja, int id_missao,
                       String funcao, Date data_participacao) {

        this.id = id;
        this.id_ninja = id_ninja;
        this.id_missao = id_missao;
        this.funcao = funcao;
        this.data_participacao = data_participacao;
    }

    public int getId() {
        return id;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public int getId_missao() {
        return id_missao;
    }

    public String getFuncao() {
        return funcao;
    }

    public Date getData_participacao() {
        return data_participacao;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public void setId_missao(int id_missao) {
        this.id_missao = id_missao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setData_participacao(Date data_participacao) {
        this.data_participacao = data_participacao;
    }
}