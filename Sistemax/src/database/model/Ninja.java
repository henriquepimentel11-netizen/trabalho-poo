package database.model;

public class Ninja {
    private int id;
    private String nome;
    private String vila;
    private String cla;
    private String rankNinja;
    private String naturezaChakra;
    private String status;

    public Ninja() {
    }

    public Ninja(int id, String nome, String vila, String cla,
                 String rankNinja, String naturezaChakra,
                 String status) {

        this.id = id;
        this.nome = nome;
        this.vila = vila;
        this.cla = cla;
        this.rankNinja = rankNinja;
        this.naturezaChakra = naturezaChakra;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getVila() {
        return vila;
    }

    public String getCla() {
        return cla;
    }

    public String getRankNinja() {
        return rankNinja;
    }

    public String getNaturezaChakra() {
        return naturezaChakra;
    }

    public String getStatus() {
        return status;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVila(String vila) {
        this.vila = vila;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public void setRankNinja(String rankNinja) {
        this.rankNinja = rankNinja;
    }

    public void setNaturezaChakra(String naturezaChakra) {
        this.naturezaChakra = naturezaChakra;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
