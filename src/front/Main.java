package front;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Facade f = new Facade();
        String senha = "0000";
        boolean p1 = false;
        boolean p2 = false;
        boolean p3 = false;

        do{

            System.out.println("Bem vindo ao Bode!\n" +
                    "1. Realizar pedido como cliente\n" +
                    "2. Entrar como colaborador\n" +
                    "3. Sair");

            int o = Integer.parseInt(sc.nextLine());

            if (o == 1){

                System.out.println("Informe seu nome:");
                String nome = sc.nextLine();
                f.iniciaPedido(nome);

                do {
                    System.out.println("\nSelecione o produto pelo código:");
                    System.out.println(f.getCardapio());

                    int cod = Integer.parseInt(sc.nextLine());
                    f.adicionarItemAoPedido(f.getProduto(cod - 1));

                    System.out.println("1. Adicionar mais produtos\n2. Remover produto\n3. Finalizar pedido\n4. Cancelar pedido");
                    int o2 = Integer.parseInt(sc.nextLine());

                    if (o2 == 1) {
                        p2 = false;
                    } else if (o2 == 2) {
                        System.out.println("Selecione o produto pelo código:");
                        int codRemover = Integer.parseInt(sc.nextLine());
                        f.removeItemDoPedido(f.getProduto(codRemover - 1));
                    } else if (o2 == 3) {
                        f.finalizaMontagemPedido();
                        System.out.println("Seu pedido já está na fila de preparo! Aguarde até que esteja pronto.");
                        System.out.println("Informações do pedido:");
                        System.out.println(f.verPedidoConcluido());
                        p2 = true;
                    } else if (o2 == 4) {
                        f.cancelaPedido();
                        System.out.println("Pedido cancelado.\n");
                        p2 = true;
                    } else {
                        System.out.println("Opção inválida!\n");
                    }
                } while (!p2);

            } else if (o == 2) {
                System.out.println("Insira a senha de acesso:");
                String tentativa = sc.nextLine();

                if (tentativa.equals(senha)){
                    System.out.println("Bem vindo ao terminal colaborador\n");
                    System.out.println("Pedidos na fila:");
                    System.out.println(f.verFilaDePreparo());

                    do {
                        System.out.println("\n1. Preparar pedido\n2. Sair do terminal colaborador");
                        int o3 = Integer.parseInt(sc.nextLine());

                        if (o3 == 1) {
                            System.out.println("Insira o código do pedido a ser preparado:");
                            int cod = Integer.parseInt(sc.nextLine());
                            f.entregaPedido(cod - 1);
                        } else if (o3 == 2) {
                            p3 = true;
                        } else {
                            System.out.println("Opção inválida!\n");
                        }
                    } while (!p3);
                } else {
                    System.out.println("Senha inválida!\n");
                }

            } else if (o == 3) {
                System.out.println("Volte sempre!\nAtt. Equipe O Bode");
                p1 = true;
            } else {
                System.out.println("Opção inválida!\n");
            }

        } while (!p1);

    }
}