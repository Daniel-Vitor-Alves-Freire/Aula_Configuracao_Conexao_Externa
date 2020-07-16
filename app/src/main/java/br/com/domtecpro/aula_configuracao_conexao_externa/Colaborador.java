package br.com.domtecpro.aula_configuracao_conexao_externa;

public class Colaborador {
    private int id;
    private String nome;
    private String cargo;
    private int situacao;

    public Colaborador(int id, String nome, String cargo, int situacao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.situacao = situacao;
    }

    public Colaborador(String nome, String cargo, int situacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
