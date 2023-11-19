package model;

import java.io.Serializable;

/*

Autor: Wallace Tavares

 */
public class Pessoa implements Serializable {

    //atributos 
    private int id;
    private String nome;
    private boolean excluida;

    //método construtor
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.excluida = false; // Por padrão, a pessoa não está excluída
    }

    //métodos especiais 
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

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + this.getNome());
    }

}
