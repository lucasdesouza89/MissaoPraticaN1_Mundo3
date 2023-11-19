package model;
import java.io.Serializable;
public class PessoaFisica implements Serializable {
    private String cpf;
    private String nome;
    private int id;
    private boolean excluida;

    public PessoaFisica(int id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                ", excluida=" + excluida +
                '}';
    }

    public static void exibirDadosPessoaFisica(PessoaFisica pessoaFisica) {
        System.out.println("ID: " + pessoaFisica.getId());
        System.out.println("Nome: " + pessoaFisica.getNome());
        System.out.println("CPF: " + pessoaFisica.getCpf());
    }
}