package database.model;

public class Missao {
    private int id;
    private String titulo;
    private String descricao;
    private String rank_missao;
    private String vila_origem;
    private String status;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRank_missao() {
        return rank_missao;
    }

    public String getVila_origem() {
        return vila_origem;
    }

    public String getStatus() {
        return status;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRank_missao(String rank_missao) {
        this.rank_missao = rank_missao;
    }

    public void setVila_origem(String vila_origem) {
        this.vila_origem = vila_origem;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
