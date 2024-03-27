package view;

import model.Categoria;
import model.CategoriaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoriaMenu {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        // Objetos DAO
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        int opcao;

        do {
            //menu principal
            System.out.print("[1]Categoria\n[2]Fornecedor\n[0]Sair\n     Opcao:");
            opcao = sc.nextInt();
            //menu de categoria
            if (opcao == 1) {
                System.out.print("[1]Listar\n[2]Buscar\n[3]inserir\n[4]Atualizar\n[5]Deletar\n[0]Sair\n    Opcao:");
                opcao = sc.nextInt();
                if (opcao == 1) {
                    ArrayList<Categoria> categorias = categoriaDAO.listar();

                    System.out.println("+------------------------+");
                    System.out.printf("| %-4s | %-15s |%n", "ID", "NOME");
                    System.out.println("+------------------------+");
                    for (Categoria categoria : categorias) {
                        System.out.println(categoria.toString());
                    }
                } else if (opcao == 2) {
                    System.out.println("Infome o ID da categoria: ");
                    int id = sc.nextInt();

                    Categoria categoria = categoriaDAO.buscarUm(id);
                    System.out.println("+------------------------+");
                    System.out.printf("| %-4s | %-15s |%n", "ID", "NOME");
                    System.out.println("+------------------------+");
                    System.out.println(categoria);
                    System.out.println("+------------------------+");
                } else if (opcao == 3) {
                    System.out.println("Informe o nome da Categoria: ");
                    String nome = sc.next();
                    categoriaDAO.inserir(new Categoria(nome));
                } else if (opcao == 4) {
                    System.out.println("Informe o Id da Categoria");
                    int id = sc.nextInt();
                    System.out.print("Informe o novo nome do Produto: ");
                    String novoNome = sc.next();

                    // Categoria novaCategoria = new Categoria(id,novoNome);

                    // CategoriaDao.atualizar(novaCategoria);
                } else if (opcao == 5) {
                    System.out.print("Informe o ID: ");
                    int id = sc.nextInt();

                    categoriaDAO.deletar(id);
                }
            }
        }while (opcao != 0) ;
    }
}