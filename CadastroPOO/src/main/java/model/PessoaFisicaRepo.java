package model;
import java.io.*;
import java.util.ArrayList;

/*

Autor: Wallace Tavares

*/

public class PessoaFisicaRepo {

    // Uma classe para armazenar e gerenciar pessoas físicas

    // Lista de pessoas físicas
    private ArrayList<PessoaFisica> pessoasFisicas;
    private Iterable<PessoaFisica> lista;

    // Construtor da classe
    public PessoaFisicaRepo() {
        // Inicializa a lista de pessoas físicas
        this.pessoasFisicas = new ArrayList<>();
    }

    // Método para inserir uma pessoa física na lista
    public void inserir(PessoaFisica pessoa) {
        this.pessoasFisicas.add(pessoa);
    }

    // Método para alterar os dados de uma pessoa física na lista
    public void alterar(PessoaFisica pessoa) {
        int index = obterIndex(pessoa.getId());
        if (index >= 0) {
            this.pessoasFisicas.set(index, pessoa);
        }
    }

    // Método para excluir uma pessoa física da lista com base no ID
    public void excluir(int id) {
        int index = obterIndex(id);
        if (index >= 0) {
            this.pessoasFisicas.remove(index);
            System.out.println("Pessoa física excluída com sucesso.");
        } else {
            System.out.println("Pessoa física não encontrada.");
        }
    }

    // Método para obter uma pessoa física com base no ID
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : this.pessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    // Método para obter todas as pessoas físicas na lista
    public ArrayList<PessoaFisica> obterTodos() {
        return this.pessoasFisicas;
    }

    // Método para salvar a lista de pessoas físicas em um arquivo
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }

    // Método para recuperar a lista de pessoas físicas de um arquivo
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) inputStream.readObject();
        }
    }

    // Método privado para obter o índice de uma pessoa física na lista com base no ID
    private int obterIndex(int id) {
        for (int i = 0; i < this.pessoasFisicas.size(); i++) {
            PessoaFisica pessoa = this.pessoasFisicas.get(i);
            if (pessoa.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Métodos para definir e obter o nome e o CPF de uma pessoa física
    public void setNome(int id, String nome) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            pessoa.setNome(nome);
        }
    }

    public void setCpf(int id, String cpf) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            pessoa.setCpf(cpf);
        }
    }

    // Métodos não implementados para definir e obter CNPJ (deve ser implementado)
    public void setCnpj(int id, String cnpj) {
        // Implementação da função setCnpj
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNome(int id) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            return pessoa.getNome();
        }
        return null;
    }

    public String getCpf(int id) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            return pessoa.getCpf();
        }
        return null;
    }

    public String getCnpj() {
        // Implementação da função getCnpj
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Método para incluir uma pessoa física na lista
    public void incluir(PessoaFisica fisica) {
        this.pessoasFisicas.add(fisica);
    }

    // Método para alterar os dados de uma pessoa física na lista com base no ID
    public void alterar(int id, PessoaFisica fisica) {
        PessoaFisica pessoaExistente = obter(id);
        if (pessoaExistente != null) {
            pessoaExistente.setNome(fisica.getNome());
            pessoaExistente.setCpf(fisica.getCpf());
        } else {
            System.out.println("Pessoa física não encontrada.");
        }
    }

    // Método para salvar os dados das pessoas físicas em um arquivo de texto
    public void salvarDados(BufferedWriter bufferedWriter) throws IOException {
        for (PessoaFisica fisica : lista) {
            bufferedWriter.write("F");
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(fisica.getId()));
            bufferedWriter.newLine();
            bufferedWriter.write(fisica.getNome());
            bufferedWriter.newLine();
            bufferedWriter.write(fisica.getCpf());
            bufferedWriter.newLine();
        }
    }

    // Getter para obter a lista de pessoas físicas
    public ArrayList<PessoaFisica> getLista() {
        return pessoasFisicas;
    }

    // Setter para definir a lista de pessoas físicas
    public void setLista(ArrayList<PessoaFisica> pessoas) {
        this.pessoasFisicas.clear();
        this.pessoasFisicas.addAll(pessoas);
    }

    // Método para buscar uma pessoa física na lista com base no ID
    public PessoaFisica buscar(int id) {
        for (PessoaFisica pessoa : this.pessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
}
