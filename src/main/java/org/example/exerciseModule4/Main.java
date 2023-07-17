package org.example.exerciseModule4;

import org.example.exerciseModule4.service.ItemService;
import org.example.exerciseModule4.service.RebelService;
import org.example.exerciseModule4.service.StoreService;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        RebelService rebelService = new RebelService();
        ItemService itemService = new ItemService();
        StoreService storeService = new StoreService();

        System.out.print("============================================================\n");
        System.out.print("|                                                          |\n");
        System.out.print("|        d0001000000000000000  d0000b    0000000000        |\n");
        System.out.print("|        Y0001000000000000000 d00PY00b   00000000000       |\n");
        System.out.print("|         Y000b    00000    ,00P  Y00.  000R    X00P       |\n");
        System.out.print("|          Y000b   00000    d00'  `00b  0000bood00P        |\n");
        System.out.print("|  000000000000b  00000   ,0000000000. 0000PY00000000000   |\n");
        System.out.print("|  000000000000P  00000   000P    Y000 0000  Y0000000000   |\n");
        System.out.print("|                                                          |\n");
        System.out.print("|  Y00b   d00b   d00P  d0000b    0000000000b  d0000000000  |\n");
        System.out.print("|   000b d0000b d000' d00PY00b   00000000000b Y0000000000  |\n");
        System.out.print("|   Y000V000000V000P ,00P  Y00.  000R    X00P  Y000b       |\n");
        System.out.print("|    000000PY000000' d00'  `00b  0000bood00P    Y000b      |\n");
        System.out.print("|    Y0000P  Y0000P ,0000000000. 0000PY8SSt&cgmm00000b     |\n");
        System.out.print("|     Y00P    Y00P  000P    Y000 0000  Y0000000000000P     |\n");
        System.out.print("|                                                          |\n");
        System.out.print("============================================================\n");


        int opcaoMenuPrincipal;
        do {
            System.out.println("\n============ Sistema  ============");
            System.out.println("1. Gestão de Rebelde");
            System.out.println("2. Base de compras");
            System.out.println("3. Área do Rebelde");
            System.out.println("4. Relatórios");
            System.out.println("5. Reportar Traidor");
            System.out.println("6. Sair");
            System.out.print("Digite a opção desejada: ");
            opcaoMenuPrincipal = new Scanner(System.in).nextInt();

            switch (opcaoMenuPrincipal) {
                case 1:
                    System.out.println("\n                                                ^^^^              ");
                    System.out.println("||||||||   ||||||||   ||||||||   ||||||||        ||       ||||||||");
                    System.out.println("||     |   ||         ||            ||          ||||      ||    ||");
                    System.out.println("||         ||          ||||         ||         || ||      ||    ||");
                    System.out.println("||  ||||   ||||||||      |||        ||        || - ||     ||    ||");
                    System.out.println("||    ||   ||              |||      ||       ||     ||    ||    ||");
                    System.out.println("||||||||   ||||||||   |||||||||     ||      ||       ||   ||||||||\n");

                    int opcaoMenuGestao;
                    do {

                        System.out.println("1. Listar todos Rebeldes");
                        System.out.println("2. Adicionar um Rebelde");
                        System.out.println("3. Mudar Localização Rebelde");
                        System.out.println("4. Deletar um Rebelde");
                        System.out.println("5. Sair");
                        System.out.print("Digite a opção desejada: ");
                        opcaoMenuGestao = new Scanner(System.in).nextInt();

                        switch (opcaoMenuGestao) {
                            case 1:
                                System.out.println("1. Listar todos Rebeldes");
                                rebelService.queryAllRebelData();

                                break;
                            case 2:

                                System.out.println("2. Adicionar um Rebelde");

                                rebelService.addRebel("Luke Skywalker", 28, "Masculino", "Tatooine","aliado");

                                break;
                            case 3:
                                System.out.println("3. Mudar Localização Rebelde");

                                System.out.println("| Você deseja listar os Rebeldes cadastrados? |\n 1 - Sim \n 2 - Não");
                                System.out.print("-> ");
                                int listaRebelde = new Scanner(System.in).nextInt();

                                if (listaRebelde == 1){
                                    System.out.println("\n==== Lista dos Rebeldes cadastrados ====");
                                    rebelService.queryAllRebelData();

                                    System.out.println("Digite o ID do Rebelde:");
                                    Long id = new Scanner(System.in).nextLong();
                                    rebelService.reportRebel(id);

                                    System.out.println("Digite a nova Localização:");
                                    String newLocation =  new Scanner(System.in).nextLine();

                                    rebelService.updateLocation(id, newLocation);
                                } else {
                                    System.out.println("Digite o ID do Rebelde:");
                                    Long id = new Scanner(System.in).nextLong();

                                    System.out.println("Digite a nova Localização:");
                                    String newLocation =  new Scanner(System.in).nextLine();

                                    rebelService.updateLocation(id, newLocation);
                                }

                                break;
                            case 4:
                                System.out.println("4. Deletar um Rebelde");

                                System.out.println("==== Lista dos Rebeldes cadastrados ====");
                                rebelService.queryAllRebelData();

                                System.out.println("Digite o ID do Rebelde que deseja deletar: ");
                                Long id = new Scanner(System.in).nextLong();
                                rebelService.deleteRebel(id);

                                break;
                            case 5:
                                System.out.println("Saindo do programa...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoMenuGestao != 5);
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("  Bem vindo a base de compras");
                    System.out.println("---------------------------------");

                    itemService.queryAllItemsData();

                    int opcaoMenuBaseCompras;
                    do {

                        System.out.println("1 - Ver lista de items disponível para compra");
                        System.out.println("2 - Ver lista de Rebeldes cadastrados");
                        System.out.println("3 - Realizar compra");
                        System.out.println("4 - Ver as compras realizadas");
                        System.out.println("5 - Sair");
                        opcaoMenuBaseCompras = new Scanner(System.in).nextInt();

                        switch (opcaoMenuBaseCompras) {
                            case 1:
                                System.out.println("1. Listar todos os items disponível para compra");
                                itemService.queryAllItemsData();

                                break;
                            case 2:

                                System.out.println("2. Lista de Rebeldes cadastrados");
                                rebelService.queryAllRebelData();

                                break;
                            case 3:
                                System.out.println("3 - Realizar compra");

                                System.out.println("Digite o ID do Rebelde: ");
                                int idRebel = new Scanner(System.in).nextInt();

                                System.out.println("Digite o ID do Item: ");
                                int idItem = new Scanner(System.in).nextInt();

                                System.out.println("Digite a quantidade do item: ");
                                int quantityItem = new Scanner(System.in).nextInt();

                                System.out.println("Digite o valor da venda: ");
                                double saleValue = new Scanner(System.in).nextDouble();

                                storeService.buyItems(idRebel, idItem, quantityItem, saleValue);

                                break;
                            case 4:
                                System.out.println("4 - Ver as compras realizadas");

                                storeService.listSales();
                                break;
                            case 5:
                                System.out.println("Saindo do programa...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoMenuBaseCompras != 5);

                    break;
                case 3:
                    System.out.println("3. Área do Rebelde");
                    break;
                case 4:
                    System.out.println("4. Relatórios");

                    System.out.println("Essa é a porcentagem de Rebelde");

                    System.out.println("Essa é a porcentagem de Traidores");

                    break;
                case 5:

                    System.out.println("\n                                      ´                               ");
                    System.out.println("||||||||   ||||||||        ||        ||   ||||||        ||||     ||||||||");
                    System.out.println("   ||      ||    ||       ||||       ||   ||   ||      ||   ||   ||    ||");
                    System.out.println("   ||      ||||||||      ||  ||      ||   ||     ||   ||    ||   ||||||||");
                    System.out.println("   ||      ||||         ||| | ||     ||   ||     ||   ||    ||   ||||    ");
                    System.out.println("   ||      ||  ||      ||      ||    ||   ||    ||     ||  ||    ||  ||  ");
                    System.out.println("   ||      ||    ||   ||        ||   ||   ||||||        ||||     ||    ||\n");


                    System.out.println("| Você deseja listar os Rebeldes cadastrados? |\n 1 - Sim \n 2 - Não");
                    System.out.print("-> ");
                    int listaRebelde = new Scanner(System.in).nextInt();

                    if (listaRebelde == 1){
                        System.out.println("\n==== Lista dos Rebeldes cadastrados ====");
                        rebelService.queryAllRebelData();

                        System.out.println("Reportar um traidor:");
                        Long id = new Scanner(System.in).nextLong();
                        rebelService.reportRebel(id);
                    } else {
                        System.out.println("Reportar um traidor:");
                        Long id = new Scanner(System.in).nextLong();
                        rebelService.reportRebel(id);
                    }

                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoMenuPrincipal != 6);

    }
}
