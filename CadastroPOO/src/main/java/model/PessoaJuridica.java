package model;
import java.io.Serializable;

/*

Autor: Wallace Tavares

*/

public class PessoaJuridica implements Serializable {
    private String cnpj;
    private String nome;
    private int id;
    private boolean excluida;

    public PessoaJuridica(String cnpj, int id, String nome) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                ", excluida=" + excluida +
                '}';
    }

    public static void exibirDadosPessoaJuridica(PessoaJuridica pessoaJuridica) {
        System.out.println("ID: " + pessoaJuridica.getId());
        System.out.println("Nome: " + pessoaJuridica.getNome());
        System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
    }
}