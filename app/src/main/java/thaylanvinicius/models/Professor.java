package thaylanvinicius.models;

public class Professor {
    private int id;
    private String nome;
    private String componente;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getComponente() {
        return componente;
    }
}

