package com.mycompany.cadastropoo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/*

Autor: Wallace Tavares

*/

public class CadastroPOO {

    private static int id;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // criar repositórios para as entidades Física e Jurídica
        PessoaFisicaRepo repFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repJuridica = new PessoaJuridicaRepo();

        while (opcao != 0) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Obter");
            System.out.println("5 - Obter todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar a execução");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o tipo de entidade (Física ou Jurídica):");
                    String tipo = scanner.next();

                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }

                        System.out.println("Digite o nome:");
                        String nome = scanner.next();
                        System.out.println("Digite o CPF:");
                        String cpf = scanner.next();
                        PessoaFisica pessoaFisica = new PessoaFisica(id, cpf, nome);
                        pessoaFisica.setId(id);
                        repFisica.incluir(pessoaFisica);
                        System.out.println("Pessoa física adicionada com sucesso.");
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }

                        System.out.println("Digite o nome:");
                        String nome = scanner.next();
                        System.out.println("Digite o CNPJ:");
                        String cnpj = scanner.next();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(cnpj, id, nome);
                        repJuridica.incluir(pessoaJuridica);
                        System.out.println("Pessoa jurídica adicionada com sucesso.");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                }

                case 2 -> {
                    System.out.println("Digite o tipo de entidade (Física ou Jurídica):");
                    String tipo = scanner.next();
                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }
                        PessoaFisica fisica = repFisica.obter(id);

                        if (fisica != null) {
                            System.out.println("Nome atual: " + fisica.getNome());
                            System.out.println("CPF atual: " + fisica.getCpf());
                            System.out.println("Digite o novo nome:");
                            fisica.setNome(scanner.next());
                            System.out.println("Digite o novo CPF:");
                            fisica.setCpf(scanner.next());
                            repFisica.alterar(id, fisica);
                            System.out.println("Física alterada com sucesso.");
                        } else {
                            System.out.println("Física não encontrada.");
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }
                        PessoaJuridica juridica = repJuridica.obter(id);

                        if (juridica != null) {
                            System.out.println("Nome atual: " + juridica.getNome());
                            System.out.println("CNPJ atual: " + juridica.getCnpj());
                            System.out.println("Digite o novo nome:");
                            juridica.setNome(scanner.next());
                            System.out.println("Digite o novo CNPJ:");
                            juridica.setCnpj(scanner.next());
                            repJuridica.alterar(id, juridica);
                            System.out.println("Jurídica alterada com sucesso.");
                        } else {
                            System.out.println("Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("Digite o tipo de entidade (Física ou Jurídica):");
                    String tipo = scanner.next();
                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }
                        repFisica.excluir(id);
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }
                        repJuridica.excluir(id);
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                }

                case 4 -> {
                    System.out.println("Digite o tipo de entidade (Física ou Jurídica):");
                    String tipo = scanner.next();
                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }
                        PessoaFisica fisica = repFisica.obter(id);

                        if (fisica != null) {
                            System.out.println("Nome: " + fisica.getNome());
                            System.out.println("CPF: " + fisica.getCpf());
                        } else {
                            System.out.println("Física não encontrada.");
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.println("Digite o ID:");
                        int id = 0;
                        try {
                            id = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. O ID deve ser um número inteiro.");
                            break;
                        }
                        PessoaJuridica juridica = repJuridica.obter(id);

                        if (juridica != null) {
                            System.out.println("Nome: " + juridica.getNome());
                            System.out.println("CNPJ: " + juridica.getCnpj());
                        } else {
                            System.out.println("Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("Digite o tipo de entidade (Física ou Jurídica):");
                    String tipo = scanner.next();
                    if (tipo.equalsIgnoreCase("F")) {
                        List<PessoaFisica> fisicas = repFisica.getLista();

                        if (fisicas.isEmpty()) {
                            System.out.println("Nenhuma Física cadastrada.");
                        } else {
                            for (var fisica : fisicas) {
                                int id = 0;
                                System.out.println("ID: " + fisica.getId());
                                System.out.println("Nome: " + fisica.getNome());
                                System.out.println("CPF: " + fisica.getCpf());
                                System.out.println("-----------------------------");
                            }
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        ArrayList<PessoaJuridica> juridicas = repJuridica.obterTodos();

                        if (juridicas.isEmpty()) {
                            System.out.println("Nenhuma Jurídica cadastrada.");
                        } else {
                            for (PessoaJuridica juridica : juridicas) {
                                int id = 0;
                                System.out.println("ID: " + juridica.getId());
                                System.out.println("Nome: " + juridica.getNome());
                                System.out.println("CNPJ: " + juridica.getCnpj());
                                System.out.println("-----------------------------");
                            }
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                }
                case 6 -> {
                    System.out.println("Digite o tipo de entidade (Física ou Jurídica):");
                    String tipoEntidade = scanner.next();

                    String nomeArquivo;
                    if (tipoEntidade.equalsIgnoreCase("F")) {
                        nomeArquivo = "fisicas.txt";
                    } else if (tipoEntidade.equalsIgnoreCase("J")) {
                        nomeArquivo = "juridicas.txt";
                    } else {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    try (FileWriter fileWriter = new FileWriter(nomeArquivo, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                        if (tipoEntidade.equalsIgnoreCase("F")) {

                            for (PessoaFisica fisica : repFisica.getLista()) {
                                bufferedWriter.write("F");
                                bufferedWriter.newLine();
                                bufferedWriter.write(String.valueOf(fisica.getId()));
                                bufferedWriter.newLine();
                                bufferedWriter.write(fisica.getNome());
                                bufferedWriter.newLine();
                                bufferedWriter.write(fisica.getCpf());
                                bufferedWriter.newLine();
                            }
                        } else if (tipoEntidade.equalsIgnoreCase("J")) {

                            for (PessoaJuridica juridica : repJuridica.getLista()) {
                                bufferedWriter.write("J");
                                bufferedWriter.newLine();
                                bufferedWriter.write(String.valueOf((char) juridica.getId()));
                                bufferedWriter.newLine();
                                bufferedWriter.write(juridica.getNome());
                                bufferedWriter.newLine();
                                bufferedWriter.write(juridica.getCnpj());
                                bufferedWriter.newLine();
                            }
                        }

                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException ex) {
                        System.out.println("Erro ao salvar os dados: " + ex.getMessage());
                    }
                    break;
                }

                case 7 -> {
                    System.out.println("Digite o tipo de recuperação de dados (Física ou Jurídica):");
                    String tipoRecuperacao = scanner.next();

                    if (tipoRecuperacao.equalsIgnoreCase("F")) {
                        String nomeArquivoFisica = "fisicas.txt";

                        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoFisica))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line.equals("F")) {
                                    int id = Integer.parseInt(reader.readLine());
                                    String nome = reader.readLine();
                                    String cpf = reader.readLine();

                                    PessoaFisica.exibirDadosPessoaFisica(new PessoaFisica(id, cpf, nome));
                                    System.out.println("-----------------------------");
                                }
                            }

                            System.out.println("Dados físicos recuperados com sucesso.");
                        } catch (IOException ex) {
                            System.out.println("Erro ao recuperar os dados físicos.");
                        }
                    } else if (tipoRecuperacao.equalsIgnoreCase("J")) {
                        String nomeArquivoJuridica = "juridicas.txt";

                        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoJuridica))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line.equals("J")) {
                                    int id = Integer.parseInt(reader.readLine());
                                    String nome = reader.readLine();
                                    String cnpj = reader.readLine();

                                    PessoaJuridica.exibirDadosPessoaJuridica(new PessoaJuridica(cnpj, id, nome));
                                    System.out.println("-----------------------------");
                                }
                            }

                            System.out.println("Dados jurídicos recuperados com sucesso.");
                        } catch (IOException ex) {
                            System.out.println("Erro ao recuperar os dados jurídicos.");
                        }
                    } else {
                        System.out.println("Tipo de recuperação inválido.");
                    }
                    break;
                }
                case 0 ->
                    System.out.println("Encerrando o programa.");
                default ->
                    System.out.println("Opção inválida.");
            }
        }
        while (opcao != 0);
    }

}
