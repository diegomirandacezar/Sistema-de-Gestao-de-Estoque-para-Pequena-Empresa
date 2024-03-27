package view;

import model.Fornecedor;
import model.FornecedorDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FornecedorMenu {
    public static void main(String[] args) throws SQLException {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        int opcao;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("[1]Listar\n[2]Buscar\n[3]inserir\n[4]Atualizar\n[5]Deletar\n[0]Sair\n    Opcao:");
            opcao = sc.nextInt();

            if (opcao == 1) {
                ArrayList<Fornecedor> fornecedores = fornecedorDAO.listarFornecedor();

                System.out.println("+------------------------+");
                System.out.printf("| %-4s | %-50s |%-15s |%n", "ID", "NOME","ID ENDERECO");
                System.out.println("+------------------------+");
                for (Fornecedor fornecedor : fornecedores) {
                    System.out.println(fornecedor);
                }
                System.out.println("+------------------------+");
            } else if (opcao == 2) {
                System.out.println("Informe o Id Fornecedor");
                int id = sc.nextInt();

                Fornecedor fornecedor = fornecedorDAO.buscarUm(id);
                System.out.println("+------------------------+");
                System.out.printf("| %-4s | %-50s |%-15s |%n", "ID", "NOME","ID ENDERECO");
                System.out.println("+------------------------+");
                System.out.println(fornecedor);
                System.out.println("+------------------------+");
            } else if (opcao == 3) {
                System.out.println("Informe o nome do Fornecedor: ");
                String nome = sc.next();
                System.out.println("Informe o ID Endereço do Fornecedor: ");
                String descricao = sc.next();

                fornecedorDAO.inserir(new Fornecedor(nome));
                fornecedorDAO.inserir(new Fornecedor(descricao));
            } else if (opcao == 4) {
                System.out.print("Informe o ID do Fornecedor: ");
                int id = sc.nextInt();
                System.out.print("Informe o novo nome do Fornecedor: ");
                String novoNome = sc.next();

                // Produto novoProduto = new Produto(id,novoNome);

                //  produtoDAO.atualizar(novoProduto);

            }
            else if (opcao == 5) {
                System.out.print("Informe o ID: ");
                int id = sc.nextInt();

                fornecedorDAO.deletar(id);
            }

        }while (opcao != 0);
    }
}


