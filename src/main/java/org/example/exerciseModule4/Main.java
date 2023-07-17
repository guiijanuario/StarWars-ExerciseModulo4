package org.example.exerciseModule4;

import org.example.exerciseModule4.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RebelService rebelService = new RebelService();
        ItemService itemService = new ItemService();
        StoreService storeService = new StoreService();
        ReportsService reportsService = new ReportsService();
        InventoryService inventory = new InventoryService();

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
                                System.out.println("Listar todos Rebeldes");
                                rebelService.queryAllRebelData();

                                break;
                            case 2:
                                System.out.println("----------------------");
                                System.out.println("Adicionar um Rebelde");
                                System.out.println("----------------------");

                                System.out.println("\nDigite o nome do Rebelde:");
                                String nameRebel = new Scanner(System.in).nextLine();

                                System.out.println("\nDigite a idade:");
                                int ageRebel = new Scanner(System.in).nextInt();

                                System.out.println("\nDigite o Gênero:");
                                String genderRebel = new Scanner(System.in).nextLine();

                                System.out.println("\nDigite a localização:");
                                String locationRebel = new Scanner(System.in).nextLine();

                                System.out.println("\nDigite se ele é aliado ou traidor: 1 - Aliado \n 2 - Traidor");
                                int statusLabel = new Scanner(System.in).nextInt();

                                String statusExato = "";
                                if (statusLabel == 1){
                                    statusExato = "aliado";
                                } else {
                                    statusExato = "traidor";
                                }

                                rebelService.addRebel(nameRebel, ageRebel, genderRebel, locationRebel,statusExato);
                                break;
                            case 3:
                                System.out.println("---------------------------");
                                System.out.println("Mudar Localização Rebelde");
                                System.out.println("---------------------------");

                                System.out.println("--- Você deseja listar os Rebeldes cadastrados? ---\n 1 - Sim \n 2 - Não");
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
                                System.out.println("---------------------------");
                                System.out.println("   Deletar um Rebelde");
                                System.out.println("---------------------------");

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
                    System.out.println("\n||| |||  ||||||||   ||||||||   |||||||        ||         |||||      ||||||");
                    System.out.println("||| |||  ||         ||    ||  ||             ||||       ||    |    ||    ||");
                    System.out.println("|| | ||  ||         ||||||||  ||            ||  ||      ||     |   ||    ||");
                    System.out.println("|| | ||  |||||||    ||||      ||           || || ||     ||     |   ||    ||");
                    System.out.println("||   ||  ||         ||  ||    ||          ||      ||    ||    |    ||    ||");
                    System.out.println("||   ||  |||||||    ||    ||   |||||||   ||        ||    |||||      ||||||\n");

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

                                System.out.println("----------------------------------------------------");
                                System.out.println("--- Listar todos os items disponível para compra ---");
                                System.out.println("----------------------------------------------------");
                                itemService.queryAllItemsData();

                                break;
                            case 2:
                                System.out.println("-----------------------------------");
                                System.out.println("-- Lista de Rebeldes cadastrados --");
                                System.out.println("-----------------------------------");
                                rebelService.queryAllRebelData();

                                break;
                            case 3:
                                System.out.println("-------------------------");
                                System.out.println("---- Realizar compra ----");
                                System.out.println("-------------------------");

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
                                System.out.println("---------------------------------");
                                System.out.println("--- Ver as compras realizadas ---");
                                System.out.println("---------------------------------");

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
                    System.out.println("-----------------------");
                    System.out.println("--- Área do Rebelde ---");
                    System.out.println("-----------------------");

                    System.out.printf("Digite o ID do Rebelde no qual deseja visualizar o inventário: ");
                    Long id_rebel = new Scanner(System.in).nextLong();
                    inventory.updateInventoryFromPurchases(id_rebel);

                    break;
                case 4:

                    System.out.println("\n                                                              ||                            ");
                    System.out.println("||||||||   ||||||||   ||              ||        ||||||||    ||||||    ||||||||   ||    |||||| ");
                    System.out.println("||    ||   ||         ||             ||||          ||      ||    ||   ||    ||   ||   ||    ||");
                    System.out.println("||||||||   ||         ||            ||  ||         ||      ||    ||   ||||||||   ||   ||    ||");
                    System.out.println("||||       ||||||||   ||           || || ||        ||      ||    ||   ||||       ||   ||    ||");
                    System.out.println("||  ||     ||         ||          ||      ||       ||      ||    ||   ||  ||     ||   ||    ||");
                    System.out.println("||    ||   ||||||||   ||||||||   ||        ||      ||       ||||||    ||    ||   ||    |||||| \n");

                    reportsService.reportsPorcent();

                    break;
                case 5:

                    System.out.println("\n                                     |                               ");
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
