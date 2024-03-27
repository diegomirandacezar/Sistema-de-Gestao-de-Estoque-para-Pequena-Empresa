package view;

import model.Categoria;
import model.Fornecedor;
import model.Produto;
import model.ProdutoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoMenu {
    public static void main(String[] args)throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        int opcao;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("[1]Listar\n[2]Buscar\n[3]inserir\n[4]Atualizar\n[5]Deletar\n[0]Sair\n    Opcao:");
            opcao = sc.nextInt();

            if (opcao == 1) {
                ArrayList<Produto> produtos = produtoDAO.listar();

                System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");


                System.out.printf("| %-4s | %-30s | %-50s | %-12s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", "ID", "NOME","DESCRICAO","PRECO UNIT.","QTDADE","ID FORNECEDOR","MARCA","DATA VALIDADE","LOTE","ID CATEGORIA");
                //System.out.printf("| %-4s | %-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%10s|%10s|%10s|%n", "ID", "NOME","DESCRICAO","PRECO UNIT.","QTDADE","ID FORNECEDOR","MARCA","DATA VALIDADE","LOTE","ID CATEGORIA");
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                for (Produto produto : produtos) {
                    System.out.printf("| %-4s | %-30s | %-50s | %-12s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPrecoUnitario(), produto.getQuantidade(), produto.getId_fornecedor(), produto.getMarca(), produto.getData_validade(), produto.getLote(), produto.getId_categoria());
                }
                    System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");


                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
            } else if (opcao == 2) {
                System.out.println("Informe o Id do Produto");
                int id = sc.nextInt();

                Produto produto = produtoDAO.buscarUm(id);

                System.out.println("+------------------------+");
                System.out.printf("| %-4s | %-30s | %-50s | %-12s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", "ID", "NOME","DESCRICAO","PRECO UNIT.","QTDADE","ID FORNECEDOR","MARCA","DATA VALIDADE","LOTE","ID CATEGORIA");
               // System.out.printf("| %-4s | %-50s |%-15s |%n", "ID", "NOME", "ID ENDERECO");
                System.out.println("+------------------------+");
                System.out.printf("| %-4s | %-30s | %-50s | %-12s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPrecoUnitario(), produto.getQuantidade(), produto.getId_fornecedor(), produto.getMarca(), produto.getData_validade(), produto.getLote(), produto.getId_categoria());
                //System.out.println(System.out.printf("| %-4s | %-30s | %-50s | %-12s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", produto.getId(), produto.getNome(),produto.getDescricao(),produto.getPrecoUnitario(),produto.getQuantidade(),produto.getId_fornecedor(),produto.getMarca(),produto.getData_validade(),produto.getLote(),produto.getId_categoria());
                System.out.println("+------------------------+");

            } else if (opcao == 3) {
                System.out.println("Informe o nome do Produto: ");
                String nome = sc.next();
                System.out.println("Informe a Descrição do Produto: ");
                String descricao = sc.next();
                System.out.println("Informe o Preço Unitario do Produto: ");
                String precoUnitario = sc.next();
                System.out.println("Informe a Quantidade do Produto: ");
                String quantidade = sc.next();
                System.out.println("Informe o ID Fornecedor do Produto: ");
                String idFornecedor = sc.next();
                System.out.println("Informe a Marca do Produto: ");
                String Marca = sc.next();
                System.out.println("Informe a Data_Validade do Produto: ");
                String dataValidade = sc.next();
                System.out.println("Informe o Lote do Produto: ");
                String lote = sc.next();
                System.out.println("Informe o Id Categoria do Produto: ");
                String idCategoria = sc.next();

                produtoDAO.inserir(new Produto(nome));
                produtoDAO.inserir(new Produto(descricao));
                produtoDAO.inserir(new Produto(precoUnitario));
                produtoDAO.inserir(new Produto(quantidade));
                produtoDAO.inserir(new Produto(idFornecedor));
                produtoDAO.inserir(new Produto(Marca));
                produtoDAO.inserir(new Produto(dataValidade));
                produtoDAO.inserir(new Produto(lote));
                produtoDAO.inserir(new Produto(idCategoria));
            } else if (opcao == 4) {
                System.out.print("Informe o ID do Produto: ");
                int id = sc.nextInt();
                System.out.print("Informe o novo nome do Produto: ");
                String novoNome = sc.next();

               // Produto novoProduto = new Produto(id,novoNome);

              //  produtoDAO.atualizar(novoProduto);
            } else if (opcao == 5) {
                System.out.print("Informe o ID: ");
                int id = sc.nextInt();

                produtoDAO.deletar(id);
            }
        }while (opcao !=0);
    }
}
