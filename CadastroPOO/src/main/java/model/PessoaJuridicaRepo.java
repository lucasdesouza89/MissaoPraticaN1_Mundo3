package model;
import java.io.*;
import java.util.*;
/*

Autor: Wallace Tavares

*/
public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    private Iterable<PessoaJuridica> lista;

    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        pessoasJuridicas.add(pessoa);
    }

    public void alterar(PessoaJuridica pessoa) {
        int index = obterIndex(pessoa.getId());
        if (index >= 0) {
            this.pessoasJuridicas.set(index, pessoa);
        }
    }

    public void excluir(int id) {
        int index = obterIndex(id);
        if (index >= 0) {
            this.pessoasJuridicas.remove(index);
            System.out.println("Pessoa jurídica excluída com sucesso.");
        } else {
            System.out.println("Pessoa jurídica não encontrada.");
        }
    }

   public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : this.pessoasJuridicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return this.pessoasJuridicas;
    }

     public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasJuridicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) inputStream.readObject();
        }
    }

    private int obterIndex(int id) {
        for (int i = 0; i < this.pessoasJuridicas.size(); i++) {
            PessoaJuridica pessoa = this.pessoasJuridicas.get(i);
            if (pessoa.getId() == id) {
                return i;
            }
        }
        return -1;
    }
    

    public void setNome(int id, String nome) {
        PessoaJuridica pessoa = obter(id);
        if (pessoa != null) {
            pessoa.setNome(nome);
        }
    }

    public void setCnpj(int id, String cnpj) {
        PessoaJuridica pessoa = obter(id);
        if (pessoa != null) {
            pessoa.setCnpj(cnpj);
        }
    }

    public void incluir(PessoaJuridica juridica) {
        this.pessoasJuridicas.add(juridica);
    }

    public void alterar(int id, PessoaJuridica juridica) {
        PessoaJuridica pessoaExistente = obter(id);
        if (pessoaExistente != null) {
            pessoaExistente.setNome(juridica.getNome());
            pessoaExistente.setCnpj(juridica.getCnpj());
        } else {
            System.out.println("Pessoa jurídica não encontrada.");
        }
    }
    public void salvarDados(BufferedWriter bufferedWriter) throws IOException {
    for (PessoaJuridica juridica : lista) {
        bufferedWriter.write("J");
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(juridica.getId()));
        bufferedWriter.newLine();
        bufferedWriter.write(juridica.getNome());
        bufferedWriter.newLine();
        bufferedWriter.write(juridica.getCnpj());
        bufferedWriter.newLine();
    }
}

    public ArrayList<PessoaJuridica> getLista() {
        return pessoasJuridicas;
    }

    public void setLista(ArrayList<PessoaJuridica> pessoas) {
        this.pessoasJuridicas.clear();
        this.pessoasJuridicas.addAll(pessoas);
    }
    public PessoaJuridica buscar(int id) {
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; 
    }
}