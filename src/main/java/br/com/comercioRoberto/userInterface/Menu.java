package br.com.comercioRoberto.userInterface;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.comercioRoberto.models.Produto;

public class Menu {
    public static void menu() {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        int id = 0;

        do{
            System.out.println("Escolha a opção: ");
            System.out.println("1- Cadastrar Produto: ");
            System.out.println("2- Listar Produtos: ");

            int option = teclado.nextInt();
            if ( option == 1 ) {
                System.out.println("Quantidade de produtos: ");
                int n = teclado.nextInt();
                if ( n == 0 ) {
                    continue;
                }
    
                for ( int i = 1 ; i <= n ; i++ ) {
                    System.out.printf("Digite o nome do %d produto a cadastrar: ", i);
                    teclado.nextLine();
                    String nome = teclado.nextLine();
                    System.out.printf("Digite o valor do %d produto: ", i);
                    double preco = teclado.nextDouble();
                    System.out.printf("Digite a quantidade %d de produtos: ", i);
                    int quantidade = teclado.nextInt();
                    id++;
                    Produto produto = new Produto(id, "produto", preco, quantidade);
                    produtos.add(produto);
                }
            } else if ( option == 2 ) {
                double total = 0;
                for (Produto produto : produtos) {
                    System.out.println(produto);
                    total += produto.getPreco() * produto.getQuantidade();
                }
                System.out.println("Total: " + total);
            } else {
                System.out.println("Opção Inválida");
            }

        } while ( true );
    }
}
